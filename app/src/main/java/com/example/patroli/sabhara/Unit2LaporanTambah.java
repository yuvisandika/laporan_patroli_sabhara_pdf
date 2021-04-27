package com.example.patroli.sabhara;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;
import java.util.HashMap;

public class Unit2LaporanTambah extends AppCompatActivity {

    DatabaseReference ref;

    EditText txt_tgl;
    Button btn_tgl,btn_upload;
    DatePickerDialog.OnDateSetListener setListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit2_laporan_tambah);

        //reverensi database
        ref = FirebaseDatabase.getInstance().getReference().child("Laporan").child("Unit2");

        //popup
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int)(width*.9),(int)(height*.2));
        //-----

        //date picker
        txt_tgl = findViewById(R.id.txt_tgl);
        btn_tgl = findViewById(R.id.btn_tgl);

        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        btn_tgl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        Unit2LaporanTambah.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth
                        ,setListener,year,month,day);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });

        setListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {

                month = month+1;
                String date = day+"/"+month+"/"+year;
                txt_tgl.setText(date);
            }
        };

        //btn upload
        btn_upload = findViewById(R.id.btn_upload);
        btn_upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //cheker tidak boleh kosong
                if (TextUtils.isEmpty(txt_tgl.getText().toString())) {
                    Toast.makeText(Unit2LaporanTambah.this, "Silahkan Pilih Tanggal", Toast.LENGTH_SHORT).show();
                }
                //upload
                else {
                    final String tanggal = txt_tgl.getText().toString();
                    if (tanggal != null) {
                        uplaod(tanggal);
                    }
                }
            }
        });
    }
    //metod upload
    private void uplaod(String tanggal) {
        final String key = ref.push().getKey();

        //progress dialog
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Data Sedang Di Upload . . . . ");
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();

        HashMap hashMap = new HashMap();
        hashMap.put("tanggal", tanggal);

        hashMap.put("jam1","");
        hashMap.put("kejadian1","");
        hashMap.put("uraian1","");
        hashMap.put("tindakan1","");
        hashMap.put("keterangan1","");

        hashMap.put("jam2","");
        hashMap.put("kejadian2","");
        hashMap.put("uraian2","");
        hashMap.put("tindakan2","");
        hashMap.put("keterangan2","");

        ref.child(key).setValue(hashMap).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                progressDialog.dismiss();
                Unit2LaporanTambah.super.onBackPressed();
                Toast.makeText(Unit2LaporanTambah.this, "Laporan Berhasil Dibuat", Toast.LENGTH_SHORT).show();

            }
        });

    }
}