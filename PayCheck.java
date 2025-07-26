package WorkingOut;

public class PayCheck
{
    static int pages_read;
    static int amt;
    static void compute()
    {   
        pages_read = 134+217+80+145;
        amt=pages_read*60;
        System.out.println("For "+pages_read+" pages,amount payable is Rs."+amt);
    }

    public static void main(String[] args) {
        compute();
    }
}