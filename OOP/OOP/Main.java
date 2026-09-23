package OOP.OOP;

import java.util.ArrayList;

public class Main {
   

    public static void main(String args[])
    {
        HospitalGUI gui = new HospitalGUI();
        Department department = new Department("Cardiology");
        Analysis analysis = new Analysis();
        System.out.println("Hospital Analysis System Started");
        ArrayList<Workload> workloads=new ArrayList<>();
        WorkloadReport report = new WorkloadReport(workloads);
    }

}
