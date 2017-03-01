/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import entity.Student;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ChiNguyen
 */
public class DataModelStudentList extends AbstractTableModel {

    private final ArrayList<Object> list;
    private final ArrayList header;

    public DataModelStudentList(ArrayList<Object> list, ArrayList header) {
        this.list = list;
        this.header = header;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return header.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        switch (columnIndex) {
            case 0:
                return ((Student) list.get(rowIndex)).getStudentId();
            case 1:
                return ((Student) list.get(rowIndex)).getStudentName();
            case 2:
                return ((Student) list.get(rowIndex)).getStudentBirth();
            case 3:
                return ((Student) list.get(rowIndex)).getStudentGender();
            case 4:
                return ((Student) list.get(rowIndex)).getStudentPhone();
            case 5:
                return ((Student) list.get(rowIndex)).getStudentEmail();
            case 6:
                return ((Student) list.get(rowIndex)).getStudentAddress();
            default:
                return null;
        }
    }
    
    public String getImageStudentAt(int rowIndex) {
        return ( (Student) list.get(rowIndex) ).getImageUrl();
    }

    @Override
    public String getColumnName(int column) {

        return (String) header.get(column);
    }
    
    // Remove Student from datamodel at specific index
    public void removeRow(int row) {
        list.remove(row);
        fireTableDataChanged();
    }
    
    // Add Student into datamodel
    public void addData(Student student) {
        list.add(student);
        fireTableDataChanged();
    }
    
    // Update data 
    public void updateData(Student student, int rowSelect) {
        list.set(rowSelect, student);
        fireTableDataChanged();
    }
    
    

}
