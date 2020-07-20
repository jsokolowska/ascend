package ascend.model.tech.conditions;

import ascend.model.CivParameters;

import java.util.HashMap;
import java.util.List;

public class PopulationConditions extends InventConditions{
    private int threshold;

    public PopulationConditions(int threshold){
        this.threshold = threshold;
    }

    @Override
    public boolean areSatisfied() {
        int population = CivParameters.getPopulation();
        return population>threshold;
    }
}
