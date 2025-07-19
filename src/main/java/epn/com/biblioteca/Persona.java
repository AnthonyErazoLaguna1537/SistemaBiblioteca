package epn.com.biblioteca;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
public class Persona {
    //Atributos
    private String nombre;
    private String telefono;
    private Acceso acceso;

    //Constructor por defecto
    public Persona() {
        this.nombre = "";
        this.telefono = "";
        this.acceso = new Acceso();
    }

    //Constructor con parametros 
    public Persona(String nombre, String telefono, Acceso acceso) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.acceso = acceso;
    }

    //Getters y Setters 
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre != null && !nombre.equals("")) {
            this.nombre = nombre;
        } else {
            System.out.println("Nombre inválido.");
            this.nombre = "";
        }
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        if (telefono != null && !telefono.equals("")) {
            this.telefono = telefono;
        } else {
            System.out.println("Teléfono inválido.");
            this.telefono = "";
        }
    }

    public Acceso getAcceso() {
        return acceso;
    }

    public void setAcceso(Acceso acceso) {
        if (acceso != null) {
            this.acceso = acceso;
        } else {
            System.out.println("Acceso inválido.");
            this.acceso = new Acceso();
        }
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", acceso=" + acceso +
                '}';
    }
}

