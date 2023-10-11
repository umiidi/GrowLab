package az.growlab.GrowLab.controller;

import az.growlab.GrowLab.dto.ProductRequest;
import az.growlab.GrowLab.dto.ProductResponse;
import az.growlab.GrowLab.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/{id}")
    public ProductResponse getProductById(@PathVariable @Min(1) Integer id) {
        return productService.getById(id);
    }

    @GetMapping
    public List<ProductResponse> getProductById() {
        return productService.getAll();
    }

    @PostMapping
    public ProductResponse postProduct(@Valid @RequestBody ProductRequest pr) {
        return productService.add(pr);
    }

    @PutMapping()
    public ProductResponse putProduct(@RequestParam("id") @Min(1) Integer id, @Valid @RequestBody ProductRequest pr) {
        return productService.update(id, pr);
    }

    @DeleteMapping("/{id}")
    public void removeProduct(@PathVariable @Min(1) Integer id) {
        productService.delete(id);
    }
}
