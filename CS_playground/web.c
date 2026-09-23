#include<stdio.h>
#include<stdlib.h>
struct node 
{
    char link[100];
    struct node *next;
    struct node *prev;
};
struct node *first,*temp,*web;
int new()
{
    web=(struct node *)malloc(sizeof(struct node));
    printf("Enter webpage name:");
    scanf("%s",web->link);
    if(first==NULL)
    {
        web->prev=NULL;
        web->next=NULL;
        first=web;
        temp=web;
        return 1;
    }
    
    if(temp!=NULL && temp->next!=NULL)
    {
        struct node *ptr=temp->next;
        temp->next=NULL;
        while(ptr!=NULL)
        {
            struct node *current=ptr;
            ptr=ptr->next;
            free(current);
        }
    }

    web->prev=temp;
    web->next=NULL;
    temp->next=web;
    temp=web;
    return 1;
}
int goback(struct node **temp)
{
    if(temp==NULL || *temp==NULL)
    {
         printf("Cannot go back\n");
         return 1;
    }
    
    if(*temp==first)
    {
        printf("Cannot go back\n");
    }
    else
    {
        *temp=(*temp)->prev;
        printf("current webpage is %s\n",(*temp)->link);
    }
    return 1;
}
int goforward(struct node **temp)
{
        if (temp == NULL || *temp == NULL) 
        {
            printf("History is empty. Cannot go forward.\n");
            return 1;
        }
        if((*temp)->next==NULL)
        {
            printf("Cannot go forward\n");
        }
        else
        {
            *temp=(*temp)->next;
            printf("current webpage is %s\n",(*temp)->link);
        }  
        return 1; 

}
int main()
{
    temp=first;
    int key;
    while(1)
    {
        printf("MENU\n\nTO GO TO NEW WEBPAGE PRESS 1\n\nTO GO BACK PRESS 2\n\nTO GO FORWARD PRESS 3\n\nTO EXIT PRESS 4\n\n");
        printf("ENTER:");
        scanf("%d",&key);
        switch(key)
        {
                
            case 1:
            {
                new();
                break;
            }
            case 2:
            {
                goback(&temp);
                break;
                    
            }
            case 3:
            {
                goforward(&temp);
                break;
                
            }
            case 4:
            {
                printf("EXITING...");
                return 0;
                
            }
        }    
    }
    
}

