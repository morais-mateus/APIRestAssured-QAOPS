package API.rest.assured.test;

import API.rest.assured.dominio.Usuario;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;

public class RegistroTeste {

    @BeforeAll
    public static void setup() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        baseURI = "https://reqres.in";
        basePath = "/api";
    }

    @Test
    public void testNaoEfetuaRegistroQuandoSenhaEstaFaltando() {

        Usuario user =  new Usuario();
        user.setEmail("Mateus@gmail.com");


        RestAssured.given()
                .contentType(ContentType.JSON)
                .body(user)
                .when().post("/register")
                .then().statusCode(HttpStatus.SC_BAD_REQUEST)
                .body("error", Matchers.is("Missing password"));
    }


}
