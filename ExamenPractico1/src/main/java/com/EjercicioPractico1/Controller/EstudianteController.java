/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.EjercicioPractico1.Controller;

import com.EjercicioPractico1.Domain.Estudiante;
import com.EjercicioPractico1.Service.EstudianteService;
import com.EjercicioPractico1.Service.impl.FirebaseStorageServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author pablo
 */
@Controller
@Slf4j
@RequestMapping("/estudiantes")
public class EstudianteController {
    @Autowired
    private EstudianteService estudianteService;

    @GetMapping("/listado")
    public String inicio(Model model) {
        var estudiante = estudianteService.getEstudiantes(false);
        model.addAttribute("Estudiantes", estudiante);
        model.addAttribute("totalEstudiantes", estudiante.size());
        return "/estudiantes/listado";
    }

    @GetMapping("/nuevo")
    public String estudianteNuevo(Estudiante estudiante) {
        return "/estudiantes/modifica";
    }
    //@Autowired
    //private FirebaseStorageServiceImpl firebaseStorageService;

    @PostMapping("/guardar")
    public String estudianteGuardar(Estudiante estudiante) {
        
        estudianteService.save(estudiante);
        return "redirect:/estudiantes/listado";
    }

    @GetMapping("/eliminar/{id}")
    public String estudianteEliminar(Estudiante estudiante) {
        estudianteService.delete(estudiante);
        return "redirect:/estudiantes/listado";
    }

    @GetMapping("/modificar/{id}")
    public String categoriaModificar(Estudiante estudiante, Model model) {
        estudiante = estudianteService.getEstudiante(estudiante);
        model.addAttribute("estudiante", estudiante);
        return "/estudiantes/modifica";
    }
}
