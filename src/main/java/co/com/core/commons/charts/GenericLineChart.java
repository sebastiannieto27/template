package co.com.core.commons.charts;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GenericLineChart implements Serializable {
 
	private static final Logger logger = LoggerFactory.getLogger(GenericLineChart.class);
	
    public LineChartModel createLineModels(Map<String, Object> charData) {
    	
    	LineChartModel lineModel = initLinearModel((List<Map<String, Object>>) charData.get("chartList"));
    	
        lineModel.setTitle(charData.get("title").toString());
        lineModel.setLegendPosition("e");
        Axis yAxis = lineModel.getAxis(AxisType.Y);
        yAxis.setMin(Integer.parseInt(charData.get("yAxisMin").toString()));
        yAxis.setMax(Integer.parseInt(charData.get("yAxisMax").toString()));
        yAxis.setTickFormat("%d");
        Axis xAxis = lineModel.getAxis(AxisType.X);
        xAxis.setMin(Integer.parseInt(charData.get("xAxisMin").toString()));
        xAxis.setMax(Integer.parseInt(charData.get("xAxisMax").toString()));
        xAxis.setTickFormat("%d");
        //xAxis.setTickInterval(tickInterval);
        
        return lineModel;
    }
    
    private LineChartModel initLinearModel(List<Map<String, Object>> chartSeriesList) {
        LineChartModel model = new LineChartModel();
        
        try {
			if (chartSeriesList != null && chartSeriesList.size() > 0) {
				for (Map<String, Object> map : chartSeriesList) {
					
					LineChartSeries chart = new LineChartSeries();
					
					if (map.get("label") != null) {
						chart.setLabel(map.get("label").toString());//jqplot-table-legend
					}

					Iterator it = map.entrySet().iterator();
					while (it.hasNext()) {
						Map.Entry pair = (Map.Entry) it.next();
						String key = pair.getKey().toString();
						String value = pair.getValue().toString();
						if(!key.equalsIgnoreCase("label")) {
							chart.set(Integer.parseInt(key), Double.parseDouble(value));
						}
						it.remove(); // avoids a ConcurrentModificationException
					}

					model.addSeries(chart);
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
        
        return model;
    }
}
