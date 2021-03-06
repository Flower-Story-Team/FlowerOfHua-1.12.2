package com.konpi.quantummeteorology.proxy;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import com.konpi.quantummeteorology.common.init.ModGuiLoader;
import com.konpi.quantummeteorology.common.init.ModHandler;
import com.konpi.quantummeteorology.common.init.ModPotions;
import com.konpi.quantummeteorology.common.init.ModStates;
import com.konpi.quantummeteorology.common.init.ModTileEntityLoader;

public class CommonProxy {

	public void preInit(FMLPreInitializationEvent event)
	{
		new ModGuiLoader();
		new ModTileEntityLoader();
		ModPotions.init();
		
		
	}

	public void init(FMLInitializationEvent event) {
		ModStates.init();
		ModHandler.init();
	}

	public void postInit(FMLPostInitializationEvent event) {
	}

}