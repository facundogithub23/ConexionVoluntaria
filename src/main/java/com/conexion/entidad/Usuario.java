package com.conexion.entidad;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import com.conexion.enums.Role;

@Entity
public class Usuario {
	
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name="uuid", strategy="uuid2")
	private String id;
	private String name;
	private String location;
	private String username; 
	private String password;
	private Integer cuit;
	private Integer telefono;
	private String email;
	private String descripcion;
	private Role role;
	
	public Usuario() {
		
	}

	public Usuario(String id, String name, String location, String username, String password, Integer cuit,
			Integer telefono, String email, String descripcion, Role role) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.username = username;
		this.password = password;
		this.cuit = cuit;
		this.telefono = telefono;
		this.email = email;
		this.descripcion = descripcion;
		this.role = role;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getCuit() {
		return cuit;
	}

	public void setCuit(Integer cuit) {
		this.cuit = cuit;
	}

	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getDescripcion () {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", name=" + name + ", location=" + location + ", username=" + username
				+ ", password=" + password + ", cuit=" + cuit + ", telefono=" + telefono + ", email=" + email
				+ ", descripcion=" + descripcion + ", role=" + role + "]";
	}
	
}
