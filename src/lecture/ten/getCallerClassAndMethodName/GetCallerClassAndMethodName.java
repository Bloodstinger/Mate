package lecture.ten.getCallerClassAndMethodName;

public class GetCallerClassAndMethodName {
    public static String getCallerClassAndMethodName() {
        StackTraceElement[] stackTraceElements = new Throwable().getStackTrace();
        try {
            return stackTraceElements[2].getClassName() + "#" + stackTraceElements[2].getMethodName();
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        }
    }

}
