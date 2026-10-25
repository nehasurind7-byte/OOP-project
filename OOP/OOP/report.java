package OOP.OOP;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.Font;


public abstract class report
{
    abstract String generateReport();
    abstract String showInference();
  
}
class WorkloadReport extends report
{
    private ArrayList<Workload> workloads;

    WorkloadReport(ArrayList<Workload> workloads)
    {
        this.workloads = workloads;
    }
    String generateReport() 
    {
        StringBuilder output = new StringBuilder();

        output.append("== DOCTOR TO PATIENT RATIO ==\n\n");

        for (Workload w : workloads) 
        {
            output.append("Date: ").append(w.getLocalDate()).append("\n");
            output.append("9 AM - 12 PM: ").append(w.getRatio()).append("\n");
            output.append("12 PM - 3 PM: ").append(w.getRatio1()).append("\n");
            output.append("3 PM - 6 PM: ").append(w.getRatio2()).append("\n");
            output.append("Daily Average: ").append(w.getDailyavg()).append("\n\n");
        }
        return output.toString();
    }

    String showInference() 
    {
        StringBuilder output = new StringBuilder();

        for (Workload w : workloads) 
        {

            if (w.getRatio() > 30) 
            {
                output.append(w.getLocalDate()).append("\nHigh workload detected: 9 AM - 12 PM\n\n");
            }

            if (w.getRatio1() > 30) 
            {
                output.append(w.getLocalDate()).append("\nHigh workload detected: 12 PM - 3 PM\n\n");
               
            }
            if (w.getRatio2() > 30) 
            {
                output.append(w.getLocalDate()).append("\nHigh workload detected: 3 PM - 6 PM\n\n");
            }
        }

        return output.toString();
    }
}

class Bedreport extends report
{
    private ArrayList<Bedpercentage> occuBedpercentages;
    Bedreport(ArrayList<Bedpercentage> occuBedpercentages)
    {
        this.occuBedpercentages=occuBedpercentages;
    }
    
     String generateReport() 
     {
        StringBuilder output = new StringBuilder();

        output.append("== BED OCCUPANCY REPORT ==\n\n");
        for (Bedpercentage b : occuBedpercentages)
        {
            output.append("Month: ").append(b.getMonth()).append("\n");
            output.append("Occupancy: ").append(b.getPercentage()).append("%\n\n");
        }
        return output.toString();
    }
    String showInference() 
    {
        StringBuilder output = new StringBuilder();
        for (Bedpercentage b : occuBedpercentages) 
        {
            double percentage = b.getPercentage();

            output.append(b.getMonth()).append("\n");

            if (percentage >= 90)
            {
                output.append("Very high occupancy\n\n");
            }
            else if (percentage > 70) 
            {
                output.append("High occupancy\n\n");
            } else 
            {
                output.append("Normal occupancy\n\n");
            }
        }

        return output.toString();
    }
}
class DemandReport extends report
{   
    private ArrayList<Demandpercentages> demandpercentages;
    DemandReport(ArrayList<Demandpercentages> demandpercentages)
    {
        this.demandpercentages=demandpercentages;
    }
    String generateReport()
    {
        StringBuilder output = new StringBuilder();

        output.append("== SURGERY DEMAND REPORT ==\n\n");

        for (Demandpercentages d : demandpercentages)
        {
            output.append("Surgery: ").append(d.getsurgeryName()).append("\n");
            output.append("Percentage of unperformed surgeries: ").append(d.getunmetPercentage()).append("%\n");
            output.append("Percentage of performed surgeries: ").append(d.getperformedPercentage()).append("%\n");
            output.append("Total high-end equipment owned: ").append(d.getequipmentCount()).append("\n\n");
        }

        return output.toString();
    }
    String showInference() 
    {
        StringBuilder output = new StringBuilder();
        for (Demandpercentages d : demandpercentages) 
        {
            String answer = JOptionPane.showInputDialog(
                null,
                "Enter the minimum expected number of cases per month " +
                "for maintaining specialised equipment:\n" +
                d.getsurgeryName()
            );

            if (answer == null) 
            {
                output.append("Inference skipped for ")
                      .append(d.getsurgeryName()).append(".\n\n");
                continue;
            }

            int limit;

            try 
            {
                limit = Integer.parseInt(answer.trim());

                if (limit < 0) {
                    output.append("Invalid threshold for ")
                          .append(d.getsurgeryName())
                          .append(".\n\n");
                    continue;
                }
            } catch (NumberFormatException e) {
                output.append("Invalid number entered for ")
                      .append(d.getsurgeryName())
                      .append(".\n\n");
                continue;
            }

            if (d.gettotalDemand() > limit &&
                d.getunmetPercentage() > 50) 
            {

                output.append("High unmet demand detected for ").append(d.getsurgeryName()).append("\n");
                output.append("This may indicate a capacity constraint and " +"could warrant further investigation.\n\n");
            }
            else 
            {
                output.append("No high demand detected for ").append(d.getsurgeryName()).append(".\n\n");
            }
        }

        return output.toString();
    }
}

    



