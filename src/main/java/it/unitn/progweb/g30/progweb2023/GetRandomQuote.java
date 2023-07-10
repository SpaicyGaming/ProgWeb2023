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
        quoteArr[0] = "Educare è come seminare: il frutto non è garantito e non è immediato, ma se non si semina è certo che non ci sarà raccolto.";
        quoteArr[1] = "Tutto quello che ho per difendermi è l'alfabeto; è quanto mi hanno dato al posto di un fucile.";
        quoteArr[2] = "Dove c'è l'educazione non c'è distinzione di classe.";
        quoteArr[3] = "Educare non significa riempire un secchio, ma accendere una fiamma.";
        quoteArr[4] = "Educare significa tirare fuori il talento di ognuno, il suo grado di libertà, la strada per apprendere davvero.";
        quoteArr[5] = "Si educa molto con quello che si dice, ancor più con quel che si fa, molto più con quel che si è.";
        quoteArr[6] = "L'educazione fa di ciascuno di noi un pezzo dell'ingranaggio e non un individuo.";
        quoteArr[7] = "L'educazione è ciò che la maggior parte delle persone riceve, molti trasmettono e pochi possiedono.";
        quoteArr[8] = "Educare la mente senza educare il cuore non è affatto un’educazione.";
        quoteArr[9] = "L'educazione è il pane dell'anima.";

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
