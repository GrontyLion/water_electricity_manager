/*
 * Created by JFormDesigner on Thu Dec 08 15:21:40 CST 2022
 */

package com.mjl.water_electricity_manager.ui;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author Brainrain
 */
public class OtherDormitoryBuildingControlFrame extends JFrame {
    public OtherDormitoryBuildingControlFrame() {
        initComponents();
    }

    private void buttonAddTopMousePressed(MouseEvent e) {
        // TODO add your code here
    }

    private void buttonResetTopMousePressed(MouseEvent e) {
        // TODO add your code here
    }

    private void buttonEditBottomMousePressed(MouseEvent e) {
        // TODO add your code here
    }

    private void buttonResetBottomMousePressed(MouseEvent e) {
        // TODO add your code here
    }

    private void buttonDeleteBottomMousePressed(MouseEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        panel1 = new JPanel();
        label1 = new JLabel();
        textFieldDNameTop = new JTextField();
        label2 = new JLabel();
        textFieldJanTop = new JTextField();
        label3 = new JLabel();
        textFieldNameTop = new JTextField();
        label4 = new JLabel();
        textFieldPhoneTop = new JTextField();
        label5 = new JLabel();
        textFieldEmailTop = new JTextField();
        label6 = new JLabel();
        textFieldNumbersTop = new JTextField();
        label7 = new JLabel();
        textFieldStartTop = new JTextField();
        label8 = new JLabel();
        textFieldEpriceTop = new JTextField();
        label9 = new JLabel();
        textFieldWpriceTop = new JTextField();
        buttonAddTop = new JButton();
        buttonResetTop = new JButton();
        panel2 = new JPanel();
        label10 = new JLabel();
        textFieldIdBottom = new JTextField();
        label11 = new JLabel();
        textFieldDNameBottom = new JTextField();
        label12 = new JLabel();
        textFieldNameBottom = new JTextField();
        label13 = new JLabel();
        textFieldPhoneBottom = new JTextField();
        label14 = new JLabel();
        textFieldEmailBottom = new JTextField();
        buttonEditBottom = new JButton();
        buttonResetBottom = new JButton();
        label15 = new JLabel();
        textFieldEPriceBottom = new JTextField();
        label16 = new JLabel();
        textFieldWPriceBottom = new JTextField();
        buttonDeleteBottom = new JButton();

        //======== this ========
        setTitle("\u66f4\u591a\u5bbf\u820d\u697c\u7ba1\u7406\u529f\u80fd");
        setResizable(false);
        var contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setBorder(new TitledBorder("\u65b0\u589e\u5bbf\u820d\u697c"));

            //---- label1 ----
            label1.setText("\u5bbf\u820d\u697c\u540d\uff1a");

            //---- label2 ----
            label2.setText("\u5bb9\u91cf\uff08\u95f4\uff09\uff1a");

            //---- label3 ----
            label3.setText("\u7ba1\u7406\u5458\u59d3\u540d\uff1a");

            //---- label4 ----
            label4.setText("\u7ba1\u7406\u5458\u624b\u673a\uff1a");

            //---- label5 ----
            label5.setText("\u7ba1\u7406\u5458\u90ae\u7bb1\uff1a");

            //---- label6 ----
            label6.setText("1\uff0c2\uff0c3\uff0c4\uff0c5\uff0c6\u4eba\u95f4\u6570\u91cf\uff1a");

            //---- textFieldNumbersTop ----
            textFieldNumbersTop.setToolTipText("\u683c\u5f0f\uff1a16,20,63,22,10,11");

            //---- label7 ----
            label7.setText("\u5bbf\u820d\u540d\uff08\u8d77\u59cb\u53f7\uff09\uff1a");

            //---- textFieldStartTop ----
            textFieldStartTop.setToolTipText("\u4f8b\u5982\uff1a101");

            //---- label8 ----
            label8.setText("\u7535\u4ef7\uff1a");

            //---- label9 ----
            label9.setText("\u6c34\u4ef7\uff1a");

            //---- buttonAddTop ----
            buttonAddTop.setText("\u65b0\u589e");
            buttonAddTop.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    buttonAddTopMousePressed(e);
                }
            });

            //---- buttonResetTop ----
            buttonResetTop.setText("\u91cd\u7f6e");
            buttonResetTop.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    buttonResetTopMousePressed(e);
                }
            });

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttonAddTop)
                                .addGap(18, 18, 18)
                                .addComponent(buttonResetTop))
                            .addGroup(GroupLayout.Alignment.LEADING, panel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addComponent(label1)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(textFieldDNameTop, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(label2)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(textFieldJanTop, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addComponent(label6)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(textFieldNumbersTop)))
                                .addGap(18, 18, 18)
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addComponent(label3)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(textFieldNameTop, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(label4)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(textFieldPhoneTop, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(label5)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(textFieldEmailTop, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addComponent(label7)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(textFieldStartTop, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(label8)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(textFieldEpriceTop, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(label9)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(textFieldWpriceTop, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(16, Short.MAX_VALUE))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label1)
                            .addComponent(textFieldDNameTop, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label2)
                            .addComponent(textFieldJanTop, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label3)
                            .addComponent(textFieldNameTop, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label4)
                            .addComponent(textFieldPhoneTop, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label5)
                            .addComponent(textFieldEmailTop, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label6)
                            .addComponent(textFieldNumbersTop, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label7)
                            .addComponent(textFieldStartTop, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label8)
                            .addComponent(textFieldEpriceTop, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label9)
                            .addComponent(textFieldWpriceTop, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonResetTop)
                            .addComponent(buttonAddTop))
                        .addGap(0, 7, Short.MAX_VALUE))
            );
        }

        //======== panel2 ========
        {
            panel2.setBorder(new TitledBorder("\u4fee\u6539\u5bbf\u820d\u697c\u4fe1\u606f\uff08\u9700\u5728\u5bbf\u820d\u697c\u8868\u4e2d\u9009\u4e2d\u540e\u624d\u4f1a\u663e\u793a\uff09"));

            //---- label10 ----
            label10.setText("\u7f16\u53f7\uff1a");

            //---- label11 ----
            label11.setText("\u5bbf\u820d\u697c\u540d\uff1a");

            //---- label12 ----
            label12.setText("\u7ba1\u7406\u5458\u59d3\u540d\uff1a");

            //---- label13 ----
            label13.setText("\u7ba1\u7406\u5458\u624b\u673a\uff1a");

            //---- label14 ----
            label14.setText("\u7ba1\u7406\u5458\u90ae\u7bb1\uff1a");

            //---- buttonEditBottom ----
            buttonEditBottom.setText("\u4fee\u6539");
            buttonEditBottom.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    buttonEditBottomMousePressed(e);
                }
            });

            //---- buttonResetBottom ----
            buttonResetBottom.setText("\u91cd\u7f6e");
            buttonResetBottom.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    buttonResetBottomMousePressed(e);
                }
            });

            //---- label15 ----
            label15.setText("\u7535\u4ef7\uff08\u4ece\u4e0b\u4e2a\u6708\u5f00\u59cb\u751f\u6548\uff09\uff1a");

            //---- label16 ----
            label16.setText("\u6c34\u4ef7\uff08\u4ece\u4e0b\u4e2a\u6708\u5f00\u59cb\u751f\u6548\uff09\uff1a");

            GroupLayout panel2Layout = new GroupLayout(panel2);
            panel2.setLayout(panel2Layout);
            panel2Layout.setHorizontalGroup(
                panel2Layout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                        .addContainerGap(13, Short.MAX_VALUE)
                        .addGroup(panel2Layout.createParallelGroup()
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addComponent(label10)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textFieldIdBottom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(label11)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textFieldDNameBottom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(label12)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textFieldNameBottom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(label13)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textFieldPhoneBottom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addComponent(label15)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textFieldEPriceBottom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(label16)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textFieldWPriceBottom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(panel2Layout.createParallelGroup()
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addComponent(label14)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textFieldEmailBottom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45))
                            .addGroup(GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                                .addComponent(buttonEditBottom)
                                .addGap(18, 18, 18)
                                .addComponent(buttonResetBottom)
                                .addGap(17, 17, 17))))
            );
            panel2Layout.setVerticalGroup(
                panel2Layout.createParallelGroup()
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label10)
                            .addComponent(textFieldIdBottom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label11)
                            .addComponent(textFieldDNameBottom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label12)
                            .addComponent(textFieldNameBottom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label13)
                            .addComponent(textFieldPhoneBottom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label14)
                            .addComponent(textFieldEmailBottom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonResetBottom)
                            .addComponent(buttonEditBottom)
                            .addComponent(label15)
                            .addComponent(textFieldEPriceBottom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label16)
                            .addComponent(textFieldWPriceBottom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
        }

        //---- buttonDeleteBottom ----
        buttonDeleteBottom.setText("\u5220\u9664\u9009\u4e2d\u5bbf\u820d\u697c\uff08\u5371\u9669\uff01\uff09");
        buttonDeleteBottom.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                buttonDeleteBottomMousePressed(e);
            }
        });

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(buttonDeleteBottom)
                            .addGap(0, 628, Short.MAX_VALUE))))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(panel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(buttonDeleteBottom)
                    .addContainerGap(14, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel panel1;
    private JLabel label1;
    private JTextField textFieldDNameTop;
    private JLabel label2;
    private JTextField textFieldJanTop;
    private JLabel label3;
    private JTextField textFieldNameTop;
    private JLabel label4;
    private JTextField textFieldPhoneTop;
    private JLabel label5;
    private JTextField textFieldEmailTop;
    private JLabel label6;
    private JTextField textFieldNumbersTop;
    private JLabel label7;
    private JTextField textFieldStartTop;
    private JLabel label8;
    private JTextField textFieldEpriceTop;
    private JLabel label9;
    private JTextField textFieldWpriceTop;
    private JButton buttonAddTop;
    private JButton buttonResetTop;
    private JPanel panel2;
    private JLabel label10;
    private JTextField textFieldIdBottom;
    private JLabel label11;
    private JTextField textFieldDNameBottom;
    private JLabel label12;
    private JTextField textFieldNameBottom;
    private JLabel label13;
    private JTextField textFieldPhoneBottom;
    private JLabel label14;
    private JTextField textFieldEmailBottom;
    private JButton buttonEditBottom;
    private JButton buttonResetBottom;
    private JLabel label15;
    private JTextField textFieldEPriceBottom;
    private JLabel label16;
    private JTextField textFieldWPriceBottom;
    private JButton buttonDeleteBottom;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
