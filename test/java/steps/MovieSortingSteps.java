package steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MovieSortingSteps {
    WebDriver driver;

    @Given("the user is on the movie list page")
    public void the_user_is_on_the_movie_list_page() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://swapi.dev/movies");
    }

    @When("the user selects the 'Title' sorting option")
    public void the_user_selects_the_title_sorting_option() {
        driver.findElement(By.id("sort-title")).click();
    }

    @Then("the last movie in the list should be {string}")
    public void the_last_movie_in_the_list_should_be(String expectedTitle) {
        WebElement lastMovie = driver.findElement(By.cssSelector("#movie-list li:last-child"));
        assertEquals(expectedTitle, lastMovie.getText());
        driver.quit();
    }

    @Then("the first movie in the list should be {string}")
    public void the_first_movie_in_the_list_should_be(String expectedTitle) {
        WebElement firstMovie = driver.findElement(By.cssSelector("#movie-list li:first-child"));
        assertEquals(expectedTitle, firstMovie.getText());
        driver.quit();
    }
}
