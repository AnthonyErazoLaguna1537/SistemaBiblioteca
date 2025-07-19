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
public class Libro {
    
    //Atributos
    private String titulo;
    private String autor;
    private String codigo;
    private boolean disponible;

    //Constructor por defecto
    public Libro() {
        this.titulo = "";
        this.autor = "";
        this.codigo = "";
        this.disponible = true;
    }

    //Constructor con parametros 
    public Libro(String titulo, String autor, String codigo, boolean disponible) {
        this.titulo = titulo;
        this.autor = autor;
        this.codigo = codigo;
        this.disponible = disponible;
    }

    //Getters y Setters 
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if (titulo != null && !titulo.equals("")) {
            this.titulo = titulo;
        } else {
            System.out.println("Título inválido.");
            this.titulo = "";
        }
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        if (autor != null && !autor.equals("")) {
            this.autor = autor;
        } else {
            System.out.println("Autor inválido.");
            this.autor = "";
        }
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        if (codigo != null && !codigo.equals("")) {
            this.codigo = codigo;
        } else {
            System.out.println("Código inválido.");
            this.codigo = "";
        }
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", codigo='" + codigo + '\'' +
                ", disponible=" + disponible +
                '}';
    }
}
