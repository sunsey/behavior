package org.upland.bd;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;


/**
 * Created by ykarpiuk on 11/4/2015.
 */
public class LoginPageHTML {

    private final java.lang.String correctLogin = "y.karpiuk@svitla.com";
    private final java.lang.String incorrectLogin = "y.karpiuk@svitla2.com";

    private final java.lang.String correctPassword = "UplandSvitla01";
    private final java.lang.String incorrectPassword = "UplandSvitla02";

    private final java.lang.String messageCorrectLogin = "Signed in successfully.";


    public LoginPageHTML clickContactUsLink() {
        //$(byText("Customer profile")
        $(By.linkText("Contact Us")).click();
        return this;
    }


    public LoginPageHTML clickForgotYourPasswordLink() {
        $("#new_user").click();
        return this;
    }

    public LoginPageHTML clickHelpLink() {
        $("#help").click();
        return this;
    }

    public LoginPageHTML clickSignIn1Button() {
        $(By.name("button")).click();
        return this;
    }

    public LoginPageHTML FillUsername(java.lang.String text) {
        $("#user_email").setValue(text);
        return this;
    }

    public LoginPageHTML FillPassword(java.lang.String text) {
        $("#user_password").setValue(text);
        return this;
    }

    private String getAlertMessage(){
        return $(By.xpath("//*[@id=\"container\"]/div/text())")).toString();

    }

    public boolean isLoginCorrect() {

        return this.getAlertMessage().equals(messageCorrectLogin);
    }



    public LoginPageHTML provideCorrectUsernameInCorrectPassword()
    {
        this.FillUsername(correctLogin);
        this.FillPassword(incorrectPassword);
        this.clickSignIn1Button();
        return this;
    }






//
//
//    public LoginPage search(String query) {
//            $(By.name("q")).setValue(query).pressEnter();
//            return page(LoginPage.class);
//        }
//
//    public class LoginPage {
//        public ElementsCollection results() {
//            return $$("#ires li.g");
//        }
//
//
//    }


}

