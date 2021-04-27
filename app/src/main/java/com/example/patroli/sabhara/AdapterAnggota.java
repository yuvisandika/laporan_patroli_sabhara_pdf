package com.example.patroli.sabhara;

public class AdapterAnggota {

    private String nama;
    private String jabatan;
    private  String imageUrl;

    public AdapterAnggota(String nama, String jabatan, String imageUrl) {
        this.nama = nama;
        this.jabatan = jabatan;
        this.imageUrl = imageUrl;
    }

    public AdapterAnggota() {
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
