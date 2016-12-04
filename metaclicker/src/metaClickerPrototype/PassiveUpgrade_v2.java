package metaClickerPrototype;

public class PassiveUpgrade_v2 extends Upgrade_v2 {

	private double clicksPerSecond;
	
	public PassiveUpgrade_v2() {
		this.clicksPerSecond = 1.0;
		this.isActive = false;
		this.isPassive = true;
	}
	
	public void setCPS(double CPS) {
		this.clicksPerSecond = CPS;
	}
	
	public double getCPS() {
		return this.clicksPerSecond;
	}
}
