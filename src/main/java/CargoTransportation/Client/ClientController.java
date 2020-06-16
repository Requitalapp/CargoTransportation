package CargoTransportation.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ClientController {
    private ClientService service;

    @Autowired
    public ClientController(ClientService service) {
        this.service = service;
    }

    @GetMapping("/client")
    public String showAll(Model model) {
        model.addAttribute("data", service.findAll());
        return "client";
    }

    @GetMapping("/clientAdd")
    public String add(Model model){
        model.addAttribute("client", new Client());
        return "clientAdd";
    }

    @PostMapping("/client")
    public String save(@ModelAttribute("client") Client client){
        service.save(client);
        return "redirect:/client";
    }

    @GetMapping("/clientEdit")
    public String edit(@RequestParam("id") int id, Model model){
        try {
            model.addAttribute("client", service.findById(id));
        }
        catch (Exception e){
            return "redirect:/error";
        }
        return "clientAdd";
    }

    @GetMapping("/clientDelete")
    public String delete(@RequestParam("id") int id, Model model){
        model.addAttribute("delete", service.delete(id));
        return "client";
    }
}
