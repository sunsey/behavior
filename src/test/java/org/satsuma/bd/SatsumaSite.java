package org.satsuma.bd;

import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;


/**
 * Created by ykarpiuk on 11/4/2015.
 */
public class SatsumaSite {

    //-Dtest=SatsumaSite -Dbrowser=org.openqa.selenium.chrome.ChromeDriver -Dwebdriver.chrome.driver=c:\satsumabd\chromedriver.exe test
    //-Dtest=SatsumaSite -Dbrowser=org.openqa.selenium.htmlunit.HtmlUnitDriver test

    @Test
    public void fillPage() {
        open("http://google.com");



    }

}

