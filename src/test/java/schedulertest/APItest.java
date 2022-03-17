package schedulertest;

import com.jayway.restassured.http.ContentType;
import javafx.beans.binding.Bindings;
import org.testng.annotations.Test;
import schedulerdto.ModelOfUser;

import java.util.List;

import static com.jayway.restassured.RestAssured.given;

public class APItest {

    private static final String URL = "https://reqres.in";

   /* @BeforeMethod
    public void preCondition(){
        RestAssured.baseURI = "https://reqres.in/";
        RestAssured.basePath = "api/users?page=2";
    }*/

 /*   @Test
    public void someTest(){

       List<DataUser> users = given()
                .when()
                .contentType(ContentType.JSON)
                .get()
                .then().log().all()
                .extract().body().jsonPath().getList("data", DataUser.class);
int a = 0;

    }*/

    @Test
    public void secondTest() {

        List<ModelOfUser> myUsers = given()
                .when()
                .contentType(ContentType.JSON)
                .get(URL+"/api/users?page=2")
                .then().log().all()
                .extract().body().jsonPath().getList("data",ModelOfUser.class);



}

}