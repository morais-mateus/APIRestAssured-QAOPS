package API.rest.assured.test;

import API.rest.assured.dominio.Usuario;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

public class RegistroTeste  extends  BaseTeste{



    @Test
    public void testNaoEfetuaRegistroQuandoSenhaEstaFaltando() {

        Usuario user =  new Usuario();
        user.setEmail("Mateus@gmail.com");


        RestAssured.given()
                .body(user)
                .when().post("/register")
                .then().statusCode(HttpStatus.SC_BAD_REQUEST)
                .body("error", Matchers.is("Missing password"));
    }


}
