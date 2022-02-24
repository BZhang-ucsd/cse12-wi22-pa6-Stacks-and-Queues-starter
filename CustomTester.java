/**
 * File: CustomTester.java
 * Name: Botao Zhang
 * ID: A17143584
 * Email: boz002@ucsd.edu
 * Sources used: Lecture recording and slides, Zybooks.
 * 
 * Descriptions: This is a custom tester file for the implementation of 
 * MyDeque.java, MyQueue.java and MyStack.java for PA6 of CSE12. Test including
 * the edge case of the method in each Class.
 */

import org.junit.*;
import static org.junit.Assert.*;

/**
 * This is the class CustomTester containing the tester for MyDeque.java, 
 * MyQueue.java and MyStack.java on their methods.
 * 
 * IMPORTANT: Do not change the method names and points are awarded
 * only if your test cases cover cases that the public tester file
 * does not take into account.
 */
public class CustomTester {
    // ----------------MyDeque class----------------

    static final int OUTOFBOUND = -100;
     /**
     * Helper method to initialize all instance variables of MyDeque
     * @param deque The deque to initialize
     * @param data The data array
     * @param size The value for size
     * @param front The value for front
     * @param rear The value for rear
     */
    static void initDeque(MyDeque<Integer> deque, Object[] data, int size, 
        int front, int rear) {
        deque.data = data;
        deque.size = size;
        deque.front = front;
        deque.rear = rear;
    }

     /**
     * Test the constructor when initial MyDeque with capacity less than 0
     */
    @Test
    public void testMyDequeConstructor() {
        boolean ExceptionThrown = false;
        try{
            MyDeque<Integer> deque = new MyDeque<>(OUTOFBOUND);
        }catch(IllegalArgumentException e){
            ExceptionThrown = true;
        }
        assertTrue("Exception not Thrown", ExceptionThrown);
    }

    /**
     * Test the expandCapacity method when capacity is 0
     */
    @Test
    public void testMyDequeExpandCapacity() {
        MyDeque<Integer> deque = new MyDeque<>(0);
        Integer[] test = {};
        initDeque(deque, test, 0, 0, 0);

        deque.expandCapacity();

        assertEquals("Capacity should set to default", 10, deque.data.length);
        assertEquals("Size should not changed", 0, deque.size);
        assertEquals("Front should be 0", 0, deque.front);
        assertEquals("Rear should be 0", 0, deque.rear);
    }

    /**
     * Test the expandCapacity method when capacity is full. Test if elements 
     * are contiguous after expanding.
     */
    @Test
    public void testMyDequeExpandCapacity2() {
        MyDeque<Integer> deque = new MyDeque<>(5);
        Integer[] test = { 3, 4, 5, 1, 2 };
        initDeque(deque, test, 5, 3, 2);

        deque.expandCapacity();

        assertEquals("Capacity should set to default", 10, deque.data.length);
        assertEquals("Size should not changed", 5, deque.size);
        assertEquals("Front should be 0", 0, deque.front);
        assertEquals("Rear should be 0", 4, deque.rear);

        assertEquals("Index 0 should be 1", 1, deque.data[0]);
        assertEquals("Index 1 should be 2", 2, deque.data[1]);
        assertEquals("Index 2 should be 3", 3, deque.data[2]);
        assertEquals("Index 3 should be 4", 4, deque.data[3]);
        assertEquals("Index 4 should be 5", 5, deque.data[4]);
        assertEquals("Index 5 should be null", null, deque.data[5]);
        assertEquals("Index 6 should be null", null, deque.data[6]);
        assertEquals("Index 7 should be null", null, deque.data[7]);
        assertEquals("Index 8 should be null", null, deque.data[8]);
        assertEquals("Index 9 should be null", null, deque.data[9]);
    }

    /**
     * Test the expandCapacity method when capacity is full. Test if elements 
     * are contiguous after expanding.
     */
    @Test
    public void testMyDequeExpandCapacity3() {
        MyDeque<Integer> deque = new MyDeque<>(5);
        Integer[] test = { 5, 1, 2, 3, 4 };
        initDeque(deque, test, 5, 1, 0);

        deque.expandCapacity();

        assertEquals("Capacity should set to default", 10, deque.data.length);
        assertEquals("Size should not changed", 5, deque.size);
        assertEquals("Front should be 0", 0, deque.front);
        assertEquals("Rear should be 0", 4, deque.rear);

        assertEquals("Index 0 should be 1", 1, deque.data[0]);
        assertEquals("Index 1 should be 2", 2, deque.data[1]);
        assertEquals("Index 2 should be 3", 3, deque.data[2]);
        assertEquals("Index 3 should be 4", 4, deque.data[3]);
        assertEquals("Index 4 should be 5", 5, deque.data[4]);
        assertEquals("Index 5 should be null", null, deque.data[5]);
        assertEquals("Index 6 should be null", null, deque.data[6]);
        assertEquals("Index 7 should be null", null, deque.data[7]);
        assertEquals("Index 8 should be null", null, deque.data[8]);
        assertEquals("Index 9 should be null", null, deque.data[9]);
    }


