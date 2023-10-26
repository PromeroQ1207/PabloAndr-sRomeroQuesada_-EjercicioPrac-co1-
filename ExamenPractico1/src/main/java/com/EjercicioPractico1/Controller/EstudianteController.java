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
@RequestMapping("/estudiante")
public class EstudianteController {
    @Autowired
    private EstudianteService estudianteService;

    @GetMapping("/listado")
    public String inicio(Model model) {
        var estudiante = estudianteService.getEstudiantes(false);
        model.addAttribute("Estudiante", estudiante);
        model.addAttribute("totalEstudiante", estudiante.size());
        return "/estudiante/listado";
    }

    @GetMapping("/nuevo")
    public String estudianteNuevo(Estudiante estudiante) {
        return "/estudiante/modifica";
    }
    //@Autowired
    //private FirebaseStorageServiceImpl firebaseStorageService;

    @PostMapping("/guardar")
    public String estudianteGuardar(Estudiante estudiante) {
        
        estudianteService.save(estudiante);
        return "redirect:/estudiante/listado";
    }

    @GetMapping("/eliminar/{id}")
    public String estudianteEliminar(Estudiante estudiante) {
        estudianteService.delete(estudiante);
        return "redirect:/estudiante/listado";
    }

    @GetMapping("/modificar/{id}")
    public String categoriaModificar(Estudiante estudiante, Model model) {
        estudiante = estudianteService.getEstudiante(estudiante);
        model.addAttribute("estudiante", estudiante);
        return "/estudiante/modifica";
    }
}
