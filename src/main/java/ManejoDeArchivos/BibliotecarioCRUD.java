/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ManejoDeArchivos;

import epn.com.biblioteca.Acceso;
import epn.com.biblioteca.Bibliotecario;
import epn.com.biblioteca.Usuario;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Thony
 */
public class BibliotecarioCRUD {
    private List <Bibliotecario> listaBibliotecarios; 
    private final String carpeta = "Archivos"; 
    private final String archivo = carpeta + "/bibliotecarios.txt"; 

    public BibliotecarioCRUD() {
        listaBibliotecarios = new ArrayList<>(); 
        crearCarpeta(); 
        cargarDesdeArchivo(); 
    }

    private void crearCarpeta() {
        File direccion = new File(carpeta); 
        if (!direccion.exists()){
            direccion.mkdir(); 
        }
    }
    
    public void agregarBiblitecario(Bibliotecario biblio){
        listaBibliotecarios.add(biblio); 
        guardarEnArchivo(); 
    }
    
    public List <Bibliotecario> listarBibliotecarios(){
        return listaBibliotecarios; 
    }
    public Bibliotecario buscarPorUsuario (String usuario){
        for (Bibliotecario b : listaBibliotecarios){
            if (b.getAcceso().getUsuario().equalsIgnoreCase(usuario)){
                return b;
            }
        }
        return null; 
    }
    public Bibliotecario buscarPorTelefono(String telefono){
        for (Bibliotecario b : listaBibliotecarios){
            if (b.getTelefono().equalsIgnoreCase(telefono)){
                return b; 
            }
        }
        return null; 
    }
    
    public boolean actualizar (String telefono, Bibliotecario biblio){
        for (int i = 0; i < listaBibliotecarios.size(); i++){
            if (listaBibliotecarios.get(i).getTelefono().equals(telefono)){
                listaBibliotecarios.set(i, biblio); 
                guardarEnArchivo(); 
                return true; 
            }
        }
        return false; 
    }

    private void guardarEnArchivo() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            for (Bibliotecario b :listaBibliotecarios){
                bw.write(b.getNombre() + ";" + b.getTelefono() + ";" + b.getAcceso().getUsuario() + 
                        ";" + b.getAcceso().getContrasena() + ";" + b.getAreaTrabajo() + ";" +
                        b.getSalario() + ";" + b.getHorario());
                bw.newLine();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo guardar el archivo", "Error al guardar", 0);
        }
    }

    private void cargarDesdeArchivo() {
        File file = new File(archivo); 
        if (!file.exists()) return; 
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String linea; 
                while ((linea = br.readLine()) != null){
                    String partes [] = linea.split(";"); 
                    if (partes.length == 7){
                        String nombre = partes [0]; 
                        String telefono = partes [1]; 
                        String usuario = partes [2]; 
                        String contrasena = partes [3]; 
                        String areaTrabajo = partes [4]; 
                        double salario = Double.parseDouble(partes [5]);
                        String horario = partes [6]; 
                        Acceso acceso = new Acceso(usuario, contrasena); 
                        Bibliotecario bliblio = new Bibliotecario(nombre, telefono, acceso, areaTrabajo, salario, horario);
                        listaBibliotecarios.add(bliblio);
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No se pudo guardar el leer el archivo", "Error al leer", 0);

            }
      
    }
    
        
}
