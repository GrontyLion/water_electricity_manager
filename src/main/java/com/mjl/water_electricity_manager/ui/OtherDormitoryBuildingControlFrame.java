package com.mjl.water_electricity_manager.ui;

import cn.hutool.core.date.LocalDateTimeUtil;
import com.mjl.water_electricity_manager.domain.BillingHistory;
import com.mjl.water_electricity_manager.domain.DormitoryBuilding;
import com.mjl.water_electricity_manager.service.BillingHistoryService;
import com.mjl.water_electricity_manager.service.DormitoryBuildingService;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@Component
public class OtherDormitoryBuildingControlFrame extends JFrame {
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


    @Resource
    private DormitoryBuildingService dormitoryBuildingService;

    @Resource
    @Lazy
    private AdminMainFrame adminMainFrame;

    @Resource
    private BillingHistoryService billingHistoryService;


    public OtherDormitoryBuildingControlFrame() {
        initComponents();
    }

    private void buttonAddTopMousePressed(MouseEvent e) {
        String dName = textFieldDNameTop.getText();
        String jan = textFieldJanTop.getText();
        String name = textFieldNameTop.getText();
        String phone = textFieldPhoneTop.getText();
        String email = textFieldEmailTop.getText();
        // 格式：1,2,3,4,5,6
        String numbers = textFieldNumbersTop.getText();
        String start = textFieldStartTop.getText();
        String ePrice = textFieldEpriceTop.getText();
        String wPrice = textFieldWpriceTop.getText();

        // 一层多少人
        String oneFloor = JOptionPane.showInputDialog("请输入一层多少间宿舍？");

        boolean b = dormitoryBuildingService.insertDormitoryBuilding(dName, jan, name, phone, email, numbers, start, ePrice, wPrice, oneFloor);
        if (b) {
            JOptionPane.showMessageDialog(this, "添加成功");
            adminMainFrame.loadTable0Data();
        } else {
            JOptionPane.showMessageDialog(this, "添加失败");
        }
    }

    private void buttonResetTopMousePressed(MouseEvent e) {
        // 清空所有文本框
        textFieldDNameTop.setText("");
        textFieldJanTop.setText("");
        textFieldNameTop.setText("");
        textFieldPhoneTop.setText("");
        textFieldEmailTop.setText("");
        textFieldNumbersTop.setText("");
        textFieldStartTop.setText("");
        textFieldEpriceTop.setText("");
        textFieldWpriceTop.setText("");

    }

    private void buttonEditBottomMousePressed(MouseEvent e) {
        String id = textFieldIdBottom.getText();
        String dName = textFieldDNameBottom.getText();
        if (dName == null || dName.equals("")) {
            JOptionPane.showMessageDialog(this, "宿舍楼名称不能为空");
            return;
        }
        String name = textFieldNameBottom.getText();
        if (name == null || name.equals("")) {
            JOptionPane.showMessageDialog(this, "管理员姓名不能为空");
            return;
        }
        String phone = textFieldPhoneBottom.getText();
        if (phone == null || phone.equals("")) {
            JOptionPane.showMessageDialog(this, "管理员电话不能为空");
            return;
        }
        String email = textFieldEmailBottom.getText();
        if (email == null || email.equals("")) {
            JOptionPane.showMessageDialog(this, "管理员邮箱不能为空");
            return;
        }
        String ePrice = textFieldEPriceBottom.getText();
        if (ePrice == null || ePrice.equals("")) {
            JOptionPane.showMessageDialog(this, "电费单价不能为空");
            return;
        }
        // 小数
        if (!ePrice.matches("\\d+(\\.\\d+)?")) {
            JOptionPane.showMessageDialog(this, "电费单价必须为数字");
            return;
        }
        String wPrice = textFieldWPriceBottom.getText();
        if (wPrice == null || wPrice.equals("")) {
            JOptionPane.showMessageDialog(this, "水费单价不能为空");
            return;
        }
        // 小数
        if (!wPrice.matches("\\d+(\\.\\d+)?")) {
            JOptionPane.showMessageDialog(this, "水费单价必须为数字");
            return;
        }

        // 类型转换
        int idInt = Integer.parseInt(id);
        double ePriceDouble = Double.parseDouble(ePrice);
        double wPriceDouble = Double.parseDouble(wPrice);

        boolean b = dormitoryBuildingService.updateDormitoryBuilding(idInt, dName, name, phone, email, ePriceDouble, wPriceDouble);
        if (b) {
            JOptionPane.showMessageDialog(this, "修改成功");
            adminMainFrame.loadTable0Data();
        } else {
            JOptionPane.showMessageDialog(this, "修改失败");
        }
    }

