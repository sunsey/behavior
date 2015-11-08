package org.satsuma.bd;

import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;




/**
 * Created by ykarpiuk on 11/4/2015.
 */
public class SatsumaSite {

    //-Dtest=SatsumaSite -Dbrowser=org.openqa.selenium.chrome.ChromeDriver -Dwebdriver.chrome.driver=c:\satsumabd\chromedriver.exe test

    //-Dtest=SatsumaSite -Dbrowser=org.openqa.selenium.htmlunit.HtmlUnitDriver test
    // -Dtest=SatsumaSite -Dbrowser=htmlunit test
    //-Dtest=SatsumaSite -Dbrowser=org.satsuma.bd.SetSettings.CustomWebDriverProvider test




    LoginPageHTML loginPageHTML = open("https://upland-logic-development.herokuapp.com/users/sign_in", LoginPageHTML.class);

    @Test
    public void successLogin() {
        loginPageHTML.provideCorrectUsernameInCorrectPassword();
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

