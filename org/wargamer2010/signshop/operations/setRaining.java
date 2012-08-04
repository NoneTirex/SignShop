package org.wargamer2010.signshop.operations;

import org.bukkit.World;
import org.wargamer2010.signshop.player.SignShopPlayer;
import org.wargamer2010.signshop.util.signshopUtil;

public class setRaining implements SignShopOperation {    
    @Override
    public Boolean setupOperation(SignShopArguments ssArgs) {
        return true;
    }

    @Override
    public Boolean checkRequirements(SignShopArguments ssArgs, Boolean activeCheck) {
        World world = ssArgs.get_ssPlayer().getPlayer().getWorld();
        if(world.hasStorm() && world.isThundering()) {
            ssArgs.get_ssPlayer().sendMessage(signshopUtil.getError("already_raining", ssArgs.messageParts));
            return false;
        }                
        return true;
    }
    
    @Override
    public Boolean runOperation(SignShopArguments ssArgs) {
        World world = ssArgs.get_ssPlayer().getPlayer().getWorld();
        world.setStorm(true);
        world.setThundering(true);

        SignShopPlayer.broadcastMsg(world, signshopUtil.getError("made_rain", ssArgs.messageParts));        
        return true;
    }
}