    private void buttonResetBottomMousePressed(MouseEvent e) {
        // 清空所有文本框
        textFieldIdBottom.setText("");
        textFieldDNameBottom.setText("");
        textFieldNameBottom.setText("");
        textFieldPhoneBottom.setText("");
        textFieldEmailBottom.setText("");
        textFieldEPriceBottom.setText("");
        textFieldWPriceBottom.setText("");

    }

    private void buttonDeleteBottomMousePressed(MouseEvent e) {
        // 获取编号
        String id = textFieldIdBottom.getText();
        // 检查是否为空
        if (id == null || id.equals("")) {
            JOptionPane.showMessageDialog(this, "编号不能为空");
            return;
        }
        // 转换为整数
        int idInt = Integer.parseInt(id);
        // 判断该宿舍楼是否还有人住
        boolean b1 = dormitoryBuildingService.checkDormitoryBuildingHasPeople(idInt);
        if (b1) {
            JOptionPane.showMessageDialog(this, "该宿舍楼还有人住，不能删除");
            return;
        }
        // 删除
        boolean b2 = dormitoryBuildingService.deleteDormitoryBuilding(idInt);
        if (b2) {
            JOptionPane.showMessageDialog(this, "删除成功");
            adminMainFrame.loadTable0Data();
        } else {
            JOptionPane.showMessageDialog(this, "删除失败");
        }
    }

    public void loadDormitoryBuildingData(Integer dormitoryBuildingId) {
        DormitoryBuilding dormitoryBuilding = dormitoryBuildingService.getById(dormitoryBuildingId);
        textFieldIdBottom.setText(dormitoryBuilding.getId().toString());
        textFieldIdBottom.setEnabled(false);
        textFieldDNameBottom.setText(dormitoryBuilding.getName());
        textFieldNameBottom.setText(dormitoryBuilding.getLeaderName());
        textFieldPhoneBottom.setText(dormitoryBuilding.getLeaderPhone());
        textFieldEmailBottom.setText(dormitoryBuilding.getLeaderEmail());
        //
        BillingHistory billingHistory = billingHistoryService.selectByIdAndYearMonth(dormitoryBuildingId, LocalDateTimeUtil.now().getYear(), LocalDateTimeUtil.now().getMonthValue());
        if (billingHistory != null) {
            textFieldEPriceBottom.setText(billingHistory.getElectricityPrice().toString());
            textFieldWPriceBottom.setText(billingHistory.getWaterPrice().toString());
        } else {
            textFieldEPriceBottom.setText("");
            textFieldWPriceBottom.setText("");
        }
    }

    private void initComponents() {
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
        setTitle("更多宿舍楼管理功能");
        setResizable(false);
        var contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setBorder(new TitledBorder("新增宿舍楼"));

            //---- label1 ----
            label1.setText("宿舍楼名：");

            //---- label2 ----
            label2.setText("容量（间）：");

            //---- label3 ----
            label3.setText("管理员姓名：");

            //---- label4 ----
            label4.setText("管理员手机：");

            //---- label5 ----
            label5.setText("管理员邮箱：");

            //---- label6 ----
            label6.setText("1，2，3，4，5，6人间数量：");

            //---- textFieldNumbersTop ----
            textFieldNumbersTop.setToolTipText("格式：16,20,63,22,10,11");

            //---- label7 ----
            label7.setText("宿舍名（起始号）：");

            //---- textFieldStartTop ----
            textFieldStartTop.setToolTipText("例如：101");

            //---- label8 ----
            label8.setText("电价：");

            //---- label9 ----
            label9.setText("水价：");

            //---- buttonAddTop ----
            buttonAddTop.setText("新增");
            buttonAddTop.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    buttonAddTopMousePressed(e);
                }
            });

            //---- buttonResetTop ----
            buttonResetTop.setText("重置");
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
            panel2.setBorder(new TitledBorder("修改宿舍楼信息（需在宿舍楼表中选中后才会显示）"));

            //---- label10 ----
            label10.setText("编号：");

            //---- label11 ----
            label11.setText("宿舍楼名：");

            //---- label12 ----
            label12.setText("管理员姓名：");

            //---- label13 ----
            label13.setText("管理员手机：");

            //---- label14 ----
            label14.setText("管理员邮箱：");

            //---- buttonEditBottom ----
            buttonEditBottom.setText("修改");
            buttonEditBottom.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    buttonEditBottomMousePressed(e);
                }
            });

            //---- buttonResetBottom ----
            buttonResetBottom.setText("重置");
            buttonResetBottom.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    buttonResetBottomMousePressed(e);
                }
            });

            //---- label15 ----
            label15.setText("电价（从下个月开始生效）：");

            //---- label16 ----
            label16.setText("水价（从下个月开始生效）：");

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
        buttonDeleteBottom.setText("删除选中宿舍楼（危险！）");
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
    }


}
