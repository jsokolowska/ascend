package ascend.model.tech;

import ascend.model.CivParameters;

public class Cost {
    public int understandingCost;
    public int creativityCostMult;
    public int addedUnderstanding;
    public int tourDelay;

    public Cost (int understandingCost, int creativityCostMult, int addedUnderstanding, int tourDelay){
        this.understandingCost = understandingCost;
        this.creativityCostMult = creativityCostMult;
        this.addedUnderstanding = addedUnderstanding;
        this.tourDelay = tourDelay;
    }
    public void update (){
        CivParameters.addDelayedUnderstanding(addedUnderstanding, tourDelay);
        CivParameters.payCosts(understandingCost, creativityCostMult);
    }
}
