package lab7.task1;

import lab7.task1.document.PlainTextSegment;
import lab7.task1.document.ItalicTextSegment;
import lab7.task1.document.BoldTextSegment;
import lab7.task1.document.UrlSegment;

public interface DocumentVisitor {
    void visit(PlainTextSegment plainTextSegment);
    void visit(ItalicTextSegment italicTextSegment);
    void visit(BoldTextSegment boldTextSegment);
    void visit(UrlSegment urlSegment);
}
