package ua.kiev.prog.homework8;

import java.util.Arrays;

public class BlackList {
    private Class<?>[] classes = new Class[10];

    public void addClass(Object object) {
        if (!isBlackListed(object)) {
            checkFreeSpace();
            for (int i = 0; i < classes.length; i++) {
                if (classes[i] == null) {
                    classes[i] = object.getClass();
                    break;
                }
            }
        }
    }

    public void addClass(Class<?> className) {
        if (!isBlackListed(className)) {
            checkFreeSpace();
            for (int i = 0; i < classes.length; i++) {
                if (classes[i] == null) {
                    classes[i] = className;
                    break;
                }
            }
        }
    }

    public boolean isBlackListed(Object object) {
        for (Class<?> className : classes) {
            if (className != null && className == object.getClass()) {
                return true;
            }
        }
        return false;
    }

    public boolean isBlackListed(Class<?> name) {
        for (Class<?> className : classes) {
            if (className != null && className == name) {
                return true;
            }
        }
        return false;
    }

    private void checkFreeSpace() {
        for (Class<?> className : classes) {
            if (className == null) {
                return;
            }
        }
        classes = Arrays.copyOf(classes, classes.length + 5);
    }

    @Override
    public String toString() {
        return "BlackList{" +
                "classes=" + Arrays.toString(classes) +
                '}';
    }
}
