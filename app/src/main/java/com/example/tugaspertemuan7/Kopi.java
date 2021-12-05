package com.example.tugaspertemuan7;

public class Kopi {

    private String _id, _merk, _jenis, _harga;
    public Kopi (String id, String merk, String jenis, String harga) {
        this._id = id;
        this._merk = merk;
        this._jenis = jenis;
        this._harga = harga;
    }
    public Kopi() {
    }
    public String get_id() {
        return _id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }
    public String get_merk() {
        return _merk;
    }
    public void set_merk(String _merk) {
        this._merk = _merk;
    }
    public String get_jenis() {
        return _jenis;
    }
    public void set_jenis(String _jenis) {
        this._jenis = _jenis;
    }
    public String get_harga() {
        return _harga;
    }
    public void set_harga(String _harga) {
        this._harga = _harga;
    }
}

