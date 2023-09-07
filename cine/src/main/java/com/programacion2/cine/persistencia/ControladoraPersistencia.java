
package com.programacion2.cine.persistencia;

import com.programacion2.cine.logica.Sala;
import com.programacion2.cine.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DavidRoco
 */
public class ControladoraPersistencia {
    private static ControladoraPersistencia instance = null;
     SalaJpaController salaJPA = new SalaJpaController();
    
    public ControladoraPersistencia() {
    }
    public static ControladoraPersistencia getInstance() {
        if (instance == null) {
            instance = new ControladoraPersistencia();
        }
        return instance;
    }

    public void guardarSala(Sala sala) {
        salaJPA.create(sala);
        
    }

    public List<Sala> buscarSalas() {
        List <Sala> listaSalas = salaJPA.findSalaEntities();
        return listaSalas;
    }

    public void borrarSala(int nroSala) {
        try {
            salaJPA.destroy(nroSala);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Sala buscar(int nroSala) {
        return salaJPA.findSala(nroSala);
    }

    public void editarSala(Sala sala) {
        try {
            salaJPA.edit(sala);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
}
