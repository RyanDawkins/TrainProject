public class ListNode
{

    private Train train;
    private ListNode previous;
    private ListNode next;

    public ListNode(Train t)
    {
	this(t, null);
    }
    public ListNode(Train t, ListNode previous)
    {
	this(t, previous, null);
    }
    public ListNode(Train t, ListNode previous, ListNode next)
    {
	this.train = t;
	this.previous = previous;
	this.next = next;
    }

    public boolean lessThan(ListNode l)
    {
	if(this.getTrain().lessThan(l.getTrain()))
	    return true;
	return false;
    }
    public boolean greaterThan(ListNode l)
    {
	if(this.getTrain().greaterThan(l.getTrain()))
	    return true;
	return false;
    }
    public boolean equals(ListNode l)
    {
	if(this.getTrain().equals(l.getTrain()))
	    return true;
	return false;
    }

    public Train getTrain()
    {
	return this.train;
    }

    public ListNode setNext(ListNode l)
    {
	this.next = l;
	return this;
    }
    public ListNode getNext()
    {
	return this.next;
    }
    public boolean hasNext()
    {
	if(this.next != null)
	    {
		return true;
	    }
	return false;
    }

    public ListNode setPrevious(ListNode l)
    {
	this.previous = l;
	return this;
    }
    public ListNode getPrevious()
    {
	return this.previous;
    }
    public boolean hasPrevious()
    {
	if(this.previous != null)
	    {
		return true;
	    }
	return false;
    }

    public ListNode insert(ListNode l)
    {
	if(!this.hasNext())
	    {
		this.setNext(l);
	    }
	else
	    {
		ListNode old = this.getNext();
		this.next = l;
		l.setNext(old);
		old.setPrevious(this.next);
	    }
	return l;
    }

}