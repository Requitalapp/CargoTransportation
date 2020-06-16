package CargoTransportation.Manage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ManageController {
    private ManageService service;

    @Autowired
    public ManageController(ManageService service) {
        this.service = service;
    }

    @GetMapping("/manage")
    public String showAll(Model model) {
        model.addAttribute("data", service.findAll());
        return "manage";
    }

    @GetMapping("/manageAdd")
    public String add(Model model) {
        model.addAttribute("manage", new Manage());
        return "manageAdd";
    }

    @PostMapping("/manage")
    public String save(@ModelAttribute("manage") Manage manage) {
        service.save(manage);
        return "redirect:/manage";
    }

    @GetMapping("/manageEdit")
    public String edit(@RequestParam("id") int id, Model model) {
        try {
            model.addAttribute("manage", service.findById(id));
        } catch (Exception e) {
            return "redirect:/error";
        }
        return "manageAdd";
    }

    @GetMapping("/manageDelete")
    public String delete(@RequestParam("id") int id, Model model) {
        model.addAttribute("delete", service.delete(id));
        return "manage";
    }
}
