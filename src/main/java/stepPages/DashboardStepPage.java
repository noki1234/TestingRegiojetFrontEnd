package stepPages;

import pages.DashboardPage;

import java.time.DayOfWeek;

public class DashboardStepPage extends DashboardPage {

    public void checkPageAppeared(){ super.checkPageAppeared();}
    public void setFromLocation(String location){ setFrom(location);}
    public void setToLocation(String location){ setTo(location);}
    public void setDeportDateToNearestDay(DayOfWeek day){ super.setDeportDate(day);}
    public void submitSearch(){super.submitSearch();}
}
