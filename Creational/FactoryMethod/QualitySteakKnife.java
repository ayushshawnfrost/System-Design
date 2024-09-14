// Concrete Product: QualitySteakKnife
public class QualitySteakKnife extends Knife {
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
