package com.poly.hangnt169.sof3012.B10_Filter.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(filterName = "AuthFilter", value = {
        // liet ke cac duong dan bat buoc phai dang nhap
//        "/demo/hien-thi","/demo/remove"
        "/demo/*","/category/*"
})
public class AuthFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
        // Dung de khoi tao
        // Khi chay vao filter chay dau tien
        // chi chay 1 lan duy nhat khi chuong trinh start
        Filter.super.init(config);
        System.out.println("Khi init");
    }
    public void destroy() {
        // Giai phong bo nho
        // => Pha huy chay cuoi cung
        // Chay cuoi cung khi ket thuc lop filter 1 lan duy nhat
        Filter.super.destroy();
        System.out.println("Khi destroy");
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
//        chain.doFilter(request, response);
        // Thuc hien o giua
        System.out.println("Do filter before");
        // B1: Goi request & response
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        // B2: Goi doi tuong trong session
        HttpSession session = httpServletRequest.getSession();
        String username = (String) session.getAttribute("user");
        String role = (String) session.getAttribute("role");
        String uri = httpServletRequest.getRequestURI();
        if(username == null){
            // chua dang nhap
            httpServletResponse.sendRedirect("/login");
        }else{
            // Thuc thien dang nhap
            // CHECK PHAN QUYEN O DAY (TAI KHOAN PHAI TON TAI) => AUTHOR
            if(role.equalsIgnoreCase("User")){
                if(uri.startsWith("/demo/")){
                    // duoc quyen truy cap
                    chain.doFilter(request,response);
                }else{
                    // nhay ra trong jsp => cam quyen (403)
                    httpServletResponse.sendRedirect("/view/buoi10/403.jsp");
                }
            }else if(role.equalsIgnoreCase("Admin")) {
                // Admin
                chain.doFilter(request,response);
            }else{
                // Vai tro khong hop le
                httpServletResponse.sendRedirect("/login");
            }
        }
        System.out.println("Do filter after");
    }
}
