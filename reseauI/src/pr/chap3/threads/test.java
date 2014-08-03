package pr.chap3.threads;

public class test {

	public static void main(String[] args) {
		TraitementSimule trait = new TraitementSimule();
		trait.start();
		for (int i = 0; i < 10; i++){
			System.out.println("SAalut "+ i);
		}

	}

}
