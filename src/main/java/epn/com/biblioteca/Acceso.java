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
public class Acceso {
    //Atributos
    private String usuario;
    private String contrasena;

    //Constructor por defecto
    public Acceso() {
        this.usuario = "";
        this.contrasena = "";
    }

    //Constructor con parametros 
    public Acceso(String usuario, String contrasena) {
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    //Getters y Setters 
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        if (usuario != null && !usuario.equals("")) {
            this.usuario = usuario;
        } else {
            System.out.println("Usuario inválido.");
            this.usuario = "";
        }
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        if (contrasena != null && contrasena.length() >= 4) {
            this.contrasena = contrasena;
        } else {
            System.out.println("Contraseña inválida.");
        }
    }

    @Override
    public String toString() {
        return "Acceso{" +
                "usuario='" + usuario + '\'' +
                ", contrasena='" + contrasena + '\'' +
                '}';
    }
}