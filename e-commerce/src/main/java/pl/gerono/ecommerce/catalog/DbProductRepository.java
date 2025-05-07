package pl.gerono.ecommerce.catalog;

import jakarta.websocket.OnError;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class DbProductRepository {
    private final jdbcTemplate jdbcTemplate;

    public DbProductRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = new jdbcTemplate;
    }
    
    
    @Override
    public List<Product> allProducts() {
        var result = jdbcTemplate.query("SELECT * FROM `product__catalog__products`",
                (rs, i) -> {
                    var product = new Product(
                            UUID.fromString(rs.getString("ID")),
                            rs.getString("NAME"),
                            rs.getString("DESCRIPTION")
                    );
                    return product;
                }
        );
        
        return result;
};
    
    @Override
    public void save(Product newProduct) {
        // check if product exists -> update
        var sql = """
                INSERT INTO `product__catalog__products` (id, name, description)
                VALUES
                    (:id,:name,:desc);
                """;

        Map<String, Object> params = new HashMap<>();
        params.put("id",newProduct.getProductId());
        params.put("name",newProduct.getName());
        params.put("desc",newProduct.getDescription());

        var namedJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        namedJdbcTemplate.update(sql,params);
    }

    @Override
    public Product loadProductById(String productId) {
        var result = jdbcTemplate.queryForObject("SELECT * FROM `product__catalog__products` WHERE id = ?",
                new Object[]{productId},
                (rs, i) -> {
                    var product = new Product(
                            UUID.fromString(rs.getString("ID")),
                            rs.getString("NAME"),
                            rs.getString("DESCRIPTION")
                    );
                    return product;
                });
        return result;
    };
