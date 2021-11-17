package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class ReservationPage {

    private final By reservationSelectionTitle = new By.ByXPath("//h1[@class='h1']");
    private final By tripOverview =  new By.ByXPath("//ul[@aria-label='Prehľad cesty']");

    protected void checkPageAppears(){
        $(reservationSelectionTitle).shouldHave(Condition.text("Výber taríf"));
        $(tripOverview).should(Condition.exist);
    }


}
