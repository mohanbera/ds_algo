import java.util.Scanner;

public class solve {
    public static void main(String[] args) {
        Scanner r = new Scanner(System.in);
        String str1 = r.next();
        recursion(str1, 0, new StringBuilder(""));
    }

    static void recursion(String str, int start, StringBuilder sb) {
        int len = str.length();
        if(start == len) {
            return;
        }
        for(int i=start; i<len; i++) {
            sb.append(str.charAt(i));
            System.out.println(sb);
            recursion(str, i+1, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
