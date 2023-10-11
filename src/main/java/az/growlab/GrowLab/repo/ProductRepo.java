package az.growlab.GrowLab.repo;

import az.growlab.GrowLab.model.Product;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ProductRepo {
    private HashMap<Integer, Product> products = new HashMap<>();

    public Integer size() {
        return products.size()+1;
    }

    public Product getById(Integer id) {
        return products.get(id);
    }

    public List<Product> getAll() {
        return new ArrayList<>(products.values());
    }

    public Product add(Product p) {
        return products.put(p.getId(), p);
    }

    public Product update(Product p) {
        return products.put(p.getId(), p);
    }

    public Product deleteById(Integer id) {
        return products.remove(id);
    }

    public boolean delete(Product p) {
        return products.remove(p.getId(), p);
    }
}
