package az.growlab.GrowLab.controller;

import az.growlab.GrowLab.model.ProductDomain;
import az.growlab.GrowLab.model.ProductRequest;
import az.growlab.GrowLab.model.ProductResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @Autowired
    private ModelMapper modelMapper;
    private HashMap<Integer, ProductDomain> products = new HashMap<>();

    @GetMapping("/{id}")
    public ProductResponse getProductById(@PathVariable Integer id) {
        return modelMapper.map(products.get(id), ProductResponse.class);
    }

    @GetMapping
    public List<ProductResponse> getProductById() {
        return products.values().stream().map(p -> modelMapper.map(p, ProductResponse.class)).collect(Collectors.toList());
    }

    @PostMapping
    public ProductResponse postProduct(@RequestBody ProductRequest pr) {
        ProductDomain pd = modelMapper.map(pr, ProductDomain.class);
        int id = products.size() + 1;
        pd.setId(id);
        pd.setCreatedAt(LocalDateTime.now());
        products.put(id, pd);
        return modelMapper.map(pd, ProductResponse.class);
    }

    @PutMapping("/{id}")
    public boolean putProduct(@PathVariable Integer id, @RequestBody ProductRequest pr) {
        try {
            ProductDomain pd = products.get(id);
            pd.setName(pr.getName());
            pd.setPrice(pr.getPrice());
            pd.setUpdatedAt(LocalDateTime.now());
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @DeleteMapping("/{id}")
    public boolean removeProduct(@PathVariable Integer id) {
        if (products.remove(id) != null) {
            return true;
        } else {
            return false;
        }
    }
}
