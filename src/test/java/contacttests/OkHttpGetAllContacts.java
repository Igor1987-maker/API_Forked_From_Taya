package contacttests;

import com.google.gson.Gson;
import contactdto.ContactDto;
import contactdto.GetAllContactDto;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class OkHttpGetAllContacts {

    @Test
    public void getAllContacts() throws IOException {
        Gson gson = new Gson();
        OkHttpClient client = new OkHttpClient();
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbWFpbCI6ImExQGIxLnJ1In0.FEqOOsgttA-jTNjFR9bmq3Dv1CqJ0NOh_IZ7jXVO77Y";

        Request request = new Request.Builder()
                .url("https://contacts-telran.herokuapp.com/api/contact")
                .addHeader("Authorization",token)
                .build();

        Response response = client.newCall(request).execute();

        Assert.assertTrue(response.isSuccessful());

        if(response.isSuccessful()){
            GetAllContactDto contacts = gson.fromJson(response.body().string(),GetAllContactDto.class);

            for (ContactDto contact:contacts.getContacts()){
                System.out.println(contact.getId());
                System.out.println(contact.getEmail());
                System.out.println("****************");

            }

        }

    }
}
