package prueba.entidad;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "prueba")
public class PruebaEntity {
 
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)

  private int id;
  
 /* En mysql hace auto incremental el campo
  *  ALTER TABLE prueba MODIFY COLUMN id INT NOT NULL AUTO_INCREMENT;
  */
 
  public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

private String columna1;
  
  private String columna2;

public String getColumna1() {
	return columna1;
}

public void setColumna1(String columna1) {
	this.columna1 = columna1;
}

public String getColumna2() {
	return columna2;
}

public void setColumna2(String columna2) {
	this.columna2 = columna2;
}
   

 
}


