package az.growlab.GrowLab.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
@Deprecated
public class ProductDto {
    private Integer id;
    private String name;
    private Integer price;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
