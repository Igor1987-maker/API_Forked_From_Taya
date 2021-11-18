package schedulertest;

import com.google.gson.Gson;
import contactdto.ContactDto;
import contactdto.GetAllContactDto;
import okhttp3.*;
/*import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;*/
import org.testng.Assert;
import org.testng.annotations.Test;
import schedulerdto.BodyDto;
import schedulerdto.DateDto;
import schedulerdto.GetAllRecordsDto;
import schedulerdto.RecordDto;

import java.io.IOException;

import static contacttests.OkHttpLoginTest.JSON;

public class OkHttpGetAllRecordsTest {

    @Test
    public void getAllContacts() throws IOException {

       /* public static final MediaType JSON =
                MediaType.get("application/json;charset=utf-8");*/

        Gson gson = new Gson();
        OkHttpClient client = new OkHttpClient();
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbWFpbCI6ImExQGIxLnJ1In0.FEqOOsgttA-jTNjFR9bmq3Dv1CqJ0NOh_IZ7jXVO77Y";
        BodyDto bodydto = BodyDto.builder()
                .monthFrom(1)
                .monthTo(12)
                .yearFrom(2021)
                .yearTo(2021)
                .build();


        RequestBody body = RequestBody.create(gson.toJson(bodydto),JSON);
        Request request = new Request.Builder()
                .url("https://super-scheduler-app.herokuapp.com/api/records")
                .addHeader("Authorization",token)
                .post(body)
                .build();

        Response response = client.newCall(request).execute();

        Assert.assertTrue(response.isSuccessful());

        if(response.isSuccessful()){
            GetAllRecordsDto records = gson.fromJson(response.body().string(),GetAllRecordsDto.class);

            for (RecordDto rec: records.getRecords()){

                System.out.println(rec.getBreaks());
                System.out.println(rec.getCurrency());
                System.out.println(rec.getDate());
                System.out.println(rec.getHours());
                System.out.println(rec.getId());
                System.out.println(rec.getTimeFrom());
                System.out.println(rec.getTimeTo());
                System.out.println(rec.getTitle());
                System.out.println(rec.getTotalSalary());
                System.out.println(rec.getType());
                System.out.println(rec.getWage());
                System.out.println("****************");

            }

        }

    }
}
