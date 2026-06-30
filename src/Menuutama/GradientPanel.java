package Menuutama;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

public class GradientPanel extends JPanel {

    private Color colorStart;
    private Color colorEnd;
    private boolean horizontal;

    public GradientPanel(Color start, Color end, boolean horizontal) {
        this.colorStart = start;
        this.colorEnd = end;
        this.horizontal = horizontal;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        int w = getWidth();
        int h = getHeight();

        GradientPaint gp;
        if (horizontal) {
            gp = new GradientPaint(0, 0, colorStart, w, 0, colorEnd);
        } else {
            gp = new GradientPaint(0, 0, colorStart, 0, h, colorEnd);
        }

        g2d.setPaint(gp);
        g2d.fillRect(0, 0, w, h);
    }
}