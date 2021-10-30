package com.tiendis.tiendis;

import com.tiendis.tiendis.Repository.CategoriaRepository;
import com.tiendis.tiendis.entity.Categoria;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;


@SpringBootApplication
public class TiendisApplication {

	private CategoriaRepository categoriaRepository;

	public static void main(String[] args) {
		SpringApplication.run(TiendisApplication.class, args);
	}


	private void saveCategoryInDataBase(){
		Categoria lapices = new Categoria("lapices", "Lapices varios");
		Categoria lapiceros = new Categoria("lapiceros", "lapiceros");
		Categoria cuadernos = new Categoria("cuadernos", "cuadernos grapado, argollados, cocidos");
		List<Categoria> list = Arrays.asList(lapices, lapiceros, cuadernos);
		list.stream().forEach(categoriaRepository::save);

	}

}
