package com.example.AlmacenconSecurity.service;

import com.example.AlmacenconSecurity.entity.Usuario;
import com.example.AlmacenconSecurity.repository.Usuariorepository;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UsuarioService implements UserDetailsService{
	
	@Autowired
	private Usuariorepository usuariorepository;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Usuario usuario = usuariorepository.findByUsername(username);
		System.out.println("Bienvenido: "+username);
		List<GrantedAuthority> authorities = usuario.getRoles()
				.stream()
				.map(role ->new SimpleGrantedAuthority(role.getNombre()))
				.collect(Collectors.toList());
		return new User(usuario.getUsername(), usuario.getPassword(), usuario.getEstado(), true, 
				true, true, authorities);
	}

}
