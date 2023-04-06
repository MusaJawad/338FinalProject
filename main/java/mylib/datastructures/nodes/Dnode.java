package main.java.mylib.datastructures.nodes;

public class Dnode<T> {
    private T data;
    private Dnode<T> next;
    private Dnode<T> prev;

    public Dnode(T data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Dnode<T> getNext() {
        return this.next;
    }

    public void setNext(Dnode<T> next) {
        this.next = next;
    }

    public Dnode<T> getPrev() {
        return this.prev;
    }

    public void setPrev(Dnode<T> prev) {
        this.prev = prev;
    }
}
