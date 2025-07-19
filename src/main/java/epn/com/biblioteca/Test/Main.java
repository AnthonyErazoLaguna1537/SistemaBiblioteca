/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epn.com.biblioteca.Test;
import epn.com.biblioteca.*;
/**
 *
 * @author HP
 */
public class Main {
    public static void main(String[] args) {

        Edificio edificio = new Edificio("Av. Central 123", 500.0);

        Biblioteca biblioteca = new Biblioteca("Biblioteca Central", "Pública", "Av. Central 123", edificio);

        Acceso accesoBibliotecario = new Acceso("admin", "1234");
        Acceso accesoUsuario = new Acceso("usuario1", "abcd");

        Bibliotecario bibliotecario = new Bibliotecario(
                "Laura Méndez", "0991234567", accesoBibliotecario,
                "Literatura", 600.0, "08:00 - 16:00"
        );

        Usuario usuario = new Usuario(
                "Carlos Pérez", "0987654321", accesoUsuario,
                "Cédula", "CB123", true
        );

        biblioteca.agregarPersona(bibliotecario);
        biblioteca.agregarPersona(usuario);

        Libro libro1 = new Libro("El Principito", "Antoine de Saint-Exupéry", "L001", true);
        Libro libro2 = new Libro("1984", "George Orwell", "L002", true);

        biblioteca.agregarLibro(libro1);
        biblioteca.agregarLibro(libro2);

        usuario.agregarLibroPrestado(libro1);
        libro1.setDisponible(false); 
      
        System.out.println("\nInformación de la biblioteca");
        System.out.println(biblioteca);

        System.out.println("\nPersonas registradas");
        biblioteca.mostrarPersonas();

        System.out.println("\nLibros en la biblioteca ");
        biblioteca.mostrarLibros();

        System.out.println("\nLibros prestados por el usuario");
        usuario.mostrarLibrosPrestados();

        usuario.devolverLibro(libro1);
        libro1.setDisponible(true);

        System.out.println("\n Libros prestados después de devolución ");
        usuario.mostrarLibrosPrestados();
    }
}

