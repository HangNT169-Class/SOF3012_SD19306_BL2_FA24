package com.poly.hangnt169.sof3012.B10_Filter.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

// 1 duong trong servlet :
// Vua co get vua co post
@WebServlet(name = "LoginServlet", value = {
        "/login",
        "/dang-xuat"
})
public class LoginServlet extends HttpServlet {
    /**
     * Authenticator: Dung de xac nhan nguoi dung co duoc truy cap vao he thong hay khong
     * => CHECK XEM NGUOI DUNG TON TAI TRONG CSDL HAY KHONG
     * Authorization : Phan quyen nguoi dung
     * HTTP Status:
     * 401: => Khong truy cap dc (chua dang nhap)
     * 403: => Da dang nhap nhung k dc quyen truy cap vao he thong
     * Java 4: Filter (BO LOC) - LOC TAT CA CAC REQUEST DUOC GUI DI
     * JAVA 6: Spring Security
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("login")){
            request.getRequestDispatcher("/view/buoi10/login.jsp").forward(request, response);
        }else{
            // dang xuat
            // => mat session
            HttpSession session = request.getSession();
            // C1: XOA CAC SESSION CAN THIET
            // CO BN SESSION => REMOVE BANG DAY LAN
//            session.removeAttribute("user");
//            session.removeAttribute("role");
            // C2: xoa toan bo
            session.invalidate();
            response.sendRedirect("/login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // B1: Lay gia tri tu o input => request.getParameter
        String username = request.getParameter("name");
        String password = request.getParameter("pass");
        // B2: Check tai khoan:
        // Username: HangNT169/NguyenVV4
        // MK: 123456/1234567
        // HangNT169 => admin => all quyen
        // NguyenVV4 => /demo/* => bi cam quyen
        if ((username.equalsIgnoreCase("HangNT169")
                && password.equalsIgnoreCase("123456")) ||
                (username.equalsIgnoreCase("NguyenVV4")
                        && password.equalsIgnoreCase("1234567"))) {
            // Dang nhap thanh cong => Chuyen sang trang /demo/...
            HttpSession session = request.getSession();
            session.setAttribute("user", username);
            // Check quyen
            if (username.equalsIgnoreCase("HangNT169")) {
                // role => admin
                session.setAttribute("role", "Admin");
            } else {
                session.setAttribute("role", "User");
            }
            // Quay ve trang nao day (co the trang ket qua)
            response.sendRedirect("/category/hien-thi");
//            request.getRequestDispatcher("/view/buoi10/ket-qua.jsp").forward(request, response);
        } else {
            // Dang nhap fail => hien thi thong bao loi
            request.setAttribute("message", "Tai khoang hoac mat khau cua cac ban khong dung");
            request.getRequestDispatcher("/view/buoi10/login.jsp").forward(request, response);
        }
    }
}
