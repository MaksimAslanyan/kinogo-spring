package com.example.kinogospring.controller.admin;

import com.example.kinogospring.model.entity.CastCrew;
import com.example.kinogospring.service.adminservice.AdminCastCrewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/admin/castcrew")
@RequiredArgsConstructor
public class AdminCastCrewController {

    private final AdminCastCrewService adminCastCrewService;


    @GetMapping("/add")
    public String addCastCrewPage() {
        return "";
    }

    @PostMapping("/add")
    public String addCastCrew(@ModelAttribute CastCrew castCrew) {
        adminCastCrewService.save(castCrew);
        return "redirect:/admin";
    }

    @GetMapping("/edit/{id}")
    public String editCastCrewPage(@RequestParam("castcrewId") int id, ModelMap modelMap) {
        Optional castCrewOptional = adminCastCrewService.getById(id);
        if (castCrewOptional.isEmpty()) {
            return "redirect:/admin";
        }
        modelMap.addAttribute("castcrew", castCrewOptional.get());
        return "";
    }

    @PostMapping("/edit")
    public String editCastCrew(@ModelAttribute CastCrew castCrew) {
        adminCastCrewService.save(castCrew);
        return "redirect:/admin";
    }

    @GetMapping("/remove/{id}")
    public String deleteCastCrew(@PathVariable("id") int id) {
        adminCastCrewService.delete(id);
        return "redirect:/admin";
    }

}

