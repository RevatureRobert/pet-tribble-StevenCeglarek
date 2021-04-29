package petTribble.service;

import petTribble.dao.TribbleDao;
import petTribble.model.Lab;
import petTribble.model.Tribble;

import java.util.List;

public class TribbleService {

    TribbleDao td = new TribbleDao();

    public List<Tribble> getAllTribbles() {
        return td.getAll();
    }

    public void createTribble(String name){
        Tribble tribble = new Tribble();
        tribble.setName(name);
        td.create(tribble);
    }

    public Tribble getTribbleById(Integer id) {
        return td.getById(id);
    }

    public void addTribbleToLab(Lab lab, Tribble tribble) {
        Integer labId = lab.getLabId();
        Integer tribbleId = tribble.getTribbleId();
        td.addTribbleToLab(tribbleId, labId);
    }

    public void deleteTribble(Tribble tribble) {
        td.delete(tribble.getTribbleId());
    }
}
