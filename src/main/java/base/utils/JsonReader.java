package base.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class JsonReader {
    private static JsonNode rootNode;

    // Gets the root path of the project dynamically
    private static final String PROJECT_PATH = System.getProperty("user.dir");
    private static final String JSON_PATH = PROJECT_PATH + File.separator + "urls.json";

    static {
        try {
            ObjectMapper mapper = new ObjectMapper();
            rootNode = mapper.readTree(new File(JSON_PATH));
        } catch (IOException e) {
            throw new RuntimeException("Failed to load urls.json", e);
        }
    }

    /**
     * Retrieves credentials for a specific environment.
     * @param env "dev", "test", or "prod"
     * @param key "url", "username", or "password"
     * @return The configuration value
     */
    public static String get(String env, String key) {
        JsonNode envNode = rootNode.path("environments").path(env);
        if (envNode.isMissingNode()) {
            throw new IllegalArgumentException("Environment not found: " + env);
        }
        return envNode.path(key).asText();
    }


}

/*class Main {
    public static void main(String[] args) {
        // You could get this from System.getProperty("env")
        String currentEnv = "test";

        String url = JsonReader.get(currentEnv, "url");
        String user = JsonReader.get(currentEnv, "username");

        System.out.println("Connecting to: " + url);
        System.out.println("Logging in as: " + user);
    }
}*/

//usage - String user = ConfigReader.get(currentEnv, "username");