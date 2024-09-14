// Concrete Creator: QualityKnifeStore
public class QualityKnifeStore extends KnifeStore {
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
