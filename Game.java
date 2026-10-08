// Grupa 13: Petar Kazic i Pavle Drobac

class Player {

	private String name;
	private int x;
	private int y;
	private int width;
	private int height;
	private int health;

	public Player(String name, int x, int y, int width, int height, int health) {
		setName(name);
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		setHealth(health);
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		String sredjenoIme = name.trim();
		if (!sredjenoIme.equals("")) {
			this.name = sredjenoIme;
		} else {
			System.out.println("Ime igraca ne smije biti prazno.");
		}
	}

	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}


	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}


	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}


	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		if (health >= 0 && health <= 100) {
			this.health = health;
		} else {
			System.out.println("Health mora biti izmedju 0 i 100.");
		}
	}
}

class Enemy {

	private String type;
	private int x;
	private int y;
	private int width;
	private int height;
	private int damage;

	public Enemy(String type, int x, int y, int width, int height, int damage) {
		setType(type);
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		setDamage(damage);
	}


	public String getType() {
		return type;
	}
	public void setType(String type) {
		String sredjeniTip = type.trim();
		if (!sredjeniTip.equals("")) {
			this.type = sredjeniTip;
		} else {
			System.out.println("Tip neprijatelja ne smije biti prazan.");
		}
	}


	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}


	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}


	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}


	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		if (damage >= 0 && damage <= 100) {
			this.damage = damage;
		} else {
			System.out.println("Damage mora biti izmedju 0 i 100.");
		}
	}
}

public class Game {

	public static boolean checkCollision(Player p, Enemy e) {
		boolean preklapanjeX = p.getX() < e.getX() + e.getWidth()
				&& p.getX() + p.getWidth() > e.getX();

		boolean preklapanjeY = p.getY() < e.getY() + e.getHeight()
				&& p.getY() + p.getHeight() > e.getY();

		return preklapanjeX && preklapanjeY;
	}


	public static void decreaseHealth(Player p, Enemy e) {
		int novoZdravlje = p.getHealth() - e.getDamage();

		if (novoZdravlje < 0) {
			novoZdravlje = 0;
		}

		p.setHealth(novoZdravlje);
	}

	public static void main(String[] args) {
	

		Player player = new Player("Player1", 10, 5, 32, 32, 85);

		Enemy goblin = new Enemy("Goblin", 12, 5, 16, 16, 20);
		Enemy orc = new Enemy("     Orc", 100, 100, 20, 20, 35);

		System.out.println("Zdravlje igraca prije: " + player.getHealth());

		if (checkCollision(player, goblin)) {
			System.out.println("Sudar sa neprijateljem: " + goblin.getType());
			decreaseHealth(player, goblin);
		} else {
			System.out.println("Nema sudara sa neprijateljem: " + goblin.getType());
		}

		if (checkCollision(player, orc)) {
			System.out.println("Sudar sa neprijateljem: " + orc.getType());
			decreaseHealth(player, orc);
		} else {
			System.out.println("Nema sudara sa neprijateljem: " + orc.getType());
		}

		System.out.println("Zdravlje igraca poslije: " + player.getHealth());
	}
}