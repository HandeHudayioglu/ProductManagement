package com.handehdy.northwind.dataAccess.abstracts;

import com.handehdy.northwind.entities.concretes.Product;
import com.handehdy.northwind.entities.dtos.ProductWithCategoryDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductDao extends JpaRepository<Product,Integer> {

    Product getByProductName(String productName);

    Product getByProductNameAndCategory_CategoryId(String productName, int categoryId);

    List<Product> getByProductNameOrCategory_CategoryId(String productName, int categoryId);

    List<Product> getByCategoryIn(List<Integer> categories); // select * from products where category_id in(1,2,3)

    List<Product> getByProductNameContains(String productName);

    List<Product> getByProductNameStartsWith(String productName);
    @Query("From Product where productName=:productName and category.categoryId=:categoryId")
    List<Product> getByNameAndCategory(String productName,int categoryId);

    @Query ("Select new com.handehdy.northwind.entities.dtos.ProductWithCategoryDto"
            +"(p.id,p.productName,c.categoryName)"
            +" From Category c Inner Join c.products p ")
    List<ProductWithCategoryDto> getProductWithCategoryDetails();
}
