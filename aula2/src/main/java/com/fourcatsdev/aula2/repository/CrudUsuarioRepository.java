package com.fourcatsdev.aula2.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fourcatsdev.aula2.orm.Usuario;

@Repository
public interface CrudUsuarioRepository extends CrudRepository<Usuario, Long>{

}
