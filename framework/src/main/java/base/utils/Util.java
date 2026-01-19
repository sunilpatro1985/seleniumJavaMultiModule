package base.utils;

import base.driver.PageDriver;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Util {

    //applicable for all browser, but takes screnshot only the visible portion of the browser
    public static String getScreenshot(String imagename) throws IOException, IOException {
        TakesScreenshot ts = (TakesScreenshot) PageDriver.getCurrentDriver();
        File f = ts.getScreenshotAs(OutputType.FILE);
        String filePath = "./screenshot/"+imagename;
        FileUtils.copyFile(f, new File(filePath));
        return filePath;
    }

    public static String convertImg_Base64(String screenshotPath) throws IOException {
           /*File f = new File(screenshotPath);
            FileInputStream fis = new FileInputStream(f);
            byte[] bytes = new byte[(int)f.length()];
            fis.read(bytes);
            String base64Img =
                    new String(Base64.encodeBase64(bytes), StandardCharsets.UTF_8);
            */

        byte[] file = FileUtils.readFileToByteArray(new File(screenshotPath));
        String base64Img = Base64.encodeBase64String(file);
        return  base64Img;
    }

    public static void writeUrlsToCsv(List<String> items, String filePath) {
        try (
                BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            // Optional: Write a Header
            writer.write("Hyperlink");
            writer.newLine();

            // Write each URL to a new line
            for (String item : items) {
                writer.write(item);
                writer.newLine();
            }
            System.out.println("CSV file successfully created at: " + filePath);
        } catch (IOException e) {
            System.err.println("Error writing to CSV: " + e.getMessage());
        }
    }
}
