/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ManejoDeArchivos;

import epn.com.biblioteca.Libro;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Thony
 */
public class LibroCRUD {
    private List <Libro> listaLibros; 
    private final String carpeta = "Archivos";
    private final String archivo = carpeta + "/libros.txt"; 

    public LibroCRUD() {
        listaLibros = new ArrayList<>(); 
        crearCarpeta();
        cargarDesdeArchivo();
        
    }
    
    public LibroCRUD(List<Libro> listaLibros) {
        this.listaLibros = listaLibros;
    }
    
    
    public void crearCarpeta(){
        File dirCarpeta = new File(carpeta); 
        if (!dirCarpeta.exists()){
            dirCarpeta.mkdir(); 
        }
    }
    
    
    public void agregarLibro(Libro libro){
        listaLibros.add(libro); 
        guardarEnArchivo();
    }
    
    public List <Libro> listarLibros(){
        return listaLibros;
    }
    
    public Libro buscarPorTitulo (String titulo){
        for (Libro l : listaLibros){
            if(l.getTitulo().equalsIgnoreCase(titulo)){
                return l; 
            }
        }
        return null; 
    }
    
    public boolean actualizar (String titulo, Libro libroNuevo){
        for (int i = 0; i < listaLibros.size(); i++){
            if(listaLibros.get(i).getTitulo().equalsIgnoreCase(titulo)){
                listaLibros.set(i, libroNuevo); 
                guardarEnArchivo();
                return true; 
            }
        }
        return false;
    }
    
    public boolean eliminarLibro(String titulo){
        for (int i = 0; i < listaLibros.size(); i++){
            if (listaLibros.get(i).getTitulo().equalsIgnoreCase(titulo)){
                listaLibros.remove(i); 
                guardarEnArchivo();
                return true; 
            }
        }
        return false; 
    }
    
    
    private void cargarDesdeArchivo(){
        File file = new File(archivo);
        if (!file.exists()) return; 
            try (BufferedReader br = new BufferedReader(new FileReader(file))){
                String linea; 
                while ((linea = br.readLine()) != null) {
                    String [] partes = linea.split(";"); 
                    if (partes.length == 4){
                        String titulo = partes [0]; 
                        String autor = partes [1]; 
                        String codigo = partes [2]; 
                        boolean esDisponible = Boolean.parseBoolean(partes [3]); 
                        listaLibros.add(new Libro(titulo, autor, codigo, esDisponible)); 
                    }
                    
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error al cargar el archivo", "Error en el arhivo", 0);
            }
        
    }

   
    

    
    public void guardarEnArchivo(){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            for (Libro l : listaLibros){
                bw.write(l.getTitulo() + ";" + l.getAutor() + ";" + l.getCodigo() + ";" + l.isDisponible());
                bw.newLine();
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al guardar el archivo", "Error", 0);
        }
    }
    
}
