package lab7.task1;

import lab7.task1.document.*;

public class MarkdownVisitor implements DocumentVisitor {
    private StringBuilder document = new StringBuilder();

    @Override
    public void visit(PlainTextSegment plainTextSegment) {
        document.append(plainTextSegment.getContent());
    }

    @Override
    public void visit(ItalicTextSegment italicTextSegment) {
        document.append("_").append(italicTextSegment.getContent()).append("_");
    }

    @Override
    public void visit(BoldTextSegment boldTextSegment) {
        document.append("**").append(boldTextSegment.getContent()).append("**");
    }

    @Override
    public void visit(UrlSegment urlSegment) {
        document.append("[").append(urlSegment.getContent()).append("](").append(urlSegment.getUrl()).append(")");
    }

    public StringBuilder getDocument() {
        return document;
    }
}
