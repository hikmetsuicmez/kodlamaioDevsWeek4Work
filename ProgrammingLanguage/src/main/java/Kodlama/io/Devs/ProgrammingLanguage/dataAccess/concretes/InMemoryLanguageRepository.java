package Kodlama.io.Devs.ProgrammingLanguage.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import Kodlama.io.Devs.ProgrammingLanguage.dataAccess.abstracts.LanguageRepository;
import Kodlama.io.Devs.ProgrammingLanguage.entities.concretes.Language;

@Repository
public class InMemoryLanguageRepository implements LanguageRepository {

	List<Language> languages;

	public InMemoryLanguageRepository() {
		languages = new ArrayList<Language>();
		languages.add(new Language(1, "Java"));
		languages.add(new Language(2, "Python"));
		languages.add(new Language(3, "C#"));
		languages.add(new Language(4, "C++"));
	}

	@Override
	public List<Language> getAll() {

		return languages;

	}

	@Override
	public Language getById(int id) throws Exception {
		for (Language language : languages) {
			if (language.getId() == id) {
				return language;
			}
		}
		throw new Exception("No registered id found");
	}

	@Override
	public void add(Language language) throws Exception {
		languages.add(language);
	}

	@Override
	public void update(int id, String name) throws Exception {
		Language setLanguage = getById(id);
		setLanguage.setName(name);

	}

	@Override
	public void delete(int id) throws Exception {
		Language setLanguage = getById(id);
		languages.remove(setLanguage);

	}

}
