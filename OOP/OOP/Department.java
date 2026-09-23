package OOP.OOP;
import java.util.ArrayList;


public class Department
{
    private String name;
    private ArrayList<Doctor> doctors;
    private ArrayList<Bedrecords> bedrecords;
    private ArrayList<Demand> demand;
    Department(String name)
    {
        this.name=name;
        this.doctors=new ArrayList<>();
        this.bedrecords=new ArrayList<>();
        this.demand=new ArrayList<>();
        
    }
}
    

