package com.conexion.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.conexion.entidad.Usuario;
import com.conexion.enums.Role;
import com.conexion.servicio.UsuarioServicio;

@Controller
@RequestMapping("/")
public class ControladorMain {

	@Autowired
	private UsuarioServicio usuarioServicio;

	@GetMapping()
	public String inicio() {
		return "index.html";
	} 
	@GetMapping("/ong")
	public String vistaong(Model model) {
		return "rutasongvoluntario.html";
	}
	
	@GetMapping("/voluntario")
	public String listaong() {
		return "perfiles.html";
	}

	@GetMapping("/ong/login")
	public String login() {
		return "login.html";
	}

	@GetMapping("registro")
	public String registro() {
		return "registro";
	}

	@PostMapping("registro")
	public String registroPost(@RequestParam("username") String username, @RequestParam("name") String name,
			@RequestParam("password") String password, @RequestParam("location") String location, @RequestParam("cuit") Integer cuit,
			@RequestParam("telefono") Integer telefono, @RequestParam("email") String email, @RequestParam("descripcion") String descripcion, @RequestParam("role") Role role) {

		try {
			usuarioServicio.createNewUsuario(username, name, password, location, cuit, telefono, email, descripcion, role);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
 
		return "login.html";

	}
	
	@PostMapping("/save")
	public String save(@Validated Usuario p,Model model){
		usuarioServicio.save(p);
		return "redirect:/listar";
	}
}
