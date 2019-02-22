package com.site.Controller;

import com.site.notification.Notification;
import com.site.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.site.model.Client;

import javax.validation.Valid;
import java.util.List;
import java.util.logging.Logger;

@Controller
@Configuration
public class HomeController {

    @Autowired
    Notification notification;

    @Autowired
    private ClientRepository clientRepository;

    private static Logger logger = Logger.getLogger(String.valueOf(HomeController.class));

    public void log() {
        logger.info("log4j is work");
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(@RequestParam(value = "search", required = false) String search,
                       Model model) {
        List<Client> clients;
        if (search == null || search.isEmpty()) {
            clients = clientRepository.findAll();
            logger.info("Main page, all data loaded: " + clients.toString());
            notification.addInfoMessage("Loaded " + clients.size() + " items!");
        } else {
            clients = clientRepository.getClientByNameOrRegNoOrVatId(search);
            logger.info("Search run, search value is: " + search + "; find results: " + clients.size());
            notification.addInfoMessage("Found " + clients.size() + " items!");
        }
        model.addAttribute("clients", clients);

        return "index";
    }

    @Transactional
    @RequestMapping("/delete/{id}")
    public String delelete(@PathVariable("id") Long id) {
        logger.info("Delete run, data to delete: " + clientRepository.getClientById(id));
        String tempClient = clientRepository.getClientById(id).getName();
        clientRepository.delete(id);
        logger.info("Success delete Client with id: " + id);
        notification.addInfoMessage("Delete data successful: " + tempClient + "!");
        return "redirect:/";
    }

    @RequestMapping("/update/{id}")
    public String update(@PathVariable("id") Long id, Model model) {
        logger.info("Update run, data to update: " + clientRepository.getClientById(id));
        model.addAttribute("client", clientRepository.getClientById(id));

        return "update";
    }

    @RequestMapping("/create")
    public String newClient(Model model, Client client) {
        model.addAttribute("client", client);
        logger.info("Open create form to save data, create new object Client.");

        return "create";
    }

    @Transactional
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String saveClient(@Valid Client client, BindingResult bindingResult) {
        logger.info("Data will be save: " + client.toString());
        if (bindingResult.hasErrors()) {
            notification.addErrorMessage("Please fill the form correctly to save!");
            logger.info("Data from the form has not been saved. Erroneous data in fields.");
            return "create";
        }
        clientRepository.save(client);
        notification.addInfoMessage("Added data successful: " + client.getName() + "!");
        logger.info("Success saved data: " + client.toString());

        return "redirect:/";
    }

    @Transactional
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String updateClient(@Valid Client client, BindingResult bindingResult) {
        logger.info("Data will be update to: " + client.toString());
        if (bindingResult.hasErrors()) {
            notification.addErrorMessage("Please fill the form correctly to update!");
            logger.info("Data from the form has not been updated. Erroneous data in fields.");
            return "create";
        }
        clientRepository.save(client);
        notification.addInfoMessage("Updated data successful: " + client.getName() + "!");
        logger.info("Success updated data");

        return "redirect:/";
    }
}
