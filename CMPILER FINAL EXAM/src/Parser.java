import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class Parser {

    public static String parseInputArray(ArrayList<String> input) {
        String outputString = "";
        boolean noProductionRule = false;

        ParseTable parseTable = new ParseTable();
        HashMap<String, Rule> hashTable = parseTable.getParseTable();


        Stack<String> stackRules = new Stack<String>();
        Stack<String> stackInput = new Stack<String>();
        stackRules.push("$");
        stackRules.push("start");
        stackInput.push("$");


        for (int i = (input.size() - 1); i >= 0; i--) {
            stackInput.push(input.get(i));
        }

        while (!stackInput.isEmpty() && !noProductionRule) {

            if (stackRules.peek().equals(stackInput.peek())) {
                stackInput.pop();
                stackRules.pop();
            }
            else if (stackRules.peek().equals("epsilon")) {
                stackRules.pop();
            }

            else {
                String nextRule = stackRules.peek();
                String findInputRule = stackInput.peek();
                String newRule = "";


                if (hashTable.containsKey(nextRule)) {

                    if (hashTable.get(nextRule).getProductionRules().containsKey(findInputRule)) {
                        newRule = hashTable.get(nextRule).getProductionRules().get(findInputRule);
                        stackRules.pop();
                    }


                    if (!newRule.equals("")) {
                        String[] newrule = newRule.split(" ");


                        for (int i = (newrule.length - 1); i >= 0; i--) {


                            stackRules.push(newrule[i]);
                        }

                    } else {
                        noProductionRule = true;

                    }
                } else {
                    noProductionRule = true;

                }


            }

        }


        if (stackInput.isEmpty() && stackRules.isEmpty()) {
            outputString = "ACCEPT";
        } else {
            outputString = "REJECT";
        }


        return outputString;
    }
}

