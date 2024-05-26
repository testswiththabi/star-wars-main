import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class MovieSortingTest {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://swapi.dev/api";
    }

    @Test
    public void testSortMoviesByTitle() {
        given().
            queryParam("sort", "title").
            when().
            get("/movies").
            then().
            statusCode(200).
            body("movies[-1].title", equalTo("The Phantom Menace"));
    }

    @Test
    public void testSortMoviesByTitleAlternateOrder() {
        given().
            queryParam("sort", "title").
            when().
            get("/movies").
            then().
            statusCode(200).
            body("movies[0].title", equalTo("Attack of the Clones"));
    }
}
