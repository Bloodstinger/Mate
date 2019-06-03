package lecture.three.ascii;

public class AsciiCharSequence implements CharSequence {
    private byte[] byteArray;

    public AsciiCharSequence(byte[] byteArray) {
        this.byteArray = byteArray;
    }

    @Override
    public int length() {
        return byteArray.length;
    }

    @Override
    public char charAt(int index) {
        return (char) byteArray[index];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        byte[] result = new byte[end - start];
        for (int i = start; i < end; i++) {
            result[i - start] = byteArray[i];
        }
        return new AsciiCharSequence(result);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(byteArray.length);
        for (byte b : byteArray) {
            result.append((char) b);
        }
        return result.toString();
    }
}
