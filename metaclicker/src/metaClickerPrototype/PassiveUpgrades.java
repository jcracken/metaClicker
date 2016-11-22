package metaClickerPrototype;

public class PassiveUpgrades extends Upgrades{
	
	public double clicksPerSecond;
	
	public PassiveUpgrades() {
		clicksPerSecond = 1.0;
		isActive = false;
		isPassive = true;
	}
	
	public void setCPS(double CPS) {
		clicksPerSecond = CPS;
	}

}
