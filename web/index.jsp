<%-- 
    Document   : index
    Created on : Jan 8, 2020, 7:23:17 PM
    Author     : Luigis
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.List"%>
<%@page import="estudiantes.*"%>
<%@page import="controller.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
        <title>Lista de Estudiantes</title>
    </head>
    <body>
        <div class="card shadow">
            <div class="card-header d-flex justify-content-between">
                <h5 class=" h3">Lista Estudiantes</h5>
                <a href="agregar.jsp">
                    <button class="btn btn-primary">Agregar</button>
                </a>
            </div>
            <div class="card-body text-center">
                <table class="table table-bordered table-hover">
                    <thead class="thead-dark">
                        <tr>
                            <th scope="col">Nombre</th>
                            <th scope="col">Apellido</th>
                            <th scope="col">Edad</th>
                            <th scope="col">Número</th>
                            <th scope="col">Matrícula</th>
                            <th scope="col">Acción</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            List<Estudiantes> ListaEstudiantes = (List<Estudiantes>) request.getAttribute("ListaEstudiantes");
                            pageContext.setAttribute("ListaEstudiantes", ListaEstudiantes);
                        %>
                        <!------------------------------------------------------------------------------------------------->                       
                        <c:forEach var="Listado" items="${ListaEstudiantes}">

                            <!--Link para actualizar los estudiantes----------------------------------->
                            <c:url var="actualizar" value="Controller_Estudiantes">
                                <c:param name="id_seleccionar" value="${Listado.getID()}"></c:param>
                            </c:url>
                            <!--Link para eliminar los estudiantes------------------------------------->
                            <c:url var="eliminar" value="Controller_Estudiantes">
                                <c:param name="id_eliminar" value="${Listado.getID()}"></c:param>
                            </c:url>
                            <!--Celdas para todos los estudiantes-------------------------------------->
                            <tr>
                                <td>${Listado.getNombre()}</td>
                                <td>${Listado.getApellido()}</td>
                                <td>${Listado.getEdad()}</td>
                                <td>${Listado.getNumero()}</td>
                                <td>${Listado.getMatricula()}</td>
                                <td>
                                    <a href="${actualizar}">
                                        <button  class="btn btn-warning">Editar</button>
                                    </a>
                                    <a>
                                        <button type="submit" onclick="if (confirm('¿Seguro que quieres eliminar?'))
                                                    window.location.href = '${eliminar}';
                                                else
                                                    window.location.href = '#';" class="btn btn-danger">Eliminar</button>
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
