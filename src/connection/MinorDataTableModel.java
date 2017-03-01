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
public class MinorDataTableModel extends AbstractTableModel {

    private ArrayList<Object> listStudent;
    private String[] columnList;

    public MinorDataTableModel(ArrayList<Object> listStudent, String[] columnList) {
        this.listStudent = listStudent;
        this.columnList = columnList;
    }

    @Override
    public int getRowCount() {
        return listStudent.size();
    }

    @Override
    public int getColumnCount() {
        return columnList.length;
    }

    @Override
    public String getValueAt(int rowIndex, int columnIndex) {
        return ((Student) listStudent.get(rowIndex)).getStudentName();
    }

    public String getIdAt(int rowIndex) {
        return ((Student) listStudent.get(rowIndex)).getStudentId();
    }

    // Xóa SV khỏi datamodel dựa vào selectedIndexRow
    public void removeDataFromModel(int rowSelect) {
        listStudent.remove(rowSelect);
        fireTableDataChanged();
    }
    
    // Xóa SV khỏi datamodel dựa vào ID
    public void removeDataById(String id) {
        for (Object s : listStudent) {
            if (((Student) s).getStudentId().equals("id")) {
                listStudent.remove(s);
                fireTableDataChanged();
                break;
            }
        }

    }

}
