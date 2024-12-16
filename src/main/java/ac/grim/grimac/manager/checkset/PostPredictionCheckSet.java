package ac.grim.grimac.manager.checkset;

import ac.grim.grimac.checks.impl.combat.MultiInteractA;
import ac.grim.grimac.checks.impl.combat.MultiInteractB;
import ac.grim.grimac.checks.impl.movement.*;
import ac.grim.grimac.checks.impl.post.Post;
import ac.grim.grimac.checks.impl.prediction.DebugHandler;
import ac.grim.grimac.checks.impl.prediction.NoFallB;
import ac.grim.grimac.checks.impl.prediction.OffsetHandler;
import ac.grim.grimac.checks.impl.prediction.Phase;
import ac.grim.grimac.checks.impl.velocity.ExplosionHandler;
import ac.grim.grimac.checks.impl.velocity.KnockbackHandler;
import ac.grim.grimac.checks.type.PostPredictionCheck;
import ac.grim.grimac.manager.LastInstanceManager;
import ac.grim.grimac.manager.SetbackTeleportUtil;
import ac.grim.grimac.manager.init.start.SuperDebug;
import ac.grim.grimac.player.GrimPlayer;
import ac.grim.grimac.predictionengine.GhostBlockDetector;
import ac.grim.grimac.predictionengine.SneakingEstimator;
import ac.grim.grimac.utils.anticheat.update.PredictionComplete;
import ac.grim.grimac.utils.latency.CompensatedFireworks;
import com.github.retrooper.packetevents.event.PacketReceiveEvent;
import com.github.retrooper.packetevents.event.PacketSendEvent;

import java.util.Arrays;
import java.util.Collection;

public class PostPredictionCheckSet implements CheckSet<PostPredictionCheck> {

    private final NegativeTimerCheck negativeTimerCheck;
    private final ExplosionHandler explosionHandler;
    private final KnockbackHandler knockbackHandler;
    private final GhostBlockDetector ghostBlockDetector;
    private final Phase phase;
    private final Post post;
    private final NoFallB noFallB;
    private final OffsetHandler offsetHandler;
    private final SuperDebug superDebug;
    private final DebugHandler debugHandler;
    private final EntityControl entityControl;
    private final NoSlowA noSlowA;
    private final NoSlowC noSlowC;
    private final NoSlowD noSlowD;
    private final NoSlowE noSlowE;
    private final MultiInteractA multiInteractA;
    private final MultiInteractB multiInteractB;
    private final SetbackTeleportUtil setbackTeleportUtil;
    private final CompensatedFireworks compensatedFireworks;
    private final SneakingEstimator sneakingEstimator;
    private final LastInstanceManager lastInstanceManager;

    public PostPredictionCheckSet(GrimPlayer player) {
        this.negativeTimerCheck = new NegativeTimerCheck(player);
        this.explosionHandler = new ExplosionHandler(player);
        this.knockbackHandler = new KnockbackHandler(player);
        this.ghostBlockDetector = new GhostBlockDetector(player);
        this.phase = new Phase(player);
        this.post = new Post(player);
        this.noFallB = new NoFallB(player);
        this.offsetHandler = new OffsetHandler(player);
        this.superDebug = new SuperDebug(player);
        this.debugHandler = new DebugHandler(player);
        this.entityControl = new EntityControl(player);
        this.noSlowA = new NoSlowA(player);
        this.noSlowC = new NoSlowC(player);
        this.noSlowD = new NoSlowD(player);
        this.noSlowE = new NoSlowE(player);
        this.multiInteractA = new MultiInteractA(player);
        this.multiInteractB = new MultiInteractB(player);
        this.setbackTeleportUtil = new SetbackTeleportUtil(player);
        this.compensatedFireworks = player.compensatedFireworks;
        this.sneakingEstimator = new SneakingEstimator(player);
        this.lastInstanceManager = player.lastInstanceManager;
    }

