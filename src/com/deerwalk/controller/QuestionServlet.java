package com.deerwalk.controller;

import com.deerwalk.model.Question;
import com.deerwalk.model.Result;
import com.deerwalk.model.Role;
import com.deerwalk.model.User;
import com.deerwalk.service.DbConnection;
import com.deerwalk.service.QuestionService;
import com.deerwalk.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Dell on 10/30/2017.
 */
public class QuestionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page");
        if (page.equalsIgnoreCase("addQuestion")) {
            String question = request.getParameter("question");
            String option1 = request.getParameter("option1");
            String option2 = request.getParameter("option2");
            String option3 = request.getParameter("option3");
            String option4 = request.getParameter("option4");
            String correctAnswer = request.getParameter("answer");
            String category = request.getParameter("category");

            Question question1 = new Question();
            question1.setQuestion(question);
            question1.setOption1(option1);
            question1.setOption2(option2);
            question1.setOption3(option3);
            question1.setOption4(option4);
            question1.setCorrectAnswer(correctAnswer);
            question1.setCategory(category);

            boolean isSuccess = new QuestionService().addQuestion(question1);
            if (isSuccess) {
                List<Question> questionList = new QuestionService().getQuestionList();
                System.out.println("Question List Size:" + questionList.size());
                request.setAttribute("question", questionList);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/html/question/list.jsp");
                requestDispatcher.forward(request, response);
            }
        } else if (page.equalsIgnoreCase("editQuestion")) {
            String id = request.getParameter("id");
            String question = request.getParameter("question");
            String option1 = request.getParameter("option1");
            String option2 = request.getParameter("option2");
            String option3 = request.getParameter("option3");
            String option4 = request.getParameter("option4");
            String correctAnswer = request.getParameter("answer");
            String category = request.getParameter("category");

            Question question1 = new Question();
            question1.setId(Integer.parseInt(id));
            question1.setQuestion(question);
            question1.setOption1(option1);
            question1.setOption2(option2);
            question1.setOption3(option3);
            question1.setOption4(option4);
            question1.setCorrectAnswer(correctAnswer);
            question1.setCategory(category);
            boolean isSuccess = new QuestionService().updateQuestion(question1);
            if (isSuccess) {
                List<Question> questionList = new QuestionService().getQuestionList();
                System.out.println("Question List Size:" + questionList.size());
                request.setAttribute("question", questionList);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/html/question/list.jsp");
                requestDispatcher.forward(request, response);
            }
        }else if(page.equalsIgnoreCase("playQuizNext")){
            String timeTaken=request.getParameter("second");
            String category=request.getParameter("category");
            String difficulty=request.getParameter("difficulty");
            String id=request.getParameter("id");
            System.out.println("Question ID:"+id);
            String checkedAnswer=request.getParameter("option");
            String correctAnswer=request.getParameter("correctAnswer");
            User user= (User) request.getSession().getAttribute("user");
            if(checkedAnswer==null){
                int updated=new QuestionService().getResult(user.getId(),Integer.parseInt(id),0,Integer.parseInt(timeTaken));
            }
            else {

                if (checkedAnswer.equalsIgnoreCase(correctAnswer)) {
                    int updated = new QuestionService().getResult(user.getId(), Integer.parseInt(id), 5, Integer.parseInt(timeTaken));
//

                } else {
                    int updated = new QuestionService().getResult(user.getId(), Integer.parseInt(id), 0, Integer.parseInt(timeTaken));
//
                }
            }


            List<Result> questionIdList = new QuestionService().getQuestionIdList(user.getId());
            Question question = new QuestionService().getRandomQuestion1(questionIdList,category,difficulty);

            if (question != null) {
                request.setAttribute("question", question);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/html/question/playQuiz.jsp");
                requestDispatcher.forward(request, response);
            } else {
                questionIdList = new QuestionService().getQuestionIdList(user.getId());
                request.setAttribute("result",questionIdList);
                new QuestionService().deleteQuestionList(user.getId());
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/html/question/result.jsp");
                requestDispatcher.forward(request, response);

            }
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page");
        System.out.println("Page:"+page);
        if (page.equalsIgnoreCase("createQuestion")) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/html/question/question.jsp");
            requestDispatcher.forward(request, response);
        } else if (page.equalsIgnoreCase("list")) {

            List<Question> questionList = new QuestionService().getQuestionList();
            System.out.println("Question List Size:" + questionList.size());
            request.setAttribute("question", questionList);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/html/question/list.jsp");
            requestDispatcher.forward(request, response);
        } else if (page.equalsIgnoreCase("editQuestion")) {
            String id = request.getParameter("id");
            Question question = new QuestionService().editQuestion(id);
            request.setAttribute("q", question);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/html/question/edit.jsp");
            requestDispatcher.forward(request, response);


        } else if (page.equalsIgnoreCase("deleteQuestion")) {
            PrintWriter writer = response.getWriter();
            String id = request.getParameter("id");
            int question = new QuestionService().deleteQuestion(id);
            if (question > 0) {
                List<Question> questionList = new QuestionService().getQuestionList();
                System.out.println("Question List Size:" + questionList.size());
                request.setAttribute("question", questionList);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/html/question/list.jsp");
                requestDispatcher.forward(request, response);
            }

        } else if (page.equalsIgnoreCase("playQuiz")) {


            String difficulty=request.getParameter("difficulty");
            String category=request.getParameter("category");
            System.out.println("Category:"+category);
            Question question = new QuestionService().getRandomQuestion(category,difficulty);
            System.out.println(question);
            if (question != null) {
                request.setAttribute("question", question);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/html/question/playQuiz.jsp");
                requestDispatcher.forward(request, response);
            }


        }
        else if(page.equalsIgnoreCase("selectCategory")){
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("/html/question/selectCategory.jsp");
            requestDispatcher.forward(request,response);
        }
        else if(page.equalsIgnoreCase("quit")){
            User user= (User) request.getSession().getAttribute("user");
            Role role1=new UserService().getRole(user.getId());
            request.setAttribute("r",role1);
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("connected.jsp");
            requestDispatcher.forward(request,response);
        }
        else if(page.equalsIgnoreCase("selectDifficulty")){
            String category=request.getParameter("category");
            System.out.println(category);
            request.setAttribute("category",category);
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("/html/question/selectDifficulty.jsp");
            requestDispatcher.forward(request,response);

        }
    }
}
