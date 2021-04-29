package petTribble.model;

public class Tribble {

    private int tribbleId;
    private String name;

    private Lab lab;

    public Tribble() {}

    public Tribble(int tribbleId, String name, Lab lab) {
        this.tribbleId = tribbleId;
        this.name = name;
        this.lab = lab;
    }

    public int getTribbleId() {
        return tribbleId;
    }

    public void setTribbleId(int tribbleId) {
        this.tribbleId = tribbleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Lab getLab() {
        return lab;
    }

    public void setLab(Lab lab) {
        this.lab = lab;
    }

    @Override
    public String toString() {
        return "Tribble{" +
                "tribbleId=" + tribbleId +
                ", name='" + name + '\'' +
                ", lab=" + lab +
                '}';
    }

}
