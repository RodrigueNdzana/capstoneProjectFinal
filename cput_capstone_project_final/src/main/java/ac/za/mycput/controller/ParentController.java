package ac.za.mycput.controller;

import ac.za.mycput.entity.ParentForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@CrossOrigin(origins = "http://localhost:8080")
public class ParentController {

    @GetMapping("/parentForm")
    public String showParentForm(Model model) {
        model.addAttribute("parentForm", new ParentForm());
        return "parentForm";
    }

    @PostMapping("/parentResult")
    public String showParentResult(@ModelAttribute("parentForm") ParentForm parentForm, Model model) {
        String searchedValue = parentForm.getStudentName();
        model.addAttribute("searchedValue", searchedValue);
        return "parentResult";
    }
}
