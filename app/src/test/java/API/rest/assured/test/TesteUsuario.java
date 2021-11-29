/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package API.rest.assured.test;


import API.rest.assured.dominio.Usuario;
import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.*;

public class TesteUsuario extends TesteBase {

    private static final String LISTA_USUARIOS_ENDPOINT ="/users";
    private static final String CRIAR_USUARIO_ENDDPOINT = "/user";
    private static final String MOSTRAR_USUARIO_ENDDPOINT = "/users/{userID}";


    @Test
    public void testMostraPaginaEspecifica() {
        RestAssured.given().param("page","2").
        when()
                .get(LISTA_USUARIOS_ENDPOINT).
                then().
                statusCode(HttpStatus.SC_OK).
                body("page", is(2)).
                body("data", is(notNullValue()));
    }

    @Test
    public void testeCriaUsuarioComSucesso() {
       // Usuario usuario = new Usuario("Mateus","Analista de Sistema","mateusmorrais@gmail.com","lima");
        Map<String, String> usuario = new HashMap<>();
        usuario.put("name", "Mateus");
        usuario.put("job", " Eng Testes");

        RestAssured.given().
                body(usuario).
                when().
                post(CRIAR_USUARIO_ENDDPOINT).
                then()
                .statusCode(201)
                .body("name", is("Mateus"));
    }

    @Test
    public void testeTamanhoDosItemsMostradosIgualAoPerPage() {
        int paginaEsperada = 2;
        int perPageEsperado = retornaPerPageEsperado(paginaEsperada);

        RestAssured.given().param("page", paginaEsperada).
                when()
                .get(LISTA_USUARIOS_ENDPOINT).
                then().
                statusCode(HttpStatus.SC_OK).
                body(
                        "page", is(paginaEsperada),
                        "data.size()", Matchers.is(perPageEsperado),
                        "data.findAll {it.avatar.startsWith('https://reqres.in')}.size()", is(perPageEsperado)

                );

    }

    @Test
    public void testeMotraUsuarioEspecifico(){

      Usuario usuario =  RestAssured.given()
                .pathParam("userID",2)
                .when()
                .get(MOSTRAR_USUARIO_ENDDPOINT)
                .then()
                .statusCode(HttpStatus.SC_OK)
              .extract().body().jsonPath().getObject("data",Usuario.class);
            //    .body("data.email", containsString("@reqres.in"));

        MatcherAssert.assertThat(usuario.getEmail(), containsString("@reqres.in"));
        MatcherAssert.assertThat(usuario.getName(), is("Janet"));
        MatcherAssert.assertThat(usuario.getLastname(), is("Weaver"));
    }



    private int retornaPerPageEsperado(int page) {
        int perPageEsperado = RestAssured.given().param("page",page).
                when().get(LISTA_USUARIOS_ENDPOINT).
                then()
                .statusCode(HttpStatus.SC_OK).extract().path("per_page");
        return perPageEsperado;
    }



}
