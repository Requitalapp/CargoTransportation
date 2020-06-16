package CargoTransportation.Cargo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CargoController {
    private CargoService service;

    @Autowired
    public CargoController(CargoService service){
        this.service = service;
    }

    @GetMapping("/cargo")
    public String showAll(Model model) {
        model.addAttribute("data", service.findAll());
        return "cargo";
    }

    @GetMapping("/cargoAdd")
    public String add(Model model){
        model.addAttribute("cargo", new Cargo());
        return "cargoAdd";
    }

    @PostMapping("/cargo")
    public String save(@ModelAttribute("cargo") Cargo cargo){
        service.save(cargo);
        return "redirect:/cargo";
    }

    @GetMapping("/cargoEdit")
    public String edit(@RequestParam("id") int id, Model model){
        try {
            model.addAttribute("cargo", service.findById(id));
        }
        catch (Exception e){
            return "redirect:/error";
        }
        return "cargoAdd";
    }

    @GetMapping("/cargoDelete")
    public String delete(@RequestParam("id") int id, Model model){
        model.addAttribute("delete", service.delete(id));
        return "cargo";
    }
}
