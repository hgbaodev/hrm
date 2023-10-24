package view.chart;

import java.awt.Color;

public class ModelPieChart {
	private String name;
	private double values;
	private Color color;
	public ModelPieChart() {
		this.name = "null";
		this.values = 0;
		this.color = Color.gray;
	}
	public ModelPieChart(String name, double values, Color color) {
        this.name = name;
        this.values = values;
        this.color = color;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getValues() {
        return values;
    }
    public void setValues(double values) {
        this.values = values;
    }
    public Color getColor() {
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
    }
}
