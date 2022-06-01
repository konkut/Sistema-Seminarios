
package controlador;

import dao.participanteDaoImplementacion;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.participante;
import dao.participanteDao;
import dao.seminarioDao;
import dao.seminarioDaoImplementacion;
import modelo.seminario;

@WebServlet(name = "participanteControlador", urlPatterns = {"/participanteControlador"})
public class participanteControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            participanteDao daoPar = new participanteDaoImplementacion();
            seminarioDao daoSem = new seminarioDaoImplementacion();

            List<seminario> listaSem = null;

            participante par = new participante();
            seminario sem = new seminario();

            int id;
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch (action) {
                case "insert":
                    listaSem = daoSem.getAll();
                    request.setAttribute("listaSem", listaSem);
                    request.setAttribute("participante", par);
                    request.getRequestDispatcher("formParticipantes.jsp").forward(request, response);
                    break;
                case "update":
                    listaSem = daoSem.getAll();
                    request.setAttribute("listaSem", listaSem);
                    id = Integer.parseInt(request.getParameter("id"));
                    par = daoPar.getById(id);
                    request.setAttribute("participante", par);
                    request.getRequestDispatcher("formParticipantes.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    daoPar.delete(id);
                    response.sendRedirect("participanteControlador");
                    break;
                case "view":
                    List<participante> listaPar = daoPar.getAll();
                    request.setAttribute("participantes", listaPar);
                    request.getRequestDispatcher("participantes.jsp").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
        } catch (Exception e) {
            System.out.println("Error en el metodo GET" + e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            participante par = new participante();
            participanteDao dao = new participanteDaoImplementacion();

            int id = Integer.parseInt(request.getParameter("id"));
            String nombres = request.getParameter("nombres");
            String apellidos = request.getParameter("apellidos");
            int id_seminario = Integer.parseInt(request.getParameter("id_seminario"));
            int confirmado  = Integer.parseInt(request.getParameter("confirmado"));
            par.setId(id);
            par.setNombres(nombres);
            par.setApellidos(apellidos);
            par.setId_seminario(id_seminario);
            par.setConfirmado(confirmado);
            if (id == 0) {
                dao.insert(par);
            } else {
                dao.update(par);
            }
            response.sendRedirect("participanteControlador");
        } catch (Exception e) {
            System.out.println("Error en el metodo POST" + e.getMessage());
        }
    }

}
