package it.unitn.progweb.g30.progweb2023;

import com.google.gson.Gson;
import com.google.gson.JsonArray;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.util.Collections;
import java.util.List;

@WebServlet(name = "GetDonationsServlet", value = "/GetDonationsServlet")
public class GetDonationsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DonationDAO dd = new DonationDAO((Connection) request.getSession().getAttribute("connection"));
        List<Donation> donations = Collections.emptyList();
        try {
            donations = dd.getYearsDonations();
        } catch (Exception e) {
            e.printStackTrace();
        }

        JsonArray arr = new JsonArray();
        Gson gson = new Gson();
        for (Donation d : donations) {
            arr.add(gson.toJson(d));
        }

        synchronized (this) {
            try {
                ServletContext context = request.getServletContext();
                String realPath = context.getRealPath("\\");
                File outf = new File(realPath + "\\donations.json");
                //System.out.println(realPath + "\\donations.json");
                if (!outf.createNewFile()) {
                    outf.delete();
                    outf.createNewFile();
                }
                FileWriter fw = new FileWriter(realPath + "\\donations.json");
                fw.write(arr.toString());
                fw.close();
                PrintWriter pw = response.getWriter();
                Path p = Path.of(realPath + "\\donations.json");
                pw.println(Files.readString(p));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
