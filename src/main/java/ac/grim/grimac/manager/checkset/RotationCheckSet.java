package ac.grim.grimac.manager.checkset;

import ac.grim.grimac.checks.impl.aim.AimDuplicateLook;
import ac.grim.grimac.checks.impl.aim.AimModulo360;
import ac.grim.grimac.checks.impl.aim.processor.AimProcessor;
import ac.grim.grimac.checks.type.RotationCheck;
import ac.grim.grimac.player.GrimPlayer;
import ac.grim.grimac.utils.anticheat.update.RotationUpdate;

import java.util.Arrays;
import java.util.Collection;

public class RotationCheckSet implements CheckSet<RotationCheck> {

    private final AimProcessor aimProcessor;
    private final AimModulo360 aimModulo360;
    private final AimDuplicateLook aimDuplicateLook;

    public RotationCheckSet(GrimPlayer player) {
        this.aimProcessor = new AimProcessor(player);
        this.aimModulo360 = new AimModulo360(player);
        this.aimDuplicateLook = new AimDuplicateLook(player);
    }

    public void onRotationUpdate(final RotationUpdate rotation) {
        aimProcessor.process(rotation);
        aimModulo360.process(rotation);
        aimDuplicateLook.process(rotation);
    }

        @Override
    public Collection<RotationCheck> getAll() {
        return Arrays.asList(
                aimProcessor,
                aimModulo360,
                aimDuplicateLook
        );
    }
}
