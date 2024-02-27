package bodyparts;

import enums.Direction;
import humans.Human;
import interfaces.Dirtiable;

public class Body {
    public Arm leftArm;
    public Arm rightArm;
    public Leg leftLeg;
    public Leg rightLeg;
    public Head head;
    public Heart heart;

    public Body() {
        this.leftArm = new Arm();
        this.rightArm = new Arm();
        this.leftLeg = new Leg();
        this.rightLeg = new Leg();
        this.head = new Head();
        this.heart = new Heart();
    }

    public void increaseLegDirtiness(int level) {
        leftLeg.foot.beFilthy(level);
        rightLeg.foot.beFilthy(level);
        leftLeg.adjustDirtiness(level);
        rightLeg.adjustDirtiness(level);
    }

    public void decreaseLegDirtiness(int level) {
        leftLeg.decreaseDirtiness(level);
        rightLeg.decreaseDirtiness(level);
        leftLeg.foot.decreaseDirtiness(level);
        rightLeg.foot.decreaseDirtiness(level);
    }
    public void increaseLegWetness(int level) {
        leftLeg.increaseWetness(level);
        rightLeg.increaseWetness(level);
        leftLeg.foot.increaseWetness(level);
        rightLeg.foot.increaseWetness(level);
    }

    public void decreaseLegWetness(int level) {
        leftLeg.decreaseWetness(level);
        rightLeg.decreaseWetness(level);
        leftLeg.foot.decreaseWetness(level);
        rightLeg.foot.decreaseWetness(level);
    }

    public static class Arm extends Body {
        public Arm() {
        }
        public String toString() {
            return "arm";
        }
        protected int liftHeight;
        protected int bendDegree;
        {
            liftHeight = 0;
            bendDegree = 145;}
        public int getLiftHeight() {
            return liftHeight;
        }
        public void setLiftHeight(int newHeight) {
            this.liftHeight = newHeight;
        }
        public int getBendDegree() {
            return bendDegree;
        }

        public void setBendDegree(int degree) {
            this.bendDegree = degree;
        }

    }

    public static class Head extends Body {
        public Eye leftEye;
        public Eye rightEye;
        public Tongue tongue;
        public Teeth teeth;
        public Head() {
            this.leftEye = new Eye();
            this.rightEye = new Eye();
            this.tongue = new Tongue();
            this.teeth = new Teeth();
        }
        protected int degree; {
            degree = 0;
        }


        @Override
        public String toString() {
            return "head";
        }
        public int getDegree(){
            return degree;
        }
        public void setDegree(int newDegree){
            this.degree = newDegree;
        }

        public void turnHead(Direction direction) {
            switch (direction) {
                case RIGHT -> {
                    int newDegree = 70;
                    this.setDegree(newDegree);
                }
                case LEFT -> {
                    int newDegree = -70;
                    this.setDegree(newDegree);
                }

                case FORWARD ->{
                    int newDegree = 0;
                    this.setDegree(newDegree);
                }
            }
        }
        public void openEyes(Human human) {
            leftEye.open();
            rightEye.open();
            System.out.printf("%s's eyes flew open again.", human.getName());
        }

        public void closeEyes(Human human) {
            leftEye.close();
            rightEye.close();
            System.out.printf("%s's eyes closed.", human.getName());
        }
        public static class Eye extends Head {

            private int sightLevel = 100;
            public Eye() {
            }

            @Override
            public String toString() {
                return "eyes";
            }

            public String getDescription() {
                return "bulging";
            }
            public void increaseSightLevel(int level) {
                sightLevel += level;
            }
            public void decreaseSightLevel(int level) {
                sightLevel -=level;
            }

            public void open() {
                this.increaseSightLevel(100);
            }

            public void close() {
                this.decreaseSightLevel(100);
            }

        }

        public static class Tongue extends Head {
            public Tongue() {
            }

            @Override
            public String toString() {
                return "tongue";
            }

            public void bleed(Body bodyPart) {
                System.out.printf("His %s was bleeding from the sudden, involuntary bite he had given it.", bodyPart.toString());
            }
        }

        public static class Teeth extends Head {
            public Teeth() {
            }
            @Override
            public String toString() {
                return "teeth";
            }

            public String getDescription() {
                return "clamped unfeelingly";
            }
        }
    }
    public static class Heart extends Body {
        private int heartRate;

        public Heart() {
            this.heartRate = 70;
        }
        @Override
        public String toString() {
            return "heart";
        }
        public void increaseHeartRate(int rateIncrease) {
            this.heartRate += rateIncrease;
        }
        public void decreaseHeartRate(int rateDecrease) {
            this.heartRate -= rateDecrease;
        }
        public void leapUp(String human) {
            increaseHeartRate(10);
            System.out.printf("%s's %s leaped up in his throat like a crazy jack-in-the-box.", human, this);
        }
    }
    public static class Leg extends Body implements Dirtiable {

        public Feet foot;
        public Leg() {
            this.foot = new Feet();
        }

        @Override
        public String toString() {
            return "legs";
        }
        protected int liftHeight;
        protected int bendDegree;
        {
            liftHeight = 0;
            bendDegree = 30;}
        public int getLiftHeight() {
            return liftHeight;
        }
        public void setLiftHeight(int newHeight) {
            this.liftHeight = newHeight;
        }
        public int getBendDegree() {
            return bendDegree;
        }

        public void setBendDegree(int degree) {
            this.bendDegree = degree;
        }

        private int dirtinessLevel;

        public void adjustDirtiness(int level) {
            dirtinessLevel += level;
            System.out.printf("Dirtiness level adjusted: %d%n", dirtinessLevel);
        }

        public void decreaseDirtiness(int level) {
            dirtinessLevel -= level;
            System.out.printf("Dirtiness level decreased: %d%n", dirtinessLevel);
        }
        private int wetnessLevel;
        public void increaseWetness(int level) {
            wetnessLevel += level;
            System.out.printf("Wetness level increased: %d%n", wetnessLevel);
        }
        public void decreaseWetness(int level) {
            wetnessLevel -= level;
            System.out.printf("Wetness level decreased: %d%n", wetnessLevel);
        }

        public static class Feet extends Leg {

            public Feet(){
            }
            @Override
            public String toString() {
                return "feet";
            }

            public void beFilthy(int level) {
                adjustDirtiness(level);
                System.out.printf("His feet were filthy with dirt and pine needles..%n");
            }
        }
    }

}
