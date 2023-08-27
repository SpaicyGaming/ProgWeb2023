package it.unitn.progweb.g30.progweb2023;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.stream.JsonReader;

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
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet(name = "GetViewsServlet", value = "/GetViewsServlet")
public class GetViewsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection connection = (Connection) request.getSession().getAttribute("connection");

        try (PreparedStatement stmt = connection.prepareStatement("SELECT * FROM VIEWSXPAGE")) {
            ResultSet rs = stmt.executeQuery();
            JsonArray arr = new JsonArray();
            Gson gson = new Gson();
            while (rs.next()) {
                Views v = new Views();
                v.setId(rs.getInt(1));
                v.setPage(rs.getString(2));
                v.setViews(rs.getInt(3));
                arr.add(gson.toJson(v));
            }

            synchronized (this) {
                try {
                    ServletContext context = request.getServletContext();
                    String realPath = context.getRealPath("\\");
                    File outf = new File(realPath + "\\views.json");
                    if (!outf.createNewFile()) {
                        outf.delete();
                        outf.createNewFile();
                    }
                    FileWriter fw = new FileWriter(realPath + "\\views.json");
                    fw.write(arr.toString());
                    fw.close();
                    PrintWriter pw = response.getWriter();
                    Path p = Path.of(realPath + "\\views.json");
                    JsonReader reader = new JsonReader(Files.newBufferedReader(p));
                    JsonArray resultArr = gson.fromJson(reader, JsonArray.class);
                    response.setContentType("application/json");
                    response.setCharacterEncoding("UTF-8");
                    pw.print(resultArr);
                    pw.flush();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
