package com.example.patroli.sabhara;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
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

public class JadwalActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    //firebase
    DatabaseReference ref;
    FirebaseRecyclerOptions<AdapterJadwal> optionsjadwal;
    FirebaseRecyclerAdapter<AdapterJadwal, ViewHolderJadwal> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jadwal);

        //recyclerview--------
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setHasFixedSize(true);
        //--------------------------------------

        ref = FirebaseDatabase.getInstance().getReference().child("Jadwal");

        LoadData(); //variabel load data from firebase


    }

    //metod load data dari firebase
    private void LoadData() {

        optionsjadwal = new FirebaseRecyclerOptions.Builder<AdapterJadwal>().setQuery(ref, AdapterJadwal.class).build();
        adapter = new FirebaseRecyclerAdapter<AdapterJadwal, ViewHolderJadwal>(optionsjadwal) {
            @Override
            protected void onBindViewHolder(@NonNull final ViewHolderJadwal holder, final int position, @NonNull AdapterJadwal model) {
                holder.rowhari.setText(model.getHari());
                holder.rowtgl.setText(model.getTanggal());

                holder.rowunit1.setText(model.getUnit1());
                holder.rowunit2.setText(model.getUnit2());
                holder.rowunit3.setText(model.getUnit3());
                holder.rowunit4.setText(model.getUnit4());

                holder.rowmulai1.setText(model.getMulai1());
                holder.rowmulai2.setText(model.getMulai2());
                holder.rowmulai3.setText(model.getMulai3());
                holder.rowmulai4.setText(model.getMulai4());


                holder.rowsampai1.setText(model.getSampai1());
                holder.rowsampai2.setText(model.getSampai2());
                holder.rowsampai3.setText(model.getSampai3());
                holder.rowsampai4.setText(model.getSampai4());

            }

            @NonNull
            @Override
            public ViewHolderJadwal onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_jadwal, parent, false);
                return new ViewHolderJadwal(v);
            }
        };
        adapter.startListening();
        recyclerView.setAdapter(adapter);
    }
}