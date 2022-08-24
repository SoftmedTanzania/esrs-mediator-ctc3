package tz.go.moh.him.esrs.mediator.ctc3.orchestrator;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import org.codehaus.plexus.util.StringUtils;
import org.openhim.mediator.engine.MediatorConfig;
import org.openhim.mediator.engine.messages.MediatorHTTPRequest;
import org.openhim.mediator.engine.messages.MediatorHTTPResponse;
import tz.go.moh.him.esrs.mediator.ctc3.utils.Constants;
import tz.go.moh.him.mediator.core.domain.ErrorMessage;
import tz.go.moh.him.mediator.core.domain.ResultDetail;
import tz.go.moh.him.mediator.core.validator.DateValidatorUtils;
import tz.go.moh.him.esrs.mediator.ctc3.domain.Request;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RequestOrchestrator extends BaseOrchestrator {

    /**
     * Initializes a new instance of the {@link RequestOrchestrator} class.
     *
     * @param config The mediator configuration.
     */
    public RequestOrchestrator(MediatorConfig config) {
        super(config);
    }

    /**
     * Validate iRIMS Request Required Fields
     *
     * @param request to be validated
     * @return array list of validation results details for failed validations
     */
    public List<ResultDetail> validateRequiredFields(Request request) {
        List<ResultDetail> resultDetailsList = new ArrayList<>();

        if (StringUtils.isBlank(request.getRequestCode()))
            resultDetailsList.add(new ResultDetail(ResultDetail.ResultsDetailsType.ERROR, String.format(errorMessageResource.getString("GENERIC_ERR"), "requestCode"), null));

        if (StringUtils.isBlank(request.getProgram()))
            resultDetailsList.add(new ResultDetail(ResultDetail.ResultsDetailsType.ERROR, String.format(errorMessageResource.getString("GENERIC_ERR"), "program"), null));

        if (StringUtils.isBlank(request.getSpecimen()))
            resultDetailsList.add(new ResultDetail(ResultDetail.ResultsDetailsType.ERROR, String.format(errorMessageResource.getString("GENERIC_ERR"), "specimen"), null));

        if (StringUtils.isBlank(request.getSpecimenRequestTime()))
            resultDetailsList.add(new ResultDetail(ResultDetail.ResultsDetailsType.ERROR, String.format(errorMessageResource.getString("GENERIC_ERR"), "specimenRequestTime"), null));

        if (StringUtils.isBlank(request.getSpecimenCollectionDate()))
            resultDetailsList.add(new ResultDetail(ResultDetail.ResultsDetailsType.ERROR, String.format(errorMessageResource.getString("GENERIC_ERR"), "specimenCollectionDate"), null));

        if (StringUtils.isBlank(request.getSpecimenSendingDate()))
            resultDetailsList.add(new ResultDetail(ResultDetail.ResultsDetailsType.ERROR, String.format(errorMessageResource.getString("GENERIC_ERR"), "specimenSendingDate"), null));

        if (StringUtils.isBlank(request.getSpecimenRequestDate()))
            resultDetailsList.add(new ResultDetail(ResultDetail.ResultsDetailsType.ERROR, String.format(errorMessageResource.getString("GENERIC_ERR"), "specimenRequestDate"), null));

        if (StringUtils.isBlank(request.getSpecimenRequesterName()))
            resultDetailsList.add(new ResultDetail(ResultDetail.ResultsDetailsType.ERROR, String.format(errorMessageResource.getString("GENERIC_ERR"), "specimenRequestName"), null));

        if (StringUtils.isBlank(request.getSpecimenCollectorName()))
            resultDetailsList.add(new ResultDetail(ResultDetail.ResultsDetailsType.ERROR, String.format(errorMessageResource.getString("GENERIC_ERR"), "specimenCollectorName"), null));

        if (StringUtils.isBlank(request.getSpecimenCollectorCadre()))
            resultDetailsList.add(new ResultDetail(ResultDetail.ResultsDetailsType.ERROR, String.format(errorMessageResource.getString("GENERIC_ERR"), "specimenCollectorCadre"), null));

        if (StringUtils.isBlank(request.getRequestStatus()))
            resultDetailsList.add(new ResultDetail(ResultDetail.ResultsDetailsType.ERROR, String.format(errorMessageResource.getString("GENERIC_ERR"), "requestStatus"), null));

        if (StringUtils.isBlank(request.getSpecimenReceivedFacility()))
            resultDetailsList.add(new ResultDetail(ResultDetail.ResultsDetailsType.ERROR, String.format(errorMessageResource.getString("GENERIC_ERR"), "specimenReceivedFacility"), null));

        if (StringUtils.isBlank(request.getRequestingFacility()))
            resultDetailsList.add(new ResultDetail(ResultDetail.ResultsDetailsType.ERROR, String.format(errorMessageResource.getString("GENERIC_ERR"), "requestingFacility"), null));

        if (StringUtils.isBlank(request.getRequestCurrentBatch()))
            resultDetailsList.add(new ResultDetail(ResultDetail.ResultsDetailsType.ERROR, String.format(errorMessageResource.getString("GENERIC_ERR"), "requestCurrentBatch"), null));

        if (StringUtils.isBlank(request.getRequestSource()))
            resultDetailsList.add(new ResultDetail(ResultDetail.ResultsDetailsType.ERROR, String.format(errorMessageResource.getString("GENERIC_ERR"), "requestSource"), null));

        if (StringUtils.isBlank(request.getSpecimenRegistrationFacility()))
            resultDetailsList.add(new ResultDetail(ResultDetail.ResultsDetailsType.ERROR, String.format(errorMessageResource.getString("GENERIC_ERR"), "specimenRegistrationFacility"), null));

        if (StringUtils.isBlank(request.getClientId()))
            resultDetailsList.add(new ResultDetail(ResultDetail.ResultsDetailsType.ERROR, String.format(errorMessageResource.getString("GENERIC_ERR"), "clientId"), null));

        if (StringUtils.isBlank(request.getClientPhone()))
            resultDetailsList.add(new ResultDetail(ResultDetail.ResultsDetailsType.ERROR, String.format(errorMessageResource.getString("GENERIC_ERR"), "clientPhone"), null));

        if (StringUtils.isBlank(request.getClientPhone()))
            resultDetailsList.add(new ResultDetail(ResultDetail.ResultsDetailsType.ERROR, String.format(errorMessageResource.getString("GENERIC_ERR"), "clientPhone"), null));

        if (StringUtils.isBlank(request.getClientBirthDate()))
            resultDetailsList.add(new ResultDetail(ResultDetail.ResultsDetailsType.ERROR, String.format(errorMessageResource.getString("GENERIC_ERR"), "clientBirthDate"), null));

        if (StringUtils.isBlank(request.getCreatedBy()))
            resultDetailsList.add(new ResultDetail(ResultDetail.ResultsDetailsType.ERROR, String.format(errorMessageResource.getString("GENERIC_ERR"), "createdBy"), null));

        if (StringUtils.isBlank(request.getClientLeader()))
            resultDetailsList.add(new ResultDetail(ResultDetail.ResultsDetailsType.ERROR, String.format(errorMessageResource.getString("GENERIC_ERR"), "clientLeader"), null));

        if (StringUtils.isBlank(request.getRegisteredDate()))
            resultDetailsList.add(new ResultDetail(ResultDetail.ResultsDetailsType.ERROR, String.format(errorMessageResource.getString("GENERIC_ERR"), "registeredDate"), null));

        if (StringUtils.isBlank(request.getWardName()))
            resultDetailsList.add(new ResultDetail(ResultDetail.ResultsDetailsType.ERROR, String.format(errorMessageResource.getString("GENERIC_ERR"), "wardName"), null));

        if (StringUtils.isBlank(request.getNursePhone()))
            resultDetailsList.add(new ResultDetail(ResultDetail.ResultsDetailsType.ERROR, String.format(errorMessageResource.getString("GENERIC_ERR"), "nursePhone"), null));

        try {
            if (!DateValidatorUtils.isValidPastDate(request.getSpecimenRequestDate(), checkDateFormatStrings(request.getSpecimenRequestDate()))) {
                resultDetailsList.add(new ResultDetail(ResultDetail.ResultsDetailsType.ERROR, String.format(errorMessageResource.getString("ERROR_DATE_IS_NOT_VALID_PAST_DATE"), "recallDate"), null));
            } else {
                SimpleDateFormat requestDateFormat = new SimpleDateFormat(checkDateFormatStrings(request.getSpecimenRequestDate()));
                request.setSpecimenRequestDate(esrsDateFormat.format(requestDateFormat.parse(request.getSpecimenRequestDate())));

            }

            if (!DateValidatorUtils.isValidPastDate(request.getClientBirthDate(), checkDateFormatStrings(request.getClientBirthDate()))) {
                resultDetailsList.add(new ResultDetail(ResultDetail.ResultsDetailsType.ERROR, String.format(errorMessageResource.getString("ERROR_DATE_IS_NOT_VALID_PAST_DATE"), "clientBirthDate"), null));
            } else {
                SimpleDateFormat requestDateFormat = new SimpleDateFormat(checkDateFormatStrings(request.getClientBirthDate()));
                request.setSpecimenRequestDate(esrsDateFormat.format(requestDateFormat.parse(request.getClientBirthDate())));

            }
        } catch (ParseException e) {
            resultDetailsList.add(new ResultDetail(ResultDetail.ResultsDetailsType.ERROR, String.format(errorMessageResource.getString("ERROR_INVALID_DATE_FORMAT"), "recallDate"), null));
        }

        log.info("results are" + resultDetailsList);
        return resultDetailsList;
    }

    protected Request validateData(Request receivedRequest) {
        Request validRequest = null;

        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setSource(new Gson().toJson(receivedRequest));

        List<ResultDetail> resultDetailsList = new ArrayList<>();

        if (receivedRequest == null) {
            resultDetailsList.add(new ResultDetail(ResultDetail.ResultsDetailsType.ERROR, errorMessageResource.getString("ERROR_INVALID_PAYLOAD"), null));
        } else {
            resultDetailsList.addAll(validateRequiredFields(receivedRequest));
        }

        //TODO implement additional data validations checks
        if (resultDetailsList.size() == 0) {
            //No errors were found during data validation
            //adding the service received to the valid payload to be sent to HDR
            validRequest = receivedRequest;
        } else {
            //Adding the validation results to the Error message object
            errorMessage.setResultsDetails(resultDetailsList);
            errorMessages.add(errorMessage);
        }

        return validRequest;
    }


    @Override
    public void onReceive(Object msg) {
        if (msg instanceof MediatorHTTPRequest) {
            workingRequest = (MediatorHTTPRequest) msg;

            log.info("Received request: " + workingRequest.getHost() + " " + workingRequest.getMethod() + " " + workingRequest.getPath());

            //Converting the received request body to POJO List
            Request request;
            try {
                request = convertMessageBodyToPojoList(((MediatorHTTPRequest) msg).getBody());
                log.info("Received payload in JSON = " + new Gson().toJson(request));

                Request validatedRequest;
                if (validateRequiredFields(request).size() > 0) {
                    ErrorMessage errorMessage = new ErrorMessage(
                            workingRequest.getBody(),
                            Arrays.asList(
                                    new ResultDetail(ResultDetail.ResultsDetailsType.ERROR, errorMessageResource.getString("ERROR_INVALID_PAYLOAD"), null)
                            )
                    );
                    errorMessages.add(errorMessage);
                    validatedRequest = null;
                } else {
                    validatedRequest = validateData(request);
                }

                sendDataToESRS(new Gson().toJson(validatedRequest), Constants.REQUEST);

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

    protected Request convertMessageBodyToPojoList(String msg) throws JsonSyntaxException {
        return new Gson().fromJson(msg, Request.class);
    }


}

