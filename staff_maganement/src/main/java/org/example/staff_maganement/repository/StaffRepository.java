package org.example.staff_maganement.repository;

import org.example.staff_maganement.model.Part;
import org.example.staff_maganement.model.Staff;
import org.example.staff_maganement.model.Title;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StaffRepository extends BaseRepository implements IRepository<Staff> {

    @Override
    public List<Staff> findAll() {
        List<Staff> staffList = new ArrayList<>();
        String query = "SELECT s.id_staff, s.name_staff, s.birthday, s.cmnd, "
                + "p.id_part, p.name_part, t.id_title, t.name_title "
                + "FROM staff s "
                + "JOIN part p ON s.id_part = p.id_part "
                + "JOIN title t ON s.id_title = t.id_title";

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                Staff staff = new Staff(
                        resultSet.getInt("id_staff"),
                        resultSet.getString("name_staff"),
                        resultSet.getDate("birthday"),
                        resultSet.getString("cmnd"),
                        new Part(resultSet.getInt("id_part"), resultSet.getString("name_part")),
                        new Title(resultSet.getInt("id_title"), resultSet.getString("name_title"))
                );
                staffList.add(staff);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return staffList;
    }

    @Override
    public Staff findById(int id) {
        String query = "SELECT s.id_staff, s.name_staff, s.birthday, s.cmnd, "
                + "p.id_part, p.name_part, t.id_title, t.name_title "
                + "FROM staff s "
                + "JOIN part p ON s.id_part = p.id_part "
                + "JOIN title t ON s.id_title = t.id_title "
                + "WHERE s.id_staff = ?";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return new Staff(
                        resultSet.getInt("id_staff"),
                        resultSet.getString("name_staff"),
                        resultSet.getDate("birthday"),
                        resultSet.getString("cmnd"),
                        new Part(resultSet.getInt("id_part"), resultSet.getString("name_part")),
                        new Title(resultSet.getInt("id_title"), resultSet.getString("name_title"))
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean save(Staff staff) {

        String query = "INSERT INTO staff (name_staff, birthday, cmnd, id_part, id_title) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, staff.getNameStaff());
            preparedStatement.setDate(2, staff.getBirthday());
            preparedStatement.setString(3, staff.getCmnd());
            preparedStatement.setInt(4, staff.getPart().getIdPart());
            preparedStatement.setInt(5, staff.getTitle().getIdTitle());

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Staff staff) {
        String query = "UPDATE staff SET name_staff = ?, birthday = ?, cmnd = ?, id_part = ?, id_title = ? WHERE id_staff = ?";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, staff.getNameStaff());
            preparedStatement.setDate(2, staff.getBirthday());
            preparedStatement.setString(3, staff.getCmnd());
            preparedStatement.setInt(4, staff.getPart().getIdPart());
            preparedStatement.setInt(5, staff.getTitle().getIdTitle());
            preparedStatement.setInt(6, staff.getIdStaff());

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        String query = "DELETE FROM staff WHERE id_staff = ?";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Staff> search(String nameStaff, String namePart, String nametTitle) {
        List<Staff> staffList = new ArrayList<>();
        List<Staff> staff2 = new ArrayList<>();
        String query = "SELECT s.id_staff, s.name_staff, s.birthday, s.cmnd, "
                + "p.id_part, p.name_part, t.id_title, t.name_title "
                + "FROM staff s "
                + "JOIN part p ON s.id_part = p.id_part "
                + "JOIN title t ON s.id_title = t.id_title";
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while  (resultSet.next()) {
                Staff staff = new Staff(
                        resultSet.getInt("id_staff"),
                        resultSet.getString("name_staff"),
                        resultSet.getDate("birthday"),
                        resultSet.getString("cmnd"),
                        new Part(resultSet.getInt("id_part"), resultSet.getString("name_part")),
                        new Title(resultSet.getInt("id_title"), resultSet.getString("name_title"))
                );
                staffList.add(staff);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (Staff staff : staffList) {
            if (staff.getNameStaff().equals(nameStaff)  && staff.getTitle().getNameTitle().equals(nametTitle)  && staff.getPart().getNamePart().equals(namePart)) {
                staff2.add(staff);
            }
        }
        return staff2;
//        String query = "SELECT s.id_staff, s.name_staff, s.birthday, s.cmnd, "
//                + "p.id_part, p.name_part, t.id_title, t.name_title "
//                + "FROM staff s "
//                + "JOIN part p ON s.id_part = p.id_part "
//                + "JOIN title t ON s.id_title = t.id_title "
//                + "WHERE 1=1"; // 1=1 để dễ dàng thêm điều kiện
//
//        // Thêm điều kiện vào truy vấn nếu có
//        if (name != null && !name.isEmpty()) {
//            query += " AND s.name_staff LIKE ?";
//        }
//        if (part != null && !part.isEmpty()) {
//            query += " AND p.name_part LIKE ?";
//        }
//        if (title != null && !title.isEmpty()) {
//            query += " AND t.name_title LIKE ?";
//        }
//
//        try (Connection connection = getConnection();
//                PreparedStatement stmt = connection.prepareStatement(query)) {
//            int index = 1;
//            if (name != null && !name.isEmpty()) {
//                stmt.setString(index++, "%" + name + "%");
//            }
//            if (part != null && !part.isEmpty()) {
//                stmt.setString(index++, "%" + part + "%");
//            }
//            if (title != null && !title.isEmpty()) {
//                stmt.setString(index++, "%" + title + "%");
//            }
//
//            ResultSet rs = stmt.executeQuery();
//            while (rs.next()) {
//                Staff staff = mapRowToStaff(rs); // Phương thức ánh xạ ResultSet vào Staff
//                staffList.add(staff);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return staffList;
    }

    public List<Staff> search( String namePart, String nametTitle) {
        List<Staff> staffList = new ArrayList<>();
        List<Staff> staff1 = new ArrayList<>();
//        String query = "SELECT s.id_staff, s.name_staff, s.birthday, s.cmnd, "
//                + "p.id_part, p.name_part, t.id_title, t.name_title "
//                + "FROM staff s "
//                + "JOIN part p ON s.id_part = p.id_part "
//                + "JOIN title t ON s.id_title = t.id_title "
//                + "WHERE 1=1"; // 1=1 để dễ dàng thêm điều kiện

//        // Thêm điều kiện vào truy vấn nếu có
//        if (part != null && !part.isEmpty()) {
//            query += " AND p.name_part LIKE ?";
//        }
//        if (title != null && !title.isEmpty()) {
//            query += " AND t.name_title LIKE ?";
//        }



//        try (Connection connection = getConnection();
//             PreparedStatement stmt = connection.prepareStatement(query)) {
//            int index = 1;
//
//            if (part != null && !part.isEmpty()) {
//                stmt.setString(index++, "%" + part + "%");
//            }
//            if (title != null && !title.isEmpty()) {
//                stmt.setString(index++, "%" + title + "%");
//            }
//
//            ResultSet rs = stmt.executeQuery();
//            while (rs.next()) {
//                Staff staff = mapRowToStaff(rs); // Phương thức ánh xạ ResultSet vào Staff
//                staffList.add(staff);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        String query = "SELECT s.id_staff, s.name_staff, s.birthday, s.cmnd, "
                + "p.id_part, p.name_part, t.id_title, t.name_title "
                + "FROM staff s "
                + "JOIN part p ON s.id_part = p.id_part "
                + "JOIN title t ON s.id_title = t.id_title";
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while  (resultSet.next()) {
                Staff staff = new Staff(
                        resultSet.getInt("id_staff"),
                        resultSet.getString("name_staff"),
                        resultSet.getDate("birthday"),
                        resultSet.getString("cmnd"),
                        new Part(resultSet.getInt("id_part"), resultSet.getString("name_part")),
                        new Title(resultSet.getInt("id_title"), resultSet.getString("name_title"))
                );
                staffList.add(staff);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (Staff staff : staffList) {
            if (staff.getTitle().getNameTitle().equals(nametTitle)  && staff.getPart().getNamePart().equals(namePart)) {
                staff1.add(staff);
            }
        }
        return staff1;
    }

    private Staff mapRowToStaff(ResultSet rs) throws SQLException {
        Staff staff = new Staff();
        staff.setIdStaff(rs.getInt("id_staff"));
        staff.setNameStaff(rs.getString("name_staff"));
        staff.setBirthday(rs.getDate("birthday"));
        staff.setCmnd(rs.getString("cmnd"));

        // Mapping Part
        Part part = new Part();
        part.setIdPart(rs.getInt("id_part"));
        part.setNamePart(rs.getString("name_part"));
        staff.setPart(part);

        // Mapping Title
        Title title = new Title();
        title.setIdTitle(rs.getInt("id_title"));
        title.setNameTitle(rs.getString("name_title"));
        staff.setTitle(title);

        return staff;
    }


}
