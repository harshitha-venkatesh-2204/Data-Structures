package lec2;

import java.util.Scanner;

public class Sequence<E> {
    protected Object[] data;
    protected int size;

    public Sequence(int n) throws IllegalArgumentException {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        this.data = new Object[n];
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public void append(E element) {
        if (this.size < this.data.length) {
            this.data[this.size] = element;
        } else {
            Object[] temp = new Object[this.size + 1];
            System.arraycopy(this.data, 0, temp, 0, this.size);
            this.data = temp;
            this.data[this.size] = element;
        }
        this.size++;
    }

    public Object get(int k) throws IndexOutOfBoundsException {
        if (k < 0 || k >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        return this.data[k];
    }

    public void print() {
        System.out.print("\nCurrent Sequence: ");
        for (int i = 0; i < this.size(); i++) {
            System.out.print(this.get(i) + " ");
        }
        System.out.println();
    }

    public void insert(int index, E newElement) {
        // IMPLEMENT ME
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException();
        }
        Object[] temp = new Object[this.size + 1];
        System.arraycopy(this.data, 0, temp, 0, index);
        temp[index] = newElement;
        System.arraycopy(this.data, index, temp, index + 1, this.size - index);
        this.data = temp;
        this.size++;
    }

    public void delete(int index) {
        // IMPLEMENT ME
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = index; i < this.size - 1; i++) {
            this.data[i] = this.data[i + 1];
        }
        this.size--;
    }

    public static void main(String[] args) {
        int k = 1;
        Scanner scanner = new Scanner(System.in);
        Sequence<Integer> s = new Sequence<Integer>(5);
        s.append(1);
        s.append(2);
        s.append(3);
        s.append(4);
        s.append(5);
        s.print();
        while (k == 1) {
            System.out.println("Choose \n a. 1 to Insert \n b. 2 to Delete \n c. 3 to Quit");
            System.out.println("Enter your choice");
            int mode = scanner.nextInt();
            // INSERT CONTROL LOOP HERE
            switch (mode) {
                case 1:
                    System.out.println("Enter the value to insert");
                    int insertValue = scanner.nextInt();
                    System.out.println("Enter the index to insert");
                    int insertIndex = scanner.nextInt();
                    s.insert(insertIndex, insertValue);
                    s.print();
                    break;
                case 2:
                    System.out.println("Enter the index to delete");
                    int deleteIndex = scanner.nextInt();
                    s.delete(deleteIndex);
                    s.print();
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    k = 0;
                    break;
                default:
                    System.out.println("Invalid! Please enter 1,2 or 3");
                    break;
            }

        }

    } // End main
} // End class
