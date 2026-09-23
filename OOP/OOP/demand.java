package OOP.OOP;
class Demand
{
    private String surgeryName;
    private int performedCount;
    private int unmetCount;
    private int equipmentCount;
    Demand(String surgeryName,int performedCount,int unmetCount,int equipmentCount)
    {
        this.surgeryName=surgeryName;
        this.equipmentCount=equipmentCount;
        this.performedCount=performedCount;
        this.unmetCount=unmetCount;
    }
    public String getsurgeryName()
    {
        return surgeryName;
    }
    public int getperformedCount()
    {
        return performedCount;
    }
    public int getunmetCount()
    {
        return unmetCount;
    }
    public int getequipmentCount()
    {
        return equipmentCount;
    }
    public int gettotalDemand()
    {
        return unmetCount+performedCount;
    }
}
