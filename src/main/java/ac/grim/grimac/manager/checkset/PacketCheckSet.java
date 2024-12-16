package ac.grim.grimac.manager.checkset;

import ac.grim.grimac.checks.impl.badpackets.*;
import ac.grim.grimac.checks.impl.combat.Reach;
import ac.grim.grimac.checks.impl.groundspoof.NoFallA;
import ac.grim.grimac.checks.impl.misc.ClientBrand;
import ac.grim.grimac.checks.impl.misc.TransactionOrder;
import ac.grim.grimac.checks.impl.movement.NoSlowB;
import ac.grim.grimac.checks.impl.movement.SetbackBlocker;
import ac.grim.grimac.checks.impl.multiactions.*;
import ac.grim.grimac.checks.type.PacketCheck;
import ac.grim.grimac.events.packets.PacketChangeGameState;
import ac.grim.grimac.events.packets.PacketEntityReplication;
import ac.grim.grimac.events.packets.PacketPlayerAbilities;
import ac.grim.grimac.events.packets.PacketWorldBorder;
import ac.grim.grimac.manager.ActionManager;
import ac.grim.grimac.player.GrimPlayer;
import ac.grim.grimac.utils.latency.CompensatedInventory;
import ac.grim.grimac.utils.team.TeamHandler;
import com.github.retrooper.packetevents.event.PacketReceiveEvent;
import com.github.retrooper.packetevents.event.PacketSendEvent;

import java.util.Arrays;
import java.util.Collection;

public class PacketCheckSet implements CheckSet<PacketCheck> {

    private final Reach reach;
    private final PacketEntityReplication packetEntityReplication;
    private final PacketChangeGameState packetChangeGameState;
    private final CompensatedInventory compensatedInventory;
    private final PacketPlayerAbilities packetPlayerAbilities;
    private final PacketWorldBorder packetWorldBorder;
    private final ActionManager actionManager;
    private final TeamHandler teamHandler;
    private final ClientBrand clientBrand;
    private final NoFallA noFallA;
    private final BadPacketsO badPacketsO;
    private final BadPacketsA badPacketsA;
    private final BadPacketsB badPacketsB;
    private final BadPacketsC badPacketsC;
    private final BadPacketsD badPacketsD;
    private final BadPacketsE badPacketsE;
    private final BadPacketsF badPacketsF;
    private final BadPacketsG badPacketsG;
    private final BadPacketsH badPacketsH;
    private final BadPacketsI badPacketsI;
    private final BadPacketsJ badPacketsJ;
    private final BadPacketsK badPacketsK;
    private final BadPacketsL badPacketsL;
    private final BadPacketsM badPacketsM;
    private final BadPacketsN badPacketsN;
    private final BadPacketsP badPacketsP;
    private final BadPacketsQ badPacketsQ;
    private final BadPacketsR badPacketsR;
    private final BadPacketsS badPacketsS;
    private final BadPacketsT badPacketsT;
    private final BadPacketsU badPacketsU;
    private final BadPacketsW badPacketsW;
    private final BadPacketsY badPacketsY;
    private final MultiActionsA multiActionsA;
    private final MultiActionsB multiActionsB;
    private final MultiActionsC multiActionsC;
    private final MultiActionsD multiActionsD;
    private final MultiActionsE multiActionsE;
    private final TransactionOrder transactionOrder;
    private final NoSlowB noSlowB;
    private final SetbackBlocker setbackBlocker;

    public PacketCheckSet(GrimPlayer player) {
        this.reach = new Reach(player);
        this.packetEntityReplication = new PacketEntityReplication(player);
        this.packetChangeGameState = new PacketChangeGameState(player);
        this.compensatedInventory = new CompensatedInventory(player);
        this.packetPlayerAbilities = new PacketPlayerAbilities(player);
        this.packetWorldBorder = new PacketWorldBorder(player);
        this.actionManager = player.actionManager;
        this.teamHandler = new TeamHandler(player);
        this.clientBrand = new ClientBrand(player);
        this.noFallA = new NoFallA(player);
        this.badPacketsO = new BadPacketsO(player);
        this.badPacketsA = new BadPacketsA(player);
        this.badPacketsB = new BadPacketsB(player);
        this.badPacketsC = new BadPacketsC(player);
        this.badPacketsD = new BadPacketsD(player);
        this.badPacketsE = new BadPacketsE(player);
        this.badPacketsF = new BadPacketsF(player);
        this.badPacketsG = new BadPacketsG(player);
        this.badPacketsH = new BadPacketsH(player);
        this.badPacketsI = new BadPacketsI(player);
        this.badPacketsJ = new BadPacketsJ(player);
        this.badPacketsK = new BadPacketsK(player);
        this.badPacketsL = new BadPacketsL(player);
        this.badPacketsM = new BadPacketsM(player);
        this.badPacketsN = new BadPacketsN(player);
        this.badPacketsP = new BadPacketsP(player);
        this.badPacketsQ = new BadPacketsQ(player);
        this.badPacketsR = new BadPacketsR(player);
        this.badPacketsS = new BadPacketsS(player);
        this.badPacketsT = new BadPacketsT(player);
        this.badPacketsU = new BadPacketsU(player);
        this.badPacketsW = new BadPacketsW(player);
        this.badPacketsY = new BadPacketsY(player);
        this.multiActionsA = new MultiActionsA(player);
        this.multiActionsB = new MultiActionsB(player);
        this.multiActionsC = new MultiActionsC(player);
        this.multiActionsD = new MultiActionsD(player);
        this.multiActionsE = new MultiActionsE(player);
        this.transactionOrder = new TransactionOrder(player);
        this.noSlowB = new NoSlowB(player);
        this.setbackBlocker = new SetbackBlocker(player);
    }

