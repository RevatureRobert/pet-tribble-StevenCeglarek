package petTribble.model;

import java.util.List;

public class Lab {

    private int labId;
    private String name;

    private List<Tribble> tribbles;

    public Lab() {
    }

    public Lab(int labId, String name, List<Tribble> tribbles) {
        this.labId = labId;
        this.name = name;
        this.tribbles = tribbles;
    }

    public int getLabId() {
        return labId;
    }

    public void setLabId(int labId) {
        this.labId = labId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Tribble> getTribbles() {
        return tribbles;
    }

    public void setTribbles(List<Tribble> tribbles) {
        this.tribbles = tribbles;
    }

    @Override
    public String toString() {
        return "Lab{" +
                "labId=" + labId +
                ", name='" + name + '\'' +
                ", tribbles=" + tribbles +
                '}';
    }
}
