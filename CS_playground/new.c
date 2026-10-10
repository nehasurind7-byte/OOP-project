#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<ctype.h>
int main()
{
    FILE *fp3,*fp2;
    fp3=fopen("new.txt","w");
    int i,pos=0;
    char word[100],find[100],replace[100],ch;
    int last;
    if(fp3==NULL)
    {
        printf("Unable to open file");
        return 1;
    }
    fputs("Hello World.This is my first firstsecond file program, first",fp3);
    fclose(fp3);
    printf("Enter word:");
    scanf("%s",find);
    printf("Enter replace word");
    scanf("%s",replace);
    fp3=fopen("new.txt","r");
    char text[100];
    if(fp3==NULL)
    {
        printf("Unable to open file");
        return 1;
    }
    fp2=fopen("new1.txt","w");
    if(fp2==NULL)
    {
        printf("File not found");
        return 1;
    }
    while((ch=fgetc(fp3))!=EOF)
    {
        text[pos]=ch;
        pos++;
        
    }
    text[pos]='\0';
    for(i=0;i<pos;i++)
    {
        if(strncmp(&text[i],find,strlen(find))==0 && !isalnum(text[i-1]) && !isalnum(text[i+strlen(find)]))
        {
            last=i;
        }
    }
    i=0;
    while(i<pos)
    {
        if(i==last)
        {
            fputs(replace,fp2);
            i=i+strlen(find);
        }
        else
        {
            fputc(text[i],fp2);
            i++;
        }
    }
    fclose(fp2);
    fclose(fp3);
    return 0;
}