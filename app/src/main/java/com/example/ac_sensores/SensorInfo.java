package com.example.ac_sensores;

public class SensorInfo {
    private String nombre;
    private String vendor;
    private int version;
    private String tipo;

    public SensorInfo(String nombre, String vendor, int version, String tipo) {
        this.nombre = nombre;
        this.vendor = vendor;
        this.version = version;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getVendor() {
        return vendor;
    }

    public int getVersion() {
        return version;
    }

    public String getTipo() {
        return tipo;
    }
}
