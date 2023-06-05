package it.unitn.progweb.g30.progweb2023;

import java.sql.*;

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
}
