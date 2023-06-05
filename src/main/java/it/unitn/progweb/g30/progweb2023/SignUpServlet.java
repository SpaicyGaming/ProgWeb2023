package it.unitn.progweb.g30.progweb2023;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;

@WebServlet(name = "SignUpServlet", value = "/SignUpServlet")
public class SignUpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/signup.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String cognome = request.getParameter("cognome");
        String username = request.getParameter("username");
        String mail = request.getParameter("mail");
        String numeroDiTelefono = request.getParameter("numeroDiTelefono");
        String bd = request.getParameter("bd");
        String userType = request.getParameter("userType");
        String password = request.getParameter("password");

        if(nome == null || cognome == null || username == null || mail == null || numeroDiTelefono == null || bd == null || userType == null || password == null){
            getServletContext().getRequestDispatcher("/signup.jsp").forward(request, response);
        }

        Connection c = (Connection)request.getSession().getAttribute("connection");
        UserDAO ud = new UserDAO(c);
        User u = new User();
        if(ud.getUserByUsername(username) == null){
            UserType ut = new UserType(userType);
            u.setNome(nome);
            u.setCognome(cognome);
            u.setUsername(username);
            u.setMail(mail);
            u.setPhoneNumber(numeroDiTelefono);
            u.setBd(bd);
            u.setUserType(ut);
            u.setPassword(password);
            try {
                ud.saveUser(u);
            }catch(Exception e){
                e.printStackTrace();
            }

            getServletContext().getRequestDispatcher("/registrazioneConfermata.jsp").forward(request, response);
        }else{
            //qui si informa l'utente del fatto che lo username non è disponibile
            ErrorMessageBean em = new ErrorMessageBean();
            em.setMessage("Il nome utente scelto è già in uso");
            request.setAttribute("errorMessage", em);
            getServletContext().getRequestDispatcher("/signup.jsp").forward(request, response);
        }
    }
}
