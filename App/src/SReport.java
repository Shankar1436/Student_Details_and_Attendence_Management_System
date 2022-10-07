


import java.sql.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

@SuppressWarnings("unused")
public class SReport extends javax.swing.JFrame {

    
	private static final long serialVersionUID = 3502024109032056383L;
	public SReport(String k) {
        initComponents(k);
    }

	
    private void initComponents(String sub) {
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Student Details");

        jTable2.setAutoCreateRowSorter(true);
        
        jScrollPane2.setViewportView(jTable2);
                                        
        
        String filePath = "select * from students";
    
        
        try {
        	Class.forName("org.sqlite.JDBC");
        	Connection con=DriverManager.getConnection("jdbc:sqlite:C://sqlite//javaproj");
        	Statement stm=con.createStatement();
        	ResultSet rs=stm.executeQuery(filePath);
            String[] columnsName = {"NAME","SEM","USN","PHONE"};
            DefaultTableModel model = (DefaultTableModel)jTable2.getModel();
            model.setColumnIdentifiers(columnsName);
            
            while(rs.next())
            {
                String line = rs.getString("name").toString().trim();
                String[] dataRow = line.split(",");
                model.addRow(dataRow);
            }
            stm.close();
            con.close();
            
        } catch (Exception ex) {
            
        }
        
        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	Teacher f1 = new Teacher("");
                f1.setVisible(true);
                dispose();
            	
            }});
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(40)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 348, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 401, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap(49, Short.MAX_VALUE))
        		.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
        			.addContainerGap(395, Short.MAX_VALUE)
        			.addComponent(btnBack)
        			.addContainerGap())
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(21)
        			.addComponent(btnBack)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(jLabel1)
        			.addGap(32)
        			.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 310, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(56, Short.MAX_VALUE))
        );
        getContentPane().setLayout(layout);

        pack();
    }

    

    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
}
