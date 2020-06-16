package CargoTransportation.Ord;

import CargoTransportation.Cargo.CargoService;
import CargoTransportation.Client.ClientService;
import CargoTransportation.Driver.DriverService;
import CargoTransportation.Manage.ManageService;
import CargoTransportation.Route.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OrdController {
    private OrdService ordService;
    private ManageService manageService;
    private ClientService clientService;
    private RouteService routeService;
    private CargoService cargoService;
    private DriverService driverService;

    @Autowired
    public OrdController(ManageService manageService, ClientService clientService, OrdService ordService,
                         RouteService routeService, CargoService cargoService, DriverService driverService) {
        this.manageService = manageService;
        this.clientService = clientService;
        this.routeService = routeService;
        this.cargoService = cargoService;
        this.driverService = driverService;
        this.ordService = ordService;
    }

    @GetMapping("/ord")
    public String showAll(Model model) {
        model.addAttribute("data", ordService.findAll());
        return "ord";
    }

    @GetMapping("/ordAdd")
    public String add(Model model) {
        model.addAttribute("ord", new Ord());
        model.addAttribute("manage", manageService.findAll());
        model.addAttribute("client", clientService.findAll());
        model.addAttribute("route", routeService.findAll());
        model.addAttribute("cargo", cargoService.findAll());
        model.addAttribute("driver", driverService.findAll());
        return "ordAdd";
    }

    @PostMapping("/ord")
    public String save(@ModelAttribute("ord") Ord ord) {
        ordService.save(ord);
        return "redirect:/ord";
    }

    @GetMapping("/ordEdit")
    public String edit(@RequestParam("id") int id, Model model) {
        model.addAttribute("ord", ordService.findById(id));
        model.addAttribute("manage", manageService.findAll());
        model.addAttribute("client", clientService.findAll());
        model.addAttribute("route", routeService.findAll());
        model.addAttribute("cargo", cargoService.findAll());
        model.addAttribute("driver", driverService.findAll());
        return "ordAdd";
    }

    @GetMapping("/ordDelete")
    public String delete(@RequestParam("id") int id, Model model) {
        model.addAttribute("delete", ordService.delete(id));
        return "ord";
    }
}
