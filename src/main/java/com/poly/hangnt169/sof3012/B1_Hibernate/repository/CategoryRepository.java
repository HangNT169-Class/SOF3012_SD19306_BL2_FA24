package com.poly.hangnt169.sof3012.B1_Hibernate.repository;

import com.poly.hangnt169.sof3012.B1_Hibernate.entity.Category1;
import com.poly.hangnt169.sof3012.B1_Hibernate.util.HibernateUtil;
import jakarta.persistence.Query;
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
    // C1: Dung ham find
    public Category1 getOne(Long id) {
        return s.find(Category1.class, id);
    }

    // SELECT * FROM Category WHERE id = ?
    // C2: Truyen tham so
    public Category1 getOne1(Long id2) {
        // B1: Tao HQL
        String hql = "SELECT c FROM Category1 c WHERE c.id1 = :a";
//        String hql = "SELECT c FROM Category1 c WHERE c.id1 = ?1 AND c.categoryName = ?2";
        // B2: Tao Query
        Query query = s.createQuery(hql);
        // B3: Set gia tri cho ts
        query.setParameter(1, id2);
//        query.setParameter(2, "C01");
        // B4: return doi tuong
        //
        Category1 cate = (Category1) query.getSingleResult();
        return cate;
    }

    // search
    public List<Category1> searchName(String name1) {
        // B1: Tao HQL
        String hql = " SELECT c FROM Category1 c WHERE c.categoryName LIKE :name";
        // B2: Tao query
        Query q = s.createQuery(hql);
        // B3: Set gia tri name
        q.setParameter("name", "%" + name1 + "%");
        // B4: return
        return q.getResultList();
    }

    // phan trang
    // C1: HQL
    // 10 pt , 3 pt/trang
    // 4 trang
    // trang vi tri dau => 3 phau (pt0-ot2)
    // trang 1 => 3 pt tiep (pt3 - pt5)
    public List<Category1> phanTrangHQL(int pageNumber, int pageSize) {
        // limit offset
        int offset = (pageNumber) * pageSize; // phan tu bat dau duoc phan trang
        // Tao cau hql
        String hql = "SELECT c FROM Category1 c ORDER BY c.id1";
        // Tao query
        Query q = s.createQuery(hql);
        // Set gia tri cho limit & offset
        q.setFirstResult(offset); // phan tu dau tien bat dau cua trang moi
//        if(pageSize >)
        q.setMaxResults(pageSize);
        // return luon list tra ra
        System.out.println(offset);
        System.out.println(pageSize);
        return q.getResultList();
    }

    // cau lenh sql
    public List<Category1> phanTrangSQL(int pageNumber, int pageSize) {
        // Set gia tri cho offset
        int offset = (pageNumber - 1) * pageSize;
        // Tao SQL
        String sql = "SELECT * from category\n" +
                "ORDER BY id\n" +
                "OFFSET :offset ROWS\n" +
                "FETCH NEXT :pageSize ROWS ONLY";
        // B3: Tao SQL
        // hql => createQuery
        // sql => createNativeQuery
        Query q = s.createNativeQuery(sql, Category1.class);
        q.setParameter("offset", offset);
        q.setParameter("pageSize", pageSize);
        return q.getResultList();
    }

    public void add(Category1 cate) {
        try {
            // Lay ra tran dang co tai thoi diem hien tai
            s.getTransaction().begin();
            // Add doi tuong => save / saveOrUpdate / persist
            s.persist(cate);
            // day di => commit
            s.getTransaction().commit();
        } catch (Exception e) {
            // Quay ve trang thai ban dau
            s.getTransaction().rollback();
        }
    }

    public void update(Category1 cate) {
        try {
            // Lay ra tran dang co tai thoi diem hien tai
            s.getTransaction().begin();
            // Update doi tuong => merge / saveOrUpdate
            s.merge(cate);
            // day di => commit
            s.getTransaction().commit();
        } catch (Exception e) {
            // Quay ve trang thai ban dau
            s.getTransaction().rollback();
        }
    }

    public void delete(Category1 cate) {
        try {
            s.getTransaction().begin(); // Mo ra 1 transation => Loi => rollback
            s.delete(cate); // Delete => merge
            s.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            // Loi => co the rollback o day
            s.getTransaction().rollback();
        }
    }

    public static void main(String[] args) {
//        System.out.println(new CategoryRepository().getAll().size());
//        System.out.println(new CategoryRepository().getAll());
//        System.out.println(new CategoryRepository().phanTrangSQL(1, 2));
//        System.out.println(new CategoryRepository().getOne1(1L));
        new CategoryRepository().phanTrangSQL(3, 2).forEach(s -> System.out.println(s));
    }
}
