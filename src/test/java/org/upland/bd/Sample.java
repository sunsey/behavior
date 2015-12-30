package org.upland.bd;

/**
 * Created by ykarpiuk on 12/2/2015.
 */

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.URL;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Sample {
    ///LoginPageHTML loginPageHTML = open("https://upland-logic-development.herokuapp.com/users/sign_in", LoginPageHTML.class);
    WebDriver driver;
    DesiredCapabilities caps  = new DesiredCapabilities();
    String remote;


    @BeforeClass
    public void setUp() throws Exception {

         remote = "http://yurii16:fNrGLC3k2WYbRiuutfrZ@hub.browserstack.com/wd/hub";
        // remote = "http://localhost:4444/wd/hub";
        Configuration.baseUrl = "https://upland-logic-development.herokuapp.com";
        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "7");
        caps.setCapability("browser", "chrome");
        caps.setCapability("browser_version", "47");
        caps.setCapability("resolution", "1024x768");
        caps.setCapability("build", "Sample");
        driver = new RemoteWebDriver(new URL(remote),caps);

        WebDriverRunner.setWebDriver(driver);

        open("/users/sign_in");
        $("#user_email").setValue("y.karpiuk@svitla.com");
        $("#user_password").setValue("UplandSvitla01");
        $(By.name("button")).click();
    }

    @Test
    public void testCheckLoginOk() {

        $(By.className("page-title")).shouldHave(text("Organization"));

    }

    @Test
    public void testCreateOrganizationFormAppear() {
        $(By.xpath("//*[@class=\"btn btn-primary\"]")).click();
        $(By.className("modal-title")).shouldHave(text("Create New Organization"));
        $(By.xpath("//*[@id=\"new_organization\"]/div[2]/div/button[1]")).click();

    }

    @Test
    public void testCreateOrganization() {
        $(By.xpath("//*[@class=\"btn btn-primary\"]")).click();
        $(By.id("organization_users_attributes_0_name")).setValue("autotestOrganization");
        $(By.id("organization_users_attributes_0_email")).setValue("karpyuk@gmail.com");
        $(By.xpath("//*[@id=\"new_organization\"]/div[2]/div/button[2]")).click();
        $(By.xpath("//*[@class = \"alert alert-danger fade in\"]")).shouldNotHave("Failed to create the organization: Users password The password must contain 8 minimum characters, including letters as minimum or more and numbers.");

    }

    @Test
    public void testCheckOrganizationIsCreated() {
        $(By.xpath("//*[@id=\"organizations-table_paginate\"]/ul/li[7]/a")).click();
        $(By.xpath("//*[@id=\"organization_31\"]/td[1]/a")).click();
        $(By.className("page-title")).shouldHave(text("Svitla"));

    }

    @Test
    public void testCheckPortfolioFormAppear() {
        $(By.xpath("//*[@id=\"organizations-table_paginate\"]/ul/li[7]/a")).click();
        $(By.xpath("//*[@id=\"organization_31\"]/td[1]/a")).click();
        $(By.xpath("//*[@id=\"container\"]/table/tbody/tr[1]/td[1]/a")).click();  // Portfolio
        $(By.className("page-title")).shouldHave(text("Portfolios"));
        $(By.xpath("//*[@id=\"container\"]/div/a")).click();  // Portfolio Create
        $(By.className("modal-title")).shouldHave(text("Create New Portfolio"));
        $(By.xpath("//*[@id=\"new_portfolio\"]/div[2]/div/button[1]")).click();  // Click Cancel

    }

    @Test   /// fail for moment
    public void testPortfolioCreate() {
        $(By.xpath("//*[@id=\"organizations-table_paginate\"]/ul/li[7]/a")).click();
        $(By.xpath("//*[@id=\"organization_31\"]/td[1]/a")).click();
        $(By.xpath("//*[@id=\"container\"]/table/tbody/tr[1]/td[1]/a")).click();  // Portfolio
        $(By.xpath("//*[@id=\"container\"]/div/a")).click();  // Portfolio Create

        $(By.id("portfolio_name")).setValue("autotestPortfolio");
        $(By.id("portfolio_analytics_start_date")).setValue("12/132/2013");

        $(By.xpath("//*[@id=\"new_portfolio\"]/div[2]/div/button[2]")).click();  // Click Save
        $(By.id("container")).shouldHave(text("12341234"));

        $(By.xpath("/html/body/div/table/tbody/tr[2]/td[6]/a[2]")).click();  // Go to asset
        $(By.className("page-title")).shouldHave(text("12341234"));

    }



    @Test
    public void testCheckCreateAssetFormAppear() {
        $(By.xpath("//*[@id=\"organizations-table_paginate\"]/ul/li[7]/a")).click();
        $(By.xpath("//*[@id=\"organization_31\"]/td[1]/a")).click();
        $(By.xpath("//*[@id=\"container\"]/table/tbody/tr[1]/td[1]/a")).click();  // Portfolio

        $(By.xpath(".//*[. = \"First Partners\"]")).click(); // Go to asset
        $(By.xpath("//*[@class =\"glyphicon glyphicon-plus icon-white\"]")).click(); // Create Asset
        $(By.className("modal-title")).shouldHave(text("Create New Asset"));
        $(By.xpath("//*[@id=\"new_asset\"]/div[2]/div/button[1]")).click(); // Click Cancel


    }

    @Test
    public void testCheckCreateAsset() {
        $(By.xpath("//*[@id=\"organizations-table_paginate\"]/ul/li[7]/a")).click();
        $(By.xpath("//*[@id=\"organization_31\"]/td[1]/a")).click();
        $(By.xpath("//*[@id=\"container\"]/table/tbody/tr[1]/td[1]/a")).click();  // Portfolio

        $(By.xpath(".//*[. = \"First Partners\"]")).click(); // Go to asset
        $(By.xpath("//*[@class =\"glyphicon glyphicon-plus icon-white\"]")).click(); // Create Asset

        $(By.id("asset_owners_name")).setValue("autotestOwnerName");
        $(By.id("asset_name")).setValue("autotestAssetName");
        $(By.xpath("//*[@id=\"new_asset\"]/div[2]/div/button[2]")).click(); // Click Save

    }


   @BeforeMethod
   public void gotoOrganizationPage() {
       $(By.id("logo_image")).click();
   }


    @AfterClass
    public void tearDown() throws Exception {
        driver.quit();
    }
}