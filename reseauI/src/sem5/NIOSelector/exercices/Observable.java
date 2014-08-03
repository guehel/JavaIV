package sem5.NIOSelector.exercices;


public interface Observable {
public void addObserver(Observer observateur);
public void notify(String message);
public void notify(byte [] message);
}
