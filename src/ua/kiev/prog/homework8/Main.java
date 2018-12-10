package ua.kiev.prog.homework8;

public class Main {
    public static void main(String[] args) {
        BlackList blackList = new BlackList();
        blackList.addClass(new Integer("1"));
        blackList.addClass("".getClass());

        Stack stack = new Stack(blackList);
        System.out.println(stack.push(12.3));
        System.out.println(stack.push(12L));
        System.out.println(stack.push("12"));
        System.out.println(stack.get());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }
}
