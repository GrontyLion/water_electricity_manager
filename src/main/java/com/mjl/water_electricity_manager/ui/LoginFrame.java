package com.mjl.water_electricity_manager.ui;

import com.mjl.water_electricity_manager.domain.User;
import com.mjl.water_electricity_manager.service.UserService;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@Component
public class LoginFrame extends JFrame {
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JTextField textFieldAccount;
    private JPasswordField passwordFieldPwd;
    private JButton buttonLogin;
    private JButton buttonAbout;

    @Resource
    @Lazy
    private StudentMainFrame studentMainFrame;


    @Resource
    @Lazy
    private SimulateFrame simulateFrame;
    @Resource
    @Lazy
    private AdminMainFrame adminMainFrame;

    @Resource
    private UserService userService;

    public LoginFrame() {
        initComponents();
    }

    private void buttonLoginMousePressed(MouseEvent e) {
        String account = textFieldAccount.getText().trim();
        String password = new String(passwordFieldPwd.getPassword()).trim();
        if (account.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "账号或密码不能为空");
            return;
        }
        User user = userService.login(account, password);
        if (user != null) {
            UserService.loginUser = user;
            if (user.getUserTypeId() == 2) {
                studentMainFrame.setVisible(true);
                simulateFrame.setVisible(true);
            }else if (user.getUserTypeId() == 1) {
                adminMainFrame.setVisible(true);
            }
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "账号或密码错误");
        }
    }

    private void buttonAboutMousePressed(MouseEvent e) {
        JOptionPane.showMessageDialog(this, "学生宿舍水电费管理系统", "关于", JOptionPane.INFORMATION_MESSAGE);
    }

    private void initComponents() {
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        textFieldAccount = new JTextField();
        passwordFieldPwd = new JPasswordField();
        buttonLogin = new JButton();
        buttonAbout = new JButton();

        //======== this ========
        setTitle("登录界面");
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("欢迎使用学校宿舍水电费管理系统");
        label1.setFont(new Font("仿宋", Font.BOLD, 20));

        //---- label2 ----
        label2.setText("账号：");

        //---- label3 ----
        label3.setText("密码：");

        //---- textFieldAccount ----
        textFieldAccount.setToolTipText("手机号或邮箱");

        //---- buttonLogin ----
        buttonLogin.setText("登录");
        buttonLogin.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                buttonLoginMousePressed(e);
            }
        });

        //---- buttonAbout ----
        buttonAbout.setText("关于");
        buttonAbout.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                buttonAboutMousePressed(e);
            }
        });

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addGap(29, 29, 29)
                                                .addComponent(label1))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addGap(90, 90, 90)
                                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                                .addComponent(buttonLogin)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(buttonAbout))
                                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(label3)
                                                                        .addComponent(label2))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(passwordFieldPwd)
                                                                        .addComponent(textFieldAccount, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE))))))
                                .addContainerGap(30, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(label1)
                                .addGap(41, 41, 41)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label2)
                                        .addComponent(textFieldAccount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label3)
                                        .addComponent(passwordFieldPwd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(buttonAbout)
                                        .addComponent(buttonLogin))
                                .addContainerGap(18, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
    }
}
