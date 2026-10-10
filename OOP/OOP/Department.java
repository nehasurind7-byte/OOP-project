package OOP.OOP;
import java.util.ArrayList;


public class Department
{
    private String name;
    private ArrayList<Doctor> doctors;
    private ArrayList<Bedrecords> bedrecords;
    private ArrayList<Demand> demand;
    Department(String name,ArrayList<Doctor> doctors,ArrayList<Bedrecords> bedrecords,ArrayList<Demand> demand)
    {
        this.name=name;
        this.doctors= doctors;
        this.bedrecords=bedrecords;
        this.demand=demand;
        
    }
    public String getName()
    {
        return name;
    }

    public ArrayList<Doctor> getDoctors()
    {
        return doctors;
    }

    public ArrayList<Bedrecords> getBedrecords()
    {
        return bedrecords;
    }

    public ArrayList<Demand> getDemand()
    {
        return demand;
    }

    public void addDoctor(Doctor doctor)
    {
        doctors.add(doctor);
    }

    public void addBedrecord(Bedrecords bedrecord)
    {
        bedrecords.add(bedrecord);
    }

    public void addDemand(Demand d)
    {
        demand.add(d);
    }
}

    

