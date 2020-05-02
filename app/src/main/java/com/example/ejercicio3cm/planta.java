package com.example.ejercicio3cm;
import java.io.Serializable;
public class planta implements Serializable {
    String flores, tipo, nombre;
    int id;
    public planta(String flores, String tipo, int id, String nombre) {
        this.flores = flores;
        this.tipo = tipo;
        this.id = id;
        this.nombre = nombre;
    }

    public String getFlores() {
        return flores;
    }

    public void setFlores(String flores) {
        this.flores = flores;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
