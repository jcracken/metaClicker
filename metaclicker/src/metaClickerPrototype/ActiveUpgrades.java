package metaClickerPrototype;

public class ActiveUpgrades extends Upgrades {
	
	public double clickMultiplier;
	
	public ActiveUpgrades() {
		clickMultiplier = 1.0;
		isActive = true;
		isPassive = false;
	}
	
	public void setMult(double mult) {
		clickMultiplier = mult;
	}

}
