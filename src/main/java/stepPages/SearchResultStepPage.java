package stepPages;

import pages.SearchResultPage;

public class SearchResultStepPage extends SearchResultPage {
    public void checkPageAppeared(){ super.checkPageAppeared();}
    public void selectFastestArrivalElement() { clickOnFastestArrivalElement(); }
    public void selectShortestTimeTravelingElement() { clickOnShortestTimeTravelingElement(); }
    public void selectLowestPriceElement() { clickOnLowestPriceElement();}
}
