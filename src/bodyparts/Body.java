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
    public Head.Eye leftEye;
    public Head.Eye rightEye;
    public Head.Tongue tongue;
    public Head.Teeth teeth;
    public Leg.Feet leftFoot;
    public Leg.Feet rightFoot;

    public Body() {
        this.leftArm = new Arm();
        this.rightArm = new Arm();
        this.leftLeg = new Leg();
        this.rightLeg = new Leg();
        this.head = new Head();
        this.heart = new Heart();
        this.leftEye = new Head.Eye();
        this.rightEye = new Head.Eye();
        this.tongue = new Head.Tongue();
        this.teeth = new Head.Teeth();
        this.leftFoot = new Leg.Feet();
        this.rightFoot = new Leg.Feet();
    }

    public void increaseLegDirtiness(int level) {
        leftFoot.beFilthy(level);
        rightFoot.beFilthy(level);
        leftLeg.adjustDirtiness(level);
        rightLeg.adjustDirtiness(level);
    }

    public void decreaseLegDirtiness(int level) {
        leftLeg.decreaseDirtiness(level);
        rightLeg.decreaseDirtiness(level);
        leftFoot.decreaseDirtiness(level);
        rightFoot.decreaseDirtiness(level);
    }
    public void increaseLegWetness(int level) {
        leftLeg.increaseWetness(level);
        rightLeg.increaseWetness(level);
        rightFoot.increaseWetness(level);
        leftFoot.increaseWetness(level);
    }

    public void decreaseLegWetness(int level) {
        leftLeg.decreaseWetness(level);
        rightLeg.decreaseWetness(level);
        leftFoot.decreaseWetness(level);
        rightFoot.decreaseWetness(level);
    }
    public void closeEyes(Human human) {
        leftEye.close();
        rightEye.close();
        System.out.printf("%s's eyes closed.", human.getName());
    }
    public void openEyes(Human human) {
        leftEye.open();
        rightEye.open();
        System.out.printf("%s's eyes flew open again.", human.getName());
    }

    public static class Arm {
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

    public static class Head {
        public Head() {
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

        public static class Eye {

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

        public static class Tongue {
            public Tongue() {
            }

            @Override
            public String toString() {
                return "tongue";
            }

            public void bleed(String bodyPart) {
                System.out.printf("His %s was bleeding from the sudden, involuntary bite he had given it.", bodyPart);
            }
        }

        public static class Teeth {
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
    public static class Heart {
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
    public static class Leg implements Dirtiable {

        public Leg() {
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
        }

        public void decreaseDirtiness(int level) {
            dirtinessLevel -= level;
        }
        private int wetnessLevel;
        public void increaseWetness(int level) {
            wetnessLevel += level;
        }
        public void decreaseWetness(int level) {
            wetnessLevel -= level;
        }

        public static class Feet implements Dirtiable {
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

            @Override
            public void adjustDirtiness(int level) {

            }

            @Override
            public void decreaseDirtiness(int level) {

            }

            private int wetnessLevel;
            public void increaseWetness(int level) {
                wetnessLevel += level;
            }
            public void decreaseWetness(int level) {
                wetnessLevel -= level;
            }
        }
    }

}
