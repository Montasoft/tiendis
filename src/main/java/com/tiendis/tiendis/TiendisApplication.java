package com.tiendis.tiendis;

import com.tiendis.tiendis.Repository.CategoriaRepository;
import com.tiendis.tiendis.Repository.ProductoRepository;
import com.tiendis.tiendis.Repository.SubCategoriaRepository;
import com.tiendis.tiendis.entity.Categoria;
import com.tiendis.tiendis.entity.SubCategoria;
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
	private SubCategoriaRepository subCategoriaRepository;
	private ProductoRepository productoRepository;


	public TiendisApplication(CategoriaRepository categoriaRepository, SubCategoriaRepository subCategoriaRepository) {
		this.categoriaRepository = categoriaRepository;
		this.subCategoriaRepository = subCategoriaRepository;
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

		System.out.print("listando articuos antes de guardar");

		SubCategoria grafito = new SubCategoria("grafito", categoriaRepository.getById(3l), "Lapices corrientes");
		SubCategoria deDibujo = new SubCategoria("de Dibujo", categoriaRepository.getById(3l), "Lapices de dibujo");
		List<SubCategoria> listSC = Arrays.asList(grafito,deDibujo);
		listSC.stream().forEach(subCategoriaRepository::save);


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
