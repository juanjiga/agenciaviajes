package es.juanjiga.agenciaviajes.api.models.response;

import java.io.Serializable;
import java.math.BigDecimal;

import es.juanjiga.agenciaviajes.util.AeroLine;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class FlyResponse implements Serializable{

    private Long id;
    private Double originLat;
    private Double originLng;
    private Double destinyLat;
    private Double destinyLng;
    private String originName;
    private String destinyName;
    private BigDecimal price;
    private AeroLine aeroLine;

}
