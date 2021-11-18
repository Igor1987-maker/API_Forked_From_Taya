package schedulertest;

import com.google.gson.Gson;
import okhttp3.*;
import org.testng.annotations.Test;
import schedulerdto.AuthRequestRecord;
import schedulerdto.AuthResponseRecord;

import java.io.IOException;

public class OkHttpLoginRecordsTest {
    public static final MediaType JSON =
            MediaType.get("application/json;charset=utf-8");

    @Test
    public void loginTest() throws IOException {
        Gson gson = new Gson();
        OkHttpClient client = new OkHttpClient();

        AuthRequestRecord requestRecord = AuthRequestRecord.builder()
                .email("igor@mail.ru")
                .password("WwAbb3'$").build();

        RequestBody requestBody  = RequestBody.create(gson.toJson(requestRecord),JSON);

        Request request = new Request.Builder()
                .url("https://super-scheduler-app.herokuapp.com/api/login")
                .post(requestBody)
                .build();

        Response response = client.newCall(request).execute();

        if(response.isSuccessful()){
            String responseJson = response.body().string();

            AuthResponseRecord responseRecord = gson.fromJson(responseJson, AuthResponseRecord.class);
            System.out.println("Youre TOKEN is: "+responseRecord.getToken());
            System.out.println(response.code());

        }else{
            System.out.println("Response code-->" +response.code());
/* ErrorDto errorDto = gson.fromJson(response.body().string(),ErrorDto.class);
            System.out.println("Error --->" +errorDto.getCode() + "Message --> " +errorDto.getMessage() );
            System.out.println("Details -->" +errorDto.getDetails());*/

        }
    }

}
