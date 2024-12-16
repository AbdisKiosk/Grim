package ac.grim.grimac.manager.checkset;

import ac.grim.grimac.checks.impl.misc.GhostBlockMitigation;
import ac.grim.grimac.checks.impl.multiactions.MultiActionsF;
import ac.grim.grimac.checks.impl.scaffolding.*;
import ac.grim.grimac.checks.type.BlockPlaceCheck;
import ac.grim.grimac.player.GrimPlayer;
import ac.grim.grimac.utils.anticheat.update.BlockPlace;
import ac.grim.grimac.utils.anticheat.update.PredictionComplete;
import ac.grim.grimac.utils.anticheat.update.RotationUpdate;
import com.github.retrooper.packetevents.event.PacketReceiveEvent;
import com.github.retrooper.packetevents.event.PacketSendEvent;

import java.util.Arrays;
import java.util.Collection;

public class BlockPlaceCheckSet implements CheckSet<BlockPlaceCheck> {

    private final InvalidPlaceA invalidPlaceA;
    private final InvalidPlaceB invalidPlaceB;
    private final AirLiquidPlace airLiquidPlace;
    private final MultiPlace multiPlace;
    private final MultiActionsF multiActionsF;
    private final FarPlace farPlace;
    private final FabricatedPlace fabricatedPlace;
    private final PositionPlace positionPlace;
    private final RotationPlace rotationPlace;
    private final DuplicateRotPlace duplicateRotPlace;
    private final GhostBlockMitigation ghostBlockMitigation;

    public BlockPlaceCheckSet(GrimPlayer player) {
        this.invalidPlaceA = new InvalidPlaceA(player);
        this.invalidPlaceB = new InvalidPlaceB(player);
        this.airLiquidPlace = new AirLiquidPlace(player);
        this.multiPlace = new MultiPlace(player);
        this.multiActionsF = new MultiActionsF(player);
        this.farPlace = new FarPlace(player);
        this.fabricatedPlace = new FabricatedPlace(player);
        this.positionPlace = new PositionPlace(player);
        this.rotationPlace = new RotationPlace(player);
        this.duplicateRotPlace = new DuplicateRotPlace(player);
        this.ghostBlockMitigation = new GhostBlockMitigation(player);
    }

    public void onPacketReceive(final PacketReceiveEvent event) {
        invalidPlaceA.onPacketReceive(event);
        invalidPlaceB.onPacketReceive(event);
        airLiquidPlace.onPacketReceive(event);
        multiPlace.onPacketReceive(event);
        multiActionsF.onPacketReceive(event);
        farPlace.onPacketReceive(event);
        fabricatedPlace.onPacketReceive(event);
        positionPlace.onPacketReceive(event);
        rotationPlace.onPacketReceive(event);
        duplicateRotPlace.onPacketReceive(event);
        ghostBlockMitigation.onPacketReceive(event);
    }

    public void onPacketSend(final PacketSendEvent event) {
        invalidPlaceA.onPacketSend(event);
        invalidPlaceB.onPacketSend(event);
        airLiquidPlace.onPacketSend(event);
        multiPlace.onPacketSend(event);
        multiActionsF.onPacketSend(event);
        farPlace.onPacketSend(event);
        fabricatedPlace.onPacketSend(event);
        positionPlace.onPacketSend(event);
        rotationPlace.onPacketSend(event);
        duplicateRotPlace.onPacketSend(event);
        ghostBlockMitigation.onPacketSend(event);
    }

    public void onRotationUpdate(final RotationUpdate rotation) {
        invalidPlaceA.process(rotation);
        invalidPlaceB.process(rotation);
        airLiquidPlace.process(rotation);
        multiPlace.process(rotation);
        multiActionsF.process(rotation);
        farPlace.process(rotation);
        fabricatedPlace.process(rotation);
        positionPlace.process(rotation);
        rotationPlace.process(rotation);
        duplicateRotPlace.process(rotation);
        ghostBlockMitigation.process(rotation);
    }

    public void onPredictionFinish(final PredictionComplete complete) {
        invalidPlaceA.onPredictionComplete(complete);
        invalidPlaceB.onPredictionComplete(complete);
        airLiquidPlace.onPredictionComplete(complete);
        multiPlace.onPredictionComplete(complete);
        multiActionsF.onPredictionComplete(complete);
        farPlace.onPredictionComplete(complete);
        fabricatedPlace.onPredictionComplete(complete);
        positionPlace.onPredictionComplete(complete);
        rotationPlace.onPredictionComplete(complete);
        duplicateRotPlace.onPredictionComplete(complete);
        ghostBlockMitigation.onPredictionComplete(complete);
    }

    public void onBlockPlace(final BlockPlace place) {
        invalidPlaceA.onBlockPlace(place);
        invalidPlaceB.onBlockPlace(place);
        airLiquidPlace.onBlockPlace(place);
        multiPlace.onBlockPlace(place);
        multiActionsF.onBlockPlace(place);
        farPlace.onBlockPlace(place);
        fabricatedPlace.onBlockPlace(place);
        positionPlace.onBlockPlace(place);
        rotationPlace.onBlockPlace(place);
        duplicateRotPlace.onBlockPlace(place);
        ghostBlockMitigation.onBlockPlace(place);
    }

    public void onPostFlyingBlockPlace(final BlockPlace place) {
        invalidPlaceA.onPostFlyingBlockPlace(place);
        invalidPlaceB.onPostFlyingBlockPlace(place);
        airLiquidPlace.onPostFlyingBlockPlace(place);
        multiPlace.onPostFlyingBlockPlace(place);
        multiActionsF.onPostFlyingBlockPlace(place);
        farPlace.onPostFlyingBlockPlace(place);
        fabricatedPlace.onPostFlyingBlockPlace(place);
        positionPlace.onPostFlyingBlockPlace(place);
        rotationPlace.onPostFlyingBlockPlace(place);
        duplicateRotPlace.onPostFlyingBlockPlace(place);
        ghostBlockMitigation.onPostFlyingBlockPlace(place);
    }

    @Override
    public Collection<BlockPlaceCheck> getAll() {
        return Arrays.asList(
                invalidPlaceA,
                invalidPlaceB,
                airLiquidPlace,
                multiPlace,
                multiActionsF,
                farPlace,
                fabricatedPlace,
                positionPlace,
                rotationPlace,
                duplicateRotPlace,
                ghostBlockMitigation
        );
    }
}
