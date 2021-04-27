package com.example.patroli.sabhara;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.annotations.NotNull;

public class ViewHolderLaporan extends RecyclerView.ViewHolder {

    TextView row_tgl;

    Button row_btndel, row_btnedit;
    View v;

    public ViewHolderLaporan(@NotNull View itemView){
        super(itemView);

        row_tgl=itemView.findViewById(R.id.row_tgl);

        row_btndel=itemView.findViewById(R.id.row_btndel);
        row_btnedit=itemView.findViewById(R.id.row_btnedit);

        v=itemView;
    }

}
