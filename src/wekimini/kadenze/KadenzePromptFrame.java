/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wekimini.kadenze;

import java.io.File;
import java.io.IOException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import wekimini.GlobalSettings;
import wekimini.WekiMiniRunner;
import wekimini.kadenze.KadenzeAssignment.KadenzeAssignmentType;
import wekimini.util.Util;

/**
 *
 * @author rebecca
 */
public class KadenzePromptFrame extends javax.swing.JFrame {

    private String currentSaveLocation = null; //used for guiding pop-up location

    private final String[] comboOptions
            = {"No, just exploring or playing",
                "Assignment 1, Part 1",
                "Assignment 2, Part 1A",
                "Assignment 2, Part 1B",
                "Assignment 2, Part 1C",
                "Assignment 2, Part 1D",
                "Assignment 2, Part 2",
                "Assignment 2, Part 3A",
                "Assignment 2, Part 3B",
                "Assignment 5, Part 1A",
                "Assignment 5, Part 1B",
                "Assignment 5, Part 1C",
                "Assignment 5, Part 2",
                "Assignment 5, Part 3A",
                "Assignment 5, Part 3B"
            };

    private final KadenzeAssignmentType[] assignmentTypes
            = {KadenzeAssignmentType.NONE,
                KadenzeAssignmentType.ASSIGNMENT1,
                KadenzeAssignmentType.ASSIGNMENT2_PART1A,
                KadenzeAssignmentType.ASSIGNMENT2_PART1B,
                KadenzeAssignmentType.ASSIGNMENT2_PART1C,
                KadenzeAssignmentType.ASSIGNMENT2_PART1D,
                KadenzeAssignmentType.ASSIGNMENT2_PART2,
                KadenzeAssignmentType.ASSIGNMENT2_PART3A,
                KadenzeAssignmentType.ASSIGNMENT2_PART3B,
                KadenzeAssignmentType.ASSIGNMENT5_PART1A,
                KadenzeAssignmentType.ASSIGNMENT5_PART1B,
                KadenzeAssignmentType.ASSIGNMENT5_PART1C,
                KadenzeAssignmentType.ASSIGNMENT5_PART2,
                KadenzeAssignmentType.ASSIGNMENT5_PART3A,
                KadenzeAssignmentType.ASSIGNMENT5_PART3B
            };

    /**
     * Creates new form KadenzePromptFrame
     */
    public KadenzePromptFrame() {
        initComponents();
        GlobalSettings s = GlobalSettings.getInstance();
        if (s.hasKadenzeSaveLocation()) {
            currentSaveLocation = s.getKadenzeSaveLocation();
            labelDirectory.setText(s.getKadenzeSaveLocation());
        } else {
            currentSaveLocation = System.getProperty("user.home");
            labelDirectory.setText(System.getProperty("user.home") + File.separator + "kadenze");
        }
        populateComboBox();
    }

