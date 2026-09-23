#include<stdio.h>
#define MAX 2
int queue[MAX],dqueue[MAX],cqueue[MAX];
int q_rear=-1,d_rear=-1,c_rear=-1;
int q_front=-1,d_front=-1,c_front=-1;
void enqueue()
{
        int n;
    if(q_rear==MAX-1)
    {
        printf("Queue overflow\n");
        return;
    }
    if(q_front==-1)
    {
        q_front=0;
    }
    
    printf("Enter number to insert:");
    scanf("%d",&n);
    q_rear++;
    queue[q_rear]=n;
    printf("%d was inserted at %d\n",n,q_rear);
    
}
void dequeue()
{
    if((q_front==-1))
    {
        printf("Queue is empty\n");
    }
    else if(q_front>q_rear)
    {
        q_front=-1;
        q_rear=-1;
    }
    else
    {

        printf("Deleted item=%d %d\n",queue[q_front],q_front);
        q_front++;
    }

}
void display()
{
    if(q_front==-1)
    {
        printf("queue is empty\n");
        return;
    }
   else
   {
    for(int i=q_front;i<=q_rear;i++)
    {
        printf("%d\n",queue[i]);
    }
   }
}
void insertfront()
{
        int n;
        

    if((d_front==0 && d_rear==MAX-1) ||(d_front==d_rear+1))
    {
        printf("OVERFLOW\n");
        return;
    }
    printf("Enter number to insert:");
    scanf("%d",&n);
    if(d_front==-1)
    {
        d_front=0;
        d_rear=0;
    }
    else if(d_front==0)
    {
        d_front=MAX-1;
    }
    else 
    {
        
        d_front--;
    }
    dqueue[d_front]=n;
    printf("%d was inserted\n",n);
}
void insertrear()
{
    int n;
    
    if((d_front==0 && d_rear==MAX-1) ||(d_front==d_rear+1))
    {
        printf("overflow\n");
        return;
    }
    printf("Enter number to insert:");
    scanf("%d",&n);
    if(d_front==-1)
    {
        d_front=0;
        d_rear=0;
    }
    else if(d_rear==MAX-1)
    {
        d_rear=0;
    }
    else 
    {
       
        d_rear++;
    }
    dqueue[d_rear]=n;
    printf("%d was inserted\n",n);
}
void deletefront()
{

  
    
    if(d_front==-1)
    {
        printf("UNDERFLOW\n");
        return;
    }
    printf("%d was deleted\n",dqueue[d_front]);

    if(d_front==d_rear)
    {

        d_front=-1;
        d_rear=-1;

    }
    else if(d_front==MAX-1)
    {
        d_front=0;
    }
    else
    {
      
       d_front++;
    }
    
}
void deleterear()
{
    
    
    if(d_front==-1)
    {
        printf("UNDERFLOW\n");
        return;
    }
    printf("%d was deleted\n",dqueue[d_rear]);

    if(d_front==d_rear)
    {
        d_front=-1;
        d_rear=-1;
    }
    else if(d_rear==0)
    {
        d_rear=MAX-1;
    }
    else
    {
       
        d_rear--;
    }
}
void d_display()
{
    if(d_front==-1)
    {
        printf("UNDERFLOW\n");
    }
    else
    {
        int i=d_front;
        while(1)
        {
            printf("%d\n",dqueue[i]);
            if(i==d_rear)
            {
                return;
            }
            i=(i+1)%MAX;
        }
    }
}
void c_enqueue()
{
        int n;
        if((c_front==c_rear+1)||(c_front==0&&c_rear==MAX-1))
        {
            printf("OVERFLOW\n");
            return;
        }
        if(c_front==-1)
        {
            c_front=0;
        }
        printf("Enter value:");
        scanf("%d",&n);
        c_rear=(c_rear+1)%MAX;
        cqueue[c_rear]=n;
        printf("%d inserted\n",n);
}
void c_dequeue() 
{
    int n;
    if (c_front == -1) 
    {
        printf("Queue Underflow! The queue is empty.\n");
        return; 
    }
    n=cqueue[c_front];
    
    if (c_front == c_rear) 
    {
        c_front = -1;
        c_rear = -1;
    }
    else 
    {
        c_front = (c_front + 1) % MAX;
    }

    printf("Deleted element is %d\n", n);
}
void c_display()
{
    if (c_front == -1) 
    {
        printf("Queue Underflow! The queue is empty.\n");
        return; 
    }
    int i=c_front;
    while(1)
    {
        printf("%d\n",cqueue[i]);
        if(i==c_rear)
        {
            break;
        }
        i=(i+1)%MAX;
    }
}
        
int main()
{
    int n,key,choice;
    while(1)
    {
        printf("MENU\n\n SELECT 1 FOR LINEAR QUEUE\n\nSELECT 2 FOR DEQUEUE\n\nSELECT 3 FOR CIRCULAR QUEUE\n\nSELECT 4 FOR EXIT\n\nENTER:");
        scanf("%d",&key);
        switch(key)
        {
            case 1:
            {
                while(1)
                {
                    printf("SELECT 1 FOR ENQUEUE\n\nSELECT 2 FOR DEQUEUE\n\n SELECT 3 FOR DISPLAY\n\nSELECT 4 EXITING\n\nENTER:");
                    scanf("%d",&choice);
                    if(choice==1)
                    {
                    
                      enqueue();
                    
                    }
                    else if(choice==2)
                    {
                      dequeue();
                    }
                    else if(choice==3)
                    {
                       display();
                    }
                    else
                    {
                        break;
                    }
                }
                    break;
            }
            case 2:
            {
                while(1)
                {
                    printf("SELECT 1 FOR INSERTION AT FRONT\n\nSELECT 2 FOR INSERTION AT REAR\n\n SELECT 3 FOR DELETION AT FRONT\n\nSELECT 4 FOR DELETION AT REAR\n\nSELECT  5 FOR DISPLAY\n\nSELECT 6 EXITING\n\nENTER:");
                    scanf("%d",&choice);
                    if(choice==1)
                    {
                
                        insertfront();
                    }
                    else if(choice==2)
                    {
                    
                        insertrear();
                    }
                    else if(choice==3)
                    {
                        deletefront();
                    }
                    else if(choice==4)
                    {
                        deleterear();
                    }
                    else if(choice==5)
                    {
                        d_display();
                    }
                    else
                    {
                        break;
                    }
                }
                break;
            }
            case 3:
            {
                while(1)
                {   
                    printf("SELECT 1 FOR CIRCULAR ENQUEUE\n\nSELECT 2 FOR CIRCULAR DEQUEUE\n\n SELECT 3 FOR DISPLAY\n\nSELECT 4 EXITING\n\nENTER:");
                    scanf("%d",&choice);
                    if(choice==1)
                    {
                        c_enqueue();
                    }
                    if(choice==2)
                    {
                        c_dequeue();
                    }
                    if(choice==3)
                    {
                        c_display();
                    }
                    if(choice==4)            
                    {
                        break;
                    }
                }
                break;
            }
            case 4:
            {
                return 0;
            }
        }
    }
}