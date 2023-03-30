public class Main {
    public static void main(String[] args) {
        Walec walec = new Walec(5, 3);
        System.out.println("Promien podstawy: " + walec.getBaseRadius());
        System.out.println("Wysokosc: " + walec.getHeight());
        System.out.println("Polew powierzchni podstawy: " + walec.getBaseSurfaceArea());
        System.out.println("Polew powierzchni bocznej: " + walec.getSideSurfaceArea());
        System.out.println("Polew powierzchni calkowitej: " + walec.getTotalSurfaceArea());
        System.out.println("Objetosc: " + walec.getVolume());

        System.out.println();

        Walec walec2 = new Walec();
        walec2.setBaseRadius(2);
        walec2.setHeight(2);
        System.out.println("Polew powierzchni podstawy: " + walec2.getBaseSurfaceArea());
        System.out.println("Polew powierzchni bocznej: " + walec2.getSideSurfaceArea());
        System.out.println("Polew powierzchni calkowitej: " + walec2.getTotalSurfaceArea());
        System.out.println("Objetosc: " + walec2.getVolume());
    }
}