/*
 * Created by JFormDesigner on Thu Dec 08 15:07:15 CST 2022
 */

package com.mjl.water_electricity_manager.ui;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author Brainrain
 */
public class AdminMainFrame extends JFrame {
    public AdminMainFrame() {
        initComponents();
    }

    private void button0SearchMousePressed(MouseEvent e) {
        // TODO add your code here
    }

    private void button0ResetMousePressed(MouseEvent e) {
        // TODO add your code here
    }

    private void button0OtherMousePressed(MouseEvent e) {
        // TODO add your code here
    }

    private void button1SearchTopMousePressed(MouseEvent e) {
        // TODO add your code here
    }

    private void button1AddTopMousePressed(MouseEvent e) {
        // TODO add your code here
    }

    private void button1EditTopMousePressed(MouseEvent e) {
        // TODO add your code here
    }

    private void button1DeleteTopMousePressed(MouseEvent e) {
        // TODO add your code here
    }

    private void button1SearchBottomMousePressed(MouseEvent e) {
        // TODO add your code here
    }

    private void button1AddBottomMousePressed(MouseEvent e) {
        // TODO add your code here
    }

    private void button1EditBottomMousePressed(MouseEvent e) {
        // TODO add your code here
    }

    private void button1DeleteBottomMousePressed(MouseEvent e) {
        // TODO add your code here
    }

    private void button2SearchMousePressed(MouseEvent e) {
        // TODO add your code here
    }

    private void button2AddMousePressed(MouseEvent e) {
        // TODO add your code here
    }

    private void button2EditMousePressed(MouseEvent e) {
        // TODO add your code here
    }

    private void button2DeleteMousePressed(MouseEvent e) {
        // TODO add your code here
    }


    private void table1topMousePressed(MouseEvent e) {
        // TODO add your code here
    }

    private void scrollPane3MousePressed(MouseEvent e) {
        // TODO add your code here
    }

    private void scrollPane1MousePressed(MouseEvent e) {
        // TODO add your code here
    }

    private void table0bottomMousePressed(MouseEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        tabbedPane1 = new JTabbedPane();
        panel1 = new JPanel();
        panel3 = new JPanel();
        label1 = new JLabel();
        textField0Id = new JTextField();
        label2 = new JLabel();
        textField0dName = new JTextField();
        label3 = new JLabel();
        textField0Name = new JTextField();
        label4 = new JLabel();
        textField0Phone = new JTextField();
        label5 = new JLabel();
        textField0Email = new JTextField();
        label6 = new JLabel();
        spinner0renL = new JSpinner();
        label7 = new JLabel();
        spinner0renR = new JSpinner();
        label8 = new JLabel();
        spinner0janL = new JSpinner();
        label9 = new JLabel();
        spinner0janR = new JSpinner();
        button0Search = new JButton();
        button0Reset = new JButton();
        button0Other = new JButton();
        scrollPane1 = new JScrollPane();
        table0bottom = new JTable();
        panel2 = new JPanel();
        panel4 = new JPanel();
        scrollPane2 = new JScrollPane();
        table1bottom = new JTable();
        label12 = new JLabel();
        textField1IdBottom = new JTextField();
        label13 = new JLabel();
        textField1NameBottom = new JTextField();
        button1SearchBottom = new JButton();
        button1AddBottom = new JButton();
        button1EditBottom = new JButton();
        button1DeleteBottom = new JButton();
        panel5 = new JPanel();
        scrollPane3 = new JScrollPane();
        table1top = new JTable();
        button1AddTop = new JButton();
        button1EditTop = new JButton();
        button1DeleteTop = new JButton();
        label10 = new JLabel();
        textField1IdTop = new JTextField();
        label11 = new JLabel();
        textField1NameTop = new JTextField();
        button1SearchTop = new JButton();
        panel6 = new JPanel();
        panel7 = new JPanel();
        scrollPane4 = new JScrollPane();
        table2Bottom = new JTable();
        label14 = new JLabel();
        textField2Id = new JTextField();
        label15 = new JLabel();
        textField2Name = new JTextField();
        label16 = new JLabel();
        textField2Type = new JTextField();
        label17 = new JLabel();
        textField2Gender = new JTextField();
        label18 = new JLabel();
        spinner2ageL = new JSpinner();
        label19 = new JLabel();
        spinner2ageR = new JSpinner();
        label20 = new JLabel();
        textField2Email = new JTextField();
        label21 = new JLabel();
        textField2Phone = new JTextField();
        label22 = new JLabel();
        textField2Dormitory = new JTextField();
        button2Search = new JButton();
        button2Add = new JButton();
        button2Edit = new JButton();
        button2Delete = new JButton();

        //======== this ========
        setTitle("\u7ba1\u7406\u5458\u4e3b\u754c\u9762");
        var contentPane = getContentPane();

        //======== tabbedPane1 ========
        {

            //======== panel1 ========
            {

                //======== panel3 ========
                {
                    panel3.setBorder(new TitledBorder("\u68c0\u7d22"));

                    //---- label1 ----
                    label1.setText("\u7f16\u53f7\uff1a");

                    //---- label2 ----
                    label2.setText("\u5bbf\u820d\u697c\u540d\uff1a");

                    //---- label3 ----
                    label3.setText("\u7ba1\u7406\u5458\u59d3\u540d\uff1a");

                    //---- label4 ----
                    label4.setText("\u7ba1\u7406\u5458\u624b\u673a\uff1a");

                    //---- label5 ----
                    label5.setText("\u7ba1\u7406\u5458\u90ae\u7bb1\uff1a");

                    //---- label6 ----
                    label6.setText("\u5bb9\u91cf\uff08\u4eba\uff09\u533a\u95f4\uff1a");

                    //---- label7 ----
                    label7.setText("\u5230");

                    //---- label8 ----
                    label8.setText("\u5bb9\u91cf\uff08\u95f4\uff09\u533a\u95f4\uff1a");

                    //---- label9 ----
                    label9.setText("\u5230");

                    //---- button0Search ----
                    button0Search.setText("\u68c0\u7d22");
                    button0Search.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mousePressed(MouseEvent e) {
                            button0SearchMousePressed(e);
                        }
                    });

                    //---- button0Reset ----
                    button0Reset.setText("\u91cd\u7f6e");
                    button0Reset.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mousePressed(MouseEvent e) {
                            button0ResetMousePressed(e);
                        }
                    });