    public void onPacketReceive(final PacketReceiveEvent packet) {
        negativeTimerCheck.onPacketReceive(packet);
        explosionHandler.onPacketReceive(packet);
        knockbackHandler.onPacketReceive(packet);
        ghostBlockDetector.onPacketReceive(packet);
        phase.onPacketReceive(packet);
        post.onPacketReceive(packet);
        noFallB.onPacketReceive(packet);
        offsetHandler.onPacketReceive(packet);
        superDebug.onPacketReceive(packet);
        debugHandler.onPacketReceive(packet);
        entityControl.onPacketReceive(packet);
        noSlowA.onPacketReceive(packet);
        noSlowC.onPacketReceive(packet);
        noSlowD.onPacketReceive(packet);
        noSlowE.onPacketReceive(packet);
        multiInteractA.onPacketReceive(packet);
        multiInteractB.onPacketReceive(packet);
        setbackTeleportUtil.onPacketReceive(packet);
        compensatedFireworks.onPacketReceive(packet);
        sneakingEstimator.onPacketReceive(packet);
        lastInstanceManager.onPacketReceive(packet);
    }

    public void onPacketSend(final PacketSendEvent packet) {
        negativeTimerCheck.onPacketSend(packet);
        explosionHandler.onPacketSend(packet);
        knockbackHandler.onPacketSend(packet);
        ghostBlockDetector.onPacketSend(packet);
        phase.onPacketSend(packet);
        post.onPacketSend(packet);
        noFallB.onPacketSend(packet);
        offsetHandler.onPacketSend(packet);
        superDebug.onPacketSend(packet);
        debugHandler.onPacketSend(packet);
        entityControl.onPacketSend(packet);
        noSlowA.onPacketSend(packet);
        noSlowC.onPacketSend(packet);
        noSlowD.onPacketSend(packet);
        noSlowE.onPacketSend(packet);
        multiInteractA.onPacketSend(packet);
        multiInteractB.onPacketSend(packet);
        setbackTeleportUtil.onPacketSend(packet);
        compensatedFireworks.onPacketSend(packet);
        sneakingEstimator.onPacketSend(packet);
        lastInstanceManager.onPacketSend(packet);
    }

    public void onPredictionFinish(final PredictionComplete complete) {
        negativeTimerCheck.onPredictionComplete(complete);
        explosionHandler.onPredictionComplete(complete);
        knockbackHandler.onPredictionComplete(complete);
        ghostBlockDetector.onPredictionComplete(complete);
        phase.onPredictionComplete(complete);
        post.onPredictionComplete(complete);
        noFallB.onPredictionComplete(complete);
        offsetHandler.onPredictionComplete(complete);
        superDebug.onPredictionComplete(complete);
        debugHandler.onPredictionComplete(complete);
        entityControl.onPredictionComplete(complete);
        noSlowA.onPredictionComplete(complete);
        noSlowC.onPredictionComplete(complete);
        noSlowD.onPredictionComplete(complete);
        noSlowE.onPredictionComplete(complete);
        multiInteractA.onPredictionComplete(complete);
        multiInteractB.onPredictionComplete(complete);
        setbackTeleportUtil.onPredictionComplete(complete);
        compensatedFireworks.onPredictionComplete(complete);
        sneakingEstimator.onPredictionComplete(complete);
        lastInstanceManager.onPredictionComplete(complete);
    }

        @Override
    public Collection<PostPredictionCheck> getAll() {
        return Arrays.asList(
                negativeTimerCheck,
                explosionHandler,
                knockbackHandler,
                ghostBlockDetector,
                phase,
                post,
                noFallB,
                offsetHandler,
                superDebug,
                debugHandler,
                entityControl,
                noSlowA,
                noSlowC,
                noSlowD,
                noSlowE,
                multiInteractA,
                multiInteractB,
                setbackTeleportUtil,
                compensatedFireworks,
                sneakingEstimator,
                lastInstanceManager
        );
    }
}
