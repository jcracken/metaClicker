package metaClickerPrototype;

public class Upgrades {
	
	public String upgradeName;
	public int upgradeCost;
	public String upgradeDescription;
	public boolean upgradePurchased;
	public boolean isActive;
	public boolean isPassive;
	
	public Upgrades () {
		upgradeName = "DEFAULT UPGRADE";
		upgradeCost = 10;
		upgradeDescription = "DEFAULT UPGRADE DESCRIPTION";
		upgradePurchased = false;
	}
	
	public void setName(String name) {
		upgradeName = name;
	}
	
	public void setCost(int cost) {
		upgradeCost = cost;
	}
	
	public void setDesc(String description) {
		upgradeDescription = description;
	}
	
	public void purchase() {
		upgradePurchased  = true;
	}

}
