package az.growlab.GrowLab.dto;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class ProductRequest {
    @NotNull(message = "name cannot be null")
    @NotBlank(message = "name cannot be blank")
    private String name;

    @Min(value = 0, message = "price min must be 1")
    @NotNull(message = "price cannot be null")
    private BigDecimal price;
}
