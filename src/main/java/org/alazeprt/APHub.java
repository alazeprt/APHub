package org.alazeprt;

import org.alazeprt.command.aphub;
import org.alazeprt.command.hub;
import org.alazeprt.command.sethub;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class APHub extends JavaPlugin {
    @Override
    public void onEnable() {
        this.saveResource("data.yml",false);
        System.out.println("§cAPHub §ev1.0 §dAlpha Version §aEnabled.");
        Objects.requireNonNull(getCommand("aphub")).setExecutor(new aphub());
        Objects.requireNonNull(getCommand("sethub")).setExecutor(new sethub());
        Objects.requireNonNull(getCommand("hub")).setExecutor(new hub());
    }

    @Override
    public void onDisable() {
        System.out.println("§cAPHub §ev1.0 §dAlpha Version §cDisabled.");
    }
}