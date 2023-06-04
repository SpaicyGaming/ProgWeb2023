package it.unitn.progweb.g30.progweb2023;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import com.google.gson.Gson;

@WebServlet(name = "GetRandomQuote", value = "/GetRandomQuote")
public class GetRandomQuote extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] quoteArr = new String[10];
        quoteArr[0] = "Il mondo va aiutato";
        quoteArr[1] = "Tum4World è un nome bellissimo per un'associazione";
        quoteArr[2] = "Dovrei perdere qualche chilo";
        quoteArr[3] = "Ho sempre bisogno di aiutare il prossimo";
        quoteArr[4] = "Diffondete la voce";
        quoteArr[5] = "Ci sono persone che hanno bisogno di aiuto";
        quoteArr[6] = "Non mi prenderete mai";
        quoteArr[7] = "Salviamo il mondo!";
        quoteArr[8] = "Portiamo questo fardello insieme";
        quoteArr[9] = "La gioia di aiutare il prossimo";

        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        PrintWriter output = response.getWriter();
        Gson gson = new Gson();
        output.println(gson.toJson(quoteArr[(int)(Math.random()*10)]));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
