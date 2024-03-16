package object;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Plato")
public class Plato {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private int price;
	private String type;
	
	public Plato() {}
	public Plato(String name, int price, String type)
	{
		this.name = name;
		this.price = price;
		this.type = type;
	}
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getPrice() {
		return price;
	}
	public String getType() {
		return type;
	}
}
