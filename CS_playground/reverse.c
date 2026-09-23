#include<stdio.h>
#include<stdlib.h>
struct node
{
    int data;
    struct node *next;
};
void display(struct node **head)
{
    struct node *temp;
    if(*head==NULL)
    {
        printf("List is empty");
        return;
    }
    else
    {
        temp=*head;
        while(temp!=NULL)
        {
            printf("%d-> ",temp->data);
            temp=temp->next;
        }
    }
    printf("NULL\n");
    
}
void creatnode(struct node **head,int m)
{
    struct node *newnode,*temp;
    *head=NULL;
    int digit;
    for(int i=0;i<m;i++)
    {
        printf("Enter digit:");
        scanf("%d",&digit);
        newnode=(struct node *)malloc(sizeof(struct node));
        newnode->next=NULL;
        newnode->data=digit;
        if(*head==NULL)
        {
            *head=newnode;
            temp=newnode;
        }
        else
        {
            while(temp->next!=NULL && temp!=NULL)
            {
                temp=temp->next;
            }
            temp->next=newnode;
        }
    }
    display(&*head);
}

void addnum(struct node **head1,struct node **head2)
{
    if(head1==NULL || head2==NULL)
    {
        printf("Cant add");
        return;
    }
    struct node *temp1,*temp2,*temp3,*newnode,*head3=NULL;
    temp1=*head1;
    temp2=*head2;
    int value=0;
    int carry=0;
    while(temp1!=NULL && temp2!=NULL)
    {
        newnode=(struct node *)malloc(sizeof(struct node));
        value=temp1->data+temp2->data;
        newnode->data=(value+carry)%10;
        carry=(value+carry)/10;
        newnode->next=NULL;
        if(head3==NULL)
        {
            head3=newnode;
            temp3=newnode;
        }
        else
        {
            while(temp3->next!=NULL)
            {
                temp3=temp3->next;
            }
            temp3->next=newnode;
        }
        temp1=temp1->next;
        temp2=temp2->next;

    }
    while(temp1!=NULL)
    {
        struct node *newnode;
        newnode=(struct node *)malloc(sizeof(struct node));
        newnode->data=(temp1->data+carry)%10;
        newnode->next=NULL;
         if(head3==NULL)
        {
            head3=newnode;
            temp3=newnode;
        }
        else
        {
            while(temp3->next!=NULL)
            {
                temp3=temp3->next;
            }
            temp3->next=newnode;
        }
        temp1=temp1->next;
    
    }
    while(temp2!=NULL)
    {
        struct node *newnode;
        newnode=(struct node *)malloc(sizeof(struct node ));
        newnode->data=(temp2->data+carry)%10;
        newnode->next=NULL;
        if(head3==NULL)
        {
            head3=newnode;
            temp3=newnode;
        }
        else
        {
            while(temp3!=NULL && temp3->next!=NULL)
            {
                temp3=temp3->next;
            }
            temp3->next=newnode;
        }
        temp2=temp2->next;
    }
    if((temp1==NULL && temp2==NULL)&&carry!=0)
    {
        struct node *newnode=(struct node *)malloc(sizeof(struct node));
        newnode->data=carry;
        newnode->next=NULL;
        while(temp3!=NULL && temp3->next!=NULL)
            {
                temp3=temp3->next;
            }
            temp3->next=newnode;

    }
    display(&head3);
}

int main()
{
    int n,m;
    struct node *temp,*head1,*head2;
    printf("Enter number of digits of first number:");
    scanf("%d",&m);
    creatnode(&head1,m);
    printf("Enter number of digits in second number:");
    scanf("%d",&n);
    creatnode(&head2,n);
    addnum(&head1,&head2);
    return 0;
    
}
