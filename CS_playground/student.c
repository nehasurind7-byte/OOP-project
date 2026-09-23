#include<stdio.h>
struct student
{
    float mark1,mark2,mark3;
    int roll;

};
int main()
{
    int n;
    printf("Enter number of students");
    scanf("%d",&n);
    struct student s[n];
    printf("Enter student details\n");
    for(int i=0;i<n;i++)
    {
        scanf("%d %f %f %f",&s[i].roll,&s[i].mark1,&s[i].mark2,&s[i].mark3);
    }
    printf("Printing details\n");
    for(int i=0;i<n;i++)
    {
        printf("%d %f %f %f\n",s[i].roll,s[i].mark1,s[i].mark2,s[i].mark3);
        float avg;
        avg=(s[i].mark1+s[i].mark2+s[i].mark3)/3;
        printf("average=%f\n",avg);
        if(avg>90)
        {
            printf("grade:A\n");
        }
        else if(avg>80) 
        {
            printf("grade:B\n");
        }
        else
        {
            printf("grade:Pass\n");
        }

    }
    return 0;
}