package it.unitn.progweb.g30.progweb2023;

import java.sql.*;
import java.util.ArrayList;

public class DonationDAO {

    Connection connection;

    public DonationDAO(Connection c) {
        this.connection = c;
    }

    public void saveDonation(Donation d) throws SQLException {
        try (PreparedStatement stmt = connection.prepareStatement("INSERT INTO DONATIONS VALUES(DEFAULT, ?, ?)")) {
            stmt.setString(1, d.getData());
            stmt.setInt(2, d.getImporto());
            stmt.executeUpdate();
        }
    }

    public ArrayList<Donation> getYearsDonations() throws SQLException {
        ArrayList<Donation> darr = new ArrayList<>();
        Date today = new Date(System.currentTimeMillis());

        try (PreparedStatement stmt = connection.prepareStatement("SELECT IMPORTO, DATA_DONAZIONE FROM DONATIONS WHERE DATA_DONAZIONE >= ?")) {
            stmt.setString(1, extractYear(today.toString()) + "-01-01");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Donation d = new Donation();
                d.setImporto(rs.getInt(1));
                d.setData(rs.getString(2));
                darr.add(d);
            }
            return darr;
        }
    }

    private String extractYear(String date) {
        return date.split("-")[0];
    }

}
