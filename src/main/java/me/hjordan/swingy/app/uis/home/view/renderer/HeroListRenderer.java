package me.hjordan.swingy.app.uis.home.view.renderer;

import me.hjordan.swingy.engine.hero.AbstractHero;

import javax.swing.*;

public class HeroListRenderer extends JLabel implements ListCellRenderer<AbstractHero> {

        @Override
        public JLabel getListCellRendererComponent(JList<? extends AbstractHero> list, AbstractHero hero, int index, boolean isSelected, boolean cellHasFocus) {
            if (hero == null)
                return this;

            final String text = String.format("%s - level %s - %s", hero.getName(), hero.getLevel(), hero.getType());

            setText(text);
            return this;
        }
}
