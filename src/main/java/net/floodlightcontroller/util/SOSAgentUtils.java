package net.floodlightcontroller.util;

/***
 * @author Khayam Anjam kanjam@g.clemson.edu
 * This class contains paths from the agent
 */
public class SOSAgentUtils {
    public static final int AGENT_REST_PORT = 8002;

    public static final String HTTP_PRESTRING = "http://";
    public static final String BASE_PATH = "/sos";
    public static final String API_VERSION = "/v1.0";
    public static final String HEALTH_PATH = "/health";
    public static final String REQUEST_PATH = "/request";

    public static String PathBuilder( String path) {
        return BASE_PATH + API_VERSION + path;
    }
    public static String addressBuilder( String IP, int port) { return IP + ":" + port; }
    public static String addressBuilder( String IP, String port) { return IP + ":" + port; }

}
