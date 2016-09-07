package modello;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Paziente {
	private int idPaziente;
	private String nome;
	private String cognome;
	private Calendar dataNas = new GregorianCalendar();
	private String cf;
	private String email;
	private String password;
	private int idCitta;
	private String indirizzo;
	private String sesso;

	public String getSesso() {
		return sesso;
	}

	public void setSesso(String sesso) {
		this.sesso = sesso;
	}

	public Paziente(String nome, String cognome, String dataNas, String cf, String email, String password, int idCitta,
			String indirizzo, String sesso) {
		super();
		this.idPaziente = 0; //
		this.nome = nome;
		this.cognome = cognome;
		this.dataNas.clear();

		if (dataNas.length() != 0) {
			String dataProvv[] = dataNas.split("-");
			this.dataNas.set(Integer.parseInt(dataProvv[0]), Integer.parseInt(dataProvv[1]) - 1,
					Integer.parseInt(dataProvv[2]));
		} else {
			this.dataNas = null;
		}

		this.cf = cf;
		this.email = email;
		this.password = password;
		this.idCitta = idCitta;
		this.indirizzo = indirizzo;
		this.sesso = sesso;
	}

	public Paziente(int idPaziente, String nome, String cognome, Calendar dataNas, String cf, String email,
			String password, int idCitta, String indirizzo, String sesso) {
		super();
		this.idPaziente = idPaziente;
		this.nome = nome;
		this.cognome = cognome;
		this.dataNas = dataNas;
		this.cf = cf;
		this.email = email;
		this.password = password;
		this.idCitta = idCitta;
		this.indirizzo = indirizzo;
		this.sesso = sesso;
	}

	public int getIdPaziente() {
		return idPaziente;
	}

	public void setIdPaziente(int idpaziente) {
		this.idPaziente = idpaziente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Calendar getDataNas() {
		return dataNas;
	}

	public String getDataForm() {
		return formattaData();
	}

	public String formatDataNasForBS() {
		String strdate = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		if (dataNas != null) {
			strdate = sdf.format(dataNas.getTime());
		}
		return strdate;
	}

	public void setDataNas(Calendar datanas) {
		this.dataNas = datanas;
	}

	public void setDataNas(Date dataNas) {
		this.dataNas.setTime(dataNas);
	}

	public void setDataNas(String dataNas) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			this.dataNas.setTime(sdf.parse(dataNas));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getCf() {
		return cf;
	}

	public void setCf(String cf) {
		this.cf = cf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getIdCitta() {
		return idCitta;
	}

	public void setIdCitta(int idcitta) {
		this.idCitta = idcitta;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	private String formattaData() {
		String strdate = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");

		if (dataNas != null) {
			strdate = sdf.format(dataNas.getTime());
		}
		return strdate;
	}

	@Override
	public String toString() {
		return "Paziente [idPaziente=" + idPaziente + ", nome=" + nome + ", cognome=" + cognome + ", cf=" + cf
				+ ", email=" + email + ", password=" + password + ", idCitta=" + idCitta + ", indirizzo=" + indirizzo
				+ ", data di nascita=" + formattaData() + "]";
	}

	public Paziente() {
		super();
		// TODO Auto-generated constructor stub
	}

}
