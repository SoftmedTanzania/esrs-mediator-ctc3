package tz.go.moh.him.esrs.mediator.ctc3.orchestrator;

import org.json.JSONArray;
import org.json.JSONObject;
import org.openhim.mediator.engine.MediatorConfig;
import org.openhim.mediator.engine.messages.MediatorHTTPRequest;
import org.openhim.mediator.engine.messages.MediatorHTTPResponse;
import org.openhim.mediator.engine.messages.PutPropertyInCoreResponse;

import static org.apache.http.HttpStatus.SC_BAD_REQUEST;
import static org.apache.http.HttpStatus.SC_OK;

public class RequestOrchestrator extends BaseOrchestrator {

    /**
     * Initializes a new instance of the {@link RequestOrchestrator} class.
     *
     * @param config The mediator configuration.
     */
    public RequestOrchestrator(MediatorConfig config) {
        super(config);
    }

    @Override
    public void onReceive(Object msg) {
        if (msg instanceof MediatorHTTPRequest) {
            workingRequest = (MediatorHTTPRequest) msg;

            log.info("Received request: " + workingRequest.getHost() + " " + workingRequest.getMethod() + " " + workingRequest.getPath());
            String body = ((MediatorHTTPRequest) msg).getBody();
            JSONObject payload = new JSONObject(body);
            JSONArray requests = payload.getJSONArray("requests");
            for (int i = 0; i < requests.length(); i++) {
                String requestCode = requests.getJSONObject(i).getString("request_code");
                ((MediatorHTTPRequest) msg).getRequestHandler().tell(new PutPropertyInCoreResponse("request_code", requestCode), getSelf());

            }

            String manifestBatchCode = payload.getJSONObject("manifest").getString("manifest_batch_code");
            ((MediatorHTTPRequest) msg).getRequestHandler().tell(new PutPropertyInCoreResponse("manifest_batch_code", manifestBatchCode), getSelf());

            sendDataToESRS(body);

        } else if (msg instanceof MediatorHTTPResponse) { //respond
            log.info("Received response from esrs");

            String body = ((MediatorHTTPResponse) msg).getBody();
            JSONObject payload = new JSONObject(body);
            int statusCode = payload.getInt("status_code");


            int httpResponseCode;
            switch (statusCode) {
                case 1000:
                    httpResponseCode = SC_OK;
                    break;
                case 1001:
                    httpResponseCode = SC_BAD_REQUEST;
                    break;
                case 1002:
                    httpResponseCode = 512;
                    break;
                default:
                    httpResponseCode = SC_BAD_REQUEST;
            }

            MediatorHTTPResponse response = new MediatorHTTPResponse((MediatorHTTPRequest) ((MediatorHTTPResponse) msg).getOriginalRequest(), ((MediatorHTTPResponse) msg).getBody(), httpResponseCode, ((MediatorHTTPResponse) msg).getHeaders());

            (workingRequest).getRequestHandler().tell(response.toFinishRequest(), getSelf());
        } else {
            unhandled(msg);
        }
    }
}

