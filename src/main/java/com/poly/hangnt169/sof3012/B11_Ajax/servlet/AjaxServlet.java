package com.poly.hangnt169.sof3012.B11_Ajax.servlet;

import com.google.gson.Gson;
import com.poly.hangnt169.sof3012.B11_Ajax.entity.SinhVien;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AjaxServlet", value = "/api/ajax/demo")
public class AjaxServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // B1: Tao du lieu
        SinhVien sv = new SinhVien("HE13041","Nguyen Thuy Hang",10,"Kỹ thuật phần mềm");
        // B2: Chuyen doi tu doi tuong SinhVien => Gson
        Gson gson = new Gson();
        String responseData = gson.toJson(sv);
        // B3: set lai type cua dinh dang khi chuyen di
        response.setContentType("application/json");
        // B4: Muon hien thi du lieu len giao dien
        PrintWriter out = response.getWriter();
        // B5: Gui du lieu json -> client
        out.println(responseData);
        out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
