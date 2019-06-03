package lecture.three.analyzer;

public class TooLongTextAnalyzer implements TextAnalyzer {
    private int maxCommentLength;

    public TooLongTextAnalyzer(int maxCommentLength) {
        this.maxCommentLength = maxCommentLength;
    }

    @Override
    public Label processText(String text) {
        if (text.length() > maxCommentLength) {
            return Label.TOO_LONG;
        }
        return Label.OK;
    }
}