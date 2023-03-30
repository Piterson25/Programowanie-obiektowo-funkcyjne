//import java.lang.Math;

public class Walec {
    public Walec(float newBaseRadius, float newHeight) {
        this.baseRadius = newBaseRadius;
        this.height = newHeight;
    }

    public Walec() {}

    public void setBaseRadius(float newBaseRadius) {
        this.baseRadius = newBaseRadius;
    }

    public void setHeight(float newHeight) {
        this.height = newHeight;
    }

    public float getBaseRadius() {
        return this.baseRadius;
    }

    public float getHeight() {
        return this.height;
    }

    public float getBaseSurfaceArea() {
        return (float) (Math.PI * Math.pow(this.baseRadius, 2));
    }

    public float getSideSurfaceArea() {
        return (float) (2 * Math.PI * this.baseRadius * this.height);
    }

    public float getTotalSurfaceArea() {
        return 2 * this.getBaseSurfaceArea() + this.getSideSurfaceArea();
    }

    public float getVolume() {
        return this.getBaseSurfaceArea() * this.height;
    }

    private float baseRadius;
    private float height;
}
