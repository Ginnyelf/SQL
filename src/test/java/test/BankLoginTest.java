package test;

import org.junit.jupiter.api.AfterAll;
import page.DashboardPage;
import page.LoginPage;
import page.VerificationPage;
import data.DataHelper;
import data.SQLHelper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static data.SQLHelper.cleanDatabase;


public class BankLoginTest {

    @AfterAll
    static void teardown() {

        cleanDatabase();
    }

    @Test
    @DisplayName("Should successfully login to dashboard with exist login and password from sut data test")
    void shouldSuccessfulLogin() {
        var loginPage = open("http://localhost:9999", LoginPage.class);
        var authinfo = DataHelper.getValidAuthInfo();
        var verificationPage = loginPage.validLogin(authinfo);
        verificationPage.VerificationPage();
        var verificationCode = SQLHelper.getVerificationCode();
        verificationPage.validVerify(verificationCode.getCode());

    }


}
