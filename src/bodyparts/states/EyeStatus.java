package bodyparts.states;

public enum EyeStatus {

    OPEN("open"),
    CLOSED("closed");

    private final String status;
    EyeStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return this.status;
    }
}
