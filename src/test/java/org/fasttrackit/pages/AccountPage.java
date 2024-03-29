package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

import java.util.*;

public class AccountPage extends PageObject {

    @FindBy(css = ".woocommerce-MyAccount-content")
    private WebElementFacade welcomeText;

    @FindBy(css=".woocommerce-MyAccount-navigation li:nth-child(2)")   // .woocommerce-MyAccount-navigation-link--orders
    private WebElementFacade ordersButton;

    @FindBy(linkText = "Orders")
    private WebElementFacade ordersButton2;


    @FindBy(css=".woocommerce-MyAccount-content div")
    private WebElementFacade optionMessage;

    @FindBy(css=".post-title")
    private WebElementFacade optionTitle;

    public void verifyWelcomeMessage(String userName){
        welcomeText.shouldContainText ("Hello "+userName);
//        welcomeText.getText().equalsIgnoreCase("Hello "+userName))
    }

    public void clickOrdersButton(){
        clickOn(ordersButton);
        clickOn(ordersButton2);
    }

    public void verifyOrdersEmpty(){
        optionMessage.shouldContainText ("No order has been made yet");

    }

    public String getOptionText(){
        return optionTitle.getText();
    }

    public void verifyMenuSelected(String menuSelected){
        optionTitle.shouldContainText (menuSelected);
    }

}
