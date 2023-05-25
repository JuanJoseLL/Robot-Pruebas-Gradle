package com.tallerconpatron.certificacion.colorlib.step;

import com.tallerconpatron.certificacion.colorlib.common.BasePage;
import com.tallerconpatron.certificacion.colorlib.pageobject.PaginaForm;
import com.tallerconpatron.certificacion.colorlib.pageobject.PaginaHome;
import com.tallerconpatron.certificacion.colorlib.pageobject.PaginaLogin;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;
import org.apache.xpath.res.XPATHErrorResources_it;

public class TaskAction extends BasePage {
    private PaginaLogin paginaLogin;
    private PaginaHome paginaHome;
    private PaginaForm paginaForm;
    @Step
    public void openPage(){
        openApp();
    }

    @Step
    public void signIn(String username,String password) {
        sendKeyUser(username);
        sendKeyPass(password);
        paginaLogin.btnSingIn.waitUntilClickable().click();
        try {
            Thread.sleep(100);
            enterMenu();
            formValidation();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }


    public void sendKeyUser(String user){
        paginaLogin.user.click();
        paginaLogin.user.clear();
        paginaLogin.user.sendKeys(user);
    }

    public void sendKeyPass(String pass){
        paginaLogin.password.click();
        paginaLogin.password.clear();
        paginaLogin.password.sendKeys(pass);
    }

    public void enterMenu(){

        paginaHome.menu.waitUntilClickable().click();
    }

    public void formValidation(){

        paginaHome.formValidation.waitUntilClickable().click();
    }

    public boolean assertTittle() throws Exception {
        if(paginaForm.header.getText().equals("Popup Validation")){
            return true;
        }else {
            return false;

        }
    }
    public void fillForm(String required, String select, String multiSelect, String url,String email, String pass, String confPass, String minF, String maxF,String num,String ip,String date,String dateE){
        paginaForm.required.click();
        paginaForm.required.clear();
        paginaForm.required.sendKeys(required);


        paginaForm.select.click();
        paginaForm.sport.click();

        paginaForm.multi.click();


        paginaForm.url.click();
        paginaForm.url.clear();
        paginaForm.url.sendKeys(url);


        paginaForm.email.click();
        paginaForm.email.clear();
        paginaForm.email.sendKeys(email);


        paginaForm.pass.click();
        paginaForm.pass.clear();
        paginaForm.pass.sendKeys(pass);

        paginaForm.confPass.click();
        paginaForm.confPass.clear();
        paginaForm.confPass.sendKeys(confPass);

        paginaForm.minField.click();
        paginaForm.minField.clear();
        paginaForm.minField.sendKeys(minF);


        paginaForm.maxField.click();
        paginaForm.maxField.clear();
        paginaForm.maxField.sendKeys(maxF);


        paginaForm.number.click();
        paginaForm.number.clear();
        paginaForm.number.sendKeys(num);


        paginaForm.ip.click();
        paginaForm.ip.clear();
        paginaForm.ip.sendKeys(ip);


        paginaForm.date.click();
        paginaForm.date.clear();
        paginaForm.date.sendKeys(date);


        paginaForm.dateEar.click();
        paginaForm.dateEar.clear();
        paginaForm.dateEar.sendKeys(dateE);



    }
    public void btnValidate(){
        paginaForm.btnValidation.click();

    }

    public boolean reqEmptyValidation(){
        return paginaForm.required.getText().equals("");
    }
}
