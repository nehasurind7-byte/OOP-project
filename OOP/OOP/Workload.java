package OOP.OOP;

import java.time.LocalDate;

public class Workload {
    LocalDate date;
    double ratio;
    double ratio1;
    double ratio2;
    double dailyavg;
    Workload(LocalDate date,double ratio,double ratio1,double ratio2,double dailyavg)
    {
        this.date=date;
        this.ratio=ratio;
        this.ratio1=ratio1;
        this.ratio2=ratio2;
        this.dailyavg=dailyavg;
    }
    double getRatio()
    {
        return ratio;
    }
    double getRatio1()
    {
        return ratio1;
    }
    double getRatio2()
    {
        return ratio2;
    }
    double getDailyavg()
    {
        return dailyavg;
    }
    LocalDate getLocalDate()
    {
        return  date;
    }
}
