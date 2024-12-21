package org.Find.services;

import org.Find.Entity.Vacancy;

import java.util.ArrayList;
import java.util.List;
//TODO этот клас должен обеспечивать выдачу вакансий порциями  ---- например по 5 шт --.
/*логика: человек в боте написал "Java junior"  -- получил 5 вакансий.
    прочел их --нажал кнопку "еще" или снова написал "Java junior"--должен получить еще порцию
    ....прочел их --нажал кнопку "еще" или снова написал "Java junior"--должен получить еще порцию --(другие пять не те что первый раз выдали)
    ....прочел их --нажал кнопку "еще" или снова написал "Java junior"--должен получить еще порцию из 5
    ... и так далее
 */
//наверное ему нужен какой то контейнер типа Map<"Java junior", Stack<Vacation>>;

public class VacancyService implements VacancyFinder {
    @Override
    public List<Vacancy> get10ByVacancyName(String jobTitle) {
        //TODO
        return null;
    }

    @Override
    public List<Vacancy> get5ByVacancyName(String jobTitle) {
        //Может уже есть в контексте стэк из 5 шт Vacancy для возврата? -- тогда их вернем, извлекая из стэка.
        //нету  GO to DB ---SELECT * WHERE name= {jobTitle}  ---- положи их в свой стэк --- верни польщователю первые 5 из него.
        //TODO пока вернет заглушку 5 тестовых вакансий
        List<Vacancy> vacancies = new ArrayList<>();
        vacancies.add(new Vacancy(jobTitle, 250000, "ASTON"," String URL", "String requirements", "String conditions"));
        vacancies.add(new Vacancy(jobTitle, 450000, "NETFLIX"," String URL", "быть собой", "String conditions"));
        vacancies.add(new Vacancy(jobTitle, 150000, "SBER"," String URL", "знать все", "String conditions"));
        vacancies.add(new Vacancy(jobTitle, 130000, "Yandex"," String URL", "быть собой", "String conditions"));
        vacancies.add(new Vacancy(jobTitle, 25000, "GOOGLE"," String URL", "быть собой", "String conditions"));

        return vacancies;
    }

    @Override
    public List<Vacancy> get10ByVacancyNameAndSalary(String jobTitle, String salary) {
        //TODO
        return null;
    }

    @Override
    public List<Vacancy> get5ByVacancyNameAndSalary() {
        //TODO
        return null;
    }
}
