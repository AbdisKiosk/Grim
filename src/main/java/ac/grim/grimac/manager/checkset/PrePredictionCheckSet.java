package ac.grim.grimac.manager.checkset;

import ac.grim.grimac.checks.impl.crash.*;
import ac.grim.grimac.checks.impl.exploit.ExploitA;
import ac.grim.grimac.checks.impl.exploit.ExploitB;
import ac.grim.grimac.checks.impl.exploit.ExploitC;
import ac.grim.grimac.checks.impl.movement.TickTimer;
import ac.grim.grimac.checks.impl.movement.TimerCheck;
import ac.grim.grimac.checks.impl.movement.VehicleTimer;
import ac.grim.grimac.checks.type.PacketCheck;
import ac.grim.grimac.player.GrimPlayer;
import com.github.retrooper.packetevents.event.PacketReceiveEvent;
import com.github.retrooper.packetevents.event.PacketSendEvent;

import java.util.Arrays;
import java.util.Collection;

public class PrePredictionCheckSet implements CheckSet<PacketCheck> {

    private final TimerCheck timerCheck;
    private final TickTimer tickTimer;
    private final CrashA crashA;
    private final CrashB crashB;
    private final CrashC crashC;
    private final CrashD crashD;
    private final CrashE crashE;
    private final CrashF crashF;
    private final CrashG crashG;
    private final CrashH crashH;
    private final ExploitA exploitA;
    private final ExploitB exploitB;
    private final ExploitC exploitC;
    private final VehicleTimer vehicleTimer;

    public PrePredictionCheckSet(GrimPlayer player) {
        this.timerCheck = new TimerCheck(player);
        this.tickTimer = new TickTimer(player);
        this.crashA = new CrashA(player);
        this.crashB = new CrashB(player);
        this.crashC = new CrashC(player);
        this.crashD = new CrashD(player);
        this.crashE = new CrashE(player);
        this.crashF = new CrashF(player);
        this.crashG = new CrashG(player);
        this.crashH = new CrashH(player);
        this.exploitA = new ExploitA(player);
        this.exploitB = new ExploitB(player);
        this.exploitC = new ExploitC(player);
        this.vehicleTimer = new VehicleTimer(player);
    }

    public void onPacketReceive(final PacketReceiveEvent packet) {
        timerCheck.onPacketReceive(packet);
        tickTimer.onPacketReceive(packet);
        crashA.onPacketReceive(packet);
        crashB.onPacketReceive(packet);
        crashC.onPacketReceive(packet);
        crashD.onPacketReceive(packet);
        crashE.onPacketReceive(packet);
        crashF.onPacketReceive(packet);
        exploitA.onPacketReceive(packet);
        exploitB.onPacketReceive(packet);
        exploitC.onPacketReceive(packet);
        vehicleTimer.onPacketReceive(packet);
    }

    public void onPacketSend(final PacketSendEvent packet) {
        timerCheck.onPacketSend(packet);
        tickTimer.onPacketSend(packet);
        crashA.onPacketSend(packet);
        crashB.onPacketSend(packet);
        crashC.onPacketSend(packet);
        crashD.onPacketSend(packet);
        crashE.onPacketSend(packet);
        crashF.onPacketSend(packet);
        exploitA.onPacketSend(packet);
        exploitB.onPacketSend(packet);
        exploitC.onPacketSend(packet);
        vehicleTimer.onPacketSend(packet);
    }

    @Override
    public Collection<PacketCheck> getAll() {
        return Arrays.asList(
                timerCheck,
                tickTimer,
                crashA,
                crashB,
                crashC,
                crashD,
                crashE,
                crashF,
                crashG,
                crashH,
                exploitA,
                exploitB,
                exploitC,
                vehicleTimer
        );
    }
}
