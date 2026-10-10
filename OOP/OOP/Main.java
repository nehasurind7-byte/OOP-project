package OOP.OOP;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Main 
{

    public static void main(String[] args)
    {
        //HospitalGUI gui=new HospitalGUI();
        System.out.println("NEW MAIN IS RUNNING");

        //==============ORTHOPEDICS========== //
        Analysis analysis = new Analysis();
        ArrayList<Doctor> doctors = new ArrayList<>();

        doctors.add(new Doctor(
            "Dr. A",
            "D001",
            "Orthopedics",
            LocalDate.of(2026, 9, 26),
            LocalTime.of(9, 0),
            LocalTime.of(12, 0),
            40
        ));

        doctors.add(new Doctor(
            "Dr. B",
            "D002",
            "Orthopedics",
            LocalDate.of(2026, 9, 26),
            LocalTime.of(9, 0),
            LocalTime.of(12, 0),
            35
        ));

        doctors.add(new Doctor(
            "Dr. C",
            "D003",
            "Orthopedics",
            LocalDate.of(2026, 9, 26),
            LocalTime.of(12, 0),
            LocalTime.of(15, 0),
            20
        ));

        doctors.add(new Doctor(
            "Dr. D",
            "D004",
            "Orthopedics",
            LocalDate.of(2026, 9, 26),
            LocalTime.of(12, 0),
            LocalTime.of(15, 0),
            25
        ));

        doctors.add(new Doctor(
            "Dr. E",
            "D005",
            "Orthopedics",
            LocalDate.of(2026, 9, 26),
            LocalTime.of(15, 0),
            LocalTime.of(18, 0),
            15
        ));

        doctors.add(new Doctor(
            "Dr. F",
            "D006",
            "Orthopedics",
            LocalDate.of(2026, 9, 26),
            LocalTime.of(15, 0),
            LocalTime.of(18, 0),
            18
        ));
        
       

        ArrayList<Bedrecords> bedrecords = new ArrayList<>();

        bedrecords.add(new Bedrecords(
            "September",
            85,
            100
        ));
        bedrecords.add(new Bedrecords(
            "October",
            25,
            100
        ));
        ArrayList<Demand> demand = new ArrayList<>();

        demand.add(new Demand(
            "Knee Replacement",
            100,
            120,
            5
        ));

        demand.add(new Demand(
            "Arthroscopy",
            100,
            150,
            2
        ));
        Department dept1=new Department("Orthopedics",doctors,bedrecords,demand);
        analysis.analyseDepartment(dept1);

        ArrayList<Workload> workloads =analysis.getWorkloads();

        ArrayList<Bedpercentage> bedPercentages=analysis.getBedPercentages();

        ArrayList<Demandpercentages> demandPercentages=analysis.getDemandPercentages();


        WorkloadReport workloadReport=new WorkloadReport(workloads);

        Bedreport bedReport=new Bedreport(bedPercentages);

        DemandReport demandReport=new DemandReport(demandPercentages);

    
        System.out.println();
        System.out.println("===== WORKLOAD REPORT =====");
        workloadReport.generateReport();

        System.out.println();
        System.out.println("===== WORKLOAD INFERENCE =====");
        workloadReport.showInference();


        System.out.println();
        System.out.println("===== BED REPORT =====");
        bedReport.generateReport();

        System.out.println();
        System.out.println("===== BED INFERENCE =====");
        bedReport.showInference();


        System.out.println();
        System.out.println("===== DEMAND REPORT =====");
        demandReport.generateReport();

        System.out.println();
        System.out.println("===== DEMAND INFERENCE =====");
        demandReport.showInference();

        // ==================== NEUROLOGY ====================

        ArrayList<Doctor> neurologyDoctors = new ArrayList<>();

        neurologyDoctors.add(new Doctor(
        "Dr. G",
         "N001",
        "Neurology",
        LocalDate.of(2026, 9, 26),
        LocalTime.of(9, 0),
        LocalTime.of(12, 0),
        28
        ));

        neurologyDoctors.add(new Doctor(
        "Dr. H",
        "N002",
        "Neurology",
        LocalDate.of(2026, 9, 26),
        LocalTime.of(9, 0),
        LocalTime.of(12, 0),
        32
        ));

        neurologyDoctors.add(new Doctor(
        "Dr. I",
        "N003",
        "Neurology",
        LocalDate.of(2026, 9, 26),
        LocalTime.of(12, 0),
        LocalTime.of(15, 0),
        22
        ));

        neurologyDoctors.add(new Doctor(
        "Dr. J",
        "N004",
        "Neurology",
        LocalDate.of(2026, 9, 26),
        LocalTime.of(12, 0),
        LocalTime.of(15, 0),
        26
        ));

        neurologyDoctors.add(new Doctor(
            "Dr. K",
            "N005",
            "Neurology",
            LocalDate.of(2026, 9, 26),
            LocalTime.of(15, 0),
            LocalTime.of(18, 0),
            18
        ));

        neurologyDoctors.add(new Doctor(
        "Dr. L",
        "N006",
        "Neurology",
        LocalDate.of(2026, 9, 26),
        LocalTime.of(15, 0),
        LocalTime.of(18, 0),
        21
        ));




        ArrayList<Bedrecords> neurologyBeds = new ArrayList<>();

        neurologyBeds.add(new Bedrecords(
        "September",
        72,
        100
        ));

        neurologyBeds.add(new Bedrecords(
        "October",
        88,
        100
        ));




        ArrayList<Demand> neurologyDemand = new ArrayList<>();

        neurologyDemand.add(new Demand(
        "Brain Tumor Surgery",
        70,
        45,
        4
        ));

        neurologyDemand.add(new Demand(
        "Spinal Surgery",
        80,
        60,
        3
        ));




        Department neurology = new Department(
        "Neurology",
        neurologyDoctors,
        neurologyBeds,
        neurologyDemand
        );




        analysis.analyseDepartment(neurology);

        ArrayList<Workload> neuroWorkloads=analysis.getWorkloads();

        ArrayList<Bedpercentage> neuroBedPercentages=analysis.getBedPercentages();

        ArrayList<Demandpercentages> neuroDemandPercentages=analysis.getDemandPercentages();



        WorkloadReport neuroWorkloadReport=new WorkloadReport(neuroWorkloads);

        Bedreport neuroBedReport=new Bedreport(neuroBedPercentages);

        DemandReport neuroDemandReport=new DemandReport(neuroDemandPercentages);



        System.out.println();
        System.out.println("===== NEUROLOGY WORKLOAD REPORT =====");
        neuroWorkloadReport.generateReport();

        System.out.println();
        System.out.println("===== NEUROLOGY WORKLOAD INFERENCE =====");
        neuroWorkloadReport.showInference();

        System.out.println();
        System.out.println("===== NEUROLOGY BED REPORT =====");
        neuroBedReport.generateReport();

        System.out.println();
        System.out.println("===== NEUROLOGY BED INFERENCE =====");
        neuroBedReport.showInference();

        System.out.println();
        System.out.println("===== NEUROLOGY DEMAND REPORT =====");
        neuroDemandReport.generateReport();

        System.out.println();
        System.out.println("===== NEUROLOGY DEMAND INFERENCE =====");
        neuroDemandReport.showInference();
    }
}
    


