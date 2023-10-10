package az.growlab.GrowLab.service;

import az.growlab.GrowLab.dto.ProductRequest;
import az.growlab.GrowLab.dto.ProductResponse;
import az.growlab.GrowLab.exception.ProductException;
import az.growlab.GrowLab.model.Product;
import az.growlab.GrowLab.repo.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;
    private final ModelMapper modelMapper;

    @Override
    public ProductResponse getById(Integer id) {
        try {
            return modelMapper.map(productRepo.getById(id), ProductResponse.class);
        } catch (RuntimeException ex) {
            throw new ProductException("Product with such id was not found");
        }
    }

    @Override
    public List<ProductResponse> getAll() {
        return productRepo.getAll().stream().map(o -> modelMapper.map(o, ProductResponse.class)).collect(Collectors.toList());
    }

    @Override
    public ProductResponse add(ProductRequest pr) {
        Product pd = modelMapper.map(pr, Product.class);
        int id = productRepo.size() + 1;
        pd.setId(id);
        pd.setCreatedAt(LocalDateTime.now());
        productRepo.add(pd);
        return modelMapper.map(pd, ProductResponse.class);
    }

    @Override
    public ProductResponse update(Integer id, ProductRequest pr) {
        try {
            Product p = productRepo.getById(id);
            p.setName(pr.getName());
            p.setPrice(pr.getPrice());
            p.setUpdatedAt(LocalDateTime.now());
            return modelMapper.map(p, ProductResponse.class);
        } catch (RuntimeException ex) {
            throw new ProductException("Product with such id was not found");
        }
    }

    @Override
    public void delete(Integer id) {
        productRepo.deleteById(id);
    }

}
