package mytown.datasource;

import mytown.entities.*;
import mytown.entities.flag.Flag;

public class InMemoryDatasource extends MyTownDatasource {
    @Override
    public boolean initialize() {
        LOG.debug("Initializing In-Memory Datasource");
        return true;
    }

    @Override
    protected boolean loadWorlds() {
        return false;
    }

    @Override
    protected boolean loadTowns() {
        LOG.debug("Loading Towns");
        return true;
    }

    @Override
    protected boolean loadBlocks() {
        LOG.debug("Loading Blocks");
        return true;
    }

    @Override
    protected boolean loadRanks() {
        LOG.debug("Loading Ranks");
        return true;
    }

    @Override
    protected boolean loadResidents() {
        LOG.debug("Loading Residents");
        return true;
    }

    @Override
    protected boolean loadPlots() {
        LOG.debug("Loading Plots");
        return true;
    }

    @Override
    protected boolean loadNations() {
        LOG.debug("Loading Nations");
        return true;
    }

    @Override
    protected boolean loadTownFlags() {
        LOG.debug("Loading Flags");
        return true;
    }

    @Override
    protected boolean loadPlotFlags() {
        LOG.debug("Loading Flags");
        return true;
    }

    @Override
    protected boolean loadBlockWhitelists() {
        return false;
    }

    @Override
    protected boolean loadSelectedTowns() {
        return false;
    }

    @Override
    protected boolean loadFriends() {
        return false;
    }

    @Override
    protected boolean loadFriendRequests() {
        return false;
    }

    @Override
    protected boolean loadTownInvites() {
        return false;
    }

    @Override
    protected boolean loadBlockOwners() {
        return false;
    }

    @Override
    protected boolean loadTownBanks() {
        return false;
    }

    @Override
    protected boolean loadRankPermissions() {
        return false;
    }

    @Override
    protected boolean loadResidentsToTowns() {
        return false;
    }

    @Override
    protected boolean loadTownsToNations() {
        return false;
    }

    @Override
    protected boolean loadResidentsToPlots() {
        return false;
    }

    @Override
    public boolean saveTown(Town town) {
        LOG.debug("Saving Town %s", town.getName());
        if (MyTownUniverse.instance.hasTown(town)) { // Update
            if (town.getOldName() != null) { // Rename
                MyTownUniverse.instance.removeTown(town);
                MyTownUniverse.instance.addTown(town);
                town.resetOldName();
            }
        } else { // Insert
            MyTownUniverse.instance.addTown(town);
        }
        return true;
    }

    @Override
    public boolean saveBlock(TownBlock block) {
        LOG.debug("Saving Block %s", block.getKey());
        if (MyTownUniverse.instance.hasTownBlock(block)) { // Update
        } else { // Insert
            MyTownUniverse.instance.addTownBlock(block);
        }
        return true;
    }

    @Override
    public boolean saveRank(Rank rank, boolean isDefault) {
        LOG.debug("Saving Rank %s", rank.getKey());
        if (MyTownUniverse.instance.hasRank(rank)) { // Update
        } else { // Insert
            MyTownUniverse.instance.addRank(rank);
        }
        return true;
    }

    @Override
    public boolean saveRankPermission(Rank rank, String perm) {
        return false;
    }

    @Override
    public boolean saveResident(Resident resident) {
        LOG.debug("Saving Resident %s (%s)", resident.getPlayerName(), resident.getUUID().toString());
        if (MyTownUniverse.instance.hasResident(resident)) { // Update
        } else { // Insert
            MyTownUniverse.instance.addResident(resident);
        }
        return true;
    }

    @Override
    public boolean savePlot(Plot plot) {
        LOG.debug("Saving Plot %s", plot.getKey());
        if (MyTownUniverse.instance.hasPlot(plot)) { // Update
        } else { // Insert
            MyTownUniverse.instance.addPlot(plot);
        }
        return true;
    }

    @Override
    public boolean saveNation(Nation nation) {
        return false;
    }

    @Override
    public boolean saveFlag(Flag flag, Town town) {
        return true;
    }

    @Override
    public boolean saveFlag(Flag flag, Plot plot) {
        return true;
    }

    @Override
    public boolean saveBlockWhitelist(BlockWhitelist bw, Town town) {
        return true;
    }

    @Override
    public boolean saveSelectedTown(Resident res, Town town) {
        return true;
    }

    @Override
    public boolean saveFriendLink(Resident res1, Resident res2) {
        return true;
    }

    @Override
    public boolean saveFriendRequest(Resident res1, Resident res2) {
        return true;
    }

    @Override
    public boolean saveTownInvite(Resident res, Town town) {
        return true;
    }

    @Override
    public boolean saveWorld(int dim) {
        return true;
    }

