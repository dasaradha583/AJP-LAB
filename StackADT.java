import java.util.Scanner;

interface InnerStackADT {
    public int peek();
    public void push(int a);
    public void pop();
    public boolean isEmpty();
    public void display();
    
}

class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}

// Array implementaion for Stacks
class ArrayStack implements InnerStackADT{
    int top = -1;
    int length = 10;
    ArrayStack(int length){
        this.length =  length;
    }
    ArrayStack(){

    }
    //max size = 10
    int[] array = new int[length];
    public int peek(){
        if (top == -1){
            return 0;
        }
        return array[top];
        // return 1;
    }
    public void push(int number){
        if(top == 9){
            System.out.println("Stack is full");
            return ;
        }
        top++;
        array[top] = number;
    }
    public void pop(){
        if(top == -1){
            System.out.println("Stack is empty");
            return ;
        }
        top--;
    }
    public boolean isEmpty(){
        if(top == -1){
            return true;
        }
        return false;
    }
    public void display(){
        if(top == -1){
            System.out.println("Stack is empty");
            return ;
        }
        System.out.println("The elements of the stack are : ");
        for(int i = top;i>=0;i--){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}


//Liked list implemenation 


class LinkedStack implements InnerStackADT{
    Node top = null;
    public int peek(){
        if(top == null){
            return 0;
        }
        return top.data;
    }
    public void push(int a){
        Node temp = new Node(a);
        if(top == null){
            
            top = temp;
            return ;
        }
        temp.next = top;
        top = temp;

    }
    public void pop(){
        if(top == null){
            System.out.println("Stack is empty");

        } else{
            top = top.next;
        }
        return ;
    }
    public boolean isEmpty(){
        if(top == null){
            return true;
        }
        return false;
    }
    public void display(){
        if(top == null){
            System.out.println("Stack is empty");
            return ;
        }
        Node temp = top;
        System.out.println("The elements in the stack are : ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}



public class StackADT {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            ArrayStack arr = new ArrayStack();
            LinkedStack l = new LinkedStack();
            System.out.println("1.Arrays 2.Linked List");
            System.out.print("Enter your choice : ");
            int choice = sc.nextInt();
            switch(choice){
                case 1:
                    while(true){
                    
                        System.out.println("1.Push 2.pop 3.peek  4. IsEmpty 5.display  6.exit");
                        System.out.print("Enter your choice : ");
                        int c = sc.nextInt();
                        switch (c) {
                            case 1:
                                System.out.print("Enter integer : ");
                                int data = sc.nextInt();
                                l.push(data);
                                break;
                            case 2:
                                l.pop();
                                break;
                            
                            case 3:
                                if(l.peek() == 0){
                                    System.out.println("Stack is empty");
                                } else {
                                    System.out.println("The peek element is : " + l.peek());
                                }
                                break;
                            case 4:
                                if(l.isEmpty()){
                                    System.out.println("Stack is empty");
                                } else {
                                    System.out.println("Stack is not empty");
                                }
                                break;
                            case 5:
                                l.display();
                                break;
                            default:
                                System.exit(0);
                                break;
                        }
                    }
                case 2:
                while(true){
                    
                    System.out.println("1.Push 2.pop 3.peek  4. IsEmpty 5.display  6.exit");
                    System.out.print("Enter your choice : ");
                    int c = sc.nextInt();
                    switch (c) {
                        case 1:
                            System.out.print("Enter integer : ");
                            int data = sc.nextInt();
                            arr.push(data);
                            break;
                        case 2:
                            arr.pop();
                            break;
                        
                        case 3:
                            if(arr.peek() == 0){
                                System.out.println("Stack is empty");
                            } else {
                                System.out.println("The peek element is : " + arr.peek());
                            }
                            break;
                        case 4:
                            if(arr.isEmpty()){
                                System.out.println("Stack is empty");
                            } else {
                                System.out.println("Stack is not empty");
                            }
                            break;
                        case 5:
                            arr.display();
                            break;
                        default:
                            System.exit(0);
                            break;
                    }
                }
                    
            }
        }

    }

}