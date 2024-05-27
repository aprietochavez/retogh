package com.gh.reto;

import com.gh.reto.dto.ProductoDto;
import com.gh.reto.model.Producto;
import com.gh.reto.repository.ProductoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class RetoApplicationTest {

    @Autowired
    private ProductoRepository productoRepository;

    @Test
    public void givenEmployees_whenGetEmployees_thenStatus200()
            throws Exception {

        createTestEmployee("bob");

        mvc.perform(get("/api/employees")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].name", is("bob")));
    }

    @Test
    @Rollback(false)
    public void testInsertarYListarProductos() {
        ProductoDto productoDto = new ProductoDto("User ABC", "20240526");
        List<Producto> lstProductos = productoRepository.insertarYListarProductos(productoDto);
        assertNotNull(lstProductos);
    }

}
