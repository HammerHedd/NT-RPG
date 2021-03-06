package cz.neumimto.rpg.effects.common.positive;

import cz.neumimto.rpg.ClassGenerator;
import cz.neumimto.rpg.effects.EffectBase;
import cz.neumimto.rpg.effects.IEffectConsumer;
import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.entity.living.Living;

/**
 * Created by NeumimTo on 23.12.2015.
 */

@ClassGenerator.Generate(id = "name", inject = false)
public class Invisibility extends EffectBase {

    public static String name = "Invisibility";

    public Invisibility(IEffectConsumer consumer, long duration) {
        super(name, consumer);
        setDuration(duration);
    }

    public Invisibility(IEffectConsumer consumer, long duration, float level) {
        this(consumer, duration);
    }

    @Override
    public void onApply() {
        Living entity = getConsumer().getEntity();
        entity.offer(Keys.INVISIBLE, true);
    }

    @Override
    public void onRemove() {
        Living entity = getConsumer().getEntity();
        entity.offer(Keys.INVISIBLE, false);
    }
}
