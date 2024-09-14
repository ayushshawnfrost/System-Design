// Abstract Product
abstract class Knife {
    public abstract void sharpen();
    public abstract void polish();
    public abstract void pack();
}

// Concrete Product: BudgetChefsKnife
class BudgetChefsKnife extends Knife {
    @Override
    public void sharpen() {
        System.out.println("Sharpening Budget Chef's Knife");
    }

    @Override
    public void polish() {
        System.out.println("Polishing Budget Chef's Knife");
    }

    @Override
    public void pack() {
        System.out.println("Packing Budget Chef's Knife");
    }
}

// Concrete Product: BudgetSteakKnife
class BudgetSteakKnife extends Knife {
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

// Abstract Creator
abstract class KnifeStore {
    public Knife orderKnife(String type) {
        Knife knife = createKnife(type);
        knife.sharpen();
        knife.polish();
        knife.pack();
        return knife;
    }

    protected abstract Knife createKnife(String type);
}

// Concrete Creator: BudgetKnifeStore
class BudgetKnifeStore extends KnifeStore {
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

// Main class to demonstrate the pattern
public class Main {
    public static void main(String[] args) {
        KnifeStore store = new BudgetKnifeStore();
        Knife chefsKnife = store.orderKnife("chefs");
        Knife steakKnife = store.orderKnife("steak");
    }
}




// Concrete Product: QualityChefsKnife
class QualityChefsKnife extends Knife {
    @Override
    public void sharpen() {
        System.out.println("Sharpening Quality Chef's Knife");
    }

    @Override
    public void polish() {
        System.out.println("Polishing Quality Chef's Knife");
    }

    @Override
    public void pack() {
        System.out.println("Packing Quality Chef's Knife");
    }
}

// Concrete Product: QualitySteakKnife
class QualitySteakKnife extends Knife {
    @Override
    public void sharpen() {
        System.out.println("Sharpening Quality Steak Knife");
    }

    @Override
    public void polish() {
        System.out.println("Polishing Quality Steak Knife");
    }

    @Override
    public void pack() {
        System.out.println("Packing Quality Steak Knife");
    }
}

// Concrete Creator: QualityKnifeStore
class QualityKnifeStore extends KnifeStore {
    @Override
    protected Knife createKnife(String type) {
        if (type.equals("chefs")) {
            return new QualityChefsKnife();
        } else if (type.equals("steak")) {
            return new QualitySteakKnife();
        } else {
            return null;
        }
    }
}

// Main class to demonstrate the pattern
public class Main {
    public static void main(String[] args) {
        KnifeStore budgetStore = new BudgetKnifeStore();
        KnifeStore qualityStore = new QualityKnifeStore();

        Knife budgetChefsKnife = budgetStore.orderKnife("chefs");
        Knife qualitySteakKnife = qualityStore.orderKnife("steak");
    }
}
