package com.example.patroli.sabhara;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;
import java.util.HashMap;

public class AdminJadwalTambah extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private EditText txthari,
            txtmulai1, txtsampai1,
            txtmulai2, txtsampai2,
            txtmulai3, txtsampai3,
            txtmulai4, txtsampai4;

    //spinner
    private Spinner spinnerhari, spinner1, spinner2, spinner3, spinner4;
    private String item;
    MSpinner mspinner;
    TextView sptxthari, sptxtu1, sptxtu2, sptxtu3, sptxtu4;
    String[] unit = {" ", "Unit 1", "Unit 2", "Unit 3", "Unit 4", "Unit 5", "Unit 6"};
    String[] hari = {"Pilih Hari", "SENIN", "SELASA", "RABU", "KAMIS", "JUMAT", "SABTU", "MINGGU"};

    //---------------------

    private Button btn_upload;

    TimePickerDialog timePickerDialog;

    DatePickerDialog.OnDateSetListener setListener;
    EditText txt_tgl;
    Button btn_tgl;

    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_jadwal_tambah);

        //reverensi database
        ref = FirebaseDatabase.getInstance().getReference().child("Jadwal");

        sptxthari = findViewById(R.id.sptxthari);



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
                        AdminJadwalTambah.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth
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

        //mulai-------------------------------------------------
        txtmulai1 = findViewById(R.id.mulai1);
        txtmulai1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timePickerDialog = new TimePickerDialog(AdminJadwalTambah.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minutes) {

                        txtmulai1.setText(String.format("%02d:%02d", hourOfDay, minutes));
                    }
                }, 0, 0, true);
                timePickerDialog.show();
            }
        });

        //2
        txtmulai2 = findViewById(R.id.mulai2);
        txtmulai2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timePickerDialog = new TimePickerDialog(AdminJadwalTambah.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minutes) {
                        txtmulai2.setText(String.format("%02d:%02d", hourOfDay, minutes));
                    }
                }, 0, 0, true);
                timePickerDialog.show();
            }
        });
        //3
        txtmulai3 = findViewById(R.id.mulai3);
        txtmulai3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timePickerDialog = new TimePickerDialog(AdminJadwalTambah.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minutes) {
                        txtmulai3.setText(String.format("%02d:%02d", hourOfDay, minutes));
                    }
                }, 0, 0, true);
                timePickerDialog.show();
            }
        });
        //4
        txtmulai4 = findViewById(R.id.mulai4);
        txtmulai4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timePickerDialog = new TimePickerDialog(AdminJadwalTambah.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minutes) {
                        txtmulai4.setText(String.format("%02d:%02d", hourOfDay, minutes));
                    }
                }, 0, 0, true);
                timePickerDialog.show();
            }
        });

        //sampai----------------------------------------
        txtsampai1 = findViewById(R.id.sampai1);
        txtsampai1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timePickerDialog = new TimePickerDialog(AdminJadwalTambah.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minutes) {
                        txtsampai1.setText(String.format("%02d:%02d", hourOfDay, minutes));
                    }
                }, 0, 0, true);
                timePickerDialog.show();
            }
        });
        //2
        txtsampai2 = findViewById(R.id.sampai2);
        txtsampai2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timePickerDialog = new TimePickerDialog(AdminJadwalTambah.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minutes) {
                        txtsampai2.setText(String.format("%02d:%02d", hourOfDay, minutes));
                    }
                }, 0, 0, true);
                timePickerDialog.show();
            }
        });
        //3
        txtsampai3 = findViewById(R.id.sampai3);
        txtsampai3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timePickerDialog = new TimePickerDialog(AdminJadwalTambah.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minutes) {
                        txtsampai3.setText(String.format("%02d:%02d", hourOfDay, minutes));
                    }
                }, 0, 0, true);
                timePickerDialog.show();
            }
        });
        //4
        txtsampai4 = findViewById(R.id.sampai4);
        txtsampai4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timePickerDialog = new TimePickerDialog(AdminJadwalTambah.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minutes) {
                        txtsampai4.setText(String.format("%02d:%02d", hourOfDay, minutes));
                    }
                }, 0, 0, true);
                timePickerDialog.show();
            }
        });



        //spinner--------------------------------------------
        spinnerhari = findViewById(R.id.sp_hari);
        spinner1 = findViewById(R.id.sp_unit1);
        spinner2 = findViewById(R.id.sp_unit2);
        spinner3 = findViewById(R.id.sp_unit3);
        spinner4 = findViewById(R.id.sp_unit4);

        spinner1.setOnItemSelectedListener(this);
        spinner2.setOnItemSelectedListener(this);
        spinner3.setOnItemSelectedListener(this);
        spinner4.setOnItemSelectedListener(this);

        mspinner = new MSpinner();
        ArrayAdapter arrayAdapter1 = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, hari);
        arrayAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, unit);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerhari.setAdapter(arrayAdapter1);

        spinner1.setAdapter(arrayAdapter);
        spinner2.setAdapter(arrayAdapter);
        spinner3.setAdapter(arrayAdapter);
        spinner4.setAdapter(arrayAdapter);

        sptxthari = findViewById(R.id.sptxthari);

        sptxtu1 = findViewById(R.id.sptxtu1);
        sptxtu2 = findViewById(R.id.sptxtu2);
        sptxtu3 = findViewById(R.id.sptxtu3);
        sptxtu4 = findViewById(R.id.sptxtu4);
        //------------


        btn_upload = findViewById(R.id.btn_uploadjadwal);
        btn_upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String hari = sptxthari.getText().toString();
                final String tanggal = txt_tgl.getText().toString();

                final String unit1 = sptxtu1.getText().toString();
                final String unit2 = sptxtu2.getText().toString();
                final String unit3 = sptxtu3.getText().toString();
                final String unit4 = sptxtu4.getText().toString();

                final String mulai1 = txtmulai1.getText().toString();
                final String mulai2 = txtmulai2.getText().toString();
                final String mulai3 = txtmulai3.getText().toString();
                final String mulai4 = txtmulai4.getText().toString();

                final String sampai1 = txtsampai1.getText().toString();
                final String sampai2 = txtsampai2.getText().toString();
                final String sampai3 = txtsampai3.getText().toString();
                final String sampai4 = txtsampai4.getText().toString();

                if (hari != null && tanggal != null &&
                        unit1 != null && mulai1 != null && sampai1 != null &&
                        unit2 != null && mulai2 != null && sampai2 != null &&
                        unit3 != null && mulai3 != null && sampai3 != null &&
                        unit4 != null && mulai4 != null && sampai4 != null) {
                    upload(hari, tanggal,
                            unit1, mulai1, sampai1,
                            unit2, mulai2, sampai2,
                            unit3, mulai3, sampai3,
                            unit4, mulai4, sampai4);

                }


            }
        });


    }

    private void upload(String hari, String tanggal,
                        String unit1, String mulai1, String sampai1,
                        String unit2, String mulai2, String sampai2,
                        String unit3, String mulai3, String sampai3,
                        String unit4, String mulai4, String sampai4) {

        final String key = ref.push().getKey();


        //progress dialog
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Data Sedang Di Upload . . . . ");
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();

        HashMap hashMap = new HashMap();
        hashMap.put("hari", hari);
        hashMap.put("tanggal", tanggal);

        hashMap.put("unit1", unit1);
        hashMap.put("mulai1", mulai1);
        hashMap.put("sampai1", sampai1);

        hashMap.put("unit2", unit2);
        hashMap.put("mulai2", mulai2);
        hashMap.put("sampai2", sampai2);

        hashMap.put("unit3", unit3);
        hashMap.put("mulai3", mulai3);
        hashMap.put("sampai3", sampai3);

        hashMap.put("unit4", unit4);
        hashMap.put("mulai4", mulai4);
        hashMap.put("sampai4", sampai4);


        ref.child(key).setValue(hashMap).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                progressDialog.dismiss();
                startActivity(new Intent(getApplicationContext(), AdminJadwal.class));
                Toast.makeText(AdminJadwalTambah.this, "Upload Sukses", Toast.LENGTH_SHORT).show();

            }
        });

    }


    //spinner--------------------------------
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        item = spinnerhari.getSelectedItem().toString();
        sptxthari.setText(item);

        item = spinner1.getSelectedItem().toString();
        sptxtu1.setText(item);

        item = spinner2.getSelectedItem().toString();
        sptxtu2.setText(item);

        item = spinner3.getSelectedItem().toString();
        sptxtu3.setText(item);

        item = spinner4.getSelectedItem().toString();
        sptxtu4.setText(item);

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}