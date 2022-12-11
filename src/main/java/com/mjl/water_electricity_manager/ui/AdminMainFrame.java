package com.mjl.water_electricity_manager.ui;

import cn.hutool.crypto.digest.DigestUtil;
import com.mjl.water_electricity_manager.domain.Dormitory;
import com.mjl.water_electricity_manager.domain.DormitoryBuilding;
import com.mjl.water_electricity_manager.domain.User;
import com.mjl.water_electricity_manager.domain.UserType;
import com.mjl.water_electricity_manager.service.*;
import org.springframework.context.annotation.Lazy;
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
import java.util.List;
import java.util.Objects;

@Component
public class AdminMainFrame extends JFrame {


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


    private DefaultTableModel tableModel0;
    private DefaultTableModel tableModel1Top;
    private DefaultTableModel tableModel1Bottom;
    private DefaultTableModel tableModel2;

    private DefaultTableCellRenderer tableCellRenderer;

    private Integer currentDormitoryId;
    private Integer currentDormitoryBuildingId;
    @Resource
    private DormitoryBuildingService dormitoryBuildingService;


    @Resource
    private DormitoryService dormitoryService;

    @Resource
    private UserService userService;

    @Resource
    private BillingHistoryService billingHistoryService;

    @Resource
    private UserTypeService userTypeService;

    @Resource
    @Lazy
    private OtherDormitoryBuildingControlFrame otherDormitoryBuildingControlFrame;



    public AdminMainFrame() {
        initComponents();
    }

    private void button0SearchMousePressed(MouseEvent e) {
        // 获取输入的值
        String id = textField0Id.getText();
        String dName = textField0dName.getText();
        String name = textField0Name.getText();
        String phone = textField0Phone.getText();
        String email = textField0Email.getText();
        int renL = (int) spinner0renL.getValue();
        int renR = (int) spinner0renR.getValue();
        int janL = (int) spinner0janL.getValue();
        int janR = (int) spinner0janR.getValue();

        // 查询
        List<DormitoryBuilding> dormitoryBuildings = dormitoryBuildingService.selectDormitoryBuilding(id, dName, name, phone, email, renL, renR, janL, janR);

        // 清空表格
        tableModel0.setRowCount(0);

        // 将查询结果显示到表格中
        for (DormitoryBuilding dormitoryBuilding : dormitoryBuildings) {
            tableModel0.addRow(new Object[]{
                    dormitoryBuilding.getId(),
                    dormitoryBuilding.getName(),
                    dormitoryBuilding.getTotalCapacity(),
                    dormitoryBuilding.getOccupiedCapacity(),
                    dormitoryBuilding.getTotalRoomNumber(),
                    dormitoryBuilding.getOccupiedRoomNumber(),
                    dormitoryBuilding.getLeaderName(),
                    dormitoryBuilding.getLeaderPhone(),
                    dormitoryBuilding.getLeaderEmail()
            });
        }

    }

    private void button0ResetMousePressed(MouseEvent e) {
        // 清空输入框
        textField0Id.setText("");
        textField0dName.setText("");
        textField0Name.setText("");
        textField0Phone.setText("");
        textField0Email.setText("");
        spinner0renL.setValue(0);
        spinner0renR.setValue(0);
        spinner0janL.setValue(0);
        spinner0janR.setValue(0);
        loadTable0Data();
    }

    private void button0OtherMousePressed(MouseEvent e) {
        otherDormitoryBuildingControlFrame.setVisible(true);
    }

    private void button1SearchTopMousePressed(MouseEvent e) {
        // 获取输入的值
        String id = textField1IdTop.getText();
        String name = textField1NameTop.getText();

        // 查询
        List<Dormitory> dormitories = dormitoryService.selectDormitory(id, name);

        // 清空表格
        tableModel1Top.setRowCount(0);

        // 将查询结果显示到表格中
        for (Dormitory dormitory : dormitories) {
            tableModel1Top.addRow(new Object[]{
                    dormitory.getId(),
                    dormitory.getName(),
                    dormitory.getCapacity(),
                    dormitory.getOccupied()
            });
        }

    }

    private void button1AddTopMousePressed(MouseEvent e) {
        // 弹出对话框询问要添加的宿舍宿舍名，容量，所属宿舍楼
        String dormitoryName = JOptionPane.showInputDialog("请输入宿舍名");
        String capacity = JOptionPane.showInputDialog("请输入容量");
        String dormitoryBuildingId = JOptionPane.showInputDialog("请输入所属宿舍楼id");

        // 判断输入是否为空
        if (dormitoryName == null || capacity == null || dormitoryBuildingId == null) {
            JOptionPane.showMessageDialog(null, "输入不能为空");
            return;
        }

        // 判断输入是否合法
        if (!capacity.matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "容量必须为数字");
            return;
        }

