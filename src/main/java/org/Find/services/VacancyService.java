package org.Find.services;

import org.Find.Entity.Vacancy;

import java.util.ArrayList;
import java.util.List;


public class VacancyService implements VacancyFinder {
    @Override
    public List<Vacancy> get10ByVacancyName(String jobTitle) {
        //TODO
        return null;
    }

    @Override
    public List<Vacancy> get5ByVacancyName(String jobTitle) {
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
