package items;

public class Shower extends Item {
    public Shower(String name) {
        super(name);
    }

    public static class Handle extends Shower {

        public Handle(String name) {
            super(name);
        }

        public String getDescription() {
            return "the shower handle on";
        }
    }

    public static class Water extends Shower {
        public Water(String name) {
            super(name);
        }

        public String getDescription() {
            return "so hot it was nearly scalding, unmindful.";
        }
    }
}
