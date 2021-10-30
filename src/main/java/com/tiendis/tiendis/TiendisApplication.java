package com.tiendis.tiendis;

import com.tiendis.tiendis.Repository.CategoriaRepository;
import com.tiendis.tiendis.entity.Categoria;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;


@SpringBootApplication
public class TiendisApplication implements CommandLineRunner {

	private CategoriaRepository categoriaRepository;

	public TiendisApplication(CategoriaRepository categoriaRepository) {
		this.categoriaRepository = categoriaRepository;
	}

	private final Log LOGGER = LogFactory.getLog(TiendisApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TiendisApplication.class, args);
	}

	private void saveCategoryInDataBase(){
		Categoria lapices = new Categoria("lapices", "Lapices varios");
		Categoria lapiceros = new Categoria("lapiceros", "lapiceros");
		Categoria cuadernos = new Categoria("cuadernos", "cuadernos grapado, argollados, cocidos");
		List<Categoria> list = Arrays.asList(lapices, lapiceros, cuadernos);
		System.out.print("listando articuos antes de guardar");
		list.stream().forEach(categoriaRepository::save);



	}
	@Override
	public void run(String... args) {
		try {
			saveCategoryInDataBase();
		} catch (Exception e){
			e.printStackTrace ();
			LOGGER.error("Esto es un error" + e.getMessage());
		}
	}

}
