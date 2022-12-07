package Kodlama.io.Devs.ProgrammingLanguage.webApi.controlles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Kodlama.io.Devs.ProgrammingLanguage.business.abstracts.LanguageService;
import Kodlama.io.Devs.ProgrammingLanguage.entities.concretes.Language;

@RestController // annotation
@RequestMapping("api/languages")
public class LanguagesController {
	private LanguageService languageService;

	@Autowired
	public LanguagesController(LanguageService languageService) {
		this.languageService = languageService;
	}

	@GetMapping("/getall")
	public List<Language> getAll() {
		return languageService.getAll();
	}

	@GetMapping("/getid")
	public Language getById(int id) throws Exception {
		return languageService.getById(id);
	}

	@GetMapping("/add")
	public void add(Language language) throws Exception {
		languageService.add(language);
	}

	@GetMapping("/update")
	public void update(int id, String name) throws Exception {
		languageService.update(id, name);
	}

	@GetMapping("/delete")
	public void delete(int id) throws Exception {
		languageService.delete(id);
	}

}
