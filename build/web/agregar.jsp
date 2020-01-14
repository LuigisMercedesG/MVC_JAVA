<%-- 
    Document   : actualizar
    Created on : Jan 10, 2020, 9:49:58 AM
    Author     : Luigis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
        <title>Insertar Estudiantes</title>
    </head>
    <body>
        <div class="container">
            <div class="d-flex justify-content-center">
                <div class="col-sm-8">
                    <div class="card shadow">
                        <div class="card-header h3 font-weight-bold">
                            Insertar Estudiante
                        </div>
                        <div class="card-body">
                            <form method="POST" action="Controller_Estudiantes">
                                <input name="insertar" value="Insertar" hidden="true">
                                <div class="form-group form-row">
                                    <label for="formGroup" class="col-sm-2 col-form-label">Nombre:</label>
                                    <div class="col-sm-10">
                                        <input name="nombre" type="text" class="form-control">
                                    </div>
                                </div>
                                <div class="form-group form-row">
                                    <label for="formGroup" class="col-sm-2 col-form-label">Apellido</label>
                                    <div class="col-sm-10">
                                        <input name="apellido" type="text" class="form-control">
                                    </div>
                                </div>
                                <div class="form-group form-row">
                                    <label for="formGroup" class="col-sm-2 col-form-label">Edad:</label>
                                    <div class="col-sm-10">
                                        <input name="edad" type="text" class="form-control">
                                    </div>
                                </div>
                                <div class="form-group form-row">
                                    <label for="formGroup" class="col-sm-2 col-form-label">Numero:</label>
                                    <div class="col-sm-10">
                                        <input name="numero" type="text" class="form-control">
                                    </div>
                                </div>
                                <div class="form-group form-row">
                                    <label for="formGroup" class="col-sm-2 col-form-label">Matricula:</label>
                                    <div class="col-sm-10">
                                        <input name="matricula" type="text" class="form-control">
                                    </div>
                                </div>
                                <div class="formGroup d-flex justify-content-center">
                                    <button type="submit" class="btn btn-primary">Insertar</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
