package com.example.android.mumenproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ConnexionActivity extends AppCompatActivity {

    private static final  String TAG = "ConnexionActivity";

    LinearLayout suivant;
    Button creation;
    String URL = "http://192.168.0.18:8000";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);

        suivant = findViewById(R.id.connexion);
        creation = findViewById(R.id.compt);


        suivant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText = (EditText) findViewById(R.id.email);
                String email = editText.getText().toString();

                EditText editText1 =(EditText) findViewById(R.id.password);
                String password = editText1.getText().toString();


                if(email.length() > 0 & password.length() > 0) {

                    Test(email, password);

                    /*Intent pro = new Intent(view.getContext(), ProfileActivity.class);

                    pro.putExtra("email", email);

                    startActivity(pro);*/

                }
            }
        });
        creation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent creation = new Intent(view.getContext(), CommandeActivity.class);
                startActivity(creation);
            }
        });
    }

    private void Test (String email, String password){

        MediaType MEDIA_TYPE = MediaType.parse("application/json");
        final TextView text = findViewById(R.id.text);

        JSONArray role = new JSONArray();
        role.put("user");


        JSONObject user = new JSONObject();
        try {
            user.put("username", "komomi");
            user.put("email", email);
            user.put("password", password);
            user.put("role", role);
        }catch (JSONException e) {
            e.printStackTrace();
        }

        RequestBody body = RequestBody.create(MEDIA_TYPE, user.toString());

       OkHttpClient client = new OkHttpClient.Builder()
               .build();
       Request request = new Request.Builder()
               .url(URL +"/api/auth/signup")
               .post(body)
               .build();
       try {
           client.newCall(request).enqueue(new Callback() {
               @Override
               public void onFailure(@NotNull Call call, @NotNull IOException e) {
                   Log.i("Failure request search", e.getMessage());
                   text.setText(" la raiponse n'est pas");
               }

               @Override
               public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                   text.setText(" oui");
               }
           });


       }
       catch (Exception e) {
           text.setText(" nop");
           Log.v(TAG,"Erreur reseau"+e);

       }
    }
}