package com.chedrocardenas.MyApi.dao;

import com.chedrocardenas.MyApi.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;


@CrossOrigin
public interface ProductRepository extends JpaRepository<Product,Long> { //< CLASS , ID of the CLASS>

    Page<Product> findByCategoryId(Long id, Pageable pageable);

    @Query(value = "SELECT * FROM Productos WHERE idCategoria=?1",nativeQuery = true)
    Page<Product> buscarProductosPorcategoria(@RequestParam("id") long id, Pageable pageable);
}
