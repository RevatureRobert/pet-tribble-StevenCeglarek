package petTribble.servlet;


import petTribble.controller.HomeController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addTribbleToLab")
public class AddTribbleToLabServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer tribbleId = Integer.parseInt(req.getParameter("tribble_id"));
        Integer labId = Integer.parseInt(req.getParameter("lab_id"));

        System.out.print(tribbleId +", " + labId);

        new HomeController().addTribbleToLab(tribbleId, labId);

    }
}
