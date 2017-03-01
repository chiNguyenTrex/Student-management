/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.ArrayList;

/**
 *
 * @author ChiNguyen
 */
public class StudentList {

    private static ArrayList STUDENT_LIST;
    private static ArrayList<String> HEADER_TABLE;

    public static void setSTUDENT_LIST() {
        StudentList.STUDENT_LIST = new ArrayList();
    }  

    public static ArrayList getSTUDENT_LIST() {
        return STUDENT_LIST;
    }

    public static ArrayList<String> getColumnHead() {
        return HEADER_TABLE;
    }

    public static void setDataAt(Student student, int rowIndex) { // chèn một student vào STUDENT_LIST tại index
        STUDENT_LIST.set(rowIndex, student); // Không biết lúc đó mình nghĩ gì mà viết cái method này :)). Chưa tìm ra 
        // mình dùng nó ở chổ nào
    }

    public static void setData(Student student) { 
        STUDENT_LIST.add(student);
    }

    public static void setColumnHead() {
        HEADER_TABLE = new ArrayList<>();
        HEADER_TABLE.add("ID");
        HEADER_TABLE.add("Full name");
        HEADER_TABLE.add("Ngày sinh");
        HEADER_TABLE.add("Giới tính");
        HEADER_TABLE.add("Điện thoại");
        HEADER_TABLE.add("Email");
        HEADER_TABLE.add("Địa chỉ");
    }

}
