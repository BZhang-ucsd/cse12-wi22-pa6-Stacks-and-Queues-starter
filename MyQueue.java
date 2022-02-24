/**
 * File: MyQueue.java
 * Name: Botao Zhang
 * ID: A17143584
 * Email: boz002@ucsd.edu
 * Sources used: Lecture recording and slides, Zybooks.
 * 
 * Descriptions: This is the Queue ADt implements from MyQeque. Class includes
 * overrided method empty, enqueue, dequeue, peek and size which can use to
 * access the elements in the queue.
 */

/**
 * This class implements the Queue ADT using a MyDeque instance variable called
 * theStack.
 */
public class MyQueue<E> implements QueueInterface<E> {
    MyDeque<E> theQueue;

    /**
     * Constructor to create new MyQueue that holds a MyDeque.
     * 
     * @param capacity The max amount of elements this data structure can hold.
     */
    public MyQueue(int capacity) {
        theQueue = new MyDeque<E>(capacity);
    }

    /**
     * Checks whether or not the queue is empty.
     * 
     * @return True if there are no elements in the queue, false otherwise.
     */
    @Override
    public boolean empty() {
        if(theQueue.size == 0){
            return true;
        }else{
            return false;
        }
    }

    /**
     * Adds the specified element to the tail of this MyQueue.
     * 
     * @param element the element to add to the queue
     */
    @Override
    public void enqueue(E element) {
        theQueue.addLast(element);
    }

    /**
     * Removes the element at the head of this MyQueue.
     * Returns the element removed, or null if there was no such
     * element.
     * 
     * @return the element removed, or null if the size was zero.
     */
    @Override
    public E dequeue() {
        E Dequeued = theQueue.removeFirst();
        return Dequeued;
    }

    /**
     * Returns the element at the head of this MyQueue,
     * or null if there was no such element.
     * 
     * @return the element at the head, or null if the size was zero.
     */
    @Override
    public E peek() {
        return theQueue.peekFirst();
    }

    /**
     * Returns the number of elements in this queue.
     * 
     * @return the number of elements in the queue
     */
    public int size() {
        return theQueue.size();
    }

}
