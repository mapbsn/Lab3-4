package bodyparts;

import bodyparts.states.BodyPartState;
import enums.Direction;

public class Head extends BodyPart {
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
            case RIGHTWAY -> {
                int newDegree = 70;
                this.setDegree(newDegree);
            }
            case LEFTWAY -> {
                int newDegree = -70;
                this.setDegree(newDegree);
            }

            case FORWARD ->{
                int newDegree = 0;
                this.setDegree(newDegree);
            }
        }
    }

    public static class Tongue extends Head {
        public Tongue() {
        }

        @Override
        public String toString() {
            return "tongue";
        }

        public void bleed(BodyPart bodyPart) {
            setBodyPartState(BodyPartState.INJURED);
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
