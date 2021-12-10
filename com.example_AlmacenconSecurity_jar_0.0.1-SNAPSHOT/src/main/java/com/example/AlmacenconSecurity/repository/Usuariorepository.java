package com.example.AlmacenconSecurity.repository;

import com.example.AlmacenconSecurity.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;



public interface Usuariorepository extends JpaRepository<Usuario, Integer>{
	public Usuario findByUsername(String username);
}
