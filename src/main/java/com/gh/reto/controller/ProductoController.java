package com.gh.reto.controller;

import com.gh.reto.dto.ProductoDto;
import com.gh.reto.model.Producto;
import com.gh.reto.service.ProductoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@Slf4j
@RestController
@RequestMapping("/api/v1/producto")
@RequiredArgsConstructor
public class ProductoController {

    private final ProductoService productoService;

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Producto>> insertarYListarProductos(@RequestBody ProductoDto productoDto) {
        return ResponseEntity.ok(productoService.insertarYListarProductos(productoDto));
    }


}