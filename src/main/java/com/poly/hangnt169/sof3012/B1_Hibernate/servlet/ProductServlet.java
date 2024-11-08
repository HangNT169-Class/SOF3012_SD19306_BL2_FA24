package com.poly.hangnt169.sof3012.B1_Hibernate.servlet;

import com.poly.hangnt169.sof3012.B1_Hibernate.entity.Product;
import com.poly.hangnt169.sof3012.B1_Hibernate.repository.ProductRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ProductServlet", value = {
        "/product/hien-thi",
        "/product/detail",
})
public class ProductServlet extends HttpServlet {
    ProductRepository repo = new ProductRepository();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("hien-thi")){
          this.hienThiProduct(request,response);
        }else if(uri.contains("detail")){
            this.detailProduct(request,response);
        }
    }

    private void detailProduct(HttpServletRequest request, HttpServletResponse response) {
        String c = request.getParameter("c");
        Product p = repo.getOne(Long.valueOf(c));
    }

    private void hienThiProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listProduct",repo.getAll());
        request.getRequestDispatcher("/view/buoi1/product.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
