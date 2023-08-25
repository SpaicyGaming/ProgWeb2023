package it.unitn.progweb.g30.progweb2023;

import java.sql.*;
import java.util.ArrayList;

public class UserDAO {

    Connection connection;

    public UserDAO(Connection connection) {
        this.connection = connection;
    }

    public User getUserByUsername(String un) {
        try (PreparedStatement stmt = connection.prepareStatement("SELECT USER_ID, USERNAME, MAIL, NOME, COGNOME, NUMERO_DI_TELEFONO, DATA_DI_NASCITA, USER_TYPES.USER_TYPE, PASSWORD FROM USERS INNER JOIN USER_TYPES ON USERS.USER_TYPE = USER_TYPES.USER_TYPE_ID WHERE USERNAME = ?")) {
            stmt.setString(1, un);
            ResultSet result = stmt.executeQuery();
            if (result.next()) {
                User user = new User();
                user.setId(result.getInt(1));
                user.setUsername(result.getString(2));
                user.setMail(result.getString(3));
                user.setNome(result.getString(4));
                user.setCognome(result.getString(5));
                user.setPhoneNumber(result.getString(6));
                user.setBd(result.getString(7));
                user.setUserType(UserType.fromString(result.getString(8)));
                user.setPassword(result.getString(9));
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void saveUser(User u) throws SQLException {
        try (PreparedStatement stmt = connection.prepareStatement("INSERT INTO USERS VALUES (DEFAULT, ?, ?, ?, ?, ?, ?, ?, ?)")) {
            stmt.setString(1, u.getUsername());
            stmt.setString(2, u.getMail());
            stmt.setString(3, u.getNome());
            stmt.setString(4, u.getCognome());
            stmt.setString(5, u.getPhoneNumber());
            stmt.setString(6, u.getBd());
            stmt.setInt(7, u.getUserType().getID());
            stmt.setString(8, u.getPassword());
            stmt.executeUpdate();
        }
    }

    public void deleteUser(User u) throws SQLException {
        try (PreparedStatement stmt = connection.prepareStatement("DELETE FROM USERS WHERE USERNAME = ?")) {
            stmt.setString(1, u.getUsername());
            stmt.executeUpdate();
        }
    }

    public ArrayList<User> getAllUsers() throws SQLException {
        try (PreparedStatement stmt = connection.prepareStatement("SELECT USER_ID, USERNAME, MAIL, NOME, COGNOME, NUMERO_DI_TELEFONO, DATA_DI_NASCITA, USER_TYPES.USER_TYPE, PASSWORD FROM USERS INNER JOIN USER_TYPES ON USERS.USER_TYPE = USER_TYPE_ID")) {
            ResultSet result = stmt.executeQuery();
            ArrayList<User> users = new ArrayList<>();
            while (result.next()) {
                User u = new User();
                u.setId(result.getInt(1));
                u.setUsername(result.getString(2));
                u.setMail(result.getString(3));
                u.setNome(result.getString(4));
                u.setCognome(result.getString(5));
                u.setPhoneNumber(result.getString(6));
                u.setBd(result.getString(7));
                u.setUserType(UserType.fromString(result.getString(8)));
                u.setPassword(result.getString(9));
                users.add(u);
            }
            return users;
        }
    }

    public ArrayList<User> getAllSimpatizzanti() throws SQLException {
        ArrayList<User> al = getAllUsers();
        al.removeIf(e -> e.getUserType() != UserType.SIMPATIZZANTE);
        return al;
    }

    public ArrayList<User> getAllAderenti() throws SQLException {
        ArrayList<User> al = getAllUsers();
        al.removeIf(e -> (e.getUserType() != UserType.ADERENTE));
        return al;
    }

    public boolean isUserSubscribedToActivity(User u, String a) throws SQLException {
        try (PreparedStatement stmt = connection.prepareStatement("SELECT * FROM USERS, USERSXATTIVITA, ATTIVITA WHERE USERNAME = ? AND USERS.USER_ID = USERSXATTIVITA.USER_ID AND USERSXATTIVITA.ACT_ID = ATTIVITA.ACT_ID AND NOME_ATTIVITA = ?")) {
            stmt.setString(1, u.getUsername());
            stmt.setString(2, a);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        }
    }

}
