package com.example.datingagency.controllers;

import com.example.datingagency.data.Archive;
import com.example.datingagency.data.Client;
import com.example.datingagency.data.ClientInfo;
import com.example.datingagency.data.DatingTable;
import com.example.datingagency.services.ArchiveService;
import com.example.datingagency.services.ClientService;
import com.example.datingagency.services.DatingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
public class MainController {

    private ClientService cs;
    private DatingService ds;
    private ArchiveService as;


    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("clients", cs.getClients());
        return "index";
    }

    @GetMapping("index")
    public String mainPage(Model model){
        model.addAttribute("clients", cs.getClients());
        return "index";
    }

    @GetMapping("filtered_clients")
    public String filteredClients(Model model) {
//        model.addAttribute("clients", cs.getClientsWith(s));
        return "filtered_clients";
    }

    @PostMapping("/filter_clients")
    public String filterClients(@RequestParam String s, Model model) {
        model.addAttribute("clients", cs.getClientsWith(s));
        return "filtered_clients";
    }

    @PostMapping("add_client")
    public String addArtist(
            @RequestParam String name,String surname, String about_yourself, String partner_requirements , String sex) {
        cs.addClient(name,surname,about_yourself,partner_requirements,sex);
        return "redirect:/index";
    }

    @GetMapping("edit_client")
    public String editArtist(@RequestParam int id, Model model) {
        Optional<Client> a = cs.findById(id);
        if (a.isPresent()) {
            model.addAttribute("client", a.get());
            return "edit_client";
        }
        return "redirect:/index";
    }

    @PatchMapping("update_client")
    public String updateArtist(@RequestParam int id, String name,String surname, String about_yourself, String partner_requirements , String sex) {
        cs.updateClient(id, name, surname, about_yourself, partner_requirements, sex);

        return "redirect:/index";
    }

    @GetMapping("delete_client")
    public String deleteArtist(@RequestParam int id) {
        try {
            cs.deleteClient(id);
        } catch (Exception ignored) {
        }
        return "redirect:/index";
    }

    @GetMapping("dating_table")
    public String artists(Model model){
        model.addAttribute("dates", ds.getDates());
        return "dating_table";
    }

    @PostMapping("add_date")
    public String addDate(@RequestParam int first_person_id, @RequestParam int second_person_id, @RequestParam LocalDateTime date, Model model) {
        Optional<Client> a = cs.findById(first_person_id);
        Optional<Client> b = cs.findById(second_person_id);
        if (a.isPresent()&&b.isPresent()) {
            model.addAttribute("first_person", a.get());
            model.addAttribute("second_person", b.get());
            ds.addDate(first_person_id, second_person_id, date);
            return "redirect:/dating_table";
        }
        return "redirect:/dating_table";
    }

    @GetMapping("delete_date")
    public String deleteDate(@RequestParam int id) {
        try {
            ds.deleteDate(id);
        } catch (Exception ignored) {
        }
        return "redirect:/dating_table";
    }

    @GetMapping("archive_date")
    public String addConvergedPair(@RequestParam int id, Model model) {
        List<DatingTable> datingTables = ds.getInfo(id);
        List<String> firstPerson = datingTables.stream()
                .map(DatingTable::getFirstPerson)
                .toList();
        List<String> secondPerson = datingTables.stream()
                .map(DatingTable::getSecondPerson)
                .toList();

        String joinedFirstPerson = String.join(" and ", firstPerson);
        String joinedSecondPerson = String.join(" and ", secondPerson);

        model.addAttribute("pairs", joinedFirstPerson + " and " + joinedSecondPerson);
        System.out.println(joinedFirstPerson + " and " + joinedSecondPerson);
        as.addConvergedPair(joinedFirstPerson + " and " + joinedSecondPerson);
        deleteDate(id);
        return "redirect:/dating_table";
    }


    @GetMapping("archive")
    public String archive(Model model){
        model.addAttribute("archivedPairs", as.getPairs());
        return "archive";
    }
}
