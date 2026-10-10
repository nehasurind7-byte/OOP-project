package OOP.OOP;

public class errorhandling {
{
        Department dept=new Department(null, null, null, null);
        Analysis analysis=new Analysis();
       try
        {
            analysis.demandAnalysis(dept.getDoctors(),dept.getName());
            analysis.demandAnalysis(dept.getName(),dept.getBedrecords());
            analysis.demandAnalysis(dept.getDemand());
        }
        catch (ArithmeticException e) 
        {
            System.out.println(e.getMessage());
        }


}
    
}
