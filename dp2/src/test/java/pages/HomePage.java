package pages;

import base.driver.PageDriver;
import base.pages.BasePage;
import base.utils.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.stream.Collectors;

public class HomePage extends BasePage {

    // 2. Define File Path (Storing it in the 'reports' or 'target' folder)
            String csvPath = System.getProperty("user.dir") + "/HyperLinks.csv";

            By footer = By.xpath("//footer[@data-testid='footer']");
            By ignoreBtn = By.id("onetrust-close-btn-container");

            public void scrollTillEnd() throws InterruptedException {
                waitForPageLoad();
                click(ignoreBtn);
                Thread.sleep(5000);
                scrollToElement(footer);
            }

            public List<String> getAllFooterLinks(){
                List<WebElement> links = getEls(footer).get(0).findElements(By.tagName("a"));
                List<String> allUrls = getListItemsWithAttribute(links, "href");
                System.out.println("--- Total Footer Links Found: " + allUrls.size() + " ---");
                return allUrls;
            }

            public void verifyFooterLinks(){

                List<String> allUrls = getAllFooterLinks();

                // 5. Detect and Report Duplicates
                Set<String> uniqueUrls = new HashSet<>();

                Set<String> duplicateUrls = allUrls.stream()
                        .filter(url -> !uniqueUrls.add(url))
                        .collect(Collectors.toSet());

                System.out.println("\n--- Duplicate Report ---");
                if (duplicateUrls.isEmpty()) {
                    System.out.println("No duplicate hyperlinks found in the footer.");
                } else {
                    System.out.println("Warning: Found " + duplicateUrls.size() + " duplicate links:");
                    duplicateUrls.forEach(url -> System.out.println("Duplicate: " + url));
                }


            }

    public void exportFooterLinksToCsv() {
        List<String> allUrls = getAllFooterLinks();

        //Call the Framework Utility
        Util.writeUrlsToCsv(allUrls, csvPath);
    }






}