    /**
     * Test the addFirst method when the list is empty
     */
    @Test
    public void testAddFirst() {
        MyDeque<Integer> deque = new MyDeque<>(5);
        Integer[] test = { null, null, null, null, null};
        initDeque(deque, test, 0, 0, 0);

        deque.addFirst(5);
        //{null, null, null, null, 5};

        assertEquals("Capacity should not change", 5, deque.data.length);
        assertEquals("Should increment size", 1, deque.size);
        assertEquals("Front should be 0", 0, deque.front);
        assertEquals("Rear should be 4", 0, deque.rear);
        assertEquals("5 should have been inserted into index 0",
                Integer.valueOf(5), deque.data[0]);
        assertEquals("Index 1 should not have changed", null, deque.data[1]);
        assertEquals("Index 2 should not have changed", null, deque.data[2]);
        assertEquals("Index 3 should not have changed", null, deque.data[3]);
        assertEquals("Index 4 should not have changed", null, deque.data[4]);
    }

    /**
     * Test the addLast method when the list is empty
     */
    @Test
    public void testAddLast() {
        MyDeque<Integer> deque = new MyDeque<>(5);
        Integer[] test = { null, null, null, null, null};
        initDeque(deque, test, 0, 0, 0);

        deque.addLast(5);
        //{null, null, null, null, 5};

        assertEquals("Capacity should not change", 5, deque.data.length);
        assertEquals("Should increment size", 1, deque.size);
        assertEquals("Front should be 0", 0, deque.front);
        assertEquals("Rear should be 0", 0, deque.rear);
        assertEquals("5 should have been inserted into index 4",
                Integer.valueOf(5), deque.data[0]);
        assertEquals("Index 0 should not have changed", null, deque.data[1]);
        assertEquals("Index 1 should not have changed", null, deque.data[2]);
        assertEquals("Index 2 should not have changed", null, deque.data[3]);
        assertEquals("Index 3 should not have changed", null, deque.data[4]);
    }

    /**
     * Test the removeFirst method when the list is empty
     */
    @Test
    public void testRemoveFirst() {
        MyDeque<Integer> deque = new MyDeque<>(10);
        Integer[] test = { null, null, null, null, null };
        initDeque(deque, test, 0, 0, 0);

        assertEquals("Element removed should be returned", null,
                deque.removeFirst());

        assertEquals("Array length unchanged",5,deque.data.length);
        assertEquals("Size should unchange", 0, deque.size);
        assertEquals("Front unchanged", 0, deque.front);
        assertEquals("Rear unchanged", 0, deque.rear);
        assertEquals("Index 0 should remain unchanged", null, deque.data[0]);
        assertEquals("Index 1 should remain unchanged", null, deque.data[1]);
        assertEquals("Index 2 should remain unchanged", null, deque.data[2]);
        assertEquals("Index 3 should remain unchanged", null, deque.data[3]);
        assertEquals("Index 4 should remain unchanged", null, deque.data[4]);
    
    }

    /**
     * Test the removeFirst method when remove last element
     */
    @Test
    public void testRemoveFirst2() {
        MyDeque<Integer> deque = new MyDeque<>(10);
        Integer[] test = { null, null, null, 4, null };
        initDeque(deque, test, 1, 3, 3);

        assertEquals("Element removed should be returned", Integer.valueOf(4),
                deque.removeFirst());
        assertEquals("Array length unchanged",5,deque.data.length);
        assertEquals("Size should bee 0", 0, deque.size);
        assertEquals("Front unchanged", 3, deque.front);
        assertEquals("Rear unchanged", 3, deque.rear);
        assertEquals("Index 0 should remain unchanged", null, deque.data[0]);
        assertEquals("Index 1 should remain unchanged", null, deque.data[1]);
        assertEquals("Index 2 should remain unchanged", null, deque.data[2]);
        assertEquals("Index 3 should be null", null, deque.data[3]);
        assertEquals("Index 4 should remain unchanged", null, deque.data[4]);
    
    }

    /**
     * Test the removeLast method when the list is empty
     */
    @Test
    public void testRemoveLast() {
        MyDeque<Integer> deque = new MyDeque<>(5);
        Integer[] test = { null, null, null, null, null };
        initDeque(deque, test, 0, 0, 0);

        assertEquals("Element removed should be returned", null,
                deque.removeLast());

        assertEquals("Array length unchanged",5,deque.data.length);
        assertEquals("Size should unchange", 0, deque.size);
        assertEquals("Front unchanged", 0, deque.front);
        assertEquals("Rear unchanged", 0, deque.rear);
        assertEquals("Index 0 should remain unchanged", null, deque.data[0]);
        assertEquals("Index 1 should remain unchanged", null, deque.data[1]);
        assertEquals("Index 2 should remain unchanged", null, deque.data[2]);
        assertEquals("Index 3 should remain unchanged", null, deque.data[3]);
        assertEquals("Index 4 should remain unchanged", null, deque.data[4]);
    
    }

