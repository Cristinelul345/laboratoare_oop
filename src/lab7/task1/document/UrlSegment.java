package lab7.task1.document;

import lab7.task1.DocumentVisitor;

public class UrlSegment extends TextSegment {
    private String url;

    public UrlSegment(String url, String content) {
        super(content);
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public void accept(DocumentVisitor visitor) {
        visitor.visit(this);
    }
}
