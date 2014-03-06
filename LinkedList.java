public class LinkedList
{

    private ListNode head;
    private int count;
    private ListNode current;

    public LinkedList()
    {
	this.head = null;
	this.count = 0;
	this.current = this.head;
    }

    public LinkedList add(Train t)
    {
	ListNode l = new ListNode(t);
	if(head == null)
	    {
		this.head = l;
		this.current = l;
		this.count = 1;
	    }
	else
	    {
		ListNode highest = this.head;
		while(highest.lessThan(l) && highest.hasNext())
		    {
			highest = highest.getNext();
		    }
		if(highest.hasPrevious())
		    {
			ListNode previous = highest.getPrevious();
			previous.setNext(l);
			highest.setPrevious(l);
		    }
		else
		    {
			highest.setPrevious(l);
			l.setNext(highest);
		    }
	    }
	return this;
    }

    public Train delete(int trainNumber)
    {
	ListNode toDelete = new ListNode(delete(trainNumber, this.head));
	ListNode previous = toDelete.getPrevious();
	if(toDelete.hasNext())
	    {
		ListNode next = toDelete.getNext();
		previous.setNext(next);
		next.setPrevious(previous);
	    }
	else
	    {
		previous.setNext(null);
	    }
	this.count--;
	return toDelete.getTrain();
    }

    public Train delete(int trainNumber, ListNode l)
    {
	if(l.getTrain().getTrainNumber() == trainNumber)
	    {
		return l.getTrain();
	    }
	else if(l.hasNext())
	    {
		return delete(trainNumber, l.getNext());
	    }
	else
	    {
		return null;
	    }
    }

    public Train first()
    {
	this.current = this.head;
	return this.head.getTrain();
    }

    public Train next()
    {
	if(this.current != null)
	    {
		Train temp = this.current.getTrain();
		if(this.current.hasNext())
		    {
			this.current = this.current.getNext();
		    }
		else
		    {
			this.current = null;
		    }
		return temp;
	    }
	return null;
    }
}
