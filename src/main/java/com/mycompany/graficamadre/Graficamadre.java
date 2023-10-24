/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.graficamadre;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Graficamadre extends JFrame {

    private JPanel panel;
    private JTextField textField;
    private JButton button;
    private double confidenceLevel;
    private XYSeriesCollection dataset;
    private ChartPanel chartPanel;

    public Graficamadre() {
        panel = new JPanel();
        textField = new JTextField(10);
        button = new JButton("Calcular");
        dataset = new XYSeriesCollection();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Gráfico de la Función Normal");
        setSize(800, 600);
        setResizable(false);

        panel.add(new JLabel("Nivel de confianza:"));
        panel.add(textField);
        panel.add(button);
        add(panel);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = textField.getText();
                try {
                    confidenceLevel = Double.parseDouble(input);
                    if (confidenceLevel >= 0 && confidenceLevel <= 1) {
                        updateChart();
                    } else {
                        textField.setText("Ingrese un valor entre 0 y 1");
                    }
                } catch (NumberFormatException ex) {
                    textField.setText("Ingrese un valor numérico");
                }
            }
        });

        // Crear el gráfico inicial
        createChart();

        // Agregar el panel del gráfico al JFrame
        getContentPane().add(chartPanel);
        
        // Actualizar el gráfico
        updateChart();
    }

    private void createChart() {
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Gráfico de la Función Normal",
                "x",
                "y",
                dataset
        );

        XYPlot plot = chart.getXYPlot();
        plot.setBackgroundPaint(Color.WHITE);
        plot.setRangeGridlinePaint(Color.GRAY);
        plot.setDomainGridlinePaint(Color.GRAY);

        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, Color.RED);
        renderer.setSeriesShapesVisible(0, false);
        renderer.setSeriesPaint(1, Color.BLUE);
        renderer.setSeriesShapesVisible(1, false);
        plot.setRenderer(renderer);

        chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(700, 500));
    }

    private void updateChart() {
        dataset.removeAllSeries();

        XYSeries normalSeries = new XYSeries("Función Normal");
        XYSeries areaSeries = new XYSeries("Área");

        for (int i = 0; i <= 300; i++) {
            double x = i - 150;
            double z = x / 40.0;
            double y = Math.exp(-0.5 * z * z) / Math.sqrt(2 * Math.PI);
            normalSeries.add(x, y);
        }

        double x0 = -40 * confidenceLevel;
        double x1 = 40 * confidenceLevel;
        double y = getFunctionValue(x0);
        areaSeries.add(x0, 0);
        areaSeries.add(x0, y);
        areaSeries.add(x1, y);
        areaSeries.add(x1, 0);
        areaSeries.add(x0, 0);

        dataset.addSeries(normalSeries);
        dataset.addSeries(areaSeries);

        chartPanel.getChart().fireChartChanged();
    }

    private double getFunctionValue(double x) {
        double z = x / 40.0;
        return Math.exp(-0.5 * z * z) / Math.sqrt(2 * Math.PI);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Graficamadre().setVisible(true);
            }
        });
    }
}
