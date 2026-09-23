#include<stdio.h>
#include<stdlib.h>
int main()
{
    FILE *fp3;
    fp3=fopen("new.txt","w");
    char word[100],find[100],replace[100];
    if(fp3==NULL)
    {
        printf("Unable to open file");
        return 1;
    }
    fputs("Hello World.This is my first file program",fp3);
    return 0;
    char ch;
    int i;
    while((ch=fgetc(fp3)!=EOF))
    {
        if(ch==find[0])
        {
            word[0]=ch;
            i=1;
            while(i<strlen(find))
            {
                ch=fgetc(fp3);
                if(ch==NULL)
                {
                    return 1;
                }
                word[i]=ch;
                i++;
            }
            word[i]='\0';
            if(strcmp(word,find)==0)
            {
                
            }
        }
    }
}