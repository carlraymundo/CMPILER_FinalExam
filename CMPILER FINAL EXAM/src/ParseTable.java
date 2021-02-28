import java.util.HashMap;

public class ParseTable {

    HashMap<String, Rule> parseTable;

    public ParseTable() {
        parseTable = new HashMap<String, Rule>();
        parseTable = initializeHashMap();
    }

    private static HashMap<String, Rule> initializeHashMap() {
        HashMap<String, Rule> initParseTable = new HashMap<String, Rule>();


        Rule rules = new Rule();
        String startString = "start";
        rules.addRules("EXPR", "A");
        rules.addRules("LEFTPAREN", "A");
        rules.addRules("EPSILON", "EPSILON C");
        initParseTable.put(startString, rules);

        String aTransition = "A";
        rules = new Rule();
        rules.addRules("EXPR", "B");
        rules.addRules("LEFTPAREN", "LEFTPAREN start RIGHTPAREN D"); // prev: B
        initParseTable.put(aTransition, rules);

        String bTransition = "B";
        rules = new Rule();
        rules.addRules("EXPR", "EXPR D");
        initParseTable.put(bTransition, rules);


        String cTransition = "C";
        rules = new Rule();
        rules.addRules("UNION", "UNION start");
        rules.addRules("RIGHTPAREN", "epsilon");
        rules.addRules("$", "epsilon");
        initParseTable.put(cTransition, rules);

        String dTransition = "D";
        rules = new Rule();
        rules.addRules("THREESYMBOLS", "THREESYMBOLS F");
        rules.addRules("UNION", "C");
        rules.addRules("RIGHTPAREN", "epsilon");
        rules.addRules("$", "epsilon");
        rules.addRules("LEFTPAREN", "F"); //newly added
        initParseTable.put(dTransition, rules);


        String fTransition = "F";
        rules = new Rule();
        rules.addRules("EXPR", "A");
        rules.addRules("UNION", "C");
        rules.addRules("LEFTPAREN", "A");
        rules.addRules("RIGHTPAREN", "epsilon");
        rules.addRules("$", "epsilon");
        initParseTable.put(fTransition, rules);

        return initParseTable;
    }

    public HashMap<String, Rule> getParseTable() {

        return parseTable;
    }
}