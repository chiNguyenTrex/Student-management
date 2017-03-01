/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author ChiNguyen
 */
public class Transcript {
    private String studentId;
    private String subjectId;
    private double lab1; 
    private double lab2; 
    private double lab3;
    private double lab4; //4%
    private double quiz1;
    private double quiz2;
    private double quiz3;
    private double quiz4; // 8%
    private double assignment1; // 20%
    private double assignment2; // 40%
    private double test;

    public Transcript() {
        
    }
    public Transcript(String studentId, String subjectId, double lab1, double lab2, double lab3, double lab4, double quiz1, double quiz2, double quiz3, double quiz4, double assignment1, double assignment2, double test) {
        this.studentId = studentId;
        this.subjectId = subjectId;
        this.lab1 = lab1;
        this.lab2 = lab2;
        this.lab3 = lab3;
        this.lab4 = lab4;
        this.quiz1 = quiz1;
        this.quiz2 = quiz2;
        this.quiz3 = quiz3;
        this.quiz4 = quiz4;
        this.assignment1 = assignment1;
        this.assignment2 = assignment2;
        this.test = test;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public double getLab1() {
        return lab1;
    }

    public void setLab1(double lab1) {
        this.lab1 = lab1;
    }

    public double getLab2() {
        return lab2;
    }

    public void setLab2(double lab2) {
        this.lab2 = lab2;
    }

    public double getLab3() {
        return lab3;
    }

    public void setLab3(double lab3) {
        this.lab3 = lab3;
    }

    public double getLab4() {
        return lab4;
    }

    public void setLab4(double lab4) {
        this.lab4 = lab4;
    }

    public double getQuiz1() {
        return quiz1;
    }

    public void setQuiz1(double quiz1) {
        this.quiz1 = quiz1;
    }

    public double getQuiz2() {
        return quiz2;
    }

    public void setQuiz2(double quiz2) {
        this.quiz2 = quiz2;
    }

    public double getQuiz3() {
        return quiz3;
    }

    public void setQuiz3(double quiz3) {
        this.quiz3 = quiz3;
    }

    public double getQuiz4() {
        return quiz4;
    }

    public void setQuiz4(double quiz4) {
        this.quiz4 = quiz4;
    }

    public double getAssignment1() {
        return assignment1;
    }

    public void setAssignment1(double assignment1) {
        this.assignment1 = assignment1;
    }

    public double getAssignment2() {
        return assignment2;
    }

    public void setAssignment2(double assignment2) {
        this.assignment2 = assignment2;
    }

    public double getTest() {
        return test;
    }

    public void setTest(double test) {
        this.test = test;
    }
    
    
    public double calculateAverageMark() {
        return (double) Math.round( ((lab1+lab2+lab3+lab4)*0.02 + (quiz1+quiz2+quiz3+quiz4)*0.03 +
                (assignment1+assignment2)*0.2+test*0.4)*100 )/100;
    }
            
    
}
