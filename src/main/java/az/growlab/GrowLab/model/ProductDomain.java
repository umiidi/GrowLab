package az.growlab.GrowLab.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProductDomain {
    private Integer id;
    private String name;
    private Integer price;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
