package fr.dawan.projettest.entite;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="theme")
public class ThemeLivre {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idTheme;
	
	private String theme;

	public ThemeLivre(long idTheme, String theme) {
		super();
		this.idTheme = idTheme;
		this.theme = theme;
	}

	public ThemeLivre() {
		super();
	}

	
	public long getIdTheme() {
		return idTheme;
	}

	public void setIdTheme(long idTheme) {
		this.idTheme = idTheme;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	@Override
	public String toString() {
		return "ThemeLivre [idTheme=" + idTheme + ", theme=" + theme + "]";
	}

}
