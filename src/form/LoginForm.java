package form;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame{

    public LoginForm(){
        super();

        setTitle("Login");
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,500);
        setResizable(false);
        setLocationRelativeTo(null);
        init();
        setVisible(true);


    }
    public void init() {
        JLabel userLabel = new JLabel("  用户名：");
        userLabel.setBounds(50,70,160,50);
        userLabel.setFont(new Font("宋体",Font.BOLD,25));
        this.add(userLabel);
        JTextField userText=new JTextField();
        userText.setBounds(205, 80, 300, 40);
        this.add(userText);



        JLabel pwdLabel=new JLabel("  密  码：");
        pwdLabel.setBounds(50, 150, 160, 50);
        pwdLabel.setFont(new Font("宋体",Font.BOLD,25));
        this.add(pwdLabel);
        JPasswordField pwdText=new JPasswordField();
        pwdText.setBounds(205, 150, 300, 40);
        this.add(pwdText);



        JButton logBtn=new JButton("登录");
        logBtn.setBounds(150, 250, 94, 35);
        this.add(logBtn);
        JButton signBtn=new JButton("注册");
        signBtn.setBounds(260, 250, 94, 35);
        signBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SignForm();
            }
        });
        this.add(signBtn);
        JButton resetBtn=new JButton("重置");
        resetBtn.setBounds(370, 250, 94, 35);
        this.add(resetBtn);

        this.setTitle("登录界面");

        LoginListener l1=new LoginListener(this,userText,pwdText);
        logBtn.addActionListener(l1);

        resetBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userText.setText("");
                pwdText.setText("");
            }
        });
        this.setVisible(true);
    }
}