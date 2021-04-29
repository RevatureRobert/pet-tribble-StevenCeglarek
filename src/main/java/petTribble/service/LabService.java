package petTribble.service;

import petTribble.dao.LabDao;
import petTribble.model.Lab;
import petTribble.model.Tribble;

import java.util.List;

public class LabService {

    LabDao ld = new LabDao();

    public List<Lab> getAllLabs() {
        return ld.getAll();
    }

    public void createLab(String name) {
        Lab lab = new Lab();
        lab.setName(name);
        ld.create(lab);
    }

    public Lab findLabById(Integer id) {
        return ld.getById(id);
    }

    public void deleteLab(Lab lab) {
        ld.delete(lab.getLabId());
    }
}
