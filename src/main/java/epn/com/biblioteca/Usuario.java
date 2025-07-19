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
import java.util.ArrayList;

public class Usuario extends Persona {
    //Atributos
    private String tipoDocumento;
    private String carnetBiblioteca;
    private boolean suscripcionActiva;
    private ArrayList<Libro> librosPrestados;

    //Constructor por defecto
    public Usuario() {
        super();
        this.tipoDocumento = "";
        this.carnetBiblioteca = "";
        this.suscripcionActiva = false;
        this.librosPrestados = new ArrayList<>();
    }

    //Constructor con parametros
    public Usuario(String nombre, String telefono, Acceso acceso,
                   String tipoDocumento, String carnetBiblioteca, boolean suscripcionActiva) {
        super(nombre, telefono, acceso);
        setTipoDocumento(tipoDocumento);
        setCarnetBiblioteca(carnetBiblioteca);
        this.suscripcionActiva = suscripcionActiva;
        this.librosPrestados = new ArrayList<>();
    }

    //Getters y Setters
    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        if (tipoDocumento != null && !tipoDocumento.equals("")) {
            this.tipoDocumento = tipoDocumento;
        } else {
            System.out.println("Tipo de documento inválido.");
            this.tipoDocumento = "";
        }
    }

    public String getCarnetBiblioteca() {
        return carnetBiblioteca;
    }

    public void setCarnetBiblioteca(String carnetBiblioteca) {
        if (carnetBiblioteca != null && !carnetBiblioteca.equals("")) {
            this.carnetBiblioteca = carnetBiblioteca;
        } else {
            System.out.println("Carnet de biblioteca inválido.");
            this.carnetBiblioteca = "";
        }
    }

    public boolean isSuscripcionActiva() {
        return suscripcionActiva;
    }

    public void setSuscripcionActiva(boolean suscripcionActiva) {
        this.suscripcionActiva = suscripcionActiva;
    }

    public ArrayList<Libro> getLibrosPrestados() {
        return librosPrestados;
    }

    public void agregarLibroPrestado(Libro libro) {
        if (libro != null) {
            librosPrestados.add(libro);
        } else {
            System.out.println("Libro nulo. No se puede agregar.");
        }
    }

    

    @Override
    public String toString() {
        return super.toString() +
                ", Usuario{" +
                "tipoDocumento='" + tipoDocumento + '\'' +
                ", carnetBiblioteca='" + carnetBiblioteca + '\'' +
                ", suscripcionActiva=" + suscripcionActiva +
                '}';
    }
    public void devolverLibro(Libro libro) {
        if (librosPrestados.contains(libro)) {
            librosPrestados.remove(libro);
        } else {
            System.out.println("El libro no está en la lista de préstamos.");
        }
    }

    public void mostrarLibrosPrestados() {
    if (librosPrestados.size() == 0) {
        System.out.println("No hay libros prestados.");
    } else {
        for (Libro libro : librosPrestados) {
            System.out.println(libro);
        }  
    }
    }
}
