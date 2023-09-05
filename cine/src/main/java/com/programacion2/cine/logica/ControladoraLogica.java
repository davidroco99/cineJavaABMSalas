
package com.programacion2.cine.logica;

/**
 *
 * @author DavidRoco
 */

import java.util.ArrayList;
import java.util.List;
import com.programacion2.cine.persistencia.ControladoraPersistencia;

public class ControladoraLogica {
    private static ControladoraLogica instance = null;
    
    
    public ControladoraLogica() {
    }
    public static ControladoraLogica getInstance() {
        if (instance == null) {
            instance = new ControladoraLogica();
        }
        return instance;
    }

    public void agregarSala(DTOSala dtoSala) {
        Sala sala = new Sala();
        sala.setNombreSala(dtoSala.getNombreSala());
        sala.setCantAsientos(Integer.parseInt(dtoSala.getCantAsientos()));
        sala.setFilas(dtoSala.getFilas());
        sala.setAsientosPorFila(Integer.parseInt(dtoSala.getAsientosPorFila()));
        
       
        ControladoraPersistencia persistencia = ControladoraPersistencia.getInstance();
        persistencia.guardarSala(sala);
        
    }

    public List<DTOSala> traerSalas() {
       ControladoraPersistencia persistencia = ControladoraPersistencia.getInstance();
       List <Sala> listSala = persistencia.buscarSalas();
       ArrayList <DTOSala> listaDTOSala;
       listaDTOSala = new ArrayList<>();
       int index = 0;
       //relleno la lista de DTOSala       
       for (Sala sala: listSala){
           DTOSala dtoSala = new DTOSala();
           
           String nroSala = String.valueOf(sala.getNroSala());
           dtoSala.setNroSala(nroSala);
           
           String cantidadAsientos = String.valueOf(sala.getCantAsientos());
           dtoSala.setCantAsientos(cantidadAsientos);
           
           String nombreSala = String.valueOf(sala.getNombreSala());
           dtoSala.setNombreSala(nombreSala);
           
           String filas = String.valueOf(sala.getFilas());
           dtoSala.setFilas(filas);
           
           String asientosPorFila = String.valueOf(sala.getAsientosPorFila());
           dtoSala.setAsientosPorFila(asientosPorFila);
           
           listaDTOSala.add(index, dtoSala);
           index += 1;
       } 
        
       return listaDTOSala;
    }

    public void borrarSala(int nroSala) {
        ControladoraPersistencia persistencia = ControladoraPersistencia.getInstance();
        persistencia.borrarSala(nroSala);
    }

    public DTOSala buscarSala(int nroSala) {
        ControladoraPersistencia persistencia = ControladoraPersistencia.getInstance();
        Sala sala = persistencia.buscar(nroSala);
                
        DTOSala dtoSala = new DTOSala();
        
        String nroSala1 = String.valueOf(sala.getNroSala());
        dtoSala.setNroSala(nroSala1);
           
        String cantidadAsientos = String.valueOf(sala.getCantAsientos());
        dtoSala.setCantAsientos(cantidadAsientos);
           
        String nombreSala = String.valueOf(sala.getNombreSala());
        dtoSala.setNombreSala(nombreSala);
          
        String filas = String.valueOf(sala.getFilas());
        dtoSala.setFilas(filas);
           
        String asientosPorFila = String.valueOf(sala.getAsientosPorFila());
        dtoSala.setAsientosPorFila(asientosPorFila);
           
        return dtoSala;
    }

    public void editarSala(DTOSala dtoSala) {
        Sala sala = new Sala();
        
        int nroSala = Integer.parseInt(dtoSala.getNroSala());
        sala.setNroSala(nroSala);
           
        int cantidadAsientos = Integer.parseInt(dtoSala.getCantAsientos());
        sala.setCantAsientos(cantidadAsientos);
           
        String nombreSala = String.valueOf(dtoSala.getNombreSala());
        sala.setNombreSala(nombreSala);
          
        String filas = String.valueOf(dtoSala.getFilas());
        sala.setFilas(filas);
           
        int asientosPorFila = Integer.parseInt(dtoSala.getAsientosPorFila());
        sala.setAsientosPorFila(asientosPorFila);
        
        
        ControladoraPersistencia persistencia = ControladoraPersistencia.getInstance();
        persistencia.editarSala(sala);
    }
    
    
}
