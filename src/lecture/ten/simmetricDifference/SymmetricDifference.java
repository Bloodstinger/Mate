package lecture.ten.simmetricDifference;

import java.util.HashSet;
import java.util.Set;

public class SymmetricDifference {
    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        Set commonness = new HashSet();
        Set difference = new HashSet();
        commonness.addAll(set1);
        commonness.retainAll(set2);
        difference.addAll(set1);
        difference.addAll(set2);
        difference.removeAll(commonness);
        return difference;
    }
}
