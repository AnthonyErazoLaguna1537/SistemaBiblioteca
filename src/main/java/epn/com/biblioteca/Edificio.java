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
public class Edificio {
    //Atributos
    private String direccion;
    private double metrosCuadrados;

    //Constructor por defecto
    public Edificio() {
        this.direccion = "";
        this.metrosCuadrados = 0;
    }

    //Constructor con parametros 
    public Edificio(String direccion, double metrosCuadrados) {
        this.direccion = direccion;
        this.metrosCuadrados = metrosCuadrados;
    }

    /**
     * 
     * @return 
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * 
     * @param direccion 
     */
    public void setDireccion(String direccion) {
        if (direccion != null && !direccion.equals("")) {
            this.direccion = direccion;
        } else {
            System.out.println("Dirección inválida.");
            this.direccion = "";
        }
    }

    /**
     * 
     * @return 
     */
    public double getMetrosCuadrados() {
        return metrosCuadrados;
    }

    /**
     * 
     * @param metrosCuadrados 
     */
    public void setMetrosCuadrados(double metrosCuadrados) {
        if (metrosCuadrados > 0) {
            this.metrosCuadrados = metrosCuadrados;
        } else {
            System.out.println("Metros cuadrados inválidos.");
            this.metrosCuadrados = -1;
        }
    }

    /**
     * 
     * @return 
     */
    @Override
    public String toString() {
        return "Edificio{" +
                "direccion='" + direccion + '\'' +
                ", metrosCuadrados=" + metrosCuadrados +
                '}';
    }
}