#include<stdio.h>
#include<stdlib.h>
typedef struct node
{
    int val;
    struct node *next;
}Node;
typedef struct
{
    Node *head;
}MyLinkedList;
MyLinkedList *obj;
MyLinkedList* MyLinkedListCreate()
{
    obj=(MyLinkedList*)malloc(sizeof(MyLinkedList));
    obj->head=NULL;
    return obj;
}
int myLinkedListGet(MyLinkedList *obj,int index)
{
    Node *temp=obj->head;
    int count=0;
    while(temp!=NULL )
    {
        if(count==index)
        {
            return temp->val;
        }
        count++;
        temp=temp->next;
    }
    return -1;

}
void myLinkedListAddAtHead(MyLinkedList *obj,int val)
{
    Node *newnode;
    newnode=(Node *)malloc(sizeof(Node));
    if(obj->head==NULL)
    {
        obj->head=newnode;
        newnode->val=val;
        newnode->next=NULL;
        return;
    }
    newnode->next=obj->head;
    newnode->val=val;
    obj->head=newnode;
}
void myLinkedListAddAtTail(MyLinkedList *obj,int val)
{
    Node *newnode;
    newnode=(Node *)malloc(sizeof(Node));
    if(obj->head==NULL)
    {
        obj->head=newnode;
        newnode->val=val;
        newnode->next=NULL;
        return;
    }
    Node *temp;
    temp=obj->head;
    while(temp->next!=NULL)
    {
        temp=temp->next;
    }   
    temp->next=newnode;
    newnode->next=NULL;
    newnode->val=val;
}
void myLinkedListAddAtIndex(MyLinkedList *obj,int index,int val)
{
    Node *temp;
    int count=-1;
    temp=obj->head;
    Node *newnode=(Node *)malloc(sizeof(Node));
    newnode->val=val;
    int count1=0;
    if(obj->head==NULL && index==0)
    {
        newnode->next=NULL;
        obj->head=newnode;
        return;
    }
    if(index==0)
    {
        newnode->next=temp;
        obj->head=newnode;   
        return;
    }
    while(temp!=NULL)
    {
        count1++;
        temp=temp->next;
    }
    temp=obj->head;
    if(index==count1)
    {
        while(temp->next!=NULL)
        {
            temp=temp->next;
        }
        temp->next=newnode;
        newnode->next=NULL;
        return;
    }
    temp=obj->head;
    while(temp->next!=NULL)
    {
        if(count==index-1)
        {
            Node *temp1;
            temp1=temp->next;
            temp->next=newnode;
            newnode->next=temp1;
            return;
        }
        count++;
        temp=temp->next;

    }
}
void myLinkedListDeleteAtIndex(MyLinkedList *obj,int index)
{
    int count=-1;
    Node *temp=obj->head;
    if(obj->head==NULL)
    {
        return;
    }
    if(index==0)
    {
        obj->head=temp->next;
        free(temp);
        return;
        
    }
    while(temp!=NULL)
    {
        if(count==index-1)
        {
            Node *temp1=temp->next->next;
            free(temp->next);
            temp->next=temp1;
            return;
        }
        count++;
        temp=temp->next;
    }

}