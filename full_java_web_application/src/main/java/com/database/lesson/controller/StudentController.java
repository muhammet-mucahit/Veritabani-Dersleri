package com.database.lesson.controller;

import com.database.lesson.dao.StudentDao;
import com.database.lesson.model.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class StudentController extends HttpServlet {
    private static String INSERT_OR_EDIT = "/student.jsp";
    private static String LIST_STUDENT = "/listStudent.jsp";
    private StudentDao dao;

    public StudentController() {
        dao = new StudentDao();
    }

    Student TEMP_STUDENT;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward;
        String action = request.getParameter("action");
        TEMP_STUDENT = null;

        if (action.equalsIgnoreCase("delete")){
            int student_number = Integer.parseInt(request.getParameter("student_number"));
            dao.deleteStudent(student_number);
            forward = LIST_STUDENT;
            request.setAttribute("students", dao.getAllStudents());
        } else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            int student_number = Integer.parseInt(request.getParameter("student_number"));
            Student student = dao.getStudentByNumber(student_number);
            request.setAttribute("student", student);
            TEMP_STUDENT = student;
        } else if (action.equalsIgnoreCase("listStudent")){
            forward = LIST_STUDENT;
            request.setAttribute("students", dao.getAllStudents());
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Student student = new Student();
        student.setStudent_number(Integer.parseInt(request.getParameter("student_number")));
        student.setName(request.getParameter("name"));
        student.setSurname(request.getParameter("surname"));
        student.setPassword(request.getParameter("password"));


        if (TEMP_STUDENT == null)
            dao.addStudent(student);
        else
            dao.updateStudent(student, TEMP_STUDENT.getStudent_number());

        RequestDispatcher view = request.getRequestDispatcher(LIST_STUDENT);
        request.setAttribute("students", dao.getAllStudents());
        view.forward(request, response);
    }
}