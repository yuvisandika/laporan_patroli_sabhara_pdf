package com.example.patroli.sabhara;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.HashMap;

public class Unit1LaporanIsi extends AppCompatActivity {

    TextView txt_tgl;//tanggal
    //fild isi
    EditText et_kejadian,et_uraian,et_tindakan,et_ket; //halaman 1
    EditText et_kejadian2,et_uraian2,et_tindakan2,et_ket2; //halaman 2

    //jam
    EditText et_jam,et_jam2;
    Button btn_jam,btn_jam2;
    TimePickerDialog timePickerDialog;


    DatabaseReference ref; //referensi menampilkan data
    DatabaseReference DataRef; //referensi mengubah data (btn upload)
    Button btn_upload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit1_laporan_isi);

        txt_tgl = findViewById(R.id.txt_tgl);

        //edittext kejadian 1
        et_kejadian = findViewById(R.id.et_kejadian);
        et_uraian = findViewById(R.id.et_uraian);
        et_tindakan = findViewById(R.id.et_tindakan);
        et_ket = findViewById(R.id.et_ket);

        //edittext kejadian 2
        et_kejadian2 = findViewById(R.id.et_kejadian2);
        et_uraian2 = findViewById(R.id.et_uraian2);
        et_tindakan2 = findViewById(R.id.et_tindakan2);
        et_ket2 = findViewById(R.id.et_ket2);


        //jam menggunakan timepicker
        //jam 1
        et_jam = findViewById(R.id.et_jam);
        btn_jam = findViewById(R.id.btn_jam);
        btn_jam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timePickerDialog = new TimePickerDialog(Unit1LaporanIsi.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minutes) {
                        String amPm;
                        if (hourOfDay >= 24) {
                            amPm = "";
                        } else {
                            amPm = "";
                        }
                        et_jam.setText(String.format("%02d:%02d", hourOfDay, minutes));
                        ;
                    }
                }, 0, 0, true);
                timePickerDialog.show();
            }
        });
        //jam 2
        et_jam2 = findViewById(R.id.et_jam2);
        btn_jam2 = findViewById(R.id.btn_jam2);
        btn_jam2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timePickerDialog = new TimePickerDialog(Unit1LaporanIsi.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minutes) {
                        String amPm;
                        if (hourOfDay >= 24) {
                            amPm = "";
                        } else {
                            amPm = "";
                        }
                        et_jam2.setText(String.format("%02d:%02d", hourOfDay, minutes));
                        ;
                    }
                }, 0, 0, true);
                timePickerDialog.show();
            }
        });



        final String LaporanKey = getIntent().getStringExtra("LaporanKey");

        ref = FirebaseDatabase.getInstance().getReference().child("Laporan").child("Unit1");
        DataRef = FirebaseDatabase.getInstance().getReference().child("Laporan").child("Unit1").child(LaporanKey);

        ref.child(LaporanKey).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists())
                {
                    //memanggil data dari database
                    String tanggal = dataSnapshot.child("tanggal").getValue().toString();

                    String jam1 = dataSnapshot.child("jam1").getValue().toString();
                    String kejadian1 = dataSnapshot.child("kejadian1").getValue().toString();
                    String uraian1 = dataSnapshot.child("uraian1").getValue().toString();
                    String tindakan1 = dataSnapshot.child("tindakan1").getValue().toString();
                    String keterangan1 = dataSnapshot.child("keterangan1").getValue().toString();

                    String jam2 = dataSnapshot.child("jam2").getValue().toString();
                    String kejadian2 = dataSnapshot.child("kejadian2").getValue().toString();
                    String uraian2 = dataSnapshot.child("uraian2").getValue().toString();
                    String tindakan2 = dataSnapshot.child("tindakan2").getValue().toString();
                    String keterangan2 = dataSnapshot.child("keterangan2").getValue().toString();

                    //implementation / meletakan data ke dalam edit text
                    txt_tgl.setText(tanggal);
                    //kejadian 1
                    et_jam.setText(jam1);
                    et_kejadian.setText(kejadian1);
                    et_uraian.setText(uraian1);
                    et_tindakan.setText(tindakan1);
                    et_ket.setText(keterangan1);
                    //kejadian 2
                    et_jam2.setText(jam2);
                    et_kejadian2.setText(kejadian2);
                    et_uraian2.setText(uraian2);
                    et_tindakan2.setText(tindakan2);
                    et_ket2.setText(keterangan2);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        //button isi data
        btn_upload = findViewById(R.id.btn_upload);
        btn_upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //menelakan kembali data


                HashMap map = new HashMap();
                //halaman 1
                map.put("jam1",et_jam.getText().toString());
                map.put("kejadian1",et_kejadian.getText().toString());
                map.put("uraian1",et_uraian.getText().toString());
                map.put("tindakan1",et_tindakan.getText().toString());
                map.put("keterangan1",et_ket.getText().toString());
                //halaman 2
                map.put("jam2",et_jam2.getText().toString());
                map.put("kejadian2",et_kejadian2.getText().toString());
                map.put("uraian2",et_uraian2.getText().toString());
                map.put("tindakan2",et_tindakan2.getText().toString());
                map.put("keterangan2",et_ket2.getText().toString());

                DataRef.updateChildren(map).addOnSuccessListener(new OnSuccessListener() {
                    @Override
                    public void onSuccess(Object o) {

                    }
                });
                Toast.makeText(Unit1LaporanIsi.this, "Data Berhasil Diisi", Toast.LENGTH_LONG).show();


            }
        });

    }
}