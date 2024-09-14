// Concrete Creator: BudgetKnifeStore
public class BudgetKnifeStore extends KnifeStore {
    @Override
    protected Knife createKnife(String type) {
        if (type.equals("chefs")) {
            return new BudgetChefsKnife();
        } else if (type.equals("steak")) {
            return new BudgetSteakKnife();
        } else {
            return null;
        }
    }
}
