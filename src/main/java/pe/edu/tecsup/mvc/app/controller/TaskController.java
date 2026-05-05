package pe.edu.tecsup.mvc.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.tecsup.mvc.app.entity.Task;
import pe.edu.tecsup.mvc.app.service.TaskService;

import java.util.List;

@Controller
@RequestMapping("/mvc")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    // Listar tareas
    @GetMapping
    public String listar(Model model) {
        List<Task> tasks = service.listar();
        model.addAttribute("tasks", tasks);
        return "mvc/lista";
    }

    // Crear tarea
    @PostMapping
    public String crear(@RequestParam String titulo) {
        service.crear(titulo);
        return "redirect:/mvc";
    }

    // Completar tarea
    @PostMapping("/{id}/completar")
    public String completar(@PathVariable Long id) {
        service.completar(id);
        return "redirect:/mvc";
    }

    // Eliminar tarea
    @PostMapping("/{id}/eliminar")
    public String eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return "redirect:/mvc";
    }
}
