public class MyDeque<E> implements DequeInterface<E> {

    Object[] data;
    int size = 0;
    int rear = 0;
    int front = 0;
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
        this.data = new Object[initialCapacity];
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
        if(data.length == 0){
            this.data = new Object[DEFAULT_SIZE];
        }else{
            Object[] temp = new Object[data.length*TWO];
            for(int i = 0; i < data.length;i++){
                temp[i] = data[i];
            }
            data = temp;
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
            expandCapacity();
            data[data.length-1] = element;
            front = data.length-1;
        }else if(data == null){
            data[data.length-1]=element;
        }else{
            for(int i = 0; i < data.length-1;i++){
                if(data[i] == null && data[i+1]!=null){
                    data[i]= element;
                    front = i;
                    break;
                }
                if(i == data.length-TWO){
                    data[i+1]= element;
                }
            }
        }

        size++;
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
            expandCapacity();
            data[size] = element;
            rear = size;
        }else if(data == null){
            data[0]=element;
        }else{
            for(int i = data.length-1 ; i > 0;i--){
                if(data[i] == null && data[i-1]!=null){
                    data[i]= element;
                    rear = i;
                    break;
                }
                if(i == 1){
                    data[0]=element;
                }
            }
        }
        size++;
    }

    /**
     * removeFirst method that Removes and returns the element at the front of 
     * the deque if there is such an element.
     * @return return the element removed. Return null if deque is empty.
     */
    @Override
    public E removeFirst(){
        if(data == null){
            return null;
        }else{
            E Removed = (E) data[front];
            data[front] = null;
            size--;
            front++;
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
        if(data == null){
            return null;
        }else{
            E Removed = (E) data[rear];
            data[rear] = null;
            size--;
            rear--;
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
        return (E)data[front];
    }

    /**
     * peekLast method that returns the element at the end of the deque 
     * if there is such an element.
     * @return return the element at the end.Return null if deque is empty.
     */
    @Override
    public E peekLast(){
        return (E)data[rear];
    }




}
