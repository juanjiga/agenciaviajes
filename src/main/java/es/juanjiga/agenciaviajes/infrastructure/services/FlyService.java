package es.juanjiga.agenciaviajes.infrastructure.services;

import java.math.BigDecimal;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import es.juanjiga.agenciaviajes.api.models.response.FlyResponse;
import es.juanjiga.agenciaviajes.domain.entities.FlyEntity;
import es.juanjiga.agenciaviajes.domain.repositories.FlyRepository;
import es.juanjiga.agenciaviajes.infrastructure.abstract_services.IFlyService;
import es.juanjiga.agenciaviajes.util.SortType;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Transactional
@Service
@AllArgsConstructor
public class FlyService implements IFlyService {

    private final FlyRepository flyRepository;

    @Override
    public Page<FlyResponse> readAll(Integer page, Integer size, SortType sortType) {
       PageRequest pageRequest = null;
       switch (sortType) {
        case NONE -> pageRequest = PageRequest.of(page, size);
        case LOWER -> pageRequest = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).ascending());
        case UPPER -> pageRequest = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).descending());
        
            
         
       }
        return this.flyRepository.findAll(pageRequest).map(this.entityToResponse);
    }

    @Override
    public Set<FlyResponse> readLessPrice(BigDecimal price) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Set<FlyResponse> readByOriginDestiny(String origin, String destiny) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Set<FlyResponse> readBetweenPrices(BigDecimal min, BigDecimal max) {
        // TODO Auto-generated method stub
        return null;
    }

    private FlyResponse entityToResponse(FlyEntity entity){
        FlyResponse response = new FlyResponse();
        BeanUtil copyProperties(entity, response);
        return response;
    }
    
}
