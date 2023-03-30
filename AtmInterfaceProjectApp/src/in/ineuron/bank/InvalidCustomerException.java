package in.ineuron.bank;
class InvalidCustomerException extends Exception
{
    public InvalidCustomerException(String msg)
    {
        super(msg);
    }
}