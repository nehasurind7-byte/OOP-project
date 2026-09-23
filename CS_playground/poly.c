#include<stdio.h>
#include<stdlib.h>
struct node 
{
    int exp;
    int coeff;
    struct node *next;
};

void poly_add(struct node *first,struct node *second,int n,int m)
{
    struct node *temp,*temp1,*temp2,temp3,*res=NULL;
    temp=first;
    temp2=second;
    struct node *new_node,*prev;
    int i=0,j=0;
    while(i<n && j<m)
    {
        if(res==NULL)
        {
            res=(struct node *)malloc(sizeof(struct node));
            res->next=NULL;
            prev=res;
        }
        else
        {
            new_node=(struct node *)malloc(sizeof(struct node ));
            new_node->next=NULL;
            prev->next=new_node;
            prev=new_node;
        }
        if((temp->exp)>(temp2->exp))
        {
            prev->coeff=temp->coeff;
            prev->exp=temp->exp;
            temp=temp->next;
            i++;
        }
        else if ((temp->exp)<(temp2->exp))
        {
            prev->coeff=temp2->coeff;
            prev->exp=temp2->exp;
            temp2=temp2->next;
            j++;
        }
        else
        {
            int sum=(temp->coeff)+(temp2->coeff);
            if(sum!=0)
            {
                prev->coeff=sum;
            }
            prev->exp=temp->exp;
            temp=temp->next;
            temp2=temp2->next;
            i++;
            j++;
        }
        
    }
    while(i<n && temp!=NULL)
    {
        new_node=(struct node *)malloc(sizeof(struct node));
        new_node->next=NULL;
        prev->next=new_node;
        prev=new_node;
        prev->coeff=temp->coeff;
        prev->exp=temp->exp;
        temp=temp->next;
        i++;
    }
    while(j<m && temp2!=NULL)
    {
        new_node=(struct node*)malloc(sizeof(struct node));
        new_node->next=NULL;
        prev->next=new_node;
        prev=new_node;
        prev->coeff=temp2->coeff;
        prev->exp=temp2->exp;
        temp2=temp2->next;
        j++;
    }
    struct node *ptr=res;
    while(ptr!=NULL)
    {
        printf("%dx^%d",ptr->coeff,ptr->exp);
        ptr=ptr->next;
        if(ptr!=NULL)
        {
            printf("+");
        }
    }
}
void poly_mul(struct node *first,struct node *second,int n,int m)
{
    struct node *res=NULL,*temp,*temp2,*new_node,*prev=NULL;
    int k=0;
    temp=first;
    for(int i=0;i<n;i++)
    {
        temp2=second;
        for(int j=0;j<m;j++)
        {
            if(res==NULL)
            {
                res=(struct node *)malloc(sizeof(struct node));
                res->next=NULL;
                prev=res;
            }
            else
            {
                new_node=(struct node *)malloc(sizeof(struct node ));
                new_node->next=NULL;
                prev->next=new_node;
                prev=new_node;
            }
            prev->coeff=(temp->coeff)*(temp2->coeff);
            prev->exp=(temp->exp)+(temp2->exp);
            temp2=temp2->next;
        }
        temp=temp->next;
    }
    prev=res->next;
    struct node *ptr=res;
    while(prev!=NULL && prev->next!=NULL)
    {
        if((prev->exp)==((prev->next)->exp))
        {
            prev->coeff=prev->coeff+(prev->next)->coeff;
            struct node *ptr=prev->next;
            prev->next=ptr->next;
            free(ptr);
        }
        else
        {
            prev=prev->next;
        }
    }
    
    prev=res;
    while(prev!=NULL) 
    {
        if(prev->exp!=0)
        {
            printf("%dx^%d",prev->coeff,prev->exp);
        }
        else
        {
            printf("%dx",prev->coeff);      
        }
        if(prev->next!=NULL)
        {
            printf("+");
        }
        prev=prev->next;
    }
    
}

int main()
{
    int n,m;
    struct node *temp,*temp1,*temp2,temp3;
    struct node*first,*second;
    printf("Enter number of terms in polynomial 1:");
    scanf("%d",&n);
    printf("Enter coeffecients and exponents of polynomial 1 in decreasing order:");
    for(int i=0;i<n;i++)
    {
        if(i==0)
        {
            first=(struct node *)malloc(sizeof(struct node));
            first->next=NULL;
            temp=first;
        }
        else
        {
            temp1=(struct node *)malloc(sizeof(struct node));
            temp->next=temp1;
            temp1->next=NULL;
            temp=temp1;    
        }
       scanf("%d %d",&temp->coeff,&temp->exp);
    }
    printf("Enter number of terms in polynomial 2:");
    scanf("%d",&m);    
    printf("Enter coeffecients and exponents of polynomial 2 in decreasing order:");
    for(int i=0;i<m;i++)
    {
        if(i==0)
        {
            second=(struct node *)malloc(sizeof(struct node));
            second->next=NULL;
            temp2=second;
        }
        else
        {
            struct node *temp3=(struct node *)malloc(sizeof(struct node));
            temp2->next=temp3;
            temp3->next=NULL;
            temp2=temp3;    
        }
       scanf("%d %d",&temp2->coeff,&temp2->exp);
    }
    poly_add(first,second,n,m);
    printf("\n");
    poly_mul(first,second,n,m);
    return 0;
}