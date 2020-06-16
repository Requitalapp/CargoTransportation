package CargoTransportation.Route;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RouteController {
    private RouteService service;

    @Autowired
    public RouteController(RouteService service) {
        this.service = service;
    }

    @GetMapping("/route")
    public String showAll(Model model) {
        model.addAttribute("data", service.findAll());
        return "route";
    }

    @GetMapping("/routeAdd")
    public String add(Model model) {
        model.addAttribute("route", new Route());
        return "routeAdd";
    }

    @PostMapping("/route")
    public String save(@ModelAttribute("route") Route route) {
        service.save(route);
        return "redirect:/route";
    }

    @GetMapping("/routeEdit")
    public String edit(@RequestParam("id") int id, Model model) {
        try {
            model.addAttribute("route", service.findById(id));
        } catch (Exception e) {
            return "redirect:/error";
        }
        return "routeAdd";
    }

    @GetMapping("/routeDelete")
    public String delete(@RequestParam("id") int id, Model model) {
        model.addAttribute("delete", service.delete(id));
        return "route";
    }
}
