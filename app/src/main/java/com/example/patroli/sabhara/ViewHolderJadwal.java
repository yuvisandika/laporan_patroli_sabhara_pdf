package com.example.patroli.sabhara;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolderJadwal extends RecyclerView.ViewHolder {

    TextView rowhari,
            rowtgl,
            rowunit1, rowmulai1, rowsampai1,
            rowunit2, rowmulai2, rowsampai2,
            rowunit3, rowmulai3, rowsampai3,
            rowunit4, rowmulai4, rowsampai4;

    Button btn_rowjadwaldel;

    View v;

    public ViewHolderJadwal(@NonNull View itemView) {
        super(itemView);

        rowhari = itemView.findViewById(R.id.rowhari);
        rowtgl = itemView.findViewById(R.id.rowtgl);

        rowunit1 = itemView.findViewById(R.id.rowunit1);
        rowunit2 = itemView.findViewById(R.id.rowunit2);
        rowunit3 = itemView.findViewById(R.id.rowunit3);
        rowunit4 = itemView.findViewById(R.id.rowunit4);

        rowmulai1 = itemView.findViewById(R.id.rowmulai1);
        rowmulai2 = itemView.findViewById(R.id.rowmulai2);
        rowmulai3 = itemView.findViewById(R.id.rowmulai3);
        rowmulai4 = itemView.findViewById(R.id.rowmulai4);

        rowsampai1 = itemView.findViewById(R.id.sampai1);
        rowsampai2 = itemView.findViewById(R.id.sampai2);
        rowsampai3 = itemView.findViewById(R.id.sampai3);
        rowsampai4 = itemView.findViewById(R.id.sampai4);

        btn_rowjadwaldel = itemView.findViewById(R.id.btn_row_jadwaldel);

        v = itemView;

    }
}
