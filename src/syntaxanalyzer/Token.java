package syntaxanalyzer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Token {
    public String AUTO = "<AUTO>";
    public String NEW = "<NEW>";
    public String EOF = "<EOF>";
    public String TRUE = "<TRUE>";
    public String FALSE = "<FALSE>";
    public String BREAK = "<BREAK>";
    public String BOOL = "<BOOL>";
    public String CASE = "<CASE>";
    public String CHAR = "<CHAR>";
    public String CONST = "<CONST>";
    public String CONTINUE = "<CONTINUE>";
    public String DEFAULT = "<DEFAULT>";
    public String DO = "<DO>";
    public String DOUBLE = "<DOUBLE>";
    public String ELSE = "<ELSE>";
    public String ENUM = "<ENUM>";
    public String EXTERN = "<EXTERN>";
    public String FLOAT = "<FLOAT>";
    public String FOR = "<FOR>";
    public String GOTO = "<GOTO>";
    public String IF = "<IF>";
    public String INT = "<INT>";
    public String LONG = "<LONG>";
    public String REGISTER = "<REGISTER>";
    public String RETURN = "<RETURN>";
    public String SHORT = "<SHORT>";
    public String SIGNED = "<SIGNED>";
    public String SIZEOF = "<SIZEOF>";
    public String SIZE = "<SIZE>";
    public String STATIC = "<STATIC>";
    public String STRUCT = "<STRUCT>";
    public String SWITCH = "<SWITCH>";
    public String TYPEDEF = "<TYPEDEF>";
    public String UNION = "<UNION>";
    public String UNSIGNED = "<UNSIGNED>";
    public String VOID = "<VOID>";
    public String VOLATILE = "<VOLATILE>";
    public String WHILE = "<WHILE>";
    public String ID = "<ID>";
    public String INTEGRAL_LITERAL = "<INTEGRAL_LITERAL>";
    public String BOOL_LITERAL = "<BOOL_LITERAL>";
    public String FLOAT_LITERAL = "<FLOAT_LITERAL>";
    public String STRING_LITERAL = "<STRING_LITERAL>";
    public String CHAR_LITERAL = "<CHAR_LITERAL>";
    public String LEFT_CURLY_B = "<LEFT_CURLY_B>";
    public String RIGHT_CURLY_B = "<RIGHT_CURLY_B>";
    public String LEFT_SQUARE_B = "<LEFT_SQUARE_B>";
    public String RIGHT_SQUARE_B = "<RIGHT_SQUARE_B>";
    public String LEFT_ROUND_B = "<LEFT_ROUND_B>";
    public String RIGHT_ROUND_B = "<RIGHT_ROUND_B>";
    public String COMMA = "<COMMA>";
    public String SEMICOLON = "<SEMICOLON>";
    public String DOT = "<DOT>";
    public String NOT = "<NOT>";
    public String ASSIGN_OPERATOR = "<ASSIGN_OPERATOR>";
    public String PREPROCESSOR = "<PREPROCESSOR>";
    public String BACKWARD_SLASH = "<BACKWARD_SLASH>";
    public String MINUS = "<MINUS>";
    public String PLUS = "<PLUS>";
    public String ASTERICK = "<ASTERICK>";
    public String DIVIDE = "<DIVIDE>";
    public String MOD = "<MOD>";
    public String LESSTHAN = "<LESSTHAN>";
    public String GREATERTHAN = "<GREATERTHAN>";
    public String LESS_EQ = "<LESS_EQ>";
    public String GREAT_EQ = "<GREAT_EQ>";
    public String EQUAL = "<EQUAL>";
    public String NOT_EQUAL = "<NOT_EQUAL>";
    public String AND = "<AND>";
    public String OR = "<OR>";
    public String BITWISE_AND = "<BITWISE_AND>";
    public String BITWISE_OR = "<BITWISE_OR>";
    public String BITWISE_XOR = "<BITWISE_XOR>";
    public String LEFT_SHIFT = "<LEFT_SHIFT>";
    public String RIGHT_SHIFT = "<RIGHT_SHIFT>";
    public String BITWISE_NOT = "<BITWISE_NOT>";
    public String MULTI_COMMENT = "<MULTI_COMMENT>";
    public String SINGLE_COMMENT = "<SINGLE_COMMENT>";
    public String value;
    public String tokenName;

    public Token() {
        value = "";
        tokenName = "";
    }

    public Queue<Token> readTokens(String fileName) throws IOException {
        Queue<Token> queue = new LinkedList<Token>();;
        File file = new File(fileName);
        if (!file.exists()) {
            file.createNewFile();
        }
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line = "";
        while ((line = br.readLine()) != null) {
            String readToken[] = line.split(":");
            Token token = new Token();
            token.tokenName = readToken[0];
            token.value = readToken[1];
            System.out.println(token.tokenName + " " + token.value);
            queue.add(token);
        }
        br.close();
        return queue;
    }
}
