package com.usaToday.supermarket.dao;

import com.usaToday.supermarket.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductDao extends JpaRepository<Products, UUID> {


    @Query("SELECT p from Products p where p.Section= :section")
    Optional<List<Products>> findBySection(String section);

    @Query("SELECT p from Products p where p.Quantity>0")
    Optional<List<Products>> findInStock();
}
