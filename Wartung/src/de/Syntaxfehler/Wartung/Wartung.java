package de.Syntaxfehler.Wartung;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class Wartung
  extends Command
{
  public Wartung(String name)
  {
    super(name);
  }
  
  public void execute(CommandSender sender, String[] args)
  {
    if (args.length == 0)
    {
      ProxiedPlayer p = (ProxiedPlayer)sender;
      p.sendMessage("§7=============== §3Wartung §7================");
      p.sendMessage("§7/wartung on");
      p.sendMessage("§7/wartung off");
      p.sendMessage("§7=============== §3Wartung §7================");
      return;
    }
    if (args.length == 1)
    {
      ProxiedPlayer p = (ProxiedPlayer)sender;
      if (p.hasPermission("bungee.change"))
      {
        if (args[0].equalsIgnoreCase("on")) {
          if (!Lobby.isWartung)
          {
            Lobby.isWartung = true;
            p.sendMessage("§2Du hast den Wartungs Mode aktiviert");
          }
          else
          {
            p.sendMessage("§cDer Wartungs Modus ist bereits an!");
          }
        }
      }
      else {
        p.sendMessage("§cDu hast keie Rechte");
      }
      if (p.hasPermission("bungee.change"))
      {
        if (args[0].equalsIgnoreCase("off")) {
          if (Lobby.isWartung)
          {
            Lobby.isWartung = false;
            p.sendMessage("§2Du hast den Wartungs Mode deaktiviert");
          }
          else
          {
            p.sendMessage("Der Wartungs Modus ist nicht an");
          }
        }
      }
      else {
        p.sendMessage("§cDu hast keine Rechte");
      }
    }
  }
}
