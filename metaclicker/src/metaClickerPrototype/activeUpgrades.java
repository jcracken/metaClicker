package metaClickerPrototype;

public class activeUpgrades extends Upgrades {
	
	public double clickMultiplier;
	
	public activeUpgrades() {
		clickMultiplier = 1.0;
		isActive = true;
		isPassive = false;
	}
	
	public void setMult(double mult) {
		clickMultiplier = mult;
	}

}