        // 容量只能1-6
        if (Integer.parseInt(capacity) < 1 || Integer.parseInt(capacity) > 6) {
            JOptionPane.showMessageDialog(null, "容量只能为1-6");
            return;
        }

        // 判断输入是否合法
        if (!dormitoryBuildingId.matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "宿舍楼id必须为数字");
            return;
        }
        // 添加
        boolean b = dormitoryService.insertDormitory(dormitoryName, Integer.parseInt(capacity), Integer.parseInt(dormitoryBuildingId));

        // 判断是否添加成功
        if (b) {
            JOptionPane.showMessageDialog(null, "添加成功");
            button0SearchMousePressed(null);
            loadTable1TopData(currentDormitoryBuildingId);
        } else {
            JOptionPane.showMessageDialog(null, "添加失败");
        }

    }

    private void button1EditTopMousePressed(MouseEvent e) {
        // 获取选中的行
        int selectedRow = table1top.getSelectedRow();

        // 判断是否选中
        if (selectedRow == -1 || selectedRow >= tableModel1Top.getRowCount()) {
            JOptionPane.showMessageDialog(null, "请选中要修改的宿舍");
            return;
        }

        // 获取选中的宿舍id
        Integer dormitoryId = (Integer) tableModel1Top.getValueAt(selectedRow, 0);

        // 弹出对话框询问要修改的宿舍名，容量
        String dormitoryName = JOptionPane.showInputDialog("请输入宿舍名", tableModel1Top.getValueAt(selectedRow, 1));
        String capacity = JOptionPane.showInputDialog("请输入容量", tableModel1Top.getValueAt(selectedRow, 2));

        // 判断输入是否为空
        if (dormitoryName == null || capacity == null) {
            JOptionPane.showMessageDialog(null, "输入不能为空");
            return;
        }

        // 判断输入是否合法
        if (!capacity.matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "容量必须为数字");
            return;
        }

        // 容量只能1-6
        if (Integer.parseInt(capacity) < 1 || Integer.parseInt(capacity) > 6) {
            JOptionPane.showMessageDialog(null, "容量只能为1-6");
            return;
        }

        Dormitory dormitory1 = dormitoryService.getById(dormitoryId);

        dormitory1.setCapacity(Integer.parseInt(capacity));
        dormitory1.setName(dormitoryName);


        // 修改
        boolean b = dormitoryService.updateById(dormitory1);

        // 判断是否修改成功
        if (b) {
            JOptionPane.showMessageDialog(null, "修改成功");
            button0SearchMousePressed(null);
            loadTable1TopData(currentDormitoryBuildingId);
        } else {
            JOptionPane.showMessageDialog(null, "修改失败");
        }

    }

    private void button1DeleteTopMousePressed(MouseEvent e) {
        //获取选中行编号
        int selectedRow = table1top.getSelectedRow();
        //判断是否选中
        if (selectedRow == -1 || selectedRow >= tableModel1Top.getRowCount()) {
            JOptionPane.showMessageDialog(null, "请选择要删除的宿舍");
            return;
        }
        //获取选中行的宿舍id
        Integer id = (Integer) tableModel1Top.getValueAt(selectedRow, 0);

        boolean b = dormitoryService.removeById(id);
        //判断是否删除成功
        if (b) {
            JOptionPane.showMessageDialog(null, "删除成功");
            button0SearchMousePressed(null);
            loadTable1TopData(currentDormitoryBuildingId);
        } else {
            JOptionPane.showMessageDialog(null, "删除失败");
        }


    }

    private void button1SearchBottomMousePressed(MouseEvent e) {
        // 获取输入的值
        String id = textField1IdBottom.getText();
        String name = textField1NameBottom.getText();

        // 查询
        List<User> users = userService.selectUser(id, name, currentDormitoryId);

        // 清空表格
        tableModel1Bottom.setRowCount(0);

        // 将查询结果显示到表格中
        for (User user : users) {
            tableModel1Bottom.addRow(new Object[]{
                    user.getId(), user.getName(),
                    Objects.equals(user.getGender(), "M") ? "男" : "女", user.getAge(),
                    user.getEmail(), user.getPhone(), user.getPassword()}
            );
        }

    }

    private void button1AddBottomMousePressed(MouseEvent e) {

        // 弹出对话框询问要添加的学生id
        String userId = JOptionPane.showInputDialog("请输入学生id");

        // 判断输入是否为空
        if (userId == null) {
            JOptionPane.showMessageDialog(null, "输入不能为空");
            return;
        }

        // 判断输入是否合法
        if (!userId.matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "学生id必须为数字");
            return;
        }

        // 判断学生是否存在
        User user = userService.getById(Integer.parseInt(userId));
        if (user == null) {
            JOptionPane.showMessageDialog(null, "学生不存在");
            return;
        }

        // 判断学生是否已经有宿舍
        if (user.getDormitoryId() != null) {
            JOptionPane.showMessageDialog(null, "学生已经有宿舍，宿舍id为" + user.getDormitoryId());
            return;
        }

        // 判断宿舍是否已经满员
        Dormitory dormitory = dormitoryService.getById(currentDormitoryId);
        if (dormitory.getCapacity() <= dormitory.getOccupied()) {
            JOptionPane.showMessageDialog(null, "宿舍已经满员");
            return;
        }

        // 添加
        user.setDormitoryId(currentDormitoryId);
        try {
            userService.updateUserById(user);
            JOptionPane.showMessageDialog(null, "添加成功");
            button1SearchBottomMousePressed(null);
            button2SearchMousePressed(null);
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "添加失败");
        }

    }

    private void button1EditBottomMousePressed(MouseEvent e) {
        // 获取选中行编号
        int selectedRow = table1bottom.getSelectedRow();
        // 判断是否选中
        if (selectedRow == -1 || selectedRow >= tableModel1Bottom.getRowCount()) {
            JOptionPane.showMessageDialog(null, "请选择要修改的学生");
            return;
        }

        // 获取选中行的学生id
        Integer id = (Integer) tableModel1Bottom.getValueAt(selectedRow, 0);


        User user = userService.getById(id);
        // 弹出对话框询问要修改的学生信息
        String name = JOptionPane.showInputDialog("请输入学生姓名", user.getName());
        if (name == null) {
            JOptionPane.showMessageDialog(null, "学生姓名不能为空");
            return;
        }
        String userTypeId = JOptionPane.showInputDialog("请输入学生类型id", user.getUserTypeId());
        if (userTypeId == null) {
            JOptionPane.showMessageDialog(null, "学生类型id不能为空");
            return;
        }
        String gender = JOptionPane.showInputDialog("请输入学生性别:M为男，F为女", user.getGender());
        if (gender == null) {
            JOptionPane.showMessageDialog(null, "学生性别不能为空");
            return;
        }
        if (!gender.equals("F") && !gender.equals("M")) {
            JOptionPane.showMessageDialog(null, "学生性别必须为M或F");
            return;
        }
        String age = JOptionPane.showInputDialog("请输入学生年龄", user.getAge());
        if (age == null) {
            JOptionPane.showMessageDialog(null, "学生年龄不能为空");
            return;
        }
        if (!age.matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "学生年龄必须为数字");
            return;
        }
        String email = JOptionPane.showInputDialog("请输入学生邮箱", user.getEmail());
        if (email == null) {
            JOptionPane.showMessageDialog(null, "学生邮箱不能为空");
            return;
        }
        String phone = JOptionPane.showInputDialog("请输入学生电话", user.getPhone());
        if (phone == null) {
            JOptionPane.showMessageDialog(null, "学生电话不能为空");
            return;
        }
        String password = JOptionPane.showInputDialog("请输入学生密码", "");
        if (password == null) {
            JOptionPane.showMessageDialog(null, "学生密码不能为空");
            return;
        }
        String dormitoryId = JOptionPane.showInputDialog("请输入学生宿舍id", user.getDormitoryId());
        if (dormitoryId == null) {
            JOptionPane.showMessageDialog(null, "学生宿舍id不能为空");
            return;
        }

        // 判断学生类型是否有修改
        if (!userTypeId.equals(user.getUserTypeId().toString())) {
            // 判断学生类型是否存在
            UserType userType = userTypeService.getById(userTypeId);
            if (userType == null) {
                JOptionPane.showMessageDialog(null, "学生类型不存在");
                return;
            }
        }

        // 判断学生宿舍id是否有修改，如果有修改，判断修改后的宿舍是否存在
        if (!dormitoryId.equals(user.getDormitoryId().toString())) {
            Dormitory dormitory = dormitoryService.getById(Integer.parseInt(dormitoryId));
            if (dormitory == null) {
                JOptionPane.showMessageDialog(null, "学生宿舍id不存在");
                return;
            }
        }

        // 判断宿舍是否已经满员
        Dormitory dormitory = dormitoryService.getById(currentDormitoryId);
        if (dormitory.getCapacity() <= dormitory.getOccupied()) {
            JOptionPane.showMessageDialog(null, "宿舍已经满员");
            return;
        }

        // 修改
        user.setName(name);
        user.setAge(Integer.parseInt(age));
        user.setUserTypeId(Integer.parseInt(userTypeId));
        user.setPassword(DigestUtil.md5Hex(password));
        user.setDormitoryId(Integer.parseInt(dormitoryId));
        user.setEmail(email);
        user.setGender(gender);
        user.setPhone(phone);
        try {
            userService.updateUserById(user);
            JOptionPane.showMessageDialog(null, "修改成功");
            button1SearchBottomMousePressed(null);
            button2SearchMousePressed(null);
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "修改失败");
        }

    }

    private void button1DeleteBottomMousePressed(MouseEvent e) {
        // 获取选中行
        int selectedRow = table1bottom.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "请选择要删除的学生");
            return;
        }

        // 获取选中行的学生id
        Integer id = (Integer) tableModel1Bottom.getValueAt(selectedRow, 0);

        // 弹出确认框
        int result = JOptionPane.showConfirmDialog(null, "确定要删除学生吗？");
        if (result == JOptionPane.YES_OPTION) {
            try {
                userService.deleteUserById(id);
                JOptionPane.showMessageDialog(null, "删除成功");
                button0SearchMousePressed(null);
                button1SearchTopMousePressed(null);
                button1SearchBottomMousePressed(null);
                button2SearchMousePressed(null);
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "删除失败");
            }
        }
    }

    private void button2SearchMousePressed(MouseEvent e) {
        // 获取输入的值
        String id = textField2Id.getText();
        String name = textField2Name.getText();
        String type = textField2Type.getText();
        String gender = textField2Gender.getText();
        Integer ageL = (Integer) spinner2ageL.getValue();
        Integer ageR = (Integer) spinner2ageR.getValue();
        String phone = textField2Phone.getText();
        String email = textField2Email.getText();
        String dormitory = textField2Dormitory.getText();

        // 查询
        List<User> users = userService.selectUser(id, name, type, gender, ageL, ageR, phone, email, dormitory);

        // 清空表格
        tableModel2.setRowCount(0);

        // 将查询结果显示到表格中
        for (User user : users) {
            UserType userType = userTypeService.getById(user.getUserTypeId());
            Dormitory dormitory1 = dormitoryService.getById(user.getDormitoryId());
            tableModel2.addRow(new Object[]{
                    user.getId(), user.getName(),
                    userType.getName(),
                    Objects.equals(user.getGender(), "M") ? "男" : "女", user.getAge(),
                    user.getEmail(), user.getPhone(), user.getPassword(),
                    dormitory1.getName()}
            );
        }

    }

    private void button2AddMousePressed(MouseEvent e) {
        String name = JOptionPane.showInputDialog("请输入学生姓名", "");
        if (name == null) {
            JOptionPane.showMessageDialog(null, "学生姓名不能为空");
            return;
        }
        String userTypeId = JOptionPane.showInputDialog("请输入学生类型id", "");
        if (userTypeId == null) {
            JOptionPane.showMessageDialog(null, "学生类型id不能为空");
            return;
        }
        // 判断学生类型是否存在
        UserType userType = userTypeService.getById(Integer.parseInt(userTypeId));
        if (userType == null) {
            JOptionPane.showMessageDialog(null, "学生类型不存在");
            return;
        }
        String gender = JOptionPane.showInputDialog("请输入学生性别:M为男，F为女", "");
        if (gender == null) {
            JOptionPane.showMessageDialog(null, "学生性别不能为空");
            return;
        }
        if (!gender.equals("F") && !gender.equals("M")) {
            JOptionPane.showMessageDialog(null, "学生性别必须为M或F");
            return;
        }
        String age = JOptionPane.showInputDialog("请输入学生年龄", "");
        if (age == null) {
            JOptionPane.showMessageDialog(null, "学生年龄不能为空");
            return;
        }
        if (!age.matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "学生年龄必须为数字");
            return;
        }
        String email = JOptionPane.showInputDialog("请输入学生邮箱", "");
        if (email == null) {
            JOptionPane.showMessageDialog(null, "学生邮箱不能为空");
            return;
        }
        String phone = JOptionPane.showInputDialog("请输入学生电话", "");
        if (phone == null) {
            JOptionPane.showMessageDialog(null, "学生电话不能为空");
            return;
        }
        String password = JOptionPane.showInputDialog("请输入学生密码", "");
        if (password == null) {
            JOptionPane.showMessageDialog(null, "学生密码不能为空");
            return;
        }
        String dormitoryId = JOptionPane.showInputDialog("请输入学生宿舍id", "");
        if (Objects.equals(dormitoryId, "")) {
            dormitoryId = null;
        }

        User user = User.builder().name(name)
                .password(DigestUtil.md5Hex(password))
                .age(Integer.parseInt(age))
                .dormitoryId(dormitoryId == null ? null : Integer.parseInt(dormitoryId))
                .phone(phone)
                .email(email)
                .userTypeId(Integer.parseInt(userTypeId))
                .gender(gender)
                .build();

        try {
            userService.insertUser(user);
            JOptionPane.showMessageDialog(null, "添加成功");
            button0SearchMousePressed(null);
            button1SearchTopMousePressed(null);
            button1SearchBottomMousePressed(null);
            button2SearchMousePressed(null);
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "添加失败");
        }
    }

    private void button2EditMousePressed(MouseEvent e) {
        // 获取选中行编号
        int selectedRow = table2Bottom.getSelectedRow();
        // 判断是否选中
        if (selectedRow == -1 || selectedRow >= tableModel2.getRowCount()) {
            JOptionPane.showMessageDialog(null, "请选择要修改的学生");
            return;
        }

        // 获取选中行的学生id
        Integer id = (Integer) tableModel2.getValueAt(selectedRow, 0);


        User user = userService.getById(id);
        // 弹出对话框询问要修改的学生信息
        String name = JOptionPane.showInputDialog("请输入学生姓名", user.getName());
        if (name == null) {
            JOptionPane.showMessageDialog(null, "学生姓名不能为空");
            return;
        }
        String userTypeId = JOptionPane.showInputDialog("请输入学生类型id", user.getUserTypeId());
        if (userTypeId == null) {
            JOptionPane.showMessageDialog(null, "学生类型id不能为空");
            return;
        }
        String gender = JOptionPane.showInputDialog("请输入学生性别:M为男，F为女", user.getGender());
        if (gender == null) {
            JOptionPane.showMessageDialog(null, "学生性别不能为空");
            return;
        }
        if (!gender.equals("F") && !gender.equals("M")) {
            JOptionPane.showMessageDialog(null, "学生性别必须为M或F");
            return;
        }
        String age = JOptionPane.showInputDialog("请输入学生年龄", user.getAge());
        if (age == null) {
            JOptionPane.showMessageDialog(null, "学生年龄不能为空");
            return;
        }
        if (!age.matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "学生年龄必须为数字");
            return;
        }
        String email = JOptionPane.showInputDialog("请输入学生邮箱", user.getEmail());
        if (email == null) {
            JOptionPane.showMessageDialog(null, "学生邮箱不能为空");
            return;
        }
        String phone = JOptionPane.showInputDialog("请输入学生电话", user.getPhone());
        if (phone == null) {
            JOptionPane.showMessageDialog(null, "学生电话不能为空");
            return;
        }
        String password = JOptionPane.showInputDialog("请输入学生密码", "");
        if (password == null) {
            JOptionPane.showMessageDialog(null, "学生密码不能为空");
            return;
        }
        String dormitoryId = JOptionPane.showInputDialog("请输入学生宿舍id", user.getDormitoryId());
        if (dormitoryId == null) {
            JOptionPane.showMessageDialog(null, "学生宿舍id不能为空");
            return;
        }

        // 判断学生类型是否有修改
        if (!userTypeId.equals(user.getUserTypeId().toString())) {
            // 判断学生类型是否存在
            UserType userType = userTypeService.getById(userTypeId);
            if (userType == null) {
                JOptionPane.showMessageDialog(null, "学生类型不存在");
                return;
            }
        }

        // 判断学生宿舍id是否有修改，如果有修改，判断修改后的宿舍是否存在
        if (!dormitoryId.equals(user.getDormitoryId().toString())) {
            Dormitory dormitory = dormitoryService.getById(Integer.parseInt(dormitoryId));
            if (dormitory == null) {
                JOptionPane.showMessageDialog(null, "学生宿舍id不存在");
                return;
            }
        }

        // 判断宿舍是否已经满员
        Dormitory dormitory = dormitoryService.getById(currentDormitoryId);
        if (dormitory.getCapacity() <= dormitory.getOccupied()) {
            JOptionPane.showMessageDialog(null, "宿舍已经满员");
            return;
        }

        // 修改
        user.setName(name);
        user.setAge(Integer.parseInt(age));
        user.setUserTypeId(Integer.parseInt(userTypeId));
        user.setPassword(DigestUtil.md5Hex(password));
        user.setDormitoryId(Integer.parseInt(dormitoryId));
        user.setEmail(email);
        user.setGender(gender);
        user.setPhone(phone);
        try {
            userService.updateUserById(user);
            JOptionPane.showMessageDialog(null, "修改成功");
            button1SearchBottomMousePressed(null);
            button2SearchMousePressed(null);
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "修改失败");
        }
    }

    private void button2DeleteMousePressed(MouseEvent e) {
        // 获取选中行
        int selectedRow = table2Bottom.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "请选择要删除的学生");
            return;
        }

        // 获取选中行的学生id
        Integer id = (Integer) tableModel2.getValueAt(selectedRow, 0);

        // 弹出确认框
        int result = JOptionPane.showConfirmDialog(null, "确定要删除学生吗？");
        if (result == JOptionPane.YES_OPTION) {
            try {
                userService.deleteUserById(id);
                JOptionPane.showMessageDialog(null, "删除成功");
                button0SearchMousePressed(null);
                button1SearchTopMousePressed(null);
                button1SearchBottomMousePressed(null);
                button2SearchMousePressed(null);
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "删除失败");
            }
        }
    }


    private void table1topMousePressed(MouseEvent e) {
        // 获取选中行编号
        int row = table1top.getSelectedRow();
        Integer id = (Integer) table1top.getValueAt(row, 0);
        loadTable1BottomData(id);
    }

    private void table0bottomMousePressed(MouseEvent e) {
        // 获取选中行的编号
        int row = table0bottom.getSelectedRow();
        Integer id = (Integer) tableModel0.getValueAt(row, 0);
        loadTable1TopData(id);
        otherDormitoryBuildingControlFrame.loadDormitoryBuildingData(id);
    }

    private void thisComponentShown(ComponentEvent e) {
        loadTable0Data();
        loadTable2Data();
    }

    public void loadTable0Data() {
        tableModel0.setRowCount(0);
        List<DormitoryBuilding> dormitoryBuildings = dormitoryBuildingService.list();
        for (DormitoryBuilding dormitoryBuilding : dormitoryBuildings) {
            tableModel0.addRow(new Object[]{
                    dormitoryBuilding.getId(),
                    dormitoryBuilding.getName(),
                    dormitoryBuilding.getTotalCapacity(),
                    dormitoryBuilding.getOccupiedCapacity(),
                    dormitoryBuilding.getTotalRoomNumber(),
                    dormitoryBuilding.getOccupiedRoomNumber(),
                    dormitoryBuilding.getLeaderName(),
                    dormitoryBuilding.getLeaderPhone(),
                    dormitoryBuilding.getLeaderEmail()
            });
        }
    }

    public void loadTable1TopData(Integer dormitoryBuildingId) {
        currentDormitoryBuildingId = dormitoryBuildingId;
        tableModel1Top.setRowCount(0);
        List<Dormitory> dormitories = dormitoryService.selectDormitoryByDormitoryBuildingId(dormitoryBuildingId);
        for (Dormitory dormitory : dormitories) {
            tableModel1Top.addRow(new Object[]{
                    dormitory.getId(),
                    dormitory.getName(),
                    dormitory.getCapacity(),
                    dormitory.getOccupied(),
            });
        }
    }

    public void loadTable1BottomData(Integer dormitoryId) {
        currentDormitoryId = dormitoryId;
        tableModel1Bottom.setRowCount(0);
        List<User> users = userService.searchByDormitoryId(dormitoryId);
        for (User user : users) {
            tableModel1Bottom.addRow(new Object[]{
                    user.getId(), user.getName(),
                    Objects.equals(user.getGender(), "M") ? "男" : "女", user.getAge(),
                    user.getEmail(), user.getPhone(), user.getPassword()}
            );
        }
    }

    public void loadTable2Data() {
        tableModel2.setRowCount(0);
        List<User> users = userService.list();

        for (User user : users) {
            UserType userType = userTypeService.getById(user.getUserTypeId());
            Dormitory dormitory = dormitoryService.getById(user.getDormitoryId());
            tableModel2.addRow(new Object[]{
                    user.getId(), user.getName(),
                    userType.getName(),
                    Objects.equals(user.getGender(), "M") ? "男" : "女", user.getAge(),
                    user.getEmail(), user.getPhone(), user.getPassword(),
                    dormitory.getName()}
            );
        }
    }

    private void initComponents() {
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
        tableCellRenderer = new DefaultTableCellRenderer();
        tableCellRenderer.setHorizontalAlignment(JLabel.CENTER);

        //======== this ========
        setTitle("管理员主界面");
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                thisComponentShown(e);
            }
        });
        var contentPane = getContentPane();

        //======== tabbedPane1 ========
        {

            //======== panel1 ========
            {

                //======== panel3 ========
                {
                    panel3.setBorder(new TitledBorder("检索"));

                    //---- label1 ----
                    label1.setText("编号：");

                    //---- label2 ----
                    label2.setText("宿舍楼名：");

                    //---- label3 ----
                    label3.setText("管理员姓名：");

                    //---- label4 ----
                    label4.setText("管理员手机：");

                    //---- label5 ----
                    label5.setText("管理员邮箱：");

                    //---- label6 ----
                    label6.setText("容量（人）区间：");

                    //---- label7 ----
                    label7.setText("到");

                    //---- label8 ----
                    label8.setText("容量（间）区间：");

                    //---- label9 ----
                    label9.setText("到");

                    //---- button0Search ----
                    button0Search.setText("检索");
                    button0Search.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mousePressed(MouseEvent e) {
                            button0SearchMousePressed(e);
                        }
                    });

                    //---- button0Reset ----
                    button0Reset.setText("重置");
                    button0Reset.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mousePressed(MouseEvent e) {
                            button0ResetMousePressed(e);
                        }
                    });

                    //---- button0Other ----
                    button0Other.setText("其它");
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
                    //---- table0bottom ----
                    tableModel0 = new DefaultTableModel(
                            new Object[][]{
                                    {null, null, null, null, null, null, null, null, null},
                            },
                            new String[]{
                                    "编号", "宿舍楼名", "总容量（人）", "已住（人）", "总容量（间）", "已住（间）", "管理员姓名", "管理员手机", "管理员邮箱"
                            }
                    ) {
                        Class<?>[] columnTypes = new Class<?>[]{
                                Integer.class, String.class, Integer.class, Integer.class, Integer.class, Integer.class, String.class, String.class, String.class
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
                    table0bottom.setModel(tableModel0);
                    table0bottom.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mousePressed(MouseEvent e) {
                            table0bottomMousePressed(e);
                        }
                    });
                    table0bottom.setDefaultRenderer(String.class, tableCellRenderer);
                    table0bottom.setDefaultRenderer(Integer.class, tableCellRenderer);
                    scrollPane1.setViewportView(table0bottom);
                }

                GroupLayout panel1Layout = new GroupLayout(panel1);
                panel1.setLayout(panel1Layout);
                panel1Layout.setHorizontalGroup(
                        panel1Layout.createParallelGroup()
                                .addGroup(panel1Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(panel1Layout.createParallelGroup()
                                                .addComponent(panel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            tabbedPane1.addTab("宿舍楼管理", panel1);

            //======== panel2 ========
            {

                //======== panel4 ========
                {
                    panel4.setBorder(new TitledBorder("宿舍人员信息（在上面选中宿舍后显示）"));

                    //======== scrollPane2 ========
                    {

                        //---- table1bottom ----
                        tableModel1Bottom = new DefaultTableModel(
                                new Object[][]{
                                        {null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null},
                                },
                                new String[]{
                                        "编号", "姓名", "性别", "年龄", "邮箱", "手机号", "密码"
                                }
                        ) {
                            Class<?>[] columnTypes = new Class<?>[]{
                                    Integer.class, String.class, String.class, Integer.class, String.class, String.class, String.class
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
                        scrollPane2.setViewportView(table1bottom);
                        table1bottom.setModel(tableModel1Bottom);
                        table1bottom.setDefaultRenderer(String.class, tableCellRenderer);
                        table1bottom.setDefaultRenderer(Integer.class, tableCellRenderer);
                    }

                    //---- label12 ----
                    label12.setText("编号：");

                    //---- label13 ----
                    label13.setText("姓名：");

                    //---- button1SearchBottom ----
                    button1SearchBottom.setText("检索");
                    button1SearchBottom.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mousePressed(MouseEvent e) {
                            button1SearchBottomMousePressed(e);
                        }
                    });

                    //---- button1AddBottom ----
                    button1AddBottom.setText("新增");
                    button1AddBottom.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mousePressed(MouseEvent e) {
                            button1AddBottomMousePressed(e);
                        }
                    });

                    //---- button1EditBottom ----
                    button1EditBottom.setText("修改");
                    button1EditBottom.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mousePressed(MouseEvent e) {
                            button1EditBottomMousePressed(e);
                        }
                    });

                    //---- button1DeleteBottom ----
                    button1DeleteBottom.setText("删除");
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
                    panel5.setBorder(new TitledBorder("宿舍信息"));

                    //======== scrollPane3 ========
                    {
                        //---- table1top ----
                        tableModel1Top = new DefaultTableModel(
                                new Object[][]{
                                        {null, null, null, null},
                                        {null, null, null, null},
                                },
                                new String[]{
                                        "编号", "宿舍名", "容量（人）", "已住（人）"
                                }
                        ) {
                            Class<?>[] columnTypes = new Class<?>[]{
                                    Integer.class, String.class, Integer.class, Integer.class
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
                        table1top.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mousePressed(MouseEvent e) {
                                table1topMousePressed(e);
                            }
                        });
                        table1top.setModel(tableModel1Top);
                        table1top.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                        table1top.setDefaultRenderer(Integer.class, tableCellRenderer);
                        table1top.setDefaultRenderer(String.class, tableCellRenderer);
                        scrollPane3.setViewportView(table1top);
                    }

                    //---- button1AddTop ----
                    button1AddTop.setText("新增");
                    button1AddTop.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mousePressed(MouseEvent e) {
                            button1AddTopMousePressed(e);
                        }
                    });

                    //---- button1EditTop ----
                    button1EditTop.setText("修改");
                    button1EditTop.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mousePressed(MouseEvent e) {
                            button1EditTopMousePressed(e);
                        }
                    });

                    //---- button1DeleteTop ----
                    button1DeleteTop.setText("删除");
                    button1DeleteTop.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mousePressed(MouseEvent e) {
                            button1DeleteTopMousePressed(e);
                        }
                    });

                    //---- label10 ----
                    label10.setText("编号：");

                    //---- label11 ----
                    label11.setText("宿舍名：");

                    //---- button1SearchTop ----
                    button1SearchTop.setText("检索");
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
            tabbedPane1.addTab("宿舍管理", panel2);

            //======== panel6 ========
            {

                //======== panel7 ========
                {
                    panel7.setBorder(new TitledBorder("人员管理"));

                    //======== scrollPane4 ========
                    {

                        //---- table2Bottom ----
                        tableModel2 = new DefaultTableModel(
                                new Object[][]{
                                        {null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null},
                                },
                                new String[]{
                                        "编号", "姓名", "用户类型", "性别", "年龄", "邮箱", "手机号", "密码", "宿舍"
                                }
                        ) {
                            Class<?>[] columnTypes = new Class<?>[]{
                                    Integer.class, String.class, String.class, String.class, Integer.class, String.class, String.class, String.class, String.class
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
                        scrollPane4.setViewportView(table2Bottom);
                        table2Bottom.setModel(tableModel2);
                        table2Bottom.setDefaultRenderer(Integer.class, tableCellRenderer);
                        table2Bottom.setDefaultRenderer(String.class, tableCellRenderer);

                    }

                    //---- label14 ----
                    label14.setText("编号：");

                    //---- label15 ----
                    label15.setText("姓名：");

                    //---- label16 ----
                    label16.setText("用户类型：");

                    //---- label17 ----
                    label17.setText("性别：");

                    //---- label18 ----
                    label18.setText("年龄区间：");

                    //---- label19 ----
                    label19.setText("到");

                    //---- label20 ----
                    label20.setText("邮箱：");

                    //---- label21 ----
                    label21.setText("手机号：");

                    //---- label22 ----
                    label22.setText("宿舍：");

                    //---- button2Search ----
                    button2Search.setText("检索");
                    button2Search.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mousePressed(MouseEvent e) {
                            button2SearchMousePressed(e);
                        }
                    });

                    //---- button2Add ----
                    button2Add.setText("新增");
                    button2Add.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mousePressed(MouseEvent e) {
                            button2AddMousePressed(e);
                        }
                    });

                    //---- button2Edit ----
                    button2Edit.setText("修改");
                    button2Edit.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mousePressed(MouseEvent e) {
                            button2EditMousePressed(e);
                        }
                    });

                    //---- button2Delete ----
                    button2Delete.setText("删除（危险）");
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
            tabbedPane1.addTab("人员管理", panel6);
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(tabbedPane1, GroupLayout.DEFAULT_SIZE, 791, Short.MAX_VALUE)
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
    }
}
