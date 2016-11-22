package metaClickerPrototype;

public class passiveUpgrades extends Upgrades{
	
	public double clicksPerSecond;
	
	public passiveUpgrades() {
		clicksPerSecond = 1.0;
		isActive = false;
		isPassive = true;
	}
	
	public void setCPS(double CPS) {
		clicksPerSecond = CPS;
	}

}
