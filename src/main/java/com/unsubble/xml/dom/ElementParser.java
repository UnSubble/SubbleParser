package com.unsubble.xml.dom;

import com.unsubble.Logger;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public final class ElementParser {

    private enum Token {
        TAG_OPENED, TAG_CLOSED, END_TAG, ATTRIBUTE_NAME, SPACE, NONE
    }

    private ElementParser() {
    }

    public static XMLNode<Element> parse(Deque<Byte> repo, byte[] buffer) {
        Queue<Token> tokens = tokenize(repo, buffer);
        Logger.getLogger().info("S: " + tokens);
        return null;
    }

    private static Queue<Token> tokenize(Deque<Byte> repo, byte[] buffer) {
        Queue<Token> tokens = new ArrayDeque<>();
        Token token = Token.TAG_CLOSED;
        boolean isStr = false;
        boolean stringEnv = false;
        boolean isEscapeChar = false;
        for (byte b : repo) {
            if (!isEscapeChar) {
                if (token == Token.TAG_OPENED)
                    stringEnv = true;
                if (token == Token.TAG_CLOSED)
                    stringEnv = false;
                if (stringEnv && (b == '"' || b == '\''))
                    isStr = !isStr;
            }
            if (!isStr && !isEscapeChar) {
                token = switch (b) {
                    case '<' -> Token.TAG_OPENED;
                    case '>' -> Token.TAG_CLOSED;
                    case '=' -> Token.ATTRIBUTE_NAME;
                    case '/' -> Token.END_TAG;
                    case ' ' -> Token.SPACE;
                    default -> Token.NONE;
                };
            } else
                token = Token.NONE;
            isEscapeChar = b == '\\';
            tokens.add(token);
        }
        for (byte b : buffer) {

        }
        return tokens;
    }
}
