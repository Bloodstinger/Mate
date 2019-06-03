package lecture.zero.match;

public class MatchApp {
    public static void main(String[] args) {

        try {
            System.out.println(
                    resultMatchScore(
                            Integer.parseInt(args[0]),
                            Integer.parseInt(args[1]),
                            Integer.parseInt(args[2]),
                            Integer.parseInt(args[3])));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Arguments must be 4 integers.[score_1] [score_2] [bid_1] [bid_2]");
        }
    }
    private static int resultMatchScore(int firstResult, int secondResult, int firstBid, int secondBid) {
        return (firstResult == firstBid && secondResult == secondBid) ? 2 :
                (firstResult < secondResult && firstBid < secondBid)
                        || (firstResult > firstBid && firstBid > secondBid)
                        || (firstResult == secondResult && firstBid == secondBid) ? 1 : 0;
    }
}