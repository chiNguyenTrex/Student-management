/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teacher;

import connection.DataModelStudentList;
import connection.DatabaseConnect;
import entity.Student;
import entity.StudentList;
import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author ChiNguyen
 */
public class AddingStudent extends javax.swing.JPanel {

    DataModelStudentList dataModel;
    Font myFont, yourFont;
    Color myColor;
    String fileName = "";
    JFileChooser chooseImage;
    BufferedImage bf;
    ImageIcon imageIcon;
    ListSelectionModel lSM;
    ListSelectionListener lSL;

    /**
     * Creates new form AddingStudent
     */
    public AddingStudent() {
        initComponents();
        myFont = new Font("Tahoma", Font.PLAIN, 14);
        yourFont = new Font("Tahoma", Font.ITALIC, 14);
        myColor = new Color(102, 102, 102);

        StudentList.setSTUDENT_LIST(); // Khởi tạo ArrayList cho biến STUDENT_LIST
        DatabaseConnect.createConnection(); // Khởi tạo một connection đến Database
        DatabaseConnect.getStudentFromDatabase(); // Lấy dữ liệu từ database cho vào STUDENT_LIST
        StudentList.setColumnHead();

        // Tạo Data Model cho bảng rồi tạo bảng từ đó
        dataModel = new DataModelStudentList(StudentList.getSTUDENT_LIST(), StudentList.getColumnHead());
        tableAddStudent.setModel(dataModel);

        // Thiết lập kiểu chọn trên bảng : chỉ chọn được một hàng
        tableAddStudent.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // bắt sự kiện chọn trên bảng
        lSM = tableAddStudent.getSelectionModel();
        
        lSM.addListSelectionListener(lSL = new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                //Ignore extra messages.
                if (e.getValueIsAdjusting()) {
                    return;
                }

                lblImage.setText("");

                ListSelectionModel lsm = (ListSelectionModel) e.getSource();
                int rowInd = lsm.getMinSelectionIndex();

                txtId.setText(tableAddStudent.getValueAt(rowInd, 0).toString());
                txtName.setText(tableAddStudent.getValueAt(rowInd, 1).toString());
                txtBirth.setText(tableAddStudent.getValueAt(rowInd, 2).toString());
                txtPhone.setText(tableAddStudent.getValueAt(rowInd, 4).toString());
                txtMail.setText(tableAddStudent.getValueAt(rowInd, 5).toString());
                txtAddress.setText(tableAddStudent.getValueAt(rowInd, 6).toString());
                System.out.println(fileName);
                try {
                    bf = ImageIO.read(new File("imagestudents/" + dataModel.getImageStudentAt(rowInd)));
                    imageIcon = new ImageIcon(bf.getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), 0));
                    lblImage.setIcon(imageIcon);
                } catch (IOException ex) {
                    Logger.getLogger(AddingStudent.class.getName()).log(Level.SEVERE, null, ex);
                }

                String sexN = (String) tableAddStudent.getValueAt(rowInd, 3);
                if (sexN.equals("Nam")) {
                    radioMale.setSelected(true);
                } else {
                    radioFemale.setSelected(true);
                }

//                radioFemale.setEnabled(false);
//                radioMale.setEnabled(false);
                txtAddress.setFont(myFont);
                txtAddress.setForeground(Color.BLACK);
//                txtAddress.setEnabled(false);

                txtBirth.setFont(myFont);
                txtBirth.setForeground(Color.BLACK);
//                txtBirth.setEnabled(false);

                txtId.setFont(myFont);
                txtId.setForeground(Color.BLACK);
//                txtId.setEnabled(false);

                txtMail.setFont(myFont);
                txtMail.setForeground(Color.BLACK);
//                txtMail.setEnabled(false);

                txtName.setFont(myFont);
                txtName.setForeground(Color.BLACK);
//                txtName.setEnabled(false);

                txtPhone.setFont(myFont);
                txtPhone.setForeground(Color.BLACK);
//                txtPhone.setEnabled(false);

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

