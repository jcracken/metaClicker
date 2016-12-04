package metaClickerPrototype;

public class Upgrade_v2 {
	
	private String upgradeName;
	private int upgradeCost;
	private String upgradeDescription;
	protected boolean upgradePurchased;
	protected boolean isActive;
	protected boolean isPassive;
	
	public Upgrade_v2() {
		this.upgradeName = "DEFAULT UPGRADE";
		this.upgradeCost = 10;
		this.upgradeDescription = "DEFAULT UPGRADE DESCRIPTION";
		this.upgradePurchased = false;
	}
	
	public void setName(String name) {
		this.upgradeName = name;
	}
	
	public String getName() {
		return this.upgradeName;
	}
	
	public void setCost(int cost) {
		this.upgradeCost = cost;
	}
	
	public int getCost() {
		return this.upgradeCost;
	}
	
	public void setDesc(String description) {
		this.upgradeDescription = description;
	}
	
	public String getDesc() {
		return this.upgradeDescription;
	}
	
	public void purchase() {
		this.upgradePurchased  = true;
	}
}
