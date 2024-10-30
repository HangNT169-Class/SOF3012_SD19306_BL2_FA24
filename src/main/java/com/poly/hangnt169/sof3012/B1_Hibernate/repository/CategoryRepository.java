package com.poly.hangnt169.sof3012.B1_Hibernate.repository;

import com.poly.hangnt169.sof3012.B1_Hibernate.entity.Category1;
import com.poly.hangnt169.sof3012.B1_Hibernate.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class CategoryRepository {
    // TRAO DOI TRUC TIEP VS CSDL (DATABASE)
    // THEM/SUA/XOA - CRUD
    private Session s;

    public CategoryRepository() {
        // MO CONG KET NOI => SESSION
        // => MO 1 LAN DUY NHAT (singleton)
        s = HibernateUtil.getFACTORY().openSession();
    }
    // Them/Sua/Xoa/Load/Detail

    // READ => SELECT
    public List<Category1> getAll() {
        // Truy van tren thuc the => FROM tu thuc the
        return s.createQuery("FROM Category1 ").list();
    }

    // Detail
    public Category1 getOne(Long id) {
        return s.find(Category1.class, id);
    }

    public void add(Category1 cate){
        try{
            // Lay ra tran dang co tai thoi diem hien tai
            s.getTransaction().begin();
            // Add doi tuong => save / saveOrUpdate / persist
            s.persist(cate);
            // day di => commit
            s.getTransaction().commit();
        }catch (Exception e){
            // Quay ve trang thai ban dau
            s.getTransaction().rollback();
        }
    }
    public void update(Category1 cate){
        try{
            // Lay ra tran dang co tai thoi diem hien tai
            s.getTransaction().begin();
            // Update doi tuong => merge / saveOrUpdate
            s.merge(cate);
            // day di => commit
            s.getTransaction().commit();
        }catch (Exception e){
            // Quay ve trang thai ban dau
            s.getTransaction().rollback();
        }
    }
    public void delete(Category1 cate){
        try{
            // Lay ra tran dang co tai thoi diem hien tai
            s.getTransaction().begin();
            // Delete doi tuong => delete
            s.delete(cate);
            // day di => commit
            s.getTransaction().commit();
        }catch (Exception e){
            // Quay ve trang thai ban dau
            s.getTransaction().rollback();
        }
    }
    public static void main(String[] args) {
        System.out.println(new CategoryRepository().getOne(1L));
    }
}
