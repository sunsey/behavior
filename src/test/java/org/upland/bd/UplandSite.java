package org.upland.bd;

import org.junit.Before;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;


/**
 * Created by ykarpiuk on 11/4/2015.
 */
public class UplandSite {

    //-Dtest=UplandSite -Dbrowser=org.openqa.selenium.chrome.ChromeDriver -Dwebdriver.chrome.driver=c:\satsumabd\chromedriver.exe test
    //-Dtest=UplandSite -Dbrowser=org.openqa.selenium.htmlunit.HtmlUnitDriver test
    //-Dtest=UplandSite -Dbrowser=htmlunit test
    //-Dtest=UplandSite -Dbrowser=SetSettings.CustomWebDriverProvider test

    LoginPageHTML loginPageHTML = open("https://upland-logic-development.herokuapp.com/users/sign_in", LoginPageHTML.class);

    @Before
    public void setUp() throws Exception {


    }



        @Test
    public void successLogin() {
            open("/login");

        //loginPageHTML.provideCorrectUsernameInCorrectPassword();



        //getWebDriver().findElement(By.id("username");
       // Assert.assertTrue(loginPageHTML.isLoginCorrect());
    }



//    @Test
//    public void notsuccessLogin() {
//        loginPageHTML.FillUsername("y.karpiuk@svitla.com");
//        loginPageHTML.FillPassword("UplandSvitla02");
//        loginPageHTML.clickSignIn1Button();
//
//    }


}

