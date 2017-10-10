package doublelinkedlist;

import linkedlist.*;

public class ChainNode {
    //visible data member
    Object element;
    ChainNode next;
    ChainNode previous;
    
    //visible constructor

    public ChainNode() {
    }

    public ChainNode(Object element) {
        this.element = element;
    }
    public ChainNode(ChainNode previous,Object element, ChainNode next) {
        this.element = element;
        this.next = next;
        this.previous = previous;
    }
}
