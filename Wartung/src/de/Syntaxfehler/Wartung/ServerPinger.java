package de.Syntaxfehler.Wartung;

import net.md_5.bungee.api.ServerPing;
import net.md_5.bungee.api.ServerPing.Protocol;
import net.md_5.bungee.api.event.ProxyPingEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class ServerPinger
  implements Listener
{
  Lobby plugin;
  
  public ServerPinger(Lobby plugin)
  {
    this.plugin = plugin;
  }
  
  @EventHandler
  public void on(ProxyPingEvent e)
  {
    if (Lobby.isWartung)
    {
      ServerPing conn = e.getResponse();
      conn.setVersion(new ServerPing.Protocol("$cWartungsarbeiten", 2));
      conn.setDescription("§fCrossCraft.de §8» §cWartungen!");
      conn.setFavicon("Wartungen");
      e.setResponse(conn);
    }
  }
}
