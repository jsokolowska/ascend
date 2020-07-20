package ascend.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Singleton class holding various parameters pertaining to the current state of the game
 */
public class CivParameters {
    private HashMap<String,Integer> civState; //wealth, happiness, health, army, defense
    private int creativity;
    private int understanding;
    private Set<String> inventedTechnologies;
    private int population;
    private int [] understandingUpdates; //better implement delayed updates queue

    private static CivParameters instance = null;
    private CivParameters(){
        inventedTechnologies = new HashSet<>();
        civState = new HashMap<>();
        civState.put("wealth", 0);
        civState.put("health", 0);
        civState.put("happiness", 0);
        civState.put("army", 0);
        civState.put("defense", 0);
        creativity = 1;
        understanding = 1;

    }
    public static CivParameters getCivParameters(){
        if (instance == null){
            instance = new CivParameters();
            return instance;
        }
        return null;
    }
    public void loadParameters(HashMap<String, Integer> civState, Set<String> inventedTechnologies, int creativeness, int understanding){
        this.creativity = creativeness;
        this.understanding = understanding;
        this.inventedTechnologies = inventedTechnologies;
        this.civState = civState;
    }

    public HashMap<String, Integer> getCivState() {
        return civState;
    }

    public static int getPopulation(){
        return instance.population;
    }
    public static void payCosts(int understandingCost, int creativityCost){
        instance.understanding -= understandingCost;
        instance.creativity -= creativityCost; //* tech_nr; todo implement globally visible tech nr
    }
    public static void addDelayedUnderstanding(int understanding, int delay){
        instance.understandingUpdates[delay]+=understanding;
    }
    //loading from file

}
