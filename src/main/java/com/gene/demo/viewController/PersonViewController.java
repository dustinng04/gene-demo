package com.gene.demo.viewController;

import com.gene.demo.model.Person;
import com.gene.demo.model.Relationship;
import com.gene.demo.model.Relative;
import com.gene.demo.model.SearchCase;
import com.gene.demo.service.PersonService;
import com.gene.demo.service.RelationshipService;
import com.gene.demo.service.RelativeService;
import com.gene.demo.service.SearchCaseService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDate;
import java.util.*;

@Controller
@RequestMapping("/person")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class PersonViewController {
    PersonService personService;
    RelationshipService relationshipService;
    SearchCaseService searchCaseService;
    RelativeService relativeService;

    @GetMapping("/info")
    public String infoPerson(Model model) {
//        List<Relationship> relationships = relationshipService.getAllRelationships();
//        model.addAttribute("relationships", relationships);
        return "PersonInfo";
    }

    @PostMapping("/info")
    public String submitPersonInfo(@ModelAttribute("person") Person person, HttpSession session) {
        // Save the person data to the session
        session.setAttribute("person", person);
        return "redirect:/person/search"; // Redirect to the next page
    }

    @GetMapping("/search")
    public String searchPerson(Model model, HttpSession session) {
        List<Relationship> relationships = relationshipService.getAllRelationships();

        Map<String, List<String>> relationshipMap = new HashMap<>();

        for (Relationship relationship : relationships) {
            String relationshipType = relationship.getRelationshipType();
            String description = relationship.getDescription();

            // Check if the relationshipType key is already present in the map
            if (relationshipMap.containsKey(relationshipType)) {
                relationshipMap.get(relationshipType).add(description);
            } else {
                List<String> descriptionList = new ArrayList<>();
                descriptionList.add(description);
                relationshipMap.put(relationshipType, descriptionList);
            }
        }

        model.addAttribute("relationships", relationshipMap);

        model.addAttribute("searchPerson", new Person());
        log.info(relationshipMap.toString());
        Person person = (Person) session.getAttribute("person");
        if (person == null) {
            return "redirect:/person/info"; // Redirect back to info page if session expired
        }

        log.info(person.getAddress());
        return "PersonSearch";
    }

    @PostMapping("/search")
    public String submitPersonSearch(@ModelAttribute("searchPerson") Person searchPerson,
                                     @RequestParam("relationshipType") String relationshipType,
                                     @RequestParam("description") String description,
                                     HttpSession session) {
        // Retrieve the person info from session
        Person person = (Person) session.getAttribute("person");
        log.info("Search person: " + searchPerson);
        if (person != null) {
            // Save person and search person to the database
            personService.createPerson(person);
            personService.createPerson(searchPerson);
            // Save the new searchCase

            SearchCase searchCase = new SearchCase();
            searchCase.setPersonId(searchPerson.getPersonId());
            searchCase.setReportedBy(person.getPersonId());
            searchCase.setDateReported(new Date());
            searchCase.setSearchStatus("NO");
            searchCase.setAdditionalInfo(person.getAdditionalNotes());
            searchCaseService.addSearchCase(searchCase);

            // Save the relative to database
            Relationship relationship = relationshipService.findRelationshipBySelection(relationshipType, description);
            Relative relative = new Relative(0, person.getPersonId(), relationship.getId());
            relativeService.addRelative(relative);
            session.removeAttribute("person");
            return "redirect:/success"; // Redirect to success or another page
        } else {
            return "redirect:/person/info"; // Redirect back to info page if session expired
        }
    }
}
