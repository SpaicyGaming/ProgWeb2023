package it.unitn.progweb.g30.progweb2023;

import com.google.gson.Gson;
import com.google.gson.JsonArray;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

@WebServlet(name = "GetViewsServlet", value = "/GetViewsServlet")
public class GetViewsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection c = (Connection)request.getSession().getAttribute("connection");
        try {
            Statement stmt = c.createStatement();
            String query = "SELECT * FROM VIEWSXPAGE";
            ResultSet rs = stmt.executeQuery(query);
            JsonArray arr = new JsonArray();
            Gson gson = new Gson();
            while(rs.next()){
                Views v = new Views();
                v.setId(rs.getInt(1));
                v.setPage(rs.getString(2));
                v.setViews(rs.getInt(3));
                arr.add(gson.toJson(v));
            }

            synchronized(this){
                try {
                    ServletContext context = request.getServletContext();
                    String realPath = context.getRealPath("\\");
                    File outf = new File(realPath + "\\views.json");
                    //System.out.println(realPath + "\\donations.json");
                    if(!outf.createNewFile()){
                        outf.delete();
                        outf.createNewFile();
                    }
                    FileWriter fw = new FileWriter(realPath + "\\views.json");
                    fw.write(arr.toString());
                    fw.close();
                    PrintWriter pw = response.getWriter();
                    Path p = Path.of(realPath + "\\views.json");
                    pw.println(Files.readString(p));
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
