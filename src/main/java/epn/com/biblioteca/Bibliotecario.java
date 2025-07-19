package epn.com.biblioteca;


import epn.com.biblioteca.Persona;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
public class Bibliotecario extends Persona {
    //Atributos
    private String areaTrabajo;
    private double salario;
    private String horario;

    //Constructor con por defecto
    public Bibliotecario() {
        super();
        this.areaTrabajo = "";
        this.salario = 470;
        this.horario = "";
    }

    //Constructor con parametros
    public Bibliotecario(String nombre, String telefono, Acceso acceso,
                         String areaTrabajo, double salario, String horario) {
        super(nombre, telefono, acceso);
        setAreaTrabajo(areaTrabajo);
        setSalario(salario);
        setHorario(horario);
    }

    //Getters y Setters
    public String getAreaTrabajo() {
        return areaTrabajo;
    }

    public void setAreaTrabajo(String areaTrabajo) {
        if (areaTrabajo != null && !areaTrabajo.equals("")) {
            this.areaTrabajo = areaTrabajo;
        } else {
            System.out.println("Área de trabajo inválida.");
            this.areaTrabajo = "";
        }
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        if (salario >= 0) {
            this.salario = salario;
        } else {
            System.out.println("Salario inválido.");
            this.salario = -1;
        }
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        if (horario != null && !horario.equals("")) {
            this.horario = horario;
        } else {
            System.out.println("Horario inválido.");
            this.horario = "";
        }
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Bibliotecario{" +
                "areaTrabajo='" + areaTrabajo + '\'' +
                ", salario=" + salario +
                ", horario='" + horario + '\'' +
                '}';
    }
}

