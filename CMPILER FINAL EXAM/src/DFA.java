public class DFA{

    private static final int q0 = 0;
    private static final int expr = 1;
    private static final int threeSymbols = 2; // plus, star, question mark
    private static final int leftParen = 3;
    private static final int rightParen = 4;
    private static final int epsilon = 5;
    private static final int union = 6;
    private static final int error = -1;


    private int state;

    public int dfaTransition(int state, char c)
    {
        switch(state){
            case q0 : switch(c){
                case 'a':
                case 'b':
                case 'c':
                case 'd':
                case 'e':
                case 'f':
                case 'g':
                case 'h':
                case 'i':
                case 'j':
                case 'k':
                case 'l':
                case 'm':
                case 'n':
                case 'o':
                case 'p':
                case 'q':
                case 'r':
                case 's':
                case 't':
                case 'u':
                case 'v':
                case 'w':
                case 'x':
                case 'y':
                case 'z':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                case '0':
                    return expr;
                case '(':
                    return leftParen;
                case ')':
                    return rightParen;
                case '+':
                case '*':
                case '?':
                    return threeSymbols;
                case 'U':
                    return union;
                case 'E':
                    return epsilon;
            }
            case expr: switch(c){
                case 'a':
                case 'b':
                case 'c':
                case 'd':
                case 'e':
                case 'f':
                case 'g':
                case 'h':
                case 'i':
                case 'j':
                case 'k':
                case 'l':
                case 'm':
                case 'n':
                case 'o':
                case 'p':
                case 'q':
                case 'r':
                case 's':
                case 't':
                case 'u':
                case 'v':
                case 'w':
                case 'x':
                case 'y':
                case 'z':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                case '0':
                    return expr;
            }

            default: return error;
        }
    }

    public boolean acceptedState()
    {
        return state == expr || state == threeSymbols || state == leftParen || state == rightParen ||
                state == union || state == epsilon;
    }


    public void processDfa(String input)
    {
        for (int i = 0; i < input.length(); i++){
            char c = input.charAt(i);
            state = dfaTransition(state, c);
        }
    }

    public int getState(){
        return state;
    }

}