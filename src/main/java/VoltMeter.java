public class VoltMeter {
    public static int getValue() {
        int value = 0;
        while (value < 150)
            value = (int) (230 * Math.random());
        return value;
    }
}
