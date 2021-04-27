package com.example.patroli.sabhara;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolderAnggota extends RecyclerView.ViewHolder {

    ImageView imgunit;
    TextView txtunitnama,txtunitjabatan;
    Button btn_rowdel;

    View v;

    public ViewHolderAnggota(@NonNull View itemView) {
        super(itemView);

        imgunit = itemView.findViewById(R.id.imgunit);
        txtunitnama = itemView.findViewById(R.id.txtunitnama);
        txtunitjabatan = itemView.findViewById(R.id.txtunitjabatan);

        btn_rowdel = itemView.findViewById(R.id.btn_rowdel);

        v=itemView;
    }
}
