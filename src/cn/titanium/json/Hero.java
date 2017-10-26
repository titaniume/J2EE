package cn.titanium.json;
public class Hero {
 
    private String name;
    private int hp;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getHp() {
        return hp;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }
    
    
    public Hero() {
		super();
	}
	public Hero(String name, int hp) {
		super();
		this.name = name;
		this.hp = hp;
	}
	@Override
    public String toString() {
        return "Hero [name=" + name + ", hp=" + hp + "]";
    }
}