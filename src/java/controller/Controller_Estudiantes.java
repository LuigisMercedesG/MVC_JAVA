package controller;

import model.*;
import estudiantes.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Luigis
 */
@WebServlet(name = "Controller_Estudiantes", urlPatterns = {"/Controller_Estudiantes"})
public class Controller_Estudiantes extends HttpServlet {

    Model_Resultado resultado = null;
    Model_Seleccionar seleccionar = null;
    Model_Agregar agregar = null;
    Model_Eliminar eliminar = null;
    Model_Actualizar actualizar = null;

    /**
     *
     * @throws ServletException
     */
    @Override
    public void init() throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.

        //Inicializamos Model Resultado Con todo los estudiantes
        resultado = new Model_Resultado();
        //Inicializamos Model Insertar los estudiantes
        agregar = new Model_Agregar();
        //Inicializamos Model Seleccionar los estudiantes
        seleccionar = new Model_Seleccionar();
        //Inicializamos Model Actualizar los estudiantes
        eliminar = new Model_Eliminar();
        //Inicializamos Model Actualizar los estudiantes
        actualizar = new Model_Actualizar();
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            /* Redireccionamiento de todo el contenido del CRUD */
            try {

                //---------------------------------Modelo de Agregar Estudiantes------------------------------------------
                String Insertar = request.getParameter("insertar");

                if (Insertar != null) {
                    Estudiantes estudiantes = new Estudiantes();
                    estudiantes.setNombre(request.getParameter("nombre"));
                    estudiantes.setApellido(request.getParameter("apellido"));
                    estudiantes.setEdad(request.getParameter("edad"));
                    estudiantes.setNumero(request.getParameter("numero"));
                    estudiantes.setMatricula(request.getParameter("matricula"));
                    agregar.setEstudiante(estudiantes);
                }
                //---------------------------------Modelo de Seleccionar Estudiantes------------------------------------------
                String ID_Seleccionado = request.getParameter("id_seleccionar");
                if (ID_Seleccionado != null) {

                    Estudiantes EstudianteSeleccionado = seleccionar.setSeleccionar(ID_Seleccionado);
                    request.setAttribute("EstudianteSeleccionado", EstudianteSeleccionado);

                    RequestDispatcher pagActualizar = request.getRequestDispatcher("/actualizar.jsp");
                    pagActualizar.forward(request, response);
                }
                //---------------------------------Modelo de eliminar Estudiantes------------------------------------------
                String ID_Eliminar = request.getParameter("id_eliminar");

                if (ID_Eliminar != null) {
                    eliminar.setEliminarEstudiantes(ID_Eliminar);
                }
                //---------------------------------Modelo de Actualizar Estudiantes------------------------------------------
                String Actualizar = request.getParameter("actualizar");

                if (Actualizar != null) {
                    Estudiantes estudiantes = new Estudiantes();
                    estudiantes.setNombre(request.getParameter("nombre"));
                    estudiantes.setApellido(request.getParameter("apellido"));
                    estudiantes.setEdad(request.getParameter("edad"));
                    estudiantes.setNumero(request.getParameter("numero"));
                    estudiantes.setMatricula(request.getParameter("matricula"));
                    actualizar.setActualizarEstudiantes(estudiantes, Actualizar);
                }
                //---------------------------------Modelo de Resultado Estudiantes------------------------------------------

                /* agragamos la lista de estudiante para a el array */
                List<Estudiantes> ListaEstudiantes = resultado.getListadoEstudiantes();

                /* agragamos la lista de estudiante para al request */
                request.setAttribute("ListaEstudiantes", ListaEstudiantes);

                /* Preparamos la lista de estudiante para su despacho */
                RequestDispatcher pagIndex = request.getRequestDispatcher("/index.jsp");
                pagIndex.forward(request, response);

            } catch (SQLException ex) {
                out.print("Error SQL: " + ex.getMessage());
            }

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
