package lab7.task1;

import lab7.task1.document.TextSegment;

import java.util.List;

/**
 * Uses visitors to parse documents and provide dokuwiki and markdown outputs.
 */
public class WikiGenerator {

    private final List<TextSegment> textSegments;

    public WikiGenerator(List<TextSegment> textSegments) {
        this.textSegments = textSegments;
    }

    public StringBuilder getDokuWikiDocument() {
        // TODO apply dokuwiki visitor on the text segments
        DokuwikiVisitor visitor = new DokuwikiVisitor();
        for (TextSegment segment : textSegments) {
            segment.accept(visitor);
        }
        return visitor.getDocument();
    }

    public StringBuilder getMarkdownDocument() {
        // TODO apply Markdown visitor on the text segments
        MarkdownVisitor visitor = new MarkdownVisitor();
        for (TextSegment segment : textSegments) {
            segment.accept(visitor);
        }
        return visitor.getDocument();
    }
}