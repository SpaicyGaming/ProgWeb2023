package it.unitn.progweb.g30.progweb2023;

import java.sql.*;
import java.util.ArrayList;

public class DonationDAO {
    Connection connection;
    public DonationDAO(Connection c){
        this.connection = c;
    }
    public void saveDonation(Donation d) throws SQLException {
        Statement stmt = connection.createStatement();
        String query = String.format("INSERT INTO DONATIONS VALUES(DEFAULT, '%s', %d)", d.getData(), d.getImporto());
        stmt.execute(query);
    }
    public ArrayList<Donation> getYearsDonations() throws SQLException {
        ArrayList<Donation> darr = new ArrayList<>();
        Date today = new Date(System.currentTimeMillis());
        Statement stmt = connection.createStatement();
        String query = String.format("SELECT IMPORTO, DATA_DONAZIONE FROM"+
                " DONATIONS WHERE DATA_DONAZIONE >= '%s'", extractYear(today.toString())+"-01-01");
        ResultSet rs = stmt.executeQuery(query);
        while(rs.next()){
            Donation d = new Donation();
            d.setImporto(rs.getInt(1));
            d.setData(rs.getString(2));
            darr.add(d);
        }
        return darr;
    }

    private String extractYear(String date){
        String year = "";
        int i = 0;
        while(date.charAt(i) != '-'){
            year += date.charAt(i);
            i++;
        }
        return year;
    }
}
