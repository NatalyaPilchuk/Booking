package steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.selector.ByText;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;
import pages.HotelsPage;
import pages.MainPage;

import java.awt.*;

import static com.codeborne.selenide.Selenide.*;

public class SearchSteps {
    MainPage mainPage;
    HotelsPage hotelsPage;

    @Before
    public void setUp() {
        Configuration.timeout = 6000;
        Dimension size
                = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) size.getWidth();
        int height = (int) size.getHeight() - 50;
        Configuration.browserSize = String.format("%dx%d", width, height);
        mainPage = new MainPage();
        hotelsPage = new HotelsPage();

    }

    @Given("Main Booking page opened")
    public void mainBookingPageOpened() {
        mainPage.openMainPage();
    }

    @When("User input the name of hotel{string}")
    public void userInputTheNameOfHotel(String hotelName) {
        mainPage.inputTheNameOfHotel(hotelName);
    }

    @And("User click button Search")
    public void userClickButtonSearch() {
        mainPage.clickSearch();
    }

    @Then("hotel {string}presents on page")
    public void hotelPresentsOnPage(String nameOfHotel) {
        Assert.assertEquals(hotelsPage.hotelPresentsOnPage(nameOfHotel), "Castle Inn", "there isn't any hotels with such name");
    }


    @Then("hotel has {string} rating")
    public void hotelHasRating(String ratingOfHotel) {
        Assert.assertEquals(hotelsPage.rightRatingPresentsOnPage(ratingOfHotel), "8.5", "the rating of hotel is wrong");
    }
}
