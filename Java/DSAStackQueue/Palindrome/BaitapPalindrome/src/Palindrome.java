import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class Palindrome {
    public static void main(String[] args) {
        String text="Able was I ere";
        String[]str=text.split("");
        for (String e:str
             ) {
            System.out.println(e);
        }
        Stack<String> stack;
        stack = new Stack<>();
        stack.addAll(Arrays.asList(str));
        Collections.reverse(stack);
        for (String e:stack
        ) {
            System.out.println(e);
        }
        int i=0;
        boolean check=true;
        for (String e:stack) {
            if (!e.equals(str[i])){
                check=false;
                break;
            }
        }
        if (check){
            System.out.println("chuoi Palindrome");
        }else System.out.println("Khong phai");
    }

}
