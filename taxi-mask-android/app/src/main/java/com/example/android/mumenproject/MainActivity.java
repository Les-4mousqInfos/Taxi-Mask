package com.example.android.mumenproject;

import androidx.appcompat.app.AppCompatActivity;
import com.example.android.mumenproject.ProfileActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    LinearLayout btn;
    LinearLayout connexion;
    String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


         btn = findViewById(R.id.circle);
         connexion = findViewById(R.id.connexion);


         btn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Commande(view);
             }
         });

         connexion.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Profile(view);
             }
         });
    }

    private void Commande (View view){
        Email();
        if(email == null){
            Intent co = new Intent(view.getContext(), ConnexionActivity.class);
            startActivity(co);
        }
        else {
            Intent commande2 = new Intent(view.getContext(), Commande2Activity.class);
            startActivity(commande2);
        }
    }

    private void Email(){
        Intent connex = getIntent();
        if(connex != null){
            email = connex.getStringExtra("Connect");
        }
        else {
            email = null;
        }
    }

    private void Profile (View view){
        Email();
        if (email != null){
            Intent pro = new Intent(view.getContext(), ProfileActivity.class);
            pro.putExtra("email", email);
            startActivity(pro);
        }
        else {
            Intent co = new Intent(view.getContext(), ConnexionActivity.class);
            startActivity(co);
        }
    }


}