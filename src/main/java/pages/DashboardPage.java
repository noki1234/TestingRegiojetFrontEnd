package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import utils.Utils;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.webdriver;

public class DashboardPage{

    private final By fromInput = new By.ById("react-select-4-input");
    private final By toInput = new By.ById("react-select-5-input");
    private final By deportDate = new By.ByXPath("/html/body/div[1]/form/div/div/div[2]/div/div[1]/div/div[1]/div/div/span[2]");
    private final By submitBtn = new By.ByXPath("//button[@data-id='search-btn']");
    private final By dashboardPictureArea = new By.ByXPath("//div[contains(@class,'heroBanner')]");

    protected void checkPageAppeared(){
        $(fromInput).should(Condition.exist);
        $(toInput).should(Condition.exist);
        $(dashboardPictureArea).should(Condition.exist);
    }
    protected void setFrom(String value){
        $(fromInput).click();
        $(fromInput).setValue(value);
        $(fromInput).pressEnter();
    }

    protected void setTo(String value){
        $(toInput).click();
        $(toInput).setValue(value);
        $(toInput).pressEnter();
    }

    protected void setDeportDate(DayOfWeek day){
        $(deportDate).click();
        getNearestDayElementFromCalendar(day).click();
    }

    protected void submitSearch(){
        $(submitBtn).click();
        webdriver().driver().getWebDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    private SelenideElement getNearestDayElementFromCalendar(DayOfWeek day){
        final LocalDate nearestDate = Utils.getInstance().getNearestDayFromCalendar(day);
        return $x("//td[contains(@aria-label,'" + nearestDate.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH) + " " + nearestDate.getDayOfMonth() + "')]");
    }


}
