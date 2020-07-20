package ascend.model;

interface Inventable {
    Change invent();
    boolean areInventConditionsSatisfied();
    boolean areAutoInventConditionsSatisfied();
}
