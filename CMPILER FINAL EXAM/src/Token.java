
public class Token{

    public TokenType tokenType;
    public String lexeme;

    public Token(String word){
        this.tokenType= identifyToken(word);
        this.lexeme = word;
    }

    public TokenType identifyToken(String word){
        DFA dfa = new DFA();

        dfa.processDfa(word);

        if(dfa.acceptedState()){
            switch (dfa.getState()){
                case 1: return TokenType.EXPR;
                case 2: return TokenType.THREESYMBOLS;
                case 3: return TokenType.LEFTPAREN;
                case 4: return TokenType.RIGHTPAREN;
                case 5: return TokenType.EPSILON;
                case 6: return TokenType.UNION;
            }
        }

        return TokenType.ERROR;
    }
}
