package com.handehdy.northwind.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="product_id")
    private int id;

    //@Column (name="category_id")  altta joincolumna category id yi yazınca buna gerek kalmadı
    //private int categoryId;

    @Column (name="unit_price")
    private double unitPrice;

    @Column (name="product_name")
    private String productName;

    @Column (name="units_in_stock")
    private short unitsInStock;

    @Column (name="quentity_per_unit")
    private String quantityPerUnit;

    @ManyToOne()
    @JoinColumn(name ="category_id")
    private Category category;

}
