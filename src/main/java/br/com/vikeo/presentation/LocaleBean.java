package br.com.vikeo.presentation;

import java.io.Serializable;
import java.util.Locale;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.http.HttpServletRequest;

@Named
@SessionScoped
public class LocaleBean implements Serializable {
	
	private static final long serialVersionUID = 4327702069772794681L;

	@Inject
	private HttpServletRequest request;

	private Locale locale;
	
	private String language;

	@PostConstruct
	public void init() {
		locale = request.getLocale();
		setLanguage(locale.toString());
	}
	
	public Locale getLocale() {
		return locale;
	}
	
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
		setLocale(language);
	}
	
	private void setLocale(String localeCode) {
		switch (localeCode) {
		case "en":
		case "en_US":
			locale = Locale.ENGLISH;
			language = "en_US";
			break;
		case "pt":
			locale = Locale.forLanguageTag("pt");
			language = "pt";
			break;
		case "pt_BR":
			locale = new Locale("pt", "BR");
			language = "pt_BR";
			break;
		case "pt_PT":
			locale = new Locale("pt", "PT");
			language = "pt_PT";
			break;
		case "es":
		case "es_ES":
			locale = new Locale("es", "ES");
			language = "es_ES";
			break;
		default:
			break;
		}
		FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
		System.out.println("Locale set to " + locale.getLanguage());
	}

}
