package xml;

import generics.Node;
import generics.ParseIterator;
import xml.dom.Element;
import xml.dom.XMLNode;

import java.nio.charset.Charset;

public class XMLDocumentImpl implements XMLDocument {
    private final String version;
    private final String encodingCharset;
    private Element root;
    private XMLNode rootAsNode;

    public XMLDocumentImpl(String version, String encodingCharset) {
        this.version = version;
        this.encodingCharset = encodingCharset;
    }

    public XMLDocumentImpl(String version) {
        this (version, Charset.defaultCharset().name());
    }

    public Element getRoot() {
        return root;
    }

    public XMLNode getRootAsNode() {
        return rootAsNode;
    }

    public ParseIterator parseIterator() {
        return new XMLDocumentIterator();
    }

    private class XMLDocumentIterator implements ParseIterator {

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Node next() {
            return null;
        }
    }
}
