package com.example.sisapp;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;


public class StudentsList {

    private final DBHelper dbHelper;


    public StudentsList(Context context){
        this.dbHelper = new DBHelper(context);
    }

    public List<Student> getStudents() {
        return this.dbHelper.getAllStudents();
    }

    public  Student getStudentById(int id) {
        return this.dbHelper.getStudentById(id);

    }

    public long addStudent(Student newStudent) {
        return this.dbHelper.insertStudent(newStudent);
    }

    public long createStudent(int id, String nic, String firstName, String lastName, String fullName,
                                        String nameWithInitials, String addressLineOne, String addressLineTwo, int zipCode) {
        Student newStudent = new Student(id,nic, firstName, lastName, fullName, nameWithInitials, addressLineOne, addressLineTwo, zipCode);
        return this.dbHelper.insertStudent(newStudent);
    }




    public int deleteById(int id) {
        return this.dbHelper.deleteStudentById(id);
    }


    public void updateById(int id, Student updatedStudent) {
        this.dbHelper.updateStudentById(updatedStudent, id);

    }




}
