package win.subilan.Ageing;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;

public class CommandHandler implements CommandExecutor {
    public Ageing plug;

    public CommandHandler(Ageing plug) {
        this.plug = plug;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("age") {
            String arg = args[0];
            FileConfiguration config = this.plug.getConfig();

            switch (arg) {
                case "set":
                    this.plug.ageData.set(args[1], args[2]);
                    sender.sendMessage(G.translateColor(G.success + "Successfully set &a" + args[1] + "&r's age to &a" + args[2] + "&r."));
                    break;

                case "get":
                    String age = this.plug.ageData.getString(args[1]);
                    sender.sendMessage(G.translateColor(G.info + "The age of &a" + args[1] + "&r is &a" + age + "&r."));
                    break;
                
                case "reload":
                    this.plug.reloadConfig();
                    sender.sendMessage(G.translateColor(G.success + "Successfully reload the plugin configuration"));
                    break;
            }
        }
        return false;
    }
}