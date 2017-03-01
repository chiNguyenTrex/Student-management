/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teacher;

import connection.DataModelTranscriptList;
import connection.DatabaseConnect;
import connection.MinorDataTableModel;
import entity.StudentList;
import entity.Transcript;
import entity.TranscriptList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author ChiNguyen
 */
public class ManageMark extends javax.swing.JPanel {

    MinorDataTableModel mDTM;
    String[] headerName = {"Sinh viên"};

    DataModelTranscriptList javaModelList;
    DataModelTranscriptList webModelList;
    DataModelTranscriptList networkModelList;

    ListSelectionModel lSMStudentTable;
    ListSelectionListener lSLStudentTable;

    ListSelectionModel lSMTranscriptTable;
    ListSelectionListener lSLTranscriptTable;

    /**
     * Creates new form ManageMark
     */
    public ManageMark() {
        initComponents();

        txtID.setEditable(false);

        StudentList.setSTUDENT_LIST();
        DatabaseConnect.createConnection();
        DatabaseConnect.getStudentFromDatabase();
        StudentList.setColumnHead();

        // Setup data cho bang tableStudentList
        mDTM = new MinorDataTableModel(StudentList.getSTUDENT_LIST(), headerName);
        tableStudentList.setModel(mDTM);
        tableStudentList.setTableHeader(null);

        // set data cho bảng tableTranscript
        TranscriptList.setHeader();
        TranscriptList.setJavaList();
        TranscriptList.setNetWorkList();
        TranscriptList.setWebList();

        DatabaseConnect.createConnection();
        DatabaseConnect.getTranscriptFromDatabase();

        javaModelList = new DataModelTranscriptList(TranscriptList.getJavaList(), TranscriptList.getHeader());
        networkModelList = new DataModelTranscriptList(TranscriptList.getNetworkList(), TranscriptList.getHeader());
        webModelList = new DataModelTranscriptList(TranscriptList.getWebList(), TranscriptList.getHeader());

        tableTranscript.setModel(javaModelList);
        tableStudentList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //tableStudentList.setRowSelectionInterval(1, 1);

        // Bắt sự kiện selection trên bảng student
        lSMStudentTable = tableStudentList.getSelectionModel();
        lSMStudentTable.addListSelectionListener(lSLStudentTable = new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                if (e.getValueIsAdjusting()) {
                    // Mouse Pressed
                    int rowIndex = tableStudentList.getSelectedRow();

                    txtID.setText(mDTM.getIdAt(rowIndex));
   

                } else {
                    // Mouse Release

                }

            }
        });

        tableTranscript.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //Bắt sư kiện selection trên bảng Transcript
        lSMTranscriptTable = tableTranscript.getSelectionModel();
        lSMTranscriptTable.addListSelectionListener(lSLStudentTable = new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) {
                    return;
                }

                int rowIndex = tableTranscript.getSelectedRow();

                if (rowIndex >= 0 && rowIndex < tableTranscript.getModel().getRowCount()) {
                    txtID.setText(tableTranscript.getModel().getValueAt(rowIndex, 0).toString());

                    String subID = tableTranscript.getModel().getValueAt(rowIndex, 1).toString();
                    if (subID.equals("NET1111")) {
                        comboSubject.setSelectedIndex(1);
                    } else if (subID.equals("JAV2222")) {
                        comboSubject.setSelectedIndex(2);
                    } else {
                        comboSubject.setSelectedIndex(3);
                    }

                    txtQ1.setText(tableTranscript.getModel().getValueAt(rowIndex, 2).toString());
                    txtQ2.setText(tableTranscript.getModel().getValueAt(rowIndex, 3).toString());
                    txtQ3.setText(tableTranscript.getModel().getValueAt(rowIndex, 4).toString());
                    txtQ4.setText(tableTranscript.getModel().getValueAt(rowIndex, 5).toString());
                    txtL1.setText(tableTranscript.getModel().getValueAt(rowIndex, 6).toString());
                    txtL2.setText(tableTranscript.getModel().getValueAt(rowIndex, 7).toString());
                    txtL3.setText(tableTranscript.getModel().getValueAt(rowIndex, 8).toString());
                    txtL4.setText(tableTranscript.getModel().getValueAt(rowIndex, 9).toString());
                    txtAss1.setText(tableTranscript.getModel().getValueAt(rowIndex, 10).toString());
                    txtAss2.setText(tableTranscript.getModel().getValueAt(rowIndex, 11).toString());
                    txtEnd.setText(tableTranscript.getModel().getValueAt(rowIndex, 12).toString());
                }

            }
        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel37 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableStudentList = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblWarnID = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        lblWarnSubject = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        lblWarnAss1 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        lblWarnAss2 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        txtID = new javax.swing.JTextField();
        jPanel15 = new javax.swing.JPanel();
        comboSubject = new javax.swing.JComboBox<>();
        jPanel16 = new javax.swing.JPanel();
        txtAss1 = new javax.swing.JTextField();
        jPanel17 = new javax.swing.JPanel();
        txtAss2 = new javax.swing.JTextField();
        jPanel18 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lblWarnQ1 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lblWarnQ2 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        lblWarnQ3 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        lblWarnQ4 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        txtQ1 = new javax.swing.JTextField();
        jPanel23 = new javax.swing.JPanel();
        txtQ2 = new javax.swing.JTextField();
        jPanel24 = new javax.swing.JPanel();
        txtQ3 = new javax.swing.JTextField();
        jPanel25 = new javax.swing.JPanel();
        txtQ4 = new javax.swing.JTextField();
        jPanel26 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        lblWarnL1 = new javax.swing.JLabel();
        jPanel27 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        lblWarnL2 = new javax.swing.JLabel();
        jpaane = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        lblWarnL3 = new javax.swing.JLabel();
        jPanel29 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        lblWarnL4 = new javax.swing.JLabel();
        jPanel30 = new javax.swing.JPanel();
        txtL1 = new javax.swing.JTextField();
        jPanel31 = new javax.swing.JPanel();
        txtL2 = new javax.swing.JTextField();
        jPanel32 = new javax.swing.JPanel();
        txtL3 = new javax.swing.JTextField();
        jPanel33 = new javax.swing.JPanel();
        txtL4 = new javax.swing.JTextField();
        jPanel34 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        lblWarnEnd = new javax.swing.JLabel();
        jPanel35 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jPanel36 = new javax.swing.JPanel();
        jPanel38 = new javax.swing.JPanel();
        jPanel39 = new javax.swing.JPanel();
        txtEnd = new javax.swing.JTextField();
        jPanel40 = new javax.swing.JPanel();
        comboSort = new javax.swing.JComboBox<>();
        jPanel41 = new javax.swing.JPanel();
        btnUpdate = new javax.swing.JButton();
        jPanel42 = new javax.swing.JPanel();
        btnSubmit = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableTranscript = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(1000, 567));
        setLayout(new java.awt.BorderLayout());

        jPanel37.setBackground(new java.awt.Color(102, 255, 255));
        jPanel37.setPreferredSize(new java.awt.Dimension(1066, 330));
        jPanel37.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(153, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(200, 330));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setPreferredSize(new java.awt.Dimension(198, 45));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel4, java.awt.BorderLayout.PAGE_START);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách sinh viên", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        jPanel5.setLayout(new java.awt.GridLayout(1, 1));

        jScrollPane1.setViewportView(tableStudentList);

        jPanel5.add(jScrollPane1);

        jPanel2.add(jPanel5, java.awt.BorderLayout.CENTER);

        jPanel37.add(jPanel2, java.awt.BorderLayout.LINE_END);

        jPanel3.setLayout(new java.awt.GridLayout(9, 4));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel6);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel7);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel8);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel9);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("ID");

        lblWarnID.setForeground(new java.awt.Color(255, 0, 0));
        lblWarnID.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(34, 34, 34)
                .addComponent(lblWarnID, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                .addGap(23, 23, 23))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblWarnID, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel10);

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Môn học");

        lblWarnSubject.setForeground(new java.awt.Color(255, 0, 0));
        lblWarnSubject.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblWarnSubject, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                .addGap(24, 24, 24))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(lblWarnSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel11);

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Assignment 1");

        lblWarnAss1.setForeground(new java.awt.Color(255, 0, 0));
        lblWarnAss1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblWarnAss1, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                .addGap(22, 22, 22))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(lblWarnAss1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel12);

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Assignment 2");

        lblWarnAss2.setForeground(new java.awt.Color(255, 0, 0));
        lblWarnAss2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblWarnAss2, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                .addGap(21, 21, 21))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(lblWarnAss2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel13);

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));

        txtID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel14);

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));

        comboSubject.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        comboSubject.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Môn học", "Quảng trị mạng", "Java nâng cao", "Thiết kế web" }));
        comboSubject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSubjectActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(comboSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(comboSubject, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel15);

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));

        txtAss1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtAss1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtAss1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel16);

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));

        txtAss2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtAss2, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtAss2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel17);

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Quiz 1");

        lblWarnQ1.setForeground(new java.awt.Color(255, 0, 0));
        lblWarnQ1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblWarnQ1, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                .addGap(23, 23, 23))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblWarnQ1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel18);

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Quiz 2");

        lblWarnQ2.setForeground(new java.awt.Color(255, 0, 0));
        lblWarnQ2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblWarnQ2, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                .addGap(23, 23, 23))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblWarnQ2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel19);

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Quiz 3");

        lblWarnQ3.setForeground(new java.awt.Color(255, 0, 0));
        lblWarnQ3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblWarnQ3, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                .addGap(23, 23, 23))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblWarnQ3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel20);

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Quiz 4");

        lblWarnQ4.setForeground(new java.awt.Color(255, 0, 0));
        lblWarnQ4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblWarnQ4, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                .addGap(22, 22, 22))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lblWarnQ4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel21);

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));

        txtQ1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtQ1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtQ1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel22);

        jPanel23.setBackground(new java.awt.Color(255, 255, 255));

        txtQ2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtQ2, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtQ2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel23);

        jPanel24.setBackground(new java.awt.Color(255, 255, 255));

        txtQ3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtQ3, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtQ3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel24);

        jPanel25.setBackground(new java.awt.Color(255, 255, 255));

        txtQ4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtQ4, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtQ4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel25);

        jPanel26.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Lab 1");

        lblWarnL1.setForeground(new java.awt.Color(255, 0, 0));
        lblWarnL1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(lblWarnL1, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                .addGap(23, 23, 23))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lblWarnL1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel26);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Lab 2");

        lblWarnL2.setForeground(new java.awt.Color(255, 0, 0));
        lblWarnL2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(lblWarnL2, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                .addGap(23, 23, 23))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(lblWarnL2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel27);

        jpaane.setBackground(new java.awt.Color(255, 255, 255));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Lab 3");

        lblWarnL3.setForeground(new java.awt.Color(255, 0, 0));
        lblWarnL3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jpaaneLayout = new javax.swing.GroupLayout(jpaane);
        jpaane.setLayout(jpaaneLayout);
        jpaaneLayout.setHorizontalGroup(
            jpaaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpaaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblWarnL3, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                .addGap(23, 23, 23))
        );
        jpaaneLayout.setVerticalGroup(
            jpaaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpaaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpaaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(lblWarnL3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.add(jpaane);

        jPanel29.setBackground(new java.awt.Color(255, 255, 255));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Lab 4");

        lblWarnL4.setForeground(new java.awt.Color(255, 0, 0));
        lblWarnL4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblWarnL4, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                .addGap(22, 22, 22))
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(lblWarnL4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel29);

        jPanel30.setBackground(new java.awt.Color(255, 255, 255));

        txtL1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtL1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtL1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel30);

        jPanel31.setBackground(new java.awt.Color(255, 255, 255));

        txtL2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtL2, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtL2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel31);

        jPanel32.setBackground(new java.awt.Color(255, 255, 255));

        txtL3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtL3, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtL3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel32);

        jPanel33.setBackground(new java.awt.Color(255, 255, 255));

        txtL4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtL4, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtL4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel33);

        jPanel34.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Kết thúc môn");

        lblWarnEnd.setForeground(new java.awt.Color(255, 0, 0));
        lblWarnEnd.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblWarnEnd, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                .addGap(22, 22, 22))
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(lblWarnEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel34);

        jPanel35.setBackground(new java.awt.Color(255, 255, 255));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Sắp xếp");

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addContainerGap(140, Short.MAX_VALUE))
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel35);

        jPanel36.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel36);

        jPanel38.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel38);

        jPanel39.setBackground(new java.awt.Color(255, 255, 255));

        txtEnd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel39Layout = new javax.swing.GroupLayout(jPanel39);
        jPanel39.setLayout(jPanel39Layout);
        jPanel39Layout.setHorizontalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel39Layout.setVerticalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtEnd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel39);

        jPanel40.setBackground(new java.awt.Color(255, 255, 255));

        comboSort.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        comboSort.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "      ", "Giảm dần", "Tăng dần" }));
        comboSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSortActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(jPanel40);
        jPanel40.setLayout(jPanel40Layout);
        jPanel40Layout.setHorizontalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(comboSort, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel40Layout.setVerticalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(comboSort, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel40);

        jPanel41.setBackground(new java.awt.Color(255, 255, 255));

        btnUpdate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel41Layout = new javax.swing.GroupLayout(jPanel41);
        jPanel41.setLayout(jPanel41Layout);
        jPanel41Layout.setHorizontalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel41Layout.createSequentialGroup()
                .addContainerGap(84, Short.MAX_VALUE)
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        jPanel41Layout.setVerticalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel41);

        jPanel42.setBackground(new java.awt.Color(255, 255, 255));

        btnSubmit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel42Layout = new javax.swing.GroupLayout(jPanel42);
        jPanel42.setLayout(jPanel42Layout);
        jPanel42Layout.setHorizontalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel42Layout.createSequentialGroup()
                .addContainerGap(85, Short.MAX_VALUE)
                .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel42Layout.setVerticalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnSubmit, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel42);

        jPanel37.add(jPanel3, java.awt.BorderLayout.CENTER);

        add(jPanel37, java.awt.BorderLayout.PAGE_START);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1066, 237));
        jPanel1.setLayout(new java.awt.GridLayout(1, 1));

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setViewportView(tableTranscript);

        jPanel1.add(jScrollPane2);

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        int check = 0;

        double q1 = 0, q2 = 0, q3 = 0, q4 = 0, l1 = 0, l2 = 0, l3 = 0, l4 = 0, ass1 = 0, ass2 = 0, test = 0;
        int indexSelect = comboSubject.getSelectedIndex();
        String idSub = "", idStd = "";

        // Kiễm tra ID sv và ID môn xem có tồn tại trong DB chưa
        if (txtID.getText().equals("")) {
            lblWarnID.setText("Chưa chọn sinh viên");
        } else {
            lblWarnID.setText("");
            if (indexSelect == 1) {
                idSub = "NET1111";
            }
            if (indexSelect == 2) {
                idSub = "JAV2222";
            }
            if (indexSelect == 3) {
                idSub = "WEB3034";
            }
            idStd = txtID.getText();

            DatabaseConnect.createConnection();
            if (DatabaseConnect.checkIDSubjectAndIDStudent(idStd, idSub)) {
                check++; //1
            } else {
                JOptionPane.showMessageDialog(null, "Sinh viên này đã có điễm môn " + comboSubject.getSelectedItem().toString());
            }

        }

        if (txtQ1.getText().equals("")) {
            lblWarnQ1.setText("Nhập điểm");
        } else {
            try {
                q1 = Double.parseDouble(txtQ1.getText());

                if (q1 > 10 || q1 < 0) {
                    lblWarnQ1.setText("Điễm 0 - 10");
                } else {
                    check++; //2
                    lblWarnQ1.setText("");
                }

            } catch (Exception e) {
                lblWarnQ1.setText("Nhập kiểu số");
            }
        }

        if (txtQ2.getText().equals("")) {
            lblWarnQ2.setText("Nhập điểm");
        } else {
            try {
                q2 = Double.parseDouble(txtQ2.getText());
                if (q2 > 10 || q2 < 0) {
                    lblWarnQ2.setText("Điễm 0 - 10");
                } else {
                    check++; //3
                    lblWarnQ2.setText("");
                }
            } catch (Exception e) {
                lblWarnQ2.setText("Nhập kiểu số");
            }
        }

        if (txtQ3.getText().equals("")) {
            lblWarnQ3.setText("Nhập điểm");
        } else {
            try {
                q3 = Double.parseDouble(txtQ3.getText());
                if (q3 > 10 || q3 < 0) {
                    lblWarnQ3.setText("Điễm 0 - 10");
                } else {
                    check++; //4
                    lblWarnQ3.setText("");
                }
            } catch (Exception e) {
                lblWarnQ3.setText("Nhập kiểu số");
            }
        }

        if (txtQ4.getText().equals("")) {
            lblWarnQ4.setText("Nhập điểm");
        } else {
            try {
                q4 = Double.parseDouble(txtQ4.getText());
                if (q4 > 10 || q4 < 0) {
                    lblWarnQ4.setText("Điễm 0 - 10");
                } else {
                    check++; //5
                    lblWarnQ4.setText("");
                }
            } catch (Exception e) {
                lblWarnQ4.setText("Nhập kiểu số");
            }
        }

        if (txtL1.getText().equals("")) {
            lblWarnL1.setText("Nhập điểm");
        } else {
            try {
                l1 = Double.parseDouble(txtL1.getText());
                if (l1 > 10 || l1 < 0) {
                    lblWarnL1.setText("Điễm 0 - 10");
                } else {
                    check++; //6
                    lblWarnL1.setText("");
                }
            } catch (Exception e) {
                lblWarnL1.setText("Nhập kiểu số");
            }
        }

        if (txtL2.getText().equals("")) {
            lblWarnL2.setText("Nhập điểm");
        } else {
            try {
                l2 = Double.parseDouble(txtL2.getText());
                if (l2 > 10 || l2 < 0) {
                    lblWarnL2.setText("Điễm 0 - 10");
                } else {
                    check++; //7
                    lblWarnL2.setText("");
                }
            } catch (Exception e) {
                lblWarnL2.setText("Nhập kiểu số");
            }
        }

        if (txtL3.getText().equals("")) {
            lblWarnL3.setText("Nhập điểm");
        } else {
            try {
                l3 = Double.parseDouble(txtL3.getText());
                if (l3 > 10 || l3 < 0) {
                    lblWarnL3.setText("Điễm 0 - 10");
                } else {
                    check++; //8
                    lblWarnL3.setText("");
                }
            } catch (Exception e) {
                lblWarnL3.setText("Nhập kiểu số");
            }
        }

        if (txtL4.getText().equals("")) {
            lblWarnL4.setText("Nhập điểm");
        } else {
            try {
                l4 = Double.parseDouble(txtL4.getText());
                if (l4 > 10 || l4 < 0) {
                    lblWarnL4.setText("Điễm 0 - 10");
                } else {
                    check++; //9
                    lblWarnL4.setText("");
                }
            } catch (Exception e) {
                lblWarnL4.setText("Nhập kiểu số");
            }
        }

        if (txtAss1.getText().equals("")) {
            lblWarnAss1.setText("Nhập điểm");
        } else {
            try {
                ass1 = Double.parseDouble(txtAss1.getText());
                if (ass1 > 10 || ass1 < 0) {
                    lblWarnAss1.setText("Điễm 0 - 10");
                } else {
                    check++; //10
                    lblWarnAss1.setText("");
                }
            } catch (Exception e) {
                lblWarnAss1.setText("Nhập kiểu số");
            }
        }

        if (txtAss2.getText().equals("")) {
            lblWarnAss2.setText("Nhập điểm");
        } else {
            try {
                ass2 = Double.parseDouble(txtAss2.getText());
                if (ass2 > 10 || ass2 < 0) {
                    lblWarnAss2.setText("Điễm 0 - 10");
                } else {
                    check++; //11
                    lblWarnAss2.setText("");
                }
            } catch (Exception e) {
                lblWarnAss2.setText("Nhập kiểu số");
            }
        }

        if (txtEnd.getText().equals("")) {
            lblWarnEnd.setText("Nhập điểm");
        } else {
            try {
                test = Double.parseDouble(txtEnd.getText());
                if (test > 10 || test < 0) {
                    lblWarnEnd.setText("Điễm 0 - 10");
                } else {
                    check++; //12
                    lblWarnEnd.setText("");
                }
            } catch (Exception e) {
                lblWarnEnd.setText("Nhập kiểu số");
            }
        }

        if (comboSubject.getSelectedIndex() == 0) {
            lblWarnSubject.setText("Chọn môn học");
        } else {
            lblWarnSubject.setText("");
            check++; //13
        }

        if (check == 13) {

            // Thêm data vào database
            DatabaseConnect.createConnection();
            int rowAffect = DatabaseConnect.insertTranscripIntoDatabase(idStd, idSub, l1, l2, l3, l4, q1, q2, q3, q4, ass1, ass2, test);
            // Nếu thêm vào DB thành công thì thêm vào table model
            if (rowAffect == 1) {
                Transcript trs = new Transcript(idStd, idSub, l1, l2, l3, l4, q1, q2, q3, q4, ass1, ass2, test);
                if (indexSelect == 1) {
                    networkModelList.addDataIntoModel(trs);
                }
                if (indexSelect == 2) {
                    javaModelList.addDataIntoModel(trs);
                }
                if (indexSelect == 3) {
                    webModelList.addDataIntoModel(trs);
                }

            }

            txtID.setText("");
            txtAss1.setText("");
            txtAss2.setText("");
            txtQ1.setText("");
            txtQ3.setText("");
            txtQ2.setText("");
            txtQ4.setText("");
            txtL1.setText("");
            txtL2.setText("");
            txtL3.setText("");
            txtL4.setText("");
            txtEnd.setText("");

        }


    }//GEN-LAST:event_btnSubmitActionPerformed

    private void comboSubjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSubjectActionPerformed

        int indexSelect = comboSubject.getSelectedIndex();

        if (indexSelect == 1) {
            tableTranscript.setModel(networkModelList);

        }
        if (indexSelect == 2) {
            tableTranscript.setModel(javaModelList);

        }
        if (indexSelect == 3) {
            tableTranscript.setModel(webModelList);

        }

    }//GEN-LAST:event_comboSubjectActionPerformed

    private void comboSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSortActionPerformed

        int selectIndex = comboSubject.getSelectedIndex();
        int selectIndexSort = comboSort.getSelectedIndex();
        switch (selectIndex) {
            case 1:
                if (selectIndexSort == 1) {
                    networkModelList.sortDataModel(false);
                }
                if (selectIndexSort == 2) {
                    networkModelList.sortDataModel(true);
                }
                break;
            case 2:
                if (selectIndexSort == 1) {
                    javaModelList.sortDataModel(false);
                }
                if (selectIndexSort == 2) {
                    javaModelList.sortDataModel(true);
                }
                break;
            case 3:
                if (selectIndexSort == 1) {
                    webModelList.sortDataModel(false);
                }
                if (selectIndexSort == 2) {
                    webModelList.sortDataModel(true);
                }
                break;
            default:
                break;
        }


    }//GEN-LAST:event_comboSortActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        int check = 0;

        double q1 = 0, q2 = 0, q3 = 0, q4 = 0, l1 = 0, l2 = 0, l3 = 0, l4 = 0, ass1 = 0, ass2 = 0, test = 0;

        if (txtID.getText().equals("")) {
            lblWarnID.setText("Chưa chọn sinh viên");
        } else {
            lblWarnID.setText("");
            check++; //1
        }

        if (txtQ1.getText().equals("")) {
            lblWarnQ1.setText("Nhập điểm");
        } else {
            try {
                q1 = Double.parseDouble(txtQ1.getText());

                if (q1 > 10 || q1 < 0) {
                    lblWarnQ1.setText("Điễm 0 - 10");
                } else {
                    check++; //2
                    lblWarnQ1.setText("");
                }

            } catch (Exception e) {
                lblWarnQ1.setText("Nhập kiểu số");
            }
        }

        if (txtQ2.getText().equals("")) {
            lblWarnQ2.setText("Nhập điểm");
        } else {
            try {
                q2 = Double.parseDouble(txtQ2.getText());
                if (q2 > 10 || q2 < 0) {
                    lblWarnQ2.setText("Điễm 0 - 10");
                } else {
                    check++; //3
                    lblWarnQ2.setText("");
                }
            } catch (Exception e) {
                lblWarnQ2.setText("Nhập kiểu số");
            }
        }

        if (txtQ3.getText().equals("")) {
            lblWarnQ3.setText("Nhập điểm");
        } else {
            try {
                q3 = Double.parseDouble(txtQ3.getText());
                if (q3 > 10 || q3 < 0) {
                    lblWarnQ3.setText("Điễm 0 - 10");
                } else {
                    check++; //4
                    lblWarnQ3.setText("");
                }
            } catch (Exception e) {
                lblWarnQ3.setText("Nhập kiểu số");
            }
        }

        if (txtQ4.getText().equals("")) {
            lblWarnQ4.setText("Nhập điểm");
        } else {
            try {
                q4 = Double.parseDouble(txtQ4.getText());
                if (q4 > 10 || q4 < 0) {
                    lblWarnQ4.setText("Điễm 0 - 10");
                } else {
                    check++; //5
                    lblWarnQ4.setText("");
                }
            } catch (Exception e) {
                lblWarnQ4.setText("Nhập kiểu số");
            }
        }

        if (txtL1.getText().equals("")) {
            lblWarnL1.setText("Nhập điểm");
        } else {
            try {
                l1 = Double.parseDouble(txtL1.getText());
                if (l1 > 10 || l1 < 0) {
                    lblWarnL1.setText("Điễm 0 - 10");
                } else {
                    check++; //6
                    lblWarnL1.setText("");
                }
            } catch (Exception e) {
                lblWarnL1.setText("Nhập kiểu số");
            }
        }

        if (txtL2.getText().equals("")) {
            lblWarnL2.setText("Nhập điểm");
        } else {
            try {
                l2 = Double.parseDouble(txtL2.getText());
                if (l2 > 10 || l2 < 0) {
                    lblWarnL2.setText("Điễm 0 - 10");
                } else {
                    check++; //7
                    lblWarnL2.setText("");
                }
            } catch (Exception e) {
                lblWarnL2.setText("Nhập kiểu số");
            }
        }

        if (txtL3.getText().equals("")) {
            lblWarnL3.setText("Nhập điểm");
        } else {
            try {
                l3 = Double.parseDouble(txtL3.getText());
                if (l3 > 10 || l3 < 0) {
                    lblWarnL3.setText("Điễm 0 - 10");
                } else {
                    check++; //8
                    lblWarnL3.setText("");
                }
            } catch (Exception e) {
                lblWarnL3.setText("Nhập kiểu số");
            }
        }

        if (txtL4.getText().equals("")) {
            lblWarnL4.setText("Nhập điểm");
        } else {
            try {
                l4 = Double.parseDouble(txtL4.getText());
                if (l4 > 10 || l4 < 0) {
                    lblWarnL4.setText("Điễm 0 - 10");
                } else {
                    check++; //9
                    lblWarnL4.setText("");
                }
            } catch (Exception e) {
                lblWarnL4.setText("Nhập kiểu số");
            }
        }

        if (txtAss1.getText().equals("")) {
            lblWarnAss1.setText("Nhập điểm");
        } else {
            try {
                ass1 = Double.parseDouble(txtAss1.getText());
                if (ass1 > 10 || ass1 < 0) {
                    lblWarnAss1.setText("Điễm 0 - 10");
                } else {
                    check++; //10
                    lblWarnAss1.setText("");
                }
            } catch (Exception e) {
                lblWarnAss1.setText("Nhập kiểu số");
            }
        }

        if (txtAss2.getText().equals("")) {
            lblWarnAss2.setText("Nhập điểm");
        } else {
            try {
                ass2 = Double.parseDouble(txtAss2.getText());
                if (ass2 > 10 || ass2 < 0) {
                    lblWarnAss2.setText("Điễm 0 - 10");
                } else {
                    check++; //11
                    lblWarnAss2.setText("");
                }
            } catch (Exception e) {
                lblWarnAss2.setText("Nhập kiểu số");
            }
        }

        if (txtEnd.getText().equals("")) {
            lblWarnEnd.setText("Nhập điểm");
        } else {
            try {
                test = Double.parseDouble(txtEnd.getText());
                if (test > 10 || test < 0) {
                    lblWarnEnd.setText("Điễm 0 - 10");
                } else {
                    check++; //12
                    lblWarnEnd.setText("");
                }
            } catch (Exception e) {
                lblWarnEnd.setText("Nhập kiểu số");
            }
        }
        int indexSelect = comboSubject.getSelectedIndex();
        if (indexSelect == 0) {
            lblWarnSubject.setText("Chọn môn học");
        } else {
            lblWarnSubject.setText("");
            check++; //13
        }

        if (check == 13) {
            String idSub = "", idStd = txtID.getText();;
            if (indexSelect == 1) {
                idSub = "NET1111";
            }
            if (indexSelect == 2) {
                idSub = "JAV2222";
            }
            if (indexSelect == 3) {
                idSub = "WEB3034";
            }

            DatabaseConnect.createConnection();
            int rowAffect = DatabaseConnect.updateTranscript(idStd, idSub, l1, l2, l3, l4, q1, q2, q3, q4, ass1, ass2, test);

            if (rowAffect == 1) {
                int rowIndex = tableTranscript.getSelectedRow();
                Transcript trs = new Transcript(idStd, idSub, l1, l2, l3, l4, q1, q2, q3, q4, ass1, ass2, test);
                if (indexSelect == 1) {
                    networkModelList.modifyDataModel(rowIndex, trs);
                }
                if (indexSelect == 2) {
                    javaModelList.modifyDataModel(rowIndex, trs);
                }
                if (indexSelect == 3) {
                    webModelList.modifyDataModel(rowIndex, trs);
                }

            }
        }

    }//GEN-LAST:event_btnUpdateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSubmit;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> comboSort;
    private javax.swing.JComboBox<String> comboSubject;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel jpaane;
    private javax.swing.JLabel lblWarnAss1;
    private javax.swing.JLabel lblWarnAss2;
    private javax.swing.JLabel lblWarnEnd;
    private javax.swing.JLabel lblWarnID;
    private javax.swing.JLabel lblWarnL1;
    private javax.swing.JLabel lblWarnL2;
    private javax.swing.JLabel lblWarnL3;
    private javax.swing.JLabel lblWarnL4;
    private javax.swing.JLabel lblWarnQ1;
    private javax.swing.JLabel lblWarnQ2;
    private javax.swing.JLabel lblWarnQ3;
    private javax.swing.JLabel lblWarnQ4;
    private javax.swing.JLabel lblWarnSubject;
    private javax.swing.JTable tableStudentList;
    private javax.swing.JTable tableTranscript;
    private javax.swing.JTextField txtAss1;
    private javax.swing.JTextField txtAss2;
    private javax.swing.JTextField txtEnd;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtL1;
    private javax.swing.JTextField txtL2;
    private javax.swing.JTextField txtL3;
    private javax.swing.JTextField txtL4;
    private javax.swing.JTextField txtQ1;
    private javax.swing.JTextField txtQ2;
    private javax.swing.JTextField txtQ3;
    private javax.swing.JTextField txtQ4;
    // End of variables declaration//GEN-END:variables
}
