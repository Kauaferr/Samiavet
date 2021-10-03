package fazendo2;

import javax.faces.bean.ManagedBean;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@ManagedBean(name="categoria")
@Entity
@Table(name="Categorias")

public class CATEGORIAS {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;

private String nome;

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getNome() {
	return nome;
}

public void setNome(String nome) {
	this.nome = nome;
}

public CATEGORIAS() {
	
}
public CATEGORIAS(String nome) {
	this.nome = nome;
}

}
