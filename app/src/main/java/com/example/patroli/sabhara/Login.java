package com.example.patroli.sabhara;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Login extends AppCompatActivity {

    EditText id, pw;//id edittext username dan password

    DatabaseReference refAdmin; //ref admin
    String idadmin,pwadmin;
    DatabaseReference refU1;//ref unit 1
    String idu1,pwu1;
    DatabaseReference refU2;//ref unit 2
    String idu2,pwu2;
    DatabaseReference refU3;//ref unit 3
    String idu3,pwu3;
    DatabaseReference refU4;//ref unit 4
    String idu4,pwu4;
    DatabaseReference refU5;//ref unit 5
    String idu5,pwu5;
    DatabaseReference refU6;//ref unit 6
    String idu6,pwu6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        id = findViewById(R.id.login_id);
        pw = findViewById(R.id.login_pw);

        //memanggil id dan password admin dari database
        refAdmin = FirebaseDatabase.getInstance().getReference().child("Auth").child("Admin");
        refAdmin.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //memanggil data dari database
                idadmin = dataSnapshot.child("username").getValue().toString();
                pwadmin = dataSnapshot.child("password").getValue().toString();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        //memanggil id dan password unit 1
        refU1 = FirebaseDatabase.getInstance().getReference().child("Auth").child("Unit").child("Unit1");
        refU1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //memanggil data dari database
                idu1 = dataSnapshot.child("username").getValue().toString();
                pwu1 = dataSnapshot.child("password").getValue().toString();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        //memanggil id dan password unit 2
        refU2 = FirebaseDatabase.getInstance().getReference().child("Auth").child("Unit").child("Unit2");
        refU2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //memanggil data dari database
                idu2 = dataSnapshot.child("username").getValue().toString();
                pwu2 = dataSnapshot.child("password").getValue().toString();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        //memanggil id dan password unit 3
        refU3 = FirebaseDatabase.getInstance().getReference().child("Auth").child("Unit").child("Unit3");
        refU3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //memanggil data dari database
                idu3 = dataSnapshot.child("username").getValue().toString();
                pwu3 = dataSnapshot.child("password").getValue().toString();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        //memanggil id dan password unit 4
        refU4 = FirebaseDatabase.getInstance().getReference().child("Auth").child("Unit").child("Unit4");
        refU4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //memanggil data dari database
                idu4 = dataSnapshot.child("username").getValue().toString();
                pwu4 = dataSnapshot.child("password").getValue().toString();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        //memanggil id dan password unit 5
        refU5 = FirebaseDatabase.getInstance().getReference().child("Auth").child("Unit").child("Unit5");
        refU5.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //memanggil data dari database
                idu5 = dataSnapshot.child("username").getValue().toString();
                pwu5 = dataSnapshot.child("password").getValue().toString();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        //memanggil id dan password unit 6
        refU6 = FirebaseDatabase.getInstance().getReference().child("Auth").child("Unit").child("Unit6");
        refU6.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //memanggil data dari database
                idu6 = dataSnapshot.child("username").getValue().toString();
                pwu6= dataSnapshot.child("password").getValue().toString();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    //motod untuk login
    public void login(View view) {
        {
            //fil edittext
            String setid = id.getText().toString();
            String setpw = pw.getText().toString();
            //admin
            String adminid = idadmin; //<<<----- dipangil dari "idadmin = dataSnapshot.child("username").getValue().toString();"
            String adminpw = pwadmin;
            //unit 1
            String u1id = idu1;
            String u1pw = pwu1;
            //unit 2
            String u2id = idu2;
            String u2pw = pwu2;
            //unit 3
            String u3id = idu3;
            String u3pw = pwu3;
            //unit 4
            String u4id = idu4;
            String u4pw = pwu4;
            //unit 5
            String u5id = idu5;
            String u5pw = pwu5;
            //unit 6
            String u6id = idu6;
            String u6pw = pwu6;
            //validasi auth
            //admin
            if (setid.equals(adminid) && setpw.equals(adminpw)) {
                Intent intent = new Intent(Login.this, AdminHome.class);
                startActivity(intent);
            }
            //unit 1
            else if (setid.equals(u1id) && setpw.equals(u1pw)) {
                Intent intent = new Intent(Login.this, Unit1Home.class);
                startActivity(intent);
            }
            //unit 2
            else if (setid.equals(u2id) && setpw.equals(u2pw)) {
                Intent intent = new Intent(Login.this, Unit2Home.class);
                startActivity(intent);
            }
            //unit 3
            else if (setid.equals(u3id) && setpw.equals(u3pw)) {
                Intent intent = new Intent(Login.this, Unit3Home.class);
                startActivity(intent);
            }
            //unit 4
            else if (setid.equals(u4id) && setpw.equals(u4pw)) {
                Intent intent = new Intent(Login.this, Unit4Home.class);
                startActivity(intent);
            }
            //unit 5
            else if (setid.equals(u5id) && setpw.equals(u5pw)) {
                Intent intent = new Intent(Login.this, Unit5Home.class);
                startActivity(intent);
            }
            //unit 6
            else if (setid.equals(u6id) && setpw.equals(u6pw)) {
                Intent intent = new Intent(Login.this, Unit6Home.class);
                startActivity(intent);
            }
            //error cek
            else if (setid.equals("") || setpw.equals("")) {
                Toast.makeText(this, "HARAP MASUKAN ID DAN PASSWORD", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(this, "ID DAN PASSWORD SALAH", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onBackPressed() {

        new AlertDialog.Builder(this)
                .setTitle("EXIT")
                .setMessage("Kamu yakin ingin keluar?")
                .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finishAffinity();
                    }
                })
                .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                })
                .show();
    }
}