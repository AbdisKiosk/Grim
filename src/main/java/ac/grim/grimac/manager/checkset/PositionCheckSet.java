package ac.grim.grimac.manager.checkset;

import ac.grim.grimac.checks.impl.movement.PredictionRunner;
import ac.grim.grimac.checks.type.PositionCheck;
import ac.grim.grimac.player.GrimPlayer;
import ac.grim.grimac.utils.anticheat.update.PositionUpdate;
import ac.grim.grimac.utils.latency.CompensatedCooldown;

import java.util.Arrays;
import java.util.Collection;

public class PositionCheckSet implements CheckSet<PositionCheck> {

    private final PredictionRunner predictionRunner;
    private final CompensatedCooldown compensatedCooldown;

    public PositionCheckSet(GrimPlayer player) {
        this.predictionRunner = new PredictionRunner(player);
        this.compensatedCooldown = new CompensatedCooldown(player);
    }

    public void onPositionUpdate(final PositionUpdate position) {
        predictionRunner.onPositionUpdate(position);
        compensatedCooldown.onPositionUpdate(position);
    }

    @Override
    public Collection<PositionCheck> getAll() {
        return Arrays.asList(
                predictionRunner,
                compensatedCooldown
        );
    }
}
