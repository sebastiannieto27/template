package co.com.core.controller.psaber;

import java.io.Serializable;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BubbleChartModel;
import org.primefaces.model.chart.BubbleChartSeries;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

public class ChartView implements Serializable {
	private BubbleChartModel bubbleModel1;
    private BubbleChartModel bubbleModel2;
 
    private LineChartModel lineModel1;
    
    //@PostConstruct
    public void init() {
        createBubbleModels();
    }
 
    public BubbleChartModel getBubbleModel1() {
    	createBubbleModels();
    	createLineModels();
        return bubbleModel1;
    }
    
    public LineChartModel getLineModel1() {
        return lineModel1;
    }
    
    private void createLineModels() {
        lineModel1 = initLinearModel();
        lineModel1.setTitle("Linear Chart");
        lineModel1.setLegendPosition("e");
        Axis yAxis = lineModel1.getAxis(AxisType.Y);
        //yAxis.setMin(0);
        yAxis.setMax(1);
        yAxis.setTickFormat("%d");
        Axis xAxis = lineModel1.getAxis(AxisType.X);
        //xAxis.setMin(0);
        xAxis.setMax(10);
        xAxis.setTickFormat("%d");
        //xAxis.setTickInterval(tickInterval);
    }
    
    private LineChartModel initLinearModel() {
        LineChartModel model = new LineChartModel();
 
        LineChartSeries series1 = new LineChartSeries();
        series1.setLabel("");//jqplot-table-legend

        series1.set(1, 0.1);
        /*series1.set(2, 1);
        series1.set(3, 3);
        series1.set(4, 6);
        series1.set(5, 8);*/
 
       /* LineChartSeries series2 = new LineChartSeries();
        series2.setLabel("Series 2");
 
        series2.set(1, 6);
        series2.set(2, 3);
        series2.set(3, 2);
        series2.set(4, 7);
        series2.set(5, 9);*/
 
        model.addSeries(series1);
        //model.addSeries(series2);
         
        return model;
    }
    
    private LineChartModel initCategoryModel() {
        LineChartModel model = new LineChartModel();
 
        ChartSeries boys = new ChartSeries();
        boys.setLabel("Boys");
        boys.set("2004", 120);
        boys.set("2005", 100);
        boys.set("2006", 44);
        boys.set("2007", 150);
        boys.set("2008", 25);
 
        ChartSeries girls = new ChartSeries();
        girls.setLabel("Girls");
        girls.set("2004", 52);
        girls.set("2005", 60);
        girls.set("2006", 110);
        girls.set("2007", 90);
        girls.set("2008", 120);
 
        model.addSeries(boys);
        model.addSeries(girls);
         
        return model;
    }
    
    private void createBubbleModels(){
        bubbleModel1 = initBubbleModel();
        bubbleModel1.setTitle("Bubble Chart");
        bubbleModel1.getAxis(AxisType.X).setLabel("Percentil");
        Axis yAxis = bubbleModel1.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(100);
        Axis xAxis = bubbleModel1.getAxis(AxisType.X);
        xAxis.setMin(0);
        xAxis.setMax(100);
        yAxis.setLabel("Labels");
         
        /*bubbleModel2 = initBubbleModel();
        bubbleModel2.setTitle("Custom Options");
        bubbleModel2.setShadow(false);
        bubbleModel2.setBubbleGradients(true);
        bubbleModel2.setBubbleAlpha(0.8);
        bubbleModel2.getAxis(AxisType.X).setTickAngle(-50);
        yAxis = bubbleModel2.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(100);
        yAxis.setTickAngle(50);*/
    }
     
    private BubbleChartModel initBubbleModel(){
        BubbleChartModel model = new BubbleChartModel();
        //x, y, radio
        //model.add(new BubbleChartSeries("Acura", 70, 183,55));
        model.add(new BubbleChartSeries("40*", 20, 30, 5));
        /*model.add(new BubbleChartSeries("AM General", 24, 104, 40));
        model.add(new BubbleChartSeries("Bugatti", 50, 123, 60));
        model.add(new BubbleChartSeries("BMW", 15, 89, 25));
        model.add(new BubbleChartSeries("Audi", 40, 180, 80));
        model.add(new BubbleChartSeries("Aston Martin", 70, 70, 48));*/
         
        return model;
    }
}
