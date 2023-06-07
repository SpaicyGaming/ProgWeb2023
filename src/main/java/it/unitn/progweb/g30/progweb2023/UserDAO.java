package it.unitn.progweb.g30.progweb2023;

import java.sql.*;
import java.util.ArrayList;

public class UserDAO {
    Connection c;

    public UserDAO(Connection c){
        this.c = c;
    }
    public User getUserByUsername(String un){
        User u = null;
        try {
            String query = "SELECT USER_ID, USERNAME, MAIL, NOME, COGNOME, NUMERO_DI_TELEFONO, DATA_DI_NASCITA, USER_TYPES.USER_TYPE, PASSWORD FROM USERS INNER JOIN USER_TYPES ON USERS.USER_TYPE = USER_TYPES.USER_TYPE_ID WHERE USERNAME = '" + un + "'";
            Statement stmt = this.c.createStatement();
            ResultSet result = stmt.executeQuery(query);
            if(result.next()){
                u = new User();
                u.setId(result.getInt(1));
                u.setUsername(result.getString(2));
                u.setMail(result.getString(3));
                u.setNome(result.getString(4));
                u.setCognome(result.getString(5));
                u.setPhoneNumber(result.getString(6));
                u.setBd(result.getString(7));
                u.setUserType(new UserType(result.getString(8)));
                u.setPassword(result.getString(9));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return u;
    }

    public void saveUser(User u) throws SQLException {
        String query = String.format("INSERT INTO USERS VALUES (DEFAULT, '%s',"+
            " '%s', '%s', '%s', '%s', '%s', %d, '%s')",
            u.getUsername(),
            u.getMail(),
            u.getNome(),
            u.getCognome(),
            u.getPhoneNumber(),
            u.getBd(),
            u.getUserType().getTypeId(),
            u.getPassword()
        );
        Statement stmt = this.c.createStatement();
        stmt.execute(query);
    }

    public void deleteUser(User u) throws SQLException {
        String query = String.format("DELETE FROM USERS WHERE USERNAME = '%s'", u.getUsername());
        Statement stmt = this.c.createStatement();
        stmt.execute(query);
    }

    public ArrayList<User> getAllUsers() throws SQLException {
        Statement stmt = c.createStatement();
        String query = "SELECT USER_ID, USERNAME, MAIL, NOME, COGNOME, NUMERO_DI_TELEFONO, DATA_DI_NASCITA, USER_TYPES.USER_TYPE, PASSWORD FROM USERS INNER JOIN USER_TYPES ON USERS.USER_TYPE = USER_TYPE_ID";
        ResultSet result = stmt.executeQuery(query);
        ArrayList<User> al = new ArrayList<>();
        while(result.next()){
            User u = new User();
            u.setId(result.getInt(1));
            u.setUsername(result.getString(2));
            u.setMail(result.getString(3));
            u.setNome(result.getString(4));
            u.setCognome(result.getString(5));
            u.setPhoneNumber(result.getString(6));
            u.setBd(result.getString(7));
            u.setUserType(new UserType(result.getString(8)));
            u.setPassword(result.getString(9));
            al.add(u);
        }
        return al;
    }

    public ArrayList<User> getAllSimpatizzanti() throws SQLException {
        ArrayList<User> al = getAllUsers();
        al.removeIf(e -> (!e.getStringifiedType().equals("simpatizzante")));
        return al;
    }

    public ArrayList<User> getAllAderenti() throws SQLException {
        ArrayList<User> al = getAllUsers();
        al.removeIf(e -> (!e.getStringifiedType().equals("aderente")));
        return al;
    }

    public boolean isUserSubscribedToActivity(User u, String a) throws SQLException {
        Statement stmt = c.createStatement();
        String query = String.format("SELECT * FROM USERS, USERSXATTIVITA, ATTIVITA WHERE USERNAME = '%s' AND USERS.USER_ID = USERSXATTIVITA.USER_ID AND USERSXATTIVITA.ACT_ID = ATTIVITA.ACT_ID AND NOME_ATTIVITA = '%s'", u.getUsername(), a);
        ResultSet rs = stmt.executeQuery(query);
        return rs.next();
    }
}
