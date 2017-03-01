/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import entity.Transcript;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ChiNguyen
 */
public class DataModelTranscriptList extends AbstractTableModel {

    private ArrayList<Object> dataList;
    private ArrayList columnName;

    public DataModelTranscriptList(ArrayList<Object> dataList, ArrayList columnName) {
        this.dataList = dataList;
        this.columnName = columnName;
    }

    @Override
    public int getRowCount() {
        return dataList.size();
    }

    @Override
    public int getColumnCount() {
        return columnName.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return ((Transcript) dataList.get(rowIndex)).getStudentId();
            case 1:
                return ((Transcript) dataList.get(rowIndex)).getSubjectId();
            case 2:
                return ((Transcript) dataList.get(rowIndex)).getQuiz1();
            case 3:
                return ((Transcript) dataList.get(rowIndex)).getQuiz2();
            case 4:
                return ((Transcript) dataList.get(rowIndex)).getQuiz3();
            case 5:
                return ((Transcript) dataList.get(rowIndex)).getQuiz4();
            case 6:
                return ((Transcript) dataList.get(rowIndex)).getLab1();
            case 7:
                return ((Transcript) dataList.get(rowIndex)).getLab2();
            case 8:
                return ((Transcript) dataList.get(rowIndex)).getLab3();
            case 9:
                return ((Transcript) dataList.get(rowIndex)).getLab4();
            case 10:
                return ((Transcript) dataList.get(rowIndex)).getAssignment1();
            case 11:
                return ((Transcript) dataList.get(rowIndex)).getAssignment2();
            case 12:
                return ((Transcript) dataList.get(rowIndex)).getTest();
            case 13:
                return ((Transcript) dataList.get(rowIndex)).calculateAverageMark();
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int column) {
        return (String) columnName.get(column);
    }

    public void addDataIntoModel(Transcript transcript) {
        dataList.add(transcript);
        fireTableDataChanged();
    }

    public void modifyDataModel(int rowIndex, Transcript transcript) {
        dataList.set(rowIndex, transcript);
        fireTableDataChanged();
    }
    
    public void sortDataModel(boolean type) {
        Sort.quickSort(dataList, type);
        fireTableDataChanged();
    }

}