    @Override
    public boolean saveBlockOwner(Resident res, int dim, int x, int y, int z) {
        return true;
    }

    @Override
    public boolean saveTownBank(Town town, int amount, int daysNotPaid) {
        return true;
    }


    /*

    @Override
    public boolean saveNation(Nation nation) {
        log.debug("Saving Nation %s", nation.getName());
        if (MyTownUniverse.instance.nations.containsValue(nation)) { // Update
        } else { // Insert
            MyTownUniverse.instance.nations.put(nation.getName(), nation);
        }
        return true;
    }

    @Override
    public boolean saveFlag(Flag flag, Plot plot) {
        log.debug("Saving Flag %s for plot:", flag.getName(), plot.getKey());
        if (plot.hasFlag(flag.getName())) { // Update
        } else { // Insert
            plot.addFlag(flag);
        }
        return true;
    }


    @Override
    public boolean saveBlockWhitelist(BlockWhitelist bw, Town town) {
        return false;
    }

    @Override
    public boolean saveSelectedTown(Resident res, Town town) {
        return false;
    }

    @Override
    public boolean saveFlag(Flag flag, Town town) {
        log.debug("Saving Flag %s for town:", flag.getName(), town.getName());
        if (town.hasFlag(flag.getName())) { // Update
        } else { // Insert
            town.addFlag(flag);
        }
        return true;
    }
    */

    /* ----- Link ----- */

    @Override
    public boolean linkResidentToTown(Resident res, Town town, Rank rank) {
        return true;
    }

    @Override
    public boolean unlinkResidentFromTown(Resident res, Town town) {
        return true;
    }

    @Override
    public boolean updateResidentToTownLink(Resident res, Town town, Rank rank) {
        return false;
    }

    @Override
    public boolean linkTownToNation(Town town, Nation nation) {
        return true;
    }

    @Override
    public boolean unlinkTownFromNation(Town town, Nation nation) {
        return true;
    }

    @Override
    public boolean updateTownToNationLink(Town town, Nation nation) {
        return true;
    }

    @Override
    public boolean linkResidentToPlot(Resident res, Plot plot, boolean isOwner) {
        return true;
    }

    @Override
    public boolean unlinkResidentFromPlot(Resident res, Plot plot) {
        return true;
    }

    @Override
    public boolean updateResidentToPlotLink(Resident res, Plot plot, boolean isOwner) {
        return false;
    }

    @Override
    public boolean updateTownBank(Town town, int amount) {
        return true;
    }

    @Override
    public boolean deleteTown(Town town) {
        LOG.debug("Deleting Town %s", town);
        return MyTownUniverse.instance.removeTown(town);
    }

    @Override
    public boolean deleteBlock(TownBlock townBlock) {
        LOG.debug("Deleting Block %s", townBlock.getKey());
        return MyTownUniverse.instance.removeTownBlock(townBlock);
    }

    @Override
    public boolean deleteRank(Rank rank) {
        LOG.debug("Deleting Rank %s", rank.getKey());
        return MyTownUniverse.instance.removeRank(rank);
    }

    @Override
    public boolean deleteResident(Resident resident) {
        LOG.debug("Deleting Resident %s (%s)", resident.getPlayerName(), resident.getUUID().toString());
        return MyTownUniverse.instance.removeResident(resident);
    }

    @Override
    public boolean deletePlot(Plot plot) {
        LOG.debug("Deleting Plot %s", plot.getKey());
        return MyTownUniverse.instance.removePlot(plot);
    }

    @Override
    public boolean deleteNation(Nation nation) {
        LOG.debug("Deleting Nation %s", nation.getName());
        return MyTownUniverse.instance.removeNation(nation);
    }

    @Override
    public boolean deleteFlag(Flag flag, Town town) {
        return false;
    }

    @Override
    public boolean deleteFlag(Flag flag, Plot plot) {
        return false;
    }

    @Override
    public boolean deleteBlockWhitelist(BlockWhitelist bw, Town town) {
        return true;
    }

    @Override
    public boolean deleteSelectedTown(Resident res) {
        return false;
    }

    @Override
    public boolean deleteFriendLink(Resident res1, Resident res2) {
        return true;
    }

    @Override
    public boolean deleteFriendRequest(Resident res1, Resident res2) {
        return true;
    }

    @Override
    public boolean deleteTownInvite(Resident res, Town town, boolean response) {
        return true;
    }

    @Override
    public boolean deleteWorld(int dim) {
        return true;
    }

    @Override
    public boolean removeRankPermission(Rank rank, String perm) {
        return false;
    }

    @Override
    public boolean deleteAllBlockOwners() {
        return true;
    }

    @Override
    protected boolean checkFlags() {
        return false;
    }

    @Override
    protected boolean checkTowns() {
        return false;
    }
}
