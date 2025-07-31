/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ManejoDeArchivos;

import epn.com.biblioteca.Biblioteca;
import epn.com.biblioteca.Bibliotecario;
import epn.com.biblioteca.Edificio;
import epn.com.biblioteca.Libro;
import epn.com.biblioteca.Persona;
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
public class BibliotecaCRUD {
    private List <Biblioteca> listaBibliotecas; 
    private final String carpeta = "Archivos"; 
    private final String archivo = carpeta + "/bibliotecas.txt"; 
    private EdificioCRUD edificioCrud; 

    
    public BibliotecaCRUD() {
        listaBibliotecas = new ArrayList<>(); 
    }

    
    
    public BibliotecaCRUD(EdificioCRUD edificioCrud) {
        this.edificioCrud = edificioCrud;
        listaBibliotecas = new ArrayList<>(); 
        crearCarpeta(); 
        cargarDesdeArchivo(); 
    }
    
    private void crearCarpeta(){
        File direccion = new File(carpeta); 
        if (!direccion.exists()){
            direccion.mkdir(); 
        }
    }
    
    public void agregarBiblioteca (Biblioteca b){
        listaBibliotecas.add(b); 
        guardarBibliotecas(b); 
    }
    
    public List <Biblioteca> listarBibliotecas(){
        List <Biblioteca> lista = new ArrayList<>(); 
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null){
                String partes [] = linea.split(";");
                if (partes.length == 5){
                    String nombre = partes [0]; 
                    String tipo = partes [1];
                    String direccion = partes [2];
                    String ubicacionEdificio = partes [3]; 
                    double metrosCuadrados = Double.parseDouble(partes [4]); 
                    Edificio edificio = new Edificio(ubicacionEdificio, metrosCuadrados); 
                    Biblioteca biblioteca = new Biblioteca(nombre, tipo, direccion, edificio);
                    List<Libro> libros = cargarLibros(nombre);
                    biblioteca.setLibros((ArrayList<Libro>) libros);

                    lista.add(biblioteca);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo listar correctamente");
        }
        return lista; 
    }

    private void guardarBibliotecas(Biblioteca b) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            bw.write(b.getNombre() + ";" + b.getTipo() + ";" + b.getDireccion() + ";" + b.getEdificio().getDireccion()
            + ";"+  b.getEdificio().getMetrosCuadrados());
            bw.newLine();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al guardar biblitoeca", "Error de guardado", 0);
        }
        
        guardarLibros(b.getNombre(), b.getLibros());
        guardarPersonas (b.getNombre(), b.getPersonas()); 
    }

    private void guardarLibros(String nombreBib, ArrayList<Libro> libros) {
        String nombreArchivo = carpeta + "/libros_" + nombreBib + ".txt"; 
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (Libro l : libros){
            // Guardar: Título ; Autor ; Código ; Disponible
            bw.write(l.getTitulo() + ";" + l.getAutor() + ";" + l.getCodigo() + ";" + l.isDisponible());
            bw.newLine();
            }
        } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al guardar libros", "Error de guardado", 0);
    }
}

    private void guardarPersonas(String nombreBib, ArrayList<Persona> personas) {
        String nombreArchivo = carpeta + "/personas_" + nombreBib + ".txt"; 
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (Persona p : personas){
                String tipo = p.getClass().getSimpleName(); 
                switch (tipo) {
                    case "Usuario":
                        Usuario usuario = (Usuario) p; 
                        bw.write(usuario.getNombre() + ";" + usuario.getTelefono() + ";" + 
                                usuario.getCarnetBiblioteca() + ";" + usuario.getTipoDocumento());
                        break;
                    case "Bibliotecario":
                        Bibliotecario biblio = (Bibliotecario) p; 
                        bw.write(biblio.getNombre() + ";" + biblio.getTelefono() + ";" + 
                                biblio.getAreaTrabajo() + ";" + biblio.getSalario() + ";" + 
                                biblio.getHorario());
                        break; 
                    default:
                        bw.newLine();
                }
                bw.newLine();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al guardar personas", "Error de guardado", 0);
        }
           
    }
    
    private void cargarDesdeArchivo(){
            File file = new File(archivo); 
            if (!file.exists()) return; 
                try  (BufferedReader br = new BufferedReader(new FileReader(file))) {
                    String linea; 
                    while ((linea = br.readLine()) != null){
                        String partes [] = linea.split(";"); 
                        if (partes.length == 4){
                            String nombre = partes [0];
                            String tipo = partes[1]; 
                            String direccion = partes [2]; 
                            String dirEdificio = partes [3]; 
                            
                            Edificio edificio = edificioCrud.buscarPorDireccion(dirEdificio); 
                            Biblioteca b = new Biblioteca(nombre, tipo, direccion, edificio); 
                            
                        }
                                
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error al cargar las personas", "Error de cargado", 0);

                }
            
        }
    
private List<Libro> cargarLibros(String nombreBib) {
    List<Libro> libros = new ArrayList<>(); 
    String archivoLibros = carpeta + "/libros_" + nombreBib + ".txt"; 
    File file = new File(archivoLibros); 
    
    if (!file.exists()) return libros; 
    
    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
        String linea;
        while ((linea = br.readLine()) != null) {
            String partes[] = linea.split(";"); 
            if (partes.length == 4) {
                String titulo = partes[0]; 
                String autor = partes[1]; 
                String codigo = partes[2]; 
                boolean esDisponible = Boolean.parseBoolean(partes[3]); 
                
                libros.add(new Libro(titulo, autor, codigo, esDisponible)); 
            }
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al cargar los libros", "Error de cargado", 0);
    }

    return libros; 
}
    
    private List <Persona> cargarPersonas (String nombreBib){
        List <Persona> personas = new ArrayList<>(); 
        String archivoPersonas = carpeta + "/personas_" + nombreBib + ".txt"; 
        File file = new File(archivoPersonas); 
        
        if (!file.exists()) return personas; 
        
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linea;
            while((linea = br.readLine()) != null){
                String partes[] = linea.split(";");
                if (partes [0].equals("Usuario") && partes.length == 5 ){
                    personas.add(new Usuario(partes [1], partes [2], null, partes [4], partes[3], true)); 
                } else if (partes[0].equals("Bibliotecario") && partes.length == 5){
                    personas.add(new Bibliotecario(partes [1], partes [2], null, partes [3], 0, partes[4])); 
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar las personas", "Error de cargado", 0);
        }
        
        return personas; 
    }
    
}
