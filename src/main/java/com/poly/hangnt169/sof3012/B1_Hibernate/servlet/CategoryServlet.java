package com.poly.hangnt169.sof3012.B1_Hibernate.servlet;

import com.poly.hangnt169.sof3012.B1_Hibernate.entity.Category1;
import com.poly.hangnt169.sof3012.B1_Hibernate.repository.CategoryRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "CategoryServlet", value = {
        "/category/hien-thi", // GET
        "/category/detail",  // GET
        "/category/delete", // GET
        "/category/view-update", // GET
        "/category/update",// POST
        "/category/add",// POST
        "/category/view-add",// GET
        "/category/search"// GET
})
public class CategoryServlet extends HttpServlet {

    private CategoryRepository categoryRepository = new CategoryRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 6 get => uri
        // localhost:8080/category/hien-thi => url => StringBuilder
        // B1: Lay ra 1 uri
        String uri = request.getRequestURI();
        System.out.println(uri);
        // B2: Kiem tra xem uri thuoc ham nao
        if (uri.contains("hien-thi")) {
            // hien thi
            this.hienThiCategory(request, response);
        } else if (uri.contains("detail")) {
            // detail
            this.detailCategory(request, response);
        } else if (uri.contains("delete")) {
            //delete
            this.deleteCategory(request, response);
        } else if (uri.contains("view-update")) {
            //view-update
            this.viewUpdateCategory(request, response);
        } else if (uri.contains("view-add")) {
            //view-add
            this.viewAddCategory(request, response);
        } else {
            //search
            this.searchCategory(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("update")) {
            //update
            this.updateCategory(request, response);
        } else {
            //add
            this.addCategory(request, response);
        }
    }

    private void addCategory(HttpServletRequest request, HttpServletResponse response) {
    }

    private void updateCategory(HttpServletRequest request, HttpServletResponse response) {
    }

    private void viewUpdateCategory(HttpServletRequest request, HttpServletResponse response) {
    }

    private void viewAddCategory(HttpServletRequest request, HttpServletResponse response) {
    }

    private void searchCategory(HttpServletRequest request, HttpServletResponse response) {
    }

    private void deleteCategory(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // B1: Lay gia tri tren duong dan
        // Lay gia tri tu phia (view - jsp) => servlet
        String id = request.getParameter("a1");
        System.out.println(id);
        // B2: Xoa
        Category1 cate = categoryRepository.getOne(Long.valueOf(id));
        System.out.println(cate);

        categoryRepository.delete(cate);
        System.out.println(categoryRepository.getAll());

        // B3: Quay ve trang chu
        response.sendRedirect("/category/hien-thi");
    }

    private void detailCategory(HttpServletRequest request, HttpServletResponse response) {
    }

    private void hienThiCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category1>a = categoryRepository.getAll();
        // Day gia tri tu phia servlet => jsp (request.setAttribute)
        request.setAttribute("a1",a);
        // Chuyen trang
        request.getRequestDispatcher("/view/buoi1/categorys.jsp").forward(request,response);
    }
}
