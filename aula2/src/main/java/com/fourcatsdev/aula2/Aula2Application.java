package com.fourcatsdev.aula2;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fourcatsdev.aula2.orm.Usuario;
import com.fourcatsdev.aula2.service.CrudUsuarioServiceImpl;

@SpringBootApplication
public class Aula2Application implements CommandLineRunner {
	
	@Autowired
	private CrudUsuarioServiceImpl crudUsuarioService;

	public static void main(String[] args) {
		SpringApplication.run(Aula2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		crudUsuarioService.salvar(new Usuario("Maria", sdf.parse("21/12/1982"),"maria@gmail.com", 5));
		crudUsuarioService.salvar(new Usuario("Paulo", sdf.parse("25/10/1999"),"paulo@gmail.com", 3));
		crudUsuarioService.salvar(new Usuario("João", sdf.parse("30/11/1990"),"joao@gmail.com", 2.5));
		crudUsuarioService.salvar(new Usuario("Luiz", sdf.parse("05/02/1992"),"luiz@gmail.com", 3.5));
	
		List<Usuario> usuarios = crudUsuarioService.buscarTodos();
        usuarios.forEach(usuario -> System.out.println(usuario.toString()));
        
		long id = 1L;
        Optional<Usuario> usuarioOpt = crudUsuarioService.buscarPorId(id);

        if (usuarioOpt.isPresent()) {
            System.out.println(usuarioOpt.get());
        } else {
            System.out.printf("Não existe usuário com o id %d%n", id);
        }
        		
		long registros = crudUsuarioService.count();
        System.out.printf("Número de registros na tabela: %d%n", registros);
        
        crudUsuarioService.apagarPorId(1L);
        
        registros = crudUsuarioService.count();
        System.out.printf("Número de registros na tabela: %d%n", registros);
		
	}

}
