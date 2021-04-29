package petTribble.dao;

import petTribble.model.Lab;
import petTribble.model.Tribble;
import petTribble.util.ConnectionSession;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TribbleDao implements DaoUtil<Tribble, Integer> {

    LabDao ld = new LabDao();

    @Override
    public Tribble getById(Integer id) {
        String sql = "SELECT * FROM tribbles WHERE tribble_id = ?";
        Tribble tribble = new Tribble();

        try (
                ConnectionSession sess = new ConnectionSession();
                PreparedStatement ps = sess.getActiveConnection().prepareStatement(sql)

        ){
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();

            tribble.setTribbleId(rs.getInt("tribble_id"));
            tribble.setName(rs.getString("name"));

            rs.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return tribble;
    }

    @Override
    public void create(Tribble tribble) {
        String sql = "Insert into tribbles (name) values (?)";
        try (
                ConnectionSession sess = new ConnectionSession();
                PreparedStatement ps = sess.getActiveConnection().prepareStatement(sql)
                ) {

            ps.setString(1, tribble.getName());
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public List<Tribble> getAll() {
        List<Tribble> tribbles = new ArrayList<>();
        String sql = "SELECT * FROM tribbles;";
        try (
                ConnectionSession sess = new ConnectionSession();
                PreparedStatement ps = sess.getActiveConnection().prepareStatement(sql)

                ){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Tribble tribble = new Tribble();

                tribble.setTribbleId(rs.getInt("tribble_id"));
                tribble.setName(rs.getString("name"));
                tribbles.add(tribble);

            }
            rs.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return tribbles;
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM tribbles WHERE tribble_id = ?";
        try(
                ConnectionSession sess = new ConnectionSession();
                PreparedStatement ps = sess.getActiveConnection().prepareStatement(sql);)
        {
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Tribble update(Tribble tribble) {
        return null;
    }

    public void addTribbleToLab(Integer tribbleId, Integer labId) {
        String sql = "UPDATE tribbles SET lab_id = " + labId + " WHERE tribble_id = " + tribbleId;
        try(
                ConnectionSession sess = new ConnectionSession();
                PreparedStatement ps = sess.getActiveConnection().prepareStatement(sql);)
        {
            ps.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


}
