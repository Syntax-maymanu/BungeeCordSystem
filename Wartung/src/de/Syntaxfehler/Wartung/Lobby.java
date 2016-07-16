package de.Syntaxfehler.Wartung;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.api.plugin.PluginManager;

public class Lobby
  extends Plugin
{
  public static boolean isWartung = false;
  
  public void onEnable()
  {
    ProxyServer.getInstance().getPluginManager().registerListener(this, new ServerPinger(this));
    ProxyServer.getInstance().getPluginManager().registerListener(this, new JoinEvent());
    ProxyServer.getInstance().getPluginManager().registerCommand(this, new Wartung("wartung"));
  }
}
