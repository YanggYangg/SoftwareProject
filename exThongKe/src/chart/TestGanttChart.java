package chart;

import java.util.Date;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.IntervalCategoryDataset;
import org.jfree.data.gantt.Task;
import org.jfree.data.gantt.TaskSeries;
import org.jfree.data.gantt.TaskSeriesCollection;
import org.jfree.data.time.SimpleTimePeriod;

/**
 *
 * @author TVD
 */
public class TestGanttChart {

    private static JFreeChart createChart() {
        JFreeChart chart = ChartFactory.createGanttChart(
                "BIỂU ĐỒ KẾ HOẠCH TRIỂN KHAI DỰ ÁN",
                "Dự án", "Thời gian", createDataset(), false, false, false
        );
        return chart;
    }

    private static IntervalCategoryDataset createDataset() {
        TaskSeriesCollection ds = new TaskSeriesCollection();
        TaskSeries taskSeries = new TaskSeries("T");
        Task task1 = new Task("M471", new SimpleTimePeriod(new Date(2020, 2, 2), new Date(2020, 2, 4)));
        Task task2 = new Task("C321", new SimpleTimePeriod(new Date(2020, 2, 5), new Date(2020, 2, 9)));
        taskSeries.add(task1);
        taskSeries.add(task2);
        ds.add(taskSeries);
        return ds;
    }

    public static void main(String[] args) {
        JFreeChart freeChart = createChart();
        ChartPanel chartPanel = new ChartPanel(freeChart);
        JFrame frame = new JFrame();
        frame.add(chartPanel);
        frame.setTitle("Biểu đồ JFreeChart trong Java Swing");
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }

}