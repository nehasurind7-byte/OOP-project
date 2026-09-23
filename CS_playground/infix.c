#include<stdio.h>
#include<ctype.h>
#include<math.h>
#define MAX 100
char stack[MAX];
int top=-1;
void push(char c)
{
    stack[++top]=c;
}
char pop()
{
    return stack[top--];
}
char peek()
{
    return stack[top];
}
int precedence(char op)
{
    if(op=='+'|| op=='-')
        return 1;
    else if(op=='*'|| op=='%'||op=='/')
        return 2;
    else if(op=='^')
        return 3;
    return 0;
}
void infixTopostfix(char infix[],char postfix[])
{
    int i=0,j=0;
    char ch;
    while((ch=infix[i])!='\0')
    {
        if(isdigit(ch))
        {
            while(isdigit(infix[i]))
            {
                postfix[j++]=infix[i++];
            }
            postfix[j++]=' ';
            i--;
        }
        else if(ch=='(')
        {
            push(ch);
        }
        else if(ch==')')
        {
            while(peek()!='(')
            {
                postfix[j++]=pop();
                postfix[j++]=' ';
            }
            pop();
        }
        else
        {
            while((top!=-1) && (precedence(peek())>=precedence(ch)))
            {
                postfix[j++]=pop();
                postfix[j++]=' ';
            }
            push(ch);
        }
        i++;
    }
    while(top!=-1)
    {
        postfix[j++]=pop();
        postfix[j++]=' ';
    }
    postfix[j++]='\0';
}
int evalPostfix(char postfix[])
{
    int i=0,k=0,a,b;
    int val[MAX],top=-1;
    while(postfix[k]!='\0')
    {
        if(isdigit(postfix[k]))
        {
            int num=0;
            while(isdigit(postfix[k]))
            {
                num=num*10+(postfix[k]-'0');
                k++;
            }
            val[++top]=num;
        }
        else if(postfix[k]==' ')
        {
            k++;
            continue;        
        }
        else
        {
            b=val[top--];
            a=val[top--];
            switch(postfix[k])
            {
                case '+':
                {    val[++top]=a+b;
                     break;
                }

                case '-':
                {   val[++top]=a-b;
                    break;
                }
                case '*':
                {   val[++top]=a*b;
                    break;
                }
                case '/':
                {   val[++top]=a/b;
                    break;
                }
                case '^':
                {   val[++top]=(int)(pow(a,b));
                    break;
                }
            }
            k++;
        }
    }
    return val[top];
}
int main()
{
    char postfix[MAX],infix[MAX];
    printf("Enter infix expression:");
    scanf("%s",infix);
    infixTopostfix(infix,postfix);
    printf("postfix expression:%s",postfix);
    printf("result:%d",evalPostfix(postfix));
    return 0;
}