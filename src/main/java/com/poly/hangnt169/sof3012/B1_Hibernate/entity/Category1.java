package com.poly.hangnt169.sof3012.B1_Hibernate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// ctrl alt 0 => xoa import thua
// ctrl alt L => format trong intellij
@Table(name = "category")
@Entity // BIET DUOC TRUY VAN TREN THUC THE NAO => DANH DAU BANG ENTITY
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder // CONTRUCTOR TUY Y THAM SO
public class Category1 {
    /**
     * 1. Hibernate => Truy van tren thuc the ( class)
     * => HQL (Hibernate Query Language)
     * JDBC : Select * FROM table(trong SQL)
     * Hibernate: Select thuc the * From Thuc the ( TRONG HQL)
     * ORM(Object Relational Mapping)
     *      => MAPPING TOAN BO THUC THE & CAC MOI QUAN HE TRONG SQL
     */
    // Khai bao cac thuoc tinh trong category
    @Id // Thuoc tinh duoc danh dau la khoa chinh => @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // TU TANG KHOA CHINH
    @Column(name = "id")
    private Long id1;
    @Column(name = "category_code")
    private String categoryCode;

    @Column(name = "category_name")
    private String categoryName;

}
