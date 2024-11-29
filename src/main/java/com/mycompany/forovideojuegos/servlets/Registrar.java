package com.mycompany.forovideojuegos.servlets;

import java.io.IOException;

import com.mycompany.forovideojuegos.dao.RegistroDao;
import com.mycompany.forovideojuegos.model.Registro;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Registrar")
public class Registrar extends HttpServlet {

    @Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    String usuario = request.getParameter("usuario");
    String contraseña = request.getParameter("contraseña");

    Registro registro = new Registro(usuario, contraseña);
    RegistroDao registroDao = new RegistroDao();

    if (registroDao.guardarRegistro(registro)) {
        response.sendRedirect("index.jsp"); 
    } else {
        response.getWriter().write("Error al guardar la solicitud.");
}
}
}

