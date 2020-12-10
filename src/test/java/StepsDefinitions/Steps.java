package StepsDefinitions;

import Enums.EndpointsEnum;
import Objetos.usuarioClass;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.fail;

public class Steps {

    private Response response;
    private ValidatableResponse json;
    private RequestSpecification request;

    //String = "([^"]*)"
    //Integer = (\\d+)

    @Given("^que o usuario informo um id (.*?)$")
    public void informarId(Integer id){
        usuarioClass userId = new usuarioClass(id);
        request = given()
                .body(userId);
    }

    @When("^submeto a requisição para o id (.*?)$")
    public void submeterRequisicao(Integer idEmpregado){
        response = request.when()
                .get(EndpointsEnum.BUSCARPESSOA.getDescricao() + idEmpregado.toString());
        System.out.println("-----------------------------------------");
        System.out.println("Response retornado: " + response.prettyPrint());
    }

    @Then("^a API retorna status sucesso (.*?)$")
    public void retornoRequisicao(Integer statusCode){
        response.then().statusCode(statusCode);
        if (statusCode.equals(200)) {
            System.out.println("Status: " + response.statusCode() + " OK!");
        }
        else {
            System.out.println("Status: " + response.statusCode() + " NOK!");
        }

    }

    @And("^deve retornar no campo eye_color o valor (.*)$")
    public void retornaValorCampoEyeColor(String eyeColor){
        response.then()
            .body("eye_color", is(eyeColor));

    }

    @And("^deve retornar no campo skin_color o valor (.*)$")
    public void retornaValorCampoSkinColor(String skinColor){
        response.then()
                .body("skin_color", is(skinColor));
    }

    @And("^deve retornar no campo name o valor (.*)$")
    public void retornaValorCampoName(String name){
        response.then()
                .body("name", is(name));
    }
}
