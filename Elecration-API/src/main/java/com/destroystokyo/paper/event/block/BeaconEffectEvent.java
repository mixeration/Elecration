package com.destroystokyo.paper.event.block;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.block.BlockEvent;
import org.bukkit.potion.PotionEffect;
import org.jetbrains.annotations.NotNull;

/**
 * Called when a beacon effect is being applied to a player.
 */
public class BeaconEffectEvent extends BlockEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;
    private PotionEffect effect;
    private Player player;
    private boolean primary;

    public BeaconEffectEvent(@NotNull Block block, @NotNull PotionEffect effect, @NotNull Player player, boolean primary) {
        super(block);
        this.effect = effect;
        this.player = player;
        this.primary = primary;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    /**
     * Gets the potion effect being applied.
     *
     * @return Potion effect
     */
    @NotNull
    public PotionEffect getEffect() {
        return effect;
    }

    /**
     * Sets the potion effect that will be applied.
     *
     * @param effect Potion effect
     */
    public void setEffect(@NotNull PotionEffect effect) {
        this.effect = effect;
    }

    /**
     * Gets the player who the potion effect is being applied to.
     *
     * @return Affected player
     */
    @NotNull
    public Player getPlayer() {
        return player;
    }

    /**
     * Gets whether the effect is a primary beacon effect.
     *
     * @return true if this event represents a primary effect
     */
    public boolean isPrimary() {
        return primary;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    @NotNull
    public static HandlerList getHandlerList() {
        return handlers;
    }
}