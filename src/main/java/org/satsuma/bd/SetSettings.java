package org.satsuma.bd;

import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by ykarpiuk on 11/4/2015.
 */
public class SetSettings  {

    public static class CustomWebDriverProvider implements WebDriverProvider {
        @Override
        public WebDriver createDriver(DesiredCapabilities capabilities) {

            return new FirefoxDriver(capabilities);
        }
    }

}
