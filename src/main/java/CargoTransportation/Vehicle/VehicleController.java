package CargoTransportation.Vehicle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class VehicleController {
    private VehicleService service;

    @Autowired
    public VehicleController(VehicleService service) {
        this.service = service;
    }

    @GetMapping("/vehicle")
    public String showAll(Model model) {
        model.addAttribute("data", service.findAll());
        return "vehicle";
    }

    @GetMapping("/vehicleAdd")
    public String add(Model model) {
        model.addAttribute("vehicle", new Vehicle());
        return "vehicleAdd";
    }

    @PostMapping("/vehicle")
    public String save(@ModelAttribute("vehicle") Vehicle vehicle) {
        service.save(vehicle);
        return "redirect:/vehicle";
    }

    @GetMapping("/vehicleEdit")
    public String edit(@RequestParam("id") int id, Model model) {
        try {
            model.addAttribute("vehicle", service.findById(id));
        } catch (Exception e) {
            return "redirect:/error";
        }
        return "vehicleAdd";
    }

    @GetMapping("/vehicleDelete")
    public String delete(@RequestParam("id") int id, Model model) {
        model.addAttribute("delete", service.delete(id));
        return "vehicle";
    }
}
