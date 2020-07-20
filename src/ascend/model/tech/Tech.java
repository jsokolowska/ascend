package ascend.model.tech;

import ascend.model.CivParameters;
import ascend.model.tech.conditions.InventConditions;
import ascend.model.tech.effects.Effect;
import ascend.model.tech.risks.Risk;
import ascend.model.util.ReinventError;

import java.util.Random;

public class Tech {
   private final Effect effect;
   private final Risk risk;
   private final InventConditions inventConditions;
   private final InventConditions autoInventConditions;
   private boolean invented;
   private final Cost cost;

   public Tech(Effect effect, Risk risk, InventConditions inventConditions, InventConditions autoInventConditions, int understandingCost, int creativityCostMult, Cost cost){
        this.autoInventConditions = autoInventConditions;
        this.inventConditions = inventConditions;
        this.risk = risk;
        this.effect = effect;
       this.cost = cost;
       this.invented = false;
    }
    public Tech(Effect effect, Risk risk, InventConditions inventConditions,
                InventConditions autoInventConditions, boolean invented, int understandingCost, int creativityCostMult, Cost cost){
        this.autoInventConditions = autoInventConditions;
        this.inventConditions = inventConditions;
        this.risk = risk;
        this.effect = effect;
        this.invented = invented;
        this.cost = cost;
    }

    public void takeEffect (CivParameters parameters){
       this.effect.takeEffect(parameters);
    }

    public boolean invent () throws ReinventError {
       /*todo - currently only manual invention incurs understanding and creativity costs,
          but both have failure rates (possibly change that?)*/

        boolean success =  inventTech(inventConditions);
        if(success){
            cost.update();
        }
        return success;
    }

    private boolean inventTech(InventConditions inventConditions) {
        if (invented){
            throw new ReinventError();
        }else{
            if(inventConditions.areSatisfied()){
                float threshold = risk.calculateRisk();
                Random rand = new Random();
                if(rand.nextFloat() > threshold){
                    invented = true;
                }
            }
        }
        return invented;
    }

    public boolean autoInvent() throws ReinventError{
        return inventTech(autoInventConditions);
    }
}