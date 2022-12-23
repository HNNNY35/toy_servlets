package com.hnnny.toy_servlets.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class PollWithDB {
    // QuestionUID로 질문 가져오는 펑션
    public HashMap<String, Object> getQuestion(String questionsUid) throws SQLException {
        Commons commons = new Commons();
        Statement statement = commons.getStatement();

        String query = "SELECT * FROM QUESTIONS_LIST " + 
        "WHERE QUESTIONS_UID = '" + questionsUid + "'";
        
        ResultSet resultSet = statement.executeQuery(query);
        HashMap<String, Object> questions = null;
        while(resultSet.next()) {
            questions = new HashMap<>();
            questions.put("QUESTIONS_UID", resultSet.getString("QUESTIONS_UID"));
            questions.put("QUESTIONS", resultSet.getString("QUESTIONS"));
            questions.put("ORDERS", resultSet.getInt("ORDERS"));
        }
        resultSet.close();
        statement.close();
        return questions;
    }

    // QuestionsUID에 해당하는 답변 가져오는 펑션
    public ArrayList<HashMap> getExample(String questionsUid) throws SQLException {
        Commons commons = new Commons();
        Statement statement = commons.getStatement();

        String query = "SELECT * FROM EXAMPLE_LIST INNER JOIN ANSWERS " + 
        "ON EXAMPLE_LIST.EXAMPLE_UID = ANSWERS.EXAMPLE_UID " + 
        "WHERE ANSWERS.QUESTIONS_UID = '" + questionsUid + "' ORDER BY EXAMPLE_LIST.ORDERS";

        ResultSet resultSet = statement.executeQuery(query);
        HashMap<String, Object> example = null;
        ArrayList<HashMap> examples = new ArrayList<>();

        while(resultSet.next()) {
            example = new HashMap<>();

            example.put("EXAMPLE_UID", resultSet.getString("EXAMPLE_UID"));
            example.put("EXAMPLE", resultSet.getString("EXAMPLE"));
            example.put("ORDERS", resultSet.getInt("ORDERS"));

            examples.add(example);
        }
        resultSet.close();
        statement.close();
        return examples;

    }
}
