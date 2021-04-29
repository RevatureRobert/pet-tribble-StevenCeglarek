package petTribble.dao;

import petTribble.model.Lab;
import petTribble.model.Tribble;
import petTribble.util.ConnectionSession;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LabDao implements DaoUtil<Lab, Integer> {

    @Override
    public Lab getById(Integer id) {
        String sql = "SELECT * FROM labs WHERE lab_id = ?";
        Lab lab = new Lab();

        try (
                ConnectionSession sess = new ConnectionSession();
                PreparedStatement ps = sess.getActiveConnection().prepareStatement(sql)

        ){
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();

            lab.setLabId(rs.getInt("lab_id"));
            lab.setName(rs.getString("name"));

            rs.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return lab;
    }

    @Override
    public void create(Lab lab) {
        String sql = "Insert into labs (name) values (?)";
        try (
                ConnectionSession sess = new ConnectionSession();
                PreparedStatement ps = sess.getActiveConnection().prepareStatement(sql)
        ) {

            ps.setString(1, lab.getName());
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Lab> getAll() {
        List<Lab> labs = new ArrayList<>();
        String sql = "SELECT * FROM labs;";
        try (
                ConnectionSession sess = new ConnectionSession();
                PreparedStatement ps = sess.getActiveConnection().prepareStatement(sql)

        ){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Lab lab = new Lab();

                lab.setLabId(rs.getInt("lab_id"));
                lab.setName(rs.getString("name"));
                labs.add(lab);

            }
            rs.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return labs;
    }

    @Override
    public void delete(Integer id) {

        String sql = "DELETE FROM labs WHERE lab_id = ?";
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
    public Lab update(Lab lab) {
        return null;
    }



}
