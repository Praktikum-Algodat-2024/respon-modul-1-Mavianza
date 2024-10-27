class Node {
    String data;
    Node next;

    public Node(String data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    public void addFirst(String data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void addLast(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void displayList() {
        Node current = head;
        int index = 1;
        while (current != null) {
            System.out.println(index+ "." + current.data);
            current = current.next;
            index++;
        }
    }

    public void deleteFirst() {
        if (head != null) {
            head = head.next;
        } else {
        }
    }

    public void deleteLast() {
        if (head == null) {
        } else if (head.next == null) {
            head = null;
        } else {
            Node temp = head;
            while (temp.next.next != null) {
                temp = temp.next;
            }
            temp.next = null;
        }
    }

    public void deleteByName(String data) {
        if (head == null) {
            return;
        }
        if (head.data.equals(data)) {
            head = head.next;
            return;
        }
        Node current = head;
        while (current.next != null && !current.next.data.equals(data)) {
            current = current.next;
        }
        if (current.next != null) {
            current.next = current.next.next;
        } else {
        }
    }

    public void reverseMiddleList() {
        if (head == null || head.next == null) {
            return;
        }
    
        Node start = head.next; //mulai dari node kedua
        Node end = head; //menunjuk node pertama
    
        //node terakhir
        while (end.next != null) {
            end = end.next;
        }
    
        Node beforeStart = head; // Node sebelum start
        Node afterEnd = end; // Node setelah end
    
        //balik tengah
        Node current = start;
        Node prev = null;
    
        //balik tengah ke end
        while (current != afterEnd) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
    
        // hubungin node baru jadi start
        beforeStart.next = prev; 
        start.next = afterEnd; 
    }
    
    

    public void reverseEntireList() {
        Node prev = null;
        Node current = head;
        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }
}

public class Praktikum {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.addFirst("Nayla");
        list.addLast("Nini");
        list.addLast("Wira");
        list.addLast("Ananta");
        list.addLast("Salsa");
        list.addLast("Raja");
        list.addLast("Alfath");
        list.addLast("Nopal");

        System.out.println("============================");
        System.out.println("DAFTAR PRAKTIKAN KELOMPOK 11");
        System.out.println("============================");
        list.displayList();

        list.deleteByName("Wira");

        System.out.println("========================================");
        System.out.println("List Presensi Setelah Wira Tidak Hadir");
        System.out.println("========================================");
        list.displayList();

        list.reverseMiddleList();
        System.out.println("========================================");
        System.out.println("List Presensi Setelah Dibalik Tengah");
        System.out.println("========================================");
        list.displayList();
        
        list.reverseEntireList();
        System.out.println("========================================");
        System.out.println("List Presensi Setelah Dibalik");
        System.out.println("========================================");
        list.displayList();
    }
}