package com.tiendis.tiendis.Repository;

import com.tiendis.tiendis.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
 //#extoende de la entidad producto, se idica entre <> el nombre de la entidad y el tipo del dato de la llave
public interface ProductoRepository extends JpaRepository <Producto, Long> {

}
