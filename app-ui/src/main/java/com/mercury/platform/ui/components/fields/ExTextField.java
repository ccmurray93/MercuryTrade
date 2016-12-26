package com.mercury.platform.ui.components.fields;


import com.mercury.platform.ui.misc.AppThemeColor;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Константин on 16.12.2016.
 */
public class ExTextField extends JTextField {
    public ExTextField(String text) {
        super();
        this.setText(text);
        init();
    }

    private void init() {
        this.setFont(new Font("Tahoma", Font.BOLD, 16));
        this.setForeground(AppThemeColor.TEXT_DEFAULT);
        this.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(AppThemeColor.TEXT_DEFAULT,1),
                BorderFactory.createLineBorder(AppThemeColor.TRANSPARENT,3)
        ));
    }
}