    private void populateComboBox() {
        comboAssignment.setModel(new DefaultComboBoxModel(comboOptions));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        comboAssignment = new javax.swing.JComboBox();
        labelSaving = new javax.swing.JLabel();
        labelDirectory = new javax.swing.JLabel();
        buttonChangeDirectory = new javax.swing.JButton();
        buttonDone = new javax.swing.JButton();
        labelVersion = new javax.swing.JLabel();
        labelVersion1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Are you working on a Kadenze assignment?");

        comboAssignment.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No, just exploring or playing", "Yes: Assignment 1", "Yes: Assignment 2, Part 1", "Yes: Assignment 2, Part 2" }));
        comboAssignment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboAssignmentActionPerformed(evt);
            }
        });

        labelSaving.setText("Saving to assignments directory:");

        labelDirectory.setText("None set yet");
        labelDirectory.setEnabled(false);

        buttonChangeDirectory.setText("Change directory");
        buttonChangeDirectory.setEnabled(false);
        buttonChangeDirectory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonChangeDirectoryActionPerformed(evt);
            }
        });

        buttonDone.setText("Done");
        buttonDone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDoneActionPerformed(evt);
            }
        });

        labelVersion.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        labelVersion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelVersion.setText("Welcome to the Kadenze version of Wekinator!");

        labelVersion1.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        labelVersion1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelVersion1.setText("Last updated 2 February 2016");

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 2, 13)); // NOI18N
        jLabel2.setText("<html>This will be the parent directory for all Kadenze assignments. We recommend leaving this unchanged.</html>");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelVersion, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
                    .addComponent(labelVersion1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(labelDirectory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(comboAssignment, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelSaving))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(buttonChangeDirectory)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonDone)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelVersion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelVersion1)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboAssignment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelSaving)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelDirectory)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonChangeDirectory)
                    .addComponent(buttonDone))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboAssignmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboAssignmentActionPerformed
        int index = comboAssignment.getSelectedIndex();
        labelDirectory.setEnabled(index != 0);
        buttonChangeDirectory.setEnabled(index != 0);
    }//GEN-LAST:event_comboAssignmentActionPerformed

    private void buttonChangeDirectoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonChangeDirectoryActionPerformed
        /*String dir = System.getProperty("user.home");
         GlobalSettings s = GlobalSettings.getInstance();
         if (s.hasKadenzeSaveLocation()) {
         String loc = s.getKadenzeSaveLocation();
            
         } */

        JFileChooser fc = new JFileChooser(currentSaveLocation) {

        };
        fc.setDialogType(JFileChooser.SAVE_DIALOG);
        fc.setApproveButtonText("Choose directory");
        fc.setDialogTitle("Choose directory for Kadenze assignments");
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int returnVal = fc.showSaveDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File chosenFile;
            File f = fc.getSelectedFile();
            if (f.isDirectory()) {
                // System.out.println("Choosing directory: " + f.getAbsolutePath());
                chosenFile = f;
            } else {
                chosenFile = f.getParentFile();
                // System.out.println("Choosing parent dir: " + f2.getAbsolutePath());
            }
            try {
                labelDirectory.setText(chosenFile.getCanonicalPath());
                currentSaveLocation = chosenFile.getCanonicalPath();
            } catch (IOException ex) {
                //Rare event that can't resolve canonical path name
                labelDirectory.setText(chosenFile.getAbsolutePath());
                currentSaveLocation = chosenFile.getAbsolutePath();
            }
        }
    }//GEN-LAST:event_buttonChangeDirectoryActionPerformed

    private void buttonDoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDoneActionPerformed
        File f = new File(labelDirectory.getText());
        //File f = new File(currentSaveLocation);
        if (!f.exists()) {
            try {
                // System.out.println("Creating directories: " + f.getAbsolutePath());
                f.mkdirs();
            } catch (Exception ex) {
                //COuld not create file!
                Util.showPrettyErrorPane(this, "Could not create directory " + currentSaveLocation + ". Please choose a different location.");
                return;
            }
        }
        GlobalSettings s = GlobalSettings.getInstance();
        try {
            s.setKadenzeSaveLocation(f.getCanonicalPath());
        } catch (IOException ex) {
            s.setKadenzeSaveLocation(f.getAbsolutePath());
        }
        if (comboAssignment.getSelectedIndex() != 0) {
            KadenzeAssignmentType type = assignmentTypes[comboAssignment.getSelectedIndex()];
            try {
                KadenzeLogging.startLoggingForAssignment(type);
                WekiMiniRunner.getInstance().runNewProject();
                this.dispose();
            } catch (IOException ex) {
                ex.printStackTrace(); //TODO remove
                Util.showPrettyErrorPane(this, "Could not begin Kadenze logging! "
                        + " Please ensure that the directory at " + f.getAbsolutePath()
                        + " and its subdirectories are writeable, or choose a different "
                        + " write location, otherwise your Kadenze assignments will not be gradeable.");
            }
        } else {
            KadenzeLogging.noLogging();
            WekiMiniRunner.getInstance().runNewProject();
            this.dispose();
        }
    }//GEN-LAST:event_buttonDoneActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KadenzePromptFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonChangeDirectory;
    private javax.swing.JButton buttonDone;
    private javax.swing.JComboBox comboAssignment;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelDirectory;
    private javax.swing.JLabel labelSaving;
    private javax.swing.JLabel labelVersion;
    private javax.swing.JLabel labelVersion1;
    // End of variables declaration//GEN-END:variables
}
