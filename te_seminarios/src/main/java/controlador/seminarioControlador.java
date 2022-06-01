/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import dao.seminarioDaoImplementacion;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.seminario;
import dao.seminarioDao;
import java.sql.Date;
import java.text.SimpleDateFormat;

@WebServlet(name = "seminarioControlador", urlPatterns = {"/seminarioControlador"})
public class seminarioControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            seminarioDao dao = new seminarioDaoImplementacion();
            seminario sem = new seminario();
            int id;
            String action = (request.getParameter("action") == null) ? "view" : request.getParameter("action");
            switch (action) {
                case "insert":
                    request.setAttribute("seminario", sem);
                    request.getRequestDispatcher("formSeminarios.jsp").forward(request, response);
                    break;
                case "update":
                    id = Integer.parseInt(request.getParameter("id"));
                    sem = dao.getById(id);
                    request.setAttribute("seminario", sem);
                    request.getRequestDispatcher("formSeminarios.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("seminarioControlador");
                    break;
                case "view":
                    List<seminario> listaSem = dao.getAll();
                    request.setAttribute("listaSem", listaSem);
                    request.getRequestDispatcher("seminarios.jsp").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
        } catch (Exception e) {
            System.out.println("error en el metodo get " + e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            seminario sem = new seminario();
            seminarioDao dao = new seminarioDaoImplementacion();

            int id = Integer.parseInt(request.getParameter("id"));
            String titulo = request.getParameter("titulo");
            String fecha = request.getParameter("fecha");
            int cupo = Integer.parseInt(request.getParameter("cupo"));
            sem.setId(id);
            sem.setTitulo(titulo);
            sem.setFecha(convierteFecha(fecha));
            sem.setCupo(cupo);
            if (id == 0) {
                dao.insert(sem);
            } else {
                dao.update(sem);
            }
            response.sendRedirect("seminarioControlador");
        } catch (Exception e) {
            System.out.println("Error en el metodo POST" + e.getMessage());
        }
    }

    public Date convierteFecha(String fecha) {
        Date fechaBD = null;
        try {

            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date FechaTemporal;
            FechaTemporal = formato.parse(fecha);
            fechaBD = new Date(FechaTemporal.getTime());

        } catch (Exception e) {
            System.out.println("Error en la conversion de la fecha" + e.getMessage());
        }
        return fechaBD;
    }
}
