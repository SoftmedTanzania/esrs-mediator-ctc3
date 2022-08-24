package tz.go.moh.him.esrs.mediator.ctc3.domain;

import com.google.gson.Gson;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ManifestTest {

    @Test
    public void testESRSAck() throws Exception {
        String jsonManifestPayload = "{\"manifest_batch_code\":\"B09-01000012\",\"destination_facility\":\"100920-01\"," +
                "\"specimen_code\":\"PLASMA\",\"sender_name\":\"HUSSEN\",\"requester_phone\":\"028832902\"," +
                "\"sending_date\":\"2022-08-01 10:10:00\", \"shipping_status\":\"0\",\"courier_company\":\"POSTA/NONE\" ," +
                "\"source_facility\":\"1000-14\", \"request_codes\":[\n" +
                "     \"B9-2022010001\",\n" +
                "     \"B9-2022010002\",\n" +
                "     \"B9-2022010003\",\n" +
                "     \"B9-2022010004\"\n" +
                "   ]\n}";
        Manifest manifest = new Gson().fromJson(jsonManifestPayload, Manifest.class);

        assertEquals("B09-01000012", manifest.getManifestBatchCode());
        assertEquals("100920-01", manifest.getDestinationFacility());
        assertEquals("PLASMA", manifest.getSpecimenCode());
        assertEquals("HUSSEN", manifest.getSenderName());
        assertEquals("028832902", manifest.getRequesterPhone());
        assertEquals("2022-08-01 10:10:00", manifest.getSendingDate());
        assertEquals("0", manifest.getShippingStatus());
        assertEquals("POSTA/NONE", manifest.getCourierCompany());
        assertEquals("1000-14", manifest.getSourceFacility());
    }
}
