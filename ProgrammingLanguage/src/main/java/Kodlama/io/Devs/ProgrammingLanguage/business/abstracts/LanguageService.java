package Kodlama.io.Devs.ProgrammingLanguage.business.abstracts;

import java.util.List;

import Kodlama.io.Devs.ProgrammingLanguage.entities.concretes.Language;

public interface LanguageService {
	List<Language> getAll();

	Language getById(int id) throws Exception;

	void add(Language language) throws Exception;

	void update(int id, String name) throws Exception;

	void delete(int id) throws Exception;
}
