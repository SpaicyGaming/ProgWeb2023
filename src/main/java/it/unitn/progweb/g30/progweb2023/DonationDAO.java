package it.unitn.progweb.g30.progweb2023;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    public List<Donation> getYearsDonations() throws SQLException {
        List<Donation> donations = new ArrayList<>();
        Date today = new Date(System.currentTimeMillis());

        try (PreparedStatement stmt = connection.prepareStatement("SELECT IMPORTO, DATA_DONAZIONE FROM DONATIONS WHERE DATA_DONAZIONE >= ?")) {
            stmt.setString(1, extractYear(today.toString()) + "-01-01");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Donation d = new Donation();
                d.setImporto(rs.getInt(1));
                d.setData(rs.getString(2));
                donations.add(d);
            }
            return donations;
        }
    }

    private String extractYear(String date) {
        return date.split("-")[0];
    }

}
