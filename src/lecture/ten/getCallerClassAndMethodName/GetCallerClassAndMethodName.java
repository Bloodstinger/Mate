package lecture.ten.getCallerClassAndMethodName;

public class GetCallerClassAndMethodName {
    public static String getCallerClassAndMethodName() {
        StackTraceElement[] stackTraceElements = new Throwable().getStackTrace();
        try {
            String result = stackTraceElements[2].getClassName() + "#" + stackTraceElements[2].getMethodName();
            return result;
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        }
    }

}
