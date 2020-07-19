package com.kongpi.flower.common.handler;

import com.kongpi.flower.Flower;
import com.kongpi.flower.api.IPlayerState;
import com.kongpi.flower.api.capabilities.Capabilities;
import com.kongpi.flower.api.capabilities.CapabilityProvider;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.Phase;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class CapabilityHandler {
	@SubscribeEvent
	public void onAttachEntityCapabilities(AttachCapabilitiesEvent<Entity> event) {
		if (event.getObject() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.getObject();
			// thirst
			Capability cap = Capabilities.THIRST;
			ResourceLocation loc = new ResourceLocation(Flower.MODID, cap.getName());
			if (!event.getCapabilities().containsKey(loc)) {
				event.addCapability(loc, new CapabilityProvider(cap));
			}
			// temperature
		}
	}

	@SubscribeEvent
	public void onAttachItemCapabilities(AttachCapabilitiesEvent<Item> event) {

	}

	@SubscribeEvent
	public void onAttachTileCapabilities(AttachCapabilitiesEvent<TileEntity> event) {

	}

	@SubscribeEvent
	public void onPlayerTick(PlayerTickEvent event) {
		EntityPlayer player = event.player;
		World world = player.world;

		if (!world.isRemote) {
			// thirst
			Capability cap = Capabilities.THIRST;
			IPlayerState state = (IPlayerState) player.getCapability(cap, null);
			state.update(player, world, event.phase);
			if (event.phase == Phase.START) {
				if (state.hasChanged()) {
					player.getEntityData().setTag(cap.getName(), cap.getStorage().writeNBT(cap, state, null));
					state.onSendClientUpdate();
				}
			}
			// temperature
		}
	}

	@SubscribeEvent
	public void onBlockBreak(BlockEvent.BreakEvent event) {
		World world = event.getWorld();
		EntityPlayer player = event.getPlayer();
		BlockPos pos = event.getPos();
		IBlockState blockstate = event.getState();
		if (!world.isRemote && !player.isCreative()) {
			boolean canHarvestBlock = blockstate.getBlock().canHarvestBlock(world, pos, player);
			if (canHarvestBlock) {
				// thirst
				Capability cap = Capabilities.THIRST;
				IPlayerState state = (IPlayerState) player.getCapability(cap, null);
				state.BreakBlock(player, world);
				// temperature
			}
		}
	}

}