    /**
     * Test the removeLast method when remove last element
     */
    @Test
    public void testRemoveLast2() {
        MyDeque<Integer> deque = new MyDeque<>(5);
        Integer[] test = { null, null, 3, null, null };
        initDeque(deque, test, 1, 2, 2);

        assertEquals("Element removed should be returned", Integer.valueOf(3),
                deque.removeLast());
        assertEquals("Array length unchanged",5,deque.data.length);
        assertEquals("Size should bee 0", 0, deque.size);
        assertEquals("Front unchanged", 2, deque.front);
        assertEquals("Rear unchanged", 2, deque.rear);
        assertEquals("Index 0 should remain unchanged", null, deque.data[0]);
        assertEquals("Index 1 should remain unchanged", null, deque.data[1]);
        assertEquals("Index 2 should be null", null, deque.data[2]);
        assertEquals("Index 3 should remain unchanged", null, deque.data[3]);
        assertEquals("Index 4 should remain unchanged", null, deque.data[4]);
    
    }

    

    /**
     * Test the peekFirst method when the list is empty
     */
    @Test
    public void testPeekFirst(){
        MyDeque<Integer> deque = new MyDeque<>(10);
        Integer[] test = { null, null, null, null, null };
        initDeque(deque, test, 0, 0, 0);

        assertEquals("Element should be null", null, deque.peekFirst());

    }

    /**
     * Test the peekLast method when the list is empty
     */
    @Test
    public void testPeekLast(){
        MyDeque<Integer> deque = new MyDeque<>(10);
        Integer[] test = { null, null, null, null, null };
        initDeque(deque, test, 0, 0, 0);

        assertEquals("Element should be null", null, deque.peekLast());
    }

    // ----------------MyStack class----------------
    /**
     * Test MyStack when push and pop non-empty stack. Test when pop and peek
     * empty stack
     */
    @Test
    public void testMyStack(){
        MyStack<Integer> stack = new MyStack<>(10);
        Integer[] test = { 1, 2, 3, null, null, null, null, null,
                null, null };
        initDeque(stack.theStack, test, 3, 0, 2);

        stack.push(4);

        assertEquals("Element should be at the top of the stack", 
                        Integer.valueOf(4), stack.theStack.peekLast());
        assertEquals("Capacity should not have changed", 10,
                stack.theStack.data.length);
        assertEquals("Size should be incremented", 4, stack.theStack.size);
        assertEquals("Front should be same", 0, stack.theStack.front);
        assertEquals("Rear should increment", 3, stack.theStack.rear);

        assertEquals("Element should be 4 which just pushed to the top", 
        Integer.valueOf(4), stack.pop());
        assertEquals("Capacity should not have changed", 10,
        stack.theStack.data.length);
        assertEquals("Size should be decrement", 3, stack.theStack.size);
        assertEquals("Front should be same", 0, stack.theStack.front);
        assertEquals("Rear should decrement", 2, stack.theStack.rear);

        stack.pop();
        stack.pop();
        stack.pop();
        //stack should now be empty

        assertEquals("Element should be at the top of the stack", 
        null, stack.pop());
        assertEquals("Element should be at the top of the stack", 
        null, stack.peek());
    }

    // ----------------MyQueue class----------------
    /**
     * Test MyQueue when enqueue multiple and dequeue nom-empty queue. 
     * Test when dequeue and peek empty queue.
     */
    @Test
    public void testMyQueue(){
        MyQueue<Integer> queue = new MyQueue<>(10);
        Integer[] test = { 1, 2, 3, null, null, null, null, null,
            null, null };
        initDeque(queue.theQueue, test, 3, 0, 2);

        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        //{ 1, 2, 3, 4, 5, 6, null, null, null, null }; front:0 rear:5

        assertEquals("6 should be at the end of the queue", 
                        Integer.valueOf(6),queue.theQueue.peekLast());
        assertEquals("Capacity should not have changed", 10,
                queue.theQueue.data.length);
        assertEquals("Size should be incremented", 6, queue.theQueue.size);
        assertEquals("Front should not have changed", 0, queue.theQueue.front);
        assertEquals("Rear should be 5", 5, queue.theQueue.rear);

        assertEquals("1 should be dequeue", Integer.valueOf(1),queue.dequeue());
        assertEquals("2 should be dequeue", Integer.valueOf(2),queue.dequeue());
        assertEquals("3 should be dequeue", Integer.valueOf(3),queue.dequeue());
        assertEquals("4 should be dequeue", Integer.valueOf(4),queue.dequeue());
        assertEquals("5 should be dequeue", Integer.valueOf(5),queue.dequeue());
        //{ null, null, null, null, null, 6, null, null, null, null }; 
        // front:5 rear:5
        assertEquals("6 should be dequeue", Integer.valueOf(6),queue.dequeue());
        //{ null, null, null, null, null, null, null, null, null, null }; 
        // front:5 rear:5

        //now the queue should be empty
        assertTrue("list empty", queue.empty());
        assertEquals("shoule be null since empty", null ,queue.peek());
        assertEquals("shoule be null since empty", null ,queue.dequeue());
        assertEquals("front should be ", 5 ,queue.theQueue.front);
        assertEquals("rear should be", 5 , queue.theQueue.rear);

    }
}
