package com.konpi.flower.item;

import com.konpi.flower.Flower;
import com.konpi.flower.block.BlockRegistry;
import com.konpi.flower.init.*;
import com.konpi.flower.item.item.ItemFoodInBowl;
import com.konpi.flower.tabs.ModCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

import java.util.ArrayList;

@Mod.EventBusSubscriber
public class ItemRegistry
{
	//装普通物品的容器
    public static final ArrayList<Item> simpleItemList = new ArrayList<>();

    //在这里往容器里添加物品, 加进去就自动注册了
    static
    {
        //实例化普通物品
    	Flower.logger.info("initializing normal items");
        
    	
    	//种子
        simpleItemList.add(new ModItemBase("rice_seed").setCreativeTab(ModCreativeTabs.MISC)); //水稻种子
        
        
        //食材
        simpleItemList.add(new ModFoodBase("chinese_cabbage", 1, 0.6F, false));		//白菜
        simpleItemList.add(new ModFoodBase("tomato", 1, 0.6F, false));                  //番茄	
        simpleItemList.add(new ModFoodBase("peanut", 1, 0.6F, false));                  //花生	
        simpleItemList.add(new ModItemBase("rice").setCreativeTab(ModCreativeTabs.MISC)); //大米
        simpleItemList.add(new ModFoodBase("corn", 1, 0.6F, false));                    //玉米	
        simpleItemList.add(new ModFoodBase("eggplant", 1, 0.6F, false));                //茄子	
        simpleItemList.add(new ModFoodBase("cabbage", 1, 0.6F, false));                 //卷心菜	
        simpleItemList.add(new ModFoodBase("scallion", 1, 0.6F, false));                //葱		
        simpleItemList.add(new ModFoodBase("ginger", 1, 0.6F, false));                  //生姜	
        simpleItemList.add(new ModFoodBase("cauliflower", 1, 0.6F, false));             //花菜	
        simpleItemList.add(new ModFoodBase("chili", 1, 0.6F, false));                   //辣椒	
        simpleItemList.add(new ModFoodBase("pepper", 1, 0.6F, false));                  //花椒	
        simpleItemList.add(new ModFoodBase("sweet_pepper", 1, 0.6F, false));            //甜椒	
        simpleItemList.add(new ModFoodBase("onion", 1, 0.6F, false));                   //洋葱	
        simpleItemList.add(new ModFoodBase("lentil", 1, 0.6F, false));                  //扁豆	
        simpleItemList.add(new ModFoodBase("garlic", 1, 0.6F, false));                  //大蒜	
        
        
        
        
        //熟食
        simpleItemList.add(new ItemFoodInBowl("steamed_rice", 1, 0.6F, false)); //米饭
    	
        
    	//餐具
        simpleItemList.add(new ModTablewareBase("bowl").setMaxStackSize(16)); //碗
        
        
        //实例化方块物品
        Flower.logger.info("initializing block items");
        for (Block b : BlockRegistry.simpleBlockList)
        {
            simpleItemList.add(new ModItemBlockBase(b));
        }

    }
    
    /**注册Item*/
    @SubscribeEvent
    public static void onItemRegister(RegistryEvent.Register<Item> event)
    {
        //注册普通物品
        Flower.logger.info("registering items");
        event.getRegistry().registerAll(simpleItemList.toArray(new Item[0]));
    }
    
    
    /**注册物品后这个会自动变成对应物品的引用*/
    @ObjectHolder(Flower.MODID)
    public static class ItemHolder
    {
    	//种子
    	@ObjectHolder("rice_seed")	//水稻种子
        public static final Item RICE_SEED = null;
    	
    	//餐具
        @ObjectHolder("bowl")	//碗
        public static final Item BOWL = null;
        
        //熟食
        @ObjectHolder("steamed_rice")	//米饭
        public static final Item STEAMED_RICE = null;
        
        
        
        
        
        
        //食材
        @ObjectHolder("chinese_cabbage")	//白菜
        public static final Item CHINESE_CABBAGE = null;
        
        @ObjectHolder("tomato")		//番茄
        public static final Item TOMATO = null;
        
        @ObjectHolder("peanut")		//花生
        public static final Item PEANUT = null;
        
        @ObjectHolder("rice")		//大米
        public static final Item RICE = null;
        
        @ObjectHolder("corn")		//玉米
        public static final Item CORN = null;
        
        @ObjectHolder("eggplant")	//茄子
        public static final Item EGGPLANT = null;
        
        @ObjectHolder("cabbage")	//卷心菜
        public static final Item CABBAGE = null;
        
        @ObjectHolder("scallion")	//葱
        public static final Item SCALLION = null;
        
        @ObjectHolder("ginger")		//姜
        public static final Item GINGER = null;
        
        @ObjectHolder("cauliflower")	//花菜
        public static final Item CAULIFLOWER = null;
        
        @ObjectHolder("chili")		//辣椒
        public static final Item CHILI = null;
        
        @ObjectHolder("pepper")		//花椒
        public static final Item PEPPER = null;
        
        @ObjectHolder("sweet_pepper")		//甜椒
        public static final Item SWEET_PEPPER = null;
        
        @ObjectHolder("onion")			//洋葱
        public static final Item ONION = null;
        
        @ObjectHolder("lentil")			//扁豆
        public static final Item LENTIL = null;
        
        @ObjectHolder("garlic")			//大蒜
        public static final Item GARLIC = null;
        
        
    }

}