        buttonGroupSex = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lblImage = new javax.swing.JLabel();
        btnChooseImage = new javax.swing.JButton();
        jPanel19 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lblIdWarn = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        txtId = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lblNameWarn = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        lblSexWarn = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        lblEmailWarn = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        txtName = new javax.swing.JTextField();
        jPanel17 = new javax.swing.JPanel();
        radioMale = new javax.swing.JRadioButton();
        radioFemale = new javax.swing.JRadioButton();
        jPanel18 = new javax.swing.JPanel();
        txtMail = new javax.swing.JTextField();
        jPanel20 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        lblBirthWarn = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        lblPhoneWarn = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        lblAddressWarn = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        txtBirth = new javax.swing.JTextField();
        jPanel24 = new javax.swing.JPanel();
        txtPhone = new javax.swing.JTextField();
        jPanel25 = new javax.swing.JPanel();
        txtAddress = new javax.swing.JTextField();
        jPanel26 = new javax.swing.JPanel();
        jPanel27 = new javax.swing.JPanel();
        jPanel28 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableAddStudent = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(1066, 567));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(153, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(769, 300));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(200, 250));

        lblImage.setBackground(new java.awt.Color(153, 255, 255));
        lblImage.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblImage.setPreferredSize(new java.awt.Dimension(150, 200));

        btnChooseImage.setText("Browser");
        btnChooseImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseImageActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(btnChooseImage)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(75, Short.MAX_VALUE)
                .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnChooseImage)
                .addGap(8, 8, 8))
        );

        jPanel1.add(jPanel3, java.awt.BorderLayout.LINE_START);

        jPanel19.setLayout(new java.awt.GridLayout(8, 3));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 288, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 37, Short.MAX_VALUE)
        );

        jPanel19.add(jPanel4);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 288, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 37, Short.MAX_VALUE)
        );

        jPanel19.add(jPanel5);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 288, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 37, Short.MAX_VALUE)
        );

        jPanel19.add(jPanel6);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Student ID");

        lblIdWarn.setForeground(new java.awt.Color(255, 51, 51));
        lblIdWarn.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(28, 28, 28)
                .addComponent(lblIdWarn, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(lblIdWarn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(3, 3, 3))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel3)))
                .addContainerGap())
        );

        jPanel19.add(jPanel7);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 288, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 37, Short.MAX_VALUE)
        );

        jPanel19.add(jPanel8);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 288, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 37, Short.MAX_VALUE)
        );

        jPanel19.add(jPanel9);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        txtId.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        txtId.setForeground(new java.awt.Color(102, 102, 102));
        txtId.setText("Your ID");
        txtId.setPreferredSize(new java.awt.Dimension(200, 23));
        txtId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtIdFocusGained(evt);
            }
        });
        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtId, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
        );

        jPanel19.add(jPanel10);

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 288, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 37, Short.MAX_VALUE)
        );

        jPanel19.add(jPanel11);

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));

        btnAdd.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel19.add(jPanel12);

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Full name");

        lblNameWarn.setForeground(new java.awt.Color(255, 51, 51));
        lblNameWarn.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(39, 39, 39)
                .addComponent(lblNameWarn, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNameWarn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        jPanel19.add(jPanel13);

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Gender");

        lblSexWarn.setForeground(new java.awt.Color(255, 51, 51));
        lblSexWarn.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(lblSexWarn, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lblSexWarn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel19.add(jPanel14);

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Email");

        lblEmailWarn.setForeground(new java.awt.Color(255, 51, 51));
        lblEmailWarn.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addComponent(lblEmailWarn, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(lblEmailWarn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel19.add(jPanel15);

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));

        txtName.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        txtName.setForeground(new java.awt.Color(102, 102, 102));
        txtName.setText("Your full name");
        txtName.setPreferredSize(new java.awt.Dimension(200, 23));
        txtName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNameFocusGained(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
        );

        jPanel19.add(jPanel16);

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));

        radioMale.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroupSex.add(radioMale);
        radioMale.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        radioMale.setText("Nam");

        radioFemale.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroupSex.add(radioFemale);
        radioFemale.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        radioFemale.setText("Nữ");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(radioMale)
                .addGap(18, 18, 18)
                .addComponent(radioFemale)
                .addContainerGap(158, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(radioFemale))
                    .addComponent(radioMale, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel19.add(jPanel17);

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));

        txtMail.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        txtMail.setForeground(new java.awt.Color(102, 102, 102));
        txtMail.setText("yourmail@gmail.com");
        txtMail.setPreferredSize(new java.awt.Dimension(200, 23));
        txtMail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtMailFocusGained(evt);
            }
        });
        txtMail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMailActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtMail, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtMail, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
        );

        jPanel19.add(jPanel18);

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Date of birth");

        lblBirthWarn.setForeground(new java.awt.Color(255, 51, 51));
        lblBirthWarn.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(lblBirthWarn, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblBirthWarn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel19.add(jPanel20);

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Phone");

        lblPhoneWarn.setForeground(new java.awt.Color(255, 51, 51));
        lblPhoneWarn.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(lblPhoneWarn, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                .addGap(41, 41, 41))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lblPhoneWarn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel19.add(jPanel21);

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Address");

        lblAddressWarn.setForeground(new java.awt.Color(255, 51, 51));
        lblAddressWarn.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(lblAddressWarn, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(lblAddressWarn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel19.add(jPanel22);

        jPanel23.setBackground(new java.awt.Color(255, 255, 255));

        txtBirth.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        txtBirth.setForeground(new java.awt.Color(102, 102, 102));
        txtBirth.setText("yyyy-mm-dd");
        txtBirth.setPreferredSize(new java.awt.Dimension(200, 23));
        txtBirth.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtBirthFocusGained(evt);
            }
        });

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtBirth, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtBirth, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
        );

        jPanel19.add(jPanel23);

        jPanel24.setBackground(new java.awt.Color(255, 255, 255));

        txtPhone.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        txtPhone.setForeground(new java.awt.Color(102, 102, 102));
        txtPhone.setText("Your phone number");
        txtPhone.setPreferredSize(new java.awt.Dimension(200, 23));
        txtPhone.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPhoneFocusGained(evt);
            }
        });
        txtPhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPhoneActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtPhone, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
        );

        jPanel19.add(jPanel24);

        jPanel25.setBackground(new java.awt.Color(255, 255, 255));

        txtAddress.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        txtAddress.setForeground(new java.awt.Color(102, 102, 102));
        txtAddress.setText("Your address");
        txtAddress.setPreferredSize(new java.awt.Dimension(200, 23));
        txtAddress.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtAddressFocusGained(evt);
            }
        });

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtAddress, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
        );

        jPanel19.add(jPanel25);

        jPanel26.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 288, Short.MAX_VALUE)
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 37, Short.MAX_VALUE)
        );

        jPanel19.add(jPanel26);

        jPanel27.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 288, Short.MAX_VALUE)
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 37, Short.MAX_VALUE)
        );

        jPanel19.add(jPanel27);

        jPanel28.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 288, Short.MAX_VALUE)
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 37, Short.MAX_VALUE)
        );

        jPanel19.add(jPanel28);

        jPanel1.add(jPanel19, java.awt.BorderLayout.CENTER);

        add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setPreferredSize(new java.awt.Dimension(452, 267));
        jPanel2.setLayout(new java.awt.GridLayout(1, 1));

        jScrollPane2.setPreferredSize(new java.awt.Dimension(452, 260));
        jScrollPane2.setViewportView(tableAddStudent);

        jPanel2.add(jScrollPane2);

        add(jPanel2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
       lSM.removeListSelectionListener(lSL);
        
        int check = 0;
        // Kiễm tra ID
        if (txtId.getText().equals("") || txtId.getText().equals("Your ID")) {
            lblIdWarn.setText("Bạn chưa nhập ID");
        } else {
            
            // Kiễm tra xem ID SV đã tồn tại chưa
            try {
                DatabaseConnect.createConnection();
                boolean isDublicate = DatabaseConnect.checkIdStudent(txtId.getText());
                DatabaseConnect.closeConnect();

                if (isDublicate) {
                    lblIdWarn.setText("");
                    check++; // 1
                } else {
                    lblIdWarn.setText("ID đã bị trùng");
                }
            } catch (SQLException ex) {
                Logger.getLogger(AddingStudent.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        // Kiễm tra name
        if (txtName.getText().equals("Your full name") || txtName.getText().equals("")) {
            lblNameWarn.setText("Bạn chưa nhập tên");
        } else {
            lblNameWarn.setText("");
            check++; // 2
        }

        // Kiễm tra ngày sinh
        if (txtBirth.getText().equals("yyyy-mm-dd") || txtBirth.getText().equals("")) {
            lblBirthWarn.setText("Bạn chưa nhập ngày sinh");
        } else {
            lblBirthWarn.setText("");
            check++; //3
        }

        // Kiễm tra sex
        if (buttonGroupSex.getSelection() == null) {
            lblSexWarn.setText("Bạn chưa chọn giới tính");
        } else {
            lblSexWarn.setText("");
            check++; //4
        }

        // Kiễm tra sdt
        if (txtPhone.getText().equals("Your phone number") || txtPhone.getText().equals("")) {
            lblPhoneWarn.setText("Bạn chưa nhập số phone");
        } else {

            try {
                Integer.parseInt(txtPhone.getText());
                lblPhoneWarn.setText("");
                check++; //5
            } catch (Exception e) {
                lblPhoneWarn.setText("Số điện thoại không hợp lệ");
            }

        }

        // Kiễm tra mail
        if (txtMail.getText().equals("yourmail@gmail.com") || txtMail.getText().equals("")) {
            lblEmailWarn.setText("Bạn chưa nhập emal");
        } else {
            lblEmailWarn.setText("");
            check++; //6
        }

        // Kiễm tra address
        if (txtAddress.getText().equals("Your address") || txtAddress.getText().equals("")) {
            lblAddressWarn.setText("Bạn chưa nhập địa chỉ");
        } else {
            lblAddressWarn.setText("");
            check++; //7
        }

        if (lblImage.getIcon() == null) {
            lblImage.setText("Chưa chọn ảnh");
            lblImage.setForeground(Color.RED);
        } else {
            lblImage.setText("");
            check++; //8
        }

        if (check == 8) {
            String idS = txtId.getText();
            String nameS = txtName.getText();
            String sex = radioFemale.isSelected() ? "Nữ" : "Nam";
            String birth = txtBirth.getText();
            String phone = txtPhone.getText();
            String mail = txtMail.getText();
            String address = txtAddress.getText();
            DatabaseConnect.createConnection();
            int insertSuccessOrNot = DatabaseConnect.insertStudentIntoDatabase(idS, nameS, birth, sex, phone, mail, address, fileName);
            /*
            // Cập nhật lại bang

            StudentList.setSTUDENT_LIST(); // Khởi tạo ArrayList cho biến STUDENT_LIST
            DatabaseConnect.createConnection(); // Khởi tạo một connection đến Database
            DatabaseConnect.getStudentFromDatabase(); // Lấy dữ liệu từ database cho vào STUDENT_LIST
            StudentList.setColumnHead();        
            dataModel = new DataModelStudentList(StudentList.getSTUDENT_LIST() , StudentList.getColumnHead());
            tableAddStudent.setModel(dataModel);
            Đây là một cách cập nhật dữ liệu trong bảng sau khi dữ liệu thay đổi, nhưng cách này tốn tài nguyên vì phải mất time 
            load data lên từ database
             */

            //Cách tối ưu: cập nhật lại datamodel
            if (insertSuccessOrNot == 1) { // Chèn vào database thành công mới chèn vào DataModel
                Student student = new Student(idS, nameS, birth, sex, phone, mail, address, fileName);
                dataModel.addData(student);

                txtAddress.setText("Your address");
                txtAddress.setFont(yourFont);
                txtAddress.setForeground(myColor);

                txtBirth.setText("yyyy-mm-dd");
                txtBirth.setFont(yourFont);
                txtBirth.setForeground(myColor);

                txtId.setText("Your ID");
                txtId.setFont(yourFont);
                txtId.setForeground(myColor);

                txtMail.setText("yourmail@gmail.com");
                txtMail.setFont(yourFont);
                txtMail.setForeground(myColor);

                txtName.setText("Your full name");
                txtName.setFont(yourFont);
                txtName.setForeground(myColor);

                txtPhone.setText("Your phone number");
                txtPhone.setFont(yourFont);
                txtPhone.setForeground(myColor);

                buttonGroupSex.clearSelection();

                lblImage.setIcon(null);
            } else {
                JOptionPane.showMessageDialog(null, "Nhập không thành công");
            }
        }
        lSM.addListSelectionListener(lSL);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
   
        lSM.removeListSelectionListener(lSL);
        if (tableAddStudent.getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Bạn phải chọn một dòng trên table.");
        } else {
            int index = tableAddStudent.getSelectedRow();
            String idStudent = (String) dataModel.getValueAt(index, 0);
            // Xoa trong Database
            DatabaseConnect.createConnection();
            DatabaseConnect.deleteStudentByID(idStudent);
            // Xoa trong DataModel

            txtAddress.setText("Your address");
            txtAddress.setFont(yourFont);
            txtAddress.setForeground(myColor);

            txtBirth.setText("yyyy-mm-dd");
            txtBirth.setFont(yourFont);
            txtBirth.setForeground(myColor);

            txtId.setText("Your ID");
            txtId.setFont(yourFont);
            txtId.setForeground(myColor);

            txtMail.setText("yourmail@gmail.com");
            txtMail.setFont(yourFont);
            txtMail.setForeground(myColor);

            txtName.setText("Your full name");
            txtName.setFont(yourFont);
            txtName.setForeground(myColor);

            txtPhone.setText("Your phone number");
            txtPhone.setFont(yourFont);
            txtPhone.setForeground(myColor);

            buttonGroupSex.clearSelection();

            lblImage.setIcon(null);

            dataModel.removeRow(index);

        }
        
        
        lSM.addListSelectionListener(lSL);


    }//GEN-LAST:event_btnDeleteActionPerformed

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed

    }//GEN-LAST:event_txtIdActionPerformed

    private void txtBirthFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBirthFocusGained
  
        txtBirth.setText("");
        txtBirth.setForeground(Color.BLACK);
        txtBirth.setFont(myFont);
    }//GEN-LAST:event_txtBirthFocusGained

    private void txtNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNameFocusGained
        // TODO add your handling code here:
        txtName.setText("");
        txtName.setForeground(Color.BLACK);
        txtName.setFont(myFont);
    }//GEN-LAST:event_txtNameFocusGained

    private void txtPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhoneActionPerformed
     

    }//GEN-LAST:event_txtPhoneActionPerformed

    private void txtMailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMailActionPerformed

    private void txtMailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMailFocusGained
      
        txtMail.setText("");
        txtMail.setForeground(Color.BLACK);
        txtMail.setFont(myFont);
    }//GEN-LAST:event_txtMailFocusGained

    private void txtAddressFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAddressFocusGained
     
        txtAddress.setText("");
        txtAddress.setForeground(Color.BLACK);
        txtAddress.setFont(myFont);
    }//GEN-LAST:event_txtAddressFocusGained

    private void txtPhoneFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPhoneFocusGained
        
        txtPhone.setText("");
        txtPhone.setForeground(Color.BLACK);
        txtPhone.setFont(myFont);

    }//GEN-LAST:event_txtPhoneFocusGained

    private void txtIdFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIdFocusGained
        // TODO add your handling code here:
        txtId.setText("");
        txtId.setForeground(Color.BLACK);
        txtId.setFont(myFont);
    }//GEN-LAST:event_txtIdFocusGained

    private void btnChooseImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseImageActionPerformed
        lblImage.setText("");
        chooseImage = new JFileChooser("D:\\Java Development\\Student App");
        int select = chooseImage.showOpenDialog(this);

        if (select == JFileChooser.APPROVE_OPTION) {
            try {
                fileName = chooseImage.getSelectedFile().getName();

                bf = ImageIO.read(new File("imagestudents/" + fileName));
                imageIcon = new ImageIcon(bf.getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), 0));
                lblImage.setIcon(imageIcon);
            } catch (IOException ex) {
                Logger.getLogger(AddingStudent.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnChooseImageActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnChooseImage;
    private javax.swing.JButton btnDelete;
    private javax.swing.ButtonGroup buttonGroupSex;
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
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAddressWarn;
    private javax.swing.JLabel lblBirthWarn;
    private javax.swing.JLabel lblEmailWarn;
    private javax.swing.JLabel lblIdWarn;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblNameWarn;
    private javax.swing.JLabel lblPhoneWarn;
    private javax.swing.JLabel lblSexWarn;
    private javax.swing.JRadioButton radioFemale;
    private javax.swing.JRadioButton radioMale;
    private javax.swing.JTable tableAddStudent;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtBirth;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtMail;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhone;
    // End of variables declaration//GEN-END:variables
}
