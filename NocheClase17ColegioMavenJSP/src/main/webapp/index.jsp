<%-- 
    Document   : index
    Created on : 21/04/2017, 19:49:48
    Author     : dsgonzalez
--%>

<%@page import="ar.com.centro8.curso.java.jsp.JSPGenerator"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <% out.println(JSPGenerator.getHead()); %>
    <body>
        <h1>Sistema de Colegio</h1>
        <h4>Menu de Opciones</h3>
        <h3> Alumnos</h3> 
        <ul>
            <li><a href=AltaAlumno.jsp> Alta de Alumno </a></li>
            <li><a href=BajaAlumno.jsp> Baja de Alumno </a></li>
            <li><a href=ModificaAlumno.jsp> Modificacion de Alumno </a></li>
            <li><a href=ListAlumno.jsp> Listado de Alumnos </a></li>
        </ul>
        <h3> Cursos</h3>
        <ul>
            <li><a href="AltaCurso.jsp"> Alta de Curso </a></li>
            <li><a href="BajaCurso.jsp"> Baja de Curso </a></li>
            <li><a href="ModificaCurso.jsp"> Modificacion de Curso </a></li>
            <li><a href="ListCurso.jsp"> Listado de Cursos </a></li>
        </ul>
    </body>
</html>
