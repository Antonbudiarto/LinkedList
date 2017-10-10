package linkedlist;

public class ExtendedChain extends Chain implements ExtendedLinearlist {

    protected ChainNode lastNode;

    public void clear() {
        firstNode = lastNode = null;
        size = 0;
    }

    public void add(Object theElement) {
        ChainNode y = new ChainNode(theElement, null);
        if (firstNode == null) {
            firstNode = lastNode = y;
        } else {
            lastNode.next = y;
            lastNode = y;
        }
        size++;
    }

    @Override
    public void append(Object theElement) {

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
        } else {
            ChainNode p = firstNode;
            for (int i = 0; i < index - 1; i++) {
                p = p.next;
            }

            p.next = new ChainNode(theElement, p.next);

        }
        size++;
    }
}
