package dl;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Azpiekitaldiak database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="Azpiekitaldiak.findAll", query="SELECT a FROM Azpiekitaldiak a"),
	@NamedQuery(name="Azpiekitaldiak.findMenpekoak", query="SELECT a FROM Azpiekitaldiak a WHERE a.ekitaldiak = :ekitaldiak")
})
public class Azpiekitaldiak implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idAzpiekitaldiak;

	private String bueltatzekoLekua;

	private String sortzailea;

	//bi-directional many-to-one association to Ekitaldiak
	@ManyToOne
	@JoinColumn(name="Ekitaldiak_idEkitaldiak")
	private Ekitaldiak ekitaldiak;

	//bi-directional many-to-one association to Geldialdiak
	@OneToMany(mappedBy="azpiekitaldiak")
	private List<Geldialdiak> geldialdiaks;

	public Azpiekitaldiak() {
	}

	public int getIdAzpiekitaldiak() {
		return this.idAzpiekitaldiak;
	}

	public void setIdAzpiekitaldiak(int idAzpiekitaldiak) {
		this.idAzpiekitaldiak = idAzpiekitaldiak;
	}

	public String getBueltatzekoLekua() {
		return this.bueltatzekoLekua;
	}

	public void setBueltatzekoLekua(String bueltatzekoLekua) {
		this.bueltatzekoLekua = bueltatzekoLekua;
	}

	public String getSortzailea() {
		return this.sortzailea;
	}

	public void setSortzailea(String sortzailea) {
		this.sortzailea = sortzailea;
	}

	public Ekitaldiak getEkitaldiak() {
		return this.ekitaldiak;
	}

	public void setEkitaldiak(Ekitaldiak ekitaldiak) {
		this.ekitaldiak = ekitaldiak;
	}

	public List<Geldialdiak> getGeldialdiaks() {
		return this.geldialdiaks;
	}

	public void setGeldialdiaks(List<Geldialdiak> geldialdiaks) {
		this.geldialdiaks = geldialdiaks;
	}

	public Geldialdiak addGeldialdiak(Geldialdiak geldialdiak) {
		getGeldialdiaks().add(geldialdiak);
		geldialdiak.setAzpiekitaldiak(this);

		return geldialdiak;
	}

	public Geldialdiak removeGeldialdiak(Geldialdiak geldialdiak) {
		getGeldialdiaks().remove(geldialdiak);
		geldialdiak.setAzpiekitaldiak(null);

		return geldialdiak;
	}

}