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
        // ?????????1,2,3,4,5,6
        String numbers = textFieldNumbersTop.getText();
        String start = textFieldStartTop.getText();
        String ePrice = textFieldEpriceTop.getText();
        String wPrice = textFieldWpriceTop.getText();

        // ???????????????
        String oneFloor = JOptionPane.showInputDialog("?????????????????????????????????");

        boolean b = dormitoryBuildingService.insertDormitoryBuilding(dName, jan, name, phone, email, numbers, start, ePrice, wPrice, oneFloor);
        if (b) {
            JOptionPane.showMessageDialog(this, "????????????");
            adminMainFrame.loadTable0Data();
        } else {
            JOptionPane.showMessageDialog(this, "????????????");
        }
    }

    private void buttonResetTopMousePressed(MouseEvent e) {
        // ?????????????????????
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
            JOptionPane.showMessageDialog(this, "???????????????????????????");
            return;
        }
        String name = textFieldNameBottom.getText();
        if (name == null || name.equals("")) {
            JOptionPane.showMessageDialog(this, "???????????????????????????");
            return;
        }
        String phone = textFieldPhoneBottom.getText();
        if (phone == null || phone.equals("")) {
            JOptionPane.showMessageDialog(this, "???????????????????????????");
            return;
        }
        String email = textFieldEmailBottom.getText();
        if (email == null || email.equals("")) {
            JOptionPane.showMessageDialog(this, "???????????????????????????");
            return;
        }
        String ePrice = textFieldEPriceBottom.getText();
        if (ePrice == null || ePrice.equals("")) {
            JOptionPane.showMessageDialog(this, "????????????????????????");
            return;
        }
        // ??????
        if (!ePrice.matches("\\d+(\\.\\d+)?")) {
            JOptionPane.showMessageDialog(this, "???????????????????????????");
            return;
        }
        String wPrice = textFieldWPriceBottom.getText();
        if (wPrice == null || wPrice.equals("")) {
            JOptionPane.showMessageDialog(this, "????????????????????????");
            return;
        }
        // ??????
        if (!wPrice.matches("\\d+(\\.\\d+)?")) {
            JOptionPane.showMessageDialog(this, "???????????????????????????");
            return;
        }

        // ????????????
        int idInt = Integer.parseInt(id);
        double ePriceDouble = Double.parseDouble(ePrice);
        double wPriceDouble = Double.parseDouble(wPrice);

        boolean b = dormitoryBuildingService.updateDormitoryBuilding(idInt, dName, name, phone, email, ePriceDouble, wPriceDouble);
        if (b) {
            JOptionPane.showMessageDialog(this, "????????????");
            adminMainFrame.loadTable0Data();
        } else {
            JOptionPane.showMessageDialog(this, "????????????");
        }
    }

    private void buttonResetBottomMousePressed(MouseEvent e) {
        // ?????????????????????
        textFieldIdBottom.setText("");
        textFieldDNameBottom.setText("");
        textFieldNameBottom.setText("");
        textFieldPhoneBottom.setText("");
        textFieldEmailBottom.setText("");
        textFieldEPriceBottom.setText("");
        textFieldWPriceBottom.setText("");

    }

    private void buttonDeleteBottomMousePressed(MouseEvent e) {
        // ????????????
        String id = textFieldIdBottom.getText();
        // ??????????????????
        if (id == null || id.equals("")) {
            JOptionPane.showMessageDialog(this, "??????????????????");
            return;
        }
        // ???????????????
        int idInt = Integer.parseInt(id);
        // ????????????????????????????????????
        boolean b1 = dormitoryBuildingService.checkDormitoryBuildingHasPeople(idInt);
        if (b1) {
            JOptionPane.showMessageDialog(this, "???????????????????????????????????????");
            return;
        }
        // ??????
        boolean b2 = dormitoryBuildingService.deleteDormitoryBuilding(idInt);
        if (b2) {
            JOptionPane.showMessageDialog(this, "????????????");
            adminMainFrame.loadTable0Data();
        } else {
            JOptionPane.showMessageDialog(this, "????????????");
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
        setTitle("???????????????????????????");
        setResizable(false);
        var contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setBorder(new TitledBorder("???????????????"));

            //---- label1 ----
            label1.setText("???????????????");

            //---- label2 ----
            label2.setText("??????????????????");

            //---- label3 ----
            label3.setText("??????????????????");

            //---- label4 ----
            label4.setText("??????????????????");

            //---- label5 ----
            label5.setText("??????????????????");

            //---- label6 ----
            label6.setText("1???2???3???4???5???6???????????????");

            //---- textFieldNumbersTop ----
            textFieldNumbersTop.setToolTipText("?????????16,20,63,22,10,11");

            //---- label7 ----
            label7.setText("???????????????????????????");

            //---- textFieldStartTop ----
            textFieldStartTop.setToolTipText("?????????101");

            //---- label8 ----
            label8.setText("?????????");

            //---- label9 ----
            label9.setText("?????????");

            //---- buttonAddTop ----
            buttonAddTop.setText("??????");
            buttonAddTop.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    buttonAddTopMousePressed(e);
                }
            });

            //---- buttonResetTop ----
            buttonResetTop.setText("??????");
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
            panel2.setBorder(new TitledBorder("?????????????????????????????????????????????????????????????????????"));

            //---- label10 ----
            label10.setText("?????????");

            //---- label11 ----
            label11.setText("???????????????");

            //---- label12 ----
            label12.setText("??????????????????");

            //---- label13 ----
            label13.setText("??????????????????");

            //---- label14 ----
            label14.setText("??????????????????");

            //---- buttonEditBottom ----
            buttonEditBottom.setText("??????");
            buttonEditBottom.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    buttonEditBottomMousePressed(e);
                }
            });

            //---- buttonResetBottom ----
            buttonResetBottom.setText("??????");
            buttonResetBottom.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    buttonResetBottomMousePressed(e);
                }
            });

            //---- label15 ----
            label15.setText("???????????????????????????????????????");

            //---- label16 ----
            label16.setText("???????????????????????????????????????");

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
        buttonDeleteBottom.setText("????????????????????????????????????");
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
