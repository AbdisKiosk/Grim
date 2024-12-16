package ac.grim.grimac.manager;

import ac.grim.grimac.api.AbstractCheck;
import ac.grim.grimac.checks.impl.badpackets.*;
import ac.grim.grimac.checks.impl.crash.*;
import ac.grim.grimac.checks.impl.groundspoof.NoFallA;
import ac.grim.grimac.checks.impl.movement.*;
import ac.grim.grimac.checks.impl.multiactions.*;
import ac.grim.grimac.checks.impl.prediction.DebugHandler;
import ac.grim.grimac.checks.impl.prediction.OffsetHandler;
import ac.grim.grimac.checks.impl.scaffolding.*;
import ac.grim.grimac.checks.impl.velocity.ExplosionHandler;
import ac.grim.grimac.checks.impl.velocity.KnockbackHandler;
import ac.grim.grimac.checks.type.*;
import ac.grim.grimac.events.packets.PacketEntityReplication;
import ac.grim.grimac.manager.checkset.*;
import ac.grim.grimac.player.GrimPlayer;
import ac.grim.grimac.utils.anticheat.update.*;
import ac.grim.grimac.utils.latency.CompensatedCooldown;
import ac.grim.grimac.utils.latency.CompensatedInventory;
import com.github.retrooper.packetevents.event.PacketReceiveEvent;
import com.github.retrooper.packetevents.event.PacketSendEvent;
import com.google.common.collect.ClassToInstanceMap;
import com.google.common.collect.ImmutableClassToInstanceMap;
import org.bukkit.Bukkit;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionDefault;

import java.util.concurrent.atomic.AtomicBoolean;

public class CheckManager {
    private static boolean inited;
    private static final AtomicBoolean initedAtomic = new AtomicBoolean(false);

    private final PacketCheckSet packetCheckSet;
    private final PositionCheckSet positionCheckSet;
    private final RotationCheckSet rotationCheckSet;
    private final VehicleCheckSet vehicleCheckSet;
    private final PostPredictionCheckSet postPredictionCheckSet;
    private final BlockPlaceCheckSet blockPlaceCheckSet;
    private final BlockBreakCheckSet blockBreakCheckSet;
    private final PrePredictionCheckSet prePredictionCheckSet;


    public ClassToInstanceMap<AbstractCheck> allChecks;

    public CheckManager(GrimPlayer player) {
        // Include post checks in the packet check too
        packetCheckSet = new PacketCheckSet(player);
        positionCheckSet = new PositionCheckSet(player);
        rotationCheckSet = new RotationCheckSet(player);
        vehicleCheckSet = new VehicleCheckSet(player);
        postPredictionCheckSet = new PostPredictionCheckSet(player);
        blockPlaceCheckSet = new BlockPlaceCheckSet(player);
        blockBreakCheckSet = new BlockBreakCheckSet(player);
        prePredictionCheckSet = new PrePredictionCheckSet(player);

        allChecks = new ImmutableClassToInstanceMap.Builder<AbstractCheck>()
                .putAll(packetCheckSet.getClassToInstance())
                .putAll(positionCheckSet.getClassToInstance())
                .putAll(rotationCheckSet.getClassToInstance())
                .putAll(vehicleCheckSet.getClassToInstance())
                .putAll(postPredictionCheckSet.getClassToInstance())
                .putAll(blockPlaceCheckSet.getClassToInstance())
                .putAll(blockBreakCheckSet.getClassToInstance())
                .putAll(prePredictionCheckSet.getClassToInstance())
                .build();

        init();
    }

    @SuppressWarnings("unchecked")
    public <T extends PositionCheck> T getPositionCheck(Class<T> check) {
        return (T) positionCheckSet.get(check);
    }

    @SuppressWarnings("unchecked")
    public <T extends RotationCheck> T getRotationCheck(Class<T> check) {
        return (T) rotationCheckSet.get(check);
    }

    @SuppressWarnings("unchecked")
    public <T extends VehicleCheck> T getVehicleCheck(Class<T> check) {
        return (T) vehicleCheckSet.get(check);
    }

    public void onPrePredictionReceivePacket(final PacketReceiveEvent packet) {
        prePredictionCheckSet.onPacketReceive(packet);
    }

