package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Utils;

import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;


public class SearchResultPage extends SearchElement {

    private final By checkBox = new By.ByClassName("MuiFormControl-root");
    private final By searchPageTitle = new By.ByXPath("//h1[@class='h1 flex-grow-1']");


    protected void checkPageAppeared(){
        $(checkBox).should(Condition.exist);
        $(searchPageTitle).should(Condition.exist);
        $(searchPageTitle).shouldHave(Condition.text("Vyberte cestu tam"));
    }

    protected void clickOnFastestArrivalElement() {getPriceButtonElement(getFastestArrivalResultPosition()).click();}

    protected void clickOnShortestTimeTravelingElement() { getPriceButtonElement(getShortestTimeTravelingResultPosition()).click();}

    protected void clickOnLowestPriceElement() { getPriceButtonElement(getLowestPriceResultPosition()).click();}

    private Integer getFastestArrivalResultPosition() {
        List<Integer> elementPositions = filterListOfDirectResults();
        Integer fastestArrivalElementPosition = elementPositions.get(0);

        for (Integer elementPosition : elementPositions) {
            try {
                if (Utils.getInstance().getTimeParser().parse(getArrivingTime(fastestArrivalElementPosition)).after(Utils.getInstance().getTimeParser().parse(getArrivingTime(elementPosition)))) {
                    fastestArrivalElementPosition = elementPosition;
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        System.out.println("FASTEST ARRIVAL: " + getTimeElement(fastestArrivalElementPosition).getText());
        return fastestArrivalElementPosition;
    }

    private Integer getShortestTimeTravelingResultPosition(){
        List<Integer> elementPositions = filterListOfDirectResults();
        Integer shortestTimeTravelingElementPosition = elementPositions.get(0);

        for (Integer elementPosition : elementPositions) {
            try {

                if (Utils.getInstance().getTimeParser().parse(getTimeOfTravelling(shortestTimeTravelingElementPosition)).after(Utils.getInstance().getTimeParser().parse(getTimeOfTravelling(elementPosition)))) {
                    shortestTimeTravelingElementPosition = elementPosition;
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        System.out.println("SHORTEST TRAVEL: " + getTimeElement(shortestTimeTravelingElementPosition).getText());
        return shortestTimeTravelingElementPosition;
    }

    private Integer getLowestPriceResultPosition(){
        List<Integer> elementPositions = filterListOfDirectResults();
        Integer lowestPriceElementPosition = elementPositions.get(0);

        for (int i = 0; i < elementPositions.size(); ++i){
            if (Integer.parseInt(getPrice(lowestPriceElementPosition)) > Integer.parseInt(getPrice(elementPositions.get(i)))) {
                lowestPriceElementPosition = elementPositions.get(i);
            }

        }
        System.out.println("LOWEST PRICE: " + getTimeElement(lowestPriceElementPosition).getText());
        return lowestPriceElementPosition;
    }



    private List<Integer> filterListOfDirectResults(){
        List<Integer> filteredListOfElements = new LinkedList();

        for (int i = 0; i < $$x(getResultsParenXpath()).size(); i++){
            if (isDirectConnection(i) && isAvailable(i)){
                filteredListOfElements.add(i);
            }
        }

        return filteredListOfElements;
    }
}

abstract class SearchElement{
    private final String searchAvailableResultsParentXpath = "//div[@class='mb-2 px-2 sm:pr-1.5 pt-2 rounded-sm border border-neutral-gray3 bg-white card']";

    protected String getResultsParenXpath() { return  searchAvailableResultsParentXpath;}

    protected WebElement getTimeElement(Integer position){
        return $$x(searchAvailableResultsParentXpath + "//h2[@class='h3 mr-1.5']").get(position);
    }

    protected WebElement getTimeOfTravellingElement(Integer position){
        return $$x(searchAvailableResultsParentXpath + "//span[contains(@aria-label,'Dĺžka cesty')]").get(position);
    }

    protected String getTimeOfTravelling(Integer position){
        return getTimeOfTravellingElement(position).getText().replace(" h", "");
    }

    protected String getArrivingTime(Integer position){
        return getTimeElement(position).getText().split(" - ")[1];
    }

    protected String getPrice(Integer position){
        return getPriceButtonElement(position).getText().replaceAll("[a-z|A-Z| ]+", "");
    }

    protected WebElement getPriceButtonElement(Integer position){
        return $$x(searchAvailableResultsParentXpath + "//button").get(position);
    }

    protected boolean isAvailable(Integer position){
        return !$$x(searchAvailableResultsParentXpath + "//span[@class='sr-only']").get(position).getText().equals("Počet volných sedadel. 0");
    }

    protected boolean isDirectConnection(Integer position){
        return $$x(searchAvailableResultsParentXpath + "//span[@class='pl-0.5 text-13 lg:text-14']").get(position).getText().equals("Priame spojenie");
    }

}
