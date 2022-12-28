package PojoPackage;

import java.util.List;

public class RCBteam {

    String name;
    String location;
    List<Player> player;

    public List<Player> getPlayer() {
        return player;
    }

    public void setPlayers(List<Player> player) {
        this.player = player;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


}
