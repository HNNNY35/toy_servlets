package com.hnnny.toy_servlets.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import com.hnnny.toy_servlets.DatasInfo;
import com.hnnny.toy_servlets.beans.PollBean;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/pollListServlet")
public class PollListServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        DatasInfo datasInfo = new DatasInfo();
        HashMap<String, Object> bundlesData = datasInfo.getBundlesData();

        HashMap<String, String> question_list = (HashMap<String, String>) bundlesData.get("questionList");
        HashMap<String, String> answer_list = (HashMap<String, String>) bundlesData.get("answerList");
        HashMap<String, Object> matchQnA = (HashMap<String, Object>) bundlesData.get("matchQnA");
        
        PrintWriter printWriter = response.getWriter();
        
        printWriter.println("");

        printWriter.println("<html lang='en'>");
        printWriter.println("  <head>");
        printWriter.println("    <meta charset='UTF-8' />");
        printWriter.println("    <title>Document</title>");
        printWriter.println("    <link href='https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css'");
        printWriter.println("      rel='stylesheet' integrity='sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65' crossorigin='anonymous' />");
        printWriter.println("      </head>");


        printWriter.println("  <body>");
        printWriter.println("    <div class='container'>");
        printWriter.println("      <div class='fs-3'>Poll List With Servlet</div>");
        printWriter.println("      <div class='py-3'>");

        PollBean pollBean1 = (PollBean) bundlesData.get("dataUserInfo");

        printWriter.println("        <div>설문자 이름 : " + pollBean1.getUserName() + "</div>");
        printWriter.println("        <div>설문자 소속 : " + pollBean1.getUserBelong() + "</div>");
        printWriter.println("      </div>");

        printWriter.println("      <div>");
        

        for(String key : question_list.keySet()) {
            String quesiton = question_list.get(key);
            printWriter.println("<div>"+key +". "+ quesiton+"</div>");

            ArrayList<String> answerUids = (ArrayList) matchQnA.get(key);
            for(int i=0; i <answerUids.size(); i++) {
                
                printWriter.println("<div class='form-check'><input type='radio' name='"+key+"' id='"+key+answerUids.get(i)+"'><label for='"+key+answerUids.get(i)+"'>"+ "("+ (i+1) + ")" + answer_list.get(answerUids.get(i)) +"</div>");
                
            }
            }
        
        printWriter.println("      <div>" );
        printWriter.println("      </div>");
        

        printWriter.println("      </div>");
        printWriter.println("    </div>");

        printWriter.println("    <script src='https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js'");
        printWriter.println("      integrity='sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4'");
        printWriter.println("      crossorigin='anonymous' ></script>");
        printWriter.println("  </body>");
        printWriter.println("</html>");

        printWriter.close();
    }
}
