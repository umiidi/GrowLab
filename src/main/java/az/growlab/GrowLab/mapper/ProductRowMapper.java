package az.growlab.GrowLab.mapper;

import az.growlab.GrowLab.model.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper implements RowMapper<Product> {
    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Product.builder()
                .id(rs.getInt("id"))
                .name(rs.getString("name"))
                .price(rs.getBigDecimal("price"))
                .createdAt(rs.getDate("created_at")==null ? null:rs.getDate("created_at").toLocalDate())
                .updatedAt(rs.getDate("updated_at")==null ? null:rs.getDate("updated_at").toLocalDate())
                .build();
    }
}
