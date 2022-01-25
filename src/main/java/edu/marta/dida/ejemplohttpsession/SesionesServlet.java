/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package edu.marta.dida.ejemplohttpsession;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author user
 */
@WebServlet(name = "SesionesServlet", urlPatterns = {"/SesionesServlet"})
public class SesionesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        HttpSession sesion = request.getSession();
        String titulo = null;
        
        //Pedimos el atributo, y verificamos si existe
        Integer contadorVisitas = (Integer) sesion.getAttribute("contadorVisitas");
        
        //Si es igul a nulo, quiere decir que es la primera vez que accedemos
        //al recurso
        if(contadorVisitas == null){
            contadorVisitas = new Integer(1);
            titulo = "bienvenido por primera vez...";
        } else {
            //si es distinto de nulo, incrementamos el contador
            titulo = "Bienvenido Nuevamente...";
            contadorVisitas += 1;
        }
        
        //En cualquier caso, agregamos el valor del contador a la sesion
        sesion.setAttribute("contadorVisitas", contadorVisitas);
        
        //Mostramos los valores en el cliente
        PrintWriter out = response.getWriter();
        out.println("Titulo: " + titulo);
        out.println("<br>");
        out.println("No. Accesos al recurso: " + contadorVisitas);
        out.println("<br>");
        out.println("ID de la sesión: " + sesion.getId());
        
    }

}
