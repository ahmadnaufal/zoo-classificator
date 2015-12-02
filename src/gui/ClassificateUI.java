/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.File;
import java.util.ArrayList;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;

/**
 *
 * @author Ahmad Naufal Farhan
 */
public class ClassificateUI extends javax.swing.JFrame {

    File file;
    ArrayList<JCheckBox> checkBox;
    /**
     * Creates new form ClassificateUI
     */
    public ClassificateUI() {
        initComponents();
        checkBox.add(properties1);
        checkBox.add(properties2);
        checkBox.add(properties3);
        checkBox.add(properties4);
        checkBox.add(properties5);
        checkBox.add(properties6);
        checkBox.add(properties7);
        checkBox.add(properties8);
        checkBox.add(properties9);
        checkBox.add(properties10);
        checkBox.add(properties11);
        checkBox.add(properties12);
        checkBox.add(properties14);
        checkBox.add(properties15);
        checkBox.add(properties16);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dataFileChooser = new javax.swing.JFileChooser();
        textFilePath = new javax.swing.JTextField();
        buttonBrowse = new javax.swing.JButton();
        buttonSubmit = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        properties1 = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        properties2 = new javax.swing.JCheckBox();
        properties3 = new javax.swing.JCheckBox();
        properties4 = new javax.swing.JCheckBox();
        properties5 = new javax.swing.JCheckBox();
        properties6 = new javax.swing.JCheckBox();
        properties7 = new javax.swing.JCheckBox();
        properties8 = new javax.swing.JCheckBox();
        properties9 = new javax.swing.JCheckBox();
        properties10 = new javax.swing.JCheckBox();
        properties11 = new javax.swing.JCheckBox();
        properties12 = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        properties14 = new javax.swing.JCheckBox();
        properties15 = new javax.swing.JCheckBox();
        properties16 = new javax.swing.JCheckBox();
        comboProperties13 = new javax.swing.JComboBox<>();
        labelResult = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        textFilePath.setEditable(false);
        textFilePath.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        textFilePath.setText("Select the zoo.data.arff file path...");
        textFilePath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFilePathActionPerformed(evt);
            }
        });

        buttonBrowse.setText("Browse..");
        buttonBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBrowseActionPerformed(evt);
            }
        });

        buttonSubmit.setText("Classify!");
        buttonSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSubmitActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Your animal name!");

        properties1.setText("Hairy");

        jLabel2.setText("Animal Properties");

        properties2.setText("Feathers");

        properties3.setText("Lays Eggs");

        properties4.setText("Has Milk");

        properties5.setText("It flies!");

        properties6.setText("It swims!");

        properties7.setText("Predator");

        properties8.setText("Has Teeth");

        properties9.setText("Vertebrae");

        properties10.setText("Breathes");

        properties11.setText("Venomous");

        properties12.setText("Fins");

        jLabel3.setText("How many Legs?");

        properties14.setText("Has Tail");

        properties15.setText("Domestic");

        properties16.setText("Catsize?");

        comboProperties13.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "2", "4", "5", "6", "8" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(properties1)
                            .addComponent(properties2)
                            .addComponent(properties3)
                            .addComponent(properties14))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(properties15)
                                .addGap(18, 18, 18)
                                .addComponent(properties16))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(properties4)
                                    .addComponent(properties5)
                                    .addComponent(properties6))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(properties7)
                                    .addComponent(properties8)
                                    .addComponent(properties9))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(properties12)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(properties10)
                                            .addComponent(properties11))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(comboProperties13, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(properties1)
                    .addComponent(properties4)
                    .addComponent(properties7)
                    .addComponent(properties10)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(properties2)
                    .addComponent(properties5)
                    .addComponent(properties8)
                    .addComponent(properties11)
                    .addComponent(comboProperties13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(properties3)
                    .addComponent(properties6)
                    .addComponent(properties9)
                    .addComponent(properties12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(properties14)
                    .addComponent(properties15)
                    .addComponent(properties16))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        labelResult.setFont(new java.awt.Font("Lato", 0, 24)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(textFilePath, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonBrowse)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonSubmit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelResult, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(174, 174, 174))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonBrowse)
                    .addComponent(buttonSubmit)
                    .addComponent(textFilePath, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelResult, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textFilePathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFilePathActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFilePathActionPerformed

    private void buttonBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBrowseActionPerformed
        // TODO add your handling code here:
        int ret = dataFileChooser.showOpenDialog(this);

        if (ret == JFileChooser.APPROVE_OPTION) {
            file = dataFileChooser.getSelectedFile();
            // What to do with the file, e.g. display it in a TextArea
            textFilePath.setText(file.getAbsolutePath());
        } else {
            System.out.println("File access cancelled by user.");
        }
    }//GEN-LAST:event_buttonBrowseActionPerformed

    private void buttonSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSubmitActionPerformed
        
    }//GEN-LAST:event_buttonSubmitActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClassificateUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClassificateUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClassificateUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClassificateUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClassificateUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonBrowse;
    private javax.swing.JButton buttonSubmit;
    private javax.swing.JComboBox<String> comboProperties13;
    private javax.swing.JFileChooser dataFileChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel labelResult;
    private javax.swing.JCheckBox properties1;
    private javax.swing.JCheckBox properties10;
    private javax.swing.JCheckBox properties11;
    private javax.swing.JCheckBox properties12;
    private javax.swing.JCheckBox properties14;
    private javax.swing.JCheckBox properties15;
    private javax.swing.JCheckBox properties16;
    private javax.swing.JCheckBox properties2;
    private javax.swing.JCheckBox properties3;
    private javax.swing.JCheckBox properties4;
    private javax.swing.JCheckBox properties5;
    private javax.swing.JCheckBox properties6;
    private javax.swing.JCheckBox properties7;
    private javax.swing.JCheckBox properties8;
    private javax.swing.JCheckBox properties9;
    private javax.swing.JTextField textFilePath;
    // End of variables declaration//GEN-END:variables
}
