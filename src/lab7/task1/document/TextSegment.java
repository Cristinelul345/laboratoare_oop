package lab7.task1.document;

import lab7.task1.DocumentVisitor;

public abstract class TextSegment {
    private String content;

    public TextSegment(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public abstract void accept(DocumentVisitor visitor);
}
