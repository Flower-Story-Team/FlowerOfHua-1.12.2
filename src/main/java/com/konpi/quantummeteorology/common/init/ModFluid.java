package com.konpi.quantummeteorology.common.init;

import com.konpi.quantummeteorology.QuantumMeteorology;
import com.konpi.quantummeteorology.common.fluid.FluidBase;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.ArrayList;

@Mod.EventBusSubscriber
public class ModFluid {

	public static final ArrayList<Fluid> fluidList = new ArrayList<>();

	static {
		// 允许万能桶
		FluidRegistry.enableUniversalBucket();
		fluidList.add(FluidBase.singleTexture("sludge"));
	}

	@SubscribeEvent
	public static void registerFluids(RegistryEvent.Register<Block> event) {
		QuantumMeteorology.logger.info("registering fluids");
		fluidList.forEach(fluid -> {
			FluidRegistry.registerFluid(fluid);
			FluidRegistry.addBucketForFluid(fluid);
		});

		QuantumMeteorology.logger.info("registering fluid blocks");
		ModFluid.fluidList.forEach(fluid -> {
			Block blockFluid = fluid.getBlock();
			if (blockFluid == null) {
				// 默认的流体方块
				blockFluid = new BlockFluidClassic(fluid, Material.WATER).setRegistryName(QuantumMeteorology.MODID,
						fluid.getName());
			}
			event.getRegistry().register(blockFluid);
		});
	}
}
