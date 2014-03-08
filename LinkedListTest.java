import java.util.Calendar;
import java.util.GregorianCalendar;

public class LinkedListTest
{

    public static void main(String[] args)
    {
	LinkedList list = new LinkedList();
	Calendar c1 = new GregorianCalendar(2000, 1, 1, 1, 1);
	Train t1 = new Train(false, c1, 1000, "Train 1");
	Calendar c2 = new GregorianCalendar(2000, 1, 1, 1, 1);
	Train t2 = new Train(true, c2, 1001, "Train 2");
	Calendar c3 = new GregorianCalendar(2001, 1, 1, 1, 1);
	Train t3 = new Train(true, c3, 1002, "Train 3");
	Train t4 = new Train(false, c3, 1003, "Train 4");
	list.add(t1);
	list.add(t2);
	list.add(t3);
	list.add(t4);

	list.first();
	Train current;
	while((current=list.next()) != null)
	    {
		System.out.println(current.toString(true));
	    }
    }
}
