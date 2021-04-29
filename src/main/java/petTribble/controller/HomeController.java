package petTribble.controller;

import com.google.gson.Gson;
import petTribble.model.Lab;
import petTribble.model.Tribble;
import petTribble.service.LabService;
import petTribble.service.TribbleService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class HomeController {

    Gson gson = new Gson();

    TribbleService ts = new TribbleService();
    LabService ls = new LabService();

    public void getAllTribbles(HttpServletRequest req, HttpServletResponse res) throws IOException {
        List<Tribble> allTribbles = ts.getAllTribbles();
        res.getWriter().print(gson.toJson(allTribbles));
    }

    public void addTribble(String name) {
        ts.createTribble(name);
    }

    public void addLab(String name) {
        ls.createLab(name);
    }

    public void getAllLabs(HttpServletResponse res) throws IOException {
        List<Lab> allLabs = ls.getAllLabs();
        res.getWriter().print(gson.toJson(allLabs));
    }

    public void addTribbleToLab(Integer tribbleId, Integer labId) {
        Lab lab= new Lab();
        Tribble tribble = new Tribble();
        try {
            lab = ls.findLabById(labId);
        } catch (Exception e) {
            System.err.print("There is no lab by this id, please try again");
        }
        try {
            tribble = ts.getTribbleById(tribbleId);
        } catch (Exception e) {
            System.err.print("There is no tribble by this id, please try again");
        }

        ts.addTribbleToLab(lab, tribble);
    }

    public void deleteTribble(Integer id){
        Tribble tribble = new Tribble();
        try {
            tribble = ts.getTribbleById(id);
        } catch (Exception e) {
            System.err.print("There is no tribble by this id, please try again");
        }

        ts.deleteTribble(tribble);

    }

    public void deleteLab(Integer id) {
        Lab lab= new Lab();
        try {
            lab = ls.findLabById(id);
        } catch (Exception e) {
            System.err.print("There is no lab by this id, please try again");
        }

        ls.deleteLab(lab);
    }

}
