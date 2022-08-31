package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class HotelsPage {
    private final String NAME_OF_HOTEL = "//div[contains(@data-testid,'property-card')]//div[text()='Castle Inn']";
    private final String RATING_HOTEL = "//div[contains(@data-testid,'property-card')]//div[@aria-label='Scored 8.5 ']";

    public String hotelPresentsOnPage(String nameOfHotel) {
        String nameHotel = String.format(NAME_OF_HOTEL, nameOfHotel);
        $(By.xpath(nameHotel)).shouldBe(Condition.visible).getText();
        return nameHotel;
    }

    public String rightRatingPresentsOnPage(String ratingOfHotel) {
        String hotelRating = String.format(RATING_HOTEL, ratingOfHotel);
        $(By.xpath(hotelRating)).shouldBe(Condition.visible).getText();
        return hotelRating;
    }
}
