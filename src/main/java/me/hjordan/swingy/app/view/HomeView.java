package me.hjordan.swingy.app.view;

import me.hjordan.swingy.app.controller.HomeController;
import me.hjordan.swingy.app.controller.IController;

import javax.swing.*;
import java.awt.*;

public class HomeView extends JFrame {

        private HomeController controller;
        public HomeView(HomeController controller) {
            super("Swingy");

            this.controller = controller;

            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(400, 400);
            setLocationRelativeTo(null);
            setVisible(false);

        }
}
