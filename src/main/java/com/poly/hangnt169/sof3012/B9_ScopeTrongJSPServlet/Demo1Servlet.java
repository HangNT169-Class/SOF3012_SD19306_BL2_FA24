package com.poly.hangnt169.sof3012.B9_ScopeTrongJSPServlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "Demo1Servlet", value = "/Demo1Servlet")
public class Demo1Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lay session
        HttpSession session = request.getSession();
        String str = (String) session.getAttribute("message4");
        // dung gia tri str nhu bien request
        request.setAttribute("str1",str);
        request.getRequestDispatcher("/view/buoi9/demo1.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
