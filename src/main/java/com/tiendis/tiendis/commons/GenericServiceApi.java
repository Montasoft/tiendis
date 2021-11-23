package com.tiendis.tiendis.commons;

import com.tiendis.tiendis.entity.Producto;

import java.io.Serializable;
import java.util.List;

public interface GenericServiceApi <T, ID extends Serializable> {

    T save (T entity);
    void delete(ID id);
    T get(ID id);
    List<T> getAll();

}
