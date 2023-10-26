package com.EjercicioPractico1.Service.impl;

import com.EjercicioPractico1.DAO.EstudianteDao;
import com.EjercicioPractico1.Domain.Estudiante;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import com.EjercicioPractico1.Service.EstudianteService;

/**
 *
 * @author pablo
 */
@Service
public class EstudianteServiceImpl implements EstudianteService {
    
    @Autowired
    private EstudianteDao EstudianteDao;
    @Override
    @Transactional(readOnly=true)
    public List<Estudiante> getEstudiantes(boolean activos) {
        var lista=EstudianteDao.findAll();
        if (activos) {
           lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }
    
    @Override
    @Transactional(readOnly = true)
    public Estudiante getEstudiante(Estudiante estudiante) {
        return EstudianteDao.findById(estudiante.getId()).orElse(null);
    }
    
    @Override
    @Transactional
    public void save(Estudiante estudiante) {
        EstudianteDao.save(estudiante);
    }
    
    @Override
    @Transactional
    public void delete(Estudiante estudiante) {
        EstudianteDao.delete(estudiante);
    }
}
