package form;

import java.util.*;
import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

public class ManagerForm extends JFrame {
    public ManagerForm() {
        super();
        this.setSize(1280,960);
        this.setTitle("图书馆管理系统");
        this.setResizable(false);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(3);
        this.setVisible(true);
        initSidebar();
    }
    public void initSidebar() {
        JPanel sidebar=new JPanel();
        List<JButton> buttonList=new ArrayList<JButton>();

        sidebar.setBounds(0, 0, 200, 920);
        sidebar.setBackground(Color.BLUE);
        sidebar.setLayout(null);
        this.add(sidebar);
        JButton bookMagBtn=new JButton("图书管理");
        JButton bookerMagBtn=new JButton("读者管理");
        JButton lendMagBtn=new JButton("借阅管理");
        JButton quitBtn=new JButton("退出账户");
        buttonList.add(bookMagBtn);
        buttonList.add(bookerMagBtn);
        buttonList.add(lendMagBtn);
        buttonList.add(quitBtn);
        int offset=54;
        for(JButton item:buttonList) {
            item.setBounds(0, 200+offset, 200, 54);
            item.setBackground(Color.red);
            item.setFont(new Font("宋体", Font.PLAIN, 16));
            sidebar.add(item);
            offset+=54;
        }
        sidebar.add(quitBtn);

    }


}