package tz.go.moh.him.esrs.mediator.ctc3.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

public class Request {

    @JsonProperty("request_code")
    @SerializedName("request_code")
    private String requestCode;

    @JsonProperty("program")
    @SerializedName("program")
    private String program;

    @JsonProperty("specimen")
    @SerializedName("specimen")
    private String specimen;

    @JsonProperty("specimen_request_time")
    @SerializedName("specimen_request_time")
    private String specimenRequestTime;

    @JsonProperty("specimen_request_date")
    @SerializedName("specimen_request_date")
    private String specimenRequestDate;

    @JsonProperty("specimen_collection_date")
    @SerializedName("specimen_collection_date")
    private String specimenCollectionDate;

    @JsonProperty("specimen_requester_name")
    @SerializedName("specimen_requester_name")
    private String specimenRequesterName;

    @JsonProperty("specimen_collection_time")
    @SerializedName("specimen_collection_time")
    private String specimenCollectionTime;

    @JsonProperty("specimen_sending_date")
    @SerializedName("specimen_sending_date")
    private String specimenSendingDate;

    @JsonProperty("specimen_sending_time")
    @SerializedName("specimen_sending_time")
    private String specimenSendingTime;

    @JsonProperty("specimen_collector_name")
    @SerializedName("specimen_collector_name")
    private String specimenCollectorName;

    @JsonProperty("specimen_collector_cadre")
    @SerializedName("specimen_collector_cadre")
    private String specimenCollectorCadre;

    @JsonProperty("request_status")
    @SerializedName("request_status")
    private String requestStatus;

    @JsonProperty("specimen_received_facility")
    @SerializedName("specimen_received_facility")
    private String specimenReceivedFacility;

    @JsonProperty("requesting_facility")
    @SerializedName("requesting_facility")
    private String requestingFacility;

    @JsonProperty("request_current_batch")
    @SerializedName("request_current_batch")
    private String requestCurrentBatch;

    @JsonProperty("request_source")
    @SerializedName("request_source")
    private String requestSource;

    @JsonProperty("specimen_registration_facility")
    @SerializedName("specimen_registration_facility")
    private String specimenRegistrationFacility;

    @JsonProperty("client_id")
    @SerializedName("client_id")
    private String clientId;

    @JsonProperty("client_phone")
    @SerializedName("client_phone")
    private String clientPhone;

    @JsonProperty("client_birth_date")
    @SerializedName("client_birth_date")
    private String clientBirthDate;

    @JsonProperty("client_gender")
    @SerializedName("client_gender")
    private String clientGender;

    @JsonProperty("created_by")
    @SerializedName("created_by")
    private String createdBy;

    @JsonProperty("client_leader")
    @SerializedName("client_leader")
    private String clientLeader;

    @JsonProperty("registered_date")
    @SerializedName("registered_date")
    private String registeredDate;

    @JsonProperty("ward_name")
    @SerializedName("ward_name")
    private String wardName;

    @JsonProperty("nurse_phone")
    @SerializedName("nurse_phone")
    private String nursePhone;

    public String getRequestCode() {
        return requestCode;
    }

    public void setRequestCode(String requestCode) {
        this.requestCode = requestCode;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getSpecimen() {
        return specimen;
    }

    public void setSpecimen(String specimen) {
        this.specimen = specimen;
    }

    public String getSpecimenRequestTime() {
        return specimenRequestTime;
    }

    public void setSpecimenRequestTime(String specimenRequestTime) {
        this.specimenRequestTime = specimenRequestTime;
    }

    public String getSpecimenRequestDate() {
        return specimenRequestDate;
    }

    public void setSpecimenRequestDate(String specimenRequestDate) {
        this.specimenRequestDate = specimenRequestDate;
    }

    public String getSpecimenCollectionDate() {
        return specimenCollectionDate;
    }

    public void setSpecimenCollectionDate(String specimenCollectionDate) {
        this.specimenCollectionDate = specimenCollectionDate;
    }

    public String getSpecimenRequesterName() {
        return specimenRequesterName;
    }

    public void setSpecimenRequesterName(String specimenRequesterName) {
        this.specimenRequesterName = specimenRequesterName;
    }

    public String getSpecimenCollectionTime() {
        return specimenCollectionTime;
    }

    public void setSpecimenCollectionTime(String specimenCollectionTime) {
        this.specimenCollectionTime = specimenCollectionTime;
    }

    public String getSpecimenSendingDate() {
        return specimenSendingDate;
    }

    public void setSpecimenSendingDate(String specimenSendingDate) {
        this.specimenSendingDate = specimenSendingDate;
    }

    public String getSpecimenSendingTime() {
        return specimenSendingTime;
    }

    public void setSpecimenSendingTime(String specimenSendingTime) {
        this.specimenSendingTime = specimenSendingTime;
    }

    public String getSpecimenCollectorName() {
        return specimenCollectorName;
    }

    public void setSpecimenCollectorName(String specimenCollectorName) {
        this.specimenCollectorName = specimenCollectorName;
    }

    public String getSpecimenCollectorCadre() {
        return specimenCollectorCadre;
    }

    public void setSpecimenCollectorCadre(String specimenCollectorCadre) {
        this.specimenCollectorCadre = specimenCollectorCadre;
    }

    public String getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(String requestStatus) {
        this.requestStatus = requestStatus;
    }

    public String getSpecimenReceivedFacility() {
        return specimenReceivedFacility;
    }

    public void setSpecimenReceivedFacility(String specimenReceivedFacility) {
        this.specimenReceivedFacility = specimenReceivedFacility;
    }

    public String getRequestingFacility() {
        return requestingFacility;
    }

    public void setRequestingFacility(String requestingFacility) {
        this.requestingFacility = requestingFacility;
    }

    public String getRequestCurrentBatch() {
        return requestCurrentBatch;
    }

    public void setRequestCurrentBatch(String requestCurrentBatch) {
        this.requestCurrentBatch = requestCurrentBatch;
    }

    public String getRequestSource() {
        return requestSource;
    }

    public void setRequestSource(String requestSource) {
        this.requestSource = requestSource;
    }

    public String getSpecimenRegistrationFacility() {
        return specimenRegistrationFacility;
    }

    public void setSpecimenRegistrationFacility(String specimenRegistrationFacility) {
        this.specimenRegistrationFacility = specimenRegistrationFacility;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientPhone() {
        return clientPhone;
    }

    public void setClientPhone(String clientPhone) {
        this.clientPhone = clientPhone;
    }

    public String getClientBirthDate() {
        return clientBirthDate;
    }

    public void setClientBirthDate(String clientBirthDate) {
        this.clientBirthDate = clientBirthDate;
    }

    public String getClientGender() {
        return clientGender;
    }

    public void setClientGender(String clientGender) {
        this.clientGender = clientGender;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getClientLeader() {
        return clientLeader;
    }

    public void setClientLeader(String clientLeader) {
        this.clientLeader = clientLeader;
    }

    public String getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(String registeredDate) {
        this.registeredDate = registeredDate;
    }

    public String getWardName() {
        return wardName;
    }

    public void setWardName(String wardName) {
        this.wardName = wardName;
    }

    public String getNursePhone() {
        return nursePhone;
    }

    public void setNursePhone(String nursePhone) {
        this.nursePhone = nursePhone;
    }
}