                    //---- button0Other ----
                    button0Other.setText("\u5176\u5b83");
                    button0Other.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mousePressed(MouseEvent e) {
                            button0OtherMousePressed(e);
                        }
                    });

                    GroupLayout panel3Layout = new GroupLayout(panel3);
                    panel3.setLayout(panel3Layout);
                    panel3Layout.setHorizontalGroup(
                        panel3Layout.createParallelGroup()
                            .addGroup(panel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addGroup(panel3Layout.createSequentialGroup()
                                        .addComponent(label1)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(textField0Id, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(label2)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(textField0dName, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(label3)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(textField0Name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(label4)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(textField0Phone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(label5)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(textField0Email, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panel3Layout.createSequentialGroup()
                                        .addComponent(label6)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(spinner0renL, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(label7)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(spinner0renR, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(label8)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(spinner0janL, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(label9)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(spinner0janR, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(button0Search)
                                        .addGap(18, 18, 18)
                                        .addComponent(button0Reset)
                                        .addGap(18, 18, 18)
                                        .addComponent(button0Other)))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    );
                    panel3Layout.setVerticalGroup(
                        panel3Layout.createParallelGroup()
                            .addGroup(panel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(label1)
                                    .addComponent(textField0Id, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label2)
                                    .addComponent(textField0dName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label3)
                                    .addComponent(textField0Name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label4)
                                    .addComponent(textField0Phone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label5)
                                    .addComponent(textField0Email, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(panel3Layout.createParallelGroup()
                                    .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label6)
                                        .addComponent(label7)
                                        .addComponent(spinner0renR, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(spinner0renL, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(button0Search)
                                        .addComponent(button0Reset)
                                        .addComponent(button0Other)
                                        .addComponent(spinner0janR, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panel3Layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addGroup(panel3Layout.createParallelGroup()
                                            .addComponent(label8)
                                            .addComponent(label9)))
                                    .addComponent(spinner0janL, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(11, Short.MAX_VALUE))
                    );
                }

                //======== scrollPane1 ========
                {
                    scrollPane1.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mousePressed(MouseEvent e) {
                            scrollPane1MousePressed(e);
                        }
                    });

                    //---- table0bottom ----
                    table0bottom.setModel(new DefaultTableModel(
                        new Object[][] {
                            {null, null, null, null, null, null, null, null, null},
                            {null, null, null, null, null, null, null, null, null},
                        },
                        new String[] {
                            "\u7f16\u53f7", "\u5bbf\u820d\u697c\u540d", "\u603b\u5bb9\u91cf\uff08\u4eba\uff09", "\u5df2\u4f4f\uff08\u4eba\uff09", "\u603b\u5bb9\u91cf\uff08\u95f4\uff09", "\u5df2\u4f4f\uff08\u95f4\uff09", "\u7ba1\u7406\u5458\u59d3\u540d", "\u7ba1\u7406\u5458\u624b\u673a", "\u7ba1\u7406\u5458\u90ae\u7bb1"
                        }
                    ) {
                        Class<?>[] columnTypes = new Class<?>[] {
                            Integer.class, String.class, Integer.class, Integer.class, Integer.class, Integer.class, String.class, String.class, String.class
                        };
                        boolean[] columnEditable = new boolean[] {
                            false, false, false, false, false, false, false, false, false
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
                    table0bottom.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mousePressed(MouseEvent e) {
                            table0bottomMousePressed(e);
                        }
                    });
                    scrollPane1.setViewportView(table0bottom);
                }

                GroupLayout panel1Layout = new GroupLayout(panel1);
                panel1.setLayout(panel1Layout);
                panel1Layout.setHorizontalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(panel1Layout.createParallelGroup()
                                .addComponent(panel3, GroupLayout.DEFAULT_SIZE, 779, Short.MAX_VALUE)
                                .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 779, Short.MAX_VALUE))
                            .addContainerGap())
                );
                panel1Layout.setVerticalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(panel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
                            .addContainerGap())
                );
            }
            tabbedPane1.addTab("\u5bbf\u820d\u697c\u7ba1\u7406", panel1);

            //======== panel2 ========
            {

                //======== panel4 ========
                {
                    panel4.setBorder(new TitledBorder("\u5bbf\u820d\u4eba\u5458\u4fe1\u606f\uff08\u5728\u4e0a\u9762\u9009\u4e2d\u5bbf\u820d\u540e\u663e\u793a\uff09"));

                    //======== scrollPane2 ========
                    {

                        //---- table1bottom ----
                        table1bottom.setModel(new DefaultTableModel(
                            new Object[][] {
                                {null, null, null, null, null, null, null},
                                {null, null, null, null, null, null, null},
                            },
                            new String[] {
                                "\u7f16\u53f7", "\u59d3\u540d", "\u6027\u522b", "\u5e74\u9f84", "\u90ae\u7bb1", "\u624b\u673a\u53f7", "\u5bc6\u7801"
                            }
                        ) {
                            Class<?>[] columnTypes = new Class<?>[] {
                                Integer.class, String.class, String.class, Integer.class, String.class, String.class, String.class
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
                        scrollPane2.setViewportView(table1bottom);
                    }

                    //---- label12 ----
                    label12.setText("\u7f16\u53f7\uff1a");

                    //---- label13 ----
                    label13.setText("\u59d3\u540d\uff1a");

                    //---- button1SearchBottom ----
                    button1SearchBottom.setText("\u68c0\u7d22");
                    button1SearchBottom.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mousePressed(MouseEvent e) {
                            button1SearchBottomMousePressed(e);
                        }
                    });

                    //---- button1AddBottom ----
                    button1AddBottom.setText("\u65b0\u589e");
                    button1AddBottom.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mousePressed(MouseEvent e) {
                            button1AddBottomMousePressed(e);
                        }
                    });

                    //---- button1EditBottom ----
                    button1EditBottom.setText("\u4fee\u6539");
                    button1EditBottom.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mousePressed(MouseEvent e) {
                            button1EditBottomMousePressed(e);
                        }
                    });

                    //---- button1DeleteBottom ----
                    button1DeleteBottom.setText("\u5220\u9664");
                    button1DeleteBottom.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mousePressed(MouseEvent e) {
                            button1DeleteBottomMousePressed(e);
                        }
                    });

                    GroupLayout panel4Layout = new GroupLayout(panel4);
                    panel4.setLayout(panel4Layout);
                    panel4Layout.setHorizontalGroup(
                        panel4Layout.createParallelGroup()
                            .addGroup(panel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panel4Layout.createParallelGroup()
                                    .addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 757, Short.MAX_VALUE)
                                    .addGroup(panel4Layout.createSequentialGroup()
                                        .addComponent(label12)
                                        .addGap(6, 6, 6)
                                        .addComponent(textField1IdBottom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(label13)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(textField1NameBottom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(button1SearchBottom)
                                        .addGap(18, 18, 18)
                                        .addComponent(button1AddBottom)
                                        .addGap(18, 18, 18)
                                        .addComponent(button1EditBottom)
                                        .addGap(18, 18, 18)
                                        .addComponent(button1DeleteBottom)
                                        .addGap(0, 167, Short.MAX_VALUE)))
                                .addContainerGap())
                    );
                    panel4Layout.setVerticalGroup(
                        panel4Layout.createParallelGroup()
                            .addGroup(GroupLayout.Alignment.TRAILING, panel4Layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panel4Layout.createParallelGroup()
                                    .addGroup(panel4Layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(label12))
                                    .addGroup(panel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(textField1IdBottom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label13)
                                        .addComponent(textField1NameBottom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(button1SearchBottom)
                                        .addComponent(button1AddBottom)
                                        .addComponent(button1EditBottom)
                                        .addComponent(button1DeleteBottom)))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                    );
                }

                //======== panel5 ========
                {
                    panel5.setBorder(new TitledBorder("\u5bbf\u820d\u4fe1\u606f"));

                    //======== scrollPane3 ========
                    {
                        scrollPane3.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mousePressed(MouseEvent e) {
                                scrollPane3MousePressed(e);
                            }
                        });

                        //---- table1top ----
                        table1top.setModel(new DefaultTableModel(
                            new Object[][] {
                                {null, null, null, null},
                                {null, null, null, null},
                            },
                            new String[] {
                                "\u7f16\u53f7", "\u5bbf\u820d\u540d", "\u5bb9\u91cf\uff08\u4eba\uff09", "\u5df2\u4f4f\uff08\u4eba\uff09"
                            }
                        ) {
                            Class<?>[] columnTypes = new Class<?>[] {
                                Integer.class, String.class, Integer.class, Integer.class
                            };
                            boolean[] columnEditable = new boolean[] {
                                false, false, false, false
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
                        table1top.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mousePressed(MouseEvent e) {
                                table1topMousePressed(e);
                            }
                        });
                        scrollPane3.setViewportView(table1top);
                    }

                    //---- button1AddTop ----
                    button1AddTop.setText("\u65b0\u589e");
                    button1AddTop.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mousePressed(MouseEvent e) {
                            button1AddTopMousePressed(e);
                        }
                    });

                    //---- button1EditTop ----
                    button1EditTop.setText("\u4fee\u6539");
                    button1EditTop.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mousePressed(MouseEvent e) {
                            button1EditTopMousePressed(e);
                        }
                    });

                    //---- button1DeleteTop ----
                    button1DeleteTop.setText("\u5220\u9664");
                    button1DeleteTop.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mousePressed(MouseEvent e) {
                            button1DeleteTopMousePressed(e);
                        }
                    });

                    //---- label10 ----
                    label10.setText("\u7f16\u53f7\uff1a");

                    //---- label11 ----
                    label11.setText("\u5bbf\u820d\u540d\uff1a");

                    //---- button1SearchTop ----
                    button1SearchTop.setText("\u68c0\u7d22");
                    button1SearchTop.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mousePressed(MouseEvent e) {
                            button1SearchTopMousePressed(e);
                        }
                    });

                    GroupLayout panel5Layout = new GroupLayout(panel5);
                    panel5.setLayout(panel5Layout);
                    panel5Layout.setHorizontalGroup(
                        panel5Layout.createParallelGroup()
                            .addGroup(panel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panel5Layout.createParallelGroup()
                                    .addComponent(scrollPane3, GroupLayout.DEFAULT_SIZE, 763, Short.MAX_VALUE)
                                    .addGroup(panel5Layout.createSequentialGroup()
                                        .addComponent(label10)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(textField1IdTop, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(label11)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(textField1NameTop, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(button1SearchTop)
                                        .addGap(18, 18, 18)
                                        .addComponent(button1AddTop)
                                        .addGap(18, 18, 18)
                                        .addComponent(button1EditTop)
                                        .addGap(18, 18, 18)
                                        .addComponent(button1DeleteTop)
                                        .addGap(0, 161, Short.MAX_VALUE))))
                    );
                    panel5Layout.setVerticalGroup(
                        panel5Layout.createParallelGroup()
                            .addGroup(panel5Layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(label10)
                                    .addComponent(textField1IdTop, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label11)
                                    .addComponent(textField1NameTop, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button1SearchTop)
                                    .addComponent(button1AddTop)
                                    .addComponent(button1EditTop)
                                    .addComponent(button1DeleteTop))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(scrollPane3, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                    );
                }

                GroupLayout panel2Layout = new GroupLayout(panel2);
                panel2.setLayout(panel2Layout);
                panel2Layout.setHorizontalGroup(
                    panel2Layout.createParallelGroup()
                        .addGroup(panel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(panel2Layout.createParallelGroup()
                                .addComponent(panel5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(panel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addContainerGap())
                );
                panel2Layout.setVerticalGroup(
                    panel2Layout.createParallelGroup()
                        .addGroup(panel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(panel5, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(panel4, GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                            .addContainerGap())
                );
            }
            tabbedPane1.addTab("\u5bbf\u820d\u7ba1\u7406", panel2);

            //======== panel6 ========
            {

                //======== panel7 ========
                {
                    panel7.setBorder(new TitledBorder("\u4eba\u5458\u7ba1\u7406"));

                    //======== scrollPane4 ========
                    {

                        //---- table2Bottom ----
                        table2Bottom.setModel(new DefaultTableModel(
                            new Object[][] {
                                {null, null, null, null, null, null, null, null, null},
                                {null, null, null, null, null, null, null, null, null},
                            },
                            new String[] {
                                "\u7f16\u53f7", "\u59d3\u540d", "\u7528\u6237\u7c7b\u578b", "\u6027\u522b", "\u5e74\u9f84", "\u90ae\u7bb1", "\u624b\u673a\u53f7", "\u5bc6\u7801", "\u5bbf\u820d"
                            }
                        ) {
                            Class<?>[] columnTypes = new Class<?>[] {
                                Integer.class, String.class, String.class, String.class, Integer.class, String.class, String.class, String.class, String.class
                            };
                            boolean[] columnEditable = new boolean[] {
                                false, false, false, false, false, false, false, false, false
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
                        scrollPane4.setViewportView(table2Bottom);
                    }

                    //---- label14 ----
                    label14.setText("\u7f16\u53f7\uff1a");

                    //---- label15 ----
                    label15.setText("\u59d3\u540d\uff1a");

                    //---- label16 ----
                    label16.setText("\u7528\u6237\u7c7b\u578b\uff1a");

                    //---- label17 ----
                    label17.setText("\u6027\u522b\uff1a");

                    //---- label18 ----
                    label18.setText("\u5e74\u9f84\u533a\u95f4\uff1a");

                    //---- label19 ----
                    label19.setText("\u5230");

                    //---- label20 ----
                    label20.setText("\u90ae\u7bb1\uff1a");

                    //---- label21 ----
                    label21.setText("\u624b\u673a\u53f7\uff1a");

                    //---- label22 ----
                    label22.setText("\u5bbf\u820d\uff1a");

                    //---- button2Search ----
                    button2Search.setText("\u68c0\u7d22");
                    button2Search.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mousePressed(MouseEvent e) {
                            button2SearchMousePressed(e);
                        }
                    });

                    //---- button2Add ----
                    button2Add.setText("\u65b0\u589e");
                    button2Add.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mousePressed(MouseEvent e) {
                            button2AddMousePressed(e);
                        }
                    });

                    //---- button2Edit ----
                    button2Edit.setText("\u4fee\u6539");
                    button2Edit.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mousePressed(MouseEvent e) {
                            button2EditMousePressed(e);
                        }
                    });

                    //---- button2Delete ----
                    button2Delete.setText("\u5220\u9664\uff08\u5371\u9669\uff09");
                    button2Delete.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mousePressed(MouseEvent e) {
                            button2DeleteMousePressed(e);
                        }
                    });

                    GroupLayout panel7Layout = new GroupLayout(panel7);
                    panel7.setLayout(panel7Layout);
                    panel7Layout.setHorizontalGroup(
                        panel7Layout.createParallelGroup()
                            .addGroup(panel7Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panel7Layout.createParallelGroup()
                                    .addComponent(scrollPane4, GroupLayout.DEFAULT_SIZE, 757, Short.MAX_VALUE)
                                    .addGroup(panel7Layout.createSequentialGroup()
                                        .addGroup(panel7Layout.createParallelGroup()
                                            .addGroup(panel7Layout.createSequentialGroup()
                                                .addComponent(label14)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(textField2Id, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(label15)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(textField2Name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(label16)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(textField2Type, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(label17)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(textField2Gender, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(label18)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(spinner2ageL, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))
                                            .addGroup(panel7Layout.createSequentialGroup()
                                                .addComponent(label20)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(textField2Email, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(label21)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(textField2Phone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(label22)
                                                .addGap(18, 18, 18)
                                                .addComponent(textField2Dormitory, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(button2Search)
                                                .addGap(18, 18, 18)
                                                .addComponent(button2Add)
                                                .addGap(18, 18, 18)
                                                .addComponent(button2Edit)))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(panel7Layout.createParallelGroup()
                                            .addGroup(panel7Layout.createSequentialGroup()
                                                .addComponent(label19)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(spinner2ageR, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                            .addComponent(button2Delete))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
                    );
                    panel7Layout.setVerticalGroup(
                        panel7Layout.createParallelGroup()
                            .addGroup(panel7Layout.createSequentialGroup()
                                .addGroup(panel7Layout.createParallelGroup()
                                    .addGroup(panel7Layout.createSequentialGroup()
                                        .addGap(9, 9, 9)
                                        .addGroup(panel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(label19)
                                            .addComponent(spinner2ageL, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(spinner2ageR, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(GroupLayout.Alignment.TRAILING, panel7Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(panel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(label14)
                                            .addComponent(textField2Id, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(label15)
                                            .addComponent(textField2Name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(label16)
                                            .addComponent(textField2Type, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(label17)
                                            .addComponent(textField2Gender, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(label18))))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(label20)
                                    .addComponent(textField2Email, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label21)
                                    .addComponent(textField2Phone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label22)
                                    .addComponent(textField2Dormitory, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button2Search)
                                    .addComponent(button2Add)
                                    .addComponent(button2Edit)
                                    .addComponent(button2Delete))
                                .addGap(17, 17, 17)
                                .addComponent(scrollPane4, GroupLayout.PREFERRED_SIZE, 387, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    );
                }

                GroupLayout panel6Layout = new GroupLayout(panel6);
                panel6.setLayout(panel6Layout);
                panel6Layout.setHorizontalGroup(
                    panel6Layout.createParallelGroup()
                        .addGroup(panel6Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(panel7, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addContainerGap())
                );
                panel6Layout.setVerticalGroup(
                    panel6Layout.createParallelGroup()
                        .addGroup(panel6Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(panel7, GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
                            .addContainerGap())
                );
            }
            tabbedPane1.addTab("\u4eba\u5458\u7ba1\u7406", panel6);
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(tabbedPane1)
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(tabbedPane1))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JPanel panel3;
    private JLabel label1;
    private JTextField textField0Id;
    private JLabel label2;
    private JTextField textField0dName;
    private JLabel label3;
    private JTextField textField0Name;
    private JLabel label4;
    private JTextField textField0Phone;
    private JLabel label5;
    private JTextField textField0Email;
    private JLabel label6;
    private JSpinner spinner0renL;
    private JLabel label7;
    private JSpinner spinner0renR;
    private JLabel label8;
    private JSpinner spinner0janL;
    private JLabel label9;
    private JSpinner spinner0janR;
    private JButton button0Search;
    private JButton button0Reset;
    private JButton button0Other;
    private JScrollPane scrollPane1;
    private JTable table0bottom;
    private JPanel panel2;
    private JPanel panel4;
    private JScrollPane scrollPane2;
    private JTable table1bottom;
    private JLabel label12;
    private JTextField textField1IdBottom;
    private JLabel label13;
    private JTextField textField1NameBottom;
    private JButton button1SearchBottom;
    private JButton button1AddBottom;
    private JButton button1EditBottom;
    private JButton button1DeleteBottom;
    private JPanel panel5;
    private JScrollPane scrollPane3;
    private JTable table1top;
    private JButton button1AddTop;
    private JButton button1EditTop;
    private JButton button1DeleteTop;
    private JLabel label10;
    private JTextField textField1IdTop;
    private JLabel label11;
    private JTextField textField1NameTop;
    private JButton button1SearchTop;
    private JPanel panel6;
    private JPanel panel7;
    private JScrollPane scrollPane4;
    private JTable table2Bottom;
    private JLabel label14;
    private JTextField textField2Id;
    private JLabel label15;
    private JTextField textField2Name;
    private JLabel label16;
    private JTextField textField2Type;
    private JLabel label17;
    private JTextField textField2Gender;
    private JLabel label18;
    private JSpinner spinner2ageL;
    private JLabel label19;
    private JSpinner spinner2ageR;
    private JLabel label20;
    private JTextField textField2Email;
    private JLabel label21;
    private JTextField textField2Phone;
    private JLabel label22;
    private JTextField textField2Dormitory;
    private JButton button2Search;
    private JButton button2Add;
    private JButton button2Edit;
    private JButton button2Delete;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
