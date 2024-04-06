package verify;

public class str_Equal_str {
    public static void main(String[] args) {
        String str="1bar2";
        String str1="bar";
        String str2=str.substring(1,4);
        System.out.println(str2);
        System.out.print("str1==str2 is "+(boolean)(str1==str2));
    }
}
