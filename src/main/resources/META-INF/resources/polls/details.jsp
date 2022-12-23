<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.HashMap, java.util.ArrayList" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
      crossorigin="anonymous"
    />
  </head>
  <body>
    <% 
    HashMap<String, Object> question = (HashMap<String, Object>)request.getAttribute("question");
    ArrayList<HashMap> example = (ArrayList<HashMap>)request.getAttribute("example");
    String question_uid =  (String)question.get("QUESTIONS_UID");
    String example_uid = "";
%>
    <div class="container p-3">
      <div class="fs-3 my-3">Toy Servlet Poll</div>
      <div class="form border p-3">
        <div>
            <%= question.get("ORDERS") %>. <%= question.get("QUESTIONS") %>
        </div>
        
        <% 
        for(int i = 0; i<example.size(); i++) { 
          example_uid = (String)example.get(i).get("EXAMPLE_UID");
          %>
        <div class="form-check">
          <input type="radio" class="form-check-input" name="<%= question_uid %>" id="<%= question_uid %>_<%= example_uid %>" />
          <label for="<%= question_uid %>_<%= example_uid %>" class="form-check-label">
            (<%= example.get(i).get("ORDERS") %>) <%= example.get(i).get("EXAMPLE") %>

          </label>
        </div>
          <% } %>

        <div> 
            <a href="/polls/PollServlet?QUESTIONS_UID=Q1">Q1</a> / 
            <a href="/polls/PollServlet?QUESTIONS_UID=Q2">Q2</a> /
            <a href="/polls/PollServlet?QUESTIONS_UID=Q3">Q3</a> /
            <a href="/polls/PollServlet?QUESTIONS_UID=Q4">Q4</a> /
            <a href="/polls/PollServlet?QUESTIONS_UID=Q5">Q5</a>
        </div>
        
        <div class="my-3">
        <%
        String parameter = request.getParameter("QUESTIONS_UID");
        int page_num = Integer.parseInt(parameter.replaceAll("[^0-9]",""));
        int prev_num = 0;
        int next_num = 0;
        if(page_num == 1) { 
          prev_num = page_num;
          next_num = page_num+1;
        } else if(page_num == 5) {
          prev_num = page_num-1;
          next_num = page_num;
        } else { 
          prev_num = page_num-1;
          next_num = page_num+1;
          }
        %>
          
          <a
          href="/polls/PollServlet?QUESTIONS_UID=Q<%= prev_num %>"
          class="btn btn-outline-secondary"
          >Prev</a
        >
        <a
          href="/polls/PollServlet?QUESTIONS_UID=Q<%= next_num %>"
          class="btn btn-outline-secondary"
          >Next</a
        >


        </div>

        
      </div>
    </div>

    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
      crossorigin="anonymous"
    ></script>
  </body>
</html>
