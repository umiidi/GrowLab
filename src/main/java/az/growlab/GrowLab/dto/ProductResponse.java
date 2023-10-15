package az.growlab.GrowLab.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class ProductResponse {

    private String name;
    private BigDecimal price;
    private LocalDate createdAt;
    private LocalDate updatedAt;

}
