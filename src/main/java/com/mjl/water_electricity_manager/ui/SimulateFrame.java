
package com.mjl.water_electricity_manager.ui;

import cn.hutool.core.date.LocalDateTimeUtil;
import com.mjl.water_electricity_manager.domain.BillingHistory;
import com.mjl.water_electricity_manager.domain.Dormitory;
import com.mjl.water_electricity_manager.domain.WaterElectricityConsumption;
import com.mjl.water_electricity_manager.service.BillingHistoryService;
import com.mjl.water_electricity_manager.service.DormitoryService;
import com.mjl.water_electricity_manager.service.WaterElectricityConsumptionService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;

@Component
public class SimulateFrame extends JFrame {


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

    @Resource
    private WaterElectricityConsumptionService waterElectricityConsumptionService;

    @Resource
    private BillingHistoryService billingHistoryService;

    @Resource
    private DormitoryService dormitoryService;

    public SimulateFrame() {
        initComponents();
    }

    private void buttonSimulateMousePressed(MouseEvent e) {
        String id = textFieldId.getText();
        String electricity = textFieldElectricity.getText();
        String water = textFieldWater.getText();

        if (!id.matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "宿舍编号必须为数字");
            return;
        }
        if (!electricity.matches("\\d+(\\.\\d+)?")) {
            JOptionPane.showMessageDialog(null, "电表度数须为数字");
            return;
        }

        if (!water.matches("\\d+(\\.\\d+)?")) {
            JOptionPane.showMessageDialog(null, "水表度数必须为数字");
            return;
        }

        WaterElectricityConsumption w = new WaterElectricityConsumption();
        w.setDormitoryId(Integer.parseInt(id));
        w.setElectricityConsume(BigDecimal.valueOf(Double.parseDouble(electricity)));
        w.setWaterConsume(BigDecimal.valueOf(Double.parseDouble(water)));
        boolean save = waterElectricityConsumptionService.save(w);
        if (save) {
            JOptionPane.showMessageDialog(null, "模拟成功");
        } else {
            JOptionPane.showMessageDialog(null, "模拟失败");
        }
    }

    private void buttonResetMousePressed(MouseEvent e) {
        textFieldId.setText("");
        textFieldElectricity.setText("");
        textFieldWater.setText("");
        textFieldCElectricity.setText("");
        textFieldCWater.setText("");
    }

    private void textFieldIdKeyTyped(KeyEvent e) {
        String id = textFieldId.getText();

        // 如果的整个字符串都是数字
        if (!id.matches("\\d+")) {
            return;
        }

        Dormitory dormitory = dormitoryService.getById(Integer.parseInt(id));
        if (dormitory == null) {
           return;
        }
        Integer year = LocalDateTimeUtil.now().getYear();
        Integer month = LocalDateTimeUtil.now().getMonthValue();
        BillingHistory billingHistory = billingHistoryService.selectByIdAndYearMonth(dormitory.getDormitoryBuildingId(), year, month);

        textFieldCElectricity.setText(billingHistory.getElectricityPrice().toString());
        textFieldCWater.setText(billingHistory.getWaterPrice().toString());

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
        setTitle("模拟用水用电");
        setResizable(false);
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("宿舍编号：");

        //---- textFieldId ----
        textFieldId.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                textFieldIdKeyTyped(e);
            }
        });

        //---- label2 ----
        label2.setText("用电量：");

        //---- label3 ----
        label3.setText("用水量：");

        //---- label4 ----
        label4.setText("当前电价：");

        //---- textFieldCElectricity ----
        textFieldCElectricity.setEditable(false);

        //---- label5 ----
        label5.setText("当前水价：");

        //---- textFieldCWater ----
        textFieldCWater.setEditable(false);

        //---- buttonSimulate ----
        buttonSimulate.setText("模拟");
        buttonSimulate.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                buttonSimulateMousePressed(e);
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

    }

}
