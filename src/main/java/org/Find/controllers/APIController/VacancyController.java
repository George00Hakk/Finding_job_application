package org.Find.controllers.APIController;

import org.Find.Entity.Vacancy;
import org.Find.services.VacancyFinder;
import org.Find.services.VacancyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/vacancies")
public class VacancyController {
    private final VacancyFinder vacancyService;

    public VacancyController(/*VacancyFinder vacancyService*/) {
        this.vacancyService = new VacancyService();
    }

    //Get метод для получения 5 вакансий по должности
    @RequestMapping ("/finder")
    public ResponseEntity<List<Vacancy>> read (
            @RequestParam(value = "jobTitle", required = true, defaultValue = "Java junior")
            String jobTitle)
    {
        List<Vacancy> vacancies = vacancyService.get5ByVacancyName(jobTitle);
        return new ResponseEntity<>(vacancies, HttpStatus.OK);
    }




    @PostMapping(value = "/add")
    public ResponseEntity<?> create(@RequestBody Vacancy vacancy) {
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
