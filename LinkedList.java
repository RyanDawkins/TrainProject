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
	if(this.head == null)
	    {
		this.head = l;
		this.current = l;
		this.count = 1;
	    }
	else if(l.lessThan(this.head))
	    {
		this.head.setPrevious(l);
		l.setNext(this.head);
		this.head = l;
		this.current = l;
	    }
	else if(!this.head.hasNext())
	    {
		this.head.setNext(l);
		l.setPrevious(this.head);
	    }
	else
	    {
		ListNode c = this.head.getNext();
		while(c.hasNext() && c.lessThan(l))
		    {
			c = c.getNext();
		    }
		if(l.lessThan(c))
		    {
			c.getPrevious().setNext(l);
			l.setPrevious(c.getPrevious());
			l.setNext(c);
			c.setPrevious(l);
		    }
		else
		    {
			if(c.hasNext())
			    {
				c.getNext().setPrevious(l);
				l.setNext(c.getNext());
				l.setPrevious(c);
				c.setNext(l);
			    }
			else
			    {
				c.setNext(l);
				l.setPrevious(c);
			    }
		    }
	    }
	return this;
    }

    public Train delete(int trainNumber)
    {
	ListNode toDelete = delete(trainNumber, this.head);
	if(toDelete == null)
	    {
		return null;
	    }

	if(!toDelete.hasPrevious())
	    {
		if(toDelete.hasNext())
		    {
			this.head = toDelete.getNext();
			this.head.setPrevious(null);
			this.current = this.head;
		    }
	    }
	else
	    {
		toDelete.getPrevious().setNext(toDelete.getNext());
		if(toDelete.hasNext())
		    {
			toDelete.getNext().setPrevious(toDelete.getPrevious());
		    }
	    }
	this.count--;
	return toDelete.getTrain();
    }

    public ListNode delete(int trainNumber, ListNode l)
    {
	if(l.getTrain().getTrainNumber() == trainNumber)
	    {
		return l;
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
