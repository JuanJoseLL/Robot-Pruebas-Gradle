package com.tallerconpatron.certificacion.colorlib.pageobject;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

public class PaginaHome extends PageObject {

    @FindBy(xpath = "//*[@id=\"menu\"]/li[6]/a")
    public WebElementFacade menu;

    @FindBy(xpath = "//*[@id=\"menu\"]/li[6]/ul/li[2]/a")
    public WebElementFacade formValidation;



}
