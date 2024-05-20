package form;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.List;

public class ManagerForm extends JFrame {
    private JPanel sidebar;
    private JPanel mainPanel;
    private List<JButton> buttonList;

    public ManagerForm() {
        super();
        this.setSize(1280, 960);
        this.setTitle("图书馆管理系统");
        this.setResizable(true); // 允许窗口大小调整
        this.setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initSidebar();
        initMainPanel();
        this.setVisible(true);

        // 添加窗口大小改变事件监听器
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                resizeSidebar();
            }
        });
    }

    public void initSidebar() {
        sidebar = new JPanel();
        buttonList = new ArrayList<>();

        sidebar.setBackground(Color.BLUE);
        sidebar.setPreferredSize(new Dimension(getWidth()/8, getHeight())); // 调整侧边栏宽度
        sidebar.setLayout(new GridBagLayout());
        this.add(sidebar, BorderLayout.WEST);

        JButton bookMagBtn = new JButton("图书管理");
        JButton bookerMagBtn = new JButton("读者管理");
        JButton lendMagBtn = new JButton("借阅管理");
        JButton quitBtn = new JButton("退出账户");

        buttonList.add(bookMagBtn);
        buttonList.add(bookerMagBtn);
        buttonList.add(lendMagBtn);
        buttonList.add(quitBtn);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 0, 10, 0); // 设置按钮之间的间距
        gbc.gridx = 0;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.CENTER;

        for (int i = 0; i < buttonList.size(); i++) {
            JButton item = buttonList.get(i);
            item.setPreferredSize(new Dimension(200, 54));
            item.setBackground(Color.RED);
            item.setFont(new Font("宋体", Font.PLAIN, 16));
            gbc.gridy = i;
            sidebar.add(item, gbc);
        }
    }

    private void resizeSidebar() {
        // 获取窗口的高度并调整侧边栏的高度
        int frameHeight = this.getHeight();
        sidebar.setPreferredSize(new Dimension(getWidth()/8, frameHeight));
        sidebar.revalidate(); // 重新布局侧边栏
        mainPanel.setPreferredSize(new Dimension(getWidth()/8, frameHeight));
        mainPanel.revalidate(); // 重新布局侧边栏
    }
    public void initMainPanel() {
        mainPanel=new LibraryPanel();
        mainPanel.setBackground(Color.YELLOW);
        mainPanel.setPreferredSize(new Dimension(getWidth()-getWidth()/8, getHeight())); // 调整内容栏宽度
        mainPanel.setLayout(new GridBagLayout());
        this.add(mainPanel, BorderLayout.CENTER);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 0, 10, 0); // 设置按钮之间的间距
        gbc.gridx = 0;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.CENTER;
    }
}
