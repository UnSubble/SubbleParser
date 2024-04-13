package com.unsubble.xml.dom;

import com.unsubble.generics.Node;

public class XMLNode<E> implements Node {

    private XMLNode<E> nextNode;
    private boolean hasChild;

    public XMLNode() {
    }

    @Override
    public String getKey() {
        return "";
    }

    @Override
    public Object getValue() {
        return null;
    }

    protected void setNextNode(XMLNode<E> node) {
        nextNode = node;
    }

    protected void setHasChild(boolean hasChild) {
        this.hasChild = hasChild;
    }

    public XMLNode<E> next() {
        return nextNode;
    }

    public boolean hasChild() {
        return hasChild;
    }
}
