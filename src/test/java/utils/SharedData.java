package utils;

import com.codeborne.selenide.SelenideElement;

public class SharedData {
    private static SharedData sharedData;
    private SelenideElement confirmationText;

    private SharedData() {
    }

    public static SharedData getSharedData(){
        if(sharedData == null){
            sharedData = new SharedData();
            return sharedData;
        }else {
            return sharedData;
        }
    }

    public SelenideElement getConfirmationText() {
        return confirmationText;
    }

    public void setConfirmationText(SelenideElement confirmationText) {
        this.confirmationText = confirmationText;
    }
}