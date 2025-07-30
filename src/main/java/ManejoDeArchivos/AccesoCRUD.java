/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ManejoDeArchivos;

import epn.com.biblioteca.Acceso;
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
public class AccesoCRUD {
    private List <Acceso> listaAccesos; 
    private final String carpeta = "Archivos"; 
    private final String archivo = carpeta + "/accesos.txt"; 

    public AccesoCRUD() {
        listaAccesos = new ArrayList<>(); 
        crearCarpeta(); 
        cargarDesdeArchivo(); 
    }

    public AccesoCRUD(List<Acceso> listaAccesos) {
        this.listaAccesos = listaAccesos;
    }

    private void crearCarpeta() {
       File direccionCarpeta = new File(carpeta); 
       if (!direccionCarpeta.exists()){
           direccionCarpeta.mkdir(); 
       }
    }
    
    public void agregarAcceso(Acceso acceso){
        listaAccesos.add(acceso); 
        guardarEnArchivo();
    }
    
    public List <Acceso> listarAccesos(){
        return listaAccesos;
    }
    
    public Acceso buscarPorUsuario (String usuario){
        for (Acceso a : listaAccesos){
            if(a.getUsuario().equals(usuario)){
                return a; 
            }
        }
        return null; 
    }
    
    public boolean validarIngreso(String usuario, String contrasena){
        for (Acceso a : listaAccesos){
            if (a.getUsuario().equals(usuario) && a.getContrasena().equals(contrasena)){
                return true;
            }
        }
        return false; 
    }
    
    public boolean actualizarAcceso (String usuario, Acceso nuevoAcceso){
        for (int i = 0; i < listaAccesos.size(); i++){
            if (listaAccesos.get(i).getUsuario().equals(usuario)){
                listaAccesos.set(i, nuevoAcceso); 
                guardarEnArchivo();
                return true; 
            }
        }
        return false; 
    }
    
    public boolean eliminarAcceso (String usuario){
        for (int i = 0; i < listaAccesos.size(); i++){
            if (listaAccesos.get(i).getUsuario().equals(usuario)){
                listaAccesos.remove(i);
                guardarEnArchivo();
                return true; 
            }
        }
        return false; 
    }
    
    private void guardarEnArchivo(){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            for (Acceso a : listaAccesos){
                bw.write(a.getUsuario() + ";" + a.getContrasena());
                bw.newLine();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al guardar el archivo", "Error de guardado", 0);
            
        }
    }

    private void cargarDesdeArchivo() {
        File file = new File(archivo); 
        if (!file.exists()) return; 
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String linea; 
                while ((linea = br.readLine()) != null){
                    String partes [] = linea.split(";"); 
                    if (partes.length == 2){
                        String usuario = partes [0];
                        String contrasena = partes [1]; 
                        listaAccesos.add(new Acceso(usuario, contrasena)); 
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al cargar el archivo", "Error de carga", 0);
            }
        
    }
    
    
    
}
