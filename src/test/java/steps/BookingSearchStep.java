package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class BookingSearchStep extends BaseStep{

    String city;

    @Given("I want to search for {string}")
    public void iWantToSearchFor(String city) {
        this.city = city;
    }

    @When("I do search")
    public void iDoSearch() {
        bookingPage.open();
        bookingPage.searchHotel(city);
    }

    @Then("Results page should contain {string}")
    public void resultsPageShouldContain(String hotel) {
        List<WebElement> hotels = driver.findElements(By.xpath("//div[@data-testid='title']"));
        assertEquals(hotels.get(0).getText(), hotel, "Wrong hotel name");
    }

    @And("rating should be {string}")
    public void ratingShouldBe(String rating) {

        List<WebElement> ratings = driver.findElements(By.xpath("//div[@data-testid='review-score']/div[contains(text(),*)]"));
        assertEquals(ratings.get(0).getText(), rating, "Wrong rating");
    }
}
