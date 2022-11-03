package com.handehdy.northwind.api.controllers;

import com.handehdy.northwind.business.abstracts.ProductService;
import com.handehdy.northwind.core.utilities.results.DataResult;
import com.handehdy.northwind.core.utilities.results.Result;
import com.handehdy.northwind.dataAccess.abstracts.ProductDao;
import com.handehdy.northwind.entities.concretes.Product;
import com.handehdy.northwind.entities.dtos.ProductWithCategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/products")
@CrossOrigin  //dışarıdan erişime izin için eklemek lazım
public class ProductController {

    private ProductService productService;
    private ProductDao productDao;

    @Autowired
    public ProductController(ProductService productService,ProductDao productDao) {
        super();
        this.productService = productService;
        this.productDao = productDao;
    }
    @GetMapping("/getall")
    public DataResult<List<Product>> getAll(){
        return this.productService.getAll();
    }
    @PostMapping("/add")
    public Result add(@RequestBody Product product){
        return this.productService.add(product);
    }
    @GetMapping("/getbyproductname")
    public DataResult<Product> getByProductName(@RequestParam String productName){
        return this.productService.getByProductName(productName);
    }
    @GetMapping("/getByProductNameAndCategoryId")
    public DataResult<Product> getByProductNameAndCategoryId(@RequestParam String productName,@RequestParam int categoryId){

        return this.productService.getByProductNameAndCategoryId(productName,categoryId);
    }
    @GetMapping("/getByProductNameContains")
    public DataResult<List<Product>> getByProductNameContains(@RequestParam String productName){
         return this.productService.getByProductNameContains(productName); //mesela parametre olarak ab verirsek ürün isminde "ab" içerenler geliyor
    }
    @GetMapping("/getAllByPage")
    public DataResult<List<Product>> getAll(int pageNo, int pageSize){
        return this.productService.getAll(pageNo,pageSize);
    }
    @GetMapping("/getAllSorted")
    public DataResult<List<Product>> getAllSorted(){
        return this.productService.getAllSorted();
    }
    @GetMapping("/getProductWithCategoryDetails")
    public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails(){
        return this.productService.getProductWithCategoryDetails();
    }
}
