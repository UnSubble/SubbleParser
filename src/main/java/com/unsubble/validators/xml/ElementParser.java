package com.unsubble.validators.xml;

import com.unsubble.Logger;
import com.unsubble.xml.dom.Element;
import com.unsubble.xml.dom.XMLNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public final class ElementParser {

    private static class TokenController {
        Token token;
        boolean isStr;
        boolean stringEnv;
        boolean isEscapeChar;
    }

    private enum Token {
        TAG_OPENED, TAG_CLOSED, END_TAG, ATTRIBUTE_NAME, SPACE, NONE
    }

    private ElementParser() {
    }

    public static XMLNode<Element> parse(Deque<Byte> repo, byte[] buffer) {
        Queue<Token> tokens = tokenize(repo, buffer);
        Logger.getLogger().info("S: {}", tokens);
        return null;
    }

    private static Queue<Token> tokenize(Deque<Byte> repo, byte[] buffer) {
        Queue<Token> tokens = new ArrayDeque<>();
        TokenController controller = new TokenController();
        controller.token = Token.TAG_CLOSED;
        controller.isStr = false;
        controller.stringEnv = false;
        controller.isEscapeChar = false;
        for (byte b : repo) {
            if (b != -1) {
                changeTokenByByte(b, controller);
                tokens.add(controller.token);
            }
        }
        for (byte b : buffer) {
            if (b != -1) {
                changeTokenByByte(b, controller);
                tokens.add(controller.token);
            }
        }
        return tokens;
    }

    private static void changeTokenByByte(byte b, TokenController controller) {
        if (!controller.isEscapeChar) {
            if (controller.token == Token.TAG_OPENED)
                controller.stringEnv = true;
            if (controller.token == Token.TAG_CLOSED)
                controller.stringEnv = false;
            if (controller.stringEnv && (b == '"' || b == '\''))
                controller.isStr = !controller.isStr;
        }
        if (!controller.isStr && !controller.isEscapeChar) {
            controller.token = switch (b) {
                case '<' -> Token.TAG_OPENED;
                case '>' -> Token.TAG_CLOSED;
                case '=' -> Token.ATTRIBUTE_NAME;
                case '/' -> Token.END_TAG;
                case ' ' -> Token.SPACE;
                default -> Token.NONE;
            };
        } else
            controller.token = Token.NONE;
        controller.isEscapeChar = b == '\\';
    }
}
