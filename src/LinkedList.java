public class LinkedList<T> {
    private Node<T> head;
    private int length;
    
    public LinkedList() {
        head = null;
        length = 0;
    }

    public LinkedList(Node<T> head, int length) {
        this.head = head;
        this.length = length;
    }
    
    public Node<T> getHead() {
        return this.head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    public int getLength() {
        return length;
    }

    public boolean isEmpty() {
        if(head == null)
            return true;
        return false;
    }

    //Give the size of the list
    public int size() {
        if(isEmpty())
            return 0;
        
        var cursor = head;
        var counter = 0;

        while(cursor != null){
            counter++;
            cursor = cursor.getNext();
        }

        return counter;
    }

    //Get a node by his index in the list
    public T get(int index) {
        if(index <= 0 || index >= length)
            throw new IndexOutOfBoundsException("Index out of range");

        var cursor = head;
        var counter = 0;
        
        while (counter < index) {
            cursor = cursor.getNext();
            counter ++;
        }

        return cursor.getData();
    }

    //Insert a new node in a given index in the list
    public void insert(int index, Node<T> node) {
        if(index <= 0 || index >= length)
            throw new IndexOutOfBoundsException("Index out of range");
        
        if(index == 0) {
            node.setNext(head);
            head = node;
        }
        else{
            var cursor = head;
            for(int i = 0; i < index; i++){
                cursor = cursor.getNext();
            }

            node.setNext(cursor.getNext());
            cursor.setNext(node);
        }

        length += 1;
    }

    //Add a node in the final of the list
    public void add(T data) {
        var node = new Node<T>(data);
        
        if(isEmpty()) {
            head = node;
        }
        else {
            var cursor = head;
            while(cursor.getNext() != null){
                cursor = cursor.getNext();
            }
            cursor.setNext(node);
        }

        length += 1;
    }

    //Remove a node from the list by a given index
    public void remove(int index) {
        if(index <= 0 || index >= length)
            throw new IndexOutOfBoundsException("Index out of range");

        if(index == 0) {
            head = head.getNext();
        }
        else {
            var cursor = head;
            
            for(int i = 0; i < index - 1; i++){
                cursor = cursor.getNext();
            }
            
            var temp = cursor.getNext();
            cursor.setNext(temp.getNext());
        }

        length -= 1;
    }
}
