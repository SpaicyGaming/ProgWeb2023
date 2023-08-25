package it.unitn.progweb.g30.progweb2023;

import java.sql.*;

public enum UserType {

    SIMPATIZZANTE,
    ADERENTE,
    ADMIN;

    private int ID = -1;

    public static UserType fromString(String stringifiedType) {
        return UserType.valueOf(stringifiedType.toUpperCase());
    }

    public int getID() {
        if (ID < 0) {
            try {
                Class.forName("org.apache.derby.jdbc.ClientDriver");
                Connection connection = DriverManager.getConnection("jdbc:derby://localhost:1527/Tum4WorldDB");
                try (PreparedStatement stmt = connection.prepareStatement("SELECT USER_TYPE_ID FROM USER_TYPES WHERE USER_TYPE = ?")) {
                    stmt.setString(1, this.toString());
                    ResultSet result = stmt.executeQuery();
                    result.next();
                    ID = result.getInt(1);
                }
            } catch (ClassNotFoundException | SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return ID;
    }

    @Override
    public String toString() {
        return super.name().toLowerCase();
    }

}
