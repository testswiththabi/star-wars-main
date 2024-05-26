package steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MovieDetailsSteps {
    WebDriver driver;

    @Given("the user is on the movie list page")
    public void the_user_is_on_the_movie_list_page() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://swapi.dev/movies");
    }

    @When("the user selects {string}")
    public void the_user_selects_movie(String movieTitle) {
        driver.findElement(By.linkText(movieTitle)).click();
    }

    @Then("the 'Species' list should include {string}")
    public void the_species_list_should_include(String species) {
        WebElement speciesList = driver.findElement(By.id("species-list"));
        assertTrue(speciesList.getText().contains(species));
        driver.quit();
    }

    @Then("{string} should not be listed as a planet")
    public void should_not_be_listed_as_a_planet(String planet) {
        WebElement planetsList = driver.findElement(By.id("planets-list"));
        assertFalse(planetsList.getText().contains(planet));
        driver.quit();
    }
}
