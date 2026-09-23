#include<stdio.h>
#include<stdlib.h>
#include<string.h>
int main()
{
    FILE *fp1,*fp2;
    char word[100],replace[100],find[100];
    char ch;
    int i;
    fp1=fopen("input.txt","r");
    if(fp1==NULL)
    {
        printf("Unable to open input file");
        return 1;
    }
    printf("Enter word to find:");
    scanf("%s",find);
    printf("Enter replacement word:");
    scanf("%s",replace);
    fp2=fopen("output.txt","w");
    if(fp2==NULL)
    {
        printf("Unable to open output file");
        return 1;
    }
    while((ch=fgetc(fp1))!=EOF)
    {
        if(ch==find[0])
        {
            i=1;
            word[0]=ch;
            while(i<strlen(find))
            {
                ch=fgetc(fp1);
                if(ch==EOF)
                {
                    break;
                }
                word[i]=ch;
                i++;
            }
            word[i]='\0';
            if(strcmp(word,find)==0)
            {
                fputs(replace,fp2);
            }
            else
            {
                fputs(word,fp2);
            }
        }
        else
        {
            fputc(ch,fp2);
        }
    }
    fclose(fp1);
    fclose(fp2);
    printf("Word replaced successfully");
    return 0;
}