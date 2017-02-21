package pw.wiped.commands;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.utils.SimpleLog;
import pw.wiped.util.CommandManager;
import pw.wiped.util.Permissions;

import java.util.Arrays;

/**
 * Created by wiped on 2/19/17.
 */
public abstract class Command {

    public static void initCommands() {

    }

    public final String[] commands;
    public final Permissions requiredPermissions;
    protected final SimpleLog LOG;

    public Command (String name, Permissions requiredPermissions, String... commands) {
        this.commands = commands;
        this.requiredPermissions = requiredPermissions;
        this.LOG = SimpleLog.getLog(name);
        LOG.info(name + " loaded. Following commands: " + Arrays.toString(commands));
    }

    public abstract void action (String param, String[] args, MessageReceivedEvent e);
    public abstract boolean called (String param, String[] args);
    public abstract void help ();

}