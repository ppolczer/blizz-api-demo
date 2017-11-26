package at.ppolczer.blizzardApiDemo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CareerProfile {

    private String battleTag;
    private Integer paragonLevel;
    private Integer paragonLevelHardcore;
    private Integer paragonLevelSeason;
    private Integer paragonLevelSeasonHardcore;
    private String guildName;
    private List<Hero> heroes;

    public String getBattleTag() {
        return battleTag;
    }

    public void setBattleTag(String battleTag) {
        this.battleTag = battleTag;
    }

    public Integer getParagonLevel() {
        return paragonLevel;
    }

    public void setParagonLevel(Integer paragonLevel) {
        this.paragonLevel = paragonLevel;
    }

    public Integer getParagonLevelHardcore() {
        return paragonLevelHardcore;
    }

    public void setParagonLevelHardcore(Integer paragonLevelHardcore) {
        this.paragonLevelHardcore = paragonLevelHardcore;
    }

    public Integer getParagonLevelSeason() {
        return paragonLevelSeason;
    }

    public void setParagonLevelSeason(Integer paragonLevelSeason) {
        this.paragonLevelSeason = paragonLevelSeason;
    }

    public Integer getParagonLevelSeasonHardcore() {
        return paragonLevelSeasonHardcore;
    }

    public void setParagonLevelSeasonHardcore(Integer paragonLevelSeasonHardcore) {
        this.paragonLevelSeasonHardcore = paragonLevelSeasonHardcore;
    }

    public String getGuildName() {
        return guildName;
    }

    public void setGuildName(String guildName) {
        this.guildName = guildName;
    }


    public List<Hero> getHeroes() {
        return heroes;
    }

    public void setHeroes(List<Hero> heroes) {
        this.heroes = heroes;
    }
}
