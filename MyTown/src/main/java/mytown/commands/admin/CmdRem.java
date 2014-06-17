package mytown.commands.admin;

import mytown.MyTown;
import mytown.core.ChatUtils;
import mytown.core.utils.command.CommandBase;
import mytown.core.utils.command.Permission;
import mytown.datasource.MyTownDatasource;
import mytown.proxies.DatasourceProxy;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;

@Permission("mytown.adm.cmd.rem")
public class CmdRem extends CommandBase {

	public CmdRem(String name, CommandBase parent) {
		super(name, parent);
	}

	@Override
	public void process(ICommandSender sender, String[] args) throws Exception {
		if (args.length < 2)
			throw new WrongUsageException(MyTown.getLocal().getLocalization("mytown.adm.cmd.usage.rem"));
		if (!getDatasource().hasResident(args[0]))
			throw new CommandException(MyTown.getLocal().getLocalization("mytown.cmd.err.resident.notexist", args[0]));
		if (!getDatasource().hasTown(args[1]))
			throw new CommandException(MyTown.getLocal().getLocalization("mytown.cmd.err.town.notexist", args[1]));
		if (!getDatasource().getTown(args[1]).hasResident(getDatasource().getResident(args[0])))
			throw new CommandException(MyTown.getLocal().getLocalization("mytown.adm.cmd.err.rem.resident", (Object[]) args));

		getDatasource().unlinkResidentFromTown(getDatasource().getResident(args[0]), getDatasource().getTown(args[1]));
		ChatUtils.sendLocalizedChat(sender, MyTown.getLocal(), "mytown.notification.town.resident.remove", (Object[]) args);
	}

	/**
	 * Helper method to return the current MyTownDatasource instance
	 * 
	 * @return
	 */
	private MyTownDatasource getDatasource() {
		return DatasourceProxy.getDatasource();
	}
}