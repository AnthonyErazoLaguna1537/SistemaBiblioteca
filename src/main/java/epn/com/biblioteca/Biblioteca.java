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
import epn.com.biblioteca.Edificio;
import epn.com.biblioteca.Libro;
import epn.com.biblioteca.Persona;
import java.util.ArrayList;

public class Biblioteca {
    //Atributos
    private String nombre;
    private String tipo;
    private String direccion;
    private ArrayList<Persona> personas;
    private ArrayList<Libro> libros;
    private Edificio edificio;

    //Constructor por defecto
    public Biblioteca() {
        this.nombre = "";
        this.tipo = "";
        this.direccion = "";
        this.personas = new ArrayList<>();
        this.libros = new ArrayList<>();
        this.edificio = new Edificio();
    }

    //Constructor con parametros
    public Biblioteca(String nombre, String tipo, String direccion, Edificio edificio) {
        setNombre(nombre);
        setTipo(tipo);
        setDireccion(direccion);
        setEdificio(edificio);
        this.personas = new ArrayList<>();
        this.libros = new ArrayList<>();
    }

    //Getters y setters 
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre != null && !nombre.equals("")) {
            this.nombre = nombre;
        } else {
            System.out.println("Nombre de biblioteca inválido.");
            this.nombre = "";
        }
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        if (tipo != null && !tipo.equals("")) {
            this.tipo = tipo;
        } else {
            System.out.println("Tipo de biblioteca inválido.");
            this.tipo = "";
        }
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        if (direccion != null && !direccion.equals("")) {
            this.direccion = direccion;
        } else {
            System.out.println("Dirección de biblioteca inválida.");
            this.direccion = "";
        }
    }

    public Edificio getEdificio() {
        return edificio;
    }

    public void setEdificio(Edificio edificio) {
        if (edificio != null) {
            this.edificio = edificio;
        } else {
            System.out.println("Edificio inválido.");
            this.edificio = new Edificio();
        }
    }

    public ArrayList<Persona> getPersonas() {
        return personas;
    }

    public void agregarPersona(Persona persona) {
        if (persona != null) {
            personas.add(persona);
        } else {
            System.out.println("No se puede agregar");
        }
    }

    public ArrayList<Libro> getLibros() {
        return libros;
    }

    public void setPersonas(ArrayList<Persona> personas) {
        this.personas = personas;
    }

    public void setLibros(ArrayList<Libro> libros) {
        this.libros = libros;
    }


    @Override
    public String toString() {
        return "Biblioteca{" +
                "nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                ", direccion='" + direccion + '\'' +
                ", edificio=" + edificio +
                '}';
    }
    //Metodos
    public void agregarLibro(Libro libro) {
        if (libro != null) {
            libros.add(libro);
        } else {
            System.out.println("No se puede agregar");
        }
    }

    public void mostrarPersonas() {
    if (personas.size() == 0) {
        System.out.println("No hay personas registradas.");
    } else {
        for (Persona p : personas) {
            System.out.println(p);
        }
    }
}

    public void mostrarLibros() {
    if (libros.size() == 0) {
        System.out.println("No hay libros registrados.");
    } else {
        for (Libro l : libros) {
            System.out.println(l);
        }
    }
    }
}
