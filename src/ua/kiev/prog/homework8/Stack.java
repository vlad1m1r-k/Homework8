package ua.kiev.prog.homework8;

import java.util.Arrays;

public class Stack {
    private Object[] elements = new Object[10];
    private int top = -1;
    private BlackList blackList;

    public Stack(BlackList blackList) {
        this.blackList = blackList;
    }

    public boolean push(Object object) {
        if (!blackList.isBlackListed(object)) {
            checkFreeSpace();
            top++;
            elements[top] = object;
            return true;
        }
        return false;
    }

    public Object pop() {
        if (top > -1) {
            Object object = elements[top];
            elements[top] = null;
            top--;
            return object;
        }
        return null;
    }

    public Object get() {
        if (top > -1) {
            return elements[top];
        }
        return null;
    }

    private void checkFreeSpace() {
        for (Object object : elements) {
            if (object == null) {
                return;
            }
        }
        elements = Arrays.copyOf(elements, elements.length + 5);
    }

    @Override
    public String toString() {
        return "Stack{" +
                "elements=" + Arrays.toString(elements) +
                '}';
    }
}
