package com.fourcatsdev.aula2.service;

import java.util.List;
import java.util.Optional;

import com.fourcatsdev.aula2.orm.Usuario;

public interface CrudUsuarioService {
	public void salvar(Usuario usuario);
	public List<Usuario> buscarTodos();
	public Optional<Usuario> buscarPorId(Long id);
	public void apagarPorId(long id);
	public long count(); 
}
