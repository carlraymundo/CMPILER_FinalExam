import java.util.HashMap;

public class Rule  {

    private HashMap<String, String> productionRules;

    public Rule () {

        this.productionRules = new HashMap<String, String>();
    }

    public void addRules(String terminal, String rule) {

        this.productionRules.put(terminal, rule);
    }

    public HashMap<String, String> getProductionRules() {

        return productionRules;
    }
}