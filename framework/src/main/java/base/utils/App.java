package base.utils;

public class App {

    public static String browser = System.getProperty("browser", "chrome");
    public static String module = System.getProperty("module", "cp");
    public static String platform = System.getProperty("platform", "local");
    public static String enableBrowserOptions = System.getProperty("enableBrowserOptions", "false");

}
