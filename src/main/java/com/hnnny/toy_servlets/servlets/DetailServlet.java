package com.hnnny.toy_servlets.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.hnnny.toy_servlets.dao.PollWithDB;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/polls/PollServlet")
public class DetailServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // input type
        String questions_Uid = request.getParameter("QUESTIONS_UID");

        // biz with DB
        PollWithDB pollwithDB = new PollWithDB();
        HashMap<String, Object> question = null;
        ArrayList<HashMap> example = null;
        
        try {
            question = pollwithDB.getQuestion(questions_Uid);
            example = pollwithDB.getExample(questions_Uid);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // output with html
        request.setAttribute("question", question);
        request.setAttribute("example", example);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/polls/details.jsp");
        requestDispatcher.forward(request, response);
    }
}
