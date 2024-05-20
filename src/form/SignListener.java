package form;

import javax.swing.*;
import java.awt.event.*;

import com.mysql.jdbc.Connection;
import table.User;
import table.Users;
import util.DBConnect;
import util.RegexValidator;

import java.sql.SQLException;
import java.util.List;

public class SignListener implements ActionListener {
    private JTextField userField;
    private JTextField pwdField;
    private JTextField again_pwdField;
    private JTextField nameField;
    private JTextField emailField;
    private JTextField phoneField;
    private JTextField addressField;
    private JFrame signForm;

    private DBConnect dbConnect=new DBConnect();

    private List<JLabel> descList;
    private ImageIcon falseIcon;
    private ImageIcon trueIcon;

    public SignListener(JFrame signForm, JTextField userField, JTextField pwdField, JTextField again_pwdField,
                        JTextField nameField, JTextField emailField, JTextField phoneField, JTextField addressField,
                        List<JLabel> descList, ImageIcon falseIcon, ImageIcon trueIcon) {
        this.signForm = signForm;
        this.userField = userField;
        this.pwdField = pwdField;
        this.again_pwdField = again_pwdField;
        this.nameField = nameField;
        this.emailField = emailField;
        this.phoneField = phoneField;
        this.addressField = addressField;
        this.descList = descList;
        this.falseIcon = falseIcon;
        this.trueIcon = trueIcon;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean allValid = true;

        if (!RegexValidator.isUsername(userField.getText().trim())) {
            allValid = false;
            descList.get(0).setIcon(falseIcon);
            descList.get(0).setVisible(true);
        } else {
            descList.get(0).setIcon(trueIcon);
            descList.get(0).setVisible(true);
        }

        if (!RegexValidator.isPassword(pwdField.getText().trim())) {
            allValid = false;
            descList.get(1).setIcon(falseIcon);
            descList.get(1).setVisible(true);
        } else {
            descList.get(1).setIcon(trueIcon);
            descList.get(1).setVisible(true);
        }

        if (!pwdField.getText().trim().equals(again_pwdField.getText().trim())) {
            allValid = false;
            descList.get(2).setIcon(falseIcon);
            descList.get(2).setVisible(true);
        } else {
            descList.get(2).setIcon(trueIcon);
            descList.get(2).setVisible(true);
        }

        if (!RegexValidator.isUsername(nameField.getText().trim())) {
            allValid = false;
            descList.get(3).setIcon(falseIcon);
            descList.get(3).setVisible(true);
        } else {
            descList.get(3).setIcon(trueIcon);
            descList.get(3).setVisible(true);
        }

        if (!RegexValidator.isEmail(emailField.getText().trim())) {
            allValid = false;
            descList.get(4).setIcon(falseIcon);
            descList.get(4).setVisible(true);
        } else {
            descList.get(4).setIcon(trueIcon);
            descList.get(4).setVisible(true);
        }
        if (!RegexValidator.isPhone(phoneField.getText().trim())) {
            allValid = false;
            descList.get(5).setIcon(falseIcon);
            descList.get(5).setVisible(true);
        } else {
            descList.get(5).setIcon(trueIcon);
            descList.get(5).setVisible(true);
        }
        if ((addressField.getText().trim().isEmpty() || addressField.getText().trim().equals(""))) {
            allValid = false;
            descList.get(6).setIcon(falseIcon);
            descList.get(6).setVisible(true);
        } else {
            descList.get(6).setIcon(trueIcon);
            descList.get(6).setVisible(true);
        }


        if (allValid) {
            User user = new User(
                    userField.getText().trim(),
                    pwdField.getText().trim(),
                    nameField.getText().trim(),
                    emailField.getText().trim(),
                    phoneField.getText().trim(),
                    addressField.getText().trim()
            );
            Users users=new Users((Connection) dbConnect.getConnection());

            try {
                users.addUser(user);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            JOptionPane.showMessageDialog(signForm, "注册成功！");
            signForm.dispose();
        } else {
            JOptionPane.showMessageDialog(signForm, "请确保所有输入都符合要求。", "注册失败", JOptionPane.ERROR_MESSAGE);
        }
    }
}
