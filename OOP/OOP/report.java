package OOP.OOP;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class report
{
    abstract void generateReport();
    abstract void showInference();
  
}
class WorkloadReport extends report
{
    private ArrayList<Workload> workloads;

    WorkloadReport(ArrayList<Workload> workloads)
    {
        this.workloads = workloads;
    }
    void generateReport()
    {
        System.out.println("==DOCTOR TO PATIENT RATIO==");
        System.out.println();

        for(Workload w : workloads)
        {
            System.out.println(w.getLocalDate());
            System.out.println("9AM-12PM:"+w.getRatio());
            System.out.println("12PM-3PM:"+w.getRatio1());
            System.out.println("3PM-6PM:"+w.getRatio2());
            System.out.println("DAILY AVG:"+w.getDailyavg());
            System.out.println();
        }
    }
     void showInference()
    {
        for(Workload w : workloads)
        {
            if(w.getRatio() > 30)
            {   
                System.out.println(w.getLocalDate());
                System.out.println("High workload detected: 9 AM - 12 PM");
                System.out.println();
            }

            if(w.getRatio1() > 30)
            {
                System.out.println(w.getLocalDate());
                System.out.println("High workload detected: 12 PM - 3 PM");
                System.out.println();
            }

            if(w.getRatio2() > 30)
            {
                System.out.println(w.getLocalDate());
                System.out.println("High workload detected: 3 PM - 6 PM");
                System.out.println();
            }
            else
            {
                System.out.println("NO HIGH WORKLOAD DETECTED....   ");
            }
        }
    }
}
class Bedreport extends report
{
    private ArrayList<Bedpercentage> occuBedpercentages;
    Bedreport(ArrayList<Bedpercentage> occuBedpercentages)
    {
        this.occuBedpercentages=occuBedpercentages;
    }
    void generateReport()
    {
        for(Bedpercentage B:occuBedpercentages)
        {
            System.out.println(B.getPercentage());
            System.out.println();
        }
    }
    void showInference()
    {
        for(Bedpercentage B:occuBedpercentages)
        {
            System.out.println(B.getMonth());
            if(B.getPercentage()>90)
            {
                System.out.println("Very high occupancy ");
                System.out.println();
            }
            if(B.getPercentage()<90 && B.getPercentage()>70)
            {
                System.out.println("High occupancy ");
                System.out.println();
            }
            if(B.getPercentage()<70)
            {
                System.out.println("Normal occupancy ");
                System.out.println();
            }
        }
    }
}
class DemandReport extends report
{   
    Scanner sc=new Scanner(System.in);
    private ArrayList<Demandpercentages> demandpercentages;
    DemandReport(ArrayList<Demandpercentages> demandpercentages)
    {
        this.demandpercentages=demandpercentages;
    }
    void generateReport()
    {
        double unmetP=0.0;
        double performP=0;
        int totalDemand=0;
        for(Demandpercentages d:demandpercentages)
        {
            unmetP=d.getunmetPercentage();
            performP=d.getperformedPercentage();
            System.out.println("Surgery:"+d.getsurgeryName());
            System.out.println("Percentage of unperformed surgeries:"+unmetP);
            System.out.println("Percentage of performed surgeries:"+performP);
            System.out.println("Total high end equipments owned:"+d.getequipmentCount());
            System.out.println();
        }
    }
    void showInference()
    {
        
        for(Demandpercentages d:demandpercentages)
        {
            System.out.println("Enter the minimum expected number of cases per month for maintaining the specialised equipment");
            
            int limit=0;
            limit=sc.nextInt();
            if(d.gettotalDemand() > limit && d.getunmetPercentage() > 50)
            {
                System.out.println("High unmet demand detected for "+ d.getsurgeryName());
                System.out.println("This may indicate a capacity constraint and could warrant further investigation.");
                System.out.println();
            }
            else
            {
                System.out.println("No high demand detected for "+d.getsurgeryName());
            }
        }

    }

    

}

