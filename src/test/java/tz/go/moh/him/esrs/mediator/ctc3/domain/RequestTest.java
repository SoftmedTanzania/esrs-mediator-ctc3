package tz.go.moh.him.esrs.mediator.ctc3.domain;

import com.google.gson.Gson;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RequestTest {
    @Test
    public void testESRSAck() throws Exception {
        String jsonRequestPayload = "{\n" +
                "   \"request_code\": \"B09-B0900001\",\n" +
                "   \"program\": \"EID\",\n" +
                "   \"specimen\": \"DBS\",\n" +
                "   \"specimen_request_time\": \"08:31\",\n" +
                "   \"specimen_request_date\": \"2022-02-10\",\n" +
                "   \"specimen_collection_date\": \"2022-02-10\",\n" +
                "   \"specimen_requester_name\": \"Hamza\",\n" +
                "   \"specimen_collection_time\": \"08:41\",\n" +
                "   \"specimen_sending_date\": \"2022-02-09\",\n" +
                "   \"specimen_sending_time\": \"08:41\",\n" +
                "   \"specimen_collector_name\": \"RaphaK\",\n" +
                "   \"specimen_collector_cadre\": \"Data Clerk\",\n" +
                "   \"dispatcher_name\": \"RaphaK\",\n" +
                "   \"comment_for_requesting_test\": \"Test\",\n" +
                "   \"date_specimen_received\": \"2022-02-10\",\n" +
                "   \"request_status\": 0,\n" +
                "   \"specimen_received_facility\": \"100438-1\",\n" +
                "   \"requesting_facility\": \"107039-0\",\n" +
                "   \"request_current_batch\": \"B922-06000001\",\n" +
                "   \"lab_comment\": \"Test\",\n" +
                "   \"lab_number\": \"12009\",\n" +
                "   \"clinician_metadata\": \"{}\",\n" +
                "   \"request_source\": \"CTC\",\n" +
                "   \"request_remark\": \"\",\n" +
                "   \"specimen_registration_facility\": \"107806-2\",\n" +
                "   \"client_id\": \"10-01-0100-010010-c01\",\n" +
                "   \"client_parent_id\": \"\",\n" +
                "   \"client_phone\": \"0766123123\",\n" +
                "   \"client_birth_date\": \"1988-02-03\",\n" +
                "   \"client_gender\": \"Male\",\n" +
                "   \"created_by\": \"Hussen\",\n" +
                "   \"client_leader\": \"Musa\",\n" +
                "   \"registered_date\": \"2022-08-01 13:00:01\",\n" +
                "   \"ward_name\": \"Ilala\",\n" +
                "   \"nurse_phone\": \"0239032890\"\n" +
                " }\n";
        Request request = new Gson().fromJson(jsonRequestPayload, Request.class);

        assertEquals("B09-B0900001", request.getRequestCode());
        assertEquals("EID", request.getProgram());
        assertEquals("DBS", request.getSpecimen());
        assertEquals("08:31", request.getSpecimenRequestTime());
        assertEquals("2022-02-10", request.getSpecimenRequestDate());
        assertEquals("2022-02-10", request.getSpecimenCollectionDate());
        assertEquals("Hamza", request.getSpecimenRequesterName());
        assertEquals("08:41", request.getSpecimenCollectionTime());
        assertEquals("2022-02-09", request.getSpecimenSendingDate());
        assertEquals("08:41", request.getSpecimenSendingTime());
        assertEquals("RaphaK", request.getSpecimenCollectorName());
        assertEquals("Data Clerk", request.getSpecimenCollectorCadre());
        assertEquals("0", request.getRequestStatus());
        assertEquals("100438-1", request.getSpecimenReceivedFacility());
        assertEquals("107039-0", request.getRequestingFacility());
        assertEquals("B922-06000001", request.getRequestCurrentBatch());
        assertEquals("CTC", request.getRequestSource());
        assertEquals("107806-2", request.getSpecimenRegistrationFacility());
        assertEquals("10-01-0100-010010-c01", request.getClientId());
        assertEquals("0766123123", request.getClientPhone());
        assertEquals("1988-02-03", request.getClientBirthDate());
        assertEquals("Male", request.getClientGender());
        assertEquals("Hussen", request.getCreatedBy());
        assertEquals("Musa", request.getClientLeader());
        assertEquals("2022-08-01 13:00:01", request.getRegisteredDate());
        assertEquals("Ilala", request.getWardName());
        assertEquals("0239032890", request.getNursePhone());
    }
}
