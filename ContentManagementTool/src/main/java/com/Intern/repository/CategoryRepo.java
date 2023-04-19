package com.Intern.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.Intern.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer>{

}

