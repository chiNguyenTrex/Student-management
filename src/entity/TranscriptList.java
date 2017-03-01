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
public class TranscriptList {
    private static ArrayList WEB_LIST;
    private static ArrayList JAVA_LIST;
    private static ArrayList NETWORK_LIST;
    private static ArrayList<String> HEADER;
    
    public static void setWebList() {
        WEB_LIST = new ArrayList<>();
    }
    public static ArrayList getWebList() {
        return WEB_LIST;
    }
    public static void setDataWebList(Transcript trans) {
        TranscriptList.WEB_LIST.add(trans);
    }
    
    public static void setJavaList() {
        JAVA_LIST = new ArrayList<>();
    }
    public static ArrayList getJavaList() {
        return JAVA_LIST;
    }
    public static void setDataJavaList(Transcript trans) {
        JAVA_LIST.add(trans);
    }
    
    public static void setNetWorkList() {
        NETWORK_LIST = new ArrayList<>();
    }
    public static ArrayList getNetworkList() {
        return NETWORK_LIST;
    }
    public static void setDataNetWorkList(Transcript trans) {
        NETWORK_LIST.add(trans);
    }
    
    public static void setHeader() {
        HEADER = new ArrayList<>();
        
        HEADER.add("ID");
        HEADER.add("Mã môn");
        HEADER.add("Quiz 1");
        HEADER.add("Quiz 2");
        HEADER.add("Quiz 3");
        HEADER.add("Quiz 4");
        HEADER.add("Lab 1");
        HEADER.add("Lab 2");
        HEADER.add("Lab 3");
        HEADER.add("Lab 4");
        HEADER.add("GĐ 1");
        HEADER.add("GĐ 2");
        HEADER.add("Test");
        HEADER.add("TB môn");
    }
    
    public static ArrayList<String> getHeader()  {
        return HEADER;
    }
    
}
