package ascend.model;


public abstract class Tech implements Inventable {
    protected final boolean autoInventable;
    protected final String name;
    protected final int id;
    protected static int idCounter=0;

    public Tech (String name, Boolean autoInventable){
        this.id = idCounter++;
        this.name = name;
        this.autoInventable = autoInventable;
    }

    public String getName(){
        return name;
    }
    public int getId(){
        return  id;
    }
}