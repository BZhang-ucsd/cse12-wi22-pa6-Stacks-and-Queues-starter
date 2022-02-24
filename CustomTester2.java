/**
 * Name: Jiajia Li, jinpeng Huang
 * ID: A17158450, A16530556
 * Email: jil273@ucsd.edu, jih054@ucsd.edu
 * Sources used: Zybooks, lecture slides
 * 
 * This file contains the custom tests of ourselves.
 * We use this to tests if MyDeque, MyStack, and MyQueue implementation
 * work correctly.
 */

import org.junit.*;
import static org.junit.Assert.*;

/**
 * 
 * This class contains custom test cases for MyDeque, MyStack, and MyQueue.
 * We use these to check if thay work correctly.
 * 
 * IMPORTANT: Do not change the method names and points are awarded
 * only if your test cases cover cases that the public tester file
 * does not take into account.
 */
public class CustomTester2 {
    /**
     * This is the helper method, it initialize all instance 
     * variables of MyDeque
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
    // ----------------MyDeque class----------------
    /**
     * Test the constructor when initialCapacity is negative
     */
    @Test
    public void testMyDequeConstructor() {
        //when initialCapacity is negative, it throw exception
        boolean exceptionThrown = false;
        try {
            MyDeque<Integer> deque = new MyDeque<>(-1);
        } 
        catch (IllegalArgumentException e) {
            exceptionThrown = true;
        }
        assertTrue("Check IllegalArgumentException", exceptionThrown); 
    }

    /**
     * Test the expandCapacity method when front and rear are not at the 
     * index 0 or size - 1
     */
    @Test
    public void testMyDequeExpandCapacity() {
        MyDeque<Integer> deque = new MyDeque<>(5);
        Integer[] listorig = { 3, 4, 5, 1, 2};
        Integer[] listfinal = { 1, 2, 3, 4, 5, null, null, null, null, null};
        initDeque(deque, listorig, 5, 3, 2);

        deque.expandCapacity();

        assertEquals("Capacity doubled", 10, deque.data.length);
        assertEquals("Size not changed", 5, deque.size);
        assertEquals("Front at 0", 0, deque.front);
        assertEquals("Rear at size - 1", 4, deque.rear);
        for (int i = 0; i < 10; i++) {
            assertEquals("Deque maintained", 
            listfinal[i], deque.data[i]);
        }
    }

    /**
     * Test the addFirst method when element is null
     */
    @Test
    public void testAddFirst() {
        //when element is null, it throw exception
        MyDeque<Integer> deque = new MyDeque<>(5);
        boolean exceptionThrown = false;
        try {
           deque.addFirst(null);
        } 
        catch (NullPointerException e) {
            exceptionThrown = true;
        }
        assertTrue("Check NullPointerException", exceptionThrown); 
    }

    /**
     * Test the addLast method when element is null
     */
    @Test
    public void testAddLast() {
        //when element is null, it throw exception
        MyDeque<Integer> deque = new MyDeque<>(5);
        boolean exceptionThrown = false;
        try {
           deque.addLast(null);
        } 
        catch (NullPointerException e) {
            exceptionThrown = true;
        }
        assertTrue("Check NullPointerException", exceptionThrown); 
    }

    /**
     * Test the removeFirst method when there are no elements in the deque
     */
    @Test
    public void testRemoveFirst() {
        MyDeque<Integer> deque = new MyDeque<>(5);
        Integer[] listorig = {null, null, null, null, null};
        initDeque(deque, listorig, 0, 3, 3); //size = 0, front = 3, rear = 3.

        deque.removeFirst();
        //Integer[] listfinish = {null, null, null, null, null}. Unchanged.
        //size = 0, front = 3, rear = 3. Unchanged.

        assertEquals("Capacity not change", 5, deque.data.length);
        assertEquals("Size not changed", 0, deque.size);
        assertEquals("Front not changed, at 3", 3, deque.front);
        assertEquals("Rear not changed, at 3", 3, deque.rear);
        assertEquals("return null", null, deque.removeFirst());
    }

    /**
     * Test the removeLast method when there is one element in the deque
     */
    @Test
    public void testRemoveLast() {
        MyDeque<Integer> deque = new MyDeque<>(5);
        Integer[] listorig = {null, null, null, null, 5};
        initDeque(deque, listorig, 1, 4, 4); //size = 1, front = 4, rear = 4.

        deque.removeLast();
        //Integer[] listfinish = {null, null, null, null, null}. Changed.
        //size = 0, front = 4, rear = 4. Size changed.

        assertEquals("Capacity not changed", 5, deque.data.length);
        assertEquals("Size - 1", 0, deque.size);
        assertEquals("Front not changed, at 4", 4, deque.front);
        assertEquals("Rear not changed, at 4", 4, deque.rear);
        assertEquals("Index 4 changed", null, deque.data[4]);
    }

