package metaClickerPrototype;

public class ActiveUpgrade_v2 extends Upgrade_v2{

	private double clickMultiplier;
	
	public ActiveUpgrade_v2() {
		this.clickMultiplier = 1.0;
		this.isActive = true;
		this.isPassive = false;
	}
	
	public void setMult(double mult) {
		this.clickMultiplier = mult;
	}
	
	public double getMult() {
		return this.clickMultiplier;
	}
}
