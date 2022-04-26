package com.conexion.servicio;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.conexion.entidad.Usuario;
import com.conexion.enums.Role;
import com.conexion.repositorios.UsuarioRepositorio;

@Service
public class UsuarioServicio implements UserDetailsService {

	@Autowired
	private UsuarioRepositorio usuarioRepositorio;

	public void createNewUsuario(String username, String name, String password, String location, Integer cuit, Integer telefono, String email, String descripcion, Role role) {

		// FALTA VALIDAR

		Usuario user = new Usuario();
		user.setUsername(username);
		user.setName(name);
		String encodePassword = new BCryptPasswordEncoder().encode(password);
		user.setPassword(encodePassword);
		user.setLocation(location);
		user.setCuit(cuit);
		user.setTelefono(telefono);
		user.setEmail(email);
		user.setDescripcion(descripcion);
		user.setRole(role);

		usuarioRepositorio.save(user);

	}
	
	@Transactional
	public List<Usuario> buscarTodos(){ 
		return usuarioRepositorio.findAll();
	}

	public Usuario findByUsername (String username) {
		
		return usuarioRepositorio.findByUsername(username);

	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Usuario usuario = this.findByUsername(username);

		List<GrantedAuthority> permisos = new ArrayList<>();

		GrantedAuthority p1 = new SimpleGrantedAuthority("ROLE_" + usuario.getRole());
		permisos.add(p1);

		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();

		HttpSession session = attr.getRequest().getSession(true);
		session.setAttribute("usersession", usuario);

		return new User(usuario.getName(), usuario.getPassword(), permisos);

	}
	
	public int save(Usuario p) { 
		int res=0;
		Usuario e=usuarioRepositorio.save(p);
		if(!e.equals(null)) {
			res=1;
		} 
		return res;
	}

}
