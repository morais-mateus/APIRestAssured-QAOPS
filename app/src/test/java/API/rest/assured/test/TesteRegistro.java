package API.rest.assured.test;

import API.rest.assured.dominio.Usuario;
import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TesteRegistro extends TesteBase {

    private static  final String REGISTRA_USUARIO_ENDPOINT = "/register";
    private static  final String LOGIN_USUARIO_ENDPOINT = "/login";

    @BeforeAll
    public static void setupRegistro(){
        RestAssured.responseSpecification = new ResponseSpecBuilder().expectStatusCode(HttpStatus.SC_BAD_REQUEST)
                .build();

    }


    @Test
    public void testNaoEfetuaRegistroQuandoSenhaEstaFaltando() {

        Usuario user =  new Usuario();
        user.setEmail("Mateus@gmail.com");


        RestAssured.given()
                .body(user)
                .when().post(REGISTRA_USUARIO_ENDPOINT)
                .then()
                .body("error", Matchers.is("Missing password"));
    }

    //Esse teste deveria estar no TesteLogin
    @Test
    public void testLoginNaoEfetuadoQuandoSenhaEstaFaltando() {

        Usuario user =  new Usuario();
        user.setEmail("peter@klaven");


        RestAssured.given()
                .body(user)
                .when().post(LOGIN_USUARIO_ENDPOINT)
                .then()
                .body("error", Matchers.is("Missing password"));
    }


}
