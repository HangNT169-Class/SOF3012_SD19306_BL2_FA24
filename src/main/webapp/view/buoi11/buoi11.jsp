<%--
  Created by IntelliJ IDEA.
  User: hangnt169
  Date: 20/11/24
  Time: 08:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Ajax data</h1>
    <button onclick="getData()">Click me - Data </button>
    <div id="result"></div>
</body>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script>
    function  getData(){
        $.ajax({
            url:"/api/ajax/demo", // URL LAY TU SERVLET => VALUE
            type:"GET",
            dataType:"json" ,// KIEU DU LIEU TRA VE
            success: function (response) {
                // Khi api tra ra thanh cong
                const sinhVien = response;
                // Hien thi response => len giao dien
                console.log(response)
                document.getElementById("result").innerHTML =
                    `MSSV: ` + sinhVien.maSV +
                    `Ho Ten: ` + sinhVien.hoTen+
                    `Tuoi:` +sinhVien.tuoi +
                    `Nganh hoc:` + sinhVien.nganhHoc
            },
            error: function () {
                // Khi bi loi
                document.getElementById("result").innerHTML = `Bi loi roi day`
            }
        })
    }
</script>
</html>
