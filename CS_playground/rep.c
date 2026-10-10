#include<stdio.h>
#include<string.h>
int main()
{
    char word[100],replace[100],find[100];
    int i;
    char ch;
    FILE *fp1,*fp2;
    int rep=0;
    fp1=fopen("input.txt","r");
    if(fp1==NULL)
    {
        printf("Unable to open file");
        return 1;
    }
    fp2=fopen("output.txt","w");
    if(fp2==NULL)
    {
        printf("Unable to open output file");
        return 1;
    }
    printf("Enter word to find:");
    scanf("%s",find);
    printf("Enter relacement word:");
    scanf("%s",replace);
    while((ch=fgetc(fp1))!=EOF)
    {
        if(ch==find[0])
        {
            word[0]=ch;
            i=1;
            while(i<strlen(find))
            {
                ch=fgetc(fp1);
                if(ch==EOF)
                    break;
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
    printf("Word replaced");
    return 0;
}

 