    /**
     * Test the peekFirst method when there are no elements in the deque
     */
    @Test
    public void testPeekFirst(){
        MyDeque<Integer> deque = new MyDeque<>(5);
        Integer[] listorig = {null, null, null, null, null};
        initDeque(deque, listorig, 0, 2, 2); //size = 0, front = 2, rear = 2.

        deque.peekFirst();
        //Integer[] listfinish = {null, null, null, null, null}. Unchanged.
        //size = 0, front = 2, rear = 2. Unchanged.

        assertEquals("Capacity not change", 5, deque.data.length);
        assertEquals("Size not changed", 0, deque.size);
        assertEquals("Front not changed, at 2", 2, deque.front);
        assertEquals("Rear not changed, at 2", 2, deque.rear);
        assertEquals("return null", null, deque.peekFirst());
    }

    /**
     * Test the peekLast method when there are no elements in the deque
     */
    @Test
    public void testPeekLast(){
        MyDeque<Integer> deque = new MyDeque<>(5);
        Integer[] listorig = {null, 4, null, null, null};
        initDeque(deque, listorig, 1, 1, 1);//size = 1, front = 1, rear = 1.

        deque.peekLast();
        //Integer[] listfinish = {null, 4, null, null, null}. Unchanged.
        //size = 1, front = 1, rear =1. Unchanged.

        assertEquals("Capacity not change", 5, deque.data.length);
        assertEquals("Size not changed", 1, deque.size);
        assertEquals("Front not changed, at 1", 1, deque.front);
        assertEquals("Rear not changed, at 1", 1, deque.rear);
        assertEquals("return null", Integer.valueOf(4), deque.peekLast());
    }

    // ----------------MyStack class----------------
    /**
     * Test MyStack when push element, then pop element, and peek, 
     * then check if empty and size (combination)
     */
    @Test
    public void testMyStack(){
        // You can test any method from MyStack or a combination of methods
        //set up
        MyStack<Integer> stack = new MyStack<>(5);
        Integer[] listorig = {null, null, null, null, null};
        initDeque(stack.theStack, listorig, 0, 2, 2);
        Integer element = 5;

        assertTrue("check if empty", stack.empty());
        stack.push(element);
        //{null, null, 5, null, null}
        //size = 1, front = 2, rear = 2
        assertFalse("check if empty", stack.empty());
        assertEquals("Capacity not changed", 5,
                stack.theStack.data.length);
        assertEquals("Size changed", 1, stack.theStack.size);
        assertEquals("Front not changed", 2, stack.theStack.front);
        assertEquals("Rear not changed", 2, stack.theStack.rear);
        stack.pop();
        //{null, null, null, null, null}
        //size = 0, front = 2, rear = 2
        assertTrue("check if empty", stack.empty());
        assertEquals("Capacity not changed", 5,
                stack.theStack.data.length);
        assertEquals("Size changed", 0, stack.theStack.size);
        assertEquals("Front not changed", 2, stack.theStack.front);
        assertEquals("Rear not changed", 2, stack.theStack.rear);
        stack.peek();
        //{null, null, null, null, null}
        //size = 0, front = 2, rear = 2
        //return null
        assertEquals("Size not changed", 0, stack.theStack.size);
        assertEquals("Front not changed", 2, stack.theStack.front);
        assertEquals("Rear not changed", 2, stack.theStack.rear);
        assertEquals("return null", null, stack.peek());
    }

    // ----------------MyQueue class----------------
    /**
     * Test MyQueue when enqueue element, then dequeue element, and peek,
     * then check if empty and size (combination)
     */
    @Test
    public void testMyQueue(){
        // You can test any method from MyQueue or a combination of methods
        //set up
        MyQueue<Integer> queue = new MyQueue<>(5);
        Integer[] listorig = {null, 3, null, null, null};
        initDeque(queue.theQueue, listorig, 1, 1, 1);
        Integer element = 5;

        assertFalse("check if empty", queue.empty());
        queue.enqueue(element);
        //{null, 3, 5, null, null}
        //size = 2, front = 1, rear = 2
        assertFalse("check if empty", queue.empty());
        assertEquals("Capacity not changed", 5,
                queue.theQueue.data.length);
        assertEquals("Size changed", 2, queue.theQueue.size);
        assertEquals("Front not changed", 1, queue.theQueue.front);
        assertEquals("Rear changed", 2, queue.theQueue.rear);
        queue.dequeue();
        //{null, null, 5, null, null}
        //size = 1, front = 2, rear = 2
        assertFalse("check if empty", queue.empty());
        assertEquals("Capacity not changed", 5,
                queue.theQueue.data.length);
        assertEquals("Size changed", 1, queue.theQueue.size);
        assertEquals("Front changed", 2, queue.theQueue.front);
        assertEquals("Rear not changed", 2, queue.theQueue.rear);
        queue.dequeue();
        //{null, null, null, null, null}
        //size = 0, front = 2, rear = 2
        assertTrue("check if empty", queue.empty());
        queue.peek();
        //{null, null, null, null, null}
        //size = 0, front = 2, rear = 2
        //return null
        assertEquals("Size not changed", 0, queue.theQueue.size);
        assertEquals("Front not changed", 2, queue.theQueue.front);
        assertEquals("Rear not changed", 2, queue.theQueue.rear);
        assertEquals("return null", null, queue.peek());
     
    }
}
