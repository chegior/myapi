package com.chedrocardenas.MyApi.dao;

import com.chedrocardenas.MyApi.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface CategoryRepository extends JpaRepository<Category,Long> {

}
