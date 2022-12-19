package com.hnnny.toy_servlets;

import java.util.ArrayList;
import java.util.HashMap;

import com.hnnny.toy_servlets.beans.PollBean;

public class DatasInfo {
    public PollBean getDataUserInfo(){
        PollBean pollBean = new PollBean();
        pollBean.setUserName("김해인");
        pollBean.setUserBelong("@HNNNY");
        return pollBean;
    }

    

    public HashMap<String, Object> getBundlesData(){
        DatasInfo datasInfo = new DatasInfo();
        HashMap<String, Object> bundlesData = new HashMap<>();
        
        bundlesData.put("dataUserInfo", datasInfo.getDataUserInfo());

        bundlesData.put("questionList", datasInfo.getQuestionList());
        
        bundlesData.put("answerList", datasInfo.getAnswerList());
        
        bundlesData.put("matchQnA", datasInfo.matchQnA());
        return bundlesData;
    }

    public HashMap<String, String> getQuestionList(){
        HashMap<String, String> question_list = new HashMap<>(); 
        question_list.put("Q1", "해당 매장을 방문시 매장은 청결 하였습니까?");
        question_list.put("Q2", "주문시 직원은 고객님께 친절 하였습니까?");
        question_list.put("Q3", "주문하신 음료가 나오기까지 시간이 적당하였습니까?");
        question_list.put("Q4", "직원이 제조한 음료에 대해 맛은 좋았습니까?");
        question_list.put("Q5", "직원이 제조한 음료에 대해 맛은 좋았습니까?");

        return question_list;
    }

    public HashMap<String, String> getAnswerList(){
        HashMap<String, String> answer_list = new HashMap<>();
        answer_list.put("E1", "전혀 아니다.");
        answer_list.put("E2", "아니다.");
        answer_list.put("E3", "보통이다.");
        answer_list.put("E4", "그렇다.");
        answer_list.put("E5", "매우 그렇다.");
        
        return answer_list;
    }

    public HashMap<String, Object> matchQnA(){
        HashMap<String, Object> pollList = new HashMap<>();

        ArrayList<String> answer1 = new ArrayList<>();
        answer1.add("E1");

        ArrayList<String> answer2 = new ArrayList<>();
        answer2.add("E1");
        answer2.add("E2");

        ArrayList<String> answer3 = new ArrayList<>();
        answer3.add("E1");
        answer3.add("E2");
        answer3.add("E3");

        ArrayList<String> answer4 = new ArrayList<>();
        answer4.add("E1");
        answer4.add("E2");
        answer4.add("E3");
        answer4.add("E4");

        ArrayList<String> answer5 = new ArrayList<>();
        answer5.add("E1");
        answer5.add("E2");
        answer5.add("E3");
        answer5.add("E4");
        answer5.add("E5");
        
        pollList.put("Q1", answer2);
        pollList.put("Q2", answer3);
        pollList.put("Q3", answer2);
        pollList.put("Q4", answer5);
        pollList.put("Q5", answer3);
        return pollList;
    }

    

    
}
