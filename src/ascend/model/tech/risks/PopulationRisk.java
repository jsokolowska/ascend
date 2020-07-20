package ascend.model.tech.risks;

import ascend.model.CivParameters;

import java.util.Map;
import java.util.TreeMap;

import static java.lang.Integer.min;

public class PopulationRisk extends Risk {
    private TreeMap<Integer, Float> thresholds;

    public PopulationRisk(TreeMap<Integer, Float> thresholds){
        this.thresholds = thresholds;
    }

    public PopulationRisk(int [] ranges, float [] riskValues){
        int len = min(ranges.length, riskValues.length);
        this.thresholds = new TreeMap<>();
        for(int i=0; i<len ; i++){
            this.thresholds.put(ranges[i], riskValues[i]);
        }
    }

    @Override
    public float calculateRisk() {
        int population = CivParameters.getPopulation();
        for (Map.Entry<Integer, Float> entry: this.thresholds.entrySet()){
            int populationThresh = entry.getKey();
            if (population < populationThresh){
                return entry.getValue();
            }
        }
        return 0;
    }
}
