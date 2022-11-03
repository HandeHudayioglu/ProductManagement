package com.handehdy.northwind.business.abstracts;

import com.handehdy.northwind.core.utilities.results.DataResult;
import com.handehdy.northwind.core.utilities.results.Result;
import com.handehdy.northwind.entities.concretes.Product;
import com.handehdy.northwind.entities.dtos.ProductWithCategoryDto;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductService {
    DataResult<List<Product>> getAll();

    DataResult<List<Product>> getAllSorted();

    DataResult<List<Product>> getAll(int pageNo, int pageSize);
    Result add(Product product);

    DataResult<Product> getByProductName(String productName);

    DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId);

    DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId);

    DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories); // select * from products where category_id in(1,2,3)

    DataResult<List<Product>> getByProductNameContains(String productName);

    DataResult<List<Product>> getByProductNameStartsWith(String productName);

    DataResult<List<Product>> getByNameAndCategory(String productName,int categoryId);

    DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails();

}
