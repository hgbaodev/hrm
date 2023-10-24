package view.chart;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Arc2D;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;

public class PieChart extends JComponent {

    private List<ModelPieChart> models;
    private DecimalFormat format = new DecimalFormat("#,##0.#");
    private PeiChartType chartType = PeiChartType.DEFAULT;


    public PieChart() {
        models = new ArrayList<>();
    }
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        double width = getWidth();
        double height = getHeight();
        double size = Math.min(width, height);
        double x = (width - size) / 2;
        double y = (height - size) / 2;
        double centerX = width / 2;
        double centerY = height / 2;
        double totalValue = getTotalvalue();
        double drawAngle = 90;
        float fontSize = 12;
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
        for (int i = 0; i < models.size(); i++) {
            ModelPieChart data = models.get(i);
            double angle = data.getValues() * 360 / totalValue;
            Area area = new Area(new Arc2D.Double(x, y, size, size, drawAngle, -angle, Arc2D.PIE));
            if (chartType == PeiChartType.DONUT_CHART) {
                double s1 = size * 0.6;
                double x1 = (width - s1) / 2;
                double y1 = (height - s1) / 2;
                area.subtract(new Area(new Ellipse2D.Double(x1, y1, s1, s1)));
            }
            g2.setColor(data.getColor());
            g2.fill(area);
            g2.setColor(Color.white);
            g2.draw(area);
      
           
            
            
            drawAngle -= angle;
        }
        drawAngle = 90;
        for (int i = 0; i < models.size(); i++) {
            ModelPieChart data = models.get(i);
            double angle = data.getValues() * 360 / totalValue;
            //  Draw Text
            double textSize = size / 2 * 0.8;
            double textAngle = -(drawAngle - angle / 2);
            double cosX = Math.cos(Math.toRadians(textAngle));
            double sinY = Math.sin(Math.toRadians(textAngle));
            String text = getPercentage(data.getValues()) + "%";
            g2.setFont(getFont().deriveFont(Font.PLAIN,fontSize));
            FontMetrics fm = g2.getFontMetrics();
            Rectangle2D r = fm.getStringBounds(text, g2);
            double textX = centerX + cosX * textSize - r.getWidth() / 2;
            double textY = centerY + sinY * textSize + fm.getAscent() / 2;
            g2.setColor(Color.WHITE);
            g2.drawString(text, (float) textX, (float) textY);
            drawAngle -= angle;
        }

        g2.dispose();
        super.paintComponent(g);
    }
    private String getPercentage(double value) {
        double total = getTotalvalue();
        return format.format(value * 100 / total);
    }

    private double getTotalvalue() {
        double max = 0;
        for (ModelPieChart data : models) {
            max += data.getValues();
        }
        return max;
    }
    public PeiChartType getChartType() {
        return chartType;
    }

    public void setChartType(PeiChartType chartType) {
        this.chartType = chartType;
        repaint();
    }
    public void setData(ArrayList<ModelPieChart> list) {
    	models = list;
    }
    public void clearData() {
        models.clear();
        repaint();
    }
    public void delDate(ModelPieChart data) {
    	models.remove(data);
    }
    public void addData(ModelPieChart data) {
        models.add(data);
    }

    public static enum PeiChartType {
        DEFAULT, DONUT_CHART
    }
}
