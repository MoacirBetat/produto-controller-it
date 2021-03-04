package br.com.dbserver.api.produto;

import br.com.dbserver.api.base.BaseTest;
import br.com.dbserver.api.builder.Produto;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.service.ExtentTestManager;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.*;

public class ProdutoGetTest extends BaseTest {

    @Test
    public void deveListarProdutos(){

        ExtentTest extentTest = ExtentTestManager.getTest();

        extentTest.log(Status.INFO,"### Início dos Testes ###");

        Response resp = given().
                basePath(basePath).
                when().log().all().
                get("/produtos").
                then().log().all().
                assertThat().
                statusCode(HttpStatus.SC_OK).extract().response();

        List<Produto> listaProdutos = resp.jsonPath().getList("",Produto.class);

        ObjectMapper mapper = new ObjectMapper();

        for (Produto p : listaProdutos) {
            try {
                extentTest.log(Status.INFO, mapper.writeValueAsString(p));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }

        extentTest.log(Status.INFO,"### Fim dos Testes ###");
    }

}
