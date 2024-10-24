package lab7.task1;

import lab7.task1.document.*;

public class DokuwikiVisitor implements DocumentVisitor {
    private StringBuilder document = new StringBuilder();

    @Override
    public void visit(PlainTextSegment plainTextSegment) {
        document.append(plainTextSegment.getContent());
    }

    @Override
    public void visit(ItalicTextSegment italicTextSegment) {
        document.append("//").append(italicTextSegment.getContent()).append("//");
    }

    @Override
    public void visit(BoldTextSegment boldTextSegment) {
        document.append("**").append(boldTextSegment.getContent()).append("**");
    }

    @Override
    public void visit(UrlSegment urlSegment) {
        document.append("[[").append(urlSegment.getUrl()).append("|").append(urlSegment.getContent()).append("]]");
    }

    public StringBuilder getDocument() {
        return document;
    }
}
