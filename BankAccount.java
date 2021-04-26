import java.util.*;

class Account{
    private int accountNumber;
    private String accountName;
    private String accountType;
    private double accountBalance;

    public Account(int accountNumber,String accountName, String accountType, double accountBalance)
    {
        this.accountNumber=accountNumber;
        this.accountName=accountName;
        this.accountType=accountType;
        this.accountBalance=accountBalance;
    }

    public int getAccountNumber(){
        return accountNumber;
    }
    public String getAccountName(){
        return accountName;
    }
    public String getAccountType(){
        return accountType;
    }
    public double getAccountBalance(){
        return accountBalance;
    }
}

public class BankAccount
{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Account[] acc=new Account[4];
        for(int i=0;i<4;i++)
        {
            System.out.println("Input account number : ");
            int accountNumber=sc.nextInt();sc.nextLine();
            System.out.println("Input account name : ");
            String accountName=sc.nextLine();
            System.out.println("Input account type string : ");
            String accountType=sc.nextLine();
            System.out.println("Input account balance : ");
            double accountBalance=sc.nextDouble();sc.nextLine();
            acc[i]= new Account(accountNumber,accountName,accountType,accountBalance);
        }
        String name=sc.nextLine();
        double bal=sc.nextDouble();sc.nextLine();
        sc.close();

        int count= countAccountsByName(acc,name);
        if(count>0)
            System.out.println((count));
        else
            System.out.println(("No such data found"));

        Account[] acc1=searchAccountsByBalance(acc,bal);
        if(acc1==null)
            System.out.println("null");
        else
            for(int i=0;i<acc1.length;i++)
                System.out.println(acc1[i].getAccountName()+"\t"+acc1[i].getAccountBalance());
    }

    public static int countAccountsByName(Account[] acc, String name){
        int c=0;
        for(Account i:acc){
            if(i.getAccountName().equalsIgnoreCase(name))
                c++;
        }
        return c;
    }

    public  static Account[] searchAccountsByBalance(Account[] acc,double bal) {
        List<Account> newlist = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            if (acc[i].getAccountBalance() == bal)
                newlist.add(acc[i]);
        }
        if (newlist.size() == 0)
            return null;
        Collections.sort(newlist,new Sort1());
        Account[] acc2 = newlist.toArray(new Account[newlist.size()]);
        return acc2;
    }
}

class Sort1 implements Comparator<Account>{
    public int compare(Account obj1, Account obj2){
        return (int)(obj1.getAccountBalance()-obj2.getAccountBalance());
    }
}
