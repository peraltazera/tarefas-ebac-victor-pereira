public class Node {

    public Integer data;
    public Node next;
    public Integer index;

    public Node(int index, int data) {
        this.data = data;
        this.next = null;
        this.index = index;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", next=" + next +
                ", index=" + index +
                '}';
    }
}
