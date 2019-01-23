package ngoy.e2e.app;

import static ngoy.core.Provider.useValue;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ngoy.Ngoy;

@Controller
@RequestMapping("/*")
public class Main implements InitializingBean {

	private Ngoy<AppComponent> ngoy;

	@Autowired
	private AppState appState;

	@Autowired
	private BeanInjector beanInjector;

	@Override
	public void afterPropertiesSet() throws Exception {
		createApp();
	}

	private void createApp() {
		ngoy = Ngoy.app(AppComponent.class)
				.injectors(beanInjector)
				.providers(useValue(AppStateProvider.class, () -> appState))
				.build();
	}

	@GetMapping()
	public void home(HttpServletResponse response) throws Exception {
		// re-create while developing to have changes picked-up
//		createApp();
		ngoy.render(response.getOutputStream());
	}
}