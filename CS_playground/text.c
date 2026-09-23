#include<stdio.h>
#include<string.h>
int main(){
	FILE *fin,*fout;
	char word[100],find[100],replace[100];
	int ch,i;
	printf("Enter find word:");
	scanf("%s",find);
	printf("Enter replace word:");
	scanf("%s",replace);
	fin=fopen("input.txt","r");
	if(fin==NULL){
		printf("Unable to open input file\n");
		return 1;
	}
	fout=fopen("output.txt","w");
	if(fout==NULL){
		printf("Unable to open output file\n");
		fclose(fin);
		return 1;
	}
	while((ch=fgetc(fin))!=EOF){
		if(ch==find[0]){
			word[0]=ch;
			i=1;
			while(i<strlen(find)){
				ch=fgetc(fin);
				if(ch==EOF)
					break;
				word[i]=ch;
				i++;
			}
			word[i]='\0';
			if(strcmp(word,find)==0){
				fputs(replace,fout);
			}
			else{
				fputs(word,fout);
				
				}
				}
		else{
			fputc(ch,fout);
		}
		
	}
	fclose(fin);
	fclose(fout);
	printf("Find and Replace successfully completed.");
	printf("Modified output is stored  in output.txt file");
	return 0;
}
