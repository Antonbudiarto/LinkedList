package circularlinkedlist;

public class Chain implements LinearList {

    //data member
    protected ChainNode firstNode;
    protected int size;

//constructors
    public Chain(int initialCapacity) {
        //the default initial value of firstNode and size are null and 0
    }

    public Chain() {
        this(0);
    }

    // methods
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index = " + index + " size = " + size);
        }
    }

    @Override
    public Object get(int index) {
        checkIndex(index);
        //move the desire node
        ChainNode currentNode = firstNode;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode.element;

    }

    @Override
    public int indexOf(Object theElement) {
        //search the chain for element
        ChainNode currentNode = firstNode;
        int index = 0;//index of currentNode
        while (currentNode != null && !currentNode.element.equals(theElement)) {
            //move to next node
            currentNode = currentNode.next;
            index++;
        }
        if (currentNode == null) {
            return -1;
        } else {
            return index;
        }
    }

    @Override
    public Object remove(int index) {
        checkIndex(index);

        Object removeElement;
        if (index == 0) {
            removeElement = firstNode.element;
            firstNode = firstNode.next;
        } else {
            ChainNode q = firstNode;
            for (int i = 0; i < index - 1; i++) {
                q = q.next;
            }
            removeElement = q.next.element;
            q.next = q.next.next;
        }
        size--;
        return removeElement;
    }

    @Override
    public void add(int index, Object theElement) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("index = " + index + " size = " + size);
        }

        if (index == 0) {
            firstNode = new ChainNode(theElement, firstNode);
            ChainNode p = new ChainNode(theElement);
            p.element = firstNode.element;
            
        } else {
            ChainNode p = new ChainNode();
            p = firstNode;
            for (int i = 0; i < index - 1; i++) {
                p = p.next;
            }
            p.next = new ChainNode(theElement, p.next);
            p = firstNode;
            
        }
        
        size++;
    }

    @Override
    public String toString() {
        StringBuffer s = new StringBuffer("");
        ChainNode currentNode = firstNode;
        while (currentNode != null) {
            if (currentNode.element == null) {
                s.append("null, ");
            } else {
                s.append(currentNode.element.toString() + " -> ");
            }
            currentNode = currentNode.next;
        }

        if (size > 0) {
            s.delete(s.length() - 1, s.length());
        }
        s.append("");

        return new String(s);
    }

}
