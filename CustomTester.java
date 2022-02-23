/**
 * TODO: Add your file header
 * Name:
 * ID:
 * Email:
 * Sources used: Put "None" if you did not have any external help
 * Some example of sources used would be Tutors, Zybooks, and Lecture Slides
 * 
 * 2-4 sentence file description here
 */

import org.junit.*;
import static org.junit.Assert.*;

/**
 * TODO: Add your class header
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
        assertEquals("Front should be 4", 4, deque.front);
        assertEquals("Rear should be 4", 4, deque.rear);
        assertEquals("5 should have been inserted into index 4",
                Integer.valueOf(5), deque.data[4]);
        assertEquals("Index 0 should not have changed", null, deque.data[0]);
        assertEquals("Index 1 should not have changed", null, deque.data[1]);
        assertEquals("Index 2 should not have changed", null, deque.data[2]);
        assertEquals("Index 3 should not have changed", null, deque.data[3]);
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
        assertEquals("Index 0 should remain unchanged", null, deque.data[1]);
        assertEquals("Index 0 should remain unchanged", null, deque.data[2]);
        assertEquals("Index 0 should remain unchanged", null, deque.data[3]);
        assertEquals("Index 0 should remain unchanged", null, deque.data[4]);
    
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
        assertEquals("Index 0 should remain unchanged", null, deque.data[1]);
        assertEquals("Index 0 should remain unchanged", null, deque.data[2]);
        assertEquals("Index 0 should remain unchanged", null, deque.data[3]);
        assertEquals("Index 0 should remain unchanged", null, deque.data[4]);
    
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
     * Test MyStack when [TODO]
     */
    @Test
    public void testMyStack(){
        // You can test any method from MyStack or a combination of methods
    }

    // ----------------MyQueue class----------------
    /**
     * Test MyQueue when [TODO]
     */
    @Test
    public void testMyQueue(){
        // You can test any method from MyQueue or a combination of methods
    }
}
