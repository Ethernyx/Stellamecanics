package fr.ethernyx.stellamecanics.builders.advancements.forgeStellaire;

import com.google.gson.JsonObject;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import fr.ethernyx.stellamecanics.Stellamecanics;
import fr.ethernyx.stellamecanics.interfaces.IMyCriterion;
import net.minecraft.advancement.AdvancementCriterion;
import net.minecraft.advancement.criterion.AbstractCriterion;
import net.minecraft.predicate.entity.EntityPredicate;
import net.minecraft.predicate.entity.LootContextPredicate;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class ForgeStellaireUsedCriterion extends AbstractCriterion<ForgeStellaireUsedCriterion.Conditions> implements IMyCriterion {

    private static final Identifier ID = Identifier.of(Stellamecanics.MOD_ID, "forge_stellaire_used");

    @Override public Codec<Conditions> getConditionsCodec() { return Conditions.CODEC; }
    @Override public Identifier getId() { return ID; }

    public void trigger(ServerPlayerEntity player, Identifier recipeId) {
        this.trigger(player, conditions -> conditions.matches(recipeId));
    }

    public Conditions create(Identifier recipeId) {
        return new Conditions(recipeId.toString());
    }

    public static class Conditions implements AbstractCriterion.Conditions {
        private final String recipeId;

        public static final Codec<Conditions> CODEC = RecordCodecBuilder.create(instance ->
                instance.group(
                        Codec.STRING.fieldOf("recipe_id").forGetter(c -> c.recipeId)
                ).apply(instance, Conditions::new)
        );

        public Conditions(String recipeId) {
            this.recipeId = recipeId;
        }

        public boolean matches(Identifier recipeId) {
            return this.recipeId.equals(recipeId.toString());
        }

        @Override
        public Optional<LootContextPredicate> player() {
            return Optional.empty();
        }
    }
}