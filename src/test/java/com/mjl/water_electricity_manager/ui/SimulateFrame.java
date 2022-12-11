/*
 * Created by JFormDesigner on Fri Dec 09 16:07:12 CST 2022
 */

package com.mjl.water_electricity_manager.ui;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author Brainrain
 */
public class SimulateFrame extends JFrame {
    public SimulateFrame() {
        initComponents();
    }

    private void buttonSimulateMousePressed(MouseEvent e) {
        // TODO add your code here
    }

    private void buttonResetMousePressed(MouseEvent e) {
        // TODO add your code here
    }

    private void textFieldIdKeyTyped(KeyEvent e) {

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        textFieldId = new JTextField();
        label2 = new JLabel();
        textFieldElectricity = new JTextField();
        label3 = new JLabel();
        textFieldWater = new JTextField();
        label4 = new JLabel();
        textFieldCElectricity = new JTextField();
        label5 = new JLabel();
        textFieldCWater = new JTextField();
        buttonSimulate = new JButton();
        buttonReset = new JButton();

        //======== this ========
        setTitle("\u6a21\u62df\u7528\u6c34\u7528\u7535");
        setResizable(false);
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("\u5bbf\u820d\u7f16\u53f7\uff1a");

        //---- textFieldId ----
        textFieldId.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                textFieldIdKeyTyped(e);
            }
        });

        //---- label2 ----
        label2.setText("\u7528\u7535\u91cf\uff1a");

        //---- label3 ----
        label3.setText("\u7528\u6c34\u91cf\uff1a");

        //---- label4 ----
        label4.setText("\u5f53\u524d\u7535\u4ef7\uff1a");

        //---- textFieldCElectricity ----
        textFieldCElectricity.setEditable(false);

        //---- label5 ----
        label5.setText("\u5f53\u524d\u6c34\u4ef7\uff1a");

        //---- textFieldCWater ----
        textFieldCWater.setEditable(false);

        //---- buttonSimulate ----
        buttonSimulate.setText("\u6a21\u62df");
        buttonSimulate.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                buttonSimulateMousePressed(e);
            }
        });

        //---- buttonReset ----
        buttonReset.setText("\u91cd\u7f6e");
        buttonReset.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                buttonResetMousePressed(e);
            }
        });

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(label1)
                                .addComponent(label2)
                                .addComponent(label3))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(textFieldId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(textFieldElectricity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(label4)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(textFieldCElectricity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(textFieldWater, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(label5)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(textFieldCWater, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(51, 51, 51)
                            .addComponent(buttonSimulate)
                            .addGap(40, 40, 40)
                            .addComponent(buttonReset)))
                    .addContainerGap(19, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGap(12, 12, 12)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1)
                        .addComponent(textFieldId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2)
                        .addComponent(textFieldElectricity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label4)
                        .addComponent(textFieldCElectricity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label3)
                        .addComponent(textFieldWater, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label5)
                        .addComponent(textFieldCWater, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonSimulate)
                        .addComponent(buttonReset))
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JTextField textFieldId;
    private JLabel label2;
    private JTextField textFieldElectricity;
    private JLabel label3;
    private JTextField textFieldWater;
    private JLabel label4;
    private JTextField textFieldCElectricity;
    private JLabel label5;
    private JTextField textFieldCWater;
    private JButton buttonSimulate;
    private JButton buttonReset;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
