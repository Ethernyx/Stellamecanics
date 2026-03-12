package fr.ethernyx.stellamecanics.init;

import fr.ethernyx.stellamecanics.Stellamecanics;
import fr.ethernyx.stellamecanics.builders.advancements.forgeStellaire.ForgeStellaireUsedCriterion;
import fr.ethernyx.stellamecanics.interfaces.IMyCriterion;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.util.Identifier;

public class ModCriteria {
    public static final ForgeStellaireUsedCriterion FORGE_STELLAIRE_USED = newCriterion(new ForgeStellaireUsedCriterion());

    public static <T extends net.minecraft.advancement.criterion.Criterion<?> & IMyCriterion> T newCriterion(T criterion) {
        Criteria.register(
                criterion.getId().toString(),
                criterion
        );
        return criterion;
    }

    public static void registerModCriteria() { Stellamecanics.LOGGER.debug("Registering Mod Criteria for " + Stellamecanics.MOD_ID); }
}
