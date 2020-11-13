package com.example.android.mumenproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ProfileActivity extends MainActivity {

    private String name, email;
    Button menu;
    Button deco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        menu = findViewById(R.id.Com);
        deco = findViewById(R.id.deco);

        Intent connexion = getIntent();
        if(connexion != null){
            if(connexion.hasExtra("email")){
                email = connexion.getStringExtra("email");
            }
        }

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                transferDonnées(view);
            }
        });
        deco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MainActivity.class);
                startActivity(intent);
            }
        });

    }

    public void transferDonnées(View view){
        String connecte = email;

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("Connect", connecte);

        startActivity(intent);
    }



}

