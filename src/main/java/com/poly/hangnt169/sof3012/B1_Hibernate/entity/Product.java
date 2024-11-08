package com.poly.hangnt169.sof3012.B1_Hibernate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "product")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "product_code")
    private String productCode;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "price")
    private Float price;

    @Column
    private String description;

    // 1 Product -> N category
    // 1 category -> 1 product
    // 1-1: OneToOne
    // 1-N: OneToMany
    // N-1: ManyToOne
    // N-N: ManyToMany

    // Cach mapping khoa ngoai
    // N-1: ManyToOne
    // fetch:
    // + fetch: Lazy: luoi : dung den dau load den day => cham
    // + fetch: Eager: load tat ca: k dung cung lay => lang phi tai nguyen
    // Default cua manytoone=> fetch eager
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category1 cate;

}
