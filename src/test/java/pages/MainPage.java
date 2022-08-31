package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.conditions.webdriver.Url;
import org.openqa.selenium.By;
import org.openqa.selenium.net.Urls;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {
    private final String SEARCHING_LINE = "//div[contains(@data-testid,'searchbox-layout-vertical')]//input[@placeholder='Where are you going?']";
    private final String OUR_HOTEL = "//div[contains(@data-testid,'searchbox-layout-vertical')]//div[@role='button']//preceding-sibling::div";
    private final String SEARCH_BUTTON = "//div[contains(@data-testid,'searchbox-layout-vertical')]//button[@type='submit']";

    public void openMainPage() {
        open("https://www.booking.com/searchresults.en-gb.html");
    }

    public void inputTheNameOfHotel(String hotelName) {
        String hotelXpath = String.format(SEARCHING_LINE, hotelName);
        $(By.xpath(hotelXpath)).shouldBe(Condition.visible).sendKeys("Castle Inn");
        String realHotel = String.format(OUR_HOTEL);
        $(By.xpath(realHotel)).shouldBe(Condition.visible).click();
    }

    public void clickSearch() {
        $(By.xpath(SEARCH_BUTTON)).click();
    }
}
