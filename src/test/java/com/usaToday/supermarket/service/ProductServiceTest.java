package com.usaToday.supermarket.service;

import com.usaToday.supermarket.dao.ProductDao;
import com.usaToday.supermarket.model.Products;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    ProductDao productDao;
    @InjectMocks
    ProductService productService;
    @Test
    void getAllProducts() {
        UUID product_id1 = UUID.randomUUID();
        UUID product_id2 = UUID.randomUUID();
        BigDecimal unit_price = BigDecimal.valueOf(2.32);
        Products product1 = new Products(product_id1, "TestFrozen", 3, "FROZEN", unit_price);
        Products product2 = new Products(product_id2, "TestFrozen2", 7, "FROZEN", unit_price);
        List<Products> expectedProducts = List.of(product1, product2);

        when(productDao.findAll()).thenReturn(expectedProducts);

        Optional<List<Products>> allProducts = Optional.ofNullable(productService.getAllProducts());

        assertEquals(2, allProducts.get().size(),"All products are not showing up");


    }

    @Test
    void getProductById() {
        UUID product_id = UUID.randomUUID();
        BigDecimal unit_price = BigDecimal.valueOf(2.32);
        Products product = new Products(product_id, "TestFrozen", 3, "FROZEN", unit_price);

        when(productDao.findById(product_id)).thenReturn(Optional.of(product));
        Optional<Products> returnedProduct = productService.getProductById(product_id);
        assertEquals(product.getName(),returnedProduct.get().getName(),"Names are not the same");
    }

    @Test
    void getProductsBySection() {
        UUID product_id1 = UUID.randomUUID();
        UUID product_id2 = UUID.randomUUID();
        BigDecimal unit_price = BigDecimal.valueOf(2.32);
        Products product1 = new Products(product_id1, "TestFrozen", 3, "FROZEN", unit_price);
        Products product2 = new Products(product_id2, "TestFrozen2", 7, "FROZEN", unit_price);
        List<Products> expectedProducts = List.of(product1, product2);

        when(productDao.findBySection("FROZEN")).thenReturn(Optional.of(expectedProducts));

        Optional<List<Products>> productsBySection = productService.getProductsBySection("FROZEN");

        assertEquals(2, productsBySection.get().size(),"No. of products not same");

    }

    @Test
    void getProductsInStock() {

        UUID product_id1 = UUID.randomUUID();
        UUID product_id2 = UUID.randomUUID();
        BigDecimal unit_price = BigDecimal.valueOf(2.32);
        Products product1 = new Products(product_id1, "TestFrozen", 3, "FROZEN", unit_price);
        Products product2 = new Products(product_id2, "TestFrozen2", 7, "FROZEN", unit_price);
        Products product3 = new Products(product_id2, "TestProduce", 0, "PRODUCE", unit_price);
        List<Products> expectedProducts = List.of(product1, product2);

        when(productDao.findInStock()).thenReturn(Optional.of(expectedProducts));

        Optional<List<Products>> productsInStock = productService.getProductsInStock();

        assertEquals(2, productsInStock.get().size(),"No. of products not same");
    }

    @Test
    void addProduct() {

        Products product = new Products();
        product.setProduct_id(UUID.randomUUID());
        product.setName("TestProduce");
        product.setQuantity(5);
        product.setSection("PRODUCE");
        product.setUnit_Price(BigDecimal.valueOf(2.02));
        String VALID_REGEX = "^[A-Z][A-Z0-9_]*$";
        DecimalFormat CURRENCY_FORMAT = new DecimalFormat("'$'0.00");

        when(productDao.save(product)).thenReturn(product);
        Products addedProduct = productService.addProduct(product);
        assertEquals(product,addedProduct,"Objects are not the same");
        assertTrue(addedProduct.getSection().matches(VALID_REGEX),"Section is not as per requirement");
//        assertTrue(Boolean.parseBoolean(CURRENCY_FORMAT.format(addedProduct.getUnit_Price())));

    }
}