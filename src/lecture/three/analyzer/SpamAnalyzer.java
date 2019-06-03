package lecture.three.analyzer;

public class SpamAnalyzer extends KeywordAnalyzer implements TextAnalyzer {
    private String[] spamKeywords;

    public SpamAnalyzer(String[] spamKeywords) {
        this.spamKeywords = spamKeywords;
    }

    @Override
    protected Label getLabel() {
        return Label.SPAM;
    }

    @Override
    protected String[] getKeywords() {
        return spamKeywords;
    }
}