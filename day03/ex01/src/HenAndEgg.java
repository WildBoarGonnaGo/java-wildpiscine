public class HenAndEgg {
	String whoIs;

	synchronized void egg(boolean isThatAll) throws InterruptedException {
		if (!isThatAll) {
			whoIs = "egg";
			notify();
			return ;
		}
		System.out.println("Egg");
		whoIs = "egg";
		notify();
		while (!whoIs.equals("hen"))
			wait();
	}

	synchronized void hen(boolean isThatAll) throws InterruptedException {
		if (!isThatAll) {
			whoIs = "hen";
			notify();
			return ;
		}
		System.out.println("Hen");
		whoIs = "hen";
		notify();
		while (!whoIs.equals("egg"))
			wait();
	}
}
