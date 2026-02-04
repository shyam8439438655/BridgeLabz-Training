interface LightAction {
    void activate();
}

public class SmartLight {
    public static void main(String[] args) {

        LightAction motion = () -> System.out.println("Motion detected → Light ON");
        LightAction time   = () -> System.out.println("Night time → Dim light ON");
        LightAction voice  = () -> System.out.println("Voice command → Party lights ON");

        motion.activate();
        time.activate();
        voice.activate();
    }
}
