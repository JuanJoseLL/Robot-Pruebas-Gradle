package com.tallerconpatron.certificacion.colorlib.definition;

import com.tallerconpatron.certificacion.colorlib.common.BasePage;
import com.tallerconpatron.certificacion.colorlib.pageobject.PaginaLogin;
import org.openqa.selenium.WebDriver;

public class LoginDefinition extends BasePage {
    public static WebDriver driver;
    private PaginaLogin logInPage;

    public void openApp() {
        logInPage.open();
    }

    public WebDriver getDriver() {
        return driver;

    }
}
