package com.design.patterns.adapter;

import java.util.ArrayList;
import java.util.List;

public class StudentList {
    public static void main(String[] args) {
        StudentClient studentClient = new StudentClient();
        List<Student> studentList = studentClient.getStudentList();
        System.out.println(studentList);
    }

    private static class StudentClient {
        public List<Student> getStudentList() {
            List<Student> studentList = new ArrayList<>();
            CollegeStudent collegeStudent = new CollegeStudent("a", "b", "c");
            SchoolStudent schoolStudent = new SchoolStudent("a", "b", "c");
            studentList.add(collegeStudent);
            studentList.add(new SchoolStudentAdapter(schoolStudent));
            return studentList;
        }
    }

    public static class SchoolStudentAdapter implements Student {
        SchoolStudent schoolStudent;

        public SchoolStudentAdapter(SchoolStudent schoolStudent) {
            this.schoolStudent = schoolStudent;
        }

        @Override
        public String getName() {
            return schoolStudent.getFirstName();
        }

        @Override
        public String getSurname() {
            return schoolStudent.getLastName();
        }

        @Override
        public String getEmail() {
            return schoolStudent.getEmailAddress();
        }
    }

    private static class CollegeStudent implements Student {
        String name;
        String surname;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSurname() {
            return surname;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        String email;

        public CollegeStudent(String name, String surname, String email) {
            this.name = name;
            this.surname = surname;
            this.email = email;
        }

    }

    private static class SchoolStudent {
        String firstName;
        String lastName;

        public SchoolStudent(String firstName, String lastName, String emailAddress) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.emailAddress = emailAddress;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getEmailAddress() {
            return emailAddress;
        }

        public void setEmailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
        }

        String emailAddress;
    }

    private interface Student {
        public String getName();

        public String getSurname();

        public String getEmail();

    }
}
