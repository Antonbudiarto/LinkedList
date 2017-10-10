package circularlinkedlist;

public class ChainNode {
    //visible data member
    Object element;
    ChainNode next;
    
    //visible constructor

    public ChainNode() {

    }

    public ChainNode(Object element) {
        this.element = element;
    }
    public ChainNode(Object element, ChainNode next) {
        this.element = element;
        this.next = next;
    }
}
