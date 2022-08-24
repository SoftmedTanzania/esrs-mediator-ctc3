package tz.go.moh.him.esrs.mediator.ctc3.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Manifest {

    @JsonProperty("manifest_batch_code")
    @SerializedName("manifest_batch_code")
    private String manifestBatchCode;

    @JsonProperty("destination_facility")
    @SerializedName("destination_facility")
    private String destinationFacility;

    @JsonProperty("specimen_code")
    @SerializedName("specimen_code")
    private String specimenCode;

    @JsonProperty("sender_name")
    @SerializedName("sender_name")
    private String senderName;

    @JsonProperty("requester_phone")
    @SerializedName("requester_phone")
    private String requesterPhone;

    @JsonProperty("sending_date")
    @SerializedName("sending_date")
    private String sendingDate;

    @JsonProperty("shipping_status")
    @SerializedName("shipping_status")
    private String shippingStatus;

    @JsonProperty("courier_company")
    @SerializedName("courier_company")
    private String courierCompany;

    @JsonProperty("source_facility")
    @SerializedName("source_facility")
    private String sourceFacility;

    @JsonProperty("request_codes")
    @SerializedName("request_codes")
    private List<String> requestCodes;

    public String getManifestBatchCode() {
        return manifestBatchCode;
    }

    public void setManifestBatchCode(String manifestBatchCode) {
        this.manifestBatchCode = manifestBatchCode;
    }

    public String getDestinationFacility() {
        return destinationFacility;
    }

    public void setDestinationFacility(String destinationFacility) {
        this.destinationFacility = destinationFacility;
    }

    public String getSpecimenCode() {
        return specimenCode;
    }

    public void setSpecimenCode(String specimenCode) {
        this.specimenCode = specimenCode;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getRequesterPhone() {
        return requesterPhone;
    }

    public void setRequesterPhone(String requesterPhone) {
        this.requesterPhone = requesterPhone;
    }

    public String getSendingDate() {
        return sendingDate;
    }

    public void setSendingDate(String sendingDate) {
        this.sendingDate = sendingDate;
    }

    public String getShippingStatus() {
        return shippingStatus;
    }

    public void setShippingStatus(String shippingStatus) {
        this.shippingStatus = shippingStatus;
    }

    public String getCourierCompany() {
        return courierCompany;
    }

    public void setCourierCompany(String courierCompany) {
        this.courierCompany = courierCompany;
    }

    public String getSourceFacility() {
        return sourceFacility;
    }

    public void setSourceFacility(String sourceFacility) {
        this.sourceFacility = sourceFacility;
    }

    public List<String> getRequestCodes() {
        return requestCodes;
    }

    public void setRequestCodes(List<String> requestCodes) {
        this.requestCodes = requestCodes;
    }

}
