package az.growlab.GrowLab.repo;

import az.growlab.GrowLab.mapper.ProductRowMapper;
import az.growlab.GrowLab.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
@RequiredArgsConstructor
public class ProductRepo {

    private final NamedParameterJdbcTemplate productJdbcTemplate;

    public Product getById(Integer id) {
        String query = "select * from product where id = :id";
        Product p = null;
        try {
            p = productJdbcTemplate.queryForObject(query, new MapSqlParameterSource()
                            .addValue("id", id),
                    new ProductRowMapper());
        } finally {
            return p;
        }
    }

    public List<Product> getAll() {
        String query = "select * from product";
        List<Product> list = productJdbcTemplate.query(query, new ProductRowMapper());
        return list;
    }

    public Product save(Product p) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String query = "insert into product(name, price, created_at) values(:name, :price, :created_at)";
        productJdbcTemplate.update(
                query,
                new MapSqlParameterSource()
                        .addValue("name", p.getName())
                        .addValue("price", p.getPrice())
                        .addValue("created_at", p.getCreatedAt()),
                keyHolder
        );
        return p;
    }

    public Product update(Product p) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String query = "update product set name = :name, price = :price, updated_at = :updated_at where id = :id";
        productJdbcTemplate.update(
                query,
                new MapSqlParameterSource()
                        .addValue("id", p.getId())
                        .addValue("name", p.getName())
                        .addValue("price", p.getPrice())
                        .addValue("updated_at", p.getUpdatedAt()),
                keyHolder
        );
        return p;
    }

    public boolean deleteById(Integer id) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String query = "delete from product where id = :id";
        productJdbcTemplate.update(
                query,
                new MapSqlParameterSource()
                        .addValue("id", id),
                keyHolder
        );
        return true;
    }

    public boolean delete(Product p) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String query = "delete from product where id = :id";
        productJdbcTemplate.update(
                query,
                new MapSqlParameterSource()
                        .addValue("id", p.getId()),
                keyHolder
        );
        return true;
    }
}
