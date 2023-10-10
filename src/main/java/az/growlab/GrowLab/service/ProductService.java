package az.growlab.GrowLab.service;

import az.growlab.GrowLab.dto.ProductRequest;
import az.growlab.GrowLab.dto.ProductResponse;

import java.util.List;

public interface ProductService {

    List<ProductResponse> getAll();

    ProductResponse getById(Integer id);

    ProductResponse add(ProductRequest pr);

    ProductResponse update(Integer id, ProductRequest pr);

    void delete(Integer id);
}
