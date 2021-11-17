import org.junit.jupiter.api.Test;
import stepPages.DashboardStepPage;
import stepPages.ReservationStepPage;
import stepPages.SearchResultStepPage;
import java.time.DayOfWeek;

public class SearchTest extends TestBaseModel {

    @Test
    void selectSpecificTravelWithFastestArrival(){
        DashboardStepPage dashboardStepPage = new DashboardStepPage();
        //Step 1: Check dashboard is displayed
        dashboardStepPage.checkPageAppeared();
        //Step 2: Set 'From' destination to Ostrava
        dashboardStepPage.setFromLocation("Ostrava");
        //Step 3: Set 'To' destination to Brno
        dashboardStepPage.setToLocation("Brno");
        //Step 4: Set deport day to Monday
        dashboardStepPage.setDeportDateToNearestDay(DayOfWeek.MONDAY);
        //Step 5: Click on search button
        dashboardStepPage.submitSearch();

        SearchResultStepPage searchResultStepPage = new SearchResultStepPage();
        //Step 6: Check search result page is displayed
        searchResultStepPage.checkPageAppeared();
        //Step 7: Select result by fastest arrival time
        searchResultStepPage.selectFastestArrivalElement();

        ReservationStepPage reservationStepPage = new ReservationStepPage();
        //Step 8: Check Reservation page is displayed
        reservationStepPage.checkPageAppears();
    }

    @Test
    void selectSpecificTravelWithShortestTravelingTime(){
        DashboardStepPage dashboardStepPage = new DashboardStepPage();
        //Step 1: Check dashboard is displayed
        dashboardStepPage.checkPageAppeared();
        //Step 2: Set 'From' destination to Ostrava
        dashboardStepPage.setFromLocation("Ostrava");
        //Step 3: Set 'To' destination to Brno
        dashboardStepPage.setToLocation("Brno");
        //Step 4: Set deport day to Monday
        dashboardStepPage.setDeportDateToNearestDay(DayOfWeek.MONDAY);
        //Step 5: Click on search button
        dashboardStepPage.submitSearch();

        SearchResultStepPage searchResultStepPage = new SearchResultStepPage();
        //Step 6: Check search result page is displayed
        searchResultStepPage.checkPageAppeared();
        //Step 7: Select result by shortest time spent with traveling
        searchResultStepPage.selectShortestTimeTravelingElement();

        ReservationStepPage reservationStepPage = new ReservationStepPage();
        //Step 8: Check Reservation page is displayed
        reservationStepPage.checkPageAppears();
    }
    @Test
    void selectSpecificTravelWithLowestPrice(){
        DashboardStepPage dashboardStepPage = new DashboardStepPage();
        //Step 1: Check dashboard is displayed
        dashboardStepPage.checkPageAppeared();
        //Step 2: Set 'From' destination to Ostrava
        dashboardStepPage.setFromLocation("Ostrava");
        //Step 3: Set 'To' destination to Brno
        dashboardStepPage.setToLocation("Brno");
        //Step 4: Set deport day to Monday
        dashboardStepPage.setDeportDateToNearestDay(DayOfWeek.MONDAY);
        //Step 5: Click on search button
        dashboardStepPage.submitSearch();

        SearchResultStepPage searchResultStepPage = new SearchResultStepPage();
        //Step 6: Check search result page is displayed
        searchResultStepPage.checkPageAppeared();
        //Step 7: Select result by lowest price of the journey
        searchResultStepPage.selectLowestPriceElement();

        ReservationStepPage reservationStepPage = new ReservationStepPage();
        //Step 8: Check Reservation page is displayed
        reservationStepPage.checkPageAppears();
    }
}
