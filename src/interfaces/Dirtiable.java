package interfaces;

public interface Dirtiable {

    void adjustDirtiness(int level);
    void decreaseDirtiness(int level);
}
