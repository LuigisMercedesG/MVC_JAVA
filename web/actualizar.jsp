<%-- 
    Document   : actualizar
    Created on : Jan 10, 2020, 7:22:10 PM
    Author     : Luigis
--%>
<%@page import="estudiantes.*"%>
<%@page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
        <title>Actualizar Estudiantes</title>
    </head>
    <body>
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-8">
                    <div class="card shadow">
                        <div class="card-header d-flex justify-content-between">
                            <h3 class="font-weight-bold">Actualizar Estudiante</h3>                      
                        </div>
                        <div class="card-body">
                            <%
                                Estudiantes Estudiante = (Estudiantes) request.getAttribute("EstudianteSeleccionado");
                                pageContext.setAttribute("Estudiante", Estudiante);
                            %>
                            <form method="POST" action="Controller_Estudiantes">
                                <input name="actualizar" value="${Estudiante.getID()}" hidden="true">
                                <div class="form-group form-row">
                                    <label for="formGroup" class="col-form-label col-sm-2">Nombre:</label>
                                    <input name="nombre" type="text" class="form-control col-sm-10" id="formGroup" value="${Estudiante.getNombre()}">
                                </div>
                                <div class="form-group form-row">
                                    <label for="formGroup" class="col-form-label col-sm-2">Apellido:</label>
                                    <input name="apellido" type="text" class="form-control col-sm-10" id="formGroup" value="${Estudiante.getApellido()}">
                                </div>
                                <div class="form-group form-row">
                                    <label for="formGroup" class="col-form-label col-sm-2">Edad:</label>
                                    <input name="edad" type="text" class="form-control col-sm-10" id="formGroup" value="${Estudiante.getEdad()}">
                                </div>
                                <div class="form-group form-row">
                                    <label for="formGroup" class="col-form-label col-sm-2">Numero:</label>
                                    <input name="numero" type="text" class="form-control col-sm-10" id="formGroup" value="${Estudiante.getNumero()}">
                                </div>
                                <div class="form-group form-row">
                                    <label for="formGroup" class="col-form-label col-sm-2">Matricula</label>
                                    <input name="matricula" type="text" class="form-control col-sm-10" id="formGroup" value="${Estudiante.getMatricula()}">
                                </div>
                                <div class="form-group d-flex justify-content-center">
                                    <button type="submit" class="btn btn-primary mb-2">Actualizar</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
