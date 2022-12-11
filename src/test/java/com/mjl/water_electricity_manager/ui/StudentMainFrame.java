/*
 * Created by JFormDesigner on Thu Dec 08 14:30:48 CST 2022
 */

package com.mjl.water_electricity_manager.ui;

import org.jdesktop.swingx.JXDatePicker;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;

/**
 * @author Brainrain
 */
public class StudentMainFrame extends JFrame {
    public StudentMainFrame() {
        initComponents();
    }

    private void buttonSearchMousePressed(MouseEvent e) {
        // TODO add your code here
    }

    private void buttonResetMousePressed(MouseEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        panel1 = new JPanel();
        label1 = new JLabel();
        textFieldId = new JTextField();
        label2 = new JLabel();
        textFieldWaterPrice = new JTextField();
        label3 = new JLabel();
        textFieldElectricityPrice = new JTextField();
        label4 = new JLabel();
        xDatePickerDate = new JXDatePicker();
        buttonSearch = new JButton();
        buttonReset = new JButton();
        panel2 = new JPanel();
        scrollPane2 = new JScrollPane();
        tableNumber = new JTable();
        panel3 = new JPanel();
        scrollPane1 = new JScrollPane();
        tableConsumption = new JTable();

        //======== this ========
        setTitle("\u5b66\u751f\u4e3b\u754c\u9762");
        var contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setBorder(new TitledBorder("\u68c0\u7d22"));

            //---- label1 ----
            label1.setText("\u7f16\u53f7\uff1a");

            //---- label2 ----
            label2.setText("\u5f53\u65f6\u6c34\u4ef7\uff1a");

            //---- label3 ----
            label3.setText("\u5f53\u65f6\u7535\u4ef7\uff1a");

            //---- label4 ----
            label4.setText("\u65e5\u671f\uff1a");

            //---- buttonSearch ----
            buttonSearch.setText("\u68c0\u7d22");
            buttonSearch.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    buttonSearchMousePressed(e);
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

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(label1)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textFieldId, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(label2)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textFieldWaterPrice, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(label3)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textFieldElectricityPrice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(label4)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(xDatePickerDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(230, 230, 230)
                                .addComponent(buttonSearch)
                                .addGap(93, 93, 93)
                                .addComponent(buttonReset)))
                        .addContainerGap(23, Short.MAX_VALUE))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label1)
                            .addComponent(textFieldId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label2)
                            .addComponent(label3)
                            .addComponent(textFieldElectricityPrice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(textFieldWaterPrice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label4)
                            .addComponent(xDatePickerDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonSearch)
                            .addComponent(buttonReset)))
            );
        }

        //======== panel2 ========
        {
            panel2.setBorder(new TitledBorder("\u5bbf\u820d\u4eba\u5458"));

            //======== scrollPane2 ========
            {

                //---- tableNumber ----
                tableNumber.setModel(new DefaultTableModel(
                    new Object[][] {
                        {null, null, "", null, null, null},
                    },
                    new String[] {
                        "\u7f16\u53f7", "\u59d3\u540d", "\u6027\u522b", "\u5e74\u9f84", "\u624b\u673a\u53f7", "\u90ae\u7bb1"
                    }
                ) {
                    Class<?>[] columnTypes = new Class<?>[] {
                        Integer.class, String.class, String.class, Integer.class, String.class, String.class
                    };
                    boolean[] columnEditable = new boolean[] {
                        false, false, false, false, false, false
                    };
                    @Override
                    public Class<?> getColumnClass(int columnIndex) {
                        return columnTypes[columnIndex];
                    }
                    @Override
                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return columnEditable[columnIndex];
                    }
                });
                scrollPane2.setViewportView(tableNumber);
            }

            GroupLayout panel2Layout = new GroupLayout(panel2);
            panel2.setLayout(panel2Layout);
            panel2Layout.setHorizontalGroup(
                panel2Layout.createParallelGroup()
                    .addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 711, Short.MAX_VALUE)
            );
            panel2Layout.setVerticalGroup(
                panel2Layout.createParallelGroup()
                    .addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
            );
        }

        //======== panel3 ========
        {
            panel3.setBorder(new TitledBorder("\u5bbf\u820d\u7528\u7535\u3001\u7528\u6c34\u60c5\u51b5"));

            //======== scrollPane1 ========
            {

                //---- tableConsumption ----
                tableConsumption.setModel(new DefaultTableModel(
                    new Object[][] {
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                    },
                    new String[] {
                        "\u7f16\u53f7", "\u7528\u6c34\u91cf", "\u7528\u7535\u91cf", "\u5f53\u65f6\u6c34\u4ef7", "\u5f53\u65f6\u7535\u4ef7", "\u603b\u8d39\u7528", "\u65e5\u671f"
                    }
                ) {
                    Class<?>[] columnTypes = new Class<?>[] {
                        Integer.class, Double.class, Double.class, Double.class, Double.class, Double.class, Date.class
                    };
                    boolean[] columnEditable = new boolean[] {
                        false, false, false, false, false, false, false
                    };
                    @Override
                    public Class<?> getColumnClass(int columnIndex) {
                        return columnTypes[columnIndex];
                    }
                    @Override
                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return columnEditable[columnIndex];
                    }
                });
                scrollPane1.setViewportView(tableConsumption);
            }

            GroupLayout panel3Layout = new GroupLayout(panel3);
            panel3.setLayout(panel3Layout);
            panel3Layout.setHorizontalGroup(
                panel3Layout.createParallelGroup()
                    .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 711, Short.MAX_VALUE)
            );
            panel3Layout.setVerticalGroup(
                panel3Layout.createParallelGroup()
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE)
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(panel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panel2, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(panel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(panel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel panel1;
    private JLabel label1;
    private JTextField textFieldId;
    private JLabel label2;
    private JTextField textFieldWaterPrice;
    private JLabel label3;
    private JTextField textFieldElectricityPrice;
    private JLabel label4;
    private JXDatePicker xDatePickerDate;
    private JButton buttonSearch;
    private JButton buttonReset;
    private JPanel panel2;
    private JScrollPane scrollPane2;
    private JTable tableNumber;
    private JPanel panel3;
    private JScrollPane scrollPane1;
    private JTable tableConsumption;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
