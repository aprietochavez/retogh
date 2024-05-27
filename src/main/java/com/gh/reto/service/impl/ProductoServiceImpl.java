package com.gh.reto.service.impl;

import com.gh.reto.dto.ProductoDto;
import com.gh.reto.model.Producto;
import com.gh.reto.repository.ProductoRepository;
import com.gh.reto.service.ProductoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;

    @Override
    public List<Producto> insertarYListarProductos(ProductoDto productoDto) {
        return productoRepository.insertarYListarProductos(productoDto);
    }

}