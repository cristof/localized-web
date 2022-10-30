package br.com.vikeo.presentation;

import java.text.MessageFormat;
import java.util.ResourceBundle;

import org.omnifaces.cdi.Startup;
import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@Startup
public class StartupBean {
	
	private static final String BASE_NAME = "locale.messages";
	
	@PostConstruct
	public void init() {
		Messages.setResolver(new Messages.Resolver() {
			
			@Override
			public String getMessage(String message, Object... params) {
				ResourceBundle bundle = ResourceBundle.getBundle(BASE_NAME, Faces.getLocale());
				if (bundle.containsKey(message)) {
					message = bundle.getString(message);
				}
				return params.length > 0 ? MessageFormat.format(message, params) : message;
			}
		});
	}

}
