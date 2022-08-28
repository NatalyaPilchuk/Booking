package steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.selector.ByText;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.*;

public class SearchSteps {

    @Given("Main Booking page opened")
    public void mainBookingPageOpened() {
        open("https://www.booking.com/searchresults.en-gb.html");
    }

    @When("User input the name of hotel{string}")
    public void userInputTheNameOfHotel(String hotelName) {
        String hotelXpath = String.format("//div[contains(@data-testid,'searchbox-layout-vertical')]//input[@placeholder='Where are you going?']", hotelName);
        $(By.xpath(hotelXpath)).shouldBe(Condition.visible).sendKeys("404 Rooms Wilanowska");
    }

    @And("User click button Search")
    public void userClickButtonSearch() {
        $(By.xpath("//div[contains(@data-testid,'searchbox-layout-vertical')]//button[@type='submit']")).click();
    }

    @Then("hotel {string}presents on page")
    public void hotelPresentsOnPage(String nameOfHotel) {
        String nameHotel = $(new ByText("404 Rooms Wilanowska: 1 property found")).getText();
        Assert.assertEquals(nameHotel, "404 Rooms Wilanowska: 1 property found", "there isn't any hotels with such name");
    }


    @Then("hotel have right rating")
    public void hotelHaveRating() {
        String rating = $(By.xpath("//div[contains(@data-testid,'property-card')]//div[@aria-label='Scored 8.3 '][1]")).getText();
        Assert.assertEquals(rating, "8.3", "the rating is wrong");
    }
}
