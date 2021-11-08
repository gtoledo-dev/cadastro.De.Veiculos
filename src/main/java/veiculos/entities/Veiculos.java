package veiculos.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GeneratorType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;

@Entity
public class Veiculos implements Serializable{
	private static final long serialVersionUID = 1L;

	private static final Shape JsonFormat = null;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String veiculo;
	private String marca;
	private Integer ano;
	private String descricao;
	private String vendido;
	
	@JsonFormat(shape = com.fasterxml.jackson.annotation.JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant created;
	
	@JsonFormat(shape = com.fasterxml.jackson.annotation.JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant updated;
	
	public Veiculos() {
		
	}

	public Veiculos(Long id, String veiculo, String marca, Integer ano, String descricao, String vendido,
			Instant created, Instant updated) {
		super();
		this.id = id;
		this.veiculo = veiculo;
		this.marca = marca;
		this.ano = ano;
		this.descricao = descricao;
		this.vendido = vendido;
		this.created = created;
		this.updated = updated;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(String veiculo) {
		this.veiculo = veiculo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getVendido() {
		return vendido;
	}

	public void setVendido(String vendido) {
		this.vendido = vendido;
	}

	public Instant getCreated() {
		return created;
	}

	public void setCreated(Instant created) {
		this.created = created;
	}

	public Instant getUpdated() {
		return updated;
	}

	public void setUpdated(Instant updated) {
		this.updated = updated;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Veiculos other = (Veiculos) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
