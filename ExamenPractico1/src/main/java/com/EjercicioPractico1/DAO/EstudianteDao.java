package com.EjercicioPractico1.DAO;

import com.EjercicioPractico1.Domain.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteDao extends JpaRepository <Estudiante,Long>{
    
}
