package API.rest.assured.test;

import API.rest.assured.dominio.Usuario;
import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

public class TesteRegistro extends TesteBase {

    private static  final String REGISTRA_USUARIO_ENDPOINT = "/register";

    @Test
    public void testNaoEfetuaRegistroQuandoSenhaEstaFaltando() {

        Usuario user =  new Usuario();
        user.setEmail("Mateus@gmail.com");


        RestAssured.given()
                .body(user)
                .when().post(REGISTRA_USUARIO_ENDPOINT)
                .then().statusCode(HttpStatus.SC_BAD_REQUEST)
                .body("error", Matchers.is("Missing password"));
    }


}
