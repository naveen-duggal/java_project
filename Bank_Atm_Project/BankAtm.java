import java.util.Scanner;

class InvalidCustomerException extends Exception
{
    public InvalidCustomerException(String msg)
    {
        super(msg);
    }
}

class Atm
{
    int userid = 1612;
    int password = 1001;
    int uid;
    int pw;

    public void input()
    {
        Scanner scan = new Scanner(System.in);

        System.out.println("Kindly enter the user id ");
        uid = scan.nextInt();

        System.out.println("Kindly enter the password ");
        pw = scan.nextInt();
    }

    public void verify() throws InvalidCustomerException
    {
        if((userid==uid) && (password==pw))
        {
            System.out.println();
        }
        else
        {
            InvalidCustomerException pas = new InvalidCustomerException("Invalid input Please try again");
            System.out.println(pas.getMessage());
            throw pas;
        }
    }
}

class Bank
{
    public void initiate()
    {
        Atm a = new Atm();
        try
        {
        a.input();
        a.verify();
        }
        catch(InvalidCustomerException e)
        {
            try
            {
                a.input();
                a.verify();
            }
            catch(InvalidCustomerException f)
            {
                try
                {
                    a.input();
                    a.verify();
                }
                catch(InvalidCustomerException g)
                {
                    try
                    {
                        a.input();
                        a.verify();
                    }
                    catch(InvalidCustomerException h)
                    {
                        System.out.println("Your card has been blocked");
                        System.exit(0);
                    }
                }
            }
        }
    }
}

public class BankAtm
{
    public static void main(String[] args)
    {
        Bank b = new Bank();
        b.initiate();
    }
} 

// This code is contributed by Naveen Duggal...
