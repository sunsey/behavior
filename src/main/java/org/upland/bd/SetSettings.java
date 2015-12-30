package org.upland.bd;
/**
 * Created by ykarpiuk on 11/4/2015.
 */

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SetSettings implements WebDriverProvider {


    @Override
    public WebDriver createDriver(DesiredCapabilities capabilities) {
        //FirefoxProfile profile = new FirefoxProfile(new File("/home/test/MozzillaProf/"));
        //profile.setAssumeUntrustedCertificateIssuer(false);
        //profile.addAdditionalPreference("general.useragent.override", "some UA string");
        DesiredCapabilities caps  = new DesiredCapabilities();
        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "7");
        caps.setCapability("browser", "Chrome");  //IE
        caps.setCapability("browser_version", "8.0");
        caps.setCapability("resolution", "1024x768");
        caps.setCapability("build", "Sample");
        Configuration.remote = "http://yurii16:fNrGLC3k2WYbRiuutfrZ@hub.browserstack.com/wd/hub";

        return new RemoteWebDriver(caps);

    }


}