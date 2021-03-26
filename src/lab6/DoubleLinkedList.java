package lab6;
/**
 * 26/4/2021.
 */
public class DoubleLinkedList<A> {
    private Node<A> header ;
    private Node<A> trailer ;
    private int size = 0 ;
    public DoubleLinkedList() {
        header = new Node<A>(null,null,null);
        trailer= new Node<A>(null,header,null);
        header.setNext(trailer);
    }
    private boolean isEmpty()
    {
        return size==0;
    }
    public A Last()
    {
        if(isEmpty()) return null ;
        return trailer.getPrevious().getElement() ;
    }
    private void Add_Between(A element , Node<A> k , Node<A> j )
    {
        Node<A> new_Node = new Node<A>(element,k,j) ;
        k.setNext(new_Node);
        j.setPrevious(new_Node);
        size++ ;
    }
    public void Add_First(A element){
        Add_Between(element,header,header.getNext());
    }

    public void Add_Last(A element)
    {
        Add_Between(element,trailer.getPrevious(),trailer);
    }

    public int getSize() {
        return size;
    }

    private A Remove(Node<A> x)
    {
        Node<A> p = x.previous ;
        Node<A> n =x.next ;
        p.setNext(n);
        n.setPrevious(p);
        size--;
        return x.getElement();
    }
    public A Remove_First()
    {
        if(isEmpty()) return null ;
        return Remove(header.getNext());
    }
    public A Remove_Last()
    {
        if (isEmpty())
            return null ;
        return Remove(trailer.getPrevious());
    }
    public void Find()
    {
        Node<A> temp =  header ;
        int c = 0 ;
        while (temp!=null)
        {
            c++ ;
            temp = temp.getNext() ;
        }
        temp = header ;
        int  p = 1 ;
            int mid = (c+1)/2 ;
            while (temp!=null)
            {
                if (p==mid)
                    break;
                p++;
                temp = temp.getNext() ;
            }
            System.out.println("The Element  : "+temp.getElement());
    }
    public int Size()
    {
      int s = 0 ;
        Node<A> temp = header ;
        if (header.getNext()==trailer)
            return s ;
        while (temp!=trailer)
        {
            s++;
            temp = temp.getNext();
        }
        return s ;
    }
    public boolean equal(DoubleLinkedList<A> list)
    {
        Node<A> a = this.header.getNext();
        Node<A> b = list.header.getNext();
        while (a!=this.trailer && b!=list.trailer)
        {
            if (a.getElement()!=b.getElement())
                return false ;
            a = a.getNext();
            b = b.getNext();
        }
        return (a==this.trailer && b==list.trailer);
    }

    public static class Node<A>
    {
        private A Element ;
        private Node<A>next ;
        private Node<A> previous ;

        public Node(A element, Node<A> previous, Node<A> next) {
            Element = element;
            this.next = next;
            this.previous = previous;
        }

        public A getElement() {
            return Element;
        }

        public void setElement(A element) {
            Element = element;
        }

        public Node<A> getNext() {
            return next;
        }

        public void setNext(Node<A> next) {
            this.next = next;
        }

        public Node<A> getPrevious() {
            return previous;
        }

        public void setPrevious(Node<A> previous) {
            this.previous = previous;
        }
    }
   
    public static void main(String[] args) {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.Add_Last(1);
        list.Add_Last(2);
        list.Add_Last(3);
        list.Add_Last(4);
        list.Add_Last(5);
        list.Add_Last(6);
        list.Add_Last(7);
        list.Add_Last(9);
        list.Add_Last(10);
        list.Find();
        
        DoubleLinkedList<Integer> list1 = new DoubleLinkedList<>();
        list1.Add_Last(1);
        list1.Add_Last(2);
        list1.Add_Last(3);
        list1.Add_Last(4);
        DoubleLinkedList<Integer> list2 = new DoubleLinkedList<>();
        list2.Add_Last(1);
        list2.Add_Last(2);
        list2.Add_Last(3);
        list2.Add_Last(4);
        if (list1.equal(list2)==true)
            System.out.println("Equal . ");
        else
            System.out.println("Aren't Equal . ");
        
        System.out.println("The Size is :"+list.Size());
    }
    }