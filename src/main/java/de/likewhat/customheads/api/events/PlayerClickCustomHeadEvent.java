package de.likewhat.customheads.api.events;

import de.likewhat.customheads.category.CustomHead;
import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

@Getter
public class PlayerClickCustomHeadEvent extends Event implements Cancellable {

    private static HandlerList handlers = new HandlerList();

    private Player player;
    private CustomHead head;

    private boolean cancelled = false;

    public PlayerClickCustomHeadEvent(Player player, CustomHead head) {
        this.player = player;
        this.head = head;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

}
