package co.com.core.commons.charts;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GenericBarChart implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory.getLogger(GenericBarChart.class);

	private BarChartModel initBarModel(List<Map<String, Object>> chartSeriesList) {
		BarChartModel model = new BarChartModel();

		try {
			if (chartSeriesList != null && chartSeriesList.size() > 0) {
				for (Map<String, Object> map : chartSeriesList) {
					ChartSeries chart = new ChartSeries();
					if (map.get("label") != null) {
						chart.setLabel(map.get("label").toString());
					}

					Iterator it = map.entrySet().iterator();
					while (it.hasNext()) {
						Map.Entry pair = (Map.Entry) it.next();
						String key = pair.getKey().toString();
						String value = pair.getValue().toString();
						if(!key.equalsIgnoreCase("label")) {
							chart.set(key, Double.parseDouble(value));
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
	
	public BarChartModel createBarModel(Map<String, Object> charData) {
		BarChartModel barModel = initBarModel((List<Map<String, Object>>) charData.get("chartList"));
         
        barModel.setTitle(charData.get("title").toString());
        barModel.setLegendPosition("ne");
         
        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel(charData.get("xTitle").toString());
         
        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel(charData.get("yTitle").toString());
        yAxis.setMin(0);
        yAxis.setMax(200);
        
        return barModel;
    }
}
