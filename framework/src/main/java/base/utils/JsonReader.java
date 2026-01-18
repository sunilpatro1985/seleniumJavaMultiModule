package base.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class JsonReader {
    private static JsonNode rootNode;

    // Gets the root path of the project dynamically
    private static final String PROJECT_PATH = System.getProperty("projectRoot");
    private static final String JSON_PATH = PROJECT_PATH + File.separator + "urls.json";

    public static String getUrlByModule(String moduleName) {

        ObjectMapper mapper = new ObjectMapper();
        try {
            // Path relative to your project root
            System.out.println(JSON_PATH);
            JsonNode rootNode = mapper.readTree(new File(JSON_PATH));

            // Navigate to moduleUrls -> moduleName
            JsonNode urlNode = rootNode.path("moduleUrls").path(moduleName);

            if (urlNode.isMissingNode()) {
                throw new RuntimeException("Module URL not found in JSON for: " + moduleName);
            }
            return urlNode.asText();

        } catch (IOException e) {
            throw new RuntimeException("Failed to read urls.json file", e);
        }
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