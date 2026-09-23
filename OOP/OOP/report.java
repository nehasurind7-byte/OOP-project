package OOP.OOP;
import java.util.ArrayList;

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
        for(Workload w : workloads)
        {
            System.out.println(w.getRatio());
            System.out.println(w.getRatio1());
            System.out.println(w.getRatio2());
            System.out.println(w.getDailyavg());
        }
    }
     void showInference()
    {
        for(Workload w : workloads)
        {
            if(w.getRatio() > 30)
                System.out.println("High workload detected: 9 AM - 12 PM");

            if(w.getRatio1() > 30)
                System.out.println("High workload detected: 12 PM - 3 PM");

            if(w.getRatio2() > 30)
                System.out.println("High workload detected: 3 PM - 6 PM");
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
        }
    }
    void showInference()
    {
        for(Bedpercentage B:occuBedpercentages)
        {
            if(B.getPercentage()>90)
            {
                System.out.println("Very high occupancy ");
            }
            if(B.getPercentage()<90 && B.getPercentage()>70)
            {
                System.out.println("High occupancy ");
            }
            if(B.getPercentage()<70)
            {
                System.out.println("Normal occupancy ");
            }
        }
    }
}
class DemandReport extends report
{
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
        }
    }
    void showInference()
    {
        for(Demandpercentages d:demandpercentages)
        {
            if(d.gettotalDemand() > 180 && d.getunmetPercentage() > 50)
            {
                System.out.println("High unmet demand detected for "+ d.getsurgeryName());
                System.out.println("This may indicate a capacity constraint and could warrant further investigation.");
            }
        }
    }
}

