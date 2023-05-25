package com.tallerconpatron.certificacion.colorlib.definition;

import com.tallerconpatron.certificacion.colorlib.common.BasePage;
import com.tallerconpatron.certificacion.colorlib.step.TaskAction;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

import static org.junit.Assert.assertEquals;

public class FormValidationDefinition extends BasePage {
    private String user;
    private String pass;
    @Steps
    TaskAction taskAction;
    @Given("I enter with my credentials")
    public void iEnterWithMyCredentials(io.cucumber.datatable.DataTable dataTable) {
        this.user = dataTable.cell(1,0);
        this.pass = dataTable.cell(1,1);

    }

    @When("I proceed with the authentication")
    public void iProceedWithTheAuthentication() {
        try{
            taskAction.openPage();
            taskAction.signIn(user,pass);
        }catch (NullPointerException ex){
            ex.printStackTrace();
        }
    }

    @And("go to the main view of the page")
    public void goToTheMainViewOfThePage() {
        try{
            taskAction.enterMenu();

        }catch (NullPointerException ex){
            ex.printStackTrace();
        }
    }

    @And("enter submenu form validations")
    public void enterSubmenuFormValidations() {
        try{
            taskAction.formValidation();

        }catch (NullPointerException ex){
            ex.printStackTrace();
        }

    }

    @And("check the title of the form on the screen")
    public void checkTheTitleOfTheFormOnTheScreen() {
        try{
            assert(taskAction.assertTittle());
        }catch(NullPointerException ex){
            ex.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @And("fill all fields")
    public void fillAllFields(io.cucumber.datatable.DataTable dataTable) {
            String req = dataTable.cell(1,0);
            String select = dataTable.cell(1,1);
            String multi = dataTable.cell(1,2);
            String url = dataTable.cell(1,3);
            String email = dataTable.cell(1,4);
            String pass = dataTable.cell(1,5);
            String confP = dataTable.cell(1,6);
            String minF = dataTable.cell(1,7);
            String maxF = dataTable.cell(1,8);
            String num = dataTable.cell(1,9);
            String ip = dataTable.cell(1,10);
            String date = dataTable.cell(1,11);
            String dateE = dataTable.cell(1,12);
            taskAction.fillForm(req,select,multi,url,email,pass,confP,minF,maxF,num,ip,date,dateE);
    }

    @And("click button validate")
    public void clickButtonValidate() {
        taskAction.btnValidate();
    }

    @Then("field required will be empty")
    public void fieldRequieredWillBeEmpty() {
        assert(taskAction.reqEmptyValidation());
    }
}
