package com.deerwalk.service;

import com.deerwalk.model.Question;
import com.deerwalk.model.Result;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dell on 10/31/2017.
 */
public class QuestionService {
    public boolean addQuestion(Question question1){
        boolean isSuccess=false;
        DbConnection dbConnection=new DbConnection();
        Connection connection=dbConnection.getDbconnection();
        String sql="insert into question(question,option1,option2,option3,option4,correct_answer,category)values(?,?,?,?,?,?,?)";
        try {
            PreparedStatement statement=connection.prepareStatement(sql);
            statement.setString(1,question1.getQuestion());
            statement.setString(2,question1.getOption1());
            statement.setString(3,question1.getOption2());
            statement.setString(4,question1.getOption3());
            statement.setString(5,question1.getOption4());
            statement.setString(6,question1.getCorrectAnswer());
            statement.setString(7,question1.getCategory());
            int affectedRows=statement.executeUpdate();
            if(affectedRows>0){
                isSuccess=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isSuccess;
    }
    public List<Question> getQuestionList() {
        DbConnection dbConnection = new DbConnection();
        Connection connection = dbConnection.getDbconnection();
        String sql = "select * from question";
        List<Question> questionList = new ArrayList<Question>();

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            boolean val = statement.execute();
            if (val) {
                ResultSet resultSet = statement.getResultSet();
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String question = resultSet.getString("question");
                    String option1 = resultSet.getString("option1");
                    String option2 = resultSet.getString("option2");
                    String option3 = resultSet.getString("option3");
                    String option4 = resultSet.getString("option4");
                    String correctAnswer = resultSet.getString("correct_answer");
                    String category = resultSet.getString("category");

                    Question question1 = new Question();

                    question1.setId(id);
                    question1.setQuestion(question);
                    question1.setOption1(option1);
                    question1.setOption2(option2);
                    question1.setOption3(option3);
                    question1.setOption4(option4);
                    question1.setCorrectAnswer(correctAnswer);
                    question1.setCategory(category);



                    questionList.add(question1);

                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return questionList;
    }

    public Question editQuestion(String id) {
        DbConnection dbConnection=new DbConnection();
        Connection connection=dbConnection.getDbconnection();
        String sql="select * from question where id=?";
        Question question1=null;
        try {
            PreparedStatement statement=connection.prepareStatement(sql);
            statement.setInt(1, Integer.parseInt(id));
            boolean val=statement.execute();
            if(val){
                ResultSet resultSet=statement.getResultSet();
                while(resultSet.next()){
                    int id1=resultSet.getInt("id");
                    String question=resultSet.getString("question");
                    String option1=resultSet.getString("option1");
                    String option2=resultSet.getString("option2");
                    String option3=resultSet.getString("option3");
                    String option4=resultSet.getString("option4");
                    String correctAnswer=resultSet.getString("correct_answer");
                    String category=resultSet.getString("category");

                    question1=new Question();

                    question1.setId(id1);
                    question1.setQuestion(question);
                    question1.setOption1(option1);
                    question1.setOption2(option2);
                    question1.setOption3(option3);
                    question1.setOption4(option4);
                    question1.setCorrectAnswer(correctAnswer);
                    question1.setCategory(category);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return question1;
    }

    public int deleteQuestion(String id) {
        DbConnection dbConnection=new DbConnection();
        Connection connection=dbConnection.getDbconnection();
        String sql="delete from question where id=?";
        int affectedRows=0;
        try {
            PreparedStatement statement=connection.prepareStatement(sql);
            statement.setInt(1,Integer.parseInt(id));
            affectedRows=statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return affectedRows;
    }

    public boolean updateQuestion(Question question) {

        boolean isSuccess=false;
        DbConnection dbConnection=new DbConnection();
        Connection connection=dbConnection.getDbconnection();

        String sql="update question set question=?,option1=?,option2=?,option3=?,option4=?,correct_answer=?,category=? where id=?";
        try {

            PreparedStatement statement=connection.prepareStatement(sql);
            statement.setString(1,question.getQuestion());
            statement.setString(2,question.getOption1());
            statement.setString(3,question.getOption2());
            statement.setString(4,question.getOption3());
            statement.setString(5,question.getOption4());
            statement.setString(6, question.getCorrectAnswer());
            statement.setString(7,question.getCategory());
            statement.setInt(8,question.getId());
            int affectedRows=statement.executeUpdate();
            if(affectedRows>0){
                isSuccess=true;
            }




        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isSuccess;
    }

    public Question getRandomQuestion(String category, String difficulty) {
        DbConnection dbConnection=new DbConnection();
        Connection connection=dbConnection.getDbconnection();
        String sql="select * from question where category=? and difficulty=? limit 1";
        Question question1=null;
        try {
            PreparedStatement statement=connection.prepareStatement(sql);
            statement.setString(1,category);
            statement.setString(2,difficulty);

            boolean val=statement.execute();
            if(val){
                ResultSet resultSet=statement.getResultSet();
                while(resultSet.next()){
                    int id=resultSet.getInt("id");
                    String question=resultSet.getString("question");
                    String option1=resultSet.getString("option1");
                    String option2=resultSet.getString("option2");
                    String option3=resultSet.getString("option3");
                    String option4=resultSet.getString("option4");
                    String correctAnswer=resultSet.getString("correct_answer");
                    String category1=resultSet.getString("category");
                    String difficulty1=resultSet.getString("difficulty");

                    question1=new Question();

                    question1.setId(id);
                    question1.setQuestion(question);
                    question1.setOption1(option1);
                    question1.setOption2(option2);
                    question1.setOption3(option3);
                    question1.setOption4(option4);
                    question1.setCorrectAnswer(correctAnswer);
                    question1.setCategory(category1);
                    question1.setDifficulty(difficulty1);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return question1;
    }

    public int getResult(int uId, int qId, int marks, int time) {
        DbConnection dbConnection=new DbConnection();
        Connection connection=dbConnection.getDbconnection();
        String sql="insert into result(user_id,q_id,marks,time_taken)values(?,?,?,?)";
        int affectedRows=0;
        try {
            PreparedStatement statement=connection.prepareStatement(sql);
            statement.setInt(1,uId);
            statement.setInt(2,qId);
            statement.setInt(3,marks);
            statement.setInt(4,time);
            affectedRows=statement.executeUpdate();
            if(affectedRows>0){
                System.out.println(affectedRows+"row(s) affected");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return affectedRows;
    }
    public List<Result> getQuestionIdList(int userId){
        DbConnection dbConnection=new DbConnection();
        Connection connection=dbConnection.getDbconnection();
        List<Result> questionIdList=new ArrayList<Result>();
        String sql="select * from result where user_id=?";
        try {
            PreparedStatement statement=connection.prepareStatement(sql);
            statement.setInt(1,userId);
            boolean val=statement.execute();
            if(val){
                ResultSet resultSet=statement.getResultSet();
                while(resultSet.next()){
                    int id=resultSet.getInt("id");
                    int uId=resultSet.getInt("user_id");
                    int qId=resultSet.getInt("q_id");
                    int marks=resultSet.getInt("marks");
                    int timeTaken=resultSet.getInt("time_taken");

                    Result result=new Result();
                    result.setId(id);
                    result.setUserId(uId);
                    result.setMarks(marks);
                    result.setQuestionId(qId);
                    result.setTimeTaken(timeTaken);


                    questionIdList.add(result);


                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return questionIdList;
    }

    public Question getRandomQuestion1(List<Result> questionIdList, String category, String difficulty) {

        String param="";
        for(int i=0;i<questionIdList.size();i++){
            param+="?";
            if(questionIdList.size()-1==i){
                break;
            }
            else{
                param+=",";
            }
        }


        DbConnection dbConnection=new DbConnection();
        Connection connection=dbConnection.getDbconnection();


        String sql="select * from question where id not in ("+param+") and category=? and difficulty=? limit 1 ";
        System.out.println("sql is: "+sql);
        Question question1=null;
        try {
            PreparedStatement statement=connection.prepareStatement(sql);
            int index=1;
            for(int i=0;i<questionIdList.size();i++){
                statement.setInt(index++,questionIdList.get(i).getQuestionId());//questionIdList ma result ko object haru cha. aile i=0 cha vaney
                //get(i) garda list ma vako 0 content dine vayo, result ko object vako vayera getter call garna payo
            }
            statement.setString(index,category);
            statement.setString(index+1,difficulty);
            boolean val=statement.execute();
            if(val){
                ResultSet resultSet=statement.getResultSet();
                while(resultSet.next()){
                    int id=resultSet.getInt("id");
                    String question=resultSet.getString("question");
                    String option1=resultSet.getString("option1");
                    String option2=resultSet.getString("option2");
                    String option3=resultSet.getString("option3");
                    String option4=resultSet.getString("option4");
                    String correctAnswer=resultSet.getString("correct_answer");
                    String category1=resultSet.getString("category");
                    String difficulty1=resultSet.getString("difficulty");
                    System.out.println("question is: "+question);

                    question1=new Question();

                    question1.setId(id);
                    question1.setQuestion(question);
                    question1.setOption1(option1);
                    question1.setOption2(option2);
                    question1.setOption3(option3);
                    question1.setOption4(option4);
                    question1.setCorrectAnswer(correctAnswer);
                    question1.setCategory(category1);
                    question1.setDifficulty(difficulty1);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return question1;

    }

    public List<Result> getResultList() {
        List<Result> resultList=new ArrayList<Result>();
        DbConnection dbConnection=new DbConnection();
        Connection connection=dbConnection.getDbconnection();
        String sql="select * from result";
        try {
            PreparedStatement statement=connection.prepareStatement(sql);
            boolean val=statement.execute();
            if(val){
                ResultSet resultSet=statement.getResultSet();
                while(resultSet.next()){
                    int id=resultSet.getInt("id");
                    int questionId=resultSet.getInt("q_id");
                    int userId=resultSet.getInt("user_id");
                    int marks=resultSet.getInt("marks");

                    Result result=new Result();

                    result.setId(id);
                    result.setUserId(userId);
                    result.setQuestionId(questionId);
                    result.setMarks(marks);

                    resultList.add(result);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    public void deleteQuestionList(int id) {
        DbConnection dbConnection=new DbConnection();
        Connection connection=dbConnection.getDbconnection();
        String sql="delete from result where user_id=?";
        try {
            PreparedStatement statement=connection.prepareStatement(sql);
            statement.setInt(1,id);
            int affectedRows=statement.executeUpdate();
            if(affectedRows>0){
                System.out.println(affectedRows+""+"row(s)affected");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
