/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bankingtest;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat; 
import java.util.*;
/**
 *
 * @author dell
 */
public class UserAccount {
    public String name;
    public int accountNumber;
    public String passKey;
    public double balance;
    String accountType;
    public boolean opened;
    static int count = 0;
    /***USER ACCOUNT SETTER PROPERTIES***/
     public UserAccount(String name, String passKey ,double balance, String accountType) 
             throws FileNotFoundException, UnsupportedEncodingException {
        this.name = name;
        this.accountNumber = ++count;
        this.passKey = passKey;
        this.balance = balance;
        this.accountType = accountType;
        this.opened = true;
        this.fileSave();
        this.fileSave2();
    }
     public UserAccount(String name, double balance) throws FileNotFoundException, UnsupportedEncodingException {
        this.name = name;
        this.accountNumber = ++count;
        if(balance>=0)
            this.balance = balance;
        else this.balance = 0;
        this.opened = true;
        this.fileSave();
        this.fileSave2();
        
    }
     /***FILE MANIPULATION PROPERTIES***/
     public String displayAccount() {       //toString() 
        return super.toString()+"\nAccount Number: "+this.accountNumber+"\nName: " + this.name 
                +"\nPass Key: "+this.passKey+ "\nBalance: "+this.balance+"\nType: "+this.accountType 
                + "\nState: "+(this.opened?"Opened\n":"Closed\n");
    }
    public boolean redundantAccount(Object obj) {   //equals
        if(this == obj) return true;
        else if(this.getClass()==obj.getClass()) {
            UserAccount a = (UserAccount)obj;
            if(this.accountNumber==a.accountNumber && 
                    this.name.equals(a.name) && 
                    this.balance == a.balance && this.opened == a.opened)
                return true;
        }
        return false;
    }
     public void fileSave() throws FileNotFoundException, UnsupportedEncodingException {
        
        PrintWriter writer = new PrintWriter("dataFile"+this.accountNumber+".txt", "UTF-8");
        writer.println(this.name);
        writer.println(this.accountNumber);
        writer.println(this.passKey);
        writer.println(this.balance);
        writer.println(this.accountType);
        writer.println(this.opened);
        writer.close();
    }
     public  void fileSave2() throws FileNotFoundException, UnsupportedEncodingException {
        
        PrintWriter writer = new PrintWriter("countFile.txt", "UTF-8");
        writer.println(UserAccount.count);
        writer.close();
    }
     public void fileSave3(String s1) throws FileNotFoundException, UnsupportedEncodingException, IOException {
        File log = new File("dataFile"+this.accountNumber+" Transaction.txt");
        try{
            if(!log.exists()){
                System.out.println("We had to make a new file.");
                log.createNewFile();
            }
        FileWriter fileWriter = new FileWriter(log, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        bufferedWriter.write(dateFormat.format(date));
        bufferedWriter.newLine();
        bufferedWriter.write(s1);
        bufferedWriter.newLine();
        bufferedWriter.write("___________________________________");
        bufferedWriter.newLine();
        bufferedWriter.close();
        } catch(IOException e) {
            System.out.println("COULD NOT LOG!!");
        }
     }
     public void fileLoad() throws FileNotFoundException {
        try {
            Scanner s = new Scanner(new File("dataFile"+this.accountNumber+".txt"));
            this.name = s.nextLine();
            this.accountNumber = Integer.parseInt(s.nextLine());
            this.passKey = s.nextLine();
            this.balance = Double.parseDouble(s.nextLine());
            this.accountType= s.nextLine();
            this.opened = Boolean.parseBoolean(s.nextLine());
        }
        catch(FileNotFoundException e) {
        }
    }
    public static ArrayList fileLoad2() throws FileNotFoundException, UnsupportedEncodingException {
        try {
            UserAccount.count=0;
            Scanner a = new Scanner(new File("countFile.txt"));
            int n = Integer.parseInt(a.nextLine());
            ArrayList al = new ArrayList();
            for(int i =0; i<n; i++) {
                Scanner b = new Scanner(new File("dataFile"+(i+1)+".txt"));
                String name = b.nextLine(); 
                b.nextLine();
                String passkey = b.nextLine();
                double balance = Double.parseDouble(b.nextLine());
                String type = b.nextLine();
                al.add(new UserAccount(name,passkey,balance,type));
                UserAccount account = (UserAccount)al.get(i);
                if(Boolean.parseBoolean(b.nextLine())==false)
                    account.closeAccount();
            }
            return al;
        }
        catch(FileNotFoundException e) {
            
        }
        return null;
    }
     /***GETTER PROPERTIES***/
     public String accountPresent()
     {
        if(this.opened==true)
            return "Account opened successfully";
        else
            return "Account could not be opened";
     }
    public void closeAccount() throws FileNotFoundException, UnsupportedEncodingException {
        if(this.opened==false)
            System.out.println("Account has already been closed");
        else {
            this.opened = false;
            System.out.println("Account closed successfully");
            this.fileSave();
        }
    }
    public void reopenAccount() throws FileNotFoundException, UnsupportedEncodingException {
         this.opened = true;
         this.fileSave();
    }
    public double getBalance() {
        return this.balance;
    }
    public String getName(){
        return this.name;
    }
    public String getPass(){    
        return this.passKey;
    }
    //hidePass PROPERTY: for securing passKey
    //unhidePass PROPERTY: for unsecuring passKey
    public int getAccountNumber(){
        return this.accountNumber;
    }
    public String getAccountType(){
        return this.accountType;
    }
    /***BANK OPERATIONS AND TRANSACTIONS***/
    //depositTransaction
    public void depositTransaction(double amount) throws FileNotFoundException, UnsupportedEncodingException, IOException {
        if(this.opened==false||amount<=0) {
            if(this.opened==false)
                System.out.println("Unsuccessful deposit: Account is closed");
            if(amount <=0)
                System.out.println("Unsuccessful deposit: Invalid amount");
        }
        else {
            this.balance+=amount;
            this.fileSave();
            String value= "Deposit value = " + amount;
            this.fileSave3(value);
        }
    }
    //withdrawTransaction
    public void withdrawTransaction(double amount) throws FileNotFoundException, UnsupportedEncodingException, IOException {
        if((amount <= 0) || (amount > this.balance) || (this.opened == false)) {
            if(amount <= 0) System.out.println("Unsuccessful withdrawal: Amount must be greater than zero");
            if(amount > this.balance) System.out.println("Unsuccessful withdrawal: Amount can't be greater than existing balance");
            if(this.opened == false) System.out.println("Unsuccessful withdrawal: Account is closed");
        }
        else {
            this.balance-=amount;
            this.fileSave();
            String value= "withdrawal value = " + amount;
            this.fileSave3(value);
        }
     }
    //transferTransaction
    public void transferTransaction(UserAccount receiver, double amount) throws FileNotFoundException, UnsupportedEncodingException, IOException {
        if((receiver.opened == false)||(this.opened == false)||(amount <= 0)||(this.balance < amount)) {
            if(this.opened == false) System.out.println("Unsuccessful transfer: Source account is closed");
            if(receiver.opened == false) System.out.println("Unsuccessful transfer: Destination account is closed");
            if(amount <= 0) System.out.println("Unsuccessful transfer: Amount must be greater than zero");
            if(amount > this.balance) System.out.println("Unsuccessful transfer: Source account has insufficient balance");
        }
        else {
            this.balance-=amount;
            receiver.balance+=amount;
            this.fileSave();
            receiver.fileSave();
            String s1= amount+ " Transferd From account "+ this.accountNumber + " to "+ receiver.accountNumber;
            this.fileSave3(s1);
            String s2 = amount + " transfered from account "+ this.accountNumber + " to this account ("+receiver.accountNumber+")"  ;
            receiver.fileSave3(s2);
        }
    }
    public static Queue enqueUsers = new Queue();

    public static void main(String args[]) throws FileNotFoundException, UnsupportedEncodingException {
        //try creating an account
        long nano_startTime = System.nanoTime();
        long millis_startTime = System.currentTimeMillis();
        //Speed test for creation/saving of account info, buffered and regular save
        UserAccount acc = new UserAccount("Sohayla", "123456" , 123.45, "Student");
        //acc.displayAccount();
        long nano_endTime = System.nanoTime();
        long millis_endTime = System.currentTimeMillis();
  
        System.out.println("Time taken in nano seconds: "
                           + (nano_endTime - nano_startTime));
        System.out.println("Time taken in milli seconds: "
                           + (millis_endTime - millis_startTime));
    }
}//END OF USERACCOUNT CLASS

class Node {
    private UserAccount data;
    private Node next;
    //Multi-node queuing: multiple transactions per account
    public Node(UserAccount data, Node next) {
        this.data=data;
        this.next=next;
    }
    //Single node queuing: single transaction per account
    public Node(UserAccount data) {
        this(data, null);
    }
    //SETTERS
    public void setData(UserAccount data) {
        this.data=data;
    }
    public void setNext(Node next) {
        this.next = next;
    }
    //GETTERS
    public UserAccount getData() {
        return this.data;
    }
    public Node getNext() {
        return this.next;
    }
}//END OF NODE CLASS

class Queue {
    private Node head, tail;
    private int count;
    //Initial queue
    public Queue() {
        tail = head = null;
        count = 0;//num of elements
    }
    public boolean isEmpty() {
        if((head = tail)==null){
            System.out.println("No transactions in queue");
            return true;
        }
        return count==0;
    }
    //Add a new node to queue: new transaction
    public void enqueue(Node n) {
        if(head==null)//initially tail is the head is the single node
            tail=head=n;
        else {//set Node tail as the next node
            tail.setNext(n);
            tail=n;
        }
        tail.setNext(null);
        count++;
    }
    //Remove a node from the queue: transaction is done
    public Node dequeue() throws IOException {
        if(head==null)
            throw new IOException();
        count--;
        Node n = head;
        if(head==tail) {
            tail = head = null;
        }
        else {
            head=head.getNext();
        }
        return n;
    }
    //GETTERS
    public int getSize() {
        return this.count;
    }
    public Node getHead() {
        return this.head;
    }
    public Node getTail() {
        return this.tail;
    }
}//END OF QUEUE CLASS
