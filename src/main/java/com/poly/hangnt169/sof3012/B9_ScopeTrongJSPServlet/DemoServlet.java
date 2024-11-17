package com.poly.hangnt169.sof3012.B9_ScopeTrongJSPServlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "DemoServlet", value = "/DemoServlet")
public class DemoServlet extends HttpServlet {
    /**
     * Doi Java bt => Cac pham vi truy cap bien/ham => access modifier
     * JSP/Servlet (request gui) - yeu cau tu phia nguoi dung (khach hang den nha hang)
     * => Co cac phan vi khac nhau (Scope trong JSP/Servlet)
     * 4 Scope co ban:
     * 1. Session
     * 2. Application
     * 3. Request
     * 4. Page
     * VD: requset.setAttribute(ts1,ts1)
     * => session.setAttribute(ts1,ts2)
     * => application.setAttribute(ts1,ts2)
     * component 1 - file jsp1                               component 3 - file jsp3
     *                                  Pham vi truy cap
     * component 2 - file jsp2                               component 4 - file jsp4
     * Tat ca cac scope deu co cac ham:
     * ts1: Ten bien ma jsp se dung
     * ts1: Gia tri duoc truyen vao bien - 1 String, 1 Object, 1 List Object....
     * Phia servlet
     * 1. <scope>.setAttribute(ts1 - String, ts2 - Object)
     * 2. <scope>.getAttribute(String) - ten bien o ts1 ma chung ta truyen o dong 31
     * 3. <scope>.removeAttribute(String) - ten bien o ts1 ma chung ta truyen o dong 31
     * Phia jsp : cung the goi duoc gia tri
     * 1. Request
     * => CHI CO GIA TRI 1 CHIEU (SERVLET -> JSP)
     * NEU SERVLET K SETATTRIBUTE (TUC LA K DAY GIA TRI) => JSP KHONG CO GIA TRI DE HIEN THI
     * => CHI TON TAI GIA TRI: SERVLET 1 -> JSP 1
     * (SERVLET 2, JSP 2 : KHONG GIA TRI. VA DAY LA GIA TRI 1 CHIEU)
     * => REQUEST K CAN REMOVE VI NO CHI CO GIA TRI TU SERVLET 1 -> JSP 1
     * 2. Page
     * => Tuong tu nhu request nhung k dung duoc o servlet (CHI DUNG DUOC O JSP)
     * => Chi duoc xy ly o jsp ( Khong chia se du lieu vs servlet/jsp khac) => Chi ton tai trong jsp hien tai
     * => Luu tru cuc bo
     * 3. Application
     * - Co the duoc goi ra o cac request/jsp khac
     * - servlet 1 -> jsp 1
     * - servlet 2 & jsp 2 ( van the goi cac bien application o servlet 1 ra de su dung)
     * => Thuong luu cache de giam su truy van den CSDL
     * DS bang SP - load tu CSDL
     * => Detail: getOne => Truy van toi CSDL
     * => Detail : ton tai ca => get tu cache len => truy van vao csdl
     * Bien Application co gia tri => BAT BUOC PHAI CHAY DUONG DAN MA BIEN APPLICATION
     * DUOC SET VALUE TRUOC => MOI CO GIA TRI DE CAC DUONG KHAC LAY VALUE CUA BIEN APPLICATION
     * Luu y:
     * - Pham vi : Danh cho tat ca nguoi dung ung dung trong thoi gian ma ung dung hoat dong
     * => Application co valu den khi ma chuong trinh dung hoat dong thi dung.
     * => La du lieu toan cuc
     * => APPLICATION CHI BI GIAI PHONG TAI NGUYEN KHI UNG DUNG BI SHUTDOWN
     * PHU HOP VS VIEC LUU CACHE DU LIEU
     * 4. Session
     *  - Dung de chia se du lieu toi cac request hoat dong trong 1 phien lam viec
     *  - Servlet 1 -> jsp 1
     *  - Serlvet 2, jsp2 : Van co the lay dc gia tri cua session
     *  => TIMEOUT (THOI GIAN SONG) CUA SESSION SE DUOC GIAI PHONG KHI ATTRIBUTE GIAI PHONG
     *  => DEFAULT SESSION 30 PHUT.
     *  co the cau hinh thoi gian song cua session trong web.xml
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Goi application:
        ServletContext application = getServletContext();
        application.setAttribute("message3", "Test demo scope JSP - application");
        request.setAttribute("message2", "Test demo scope JSP - request");
        // Goi session
        HttpSession session = request.getSession();
        session.setAttribute("message4","Test demo scope JSP - session");
        request.getRequestDispatcher("/view/buoi9/demo.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
