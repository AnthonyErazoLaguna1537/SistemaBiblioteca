/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ManejoDeArchivos;

import epn.com.biblioteca.Acceso;
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
public class UsuarioCRUD {
    private List <Usuario> listaUsuarios; 
    private final String carpeta = "Archivos"; 
    private final String archivo = carpeta + "/usuarios.txt"; 

    public UsuarioCRUD() {
        listaUsuarios = new ArrayList<>(); 
        crearCarpeta();
        cargarDesdeArchivo(); 
    }

    public UsuarioCRUD(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }
    
    public void crearCarpeta(){
        File direccionCarpeta = new File(carpeta); 
        if (!direccionCarpeta.exists()){
            direccionCarpeta.mkdir(); 
        }
    }
    
    public Usuario buscarPorUsuario (String usuario){
        for (Usuario u : listaUsuarios){
            if (u.getAcceso().getUsuario().equals(usuario)){
                return u;
            }
        }
        return null; 
    }
    public void agregarUsuario(Usuario usuario){
        listaUsuarios.add(usuario); 
        guardarEnArchivo(); 
    }
    
    public List <Usuario> listarUsuario(){
        return listaUsuarios; 
    }
    
    public Usuario buscarPorCarnet (String carnet){
        for (Usuario u : listaUsuarios){
            if (u.getCarnetBiblioteca().equalsIgnoreCase(carnet)){
                return u; 
            }
        }
        return null; 
    }
    
    public boolean actualizarPorCarnet (String carnet, Usuario nuevoUsuario){
        for (int i = 0; i < listaUsuarios.size(); i++){
            if (listaUsuarios.get(i).getCarnetBiblioteca().equalsIgnoreCase(carnet)){
                listaUsuarios.set(i, nuevoUsuario); 
                guardarEnArchivo();
                return true; 
            }
        }
        return false; 
    }
    
    public boolean eliminarPorCarnet(String carnet){
        for (int i = 0; i < listaUsuarios.size(); i++){
            if(listaUsuarios.get(i).getCarnetBiblioteca().equalsIgnoreCase(carnet)){
                listaUsuarios.remove(i); 
                guardarEnArchivo();
                return true; 
            }
        }
        return false; 
    }
    
    private void guardarEnArchivo(){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            for (Usuario u: listaUsuarios){
                bw.write(u.getNombre() + ";" + u.getTelefono()+ ";" + u.getAcceso().getUsuario() + ";" + 
                        u.getAcceso().getContrasena() + ";" + u.getTipoDocumento() + ";" + 
                        u.getCarnetBiblioteca() + ";" + u.isSuscripcionActiva()); 
                bw.newLine();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo guardar el archivo", "Error en escritura", 0);
        }
    }
    
    private void cargarDesdeArchivo(){
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
                        String tipoDocumento = partes [4]; 
                        String carnetBiblioteca = partes [5]; 
                        boolean suscipcionActiva = Boolean.parseBoolean(partes [6]); 
                        Acceso acceso = new Acceso(usuario, contrasena); 
                        Usuario usuarionuevo = new Usuario(nombre, telefono, acceso, tipoDocumento, carnetBiblioteca, suscipcionActiva);
                        listaUsuarios.add(usuarionuevo); 
                    }
                }
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No se pudo cargar el archivo", "Error en lectura", 0);
            }
        
    }
    
    
    
}