    public void onPacketReceive(final PacketReceiveEvent event) {
        reach.onPacketReceive(event);
        packetEntityReplication.onPacketReceive(event);
        packetChangeGameState.onPacketReceive(event);
        compensatedInventory.onPacketReceive(event);
        packetPlayerAbilities.onPacketReceive(event);
        packetWorldBorder.onPacketReceive(event);
        actionManager.onPacketReceive(event);
        teamHandler.onPacketReceive(event);
        clientBrand.onPacketReceive(event);
        noFallA.onPacketReceive(event);
        badPacketsO.onPacketReceive(event);
        badPacketsA.onPacketReceive(event);
        badPacketsB.onPacketReceive(event);
        badPacketsC.onPacketReceive(event);
        badPacketsD.onPacketReceive(event);
        badPacketsE.onPacketReceive(event);
        badPacketsF.onPacketReceive(event);
        badPacketsG.onPacketReceive(event);
        badPacketsH.onPacketReceive(event);
        badPacketsI.onPacketReceive(event);
        badPacketsJ.onPacketReceive(event);
        badPacketsK.onPacketReceive(event);
        badPacketsL.onPacketReceive(event);
        badPacketsM.onPacketReceive(event);
        badPacketsN.onPacketReceive(event);
        badPacketsP.onPacketReceive(event);
        badPacketsQ.onPacketReceive(event);
        badPacketsR.onPacketReceive(event);
        badPacketsS.onPacketReceive(event);
        badPacketsT.onPacketReceive(event);
        badPacketsU.onPacketReceive(event);
        badPacketsW.onPacketReceive(event);
        badPacketsY.onPacketReceive(event);
        multiActionsA.onPacketReceive(event);
        multiActionsB.onPacketReceive(event);
        multiActionsC.onPacketReceive(event);
        multiActionsD.onPacketReceive(event);
        multiActionsE.onPacketReceive(event);
        transactionOrder.onPacketReceive(event);
        noSlowB.onPacketReceive(event);
        setbackBlocker.onPacketReceive(event);
    }

    public void onPacketSend(final PacketSendEvent event) {
        reach.onPacketSend(event);
        packetEntityReplication.onPacketSend(event);
        packetChangeGameState.onPacketSend(event);
        compensatedInventory.onPacketSend(event);
        packetPlayerAbilities.onPacketSend(event);
        packetWorldBorder.onPacketSend(event);
        actionManager.onPacketSend(event);
        teamHandler.onPacketSend(event);
        clientBrand.onPacketSend(event);
        noFallA.onPacketSend(event);
        badPacketsO.onPacketSend(event);
        badPacketsA.onPacketSend(event);
        badPacketsB.onPacketSend(event);
        badPacketsC.onPacketSend(event);
        badPacketsD.onPacketSend(event);
        badPacketsE.onPacketSend(event);
        badPacketsF.onPacketSend(event);
        badPacketsG.onPacketSend(event);
        badPacketsH.onPacketSend(event);
        badPacketsI.onPacketSend(event);
        badPacketsJ.onPacketSend(event);
        badPacketsK.onPacketSend(event);
        badPacketsL.onPacketSend(event);
        badPacketsM.onPacketSend(event);
        badPacketsN.onPacketSend(event);
        badPacketsP.onPacketSend(event);
        badPacketsQ.onPacketSend(event);
        badPacketsR.onPacketSend(event);
        badPacketsS.onPacketSend(event);
        badPacketsT.onPacketSend(event);
        badPacketsU.onPacketSend(event);
        badPacketsW.onPacketSend(event);
        badPacketsY.onPacketSend(event);
        multiActionsA.onPacketSend(event);
        multiActionsB.onPacketSend(event);
        multiActionsC.onPacketSend(event);
        multiActionsD.onPacketSend(event);
        multiActionsE.onPacketSend(event);
        transactionOrder.onPacketSend(event);
        noSlowB.onPacketSend(event);
        setbackBlocker.onPacketSend(event);
    }

    @Override
    public Collection<ac.grim.grimac.checks.type.PacketCheck> getAll() {
        return Arrays.asList(
                reach,
                packetEntityReplication,
                packetChangeGameState,
                compensatedInventory,
                packetPlayerAbilities,
                packetWorldBorder,
                actionManager,
                teamHandler,
                clientBrand,
                noFallA,
                badPacketsO,
                badPacketsA,
                badPacketsB,
                badPacketsC,
                badPacketsD,
                badPacketsE,
                badPacketsF,
                badPacketsG,
                badPacketsH,
                badPacketsI,
                badPacketsJ,
                badPacketsK,
                badPacketsL,
                badPacketsM,
                badPacketsN,
                badPacketsP,
                badPacketsQ,
                badPacketsR,
                badPacketsS,
                badPacketsT,
                badPacketsU,
                badPacketsW,
                badPacketsY,
                multiActionsA,
                multiActionsB,
                multiActionsC,
                multiActionsD,
                multiActionsE,
                transactionOrder,
                noSlowB,
                setbackBlocker
        );
    }
}
