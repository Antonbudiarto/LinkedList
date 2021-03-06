package doublelinkedlist;

public class Chain implements LinearList {

    //data member
    protected ChainNode firstNode;
    protected ChainNode lastNode;
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
            System.out.println(q.previous);
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
            firstNode = new ChainNode(theElement, firstNode, null);

        } else {
            lastNode = firstNode;
            for (int i = 0; i < index - 1; i++) {
                lastNode = lastNode.next;
            }
            lastNode.next = new ChainNode(theElement, lastNode.next, lastNode.previous);
            lastNode.previous = firstNode.next;
            System.out.println(lastNode.previous);
//           p.next.previous.element = firstNode.element;
//           System.out.println(p.next.previous.element);
        }
        size++;
    }

    @Override
    public String toString() {
        StringBuffer s = new StringBuffer("[");
        ChainNode currentNode = firstNode;
        while (currentNode != null) {
            if (currentNode.element == null) {
                s.append("null, ");
            } else {
                s.append(currentNode.element.toString() + ",");
            }
            currentNode = currentNode.next;
        }
        if (size > 0) {
            s.delete(s.length() - 1, s.length());
        }
        s.append("]");

        return new String(s);
    }

    public static void main(String[] args) {

    }

}
