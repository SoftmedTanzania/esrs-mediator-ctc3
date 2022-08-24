package tz.go.moh.him.esrs.mediator.ctc3.orchestrator;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import org.codehaus.plexus.util.StringUtils;
import org.openhim.mediator.engine.MediatorConfig;
import org.openhim.mediator.engine.messages.MediatorHTTPRequest;
import org.openhim.mediator.engine.messages.MediatorHTTPResponse;
import tz.go.moh.him.esrs.mediator.ctc3.domain.Request;
import tz.go.moh.him.mediator.core.domain.ErrorMessage;
import tz.go.moh.him.mediator.core.domain.ResultDetail;
import tz.go.moh.him.mediator.core.validator.DateValidatorUtils;
import tz.go.moh.him.esrs.mediator.ctc3.domain.Manifest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ManifestOrchestrator extends BaseOrchestrator {

    /**
     * Initializes a new instance of the {@link RequestOrchestrator} class.
     *
     * @param config The mediator configuration.
     */
    public ManifestOrchestrator(MediatorConfig config) {
        super(config);
    }

    /**
     * Handles data validations
     *
     * @param receivedList The object to be validated
     */

    /**
     * Validate iRIMS Request Required Fields
     *
     * @param manifest to be validated
     * @return array list of validation results details for failed validations
     */
    public List<ResultDetail> validateRequiredFields(Manifest manifest) {
        List<ResultDetail> resultDetailsList = new ArrayList<>();

        if (StringUtils.isBlank(manifest.getManifestBatchCode()))
            resultDetailsList.add(new ResultDetail(ResultDetail.ResultsDetailsType.ERROR, String.format(errorMessageResource.getString("GENERIC_ERR"), "manifestBatchCode"), null));

        if (StringUtils.isBlank(manifest.getDestinationFacility()))
            resultDetailsList.add(new ResultDetail(ResultDetail.ResultsDetailsType.ERROR, String.format(errorMessageResource.getString("GENERIC_ERR"), "destinationFacility"), null));

        if (StringUtils.isBlank(manifest.getSpecimenCode()))
            resultDetailsList.add(new ResultDetail(ResultDetail.ResultsDetailsType.ERROR, String.format(errorMessageResource.getString("GENERIC_ERR"), "specimenCode"), null));

        if (StringUtils.isBlank(manifest.getSenderName()))
            resultDetailsList.add(new ResultDetail(ResultDetail.ResultsDetailsType.ERROR, String.format(errorMessageResource.getString("GENERIC_ERR"), "senderName"), null));

        if (StringUtils.isBlank(manifest.getRequesterPhone()))
            resultDetailsList.add(new ResultDetail(ResultDetail.ResultsDetailsType.ERROR, String.format(errorMessageResource.getString("GENERIC_ERR"), "requesterPhone"), null));

        if (StringUtils.isBlank(manifest.getSendingDate()))
            resultDetailsList.add(new ResultDetail(ResultDetail.ResultsDetailsType.ERROR, String.format(errorMessageResource.getString("GENERIC_ERR"), "sendingDate"), null));

        if (StringUtils.isBlank(manifest.getShippingStatus()))
            resultDetailsList.add(new ResultDetail(ResultDetail.ResultsDetailsType.ERROR, String.format(errorMessageResource.getString("GENERIC_ERR"), "shippingStatus"), null));

        if (StringUtils.isBlank(manifest.getCourierCompany()))
            resultDetailsList.add(new ResultDetail(ResultDetail.ResultsDetailsType.ERROR, String.format(errorMessageResource.getString("GENERIC_ERR"), "courierCompany"), null));

        if (StringUtils.isBlank(manifest.getSourceFacility()))
            resultDetailsList.add(new ResultDetail(ResultDetail.ResultsDetailsType.ERROR, String.format(errorMessageResource.getString("GENERIC_ERR"), "sourceFacility"), null));

//        if (manifest.getRequestCodes().size() == 0)
//            resultDetailsList.add(new ResultDetail(ResultDetail.ResultsDetailsType.ERROR, String.format(errorMessageResource.getString("GENERIC_ERR"),"requestCodes"), null));

        try {
            if (!DateValidatorUtils.isValidPastDate(manifest.getSendingDate(), checkDateFormatStrings(manifest.getSendingDate()))) {
                resultDetailsList.add(new ResultDetail(ResultDetail.ResultsDetailsType.ERROR, String.format(errorMessageResource.getString("ERROR_DATE_IS_NOT_VALID_PAST_DATE"), "sendingDate"), null));
            } else {
                SimpleDateFormat requestDateFormat = new SimpleDateFormat(checkDateFormatStrings(manifest.getSendingDate()));
                manifest.setSendingDate(esrsDateFormat.format(requestDateFormat.parse(manifest.getSendingDate())));

            }

        } catch (ParseException e) {
            resultDetailsList.add(new ResultDetail(ResultDetail.ResultsDetailsType.ERROR, String.format(errorMessageResource.getString("ERROR_INVALID_DATE_FORMAT"), "recallDate"), null));
        }

        log.info("results are" + resultDetailsList);
        return resultDetailsList;
    }

    protected Manifest validateData(Manifest receivedManifest) {
        Manifest validManifest = null;
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setSource(new Gson().toJson(receivedManifest));

        List<ResultDetail> resultDetailsList = new ArrayList<>();

        if (receivedManifest == null) {
            resultDetailsList.add(new ResultDetail(ResultDetail.ResultsDetailsType.ERROR, errorMessageResource.getString("ERROR_INVALID_PAYLOAD"), null));
        } else {
            resultDetailsList.addAll(validateRequiredFields(receivedManifest));
        }

        //TODO implement additional data validations checks
        if (resultDetailsList.size() == 0) {
            //No errors were found during data validation
            //adding the service received to the valid payload to be sent to HDR
            validManifest = receivedManifest;
        } else {
            //Adding the validation results to the Error message object
            errorMessage.setResultsDetails(resultDetailsList);
            errorMessages.add(errorMessage);
        }

        return validManifest;
    }

    @Override
    public void onReceive(Object msg) {
        if (msg instanceof MediatorHTTPRequest) {
            workingRequest = (MediatorHTTPRequest) msg;

            log.info("Received request: " + workingRequest.getHost() + " " + workingRequest.getMethod() + " " + workingRequest.getPath());
            //Converting the received request body to POJO List
            Manifest manifest = null;
            try {
                manifest = convertMessageBodyToPojoList(((MediatorHTTPRequest) msg).getBody());
                log.info("Received payload in JSON = " + new Gson().toJson(manifest));

                Manifest validatedManifest;

                if (validateRequiredFields(manifest).size() > 0) {
                    ErrorMessage errorMessage = new ErrorMessage(
                            workingRequest.getBody(),
                            Arrays.asList(
                                    new ResultDetail(ResultDetail.ResultsDetailsType.ERROR, errorMessageResource.getString("ERROR_INVALID_PAYLOAD"), null)
                            )
                    );
                    errorMessages.add(errorMessage);
                    validatedManifest = null;
                } else {

                    validatedManifest = validateData(manifest);
                }

                sendDataToESRS(new Gson().toJson(validatedManifest));

            } catch (Exception e) {
                //In-case of an exception creating an error message with the stack trace
                ErrorMessage errorMessage = new ErrorMessage(
                        workingRequest.getBody(),
                        Arrays.asList(new ResultDetail(ResultDetail.ResultsDetailsType.ERROR, e.getMessage(), tz.go.moh.him.mediator.core.utils.StringUtils.writeStackTraceToString(e)))
                );
                errorMessages.add(errorMessage);
            }

        } else if (msg instanceof MediatorHTTPResponse) { //respond
            log.info("Received response from esrs");
            (workingRequest).getRequestHandler().tell(((MediatorHTTPResponse) msg).toFinishRequest(), getSelf());
        } else {
            unhandled(msg);
        }
    }

    protected Manifest convertMessageBodyToPojoList(String msg) throws JsonSyntaxException {
        return new Gson().fromJson(msg, Manifest.class);
    }
}
