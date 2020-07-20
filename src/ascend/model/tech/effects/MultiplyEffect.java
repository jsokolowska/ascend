package ascend.model.tech.effects;

import ascend.model.CivParameters;

import java.util.HashMap;
import java.util.Map;

public class MultiplyEffect extends Effect {
    private HashMap<String,Integer> multipliers;

    public MultiplyEffect(HashMap<String, Integer> multipliers){
        this.multipliers = multipliers;
    }
    @Override
    public void takeEffect(CivParameters parameters) {
        HashMap<String, Integer> civState = parameters.getCivState();
        for (Map.Entry<String, Integer> entry : multipliers.entrySet()) {
            String key = entry.getKey();
            int multiplier = entry.getValue();
            if (civState.containsKey(key)){
                int oldVal = civState.get(key);
                int newVal = oldVal * multiplier;
                civState.replace(key, newVal);
            }
        }
    }
}
