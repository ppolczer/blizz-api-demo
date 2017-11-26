package at.ppolczer.blizzardApiDemo.controllers;

import at.ppolczer.blizzardApiDemo.services.BlizzardApiService;
import at.ppolczer.blizzardApiDemo.models.CareerProfile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.util.StringUtils;

@Controller
public class D3CareerProfilesController {

    private BlizzardApiService apiService = new BlizzardApiService();

    @RequestMapping("/profiles")
    public String profiles() {
        return "profiles";
    }

    @PostMapping("/profile")
    public String profile(Model model, @ModelAttribute("battleTagInput") String battleTagInput) {
        if(StringUtils.isEmptyOrWhitespace(battleTagInput)){
            return "profileBattletagNotFound";
        }

        CareerProfile profile = apiService.getD3CareerProfile(battleTagInput);

        if(profile != null && profile.getBattleTag() != null){
            model.addAttribute("battletag", profile.getBattleTag());
            model.addAttribute("paragonLevel", profile.getParagonLevel());
            model.addAttribute("paragonLevelHardcore", profile.getParagonLevelHardcore());
            model.addAttribute("paragonLevelSeason", profile.getParagonLevelSeason());
            model.addAttribute("paragonLevelSeasonHardcore", profile.getParagonLevelSeasonHardcore());
            model.addAttribute("guildName", profile.getGuildName());

            model.addAttribute("heroes", profile.getHeroes());
        } else {
            return "profileBattletagNotFound";
        }

        return "profile";
    }
}
