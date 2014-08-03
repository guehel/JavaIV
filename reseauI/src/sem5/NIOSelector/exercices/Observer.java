package sem5.NIOSelector.exercices;

public interface Observer {

	public void update(String message);

	public void update(byte[] message);

}
