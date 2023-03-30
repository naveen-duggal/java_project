package in.ineuron.bank;

import java.util.Scanner;

class Atm
{
    int userid = 95600;
    int password = 9009;
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
