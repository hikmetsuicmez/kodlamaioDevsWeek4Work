package Kodlama.io.Devs.ProgrammingLanguage.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlama.io.Devs.ProgrammingLanguage.business.abstracts.LanguageService;
import Kodlama.io.Devs.ProgrammingLanguage.dataAccess.abstracts.LanguageRepository;
import Kodlama.io.Devs.ProgrammingLanguage.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService {
	LanguageRepository languageRepository;

	@Autowired
	public LanguageManager(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}

	@Override
	public List<Language> getAll() {

		return languageRepository.getAll();
	}

	@Override
	public Language getById(int id) throws Exception {

		return languageRepository.getById(id);
	}

	@Override
	public void add(Language language) throws Exception {
		if (language.getName().isEmpty()) {
			throw new Exception("Programming language name cannot be empty.");
		}

		for (Language lang : getAll()) {
			if (lang.getName().equals(language.getName())) {
				throw new Exception("There is a programming language with the same name.");
			}
		}
		languageRepository.add(language);

	}

	@Override
	public void update(int id, String name) throws Exception {
		for (Language lang : getAll()) {
			if (lang.getId() == id) {
				languageRepository.update(id, name);
			}
		}
	}

	@Override
	public void delete(int id) throws Exception {
		for (Language lang : getAll()) {
			if (lang.getId() == id) {
				languageRepository.delete(id);
			}
		}
	}
}
