package it.unitn.progweb.g30.progweb2023;

import java.sql.*;

public class UserType {

    static public final String SIMPATIZZANTE = "simpatizzante";
    static public final String ADERENTE = "aderente";
    static public final String ADMIN = "admin";
    private static Integer simpatizzanteId = null;
    private static Integer aderenteId = null;
    private static Integer adminId = null;
    private Connection connection=null;
    private String stringifiedType;
    private int type;
    public UserType(String t){
        String stringifiedType = t;
        boolean isNull = true;
        switch(t) {
            case SIMPATIZZANTE:
                if(simpatizzanteId != null){
                    isNull = false;
                    type = simpatizzanteId;
                }
                break;
            case ADERENTE:
                if(aderenteId != null){
                    isNull = false;
                    type = aderenteId;
                }
                break;
            case ADMIN:
                if(adminId != null){
                    isNull = false;
                    type = adminId;
                }
                break;
        }
        if(isNull) {
            try {
                Class.forName("org.apache.derby.jdbc.ClientDriver");
                this.connection = DriverManager.getConnection("jdbc:derby://localhost:1527/Tum4WorldDB");


                String query = "SELECT USER_TYPE_ID FROM USER_TYPES WHERE USER_TYPE = '" + stringifiedType + "'";
                Statement stmt = this.connection.createStatement();
                ResultSet result = stmt.executeQuery(query);
                result.next();
                type = result.getInt(1);
            } catch (NullPointerException | SQLException | ClassNotFoundException var2) {
                System.out.println(var2);
            }
        }
    }

    public int getTypeId(){
        return this.type;
    }
    public String getStringifiedType() { return this.stringifiedType; }
}
