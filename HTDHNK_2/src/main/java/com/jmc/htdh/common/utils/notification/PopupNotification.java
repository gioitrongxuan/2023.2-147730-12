package com.jmc.htdh.common.utils.notification;

import javax.swing.*;

public class PopupNotification {
    public static void popupNotification(String title, String content) {
        // Tạo thông báo popup
        JOptionPane.showMessageDialog(null,
                content, // Nội dung thông báo
                title, // Tiêu đề
                JOptionPane.INFORMATION_MESSAGE); // Loại thông báo
    }
}
