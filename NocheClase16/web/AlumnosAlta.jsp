<%-- 
    Document   : AlumnosAlta
    Created on : 20/04/2017, 20:37:08
    Author     : dsgonzalez
--%>

<%@page import="ar.com.centro8.curso.java.repositories.GenericR"%>
<%@page import="ar.com.centro8.curso.java.entities.alumnos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alta Alumnos</title>
    </head>
    <body>
        <div>Alta de Alumnos</div>
                <form method="post">
			nombre: <input type="text" name="nombre"/> <br>
			apellido: <input type="text" name="apellido"/> <br>
			edad: <input type="text" name="edad"/> <br>
			curso: <input type="text" name="curso"/> <br>
			<input type="submit" value="agregar" />
		</form>
                <%
                try {
                        if(request.getParameterNames().hasMoreElements()){
                            String nombre = request.getParameter("nombre");
                            String apellido = request.getParameter("apellido");
                            int edad = Integer.parseInt(request.getParameter("edad"));
                            int curso = Integer.parseInt(request.getParameter("curso"));
                            new GenericR().save(new alumnos(nombre,apellido,curso,edad));
                            out.println("<h3>Se dio de Alta un Alumno</h3>");
                        }
                } catch (Exception e) {
                    out.println("Ocurrio un error!");
                }
                %>
    </body>
</html>
