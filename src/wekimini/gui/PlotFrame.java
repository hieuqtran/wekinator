/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wekimini.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import weka.core.Instance;
import wekimini.Wekinator;

/**
 *
 * @author louismccallum
 */
public class PlotFrame extends javax.swing.JFrame implements PlotRowDelegate {

    /**
     * Creates new form PlotFrame
     */
    private Wekinator w;
    private Random r = new Random();
    private final int REFRESH_RATE = 20;
    private PlotTableModel tableModel = new PlotTableModel();
    private final static int POINTS_PER_ROW = 100;
    private ArrayList<PlotRowPanel> rows = new ArrayList();

    public PlotFrame() {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    public PlotFrame(Wekinator w) {
        initComponents();
        this.w = w;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE)  ;   
        Timer timer = new Timer(REFRESH_RATE, new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
            Instance in = w.getSupervisedLearningManager().getCurrentInputInstance();
            if(in != null)
            {
                int numPlots = tableModel.getRowCount();
                for(int i = 0; i < numPlots; i++)
                {
                    PlotRowModel model = tableModel.getValueAt(i, 0);
                    if(model.isStreaming)
                    {
                        float val = (float) in.value(model.featureIndex);
                        //System.out.print("adding " + val + " to model " + model.featureIndex);
                        model.addPoint(val);
                    }
                }
            }
        }    
        });  
        timer.start();
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
        addPlotButton = new javax.swing.JButton();
        linkScrollToggle = new javax.swing.JRadioButton();
        plotScrollView = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        addPlotButton.setText("Add Plot");
        addPlotButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPlotButtonActionPerformed(evt);
            }
        });

        linkScrollToggle.setText("Link Scroll");
        linkScrollToggle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                linkScrollToggleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(addPlotButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(linkScrollToggle)
                .addGap(0, 460, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 15, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addPlotButton)
                    .addComponent(linkScrollToggle)))
        );

        plotScrollView.setHorizontalScrollBar(null);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(plotScrollView)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(plotScrollView, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addPlotButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPlotButtonActionPerformed
        // TODO add your handling code here:
        tableModel.data.add(new PlotRowModel());
        redrawTable();
    }//GEN-LAST:event_addPlotButtonActionPerformed

    private void linkScrollToggleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_linkScrollToggleActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_linkScrollToggleActionPerformed

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
            java.util.logging.Logger.getLogger(PlotFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PlotFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PlotFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PlotFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PlotFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addPlotButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton linkScrollToggle;
    private javax.swing.JScrollPane plotScrollView;
    // End of variables declaration//GEN-END:variables

    @Override
    public void streamingToggleChanged(PlotRowModel model)
    {

    }
    
    public boolean areAnyRowsStreaming()
    {
        for(PlotRowModel model : tableModel.data)
        {
            if(model.isStreaming)
            {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public void modelChanged(PlotRowModel model)
    {
        System.out.println("model changed");
        tableModel.data.set(model.rowIndex, model);
        model.points = new LinkedList();
        model.classes = new LinkedList();
        w.getSupervisedLearningManager().isPlotting = areAnyRowsStreaming();
        if(model.isStreaming)
        {
            
        }
        else
        {
            double[][] vals = w.getDataManager().getTrainingDataForFeature(model.outputIndex, model.featureIndex);
            for(int i = 0; i < vals.length; i ++)
            {
                model.points.add(vals[i][0]);
                model.classes.add(vals[i][1]);
            }
            redrawTable();
        }
        updateTable();
    }
    
    @Override
    public void closeButtonPressed(PlotRowModel model)
    {
        tableModel.data.remove(model);
        redrawTable();
    }
    
    public void redrawTable()
    {
        System.out.println("redraw table");
        int ptr = 0;
        int rowHeight = 100;
        String[] outputs = new String[w.getDataManager().getNumOutputs()];
        for(int i = 0; i < outputs.length; i++)
        {
            outputs[i] = w.getDataManager().getOutputName(i);
        }
        String[] features = w.getDataManager().featureManager.getAllFeaturesGroup().valueMap;
        int numRows = tableModel.data.size();
        rows = new ArrayList(numRows);
        JPanel content = new JPanel();
        GridLayout layout = new GridLayout(numRows,1);
        content.setLayout(layout);
        for(PlotRowModel model : tableModel.data)
        {
            int y = ptr * rowHeight;
            int x = 0;
            PlotRowPanel row = new PlotRowPanel(outputs, features, this);
            model.rowIndex = ptr;
            row.updateModel(model);
            content.add(row);
            rows.add(row);
            ptr++;
        }
        plotScrollView.setViewportView(content);
        plotScrollView.revalidate();
    }
    
    @Override
    public void wasScrolled(int xPos)
    {
        if(linkScrollToggle.isSelected())
        {
            for(PlotRowPanel panel : rows)
            {
                if(!panel.model.isStreaming)
                {
                    panel.scroll(xPos);
                }
            }
        }
    }
    
    public void updateTable()
    {
        System.out.println("updateTable");
        int ptr = 0;
        for(PlotRowPanel row : rows)
        {
            PlotRowModel model  = tableModel.data.get(ptr);
            row.updateModel(model);
            ptr++;
        }
    }
    
    public class PlotRowModel
    {
        int featureIndex = 0;
        int outputIndex = 0;
        boolean isStreaming = false;
        int rowIndex = 0;
        protected LinkedList<Double> points = new LinkedList();
        protected LinkedList<Double> classes = new LinkedList();
        
        public void addPoint(double pt)
        {
            synchronized(this) {
                points.add(pt);
                if(isStreaming)
                {
                    while (points.size() > POINTS_PER_ROW) {
                        points.removeFirst();
                    }
                }
                rows.get(rowIndex).updateModel(this);
            }
        } 
    }
    
    public class PlotTableModel
    {
        private String[] columnNames = {"Plots"};
        public ArrayList<PlotRowModel> data = new ArrayList();

        public int getColumnCount() {
            return 1;
        }

        public int getRowCount() {
            return data.size();
        }

        public String getColumnName(int col) {
            return columnNames[col];
        }

        public PlotRowModel getValueAt(int row, int col) {
            return data.get(row);
        }

        public void setValueAt(PlotRowModel value, int row, int col) {
            data.set(row, value);
        }

        public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }
        
        public boolean isCellEditable(int row, int col) {
            return true;        
        }
    }
}
