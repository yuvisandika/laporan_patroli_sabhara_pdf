package com.example.patroli.sabhara;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AnggotaMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anggota_main);

        //unit1
        CardView c1 = findViewById(R.id.unit1);
        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AnggotaMain.this, Anggota1.class);
                startActivity(intent);
            }
        });
        //unit2
        CardView c2 = findViewById(R.id.unit2);
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AnggotaMain.this, Anggota2.class);
                startActivity(intent);
            }
        });
        //unit3
        CardView c3 = findViewById(R.id.unit3);
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AnggotaMain.this, Anggota3.class);
                startActivity(intent);
            }
        });
        //unit4
        CardView c4 = findViewById(R.id.unit4);
        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AnggotaMain.this, Anggota4.class);
                startActivity(intent);
            }
        });
        //unit5
        CardView c5 = findViewById(R.id.unit5);
        c5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AnggotaMain.this, Anggota5.class);
                startActivity(intent);
            }
        });
        //unit6
        CardView c6 = findViewById(R.id.unit6);
        c6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AnggotaMain.this, Anggota6.class);
                startActivity(intent);
            }
        });

    }
}