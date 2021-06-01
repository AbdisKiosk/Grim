package ac.grim.grimac.events.packets;

import ac.grim.grimac.GrimAC;
import ac.grim.grimac.checks.packets.OnGroundCorrector;
import ac.grim.grimac.player.GrimPlayer;
import ac.grim.grimac.predictionengine.MovementCheckRunner;
import ac.grim.grimac.utils.data.PredictionData;
import io.github.retrooper.packetevents.event.PacketListenerDynamic;
import io.github.retrooper.packetevents.event.impl.PacketPlayReceiveEvent;
import io.github.retrooper.packetevents.event.priority.PacketEventPriority;
import io.github.retrooper.packetevents.packettype.PacketType;
import io.github.retrooper.packetevents.packetwrappers.play.in.flying.WrappedPacketInFlying;
import io.github.retrooper.packetevents.packetwrappers.play.in.steervehicle.WrappedPacketInSteerVehicle;
import io.github.retrooper.packetevents.packetwrappers.play.in.vehiclemove.WrappedPacketInVehicleMove;

public class PacketPositionListener extends PacketListenerDynamic {
    public PacketPositionListener() {
        super(PacketEventPriority.MONITOR);
    }

    @Override
    public void onPacketPlayReceive(PacketPlayReceiveEvent event) {
        byte packetID = event.getPacketId();

        if (packetID == PacketType.Play.Client.POSITION) {
            WrappedPacketInFlying position = new WrappedPacketInFlying(event.getNMSPacket());
            GrimPlayer player = GrimAC.playerGrimHashMap.get(event.getPlayer());
            if (player == null) return;

            OnGroundCorrector.correctMovement(position, position.getY());

            MovementCheckRunner.processAndCheckMovementPacket(new PredictionData(player, position.getX(), position.getY(), position.getZ(), player.packetStateData.packetPlayerXRot, player.packetStateData.packetPlayerYRot, position.isOnGround()));
        }

        if (packetID == PacketType.Play.Client.POSITION_LOOK) {
            WrappedPacketInFlying position = new WrappedPacketInFlying(event.getNMSPacket());
            GrimPlayer player = GrimAC.playerGrimHashMap.get(event.getPlayer());
            if (player == null) return;

            OnGroundCorrector.correctMovement(position, position.getY());

            MovementCheckRunner.processAndCheckMovementPacket(new PredictionData(player, position.getX(), position.getY(), position.getZ(), position.getYaw(), position.getPitch(), position.isOnGround()));
        }

        if (packetID == PacketType.Play.Client.LOOK) {
            WrappedPacketInFlying position = new WrappedPacketInFlying(event.getNMSPacket());
            GrimPlayer player = GrimAC.playerGrimHashMap.get(event.getPlayer());
            if (player == null) return;

            OnGroundCorrector.correctMovement(position, player.y);

            // TODO: This isn't async safe
            if (player.bukkitPlayer.getVehicle() != null) return;

            MovementCheckRunner.processAndCheckMovementPacket(new PredictionData(player,
                    player.packetStateData.packetPlayerX, player.packetStateData.packetPlayerY, player.packetStateData.packetPlayerZ,
                    position.getYaw(), position.getPitch(), position.isOnGround()));
        }

        if (packetID == PacketType.Play.Client.FLYING) {
            WrappedPacketInFlying position = new WrappedPacketInFlying(event.getNMSPacket());
            GrimPlayer player = GrimAC.playerGrimHashMap.get(event.getPlayer());
            if (player == null) return;

            OnGroundCorrector.correctMovement(position, player.y);

            MovementCheckRunner.processAndCheckMovementPacket(new PredictionData(player,
                    player.packetStateData.packetPlayerX, player.packetStateData.packetPlayerY, player.packetStateData.packetPlayerZ,
                    player.packetStateData.packetPlayerXRot, player.packetStateData.packetPlayerYRot, position.isOnGround()));
        }

        if (packetID == PacketType.Play.Client.STEER_VEHICLE) {
            WrappedPacketInSteerVehicle steer = new WrappedPacketInSteerVehicle(event.getNMSPacket());
            GrimPlayer player = GrimAC.playerGrimHashMap.get(event.getPlayer());
            if (player == null) return;
            player.packetStateData.packetVehicleForward = steer.getForwardValue();
            player.packetStateData.packetVehicleHorizontal = steer.getSideValue();
        }

        if (packetID == PacketType.Play.Client.VEHICLE_MOVE) {
            WrappedPacketInVehicleMove move = new WrappedPacketInVehicleMove(event.getNMSPacket());
            GrimPlayer player = GrimAC.playerGrimHashMap.get(event.getPlayer());
            if (player == null) return;

            MovementCheckRunner.processAndCheckMovementPacket(new PredictionData(player, move.getX(), move.getY(), move.getZ(), move.getYaw(), move.getPitch()));
        }
    }
}