package es.juanjiga.agenciaviajes.infrastructure.abstract_services;

import java.math.BigDecimal;
import java.util.Set;

import org.springframework.data.domain.Page;

import es.juanjiga.agenciaviajes.util.SortType;

public interface CatalogServices<R> {

    Page<R>readAll(Integer page, Integer size, SortType sortTye);
    
    Set<R> readLessPrice(BigDecimal price);

    Set<R> readBetweenPrices(BigDecimal min, BigDecimal max);

    String FIELD_BY_SORT = "price";

}
