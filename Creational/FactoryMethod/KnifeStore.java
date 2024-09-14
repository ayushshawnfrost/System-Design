// Abstract Creator
public abstract class KnifeStore {
    public Knife orderKnife(String type) {
        Knife knife = createKnife(type);
        if (knife != null) {
            knife.sharpen();
            knife.polish();
            knife.pack();
        }
        return knife;
    }

    protected abstract Knife createKnife(String type);
}
