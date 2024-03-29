/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficha4ed;

/**
 *
 * @author tiago
 */
public class LinkedQueue<T> implements QueueADT<T> {

    private int count;
    private LinearNode<T> front;
    private LinearNode<T> rear;

    public LinkedQueue() {
        this.count = 0;
        this.front = null;
        this.rear = null;
    }

    @Override
    public void enqueue(T element) {
        LinearNode<T> newNode = new LinearNode<>(element);
        if (this.isEmpty()) {
            this.front = newNode;
            this.rear = newNode;
        } else {
            this.rear.setNext(newNode);
            this.rear = newNode;
        }
        this.count++;
    }

    @Override
    public T dequeue() throws EmptyCollectionException2{
        if (this.isEmpty()) {
            throw new EmptyCollectionException2("Lista Vazia!");
        } else {
            LinearNode<T> current = new LinearNode<>();
            current = this.front;
            this.front = this.front.getNext();
            current.setNext(null);
            this.count--;
            return current.getElement();
        }
    }

    @Override
    public T first() throws EmptyCollectionException2{
        if(this.isEmpty()){
            throw new EmptyCollectionException2("Lista Vazia!");
        } else{
            return this.front.getElement();
        }
    }

    @Override
    public boolean isEmpty() {
        if(this.count == 0){
            return true;
        } else{
            return false;
        }
    }

    @Override
    public int size() {
        return this.count;
    }

    @Override
    public String toString() {
        if(this.isEmpty()){
            return "Lista Vazia";
        } else{
            LinearNode<T> current = this.front;
        StringBuilder str = new StringBuilder();
        str.append("Front: ");
        str.append(this.front.getElement());
        str.append("\n");
        str.append("Rear: ");
        str.append(this.rear.getElement());
        str.append("\n");
        str.append("Tamanho: ");
        str.append(this.count);
        str.append("\n");

        while (current != null) {
            str.append(current.getElement());
            str.append("\n");
            current = current.getNext();
        }
        return str.toString();
        }
    
    }

}
