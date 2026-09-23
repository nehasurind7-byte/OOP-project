#include<stdio.h>
int main()
{
    int key,stack[100],top=-1,item;
    do
    {
    

        printf("Select,1 for PUSH,2 for POP,3 for PEEK,4 for DISPLAY\n");
        scanf("%d",&key);
        switch(key)
        {
    
            case 1:
            {
                if(top==99)
                {
                    printf("stack overflow\n");
                }
                else
                {
                    printf("Enter element to push:");
                    scanf("%d",&item);
                    top++;
                    stack[top]=item;
                    printf("%d pushed to stack\n",item);
                }
                break;
            }
            case 2:
            {
                if(top==-1)
                {
                    printf("Stack underflow\n");
                }
                else
                {
                    item=stack[top];
                    printf("Element popped is %d\n",item);
                    top--;
                }
                break;
            }
            case 3:
            {
                if(top==-1)
                {
                    printf("Stack is empty\n");
                }
                else
                {
                    printf("The element at top is %d\n",stack[top]);
                }
                break;
            }
            case 4:
            {
                if(top==-1)
                {
                    printf("stack is empty");
                }
                else
                {
                    for(int i=top;i>=0;i--)
                    {
                        printf("%d:%d\n",i,stack[i]);
                    }
                    printf("\n");
                }
                break;
            }
            case 5:
            {
                printf("Exiting program");
                break;
            }
        default:
            {
                printf("Invalid input");
            }
        }
    }while(key!=5);
    return 0;
}
