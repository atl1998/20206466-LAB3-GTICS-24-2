package com.example.lab3_20206466.controller;

import java.util.List;
import com.example.lab3_20206466.repository.EmployeeRepository;
import com.example.lab3_20206466.entity.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @GetMapping("/list")
    public String listarEmpleados(Model model) {
        List<Employee> lista = employeeRepository.findAll();
        model.addAttribute("listaEmployees", lista); // Añadimos la lista al modelo
        return "empleados"; // Se enviarán los datos a la plantilla lista.html
    }
    @PostMapping("/buscarEmpleado")
    public String buscarEmpleado(@RequestParam("searchField") String searchField,Model model){
        List<Employee> listaRep=employeeRepository.findByFirstName(searchField);
        model.addAttribute("listaEmpleados",listaRep);
        return "employee/list";
    }

    @PostMapping("/limpiarFiltros")
    public String limpiarFiltros(Model model) {
        List<Employee> lista = employeeRepository.findAll();
        model.addAttribute("listaEmployees", lista); // Añadimos la lista al modelo
        return "empleados"; // Se enviarán los datos a la plantilla lista.html
    }


    @GetMapping("/editar/{id}")
    public String informEmpleado(@PathVariable("id") Integer id, Model model) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Empleado no encontrado"));
        model.addAttribute("employee", employee);
        return "editarEmpleado"; // Página de detalles del empleado
    }

    // Método para eliminar un empleado

    @PostMapping("/delete/{id}")
    public String deleteEmpleado(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Empleado no encontrado"));

        employeeRepository.delete(employee);
        redirectAttributes.addFlashAttribute("message", "Empleado eliminado exitosamente.");
        return "redirect:/employee/list"; // Redirige a la lista de empleados después de eliminar
    }
}
