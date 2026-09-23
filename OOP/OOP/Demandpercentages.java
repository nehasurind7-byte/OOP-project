package OOP.OOP;

public class Demandpercentages {
    String surgeryName;
    double unmetPercentage;
    double performedPercentage;
    int equipmentCount;
    int totalDemand;
    Demandpercentages(String surgeryName,double unmetPercentage,double performedPercentage,int equipmentCount,int totalDemand)
    {
        this.surgeryName=surgeryName;
        this.unmetPercentage=unmetPercentage;
        this.performedPercentage=performedPercentage;
        this.equipmentCount=equipmentCount;
        this.totalDemand=totalDemand;
    }
    String getsurgeryName()
    {
        return surgeryName;
    }
    double getunmetPercentage()
    {
        return unmetPercentage;
    }
    double getperformedPercentage()
    {
        return performedPercentage;
    }
    int getequipmentCount()
    {
        return equipmentCount;
    }
    int gettotalDemand()
    {
        return totalDemand;
    }    
}
