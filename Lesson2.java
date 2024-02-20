

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class Lesson2 {
    public static void main(String[] args) {
        //  mergeArrays(new int[] {2, 43, 56, 78}, new int[] {5, 8, 23, 24, 48, 49});
        OneWayLinkedList<Integer> linkedList = new OneWayLinkedList<>();
        linkedList.add(5);
        linkedList.add(53);
        linkedList.add(235);
        linkedList.add(321);
        linkedList.add(599);
        linkedList.add(1092);

        reverseList(linkedList);
    }

    /**
     * [2, 43, 56, 78] i
     * [5, 8, 23, 24, 48, 49] j
     * -> [2, 5, 8, 23, 24, 43, 48, 49, 56, 78] k
     */
    static int[] mergeArrays(int[] ar1, int[] ar2) {
        int[] result = new int[ar1.length + ar2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        boolean lengthCondition1 = true;
        boolean lengthCondition2 = true;

        while (true) {
            if (lengthCondition2 && (ar2[j] < ar1[i])) {
                result[k] = ar2[j];
                j++;
                lengthCondition2 = j < ar2.length;
            } else if (lengthCondition1) {
                result[k] = ar1[i];
                i++;
                lengthCondition1 = i < ar1.length;
            } else {
                break;
            }

            k++;
        }

        return result;
    }

    /**
     * list: el1(3) -> el2(5) -> el3(44) -> el4(55) -> el5(122) -> el6(500)
     * head: 3, ref(el2(5))
     * tail: 500, ref(null)
     * from(head : tail):
     * 0:
     * next = head.next; // next = el2(5)
     * head.next = null;  // null <- el1()
     * previous = head; // previous = el1
     * 1:
     * current = next; // current = el2
     * next = next.next; // next = el3
     * current.next = previous;  // null <- el1() <- el2()
     * previous = current; // previous = el2
     * 2:
     * current = next; // current= el3
     * next = next.next; // next = el4
     * current.next = previous; // null <- el1() <- el2() <- el3()
     * previous = current; // previous = el3
     */
    static <T> OneWayLinkedList<T> reverseList(OneWayLinkedList<T> list) {
        Node<T> current;
        Node<T> next = list.head.getNextNode();
        Node<T> previous = list.head;
        Node<T> newTail = list.head;
        list.head.setNextNode(null);

        while (nonNull(next)) {
            current = next;
            next = next.getNextNode();
            current.setNextNode(previous);
            previous = current;
        }
        list.head = previous;
        list.tail = newTail;

        return list;
    }

    /*
    1
     */

    /**
     * Реализация стека
     */
    class Stack {
        private List<Integer> elements = new ArrayList<>();

        public void push(int element) {
            elements.add(element);
        }

        public Integer pop() {
            if (!elements.isEmpty()) {
                int result = elements.get(elements.size() - 1);
                elements.remove(elements.size() - 1);
                return result;
            }

            return null;
        }

        public Integer peek() {
            if (!elements.isEmpty()) {
                return elements.get(elements.size() - 1);
            }

            return null;
        }

        public void clear() {
            elements.clear();
        }
    }
}

class OneWayLinkedList<T> {
    Node<T> head;
    Node<T> tail;

    public void add(T value) {
        Node<T> newElem = new Node();
        newElem.setValue(value);

        if (isNull(tail)) {
            head = newElem;
            tail = newElem;
        } else {
            tail.setNextNode(newElem);
            tail = newElem;
        }
    }
}

class Node<T> {
    private T value;
    private Node nextNode;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

}
