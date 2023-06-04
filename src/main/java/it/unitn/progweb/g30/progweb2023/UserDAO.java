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
            String query = "SELECT * FROM USERS WHERE USERNAME = '" + un + "'";
            Statement stmt = this.c.createStatement();
            ResultSet result = stmt.executeQuery(query);
            if(result.next()){
                u.setId(result.getInt(1));
                u.setUsername(result.getString(2));
                u.setMail(result.getString(3));
                u.setNome(result.getString(4));
                u.setUserType(new UserType(result.getString(5)));
                u.setCognome(result.getString(6));
                u.setPhoneNumber(result.getString(7));
                u.setBd(result.getString(8));
                u.setPassword(result.getString(9));
            }
        } catch (NullPointerException | SQLException e) {
            System.err.println(e);
        }
        return u;
    }

    public boolean saveUser(User u){
        /*
        System.out.println("prova");
        System.out.println(u.getNome());
        System.out.println(u.getCognome());
        System.out.println(u.getUsername());
        */

        try {
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
        } catch (NullPointerException | SQLException e) {
            System.err.println(e);
            return false;
        }
        return true;
    }
}
