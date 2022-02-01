package pages;

import org.openqa.selenium.By;

public class BookingPage extends BasePage{

    String inputSearch = "//input[@type='search']";
    String buttonSearch = "//span[contains(text(),'Проверить цены')]";

    public void open(){
        driver.get("https://www.booking.com/index.ru.html");
    }

    public void searchHotel(String city){
        driver.findElement(By.xpath(inputSearch)).sendKeys(city);
        driver.findElement(By.xpath(buttonSearch)).click();
    }
}
