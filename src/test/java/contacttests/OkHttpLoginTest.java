package contacttests;

import com.google.gson.Gson;
import contactdto.AuthRequestDto;
import contactdto.AuthResponseDto;
import contactdto.ErrorDto;
import okhttp3.*;
import org.testng.annotations.Test;

import java.io.IOException;

public class OkHttpLoginTest {

    public static final MediaType JSON =
            MediaType.get("application/json;charset=utf-8");

    @Test
    public void loginTest() throws IOException {
        Gson gson = new Gson();
        OkHttpClient client = new OkHttpClient();

        AuthRequestDto requestDto = AuthRequestDto.builder()
                .email("a1@b1.ru")
                .password("AAbb3'$'").build();

        RequestBody requestBody  = RequestBody.create(gson.toJson(requestDto),JSON);

        Request request = new Request.Builder()
                .url("https://contacts-telran.herokuapp.com/api/login")
                .post(requestBody)
                .build();

        Response response = client.newCall(request).execute();

        if(response.isSuccessful()){
            String responseJson = response.body().string();

            AuthResponseDto responseDto = gson.fromJson(responseJson,AuthResponseDto.class);
            System.out.println(responseDto.getToken());
            System.out.println(response.code());

        }else{
            System.out.println("Response code-->" +response.code());
            ErrorDto errorDto = gson.fromJson(response.body().string(),ErrorDto.class);
            System.out.println("Error --->" +errorDto.getCode() + "Message --> " +errorDto.getMessage() );
            System.out.println("Details -->" +errorDto.getDetails());
        }
    }
}
