package lecture.five.pair;

import java.util.Objects;

public final class Pair<T, K> {
    private final T first;
    private final K second;

    private Pair(T first, K second) {
        this.first = first;
        this.second = second;
    }

    public static <T, K> Pair<T, K> of(T firstValue, K secondValue) {
        return new Pair<>(firstValue, secondValue);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(getFirst(), pair.getFirst()) &&
                Objects.equals(getSecond(), pair.getSecond());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirst(), getSecond());
    }

    public T getFirst() {
        return this.first;
    }

    public K getSecond() {
        return this.second;
    }


}
