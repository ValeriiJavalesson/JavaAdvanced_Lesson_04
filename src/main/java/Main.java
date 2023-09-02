import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class Main {
    public static Logger LOG = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        DOMConfigurator.configure("log4j.xml");

        int value = 0;

        for (int i = 0; i<20; i++){
            value = VoltMeter.getValue();
            int cs = (value < 180) ? 0 : (180 <= value && value < 200) ? 1 : (200 <= value && value < 220) ? 2 : (value >= 220 && value<230) ? 3 : 4;
            switch (cs) {
                case 0 -> LOG.error("VoltMeter Value is less then " + 180 + " volts");
                case 1 -> LOG.warn("VoltMeter Value is: " + value + " volts");
                case 2 -> LOG.info("VoltMeter Value is: " + value + " volts");
                case 3 -> LOG.debug("VoltMeter Value is: " + value + " volts");
            }
        }
    }
}
