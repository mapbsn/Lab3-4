package bodyparts;

import bodyparts.states.EyeStatus;

public class Eyes extends BodyPart {

    public Eyes() {
    }

    @Override
    public String toString() {
        return "eyes";
    }

    public String getDescription() {
        return "bulging";
    }

    protected EyeStatus status = EyeStatus.OPEN;

    public void setEyeStatus(EyeStatus status) {
        this.status = status;
    }

    public void open(String human, String bodyPart) {
        setEyeStatus(EyeStatus.OPEN);
        System.out.printf("%s's %s flew %s again.", human, bodyPart, status);
    }

    public void close(String human, String bodyPart) {
        setEyeStatus(EyeStatus.CLOSED);
        System.out.printf("%s's %s %s.", human, bodyPart, status);
    }

}
