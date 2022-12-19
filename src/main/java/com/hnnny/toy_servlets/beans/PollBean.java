package com.hnnny.toy_servlets.beans;

import java.util.ArrayList;
import java.util.HashMap;

public class PollBean {
    String userName;
    String userBelong;

    String qUid;
    String question;

    HashMap<String, String> answer_list;

    public String getUserName(){
        return this.userName;
    }
    public String getUserBelong(){
        return this.userBelong;
    }

    public String getQUid(){
        return this.qUid;
    }
    public String getQuestion(){
        return this.question;
    }



    public void setUserName(String userName){
        this.userName = userName;
    }
    public void setUserBelong(String userBelong) {
        this.userBelong = userBelong;
    }
    public void setQUid(String qUid) {
        this.qUid = qUid;
    }
    public void setQuestion(String question) {
        this.question = question;
    }



}
