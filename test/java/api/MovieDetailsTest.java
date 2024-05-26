import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class MovieDetailsTest {

    @BeforeAll
    public static void setup() {
        // Base URI
        RestAssured.baseURI = "https://swapi.dev/api";
    }

    @Test
    public void testGetMoviesListAndCount() {
        given().
            header("Content-Type", "application/json").
        when().
            get("/films").
        then().
            statusCode(200).
            body("count", equalTo(6));
    }

    @Test
    public void testGetThirdMovieAndCheckDirector() {
        given().
            header("Content-Type", "application/json").
        when().
            get("/films/3").
        then().
            statusCode(200).
            body("director", equalTo("Richard Marquand"));
    }

    @Test
    public void testGetFifthMovieAndCheckProducers() {
        given().
            header("Content-Type", "application/json").
        when().
            get("/films/5").
        then().
            statusCode(200).
            body("producers", not(hasItem("Gary Kurtz, George Lucas")));
    }

    @Test
    public void testViewEmpireStrikesBackDetails() {
        given().
            when().
            get("/movies").
            then().
            statusCode(200).
            body("find { it.title == 'The Empire Strikes Back' }.species", hasItem("Wookie"));
    }

    @Test
    public void testCaminoNotInPhantomMenace() {
        given().
            when().
            get("/movies").
            then().
            statusCode(200).
            body("find { it.title == 'The Phantom Menace' }.planets", not(hasItem("Camino")));
    }
}

