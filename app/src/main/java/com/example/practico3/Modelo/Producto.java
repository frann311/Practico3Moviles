package com.example.practico3.Modelo;

import java.util.Objects;

public class Producto {
    private int codigo;
    private String descripcion;
    private double precio;

    public Producto(int codigo, String descripcion, double precio) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Producto)) return false;
        Producto producto = (Producto) o;
        return Objects.equals(codigo, producto.codigo);

    }

    @Override
    public int hashCode() {
        return Objects.hashCode(codigo);
    }
}