package com.poly.hangnt169.sof3012.B1_Hibernate.repository;

import com.poly.hangnt169.sof3012.B1_Hibernate.entity.Category1;
import com.poly.hangnt169.sof3012.B1_Hibernate.entity.Product;
import com.poly.hangnt169.sof3012.B1_Hibernate.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class ProductRepository {
    private Session s;

    public ProductRepository() {
        // MO CONG KET NOI => SESSION
        // => MO 1 LAN DUY NHAT (singleton)
        s = HibernateUtil.getFACTORY().openSession();
    }
    // Them/Sua/Xoa/Load/Detail

    // READ => SELECT
    public List<Product> getAll() {
        // Truy van tren thuc the => FROM tu thuc the
        return s.createQuery("FROM Product ").list();
    }
    public Product getOne(Long id) {
        return s.find(Product.class, id);
    }
}
