package com.database.lesson.dao;

import com.database.lesson.DbUtil;
import com.database.lesson.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {

    private Connection connection;

    public StudentDao() {
        connection = DbUtil.getConnection();
    }

    public void addStudent(Student student) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into student(student_number, name, surname, password) values (?, ?, ?, ?)");
            // Parameters start with 1
            preparedStatement.setInt(1, student.getStudent_number());
            preparedStatement.setString(2, student.getName());
            preparedStatement.setString(3, student.getSurname());
            preparedStatement.setString(4, student.getPassword());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent(int student_number) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from student where student_number = ?");
            preparedStatement.setInt(1, student_number);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateStudent(Student student, int old_number) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update student set student_number = ?, name = ?, surname = ?, password = ?" +
                            "where student_number = ?");
            preparedStatement.setInt(1, student.getStudent_number());
            preparedStatement.setString(2, student.getName());
            preparedStatement.setString(3, student.getSurname());
            preparedStatement.setString(4, student.getPassword());
            preparedStatement.setInt(5, old_number);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<Student>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from student");
            while (rs.next()) {
                Student student = new Student();
                student.setStudent_number(rs.getInt("student_number"));
                student.setName(rs.getString("name"));
                student.setSurname(rs.getString("surname"));
                student.setPassword(rs.getString("password"));
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return students;
    }

    public Student getStudentByNumber(int number) {
        Student student = new Student();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from student where student_number = ?");
            preparedStatement.setInt(1, number);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                student.setStudent_number(rs.getInt("student_number"));
                student.setName(rs.getString("name"));
                student.setSurname(rs.getString("surname"));
                student.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return student;
    }
}

