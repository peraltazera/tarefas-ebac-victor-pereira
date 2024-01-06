public class ListaEncadeada {

    private Node head;
    private Node tail;
    private Integer maiorIndex;
    private Integer menorIndex;
    private Integer sizeLista;

    public ListaEncadeada() {
        this.head = null;
        this.tail = null;
        this.maiorIndex = null;
        this.menorIndex = null;
        this.sizeLista = 0;
    }

    public void insert(Integer index, Integer data) {
        Node newNode = new Node(index,data); //O(1)
        Boolean add = false; //O(1)
        if(maiorIndex == null || menorIndex == null){ //O(1)
            maiorIndex = index; //O(1)
            menorIndex = index; //O(1)
        }
        if(maiorIndex < index || tail == null){ //O(1)
            maiorIndex = index; //O(1)
            if(tail != null){ //O(1)
                tail.next = newNode; //O(1)
            }
            add = true; //O(1)
            tail = newNode; //O(1)
        }
        if(menorIndex > index || head == null){ //O(1)
            menorIndex = index; //O(1)
            if(head != null){ //O(1)
                newNode.next = head; //O(1)
            }
            add = true; //O(1)
            head = newNode; //O(1)
        }
        if(head != newNode && tail != newNode) //O(1)
        {
            Node current = head; //O(1)
            Node past = head; //O(1)
            Boolean nodeExistente = false; //O(1)
            while (current != null && newNode.next == null && !nodeExistente) { //O(log n)
                if(current.index.equals(index)){ //O(1)
                    nodeExistente = true;//O(1)
                }else {
                    if(current.index > index && past.index < index ){//O(1)
                        past.next = newNode;//O(1)
                        newNode.next = current;//O(1)
                        add = true;//O(1)
                    }
                    past = current;//O(1)
                    current = current.next;//O(1)
                }
            }
        }
        if(add){//O(1)
            sizeLista++;//O(1)
        }
    }

    public void remove(Integer index) {
        Node current = head;//O(1)
        Node past = head;//O(1)
        Node nodeSearch = null;//O(1)
        while (current != null && nodeSearch == null) {//O(log n)
            if(current.index.equals(index)){//O(1)
                nodeSearch = current;//O(1)
                past.next = nodeSearch.next;//O(1)
                sizeLista--;//O(1)
            }
            past = current;//O(1)
            current = current.next;//O(1)
        }
    }

    public Node elementAt(Integer index) {
        Node current = head;//O(1)
        Node nodeSearch = null;//O(1)
        while (current != null && nodeSearch == null) {//O(log n)
            if(current.index.equals(index)){//O(1)
                nodeSearch = current;//O(1)
            }
            current = current.next;//O(1)
        }
        return nodeSearch;//O(1)
    }

    public Integer size() {
        return sizeLista;
    }

    public void printList() {
        Node current = head;
        String systemPrint = "[";
        while (current != null) {
            systemPrint += current.data;
            current = current.next;
            if(current != null){
                systemPrint += ",";
            }
        }
        systemPrint += "]";
        System.out.println(systemPrint);
    }
}
