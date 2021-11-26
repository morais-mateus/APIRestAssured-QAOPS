/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package API.rest.assured;



import static org.hamcrest.Matchers.*;

import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.when;

public class AppTest {


    @Test
    public void testeListaMetadosUsuarios() {

                when()
                        .get("https://reqres.in/api/users?page=2").
                then().
                        statusCode(HttpStatus.SC_OK).
                        body("page", is(2)).
                        body("data", is(notNullValue()));


    }
}
