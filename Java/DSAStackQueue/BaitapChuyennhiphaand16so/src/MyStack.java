import java.util.Stack;

public class MyStack {
    public static final char CHAR_55 = 55;
    public Stack convertBinary(int num) {
        Stack<Integer> stack = new Stack<Integer>();
        while (num != 0) {
            int d = num % 2;
            stack.push(d);
            num /= 2;
        }
        return stack;
    }

    public static void main(String[] args) {
        int decimalNumber = 123456789;
        System.out.print("Hệ nhị phân của " + decimalNumber + " là :");
        Stack<Integer> stack = new MyStack().convertBinary(decimalNumber);
        while (!(stack.isEmpty())) {
            System.out.print(stack.pop());
        }
        System.out.println();
        String stack1 = MyStack.convertNumber(decimalNumber, 16);
        System.out.println(stack1);
    }


    public static String convertNumber(int n, int b) {
        if (n < 0 || b < 2 || b > 16 ) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        int m;
        int remainder = n;
        while (remainder > 0) {
            if (b > 10) {
                m = remainder % b;
                if (m >= 10) {
//                    bang chu cai Aci: (char) (CHAR_55 + m)
                    sb.append((char) (CHAR_55 + m));
                } else {
                    sb.append(m);
                }
            } else {
                sb.append(remainder % b);
            }
            remainder = remainder / b;
        }
        return sb.reverse().toString();
    }
}



