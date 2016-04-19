package prueba.entidad;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "WPRUEBA")

public class PruebaEntity {
 
  @Id
  private int id;
 

  private String campo1;
  private String campo2;

	public String getCampo1() {
		return campo1;
	}
	
	public void setCampo1(String campo1) {
		this.campo1 = campo1;
	}
	   
	 
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCampo2() {
		return campo2;
	}

	public void setCampo2(String campo2) {
		this.campo2 = campo2;
	}
 
}