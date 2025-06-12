package pl.gerono.ecommerce.catalog;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class DatabaseProductRepository implements ProductStorage {

    private final JdbcTemplate jdbcTemplate;

    public DatabaseProductRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Product loadProductById(String productId) {

        var sql = "SELECT * FROM `product__catalog__products` WHERE product_id = ?";

        var result = jdbcTemplate.queryForObject(
                sql,
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
    }




    @Override
    public List<Product> allProducts() {

        var sql = "SELECT * FROM product__catalog__products";

        var result = jdbcTemplate.query(
                sql,
                new Object[]{},
                (rs, i) -> new Product(
                       UUID.fromString( rs.getString("ID")),
                        rs.getString("NAME"),
                        rs.getString("DESCRIPTION")
                )
        );
        return result;
    }




    @Override
    public void save(Product newProduct) {
        var sql = """
            INSERT INTO `product__catalog__products` (id, name, description)
            VALUES 
                (:id, :name, :desc)
        """;

        Map<String, Object> params = new HashMap<>();
        params.put("id", newProduct.getId());
        params.put("name", newProduct.getName());
        params.put("desc", newProduct.getDescription());

        var namedJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        namedJdbcTemplate.update(sql, params);
    }


}