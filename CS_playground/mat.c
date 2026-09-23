#include <stdio.h>
int main()
{
    int a[20][3], b[20][3], c[40][3], tran[20][3];
    int i, j, k, n, m, n1, m1;
    printf("Enter number of rows:");
    scanf("%d", &n);
    printf("Enter number of columns:");
    scanf("%d", &m);
     int A[n][m];
    printf("Enter elements:");
    for (i = 0; i < n; i++)
    {
        for (j = 0; j < m; j++)
            scanf("%d", &A[i][j]);
    }
    printf("Enter number of rows:");
    scanf("%d", &n1);
    printf("Enter number of columns:");
    scanf("%d", &m1);
    int B[n1][m1];
    int C[n][m];
    if (n != n1 || m != m1)
    {
        printf("Addition not possible");
        return 0;
    }
    for (i = 0; i < n1; i++)
    {
        for (j = 0; j < m1; j++)
            scanf("%d", &B[i][j]);
    }
    a[0][0] = n;
    a[0][1] = m;
    int l = 1;
    for (i = 0; i < n; i++)
    {
        for (j = 0; j < m; j++)
        {
            if (A[i][j] != 0)
            {
                a[l][0] = i;
                a[l][1] = j;
                a[l][2] = A[i][j];
                l++;
            }
        }
    }
    a[0][2] = l - 1;
    b[0][0] = n1;
    b[0][1] = m1;
    int o = 1;
    for (i = 0; i < n1; i++)
    {
        for (j = 0; j < m1; j++)
        {
            if (B[i][j] != 0)
            {
                b[o][0] = i;
                b[o][1] = j;
                b[o][2] = B[i][j];
                o++;
            }
        }
    }
    b[0][2] = o - 1;
    i = 1;
    j = 1;
    k = 1;
    while (i <= a[0][2] && j <= b[0][2])
    {
        if (a[i][0] == b[j][0] && a[i][1] == b[j][1])
        {
            int sum = a[i][2] + b[j][2];
            if (sum != 0)
            {
                c[k][0] = a[i][0];
                c[k][1] = a[i][1];
                c[k][2] = sum;
                k++;
            }
            i++;
            j++;
        }
        else if ((a[i][0] < b[j][0]) || (a[i][0] == b[j][0] && a[i][1] < b[j][1]))
        {
            c[k][0] = a[i][0];
            c[k][1] = a[i][1];
            c[k][2] = a[i][2];
            k++;
            i++;
        }
        else
        {
            c[k][0] = b[j][0];
            c[k][1] = b[j][1];
            c[k][2] = b[j][2];
            k++;
            j++;
        }
    }

    while (i <= a[0][2])
    {
        c[k][0] = a[i][0];
        c[k][1] = a[i][1];
        c[k][2] = a[i][2];
        k++;
        i++;
    }

    while (j <= b[0][2])
    {
        c[k][0] = b[j][0];
        c[k][1] = b[j][1];
        c[k][2] = b[j][2];
        k++;
        j++;
    }

    c[0][0] = n;
    c[0][1] = m;
    c[0][2] = k - 1;

    printf("Sum triplet form\n");
    for (i = 1; i <= c[0][2]; i++)
        printf("%d %d %d\n", c[i][0], c[i][1], c[i][2]);
    tran[0][0] = a[0][1];
    tran[0][1] = a[0][0];
    tran[0][2] = a[0][2];
    int t = 1;

    printf("Transpose matrix of A\n");
    for (i = 0; i < m; i++)
    {
        for (j = 0; j < n; j++)
            printf("%d ", A[j][i]);
        printf("\n");
    }

    for (i = 0; i < a[0][1]; i++)
    {
        for (j = 1; j <= a[0][2]; j++)
        {
            if (a[j][1] == i)
            {
                tran[t][0] = a[j][1];
                tran[t][1] = a[j][0];
                tran[t][2] = a[j][2];
                t++;
            }
        }
    }

    printf("Transpose triplet form\n");
    for (i = 1; i <= a[0][2]; i++)
        printf("%d %d %d\n", tran[i][0], tran[i][1], tran[i][2]);
    for (i = 0; i < n; i++)
    {
        for (j = 0; j < m; j++)
            C[i][j] = A[i][j] + B[i][j];
    }

    printf("Sum matrix form\n");
    for (i = 0; i < n; i++)
    {
        for (j = 0; j < m; j++)
            printf("%d ", C[i][j]);
        printf("\n");
    }

    return 0;
}
while(fgets(line,sizeof(line),fp))
{
        current=line;
        while(pos=strstr(current,find)!=NULL)
        {
            if(pos==line|| !isalpha(*(pos-1))&& !isalpha(*(pos-strlen(find))))
            {
                fwrite(current,1,current-1,temp);
                fprintf(temp,%s,replace);
                current=pos+strlen(find);
            }
            else
            {
                    fwrite(current,1,pos-current+1,temp);
                    current=pos+1;

            }
            fprint(temp,%s,current)
        }
}
