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
            this.data[data.length-1] = element;
            this.front = data.length-1;
        }
        if(this.size == 0){
            this.data[data.length-1] = element;
            this.front = data.length-1;
            this.rear = data.length-1;
        }else{
            for(int i = 0; i < this.data.length-1;i++){
                if(data[i] == null && data[i+1]!=null){
                    this.data[i]= element;
                    this.front = i;
                    break;
                }
                if(i == data.length-TWO){
                    this.data[i+1]= element;
                    this.front = data.length-1;
                }
            }
        }

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
            expandCapacity();
            this.data[size] = element;
            this.rear = size;
        }else if(this.size == 0){
            this.data[0]=element;
            this.front = 0;
            this.rear = 0;
        }else{
            for(int i = this.data.length-1 ; i > 0;i--){
                if(this.data[i] == null && this.data[i-1]!=null){
                    this.data[i]= element;
                    this.rear = i;
                    break;
                }
                if(i == 1){
                    this.data[0]=element;
                    this.rear = 0;
                }
            }
        }
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
            return null;
        }else{
            E Removed = (E) this.data[front];
            this.data[front] = null;
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
            return null;
        }else{
            E Removed = (E) data[rear];
            this.data[rear] = null;
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
