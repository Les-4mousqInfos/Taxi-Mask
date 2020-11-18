package com.example.android.mumenproject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ConnexionActivity extends AppCompatActivity {

    LinearLayout suivant;
    Button creation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);

        suivant = findViewById(R.id.connexion);
        creation = findViewById(R.id.compt);


        suivant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Connexion(view);
            }
        });
        creation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Creation(view);
            }
        });
    }

    private void Connexion(View view){

        EditText editText = (EditText) findViewById(R.id.email);
        String email = editText.getText().toString();

        EditText editText1 =(EditText) findViewById(R.id.password);
        String password = editText1.getText().toString();

        if(email.length() > 0 & password.length() > 0) {

            Intent pro = new Intent(view.getContext(), ProfileActivity.class);

            pro.putExtra("email", email);

            startActivity(pro);
        }
    }

    private void Creation(View view){
        Intent creation = new Intent(view.getContext(), CommandeActivity.class);
        startActivity(creation);
    }
}