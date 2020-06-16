package CargoTransportation.Driver;

import CargoTransportation.Vehicle.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DriverController {
    private DriverService driverService;
    private VehicleService vehicleService;

    @Autowired
    public DriverController(DriverService driverService,
                            VehicleService vehicleService){
        this.driverService = driverService;
        this.vehicleService = vehicleService;
    }

    @GetMapping("/driver")
    public String showAll(Model model) {
        model.addAttribute("data", driverService.findAll());
        return "driver";
    }

    @GetMapping("/driverAdd")
    public String add(Model model){
        model.addAttribute("driver", new Driver());
        model.addAttribute("vehicle", vehicleService.findAll());
        return "driverAdd";
    }

    @PostMapping("/driver")
    public String save(@ModelAttribute("driver") Driver driver){
        driverService.save(driver);
        return "redirect:/driver";
    }

    @GetMapping("/driverEdit")
    public String edit(@RequestParam("id") int id, Model model){
        model.addAttribute("driver", driverService.findById(id));
        model.addAttribute("vehicle", vehicleService.findAll());
        return "driverAdd";
    }

    @GetMapping("/driverDelete")
    public String delete(@RequestParam("id") int id, Model model){
        model.addAttribute("delete", driverService.delete(id));
        return "driver";
    }
}
