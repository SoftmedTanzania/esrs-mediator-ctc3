package tz.go.moh.him.esrs.mediator.ctc3.orchestrator;

import akka.testkit.JavaTestKit;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.junit.After;
import org.junit.Test;
import org.openhim.mediator.engine.messages.FinishRequest;
import org.openhim.mediator.engine.testing.TestingUtils;
import tz.go.moh.him.esrs.mediator.ctc3.TestMockLauncher;
import tz.go.moh.him.esrs.mediator.ctc3.mock.MockDestination;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class RequestOrchestratorTest extends BaseTest {

    /**
     * Represents an Error Messages Definition Resource Object defined in <a href="file:../resources/error-messages.json">/resources/error-messages.json</a>.
     */
    protected JSONObject esrsErrorMessageResource;

    /**
     * Runs initialization before each class execution.
     */
    @Override
    public void before() throws Exception {
        super.before();
        InputStream stream = getClass().getClassLoader().getResourceAsStream("error-messages.json");
        try {
            if (stream != null) {
                esrsErrorMessageResource = new JSONObject(IOUtils.toString(stream));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Runs cleanup after class execution.
     */
    @After
    public void after() {
        TestingUtils.clearRootContext(system, testConfig.getName());
        JavaTestKit.shutdownActorSystem(system);
        system = null;
    }

    /**
     * Tests the mediator.
     *
     * @throws Exception if an exception occurs
     */
    @Test
    public void testSuccessfulResponseMediatorHTTPRequest() throws Exception {
        assertNotNull(testConfig);
        new JavaTestKit(system) {{
            List<TestMockLauncher.ActorToLaunch> toLaunch = new LinkedList<>();

            toLaunch.add(new TestMockLauncher.ActorToLaunch("http-connector", MockDestination.class, "sucessful_response"));
            tz.go.moh.him.esrs.mediator.ctc3.TestingUtils.launchActors(system, testConfig.getName(), toLaunch);

            InputStream stream = RequestOrchestrator.class.getClassLoader().getResourceAsStream("request.json");

            assertNotNull(stream);


            createActorAndSendRequest(system, testConfig, getRef(), IOUtils.toString(stream), RequestOrchestrator.class, "/samples");

            final Object[] out =
                    new ReceiveWhile<Object>(Object.class, duration("3 second")) {
                        @Override
                        protected Object match(Object msg) throws Exception {
                            if (msg instanceof FinishRequest) {
                                return msg;
                            }
                            return msg;
                        }
                    }.get();

            boolean foundResponse = false;
            int statusCode = 200;

            for (Object o : out) {
                if (o instanceof FinishRequest) {
                    foundResponse = true;
                    statusCode = ((FinishRequest) o).getResponseStatus();
                    break;
                }
            }
            assertNotNull(foundResponse);
            assertEquals(200, statusCode);
        }};
    }

    @Test
    public void testPartialResponseMediatorHTTPRequest() throws Exception {
        assertNotNull(testConfig);
        new JavaTestKit(system) {{
            List<TestMockLauncher.ActorToLaunch> toLaunch = new LinkedList<>();

            toLaunch.add(new TestMockLauncher.ActorToLaunch("http-connector", MockDestination.class, "partial_response"));
            tz.go.moh.him.esrs.mediator.ctc3.TestingUtils.launchActors(system, testConfig.getName(), toLaunch);

            InputStream stream = RequestOrchestrator.class.getClassLoader().getResourceAsStream("request.json");

            assertNotNull(stream);


            createActorAndSendRequest(system, testConfig, getRef(), IOUtils.toString(stream), RequestOrchestrator.class, "/samples");

            final Object[] out =
                    new ReceiveWhile<Object>(Object.class, duration("3 second")) {
                        @Override
                        protected Object match(Object msg) throws Exception {
                            if (msg instanceof FinishRequest) {
                                return msg;
                            }
                            return msg;
                        }
                    }.get();

            boolean foundResponse = false;
            int statusCode = 200;

            for (Object o : out) {
                if (o instanceof FinishRequest) {
                    foundResponse = true;
                    statusCode = ((FinishRequest) o).getResponseStatus();
                    break;
                }
            }
            assertNotNull(foundResponse);
            assertEquals(400, statusCode);
        }};
    }
    @Test
    public void testFailedResponseMediatorHTTPRequest() throws Exception {
        assertNotNull(testConfig);
        new JavaTestKit(system) {{
            List<TestMockLauncher.ActorToLaunch> toLaunch = new LinkedList<>();

            toLaunch.add(new TestMockLauncher.ActorToLaunch("http-connector", MockDestination.class, "failed_response"));
            tz.go.moh.him.esrs.mediator.ctc3.TestingUtils.launchActors(system, testConfig.getName(), toLaunch);

            InputStream stream = RequestOrchestrator.class.getClassLoader().getResourceAsStream("request.json");

            assertNotNull(stream);


            createActorAndSendRequest(system, testConfig, getRef(), IOUtils.toString(stream), RequestOrchestrator.class, "/samples");

            final Object[] out =
                    new ReceiveWhile<Object>(Object.class, duration("3 second")) {
                        @Override
                        protected Object match(Object msg) throws Exception {
                            if (msg instanceof FinishRequest) {
                                return msg;
                            }
                            return msg;
                        }
                    }.get();

            boolean foundResponse = false;
            int statusCode = 200;

            for (Object o : out) {
                if (o instanceof FinishRequest) {
                    foundResponse = true;
                    statusCode = ((FinishRequest) o).getResponseStatus();
                    break;
                }
            }
            assertNotNull(foundResponse);
            assertEquals(512, statusCode);
        }};
    }

    @Test
    public void testUndefinedResponseMediatorHTTPRequest() throws Exception {
        assertNotNull(testConfig);
        new JavaTestKit(system) {{
            List<TestMockLauncher.ActorToLaunch> toLaunch = new LinkedList<>();

            toLaunch.add(new TestMockLauncher.ActorToLaunch("http-connector", MockDestination.class, "undefined_response"));
            tz.go.moh.him.esrs.mediator.ctc3.TestingUtils.launchActors(system, testConfig.getName(), toLaunch);

            InputStream stream = RequestOrchestrator.class.getClassLoader().getResourceAsStream("request.json");

            assertNotNull(stream);


            createActorAndSendRequest(system, testConfig, getRef(), IOUtils.toString(stream), RequestOrchestrator.class, "/samples");

            final Object[] out =
                    new ReceiveWhile<Object>(Object.class, duration("3 second")) {
                        @Override
                        protected Object match(Object msg) throws Exception {
                            if (msg instanceof FinishRequest) {
                                return msg;
                            }
                            return msg;
                        }
                    }.get();

            boolean foundResponse = false;
            int statusCode = 200;

            for (Object o : out) {
                if (o instanceof FinishRequest) {
                    foundResponse = true;
                    statusCode = ((FinishRequest) o).getResponseStatus();
                    break;
                }
            }
            assertNotNull(foundResponse);
            assertEquals(400, statusCode);
        }};
    }





}
