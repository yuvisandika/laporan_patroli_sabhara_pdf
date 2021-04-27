package com.example.patroli.sabhara;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.HashMap;

public class AdminAnggota4Tambah extends AppCompatActivity {
    private static final int REQUEST_CODE_IMAGE = 101;
    private ImageView imageadd;
    private EditText txtnama, txtjabatan;
    private Button btnupload;

    Uri imageUri;
    boolean isImageAdded;

    DatabaseReference ref;
    StorageReference sref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_anggota4_tambah);

        imageadd =findViewById(R.id.imgunitadd);

        txtnama=findViewById(R.id.et_nama);
        txtjabatan=findViewById(R.id.et_jabatan);

        btnupload=findViewById(R.id.btn_upload);



        ref = FirebaseDatabase.getInstance().getReference().child("Anggota").child("Unit4");
        sref = FirebaseStorage.getInstance().getReference().child("Anggota").child("Unit4");

        imageadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inten=new Intent();
                inten.setType("image/*");
                inten.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(inten,REQUEST_CODE_IMAGE);

            }
        });

        btnupload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String nama=txtnama.getText().toString();
                final String jabatan=txtjabatan.getText().toString();

                if (isImageAdded!=false && nama!=null && jabatan!=null)
                {
                    upload(nama,jabatan);
                }
                else
                {
                    Toast.makeText(AdminAnggota4Tambah.this, "Mohon Masukan Gambar", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void upload(final String nama, final String jabatan) {


        final String key=ref.push().getKey();



        //progress dialog
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Data Sedang Di Upload . . . . ");
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();

        sref.child(key+".jpg").putFile(imageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                sref.child(key +".jpg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("nama",nama);
                        hashMap.put("jabatan",jabatan);
                        hashMap.put("imageUrl",uri.toString());


                        ref.child(key).setValue(hashMap).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                progressDialog.dismiss();
                                startActivity(new Intent(getApplicationContext(),AdminAnggota4.class));
                                Toast.makeText(AdminAnggota4Tambah.this, "Sukses", Toast.LENGTH_SHORT).show();

                            }
                        });
                    }
                });

            }
        }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                double progress=(taskSnapshot.getBytesTransferred()*100)/taskSnapshot.getTotalByteCount();

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==REQUEST_CODE_IMAGE && data!=null)
        {
            imageUri=data.getData();
            isImageAdded=true;
            imageadd.setImageURI(imageUri);
        }
    }

}