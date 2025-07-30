/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ManejoDeArchivos;

import epn.com.biblioteca.Edificio;
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
public class EdificioCRUD {
    private List <Edificio> listaEdificios; 
    private final String carpeta = "Archivos"; 
    private final String archivo = carpeta + "/edificios.txt"; 

    public EdificioCRUD() {
        listaEdificios = new ArrayList<>(); 
        crearCarpeta(); 
        cargarDesdeArchivo(); 
    }
    
    
    private void crearCarpeta(){
        File direccion = new File(carpeta);
        if (!direccion.exists()){
            direccion.mkdir(); 
        }
    }
    
    public void agregarEdificio(Edificio edificio){
        listaEdificios.add(edificio); 
        guardarEnArchivo();
    }
    
    
    public List <Edificio> listarEdificios(){
        return listaEdificios; 
    }
    
    public Edificio buscarPorDireccion(String direccion){
        for (Edificio e : listaEdificios){
            if (e.getDireccion().equalsIgnoreCase(direccion)){
                return e; 
            }
        }
        return null; 
    }

    private void guardarEnArchivo() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            for (Edificio e : listaEdificios){
                bw.write(e.getDireccion() + ";" + e.getMetrosCuadrados());
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
                while((linea = br.readLine()) != null){
                    String partes [] = linea.split(";");
                    if (partes.length == 2){
                        String direccion = partes [0];
                        double metrosCuadrados = Double.parseDouble(partes [1]); 
                        listaEdificios.add(new Edificio(direccion, metrosCuadrados)); 
                    }
                }
            } catch (Exception e) {
                 JOptionPane.showMessageDialog(null, "No se pudo leer el archivo", "Error al leer", 0);

            }
       
    }
}
