package ac.grim.grimac.manager.checkset;

import ac.grim.grimac.checks.impl.badpackets.BadPacketsX;
import ac.grim.grimac.checks.impl.badpackets.BadPacketsZ;
import ac.grim.grimac.checks.impl.misc.FastBreak;
import ac.grim.grimac.checks.type.BlockBreakCheck;
import ac.grim.grimac.player.GrimPlayer;
import ac.grim.grimac.utils.anticheat.update.BlockBreak;
import ac.grim.grimac.utils.anticheat.update.PredictionComplete;
import com.github.retrooper.packetevents.event.PacketReceiveEvent;
import com.github.retrooper.packetevents.event.PacketSendEvent;

import java.util.Arrays;
import java.util.Collection;

public class BlockBreakCheckSet implements CheckSet<BlockBreakCheck> {

    private final BadPacketsX badPacketsX;
    private final BadPacketsZ badPacketsZ;
    private final FastBreak fastBreak;

    public BlockBreakCheckSet(GrimPlayer player) {
        this.badPacketsX = new BadPacketsX(player);
        this.badPacketsZ = new BadPacketsZ(player);
        this.fastBreak = new FastBreak(player);
    }

    public void onPacketReceive(final PacketReceiveEvent packet) {
        badPacketsX.onPacketReceive(packet);
        badPacketsZ.onPacketReceive(packet);
        fastBreak.onPacketReceive(packet);
    }

    public void onPacketSend(final PacketSendEvent packet) {
        badPacketsX.onPacketSend(packet);
        badPacketsZ.onPacketSend(packet);
        fastBreak.onPacketSend(packet);
    }

    public void onPredictionFinish(final PredictionComplete complete) {
        badPacketsX.onPredictionComplete(complete);
        badPacketsZ.onPredictionComplete(complete);
        fastBreak.onPredictionComplete(complete);
    }

    public void onBlockBreak(final BlockBreak blockBreak) {
        badPacketsX.onBlockBreak(blockBreak);
        badPacketsZ.onBlockBreak(blockBreak);
        fastBreak.onBlockBreak(blockBreak);
    }

    @Override
    public Collection<BlockBreakCheck> getAll() {
        return Arrays.asList(
                badPacketsX,
                badPacketsZ,
                fastBreak
        );
    }
}
