package com.example.patroli.sabhara;

public class AdapterLaporan {

    private String tanggal;

    private String jam1;
    private String kejadian1;
    private String uraian1;
    private String tindakan1;
    private String keterangan1;

    private String jam2;
    private String kejadian2;
    private String uraian2;
    private String tindakan2;
    private String keterangan2;

    public AdapterLaporan(String tanggal,
                          String jam1, String kejadian1, String uraian1, String tindakan1, String keterangan1,
                          String jam2, String kejadian2, String uraian2, String tindakan2, String keterangan2) {
        this.tanggal = tanggal;
        this.jam1 = jam1;
        this.kejadian1 = kejadian1;
        this.uraian1 = uraian1;
        this.tindakan1 = tindakan1;
        this.keterangan1 = keterangan1;
        this.jam2 = jam2;
        this.kejadian2 = kejadian2;
        this.uraian2 = uraian2;
        this.tindakan2 = tindakan2;
        this.keterangan2 = keterangan2;
    }

    public AdapterLaporan() {
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getJam1() {
        return jam1;
    }

    public void setJam1(String jam1) {
        this.jam1 = jam1;
    }

    public String getKejadian1() {
        return kejadian1;
    }

    public void setKejadian1(String kejadian1) {
        this.kejadian1 = kejadian1;
    }

    public String getUraian1() {
        return uraian1;
    }

    public void setUraian1(String uraian1) {
        this.uraian1 = uraian1;
    }

    public String getTindakan1() {
        return tindakan1;
    }

    public void setTindakan1(String tindakan1) {
        this.tindakan1 = tindakan1;
    }

    public String getKeterangan1() {
        return keterangan1;
    }

    public void setKeterangan1(String keterangan1) {
        this.keterangan1 = keterangan1;
    }

    public String getJam2() {
        return jam2;
    }

    public void setJam2(String jam2) {
        this.jam2 = jam2;
    }

    public String getKejadian2() {
        return kejadian2;
    }

    public void setKejadian2(String kejadian2) {
        this.kejadian2 = kejadian2;
    }

    public String getUraian2() {
        return uraian2;
    }

    public void setUraian2(String uraian2) {
        this.uraian2 = uraian2;
    }

    public String getTindakan2() {
        return tindakan2;
    }

    public void setTindakan2(String tindakan2) {
        this.tindakan2 = tindakan2;
    }

    public String getKeterangan2() {
        return keterangan2;
    }

    public void setKeterangan2(String keterangan2) {
        this.keterangan2 = keterangan2;
    }
}