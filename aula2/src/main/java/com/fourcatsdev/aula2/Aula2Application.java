package com.fourcatsdev.aula2;


import java.text.SimpleDateFormat;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fourcatsdev.aula2.orm.Usuario;
import com.fourcatsdev.aula2.repository.CrudUsuarioRepository;


@SpringBootApplication
public class Aula2Application implements CommandLineRunner{
	
	@Autowired
	private CrudUsuarioRepository crudUsuarioRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Aula2Application.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("\nEnviando dados ao banco de dados...");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Usuario maria = new Usuario("Maria", sdf.parse("21/12/1982"),"maria@gmail.com", 5);
		crudUsuarioRepository.save(maria);
		crudUsuarioRepository.save(new Usuario("Paulo", sdf.parse("25/10/1999"),"paulo@gmail.com", 3));
		crudUsuarioRepository.save(new Usuario("João", sdf.parse("30/11/1990"),"joao@gmail.com", 2.5));
		crudUsuarioRepository.save(new Usuario("Luiz", sdf.parse("05/02/1992"),"luiz@gmail.com", 3.5));
		
		System.out.println("\nBuscando por id...");
		long id = 1L;
        Optional<Usuario> usuarioOpt = crudUsuarioRepository.findById(id);

        if (usuarioOpt.isPresent()) {
            System.out.println(usuarioOpt.get());
        } else {
            System.out.printf("Não existe usuário com o id %d%n", id);
        }
		
        System.out.println("\nBuscando todos os registros do banco...");
		
		Iterable<Usuario> usuarios = crudUsuarioRepository.findAll();
        usuarios.forEach(usuario -> System.out.println(usuario.toString()));
		
		
        System.out.println("\nContando os registros do banco de dados...");
		long registros = crudUsuarioRepository.count();
        System.out.printf("Número de registros na tabela: %d%n", registros);
        
        System.out.println("\nApagando dados por id...");
        crudUsuarioRepository.deleteById(2L); 
        
        System.out.println("\nContando os registros novamente do banco de dados...");
        registros = crudUsuarioRepository.count();
        System.out.printf("Número de registros na tabela: %d%n", registros);
        
	}	

}
