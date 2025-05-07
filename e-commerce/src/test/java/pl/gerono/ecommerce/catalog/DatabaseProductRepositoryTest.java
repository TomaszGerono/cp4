package pl.gerono.ecommerce.catalog;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import pl.gerono.ecommerce.catalog.Product;
import pl.gerono.ecommerce.catalog.ProductRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class DatabaseProductRepositoryTest {

    @Autowired
    JdbcTemplate jdbcTemplate;


    private ProductRepository thereIsProductRepository() {
        return new DbProductRepository(jdbcTemplate);
    }


    @BeforeEach
    void setupDatabase() {
        jdbcTemplate.execute("DROP TABLE `product__catalog__products` IF EXISTS");

        var sql = """
                    CREATE TABLE `product__catalog__products` (
                    id VARCHAR(100) NOT NULL,
                    name VARCHAR(50) NOT NULL,
                    description VARCHAR(144) NOT NULL,
                    cover DECIMAL(12,2),
                    PRIMARY KEY(id)
                    );
                """;

        jdbcTemplate.execute(sql);
    }


    @Test
    void itQueryDb() {
        var sql = "SELECT now() curr_time";
        var result = jdbcTemplate.queryForObject(sql, String.class);

        assert result.contains("2025");
    }

    @Test
    void initialProductTableIsEmpty() {
        var result = jdbcTemplate.queryForObject(
                "SELECT COUNT(*) FROM `product__catalog__products`", Integer.class);

        assert result == 0;
    }


    @Test
    void insertSomeProductV1() {
        var sql = """
                INSERT INTO `product__catalog__products` (id, name, description)
                VALUES
                    ('51061b5f-0ff7-432c-8ed2-94edcfaf53ba'. 'nice product 1', 'nice one'),
                    ('df27e2e4-9d33-48cd-9896-03a76af38557'. 'nice product 2', 'nice one')
                """;

        jdbcTemplate.execute(sql);

        var result = jdbcTemplate.queryForObject(
                "SELECT COUNT(*) FROM `product__catalog__products", Integer.class);

        assert result == 2;
    }

    @Test
    void insertSomeProductV2DynamicValues() {
        var sql = """
                INSERT INTO `product__catalog__products` (id, name, description)
                VALUES
                    (?,?,?);
                """;

        jdbcTemplate.update(sql,"c22929cc-fff6-4328-8231-8e778668bafc","product X","nice product X");

        var result = jdbcTemplate.queryForObject(
                "SELECT COUNT(*) FROM `product__catalog__products",
                    Integer.class);

        assert result == 1;
    }

    @Test
    void insertSomeProductV3DynamicValueNamedParameters() {
        var sql = """
                INSERT INTO `product__catalog__products` (id, name, description)
                VALUES
                    (:id,:name,:desc);
                """;

        Map<String, Object> params = new HashMap<>();
        params.put("id","");
        params.put("name","product Z");
        params.put("desc","nice product z");

        var namedJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        namedJdbcTemplate.update(sql,params);

        var result = jdbcTemplate.queryForObject(
                "SELECT COUNT(*) FROM `product__catalog__products",
                Integer.class);

        assert result == 1;
    }


    @Test
    void itStoresAndLoadsProduct() {
        Product product = thereIsProduct();
        ProductRepository repository = thereIsProductRepository();

        repository.save(product);

        Product loaded = repository.getProductById(product.getProductId());

        assertEquals(product.getId(), loaded.getId());
        assertEquals(product.getName(), loaded.getName());
        assertEquals(product.getDescription(), loaded.getDescription());
    }

    @Test
    void itLoadsAllProducts() {
        Product product = thereIsProduct();
        ProductRepository repository = thereIsProductRepository();

        repository.save(product);

        List<Product> products = repository.allProducts();

        assertEquals(1, products.size());
    }

    private Product thereIsProduct() {
        return new Product(UUID.randomUUID(), "test", "desc");
    }
}
