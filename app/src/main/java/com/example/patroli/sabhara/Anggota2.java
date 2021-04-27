package com.example.patroli.sabhara;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class Anggota2 extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    //firebase
    DatabaseReference ref;
    FirebaseRecyclerOptions<AdapterAnggota> optionsUnit;
    FirebaseRecyclerAdapter<AdapterAnggota,ViewHolderAnggota> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anggota2);

        //recyclerview--------
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setHasFixedSize(true);
        //layout manager recyclerview dalam bentuk grid view
        layoutManager=new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        //--------------------------------------

        ref = FirebaseDatabase.getInstance().getReference().child("Anggota").child("Unit2");
        LoadData();
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
}