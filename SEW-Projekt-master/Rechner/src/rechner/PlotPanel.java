/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rechner;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author andyk
 */
public class PlotPanel extends javax.swing.JPanel {

    /**
     * Creates new form PlotPanel
     */
    public PlotPanel() {
        initComponents();
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        int x = getWidth();
        int y = getHeight();
        
        g.setColor(Color.red);
        g.drawOval(10, 10, x-20, y-20);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bX = new javax.swing.JLabel();
        bY = new javax.swing.JLabel();

        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });

        bX.setText("X=");

        bY.setText("Y=");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bX)
                    .addComponent(bY))
                .addContainerGap(121, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bX)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bY)
                .addGap(0, 139, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        // TODO add your handling code here:
        int x=evt.getX();
        int y=evt.getY();
        
        bX.setText("X" + x);
        bY.setText("Y" + y);
        System.out.println("hall1o");
    }//GEN-LAST:event_formMouseMoved


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bX;
    private javax.swing.JLabel bY;
    // End of variables declaration//GEN-END:variables
}