package com.conexion.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.conexion.entidad.Usuario;
import com.conexion.enums.Role;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, String>{

	public Usuario findByUsername(String username);
	
	public List<Usuario> findByRole (Role role);
	
}
