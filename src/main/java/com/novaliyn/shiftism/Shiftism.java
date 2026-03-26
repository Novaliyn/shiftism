package com.novaliyn.shiftism;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = Shiftism.MODID, version = Shiftism.VERSION, name = "Shiftism")
public class Shiftism {
    public static final String MODID = "shiftism";
    public static final String VERSION = "1.0";

    //Items
    public static Item miku_ingot;
    public static Item miku_sword;
    public static Item miku_rod;
    public static Item impure_miku_dust;
    public static Item pure_miku_dust;
    public static Item miku_nugget;
    public static Item miku_bucket;
    public static Item miku_milk;

    //Blocks
    public static Block miku_ore;

    public static final Item.ToolMaterial MIKU = EnumHelper.addToolMaterial("MIKU", 4, 3939, 10f, 6f, 39).setRepairItem(new ItemStack(miku_ingot));


    @EventHandler
    public void preinit(FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new ShiftedEvents());
        ShiftedPotions.register();

        //Items
        miku_ingot = new ItemShiftism().setUnlocalizedName("miku_ingot").setTextureName("shiftism:miku_ingot").setCreativeTab(tabShiftism);
        GameRegistry.registerItem(miku_ingot, miku_ingot.getUnlocalizedName().substring(5));
        miku_sword = new ItemSword(MIKU).setUnlocalizedName("miku_sword").setTextureName("shiftism:miku_sword").setCreativeTab(tabShiftism);
        GameRegistry.registerItem(miku_sword, miku_sword.getUnlocalizedName().substring(5));
        miku_rod = new ItemShiftism().setUnlocalizedName("miku_rod").setTextureName("shiftism:miku_rod").setCreativeTab(tabShiftism);
        GameRegistry.registerItem(miku_rod, miku_rod.getUnlocalizedName().substring(5));
        impure_miku_dust = new ItemMikuDust().setUnlocalizedName("impure_miku_dust").setTextureName("shiftism:impure_miku_dust").setCreativeTab(tabShiftism);
        GameRegistry.registerItem(impure_miku_dust, impure_miku_dust.getUnlocalizedName().substring(5));
        pure_miku_dust = new ItemShiftism().setUnlocalizedName("pure_miku_dust").setTextureName("shiftism:pure_miku_dust").setCreativeTab(tabShiftism);
        GameRegistry.registerItem(pure_miku_dust, pure_miku_dust.getUnlocalizedName().substring(5));
        miku_nugget = new ItemShiftism().setUnlocalizedName("miku_nugget").setTextureName("shiftism:miku_nugget").setCreativeTab(tabShiftism);
        GameRegistry.registerItem(miku_nugget, miku_nugget.getUnlocalizedName().substring(5));
        miku_bucket = new ItemMikuBucket().setUnlocalizedName("miku_bucket").setTextureName("shiftism:miku_bucket").setCreativeTab(tabShiftism);
        GameRegistry.registerItem(miku_bucket, miku_bucket.getUnlocalizedName().substring(5));
        miku_milk = new ItemMikuMilk().setUnlocalizedName("miku_milk").setTextureName("shiftism:miku_milk").setCreativeTab(tabShiftism);
        GameRegistry.registerItem(miku_milk, miku_milk.getUnlocalizedName().substring(5));

        //Blocks
        miku_ore = new BlockMikuOre(Material.rock).setBlockName("miku_ore").setBlockTextureName("shiftism:miku_ore").setCreativeTab(tabShiftism);
        GameRegistry.registerBlock(miku_ore, miku_ore.getUnlocalizedName().substring(5));

        //World Gen
        GameRegistry.registerWorldGenerator(new ShiftedGenerator(), 0);

    }


    @EventHandler
    public void init(FMLInitializationEvent event) {
        GameRegistry.addSmelting(pure_miku_dust, new ItemStack(miku_nugget), 3.9f);
        GameRegistry.addRecipe(new ItemStack(miku_ingot), new Object[]{"MMM", "MMM", "MMM", 'M', miku_nugget});
        GameRegistry.addRecipe(new ItemStack(miku_rod), new Object[]{"M", "M", 'M', miku_ingot});
        GameRegistry.addRecipe(new ItemStack(miku_sword), new Object[]{"M", "M", "R", 'M', miku_ingot, 'R', miku_rod});
    }

    @EventHandler
    public void postinit(FMLPostInitializationEvent event) {

    }

    public static CreativeTabs tabShiftism = new CreativeTabs("tabShiftism") {
        @Override
        public Item getTabIconItem(){
            return miku_ingot;
        }
    };

}