    public void onPacketReceive(final PacketReceiveEvent packet) {
        packetCheckSet.onPacketReceive(packet);
        postPredictionCheckSet.onPacketReceive(packet);
        blockPlaceCheckSet.onPacketReceive(packet);
        blockPlaceCheckSet.onPacketReceive(packet);
    }

    public void onPacketSend(final PacketSendEvent packet) {
        prePredictionCheckSet.onPacketSend(packet);
        packetCheckSet.onPacketSend(packet);
        postPredictionCheckSet.onPacketSend(packet);
        blockPlaceCheckSet.onPacketSend(packet);
        blockPlaceCheckSet.onPacketSend(packet);
    }

    public void onPositionUpdate(final PositionUpdate position) {
        positionCheckSet.onPositionUpdate(position);
    }

    public void onRotationUpdate(final RotationUpdate rotation) {
        rotationCheckSet.onRotationUpdate(rotation);
        blockPlaceCheckSet.onRotationUpdate(rotation);
    }

    public void onVehiclePositionUpdate(final VehiclePositionUpdate update) {
        vehicleCheckSet.onVehiclePositionUpdate(update);
    }

    public void onPredictionFinish(final PredictionComplete complete) {
        postPredictionCheckSet.onPredictionFinish(complete);
        blockPlaceCheckSet.onPredictionFinish(complete);
        blockBreakCheckSet.onPredictionFinish(complete);
    }

    public void onBlockPlace(final BlockPlace place) {
        blockPlaceCheckSet.onBlockPlace(place);
    }

    public void onPostFlyingBlockPlace(final BlockPlace place) {
        blockPlaceCheckSet.onPostFlyingBlockPlace(place);
    }

    public void onBlockBreak(final BlockBreak blockBreak) {
        blockBreakCheckSet.onBlockBreak(blockBreak);
    }

    public ExplosionHandler getExplosionHandler() {
        return getPostPredictionCheck(ExplosionHandler.class);
    }

    @SuppressWarnings("unchecked")
    public <T extends PacketCheck> T getPacketCheck(Class<T> check) {
        return (T) packetCheckSet.get(check);
    }

    @SuppressWarnings("unchecked")
    public <T extends PacketCheck> T getPrePredictionCheck(Class<T> check) {
        return (T) prePredictionCheckSet.get(check);
    }

    private PacketEntityReplication packetEntityReplication = null;

    public PacketEntityReplication getEntityReplication() {
        if (packetEntityReplication == null) packetEntityReplication = getPacketCheck(PacketEntityReplication.class);
        return packetEntityReplication;
    }

    public NoFallA getNoFall() {
        return getPacketCheck(NoFallA.class);
    }

    private CompensatedInventory inventory = null;

    public CompensatedInventory getInventory() {
        if (inventory == null) inventory = getPacketCheck(CompensatedInventory.class);
        return inventory;
    }

    public KnockbackHandler getKnockbackHandler() {
        return getPostPredictionCheck(KnockbackHandler.class);
    }

    public CompensatedCooldown getCompensatedCooldown() {
        return getPositionCheck(CompensatedCooldown.class);
    }

    public NoSlowA getNoSlow() {
        return getPostPredictionCheck(NoSlowA.class);
    }

    public SetbackTeleportUtil getSetbackUtil() {
        return getPostPredictionCheck(SetbackTeleportUtil.class);
    }

    public DebugHandler getDebugHandler() {
        return getPostPredictionCheck(DebugHandler.class);
    }

    public OffsetHandler getOffsetHandler() {
        return getPostPredictionCheck(OffsetHandler.class);
    }

    @SuppressWarnings("unchecked")
    public <T extends PostPredictionCheck> T getPostPredictionCheck(Class<T> check) {
        return (T) postPredictionCheckSet.get(check);
    }

    private void init() {
        // Fast non-thread safe check
        if (inited) return;
        // Slow thread safe check
        if (!initedAtomic.compareAndSet(false, true)) return;
        inited = true;

        for (AbstractCheck check : allChecks.values()) {
            if (check.getCheckName() != null) {
                String permissionName = "grim.exempt." + check.getCheckName().toLowerCase();
                Permission permission = Bukkit.getPluginManager().getPermission(permissionName);

                if (permission == null) {
                    Bukkit.getPluginManager().addPermission(new Permission(permissionName, PermissionDefault.FALSE));
                } else {
                    permission.setDefault(PermissionDefault.FALSE);
                }
            }
        }
    }
}
