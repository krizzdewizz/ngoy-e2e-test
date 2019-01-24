package ngoy.e2e.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import ngoy.core.Component;
import ngoy.core.Inject;
import ngoy.core.OnInit;

@Component(selector = "", templateUrl = "app.component.html")
@Controller
public class AppComponent implements OnInit {
	public final String title = "e2e-test-app";

	@Inject
	public AppStateProvider appStateProvider;

	public AppState appState;

	@Override
	public void ngOnInit() {
		appState = appStateProvider.getAppState();
	}

	@PostMapping("/setmessage")
	public String setMessage(String message) {
		appStateProvider.getAppState()
				.setMessage(message);
		return "redirect:/";
	}
}
