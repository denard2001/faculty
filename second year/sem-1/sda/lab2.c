#include <stdlib.h>
#include <stdio.h>
#include <string.h>

FILE *f;

typedef struct 
{
    int cod;
    char denumire[350];
}job;
job x[5000];
char s[350];
int cod,i=0;

int bsearch1(job x[],int stanga, int dreapta, int find)
{
    if(stanga > dreapta)
    {
        return -1;
    }
    else 
    {
        int mij=( stanga + dreapta)/2;
        
        if(x[mij].cod==find)
            return mij;
        
         if(x[mij].cod<find)
            return bsearch1(x,stanga,mij-1,find);

        if(x[mij].cod>find)
            return bsearch1(x,mij+1,dreapta,find);
        
    }
}

int check(char s1[],char s2[])
{
    
    if(strncmp(s1,s2,strlen(s2))==0)
        return 1;

    return 0;
}
int main()
{

    if((f=fopen("COR_Descrescator.txt","r"))==NULL)
    {
        printf("eroare fisier");
        exit(EXIT_FAILURE);
    }

    fgets(s,350,f);
    
    while(!feof(f))
    {
        fscanf(f, "%d %[^\n]s", &cod, s);
        strcpy(x[i].denumire,s);
        x[i].cod=cod;
        i++;
    }

    printf("Introduceti codul:");
    int c;
    scanf("%d",&c);
    int nr=bsearch1(x,0,i-1,c);
    
    if(nr==-1)
        printf("COD INEXISTENT\n");
    else
        printf("%s\n",x[nr].denumire);
    
    char s3[350];
    scanf("%s",s3);
    
    for(int j;j<i-1;j++)
    {
        if(check(x[j].denumire,s3)==1)
            printf("%s\n",x[j].denumire);
    }

    fclose(f);
}