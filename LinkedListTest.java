import java.util.Calendar;
import java.util.GregorianCalendar;

public class LinkedListTest
{

    public static void main(String[] args)
    {

	LinkedList list = new LinkedList();
	Calendar c1 = new GregorianCalendar(2000, 1, 1, 1, 1);
	Train t1 = new Train(true, c1, 1000, "Train 1");
	Calendar c2 = new GregorianCalendar(2000, 1, 1, 1, 1);
	Train t2 = new Train(false, c2, 1001, "Train 2");
	list.add(t1);
	list.add(t2);

	Train current;
	while((current=list.next()) != null)
	    {
		System.out.println(current);
	    }
    }
}
