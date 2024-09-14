// Main class to demonstrate the pattern
public class Main {
    public static void main(String[] args) {
        KnifeStore budgetStore = new BudgetKnifeStore();
        KnifeStore qualityStore = new QualityKnifeStore();

        Knife budgetChefsKnife = budgetStore.orderKnife("chefs");
        Knife qualitySteakKnife = qualityStore.orderKnife("steak");
    }
}
