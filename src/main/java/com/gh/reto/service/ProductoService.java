package com.gh.reto.service;

import com.gh.reto.dto.ProductoDto;
import com.gh.reto.model.Producto;

import java.util.List;

public interface ProductoService {

    List<Producto> insertarYListarProductos(ProductoDto productoDto);


}
