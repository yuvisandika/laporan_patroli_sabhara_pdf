package com.example.patroli.sabhara;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
import com.squareup.picasso.Picasso;

public class AdminAnggota1 extends AppCompatActivity {

    FloatingActionButton ft_unittambah,ft_unitdel;

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    //firebase
    DatabaseReference ref;
    FirebaseRecyclerOptions<AdapterAnggota> optionsUnit;
    FirebaseRecyclerAdapter<AdapterAnggota,ViewHolderAnggota> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_anggota1);

        //recyclerview--------
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setHasFixedSize(true);
        //layout manager recyclerview dalam bentuk grid view
        layoutManager=new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        //--------------------------------------

        ref = FirebaseDatabase.getInstance().getReference().child("Anggota").child("Unit1");


        ft_unittambah = findViewById(R.id.ft_unittambah);
        ft_unittambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminAnggota1.this,AdminAnggota1Tambah.class);
                startActivity(intent);
            }
        });

        ft_unitdel = findViewById(R.id.ft_unitdel);
        ft_unitdel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HapusData();
            }
        });


        LoadData(); //variabel load data from firebase

    }
    private void LoadData() {

        optionsUnit=new FirebaseRecyclerOptions.Builder<AdapterAnggota>().setQuery(ref, AdapterAnggota.class).build();
        adapter=new FirebaseRecyclerAdapter<AdapterAnggota, ViewHolderAnggota>(optionsUnit) {
            @Override
            protected void onBindViewHolder(@NonNull final ViewHolderAnggota holder, final int position, @NonNull AdapterAnggota model) {
                holder.txtunitnama.setText(model.getNama());
                holder.txtunitjabatan.setText(model.getJabatan());
                Picasso.get().load(model.getImageUrl()).into(holder.imgunit);
            }
            @NonNull
            @Override
            public ViewHolderAnggota onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_unit,parent,false);
                return new ViewHolderAnggota(v);
            }
        };
        adapter.startListening();
        recyclerView.setAdapter(adapter);
    }

    private void HapusData() {

        optionsUnit=new FirebaseRecyclerOptions.Builder<AdapterAnggota>().setQuery(ref, AdapterAnggota.class).build();
        adapter=new FirebaseRecyclerAdapter<AdapterAnggota, ViewHolderAnggota>(optionsUnit) {
            @Override
            protected void onBindViewHolder(@NonNull final ViewHolderAnggota holder, final int position, @NonNull AdapterAnggota model) {
                holder.txtunitnama.setText(model.getNama());
                holder.txtunitjabatan.setText(model.getJabatan());
                Picasso.get().load(model.getImageUrl()).into(holder.imgunit);

                holder.btn_rowdel.setVisibility(View.VISIBLE);
                holder.btn_rowdel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        AlertDialog.Builder builder=new AlertDialog.Builder(holder.imgunit.getContext());
                        builder.setTitle("Delet");
                        builder.setMessage("Delete....");

                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                FirebaseDatabase.getInstance().getReference().child("Anggota").child("Unit1").child(getRef(position).getKey()).removeValue();

                                Intent intent = new Intent(AdminAnggota1.this,AdminAnggota1.class);
                                Toast.makeText(AdminAnggota1.this, "Data Berhasi Dihapus", Toast.LENGTH_SHORT).show();
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
            public ViewHolderAnggota onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_unit,parent,false);
                return new ViewHolderAnggota(v);
            }
        };
        adapter.startListening();
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(AdminAnggota1.this, AdminAnggotaMain.class);
        startActivity(intent);
        finish();
    }
}