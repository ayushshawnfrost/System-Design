// Concrete Product: BudgetSteakKnife
public class BudgetSteakKnife extends Knife {
    @Override
    public void sharpen() {
        System.out.println("Sharpening Budget Steak Knife");
    }

    @Override
    public void polish() {
        System.out.println("Polishing Budget Steak Knife");
    }

    @Override
    public void pack() {
        System.out.println("Packing Budget Steak Knife");
    }
}
