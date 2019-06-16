package lecture.ten.getCallerClassAndMethodName;

public class Test {
    public static void main(String[] args) {
        System.out.println(GetCallerClassAndMethodName.getCallerClassAndMethodName());
        test();
    }
    private static void test() {
        System.out.println(GetCallerClassAndMethodName.getCallerClassAndMethodName());
    }
}
