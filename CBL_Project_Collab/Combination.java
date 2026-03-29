public class Combination {
    private Item parent1;
    private Item parent2;
    private Item child;
    private boolean discovered = false;

    public Combination(Item comp1, Item comp2, Item resultItem) {
        this.parent1 = comp1;
        this.parent2 = comp2;
        this.child = resultItem;
    }

    public Item getParent1(){
        return this.parent1;
    }

    public Item getParent2(){
        return this.parent2;
    }

    public Item getChild(){
        return this.child;
    }

    public boolean isDiscovered() {
        return this.discovered;
    }

    public void setDiscovered(boolean d){
        this.discovered = d; 
    }

}
