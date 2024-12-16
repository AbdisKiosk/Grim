package ac.grim.grimac.manager.checkset;

import ac.grim.grimac.checks.impl.movement.VehiclePredictionRunner;
import ac.grim.grimac.checks.type.VehicleCheck;
import ac.grim.grimac.player.GrimPlayer;
import ac.grim.grimac.utils.anticheat.update.VehiclePositionUpdate;

import java.util.Arrays;
import java.util.Collection;

public class VehicleCheckSet implements CheckSet<VehicleCheck> {

    private final VehiclePredictionRunner vehiclePredictionRunner;

    public VehicleCheckSet(GrimPlayer player) {
        this.vehiclePredictionRunner = new VehiclePredictionRunner(player);
    }

    public void onVehiclePositionUpdate(final VehiclePositionUpdate update) {
        vehiclePredictionRunner.process(update);
    }

        @Override
    public Collection<VehicleCheck> getAll() {
        return Arrays.asList(
                vehiclePredictionRunner
        );
    }
}
