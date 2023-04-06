package main.java.mylib.datastructures.nodes;

public class Tnode<T> {
    private T data;
    private Tnode<T> left;
    private Tnode<T> right;

    // constructor
    public Tnode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    // getters and setters
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Tnode<T> getLeft() {
        return left;
    }

    public void setLeft(Tnode<T> left) {
        this.left = left;
    }

    public Tnode<T> getRight() {
        return right;
    }

    public void setRight(Tnode<T> right) {
        this.right = right;
    }
}

