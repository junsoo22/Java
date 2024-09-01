package LinkedList;

import java.util.Scanner;

public class polynomialEx {
    private polynomial [] polys=new polynomial[100];
    private Scanner sc=new Scanner(System.in);
    private int n=0;

    public polynomialEx(){

    }

    public static void main(String[] args) {
        polynomialEx app=new polynomialEx();
        app.processCommand();

    }

    public void processCommand() {
        while(true){
            System.out.print("$ ");
            String command=sc.next();
            if(command.equals("create"))
                handleCreate();
            else if (command.equals("add"))
                handleAdd();
            else if(command.equals("calc"))
                handleCalc();
            else if(command.equals("print"))
                handlePrint();
            else if(command.equals("exit"))
                break;
        }
        sc.close();
    }

    private void handlePrint() {
        char name=sc.next().charAt(0);

        int index=find(name);
        if(index<0){
            System.out.println("No such polynomial");
            return;
        }
        else {
            System.out.println(polys[index].toString());
        }
    }

    private void handleCalc() {
        char name=sc.next().charAt(0);
        int x=sc.nextInt();
        int index=find(name);
        if(index<0){
            System.out.println("No such polynomial");
            return;
        }
        else {
            System.out.println(polys[index].calc(x));
        }
    }

    private void handleAdd() {
        char name=sc.next().charAt(0);
        int coef=sc.nextInt();
        int expo=sc.nextInt();
        int index=find(name);
        if(index<0){
            System.out.println("No such polynomial");
            return;
        }
        else{
            polys[index].addTerm(coef, expo);
        }
    }
    private int find(char name){
        for(int i=0; i<n; i++){
            if(polys[i].name==name){
                return i;
            }
        }
        return -1;
    }

    private void handleCreate() {
        char name=sc.next().charAt(0);
        polynomial p=new polynomial(name);
        polys[n++]=p;
    }
}
