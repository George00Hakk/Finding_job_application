package org.Find.Entity;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name="vacancy")
public class Vacancy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "vacancyName")
    private String vacancyName;
    @Column(name = "salary")
    private Integer salary;
    @Column(name ="companyName")
    private String companyName;
    @Column(name = "URL")
    private String URL;
    @Column(name = "requirements")
    private String requirements;
    @Column(name = "conditions")
    private String conditions;

    public Vacancy() {
    }

    public Vacancy(String vacancyName, Integer salary, String companyName, String URL, String requirements, String conditions) {
        this.vacancyName = vacancyName;
        this.salary = salary;
        this.companyName = companyName;
        this.URL = URL;
        this.requirements = requirements;
        this.conditions = conditions;
    }

    public long getId() {
        return id;
    }

    public String getVacancyName() {
        return vacancyName;
    }

    public Integer getSalary() {
        return salary;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getURL() {
        return URL;
    }

    public String getRequirements() {
        return requirements;
    }

    public String getConditions() {
        return conditions;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setVacancyName(String vacancyName) {
        this.vacancyName = vacancyName;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vacancy)) return false;
        Vacancy vacancy = (Vacancy) o;
        return id == vacancy.id && Objects.equals(vacancyName, vacancy.vacancyName) &&
                Objects.equals(salary, vacancy.salary) &&
                Objects.equals(companyName, vacancy.companyName) &&
                Objects.equals(URL, vacancy.URL) &&
                Objects.equals(requirements, vacancy.requirements) &&
                Objects.equals(conditions, vacancy.conditions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, vacancyName, salary,
                companyName, URL, requirements, conditions);

    }

    @Override
    public String toString() {
        return "Vacancy{" +
                "id=" + id +
                ", vacancyName='" + vacancyName + '\'' +
                ", salary=" + salary +
                ", companyName='" + companyName + '\'' +
                ", URL='" + URL + '\'' +
                ", requirements='" + requirements + '\'' +
                ", conditions='" + conditions + '\'' +
                '}';
    }
}

