package com.konpi.flower.common.temperature.modifier;

import com.konpi.flower.api.temperature.Temperature;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
//
// public class SeasonModifier extends TemperatureModifier
// {
// public SeasonModifier(String id)
// {
// super(id);
// }
//
// @Override
// public Temperature applyEnvironmentModifiers(World world, BlockPos pos,
// Temperature initialTemperature, IModifierMonitor monitor)
// {
// int temperatureLevel = initialTemperature.getRawValue();
// SeasonState season = SeasonHelper.getSeasonState(world).getSubSeason();
//
// if (world.provider.isSurfaceWorld())
// {
// int temperatureModifier = 0;
// switch (season)
// {
// case EARLY_SPRING:
// temperatureModifier = ModConfig.temperature.earlySpringModifier;
// break;
//
// case MID_SPRING:
// temperatureModifier = ModConfig.temperature.midSpringModifier;
// break;
//
// case LATE_SPRING:
// temperatureModifier = ModConfig.temperature.lateSpringModifier;
// break;
//
// case EARLY_SUMMER:
// temperatureModifier = ModConfig.temperature.earlySummerModifier;
// break;
//
// case MID_SUMMER:
// temperatureModifier = ModConfig.temperature.midSummerModifier;
// break;
//
// case LATE_SUMMER:
// temperatureModifier = ModConfig.temperature.lateSummerModifier;
// break;
//
// case EARLY_AUTUMN:
// temperatureModifier = ModConfig.temperature.earlyAutumnModifier;
// break;
//
// case MID_AUTUMN:
// temperatureModifier = ModConfig.temperature.midAutumnModifier;
// break;
//
// case LATE_AUTUMN:
// temperatureModifier = ModConfig.temperature.lateAutumnModifier;
// break;
//
// case EARLY_WINTER:
// temperatureModifier = ModConfig.temperature.earlyWinterModifier;
// break;
//
// case MID_WINTER:
// temperatureModifier = ModConfig.temperature.midWinterModifier;
// break;
//
// case LATE_WINTER:
// temperatureModifier = ModConfig.temperature.lateWinterModifier;
// break;
//
// default:
// break;
// }
//
// // Apply underground coefficient
// if (ModConfig.temperature.enableUndergroundEffect)
// temperatureModifier =
// Math.round(TerrainUtils.getAverageUndergroundCoefficient(world, pos) *
// temperatureModifier);
// temperatureLevel += temperatureModifier;
// }
// monitor.addEntry(new IModifierMonitor.Context(this.getId(), "Season",
// initialTemperature, new Temperature(temperatureLevel)));
//
// return new Temperature(temperatureLevel);
// }
//
// @Override
// public boolean isPlayerSpecific()
// {
// return false;
// }

// }
