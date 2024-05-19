package form;
import com.mysql.jdbc.Connection;
import table.Users;
import util.DBConnect;
import util.RegexValidator;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

public class SignForm extends JFrame {
    public RegexValidator regexValidator = new RegexValidator();

    public SignForm(){
        super();
        this.setTitle("注册");
        setSize(620,800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);
        init();
        this.setVisible(true);

    }
    public void init(){

        ImageIcon falseIcon = new ImageIcon("C:\\Users\\theshy\\IdeaProjects\\LibraryManager\\asset\\错误.png");
        falseIcon.setImage(falseIcon.getImage().getScaledInstance(30, 30, 100));
        ImageIcon trueIcon = new ImageIcon("C:\\Users\\theshy\\IdeaProjects\\LibraryManager\\asset\\正确.png");
        trueIcon.setImage(trueIcon.getImage().getScaledInstance(30, 30, 100));


        List<JLabel> labels = new ArrayList<JLabel>();
        List<JTextField> texts=new ArrayList<>();
        List<JLabel> descList=new ArrayList<JLabel>();
        JLabel userDesc = new JLabel("用户名3-16个字符");
        descList.add(userDesc);
        JLabel pwdDesc = new JLabel("8-16个字符，需包括字母大小写两种");
        descList.add(pwdDesc);
        JLabel againDesc =new JLabel("请确保与上面密码相同");
        descList.add(againDesc);
        JLabel nameDesc = new JLabel("昵称3-16个字符");
        descList.add(nameDesc);
        JLabel emailDesc=new JLabel("请输入正确的邮箱");
        descList.add(emailDesc);
        JLabel phoneDesc=new JLabel("请输入正确的电话号码");
        descList.add(phoneDesc);
        JLabel addressDesc=new JLabel("您的地址");
        descList.add(addressDesc);
        int offset=20;
        for(JLabel desc:descList){
            desc.setBounds(255,100+offset,300,40);
            desc.setFont(new Font("宋体",Font.BOLD,16));
            desc.setVisible(false);
            desc.setIcon(falseIcon);
            offset+=80;
            this.add(desc);
        }





        JLabel userLabel = new JLabel("  用户名：");
        labels.add(userLabel);
        JLabel pwdLabel=new JLabel("  密  码：");
        labels.add(pwdLabel);
        JLabel again_pwdLabel=new JLabel("确认密码：");
        labels.add(again_pwdLabel);
        JLabel nameLabel=new JLabel("  昵  称：");
        labels.add(nameLabel);
        JLabel emailLabel=new JLabel("  邮  箱：");
        labels.add(emailLabel);
        JLabel phoneLabel=new JLabel("电话号码：");
        labels.add(phoneLabel);
        JLabel addressLabel=new JLabel("  地  址：");
        labels.add(addressLabel);
        offset=20;
        for(JLabel label: labels){
        label.setBounds(100,50+offset,160,50);
        offset+=80;
        label.setFont(new Font("宋体",Font.BOLD,25));
        this.add(label);

        }
        JTextField userField=new JTextField(10);
        texts.add(userField);
        JTextField pwdField=new JTextField(10);
        texts.add(pwdField);
        JTextField again_pwdField=new JTextField(10);
        texts.add(again_pwdField);
        JTextField nameField=new JTextField(10);
        texts.add(nameField);
        JTextField emailField=new JTextField(10);
        texts.add(emailField);
        JTextField phoneField=new JTextField(10);
        texts.add(phoneField);
        JTextField addressField=new JTextField(10);
        texts.add(addressField);
        offset=20;
        for (JTextField text : texts) {
            text.setBounds(255, 60 + offset, 300, 40);
            offset += 80;

            int index = texts.indexOf(text);
            text.getDocument().addDocumentListener(new DocumentListener() {
                @Override
                public void insertUpdate(DocumentEvent e) {
                    validateField(text, index, descList, falseIcon, trueIcon,texts);
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    validateField(text, index, descList, falseIcon, trueIcon,texts);
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    validateField(text, index, descList, falseIcon, trueIcon,texts);
                }
            });

            text.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    descList.get(index).setVisible(true);
                }

                @Override
                public void focusLost(FocusEvent e) {
                    descList.get(index).setVisible(false);
                }
            });

            this.add(text);
        }
        JButton signBtn=new JButton("注册");
        DBConnect db=new DBConnect();
        Users users=new Users((Connection) db.getConnection());
        signBtn.addActionListener(new SignListener(
                this,
                userField,
                pwdField,
                again_pwdField,
                nameField,
                emailField,
                phoneField,
                addressField,
                descList,
                falseIcon,
                trueIcon
        ));

        signBtn.setBounds(215,650,100,40);
        this.add(signBtn);
    }
    private void validateField(JTextField text, int index, List<JLabel> descList, ImageIcon falseIcon, ImageIcon trueIcon, List<JTextField> texts) {
        boolean flag = false;
        String txt = text.getText().trim();
        switch (index) {
            case 0:
                flag = regexValidator.isUsername(txt);
                break;
            case 1:
                flag = regexValidator.isPassword(txt);
                break;
            case 2:
                flag = regexValidator.isPassword(txt) && txt.equals(texts.get(1).getText().trim());
                break;
            case 3:
                flag = regexValidator.isUsername(txt);
                break;
            case 4:
                flag = regexValidator.isEmail(txt);
                break;
            case 5:
                flag = regexValidator.isPhone(txt);
            case 6:
                flag = !txt.equals("");
            // 添加其他判断
        }
        if (flag) {
            descList.get(index).setIcon(trueIcon);
        } else {
            descList.get(index).setIcon(falseIcon);
        }
        descList.get(index).setVisible(true);
    }


}
