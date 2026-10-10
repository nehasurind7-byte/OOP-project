#include<stdio.h>
#include<stdlib.h>
#include<ctype.h>
struct node 
{
    char data;
    struct node *left;
    struct node *right;
};
#define MAX 100
struct node *stack[MAX];
int top=-1;

char opStack[MAX];
int opTop=-1;

struct node* nodeStack[MAX];
int nodeTop=-1;
struct node *createNode(char data)
{
    struct node *newnode=(struct node *)malloc(sizeof(struct node));
    newnode->data=data;
    newnode->left=NULL;
    newnode->right=NULL;
    return newnode;
}
/*void push(struct node *newnode)
{
    stack[++top]=newnode;
}
struct node* pop()
{
    return stack[top--];
}*/
int isOperator(char ch)
{
    return(ch=='+'|| ch=='-'||ch=='*'|| ch=='/');
}
void pushOperator(char c)
{
    opStack[++opTop]=c;
}
char popOperator()
{
    return opStack[opTop--];
}
void pushNode(struct node *node)
{
    nodeStack[++nodeTop] = node;
}
struct node* popNode()
{
    return nodeStack[nodeTop--];
}
int precedence(char ch)
{
    if (ch == '+' || ch == '-')
        return 1;

    if (ch == '*' || ch == '/')
        return 2;

    return 0;
}
void infixToPostfix(char infix[], char postfix[])
{
    int i, j = 0;
    char ch;

    for (i = 0; infix[i] != '\0'; i++)
    {
        ch = infix[i];
        if (ch == ' ')
            continue;
        if (isalnum(ch))
        {
            postfix[j++] = ch;
        }
        else if (ch == '(')
        {
            pushOperator(ch);
        }

        else if (ch == ')')
        {
            while (opTop != -1 && opStack[opTop] != '(')
            {
                postfix[j++] = popOperator();
            }

            popOperator();
        }
        else if (isOperator(ch))
        {
            while (opTop != -1 &&opStack[opTop] != '(' &&precedence(opStack[opTop]) >= precedence(ch))
            {
                postfix[j++] = popOperator();
            }

            pushOperator(ch);
        }
    }
    while (opTop != -1)
    {
        postfix[j++] = popOperator();
    }

    postfix[j] = '\0';
}
struct node* constructTree(char postfix[])
{
    int i;
    char ch;
    struct node *node;

    for (i = 0; postfix[i] != '\0'; i++)
    {
        ch = postfix[i];

        if (isalnum(ch))
        {
            node = createNode(ch);
            pushNode(node);
        }
        else if (isOperator(ch))
        {
            node = createNode(ch);
            node->right = popNode();
            node->left = popNode();
            pushNode(node);
        }
    }

    return popNode();
}
void inorder(struct node *root)
{
    if (root != NULL)
    {
        inorder(root->left);
        printf("%c ", root->data);
        inorder(root->right);
    }
}
void preorder(struct node *root)
{
    if (root != NULL)
    {
        printf("%c ", root->data);
        preorder(root->left);
        preorder(root->right);
    }
}
void postorder(struct node *root)
{
    if(root!=NULL)
    {
        postorder(root->left);
        postorder(root->right);
        printf("%c",root->data);
    }
}
int main()
{
    char expression [MAX];
    char postfix[MAX];
    char infix[MAX];
    struct node *root;
    printf("Enter an expression");
    fgets(infix,MAX,stdin);
    infixToPostfix(infix,postfix);
    root=constructTree(postfix);
    printf("Inorder :");
    inorder(root);
    printf("\n");
    printf("Preorder:");
    preorder(root);
    printf("\n");
    printf("Postorder:");
    postorder(root);
   
}