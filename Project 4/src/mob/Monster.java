package mob;

import java.util.Random;

public class Monster extends Participant{
	
	public Monster() {
		super();
	}

	@Override
	public void setHealth() {
		int number;
		Random rand = new Random();
		number = rand.nextInt(50) + 100;
		health = Math.round(number);
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		
	}

}
