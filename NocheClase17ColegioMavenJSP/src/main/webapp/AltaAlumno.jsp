<%-- 
    Document   : AltaAlumno
    Created on : 21/04/2017, 20:19:45
    Author     : dsgonzalez
--%>

<%@page import="ar.com.centro8.curso.java.jsp.JSPGenerator"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <% out.println(JSPGenerator.getHead()); %>
    <body>
        <h1>Alta Alumno</h1>
        <form method="post" action="AltaAlumnos2.jsp"/>
            <table> 
                <tr> 
                    <td> Nombre: </td> 
                    <td> <input type="text" name="nombre" required="true"/> </td>
                </tr>
                <tr> 
                    <td> Apellido: </td> 
                    <td> <input type="text" name="apellido" required="true"/> </td>
                </tr>
                <tr> 
                    <td> Edad: </td> 
                    <td> <input type="number" name="edad" min="18" max="90" required="true" /> </td>
                </tr>
                <tr> 
                    <td> Curso: </td> 
                    <td> <input type="text" name="nombre" required="true"/> </td>
                </tr>
                <tr>
                    <td> </td>
                    <td> <input type="submit" value="Agregar"/> </td>
                </tr>
            </table>
        </form>
        <div>
            <% out.println(JSPGenerator.getBack()); %>
        </div>
    </body>
</html>
