package com.example.gameratehub_androidstudio;

public class Encapsulador {
    private int image;
    private String nombre;
    private String descripcion;
    private String precio;
    private boolean selected;

    // Constructor
    public Encapsulador(int image, String nombre, String descripcion, String precio) {
        this.image = image;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.selected = false;  // Inicialmente no está seleccionado
    }

    // Getters y setters
    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
