package com.fourcatsdev.aula2.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fourcatsdev.aula2.orm.Usuario;
import com.fourcatsdev.aula2.repository.CrudUsuarioRepository;

@Service
public class CrudUsuarioServiceImpl implements CrudUsuarioService {
	
	@Autowired
	private CrudUsuarioRepository usuarioRepository;

	@Override
	public void salvar(Usuario usuario) {
		usuarioRepository.save(usuario);
	}

	@Override
	public List<Usuario> buscarTodos() {
		List<Usuario> usuarios = new ArrayList<>();
		usuarioRepository.findAll().forEach(usuarios::add);
	    return usuarios;
	}

	@Override
	public Optional<Usuario> buscarPorId(Long id) {
		return usuarioRepository.findById(id);
	}

	@Override
	public void apagarPorId(long id) {
		usuarioRepository.deleteById(id);
	}

	@Override
	public long count() {
		return usuarioRepository.count();
	}

}
