package form;

import javax.swing.*;
import java.awt.*;

public class LibraryPanel extends javax.swing.JPanel {
    public LibraryPanel() {
        super();

        setBackground(Color.YELLOW);
        setPreferredSize(new Dimension(getWidth()-getWidth()/8, getHeight())); // 调整内容栏宽度
        setLayout(new GridBagLayout());
        init();

    }
    public void init(){

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 0, 10, 0); // 设置按钮之间的间距
        gbc.gridx = 0;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.CENTER;
        JLabel descriptionLabel = new JLabel("<html><b>Library Information</b></html>");
        add(descriptionLabel, gbc);

    }
}
