module framework {
    requires transitive org.seleniumhq.selenium.support;
    requires extentreports;
    requires org.testng;
    requires transitive org.seleniumhq.selenium.chrome_driver;
    requires transitive org.seleniumhq.selenium.firefox_driver;
    requires transitive org.apache.poi.poi;
    requires transitive com.fasterxml.jackson.databind;
    requires transitive org.apache.commons.codec;
    requires transitive org.apache.commons.io;
    requires com.google.common;

    // Allows other modules to see your PageDriver class
    exports base.driver;
    exports base.utils;
    exports base.testUtils;
    exports base.pages;
}