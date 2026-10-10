#include<stdio.h>
#include<stdlib.h>
struct node
{
    struct node *next;
    int data;
};
struct node *createNode(int data)
{
    struct node *newnode;
    newnode=(struct node *)malloc(sizeof(struct node));
    if(newnode==NULL)
    {
        printf("not allocated");
    }
    newnode->data=data;
    newnode->next=NULL;
    return newnode;
}
struct node *insertNode(struct node *head,int data)
{
    struct node *newnode=createNode(data);
    if(head==NULL)
    {
        head=newnode;
        return newnode;
    }
    struct node *temp;
    temp=head;
    while(temp->next!=NULL)
    {
        temp=temp->next;
    }
    temp->next=newnode;
    return head;
}
struct node *insertNode1(struct node *head,int data)
{
    struct node *newnode=createNode(data);
    if(head==NULL)
    {
        head=newnode;
        return newnode;
    }
    newnode->next=head;
    head=newnode;
    return head;
}
struct node *insertbefore(struct node *head,int data,int value)
{
    struct node *newnode=createNode(data);
    if(head==NULL)
    {
        printf("list is empty");
        exit(1);
    }
    struct node *temp;
    temp=head;
    while(temp->next->data!=value)
    {
        temp=temp->next;
    }
    newnode->next=temp->next;
    temp->next=newnode;
    return head;
}
struct node *insertafter(struct node *head,int data,int value)
{
    struct node *newnode=createNode(data);
    if(head==NULL)
    {
        printf("list is empty");
        exit(1);
    }
    struct node *temp;
    temp=head;
    while(temp->data!=value)
    {
        temp=temp->next;
    }
    newnode->next=temp->next;
    temp->next=newnode;
    return head;
}
struct node *deletefront(struct node *head)
{
    if(head==NULL)
    {
        printf("List is empty");
        exit(1);
    }
    if(head->next==NULL)
    {
        free(head);
        return NULL;
    }
    struct node *temp=head;
    head=head->next;
    free(temp);
    return head;
}
struct node *deleterear(struct node *head)
{
    if(head==NULL)
    {
        printf("List is empty");
        exit(1);
    }
    if(head->next==NULL)
    {
        free(head);
        return NULL;
    }
    struct node *temp=head;
    while(temp!=NULL && temp->next->next!=NULL)
    {
        temp=temp->next;
    }
    free(temp->next);
    temp->next=NULL;
    return head;
    
}
struct node *deleteafter(struct node *head,int value)
{
    if(head==NULL)
    {
        printf("List is empty");
        exit(1);
    }
    struct node *temp=head;
    while(temp!=NULL && temp->data!=value)
    {
        temp=temp->next;
    }
    if (temp == NULL || temp->next == NULL) {
        printf("Node with value %d not found or has no node after it.\n", value);
        return head;
    }
    struct node *temp1;
    temp1=temp->next;
    temp->next=temp1->next;
    free(temp1);
    return head;
}
struct node *deletebefore(struct node *head,int value)
{
    if(head==NULL)
    {
        printf("List is empty");
        exit(1);
    }
    if(head->next==NULL || head==NULL)
    {
        printf("No value before");
        return head;
    }
    if(head->next->data==value)
    {
        struct node *temp=head;
        head=head->next;
        free(temp);
        return head;
    }
    struct node *temp;
    struct node *prev;
    temp=head->next;
    prev=head;
    while(temp->next!=NULL && temp->next->data!=value)
    {
        prev=temp;
        temp=temp->next;

    }
    if(temp->next==NULL)
    {
        printf("Element not found");
        return head;
    }
    prev->next=temp->next;
    free(temp);

    return head;

}
void display(struct node *head)
{
    struct node *temp=head;
    while(temp!=NULL)
    {
        printf("%d->",temp->data);
        temp=temp->next;
    }
    printf("NULL\n");
}
struct node *concate(struct node *head,struct node *head1)
{
    struct node *temp=head;
    while(temp->next!=NULL)
    {
        temp=temp->next;
    }
    temp->next=head1;
    return head;
}
struct node *inspos(struct node *head,int data,int pos)
{
    int n=pos-1;
    struct node *temp=head;
    int i=-1;
    struct node *newnode=createNode(data);
    if(n==0)
    {
       newnode->next=head;
       head=newnode;
       return head; 
    }
    while(temp!=NULL && i<n-1 )
    {
        i++;
        temp=temp->next;
    }
    newnode->next=temp->next;
    temp->next=newnode;
    return head;
}
struct node *occ(struct node *head,int value)
{
    if(head==NULL)
    {
        printf("list is empty");
        exit(1);
    }
    if(head->next==NULL && head->data==value)
    {
        free(head);
        return NULL;
    }
    if(head->data==value)
    {
        struct node *temp;
        temp=head;
        head=head->next;
        free(temp);
    }
    struct node *temp;
    temp=head;
    int n=0;
    display(head);
    while(temp!=NULL)
    {
        if(temp->data==value)
        {
            n++;
        }
        if(temp->next->next==NULL && temp->next->data==value)
        {
            free(temp->next);
            temp->next=NULL;
        }
        temp=temp->next;
    }
    printf("%d\n",n);
    for(int i=0;i<n;i++)
    {
        struct node *temp=head;
        while(temp->next!=NULL && temp->next->data!=value)
        {
           temp=temp->next;
        }
        struct node *temp1;
        temp1=temp->next;
        temp->next=temp1->next;
        free(temp1);
    }
    return head;
}
int main()
{
    struct node *head=NULL;
    //head=insertNode(head,10);
    //display(head);
    //head=insertNode(head,20);
    //display(head);
    //head=insertNode(head,30);
    //display(head);
    //head=insertNode1(head,40);
    //display(head);
    //head=insertNode1(head,50);
    //display(head);
    //head=insertafter(head,5,30);
    //display(head);
    //head=insertbefore(head,5,30);
    //display(head);
    //head=insertafter(head,40,40);
    /*struct node *head1=NULL;
    head1=insertNode(head1,10);
    //display(head1);
    head1=insertNode(head1,20);
    //display(head1);
    head1=insertNode(head1,30);
    //display(head1);
    head1=insertNode1(head1,40);
    //display(head1);
    head1=insertNode1(head1,50);
    //display(head1);
    head1=insertafter(head1,5,30);
    //display(head1);
    head1=insertbefore(head1,5,30);
    //display(head1);
    head=concate(head,head1);
    //display(head);
    head=inspos(head,40,1);
    display(head);*/
    //head=occ(head,40);
    //display(head);
    int x=10;
    printf(&x);
    int *p=&x;
    printf(*p);

    return 0;
}