package schedulertest;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import contactdto.AuthRequestDto;
import contactdto.AuthResponseDto;
import contactdto.ErrorDto;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import contactdto.AuthRequestDto;
import contactdto.AuthResponseDto;
import contactdto.ErrorDto;
import schedulerdto.BodyDto;
import schedulerdto.GetAllRecordsDto;
import schedulerdto.RecordDto;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
public class RestAssuredLoginTest {

    public static String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbWFpbCI6Imlnb3JAbWFpbC5ydSJ9.s7bUIfjB-42LtC0HlSuTE72AR1Ph85ARwvDdYYQF_NE";


    @BeforeMethod
    public void precondition(){
        RestAssured.baseURI = "https://super-scheduler-app.herokuapp.com/";
        RestAssured.basePath = "api";
    }

    @Test
    public void loginTestSuccess(){
        AuthRequestDto auth = AuthRequestDto.builder()
                .email("dolly@gmail.com")
                .password("Dd12345~")
                .build();

        AuthResponseDto responseDto = given()
                .contentType("application/json")
                .body(auth)
                .when()
                .post("login")
                .then()
                .assertThat().statusCode(200)
                .extract().response().as(AuthResponseDto.class);
        System.out.println( responseDto.getToken());
     //   System.out.println(responseDto.getStatus());
       // System.out.println(responseDto.isRegistration());

    }

    @Test
    public void loginWrongPassword(){
        AuthRequestDto auth = AuthRequestDto.builder()
                .email("dolly@gmail.com")
                .password("Dd12345")
                .build();

        ErrorDto errorDto = given().contentType(ContentType.JSON)
                .body(auth)
                .when()
                .post("login")
                .then()
                .assertThat().statusCode(401)
                .extract().response().as(ErrorDto.class);

         /* GetAllRecordsDto recordsDto =  given()
                .header("Authorization",token)
                .contentType(ContentType.JSON)
                .body(requestDto)
                .when()
                .post("records")
                .then()
                .assertThat().statusCode(200)
                .extract().as(GetAllRecordsDto.class); */

        System.out.println(errorDto.toString());
    }

    @Test
    public void loginWrongPassword2(){
        AuthRequestDto auth = AuthRequestDto.builder()
                .email("dolly@gmail.com")
                .password("Dd12345")
                .build();

        String message = given().contentType(ContentType.JSON)
                .body(auth)
                .when()
                .post("login")
                .then()
                .assertThat().statusCode(401)
                .extract().path("message");

        System.out.println(message);
        Assert.assertEquals(message,"Wrong email or password");
    }

    @Test
    public void registrationSuccess(){
        int index = (int)(System.currentTimeMillis()/1000)%3600;
        AuthRequestDto auth = AuthRequestDto.builder()
                .email("dolly"+index+"@gmail.com")
                .password("Dd12345~")
                .build();

        given().contentType(ContentType.JSON)
                .body(auth)
                .when()
                .post("login")
                .then()
                .statusCode(200)
                .assertThat()
                .body("status",containsString("Registration success"))
                .body("registration",equalTo(true));
    }

    @Test

    public void gettAllRecordsRestAssured(){
        BodyDto bodydto = BodyDto.builder()
                .monthFrom(1)
                .monthTo(12)
                .yearFrom(2022)
                .yearTo(2022)
                .build();

        GetAllRecordsDto allRecordsDto = given()
                .header("Authorization",token)
                .contentType(ContentType.JSON)
                .body(bodydto)
                .when()
                .post("records")
                .then()
                .assertThat().statusCode(200)
                .extract().response().as(GetAllRecordsDto.class);

        for(RecordDto record: allRecordsDto.getRecords()){
            System.out.println(record.getId());
            System.out.println("******************");


        }

    }


}
