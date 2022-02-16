package com.spblue4422.daangnclone.repository;

import com.spblue4422.daangnclone.model.entity.Category;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
