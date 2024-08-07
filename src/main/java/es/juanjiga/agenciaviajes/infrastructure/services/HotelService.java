package es.juanjiga.agenciaviajes.infrastructure.services;

import java.math.BigDecimal;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import es.juanjiga.agenciaviajes.api.models.response.HotelResponse;
import es.juanjiga.agenciaviajes.domain.entities.HotelEntity;
import es.juanjiga.agenciaviajes.domain.repositories.HotelRepository;
import es.juanjiga.agenciaviajes.infrastructure.abstract_services.IHotelService;
import es.juanjiga.agenciaviajes.util.SortType;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;



@Transactional
@Service
@AllArgsConstructor
public class HotelService implements IHotelService {

    private final HotelRepository hotelRepository;


    @SuppressWarnings("null")
    @Override
    public Page<HotelResponse> readAll(Integer page, Integer size, SortType sortType) {
       PageRequest pageRequest = null;
       switch (sortType) {
        case NONE -> pageRequest = PageRequest.of(page, size);
        case LOWER -> pageRequest = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).ascending());
        case UPPER -> pageRequest = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).descending());      
       }
        return this.hotelRepository.findAll(pageRequest).map(this::entityToResponse);
    }

    @Override
    public Set<HotelResponse> readLessPrice(BigDecimal price) {
       return this.hotelRepository.findByPriceLessThan(price)
                .stream()
                .map(this::entityToResponse)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<HotelResponse> readBetweenPrices(BigDecimal min, BigDecimal max) {
        return this.hotelRepository.findByPriceBetween(min, max)
               .stream()
               .map(this::entityToResponse)
               .collect(Collectors.toSet());
    }

    @Override
    public Set<HotelResponse> ratingGreaterThan(Integer rating) {
        return this.hotelRepository.findByRatingGreaterThan(rating)
               .stream()
               .map(this::entityToResponse)
               .collect(Collectors.toSet());
        
    }

    @Override
    public Set<HotelResponse> readByRating(Integer rating) {
        return this.hotelRepository.findByRatingGreaterThan(rating)
               .stream()
               .map(this::entityToResponse)
               .collect(Collectors.toSet());
        
    }


    

    private HotelResponse entityToResponse(HotelEntity entity){
        HotelResponse response = new HotelResponse();
        BeanUtils.copyProperties(entity, response);
        return response;
    }
    
}
