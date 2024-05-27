package com.gh.reto.repository;

import com.gh.reto.config.DataSourceConfig;
import com.gh.reto.dto.ProductoDto;
import com.gh.reto.model.Producto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.List;
import java.util.Map;

import static com.gh.reto.util.FunctionUtil.stringToDateyyyyMMdd;

@Repository
@Slf4j
public class ProductoRepository {

    private final DataSourceConfig dataSource;

    public ProductoRepository(DataSourceConfig dataSource) {
        this.dataSource = dataSource;
    }

    public List<Producto> insertarYListarProductos(ProductoDto productoDto) {
        SimpleJdbcCall jdbc = new SimpleJdbcCall(dataSource.dataSource())
                .withSchemaName("GH")
                .withProcedureName("SP_INSERT_AND_LIST_PRODUCTS")
                .declareParameters(
                        new SqlParameter("NOMBRE", Types.VARCHAR),
                        new SqlParameter("FEC_REGISTRO", Types.DATE),
                        new SqlOutParameter("SRC", Types.REF_CURSOR),
                        new SqlOutParameter("CODIGO_RPTA", Types.INTEGER),
                        new SqlOutParameter("MENSAJE_RPTA", Types.VARCHAR));
        MapSqlParameterSource in = new MapSqlParameterSource();
        in.addValue("NOMBRE", productoDto.getNombre());
        in.addValue("FEC_REGISTRO", stringToDateyyyyMMdd(productoDto.getFecRegistro()));
        Map<String, Object> out = jdbc.execute(in);
        log.info(String.format("CODIGO_RPTA: %s, MENSAJE_RPTA: %s", out.get("CODIGO_RPTA"), out.get("MENSAJE_RPTA")));
        return (List<Producto>) out.get("SRC");
    }
}
