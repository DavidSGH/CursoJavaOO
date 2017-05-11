<%-- 
    Document   : index
    Created on : 20/04/2017, 20:05:50
    Author     : dsgonzalez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello JSP!</h1>
        <%
          //codigo JSP
          out.println("<h2> Codigo JSP </h2>");
          
        /*
            try {
                int nro1 = Integer.parseInt(request.getParameter("nro1"));
                int nro2 = Integer.parseInt(request.getParameter("nro2"));
                out.println("<h3>Suma="+(nro1+nro2)+"</h3>");
            } catch (Exception e) {
                out.println("<h3>Ocurrio un error.</h3>");
            }
        */
        out.println("<a href='AlumnosAlta.jsp'>Alta Alumnos</a>");
        %>
    </body>
</html>
