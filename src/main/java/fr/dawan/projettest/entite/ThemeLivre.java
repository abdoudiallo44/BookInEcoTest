package fr.dawan.projettest.entite;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="theme")
public class ThemeLivre extends DbObject {
	private String theme;

	public ThemeLivre(String theme) {
		super();
		this.theme = theme;
	}

	public ThemeLivre() {
		super();
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	@Override
	public String toString() {
		return super.toString() + " ThemeLivre [theme=" + theme + "]";
	}


}
