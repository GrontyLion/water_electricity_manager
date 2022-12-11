
package com.mjl.water_electricity_manager.ui;

import com.mjl.water_electricity_manager.domain.User;
import com.mjl.water_electricity_manager.domain.WaterElectricityConsumption;
import com.mjl.water_electricity_manager.service.UserService;
import com.mjl.water_electricity_manager.service.WaterElectricityConsumptionService;
import org.jdesktop.swingx.JXDatePicker;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.RoundingMode;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Component
public class StudentMainFrame extends JFrame {

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

    private DefaultTableModel tableModelNumber;
    private DefaultTableModel tableModelConsumption;
    private DefaultTableCellRenderer tableCellRenderer;


    @Resource
    private UserService userService;

    @Resource
    private WaterElectricityConsumptionService waterElectricityConsumptionService;

    public StudentMainFrame() {
        initComponents();
    }

    public void loadData() {
        List<User> users = userService.searchByDormitoryId(UserService.loginUser.getDormitoryId());
        tableModelNumber.setRowCount(0);
        for (User user : users) {
            tableModelNumber.addRow(new Object[]{
                    user.getId(), user.getName(),
                    Objects.equals(user.getGender(), "M") ? "男" : "女", user.getAge(),
                    user.getPhone(), user.getEmail()}
            );
        }

        List<WaterElectricityConsumption> waterElectricityConsumptions = waterElectricityConsumptionService.searchByDormitoryId(UserService.loginUser.getDormitoryId());
        tableModelConsumption.setRowCount(0);
        for (WaterElectricityConsumption waterElectricityConsumption : waterElectricityConsumptions) {
            tableModelConsumption.addRow(new Object[]{
                    waterElectricityConsumption.getId(), waterElectricityConsumption.getWaterConsume(), waterElectricityConsumption.getElectricityConsume(),
                    waterElectricityConsumption.getWaterFee().divide(waterElectricityConsumption.getWaterConsume(), 2, RoundingMode.HALF_UP),
                    waterElectricityConsumption.getElectricityFee().divide(waterElectricityConsumption.getElectricityConsume(), 2, RoundingMode.HALF_UP),
                    waterElectricityConsumption.getTotalFee(), waterElectricityConsumption.getDate()
            });
        }
    }

    private void thisComponentShown(ComponentEvent e) {
        loadData();
        setTitle(getTitle() + " - " + UserService.loginUser.getName() + " - " + UserService.loginUser.getDormitoryId());
    }

    private void buttonSearchMousePressed(MouseEvent e) {
        Integer id;
        Double waterPrice;
        Double electricityPrice;
        try {
            id = null;
            if (!textFieldId.getText().isEmpty()) {
                id = Integer.parseInt(textFieldId.getText());
            }
            waterPrice = null;
            if (!textFieldWaterPrice.getText().isEmpty()) {
                waterPrice = Double.parseDouble(textFieldWaterPrice.getText());
            }
            electricityPrice = null;
            if (!textFieldElectricityPrice.getText().isEmpty()) {
                electricityPrice = Double.parseDouble(textFieldElectricityPrice.getText());
            }
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, "输入有误, 数据类型不匹配");
            return;
        }
        List<WaterElectricityConsumption> waterElectricityConsumptions = waterElectricityConsumptionService.searchBy5Condition(
                UserService.loginUser.getDormitoryId(), id, waterPrice, electricityPrice, xDatePickerDate.getDate()
        );
        tableModelConsumption.setRowCount(0);
        for (WaterElectricityConsumption waterElectricityConsumption : waterElectricityConsumptions) {
            tableModelConsumption.addRow(new Object[]{
                    waterElectricityConsumption.getId(), waterElectricityConsumption.getWaterConsume(), waterElectricityConsumption.getElectricityConsume(),
                    waterElectricityConsumption.getWaterFee().divide(waterElectricityConsumption.getWaterConsume(), 2, RoundingMode.HALF_UP),
                    waterElectricityConsumption.getElectricityFee().divide(waterElectricityConsumption.getElectricityConsume(), 2, RoundingMode.HALF_UP),
                    waterElectricityConsumption.getTotalFee(), waterElectricityConsumption.getDate()
            });
        }
    }

    private void buttonResetMousePressed(MouseEvent e) {
        textFieldId.setText("");
        textFieldWaterPrice.setText("");
        textFieldElectricityPrice.setText("");
        xDatePickerDate.setDate(new Date());
        loadData();
    }

    private void initComponents() {
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
        tableCellRenderer = new DefaultTableCellRenderer();

        //======== this ========
        setTitle("学生主界面");
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                thisComponentShown(e);
            }
        });
        var contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setBorder(new TitledBorder("检索"));

            //---- label1 ----
            label1.setText("编号：");

            //---- label2 ----
            label2.setText("当时水价：");

            //---- label3 ----
            label3.setText("当时电价：");

            //---- label4 ----
            label4.setText("日期：");

            //---- buttonSearch ----
            buttonSearch.setText("检索");
            buttonSearch.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    buttonSearchMousePressed(e);
                }
            });

            //---- buttonReset ----
            buttonReset.setText("重置");
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
                                    .addContainerGap(26, Short.MAX_VALUE))
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
            panel2.setBorder(new TitledBorder("宿舍人员"));

            //======== scrollPane2 ========
            {

                //---- tableNumber ----
                tableModelNumber = new DefaultTableModel(
                        new Object[][]{
                                {null, null, "", null, null, null},
                        },
                        new String[]{
                                "编号", "姓名", "性别", "年龄", "手机号", "邮箱"
                        }
                ) {
                    Class<?>[] columnTypes = new Class<?>[]{
                            Integer.class, String.class, String.class, Integer.class, String.class, String.class
                    };

                    @Override
                    public Class<?> getColumnClass(int columnIndex) {
                        return columnTypes[columnIndex];
                    }

                    @Override
                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return false;
                    }


                };
                scrollPane2.setViewportView(tableNumber);
                tableNumber.setModel(tableModelNumber);
                // 表格内容居中
                tableCellRenderer.setHorizontalAlignment(JLabel.CENTER);
                tableNumber.setDefaultRenderer(String.class, tableCellRenderer);
                tableNumber.setDefaultRenderer(Integer.class, tableCellRenderer);
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
            panel3.setBorder(new TitledBorder("宿舍用电、用水情况"));

            //======== scrollPane1 ========
            {

                //---- tableConsumption ----
                tableModelConsumption = new DefaultTableModel(
                        new Object[][]{
                                {null, null, null, null, null, null, null},
                        },
                        new String[]{
                                "编号", "用水量", "用电量", "当时水价", "当时电价", "总费用", "日期"
                        }
                ) {
                    Class<?>[] columnTypes = new Class<?>[]{
                            Integer.class, Double.class, Double.class, Double.class, Double.class, Double.class, Date.class
                    };

                    @Override
                    public Class<?> getColumnClass(int columnIndex) {
                        return columnTypes[columnIndex];
                    }

                    @Override
                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return false;
                    }
                };
                tableConsumption.setModel(tableModelConsumption);
                scrollPane1.setViewportView(tableConsumption);
                tableCellRenderer.setHorizontalAlignment(JLabel.CENTER);
                tableConsumption.setDefaultRenderer(String.class, tableCellRenderer);
                tableConsumption.setDefaultRenderer(Integer.class, tableCellRenderer);
                tableConsumption.setDefaultRenderer(Double.class, tableCellRenderer);

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
                                .addComponent(panel1, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        pack();
        setLocationRelativeTo(getOwner());
    }


}
