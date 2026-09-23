package OOP.OOP;
class Bedrecords
{
    private int bedOccupied;
    private int bedTotal;
    private String month;
    Bedrecords(String month,int bedOccupied,int bedTotal)
    {
        this.month=month;
        this.bedTotal=bedTotal;
        this.bedOccupied=bedOccupied;
    }
    public int getbedOccupied()
    {
        return bedOccupied;
    }
    public int getbedTotal()
    {
        return bedTotal;
    }
    public String getMonth()
    {
        return month;
    }
}