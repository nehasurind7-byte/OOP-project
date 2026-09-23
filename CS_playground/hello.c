#include<stdio.h>
 int main()
    {
        int n,ele,flag=0,ind;
        printf("Enter number of students:");
        scanf("%d",&n);
        int st[n];
        printf("Enter registration numbers:");
        for(int i=0;i<n;i++)
        {
            scanf("%d",&st[i]);
        }
        printf("Enter number to search:");
        scanf("%d",&ele);
        for(int i=0;i<n;i++)
        {
            if(st[i]==ele)
            {
                flag=1;
                ind=i+1;
                break;
            }
        }
        if(flag==1)
        {
                printf("Found %d at %d\n",ele,ind);
        }
        else
        {
                printf("Not Found\n");
        }
        printf("done");
        return 0;
    }