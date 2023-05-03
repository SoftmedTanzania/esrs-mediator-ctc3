package tz.go.moh.him.esrs.mediator.ctc3.mock;


import org.apache.commons.io.IOUtils;
import org.openhim.mediator.engine.messages.MediatorHTTPRequest;
import org.openhim.mediator.engine.testing.MockHTTPConnector;
import tz.go.moh.him.mediator.core.serialization.JsonSerializer;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;


/**
 * Represents a mock destination.
 */
public class MockDestination extends MockHTTPConnector {
    /**
     * The expected message type
     */
    private final String expectedMessageType;
    /**
     * serializer initialization
     */
    public JsonSerializer serializer = new JsonSerializer();


    public MockDestination(String expectedMessageType) {
        this.expectedMessageType = expectedMessageType;
    }

    /**
     * Gets the response.
     *
     * @return Returns the response.
     */
    @Override
    public String getResponse() {
        if (expectedMessageType.equals("sucessful_response")) {
            try {
                return IOUtils.toString(MockDestination.class.getClassLoader().getResourceAsStream("successful_sample_response.json"));
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        } else if (expectedMessageType.equals("partial_response")) {
            try {
                return IOUtils.toString(MockDestination.class.getClassLoader().getResourceAsStream("partial_sample_response.json"));
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        } else if (expectedMessageType.equals("failed_response")) {
            try {
                return IOUtils.toString(MockDestination.class.getClassLoader().getResourceAsStream("failed_sample_response.json"));
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        } else {
            try {
                return IOUtils.toString(MockDestination.class.getClassLoader().getResourceAsStream("undefined_sample_response.json"));
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    /**
     * Gets the status code.
     *
     * @return Returns the status code.
     */
    @Override
    public Integer getStatus() {
        return 200;
    }

    /**
     * Gets the HTTP headers.
     *
     * @return Returns the HTTP headers.
     */
    @Override
    public Map<String, String> getHeaders() {
        return Collections.emptyMap();
    }

    /**
     * Handles the message.
     *
     * @param msg The message.
     */
    @Override
    public void executeOnReceive(MediatorHTTPRequest msg) {
        System.out.println("Received body : " + msg.getBody());
    }
}