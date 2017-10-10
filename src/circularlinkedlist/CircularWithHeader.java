package circularlinkedlist;

import linkedlist.*;

public class CircularWithHeader {

    protected ChainNode headerNode;

    public CircularWithHeader() {
        headerNode = new ChainNode();
        headerNode.next = headerNode;
    }

    public int indexOf(Object theElment) {
        //put the element in header node
        headerNode.element = theElment;

        ChainNode currentNode = headerNode.next;
        int index = 0;
        while (!currentNode.element.equals(theElment)) {
            currentNode = currentNode.next;
            index++;
        }
        if (currentNode == headerNode) {
            return -1;
        } else {
            return index;
        }

    }

}
