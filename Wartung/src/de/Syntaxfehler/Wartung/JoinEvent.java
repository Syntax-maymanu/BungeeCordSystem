package de.Syntaxfehler.Wartung;

import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ServerConnectEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class JoinEvent
  implements Listener
{
  @EventHandler
  public void onJoin(ServerConnectEvent e)
  {
    if (Lobby.isWartung)
    {
      if (e.getPlayer().hasPermission("Bungee.CanJoin"))
      {
        e.setCancelled(false);
      }
      else
      {
        e.setCancelled(true);
        e.getPlayer().disconnect("§4Wartungsarbeiten!\n\n§cDas CrossCraft.de Netzwerk ist gerade im Wartungs Modus!\n\n§3Es werden gerade updates oder Wartungen durchgeführt\n\n§2Wir bitten um ihr verständnis!");
      }
    }
    else {
      e.setCancelled(false);
    }
  }
}
