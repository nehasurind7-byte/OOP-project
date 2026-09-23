package OOP.OOP;
import java.time.LocalDate;
import java.time.LocalTime;
class Doctor
{
    private String name;
    private String id;
    private String specialization;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private int patientCount;
    Doctor(String name, String id,String specialization,LocalDate date,LocalTime startTime,LocalTime endTime,int patientCount)
    {
        this.name=name;
        this.id=id;
        this.specialization=specialization;
        this.date=date;
        this.startTime=startTime;
        this.endTime=endTime;
        this.patientCount=patientCount;
    } 
    public LocalDate getDate() 
    {
        return date;
    }
    public LocalTime getEndTime() 
    {
        return endTime;
    }
    public LocalTime getStartTime() 
    {
        return startTime;
    }
    public int getpatientCount()
    {
        return patientCount;
    }
}