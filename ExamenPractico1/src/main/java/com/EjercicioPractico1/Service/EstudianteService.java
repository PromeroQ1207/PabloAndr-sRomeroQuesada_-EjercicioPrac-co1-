package com.EjercicioPractico1.Service;

import java.util.List;
import com.EjercicioPractico1.Domain.Estudiante;

public interface EstudianteService {
    //Se obtiene un listado de estudiante en un list
    public List<Estudiante> getEstudiantes (boolean activos);
    
    // Se obtiene un estudiante, a partir del id de un estudiante
    public Estudiante getEstudiante(Estudiante id);
    
    // Se inserta un nuevo estudiante si el id del estudiante esta vacío
    // Se actualiza un estudiante si el id del estudiante NO esta vacío
    public void save(Estudiante id);
    
    // Se elimina el estudiante que tiene el id pasado por parámetro
    public void delete(Estudiante id);
}
