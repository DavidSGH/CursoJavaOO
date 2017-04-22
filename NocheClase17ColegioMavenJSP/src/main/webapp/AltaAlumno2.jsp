<%-- 
    Document   : AltaAlumno2
    Created on : 21/04/2017, 21:58:32
    Author     : dsgonzalez
--%>

<%@page import="ar.com.centro8.curso.java.repositories.GenericR"%>
<%@page import="ar.com.centro8.curso.java.entities.alumnos"%>
<%@page import="ar.com.centro8.curso.java.jsp.JSPGenerator"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <% out.println(JSPGenerator.getHead()); %>
    <body>
        <%
            try {
                String nombre = request.getParameter("nombre");
                String apellido = request.getParameter("apellido");
                int edad = Integer.parseInt(request.getParameter("edad"));
                int curso = Integer.parseInt(request.getParameter("curso"));
                new GenericR().save(new alumnos(nombre,apellido,edad,curso));
            } catch (Exception e) {
                out.println("Ocurrio un Error.");
            }
        %>
        
        <div>
            <% out.println(JSPGenerator.getBack()); %>
        </div>
    </body>
</html>
