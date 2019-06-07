package lecture.seven.array.list;

public class NegativeIndexException extends RuntimeException{
    public NegativeIndexException() {
        System.out.println("Index cannot be negative!");
    }
}
