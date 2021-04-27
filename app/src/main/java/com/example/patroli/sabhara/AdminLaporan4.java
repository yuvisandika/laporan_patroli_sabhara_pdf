package com.example.patroli.sabhara;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.storage.FirebaseStorage;

public class AdminLaporan4 extends AppCompatActivity {

    FloatingActionButton ft_btnadd, ft_btndel;

    RecyclerView recyclerView;
    FirebaseRecyclerOptions<AdapterLaporan> optionsLaporan;
    FirebaseRecyclerAdapter<AdapterLaporan, ViewHolderLaporan> adapter;

    DatabaseReference ref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_laporan4);

        ref = FirebaseDatabase.getInstance().getReference().child("Laporan").child("Unit4");
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        //floating button tambah
        ft_btnadd = findViewById(R.id.ft_btnadd);
        ft_btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminLaporan4.this, Unit4LaporanTambah.class);
                startActivity(intent);
            }
        });

        //floating button hapus
        ft_btndel = findViewById(R.id.ft_btndel);
        ft_btndel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HapusData("");
            }
        });

        //variabel untuk memanggil data
        LoadData("");

    }
    // metod untuk memanggil data
    private void LoadData(String data) {
        //progress dialog
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Sedang Memuat Data . . . . ");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();

        Query query = ref.orderByChild("tanggal").startAt(data).endAt(data + "\uf8ff");//mengurutkan data berdasatkan tgl
        optionsLaporan = new FirebaseRecyclerOptions.Builder<AdapterLaporan>().setQuery(query, AdapterLaporan.class).build();
        adapter = new FirebaseRecyclerAdapter<AdapterLaporan, ViewHolderLaporan>(optionsLaporan) {
            @Override
            protected void onBindViewHolder(@NonNull final ViewHolderLaporan holder, final int position, @NonNull AdapterLaporan model) {

                holder.row_tgl.setText(model.getTanggal());// diambil dari ViewHolderLaporan dan tampilan dari row_laporan.xml

                holder.v.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(AdminLaporan4.this,Unit4LaporanIsi.class);
                        intent.putExtra("LaporanKey",getRef(position).getKey());
                        startActivity(intent);
                    }
                });


            }

            @NonNull
            @Override
            public ViewHolderLaporan onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                progressDialog.dismiss();
                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_laporan, parent, false);
                return new ViewHolderLaporan(v);
            }
        };
        adapter.startListening();
        recyclerView.setAdapter(adapter);
    }

    // metod untuk menghapus data
    private void HapusData(String data) {
        //progress dialog
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Sedang Memuat Data . . . . ");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();

        Query query = ref.orderByChild("tanggal").startAt(data).endAt(data + "\uf8ff");//mengurutkan data berdasatkan tgl
        optionsLaporan = new FirebaseRecyclerOptions.Builder<AdapterLaporan>().setQuery(query, AdapterLaporan.class).build();
        adapter = new FirebaseRecyclerAdapter<AdapterLaporan, ViewHolderLaporan>(optionsLaporan) {
            @Override
            protected void onBindViewHolder(@NonNull final ViewHolderLaporan holder, final int position, @NonNull AdapterLaporan model) {

                holder.row_tgl.setText(model.getTanggal());// diambil dari ViewHolderLaporan dan tampilan dari row_laporan.xml

                holder.row_btndel.setVisibility(View.VISIBLE);//diambil dari row
                holder.row_btndel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        AlertDialog.Builder builder=new AlertDialog.Builder(holder.row_tgl.getContext());
                        builder.setTitle("Delet");
                        builder.setMessage("Delete....");

                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                FirebaseDatabase.getInstance().getReference().child("Laporan").child("Unit4").child(getRef(position).getKey()).removeValue();

                                Intent intent = new Intent(AdminLaporan4.this,AdminLaporan4.class);
                                Toast.makeText(AdminLaporan4.this, "Data Berhasi Dihapus", Toast.LENGTH_SHORT).show();
                                startActivity(intent);
                                finish();
                            }
                        });
                        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });
                        builder.show();

                    }
                });
            }

            @NonNull
            @Override
            public ViewHolderLaporan onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                progressDialog.dismiss();
                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_laporan, parent, false);
                return new ViewHolderLaporan(v);
            }
        };
        adapter.startListening();
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(AdminLaporan4.this, AdminLaporanMain.class);
        startActivity(intent);
        finish();
    }
}