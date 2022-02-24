/**
 * File: MyDeque.java
 * Name: Botao Zhang
 * ID: A17143584
 * Email: boz002@ucsd.edu
 * Sources used: Lecture recording and slides, Zybooks.
 * 
 * Descriptions: This file contains a MyDeque class implements DequeInterface,
 * elements can be added/removed from the deque. It also contains method
 * expandCapacity,size and peek(first/last) to access the elements.
 */

 /**
 * This class MyDeque implements DequeInterface and it is a generic class
 */
public class MyDeque<E> implements DequeInterface<E> {

    Object[] data;
    int size;
    int rear;
    int front;
    static final int DEFAULT_SIZE = 10;
    static final int TWO = 2;

    /**
     * Initialize the Object array data with length of initialCapacity
     * @param initialCapacity the initial capacity of the array
     */
    public MyDeque(int initialCapacity){
        if(initialCapacity < 0){
            throw new IllegalArgumentException();
        }
        //initialize instance variables
        this.data = new Object[initialCapacity];
        this.size = 0;
        this.rear = 0;
        this.front = 0;
    }

    /**
     * @return return the size of the deque
     */
    @Override
    public int size(){
        return this.size;
    }

    /**
     * Doubles the current capacity. If the capacity is 0, set the capacity to 
     * a default value of 10.
     */
    @Override
    public void expandCapacity(){
        //set to size of 10 if capacity is zero
        if(data.length == 0){
            this.data = new Object[DEFAULT_SIZE];
        }else{
            //double the capacity
            Object[] temp = new Object[data.length*TWO];
            int count = 0;
            for(int i = 0; i < data.length;i++){
                if(front+i >= data.length){
                    temp[i] = data[count];
                    count++;
                }else{
                    temp[i] = data[front+i];
                }  
            }
            this.data = temp;
            this.front = 0;
            this.rear = this.size - 1;
        }
    }

    /**
     * @param element the element that will be add to the deque in front
     */
    @Override
    public void addFirst(E element){
        if(element == null){
            throw new NullPointerException();
        }
        if(size == data.length){
            //expand capacity if full
            expandCapacity();
            this.data[data.length-1] = element;
            this.front = data.length-1;
        }
        if(this.size == 0){
            this.data[front] = element;
        }else{
            if(front == 0){
                //if front is at 0, wrap around the deque at the end
                this.data[data.length-1] = element;
                this.front = data.length-1;
            }else{
                //update front and add element to front
                this.front--;
                data[front] = element;
            }
        }
        //increment size
        this.size++;
    }

    /**
     * @param element the element that will be add to the deque at the end
     */
    @Override
    public void addLast(E element){
        if(element == null){
            throw new NullPointerException();
        }
        if(size == data.length){
            //expand capacity if full
            expandCapacity();
            this.data[size] = element;
            this.rear = size;
        }else if(this.size == 0){
            this.data[rear]=element;
        }else{
            if(rear == data.length-1){
                 //if rear is at the end, wrap around the deque at the front
                this.data[0] = element;
                this.rear = 0;
            }else{
                //update rear and add element to rear
                this.rear++;
                data[rear] = element;
            }
        }
        //increment size
        this.size++;
    }

    /**
     * removeFirst method that Removes and returns the element at the front of 
     * the deque if there is such an element.
     * @return return the element removed. Return null if deque is empty.
     */
    @Override
    public E removeFirst(){
        if(this.size == 0){
            //return null if empty
            return null;
        }else if(this.size==1){
            //dont update rear when remove last element
            E Removed = (E) data[front];
            this.data[front] = null;
            //update size
            this.size--;
            return Removed;
        }else{
            //remove and return data at front
            E Removed = (E) this.data[front];
            this.data[front] = null;
            //update instance variables
            this.size--;
            this.front++;
            return Removed;
        }
    }

    /**
     * removeLast method that Removes and returns the element at the end of 
     * the deque if there is such an element.
     * @return return the element removed.Return null if deque is empty.
     */
    @Override
    public E removeLast(){
        if(this.size == 0){
            //return null if empty
            return null;
        }else if(this.size==1){
            //dont update rear when remove last element
            E Removed = (E) data[rear];
            this.data[rear] = null;
            //update size
            this.size--;
            return Removed;
        }else{
            //remove and return data at rear
            E Removed = (E) data[rear];
            this.data[rear] = null;
            //update instance variables
            this.size--;
            this.rear--;
            return Removed;
        }
    }

    /**
     * peekFirst method that returns the element in the front of the deque 
     * if there is such an element.
     * @return return the element in the front.Return null if deque is empty.
     */
    @Override
    public E peekFirst(){
        if(this.size == 0){
            return null;
        }else{
            return (E)data[front];
        }
    }

    /**
     * peekLast method that returns the element at the end of the deque 
     * if there is such an element.
     * @return return the element at the end.Return null if deque is empty.
     */
    @Override
    public E peekLast(){
        if(this.size == 0){
            return null;
        }else{
            return (E)data[rear];
        }
    }




}
