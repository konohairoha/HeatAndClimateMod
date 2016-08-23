package defeatedcrow.hac.main;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import defeatedcrow.hac.core.ClimateCore;
import defeatedcrow.hac.core.DCLogger;
import defeatedcrow.hac.core.base.DCItemBlock;
import defeatedcrow.hac.core.util.DCUtil;
import defeatedcrow.hac.food.FoodInit;
import defeatedcrow.hac.food.block.BlockPotteryPot;
import defeatedcrow.hac.food.block.BlockSteelPot;
import defeatedcrow.hac.food.block.crop.BlockCoffee;
import defeatedcrow.hac.food.block.crop.BlockCotton;
import defeatedcrow.hac.food.block.crop.BlockLeavesLemon;
import defeatedcrow.hac.food.block.crop.BlockLeavesOlive;
import defeatedcrow.hac.food.block.crop.BlockLeavesTea;
import defeatedcrow.hac.food.block.crop.BlockOnion;
import defeatedcrow.hac.food.block.crop.BlockRice;
import defeatedcrow.hac.food.block.crop.BlockSaplingDC;
import defeatedcrow.hac.food.block.crop.BlockSpinach;
import defeatedcrow.hac.food.block.crop.BlockTomato;
import defeatedcrow.hac.food.item.ItemDCCrops;
import defeatedcrow.hac.food.item.ItemDCSeeds;
import defeatedcrow.hac.food.item.RoundBreadItem;
import defeatedcrow.hac.food.item.StickFoodsItem;
import defeatedcrow.hac.machine.MachineInit;
import defeatedcrow.hac.machine.block.BlockCrank_S;
import defeatedcrow.hac.machine.block.BlockFan;
import defeatedcrow.hac.machine.block.BlockGearBox;
import defeatedcrow.hac.machine.block.BlockHandCrank;
import defeatedcrow.hac.machine.block.BlockRedBox;
import defeatedcrow.hac.machine.block.BlockShaft_L;
import defeatedcrow.hac.machine.block.BlockShaft_S;
import defeatedcrow.hac.machine.block.BlockShaft_TA;
import defeatedcrow.hac.machine.block.BlockShaft_TB;
import defeatedcrow.hac.machine.block.BlockStoneMill;
import defeatedcrow.hac.machine.block.BlockWindmill;
import defeatedcrow.hac.machine.block.BlockWindmill_L;
import defeatedcrow.hac.magic.MagicInit;
import defeatedcrow.hac.magic.item.ItemMagicalBadge;
import defeatedcrow.hac.magic.item.ItemMagicalPendant;
import defeatedcrow.hac.main.block.build.BlockChalcedonyLamp;
import defeatedcrow.hac.main.block.build.BlockGemBricks;
import defeatedcrow.hac.main.block.build.BlockGlassSelenite;
import defeatedcrow.hac.main.block.build.BlockSlabDC;
import defeatedcrow.hac.main.block.build.BlockSofaBase;
import defeatedcrow.hac.main.block.build.BlockStairsBase;
import defeatedcrow.hac.main.block.build.BlockTableBase;
import defeatedcrow.hac.main.block.container.BlockCardboard;
import defeatedcrow.hac.main.block.container.BlockCropCont;
import defeatedcrow.hac.main.block.container.BlockEnemyCont;
import defeatedcrow.hac.main.block.container.BlockLogCont;
import defeatedcrow.hac.main.block.container.BlockMiscCont;
import defeatedcrow.hac.main.block.device.BlockNormalChamber;
import defeatedcrow.hac.main.block.device.BlockShitirin;
import defeatedcrow.hac.main.block.device.BlockStevensonScreen;
import defeatedcrow.hac.main.block.ores.BlockDusts;
import defeatedcrow.hac.main.block.ores.BlockGem;
import defeatedcrow.hac.main.block.ores.BlockMetal;
import defeatedcrow.hac.main.block.ores.BlockOres;
import defeatedcrow.hac.main.block.ores.BlockOres2;
import defeatedcrow.hac.main.item.equip.ItemArmorDC;
import defeatedcrow.hac.main.item.equip.ItemArmorThinDC;
import defeatedcrow.hac.main.item.food.ItemDCFoods;
import defeatedcrow.hac.main.item.food.ItemFoodMaterials;
import defeatedcrow.hac.main.item.misc.ItemMiscs;
import defeatedcrow.hac.main.item.misc.ItemRepairPutty;
import defeatedcrow.hac.main.item.ores.ItemGems;
import defeatedcrow.hac.main.item.ores.ItemIngots;
import defeatedcrow.hac.main.item.ores.ItemMiscDust;
import defeatedcrow.hac.main.item.ores.ItemOreDusts;
import defeatedcrow.hac.main.item.tool.ItemArroyYagen;
import defeatedcrow.hac.main.item.tool.ItemAxeDC;
import defeatedcrow.hac.main.item.tool.ItemCrowDrill;
import defeatedcrow.hac.main.item.tool.ItemPickaxeDC;
import defeatedcrow.hac.main.item.tool.ItemSpadeDC;
import defeatedcrow.hac.main.item.tool.ItemStoneYagen;
import defeatedcrow.hac.main.item.tool.ItemSwordDC;
import defeatedcrow.hac.main.item.tool.ItemWrench;
import defeatedcrow.hac.main.util.DCArmorMaterial;
import defeatedcrow.hac.main.util.DCMaterial;
import defeatedcrow.hac.main.util.DCToolMaterial;

public class MainMaterialRegister {
	private MainMaterialRegister() {
	}

	public static void load() {

		registerBlock();
		registerSidedBlock();
		regJsonBlock();
		regDeviceBlock();
		regCropBlock();
		registerItems();
		registerMaterialEnum();
		registerEquip();
		registerFood();
		registerHarvestLevel();
	}

	static void registerBlock() {
		MainInit.ores = new BlockOres(Material.IRON, ClimateCore.PACKAGE_BASE + "_ore_stone", 15);
		registerBlock(MainInit.ores, ClimateCore.PACKAGE_BASE + "_ore_stone");

		MainInit.ores_2 = new BlockOres2(Material.IRON, ClimateCore.PACKAGE_BASE + "_ore2_stone", 5);
		registerBlock(MainInit.ores_2, ClimateCore.PACKAGE_BASE + "_ore2_stone");

		MainInit.metalBlock = new BlockMetal(Material.IRON, ClimateCore.PACKAGE_BASE + "_metal", 9);
		registerBlock(MainInit.metalBlock, ClimateCore.PACKAGE_BASE + "_ore_metalblock");

		MainInit.dustBlock = new BlockDusts(Material.GROUND, ClimateCore.PACKAGE_BASE + "_dustblock", 9);
		registerBlock(MainInit.dustBlock, ClimateCore.PACKAGE_BASE + "_ore_dustblock");

		MainInit.gemBlock = new BlockGem(Material.ROCK, ClimateCore.PACKAGE_BASE + "_gemblock", 7);
		registerBlock(MainInit.gemBlock, ClimateCore.PACKAGE_BASE + "_ore_gemblock");

		MainInit.bricks = new BlockGemBricks(Material.ROCK, ClimateCore.PACKAGE_BASE + "_build_bricks");
		registerBlock(MainInit.bricks, ClimateCore.PACKAGE_BASE + "_build_bricks");

		MainInit.selenite = new BlockGlassSelenite(ClimateCore.PACKAGE_BASE + "_build_selenite", 2);
		registerBlock(MainInit.selenite, ClimateCore.PACKAGE_BASE + "_build_selenite");

		MainInit.chalLamp = new BlockChalcedonyLamp(ClimateCore.PACKAGE_BASE + "_build_challamp", 15);
		registerBlock(MainInit.chalLamp, ClimateCore.PACKAGE_BASE + "_build_challamp");
	}

	static void registerSidedBlock() {
		MainInit.logCont = new BlockLogCont(Material.CLAY, ClimateCore.PACKAGE_BASE + "_cont_log", 6);
		registerBlock(MainInit.logCont, ClimateCore.PACKAGE_BASE + "_cont_log");
		ClimateMain.proxy.addSidedBlock(MainInit.logCont, "cont_log", 6);

		MainInit.cropCont = new BlockCropCont(Material.CLAY, ClimateCore.PACKAGE_BASE + "_cont_crop", 10);
		registerBlock(MainInit.cropCont, ClimateCore.PACKAGE_BASE + "_cont_crop");
		ClimateMain.proxy.addTBBlock(MainInit.cropCont, "cont_crop", 10);

		MainInit.dropCont = new BlockEnemyCont(Material.CLAY, ClimateCore.PACKAGE_BASE + "_cont_metal", 4);
		registerBlock(MainInit.dropCont, ClimateCore.PACKAGE_BASE + "_cont_metal");
		ClimateMain.proxy.addTBBlock(MainInit.dropCont, "cont_metal", 4);

		MainInit.miscCont = new BlockMiscCont(Material.CLAY, ClimateCore.PACKAGE_BASE + "_cont_misc", 3);
		registerBlock(MainInit.miscCont, ClimateCore.PACKAGE_BASE + "_cont_misc");
		ClimateMain.proxy.addTBBlock(MainInit.miscCont, "cont_misc", 3);

		MainInit.cardboard = new BlockCardboard(Material.CLAY, ClimateCore.PACKAGE_BASE + "_cont_cardboard", 5);
		registerBlock(MainInit.cardboard, ClimateCore.PACKAGE_BASE + "_cont_cardboard");
		ClimateMain.proxy.addSidedBlock(MainInit.cardboard, "cont_cardboard", 5);
	}

	static void regCropBlock() {
		FoodInit.cropRice = new BlockRice(ClimateCore.PACKAGE_BASE + "_crop_rice");
		registerBlock(FoodInit.cropRice, ClimateCore.PACKAGE_BASE + "_crop_rice");
		ClimateMain.proxy.addCropBlock(FoodInit.cropRice, "crop_rice", 3);

		FoodInit.cropOnion = new BlockOnion(ClimateCore.PACKAGE_BASE + "_crop_onion");
		registerBlock(FoodInit.cropOnion, ClimateCore.PACKAGE_BASE + "_crop_onion");
		ClimateMain.proxy.addCropBlock(FoodInit.cropOnion, "crop_onion", 3);

		FoodInit.cropSpinach = new BlockSpinach(ClimateCore.PACKAGE_BASE + "_crop_spinach");
		registerBlock(FoodInit.cropSpinach, ClimateCore.PACKAGE_BASE + "_crop_spinach");
		ClimateMain.proxy.addCropBlock(FoodInit.cropSpinach, "crop_spinach", 3);

		FoodInit.cropTomato = new BlockTomato(ClimateCore.PACKAGE_BASE + "_crop_tomato");
		registerBlock(FoodInit.cropTomato, ClimateCore.PACKAGE_BASE + "_crop_tomato");
		ClimateMain.proxy.addCropBlock(FoodInit.cropTomato, "crop_tomato", 7);

		FoodInit.cropCoffee = new BlockCoffee(ClimateCore.PACKAGE_BASE + "_crop_coffee");
		registerBlock(FoodInit.cropCoffee, ClimateCore.PACKAGE_BASE + "_crop_coffee");
		ClimateMain.proxy.addCropBlock(FoodInit.cropCoffee, "crop_coffee", 7);

		FoodInit.cropCotton = new BlockCotton(ClimateCore.PACKAGE_BASE + "_crop_cotton");
		registerBlock(FoodInit.cropCotton, ClimateCore.PACKAGE_BASE + "_crop_cotton");
		ClimateMain.proxy.addCropBlock(FoodInit.cropCotton, "crop_cotton", 7);

		FoodInit.leavesLemon = new BlockLeavesLemon(ClimateCore.PACKAGE_BASE + "_leaves_lemon");
		registerBlock(FoodInit.leavesLemon, ClimateCore.PACKAGE_BASE + "_leaves_lemon");
		ClimateMain.proxy.addSidedBlock(FoodInit.leavesLemon, "leaves_lemon", 3);

		FoodInit.leavesOlive = new BlockLeavesOlive(ClimateCore.PACKAGE_BASE + "_leaves_olive");
		registerBlock(FoodInit.leavesOlive, ClimateCore.PACKAGE_BASE + "_leaves_olive");
		ClimateMain.proxy.addSidedBlock(FoodInit.leavesOlive, "leaves_olive", 3);

		FoodInit.leavesTea = new BlockLeavesTea(ClimateCore.PACKAGE_BASE + "_leaves_tea");
		registerBlock(FoodInit.leavesTea, ClimateCore.PACKAGE_BASE + "_leaves_tea");

		FoodInit.saplings = new BlockSaplingDC(ClimateCore.PACKAGE_BASE + "_crop_sapling");
		registerBlock(FoodInit.saplings, ClimateCore.PACKAGE_BASE + "_crop_sapling");
		ClimateMain.proxy.addCropBlock(FoodInit.saplings, "crop_sapling", 2);
	}

	static void regJsonBlock() {
		MainInit.stairsGlass = new BlockStairsBase(MainInit.selenite.getDefaultState(), "build/glass_stairs", true)
				.setUnlocalizedName("dcs_stairs_glass");
		registerBlock(MainInit.stairsGlass, ClimateCore.PACKAGE_BASE + "_stairs_glass");
		ClimateMain.proxy.regBlockJson(Item.getItemFromBlock(MainInit.stairsGlass), "dcs_climate", "dcs_stairs_glass",
				"build", 15, false);

		MainInit.stairsGypsum = new BlockStairsBase(MainInit.ores.getDefaultState(), "ores/gemblock_gypsum", false)
				.setUnlocalizedName("dcs_stairs_gypsum");
		registerBlock(MainInit.stairsGypsum, ClimateCore.PACKAGE_BASE + "_stairs_gypsum");
		ClimateMain.proxy.regBlockJson(Item.getItemFromBlock(MainInit.stairsGypsum), "dcs_climate",
				"dcs_stairs_gypsum", "build", 15, false);

		MainInit.halfSlab = new BlockSlabDC();
		registerBlock(MainInit.halfSlab, ClimateCore.PACKAGE_BASE + "_build_slab");
		ClimateMain.proxy.regBlockJson(Item.getItemFromBlock(MainInit.halfSlab), "dcs_climate", "dcs_build_slab",
				"build", 2, true);

		MainInit.tableMarble = new BlockTableBase(ClimateCore.PACKAGE_BASE + "_table_marble", false);
		registerBlock(MainInit.tableMarble, ClimateCore.PACKAGE_BASE + "_table_marble");
		ClimateMain.proxy.regBlockJson(Item.getItemFromBlock(MainInit.tableMarble), "dcs_climate", "dcs_table_marble",
				"build", 0, false);

		MainInit.tableGypsum = new BlockTableBase(ClimateCore.PACKAGE_BASE + "_table_gypsum", false);
		registerBlock(MainInit.tableGypsum, ClimateCore.PACKAGE_BASE + "_table_gypsum");
		ClimateMain.proxy.regBlockJson(Item.getItemFromBlock(MainInit.tableGypsum), "dcs_climate", "dcs_table_gypsum",
				"build", 0, false);

		MainInit.tableWood = new BlockTableBase(ClimateCore.PACKAGE_BASE + "_table_wood", false);
		registerBlock(MainInit.tableWood, ClimateCore.PACKAGE_BASE + "_table_wood");
		ClimateMain.proxy.regBlockJson(Item.getItemFromBlock(MainInit.tableWood), "dcs_climate", "dcs_table_wood",
				"build", 0, false);

		MainInit.tableDark = new BlockTableBase(ClimateCore.PACKAGE_BASE + "_table_darkwood", false);
		registerBlock(MainInit.tableDark, ClimateCore.PACKAGE_BASE + "_table_darkwood");
		ClimateMain.proxy.regBlockJson(Item.getItemFromBlock(MainInit.tableDark), "dcs_climate", "dcs_table_darkwood",
				"build", 0, false);

		MainInit.carpetRed = new BlockTableBase(ClimateCore.PACKAGE_BASE + "_carpet_red", true);
		registerBlock(MainInit.carpetRed, ClimateCore.PACKAGE_BASE + "_carpet_red");
		ClimateMain.proxy.regBlockJson(Item.getItemFromBlock(MainInit.carpetRed), "dcs_climate", "dcs_carpet_red",
				"build", 0, false);

		MainInit.carpetWhite = new BlockTableBase(ClimateCore.PACKAGE_BASE + "_carpet_white", true);
		registerBlock(MainInit.carpetWhite, ClimateCore.PACKAGE_BASE + "_carpet_white");
		ClimateMain.proxy.regBlockJson(Item.getItemFromBlock(MainInit.carpetWhite), "dcs_climate", "dcs_carpet_white",
				"build", 0, false);

		MainInit.carpetGray = new BlockTableBase(ClimateCore.PACKAGE_BASE + "_carpet_gray", true);
		registerBlock(MainInit.carpetGray, ClimateCore.PACKAGE_BASE + "_carpet_gray");
		ClimateMain.proxy.regBlockJson(Item.getItemFromBlock(MainInit.carpetGray), "dcs_climate", "dcs_carpet_gray",
				"build", 0, false);

		MainInit.sofaBlack = new BlockSofaBase(ClimateCore.PACKAGE_BASE + "_sofa_black");
		registerBlock(MainInit.sofaBlack, ClimateCore.PACKAGE_BASE + "_sofa_black");
		ClimateMain.proxy.regBlockJson(Item.getItemFromBlock(MainInit.sofaBlack), "dcs_climate", "dcs_sofa_black",
				"build", 0, false);

		MainInit.sofaRed = new BlockSofaBase(ClimateCore.PACKAGE_BASE + "_sofa_red");
		registerBlock(MainInit.sofaRed, ClimateCore.PACKAGE_BASE + "_sofa_red");
		ClimateMain.proxy.regBlockJson(Item.getItemFromBlock(MainInit.sofaRed), "dcs_climate", "dcs_sofa_red", "build",
				0, false);

		MainInit.stoolBlack = new BlockSofaBase(ClimateCore.PACKAGE_BASE + "_stool_black").setSmallAABB();
		registerBlock(MainInit.stoolBlack, ClimateCore.PACKAGE_BASE + "_stool_black");
		ClimateMain.proxy.regBlockJson(Item.getItemFromBlock(MainInit.stoolBlack), "dcs_climate", "dcs_stool_black",
				"build", 0, false);

		MainInit.stoolRed = new BlockSofaBase(ClimateCore.PACKAGE_BASE + "_stool_red").setSmallAABB();
		registerBlock(MainInit.stoolRed, ClimateCore.PACKAGE_BASE + "_stool_red");
		ClimateMain.proxy.regBlockJson(Item.getItemFromBlock(MainInit.stoolRed), "dcs_climate", "dcs_stool_red",
				"build", 0, false);
	}

	static void regDeviceBlock() {
		MainInit.chamber = new BlockNormalChamber(Material.IRON, ClimateCore.PACKAGE_BASE + "_device_chamber", 1);
		registerBlock(MainInit.chamber, ClimateCore.PACKAGE_BASE + "_device_chamber");

		MainInit.shitirin = new BlockShitirin(Material.CLAY, ClimateCore.PACKAGE_BASE + "_device_shitirin", 1);
		registerBlock(MainInit.shitirin, ClimateCore.PACKAGE_BASE + "_device_shitirin");

		MachineInit.windmill = new BlockWindmill(ClimateCore.PACKAGE_BASE + "_device_windmill");
		registerBlock(MachineInit.windmill, ClimateCore.PACKAGE_BASE + "_device_windmill");

		MachineInit.windmill_l = new BlockWindmill_L(ClimateCore.PACKAGE_BASE + "_device_windmill_l");
		registerBlock(MachineInit.windmill_l, ClimateCore.PACKAGE_BASE + "_device_windmill_l");

		MachineInit.shaft_s = new BlockShaft_S(ClimateCore.PACKAGE_BASE + "_device_shaft_s");
		registerBlock(MachineInit.shaft_s, ClimateCore.PACKAGE_BASE + "_device_shaft_s");

		MachineInit.shaft_l = new BlockShaft_L(ClimateCore.PACKAGE_BASE + "_device_shaft_l");
		registerBlock(MachineInit.shaft_l, ClimateCore.PACKAGE_BASE + "_device_shaft_l");

		MachineInit.shaft_t_a = new BlockShaft_TA(ClimateCore.PACKAGE_BASE + "_device_shaft_ta");
		registerBlock(MachineInit.shaft_t_a, ClimateCore.PACKAGE_BASE + "_device_shaft_ta");

		MachineInit.shaft_t_b = new BlockShaft_TB(ClimateCore.PACKAGE_BASE + "_device_shaft_tb");
		registerBlock(MachineInit.shaft_t_b, ClimateCore.PACKAGE_BASE + "_device_shaft_tb");

		MachineInit.gearbox = new BlockGearBox(ClimateCore.PACKAGE_BASE + "_device_gearbox");
		registerBlock(MachineInit.gearbox, ClimateCore.PACKAGE_BASE + "_device_gearbox");

		MachineInit.piston = new BlockCrank_S(ClimateCore.PACKAGE_BASE + "_device_crank_s");
		registerBlock(MachineInit.piston, ClimateCore.PACKAGE_BASE + "_device_crank_s");

		MachineInit.handcrank = new BlockHandCrank(ClimateCore.PACKAGE_BASE + "_device_handcrank");
		registerBlock(MachineInit.handcrank, ClimateCore.PACKAGE_BASE + "_device_handcrank");

		MachineInit.stonemill = new BlockStoneMill(ClimateCore.PACKAGE_BASE + "_device_stonemill");
		registerBlock(MachineInit.stonemill, ClimateCore.PACKAGE_BASE + "_device_stonemill");

		MachineInit.fan = new BlockFan(ClimateCore.PACKAGE_BASE + "_device_fan");
		registerBlock(MachineInit.fan, ClimateCore.PACKAGE_BASE + "_device_fan");

		MachineInit.redbox = new BlockRedBox(ClimateCore.PACKAGE_BASE + "_device_redbox");
		registerBlock(MachineInit.redbox, ClimateCore.PACKAGE_BASE + "_device_redbox");

		MainInit.stevenson_screen = new BlockStevensonScreen(ClimateCore.PACKAGE_BASE + "_device_stevenson_screen");
		registerBlock(MainInit.stevenson_screen, ClimateCore.PACKAGE_BASE + "_device_stevenson_screen");

		FoodInit.potteryPot = new BlockPotteryPot(ClimateCore.PACKAGE_BASE + "_device_pottery_pot");
		registerBlock(FoodInit.potteryPot, ClimateCore.PACKAGE_BASE + "_device_pottery_pot");

		FoodInit.steelPot = new BlockSteelPot(ClimateCore.PACKAGE_BASE + "_device_steel_pot");
		registerBlock(FoodInit.steelPot, ClimateCore.PACKAGE_BASE + "_device_steel_pot");
	}

	static void registerItems() {
		// ores
		MainInit.oreIngot = new ItemIngots(9).setCreativeTab(ClimateCore.climate).setUnlocalizedName(
				ClimateCore.PACKAGE_BASE + "_ingot");
		GameRegistry.register(MainInit.oreIngot.setRegistryName(ClimateCore.PACKAGE_BASE + "_ingot"));

		MainInit.oreDust = new ItemOreDusts(8).setCreativeTab(ClimateCore.climate).setUnlocalizedName(
				ClimateCore.PACKAGE_BASE + "_oredust");
		GameRegistry.register(MainInit.oreDust.setRegistryName(ClimateCore.PACKAGE_BASE + "_oredust"));

		MainInit.gems = new ItemGems(11).setCreativeTab(ClimateCore.climate).setUnlocalizedName(
				ClimateCore.PACKAGE_BASE + "_gem");
		GameRegistry.register(MainInit.gems.setRegistryName(ClimateCore.PACKAGE_BASE + "_gem"));

		MainInit.miscDust = new ItemMiscDust(7).setCreativeTab(ClimateCore.climate).setUnlocalizedName(
				ClimateCore.PACKAGE_BASE + "_miscdust");
		GameRegistry.register(MainInit.miscDust.setRegistryName(ClimateCore.PACKAGE_BASE + "_miscdust"));

		// tools
		MainInit.materials = new ItemMiscs(6).setCreativeTab(ClimateCore.climate).setUnlocalizedName(
				ClimateCore.PACKAGE_BASE + "_material");
		GameRegistry.register(MainInit.materials.setRegistryName(ClimateCore.PACKAGE_BASE + "_material"));

		MainInit.stoneYagen = new ItemStoneYagen().setCreativeTab(ClimateCore.climate).setUnlocalizedName(
				ClimateCore.PACKAGE_BASE + "_yagen_stone");
		GameRegistry.register(MainInit.stoneYagen.setRegistryName(ClimateCore.PACKAGE_BASE + "_yagen_stone"));

		MainInit.brassYagen = new ItemArroyYagen().setCreativeTab(ClimateCore.climate).setUnlocalizedName(
				ClimateCore.PACKAGE_BASE + "_yagen_brass");
		GameRegistry.register(MainInit.brassYagen.setRegistryName(ClimateCore.PACKAGE_BASE + "_yagen_brass"));

		MainInit.crowDrill = new ItemCrowDrill().setCreativeTab(ClimateCore.climate).setUnlocalizedName(
				ClimateCore.PACKAGE_BASE + "_creative_drill");
		GameRegistry.register(MainInit.crowDrill.setRegistryName(ClimateCore.PACKAGE_BASE + "_creative_drill"));

		MainInit.wrench = new ItemWrench().setCreativeTab(ClimateCore.climate).setUnlocalizedName(
				ClimateCore.PACKAGE_BASE + "_wrench");
		GameRegistry.register(MainInit.wrench.setRegistryName(ClimateCore.PACKAGE_BASE + "_wrench"));

	}

	static void registerFood() {
		MainInit.foodMaterials = new ItemFoodMaterials(2).setCreativeTab(ClimateMain.food).setUnlocalizedName(
				ClimateCore.PACKAGE_BASE + "_food_materials");
		GameRegistry.register(MainInit.foodMaterials.setRegistryName(ClimateCore.PACKAGE_BASE + "_food_materials"));

		MainInit.bakedApple = new ItemDCFoods(2, false).setCreativeTab(ClimateMain.food).setUnlocalizedName(
				ClimateCore.PACKAGE_BASE + "_food_itemfood");
		GameRegistry.register(MainInit.bakedApple.setRegistryName(ClimateCore.PACKAGE_BASE + "_food_itemfood"));

		FoodInit.bread = new RoundBreadItem(false).setCreativeTab(ClimateMain.food).setUnlocalizedName(
				ClimateCore.PACKAGE_BASE + "_food_bread");
		GameRegistry.register(FoodInit.bread.setRegistryName(ClimateCore.PACKAGE_BASE + "_food_bread"));

		FoodInit.sticks = new StickFoodsItem(true).setCreativeTab(ClimateMain.food).setUnlocalizedName(
				ClimateCore.PACKAGE_BASE + "_food_stick");
		GameRegistry.register(FoodInit.sticks.setRegistryName(ClimateCore.PACKAGE_BASE + "_food_stick"));

		FoodInit.crops = new ItemDCCrops(9).setCreativeTab(ClimateMain.food).setUnlocalizedName(
				ClimateCore.PACKAGE_BASE + "_food_crops");
		GameRegistry.register(FoodInit.crops.setRegistryName(ClimateCore.PACKAGE_BASE + "_food_crops"));

		FoodInit.seeds = new ItemDCSeeds(5).setCreativeTab(ClimateMain.food).setUnlocalizedName(
				ClimateCore.PACKAGE_BASE + "_food_seeds");
		GameRegistry.register(FoodInit.seeds.setRegistryName(ClimateCore.PACKAGE_BASE + "_food_seeds"));
	}

	static void registerEquip() {
		String[] name = {
				"brass",
				"steel",
				"silver",
				"nickelsilver",
				"chalcedony",
				"sapphire" };
		for (int j = 0; j < 6; j++) {
			DCLogger.debugLog(j + "/" + DCToolMaterial.getToolMaterial(j).toString());
			MainInit.dcAxe[j] = new ItemAxeDC(DCToolMaterial.getToolMaterial(j), name[j]).setCreativeTab(
					ClimateMain.tool).setUnlocalizedName(ClimateCore.PACKAGE_BASE + "_axe_" + name[j]);
			GameRegistry.register(MainInit.dcAxe[j].setRegistryName(ClimateCore.PACKAGE_BASE + "_axe_" + name[j]));
		}

		for (int j = 0; j < 6; j++) {
			MainInit.dcPickaxe[j] = new ItemPickaxeDC(DCToolMaterial.getToolMaterial(j), name[j]).setCreativeTab(
					ClimateMain.tool).setUnlocalizedName(ClimateCore.PACKAGE_BASE + "_pickaxe_" + name[j]);
			GameRegistry.register(MainInit.dcPickaxe[j].setRegistryName(ClimateCore.PACKAGE_BASE + "_pickaxe_"
					+ name[j]));
		}

		for (int j = 0; j < 6; j++) {
			MainInit.dcSpade[j] = new ItemSpadeDC(DCToolMaterial.getToolMaterial(j), name[j]).setCreativeTab(
					ClimateMain.tool).setUnlocalizedName(ClimateCore.PACKAGE_BASE + "_spade_" + name[j]);
			GameRegistry.register(MainInit.dcSpade[j].setRegistryName(ClimateCore.PACKAGE_BASE + "_spade_" + name[j]));
		}

		for (int j = 0; j < 4; j++) {
			MainInit.dcSword[j] = new ItemSwordDC(DCToolMaterial.getToolMaterial(j), name[j], false).setCreativeTab(
					ClimateMain.tool).setUnlocalizedName(ClimateCore.PACKAGE_BASE + "_sword_" + name[j]);
			GameRegistry.register(MainInit.dcSword[j].setRegistryName(ClimateCore.PACKAGE_BASE + "_sword_" + name[j]));
		}
		for (int j = 4; j < 6; j++) {
			MainInit.dcSword[j] = new ItemSwordDC(DCToolMaterial.getToolMaterial(j), name[j], true).setCreativeTab(
					ClimateMain.tool).setUnlocalizedName(ClimateCore.PACKAGE_BASE + "_sword_" + name[j]);
			GameRegistry.register(MainInit.dcSword[j].setRegistryName(ClimateCore.PACKAGE_BASE + "_sword_" + name[j]));
		}

		String[] type = {
				"met",
				"plate",
				"leggins",
				"boots" };
		for (int i = 0; i < 4; i++) {
			EntityEquipmentSlot slot = DCUtil.SLOTS[i];
			MainInit.brassArmor[i] = new ItemArmorDC(DCArmorMaterial.DC_BRASS, DCMaterial.BRASS, slot, "brass")
					.setCreativeTab(ClimateMain.tool).setUnlocalizedName(
							ClimateCore.PACKAGE_BASE + "_" + type[i] + "_brass");
			GameRegistry.register(MainInit.brassArmor[i].setRegistryName(ClimateCore.PACKAGE_BASE + "_" + type[i]
					+ "_brass"));

			MainInit.steelArmor[i] = new ItemArmorDC(DCArmorMaterial.DC_STEEL, DCMaterial.STEEL, slot, "steel")
					.setCreativeTab(ClimateMain.tool).setUnlocalizedName(
							ClimateCore.PACKAGE_BASE + "_" + type[i] + "_steel");
			GameRegistry.register(MainInit.steelArmor[i].setRegistryName(ClimateCore.PACKAGE_BASE + "_" + type[i]
					+ "_steel"));

			MainInit.chalcArmor[i] = new ItemArmorDC(DCArmorMaterial.DC_CHALCEDONY, DCMaterial.CHALCEDONY, slot,
					"chalcedony").setCreativeTab(ClimateMain.tool).setUnlocalizedName(
					ClimateCore.PACKAGE_BASE + "_" + type[i] + "_chalcedony");
			GameRegistry.register(MainInit.chalcArmor[i].setRegistryName(ClimateCore.PACKAGE_BASE + "_" + type[i]
					+ "_chalcedony"));

			MainInit.sapphireArmor[i] = new ItemArmorDC(DCArmorMaterial.DC_SAPPHIRE, DCMaterial.SAPPHIRE, slot,
					"sapphire").setCreativeTab(ClimateMain.tool).setUnlocalizedName(
					ClimateCore.PACKAGE_BASE + "_" + type[i] + "_sapphire");
			GameRegistry.register(MainInit.sapphireArmor[i].setRegistryName(ClimateCore.PACKAGE_BASE + "_" + type[i]
					+ "_sapphire"));
		}

		MainInit.linenUnder = new ItemArmorThinDC(DCArmorMaterial.DC_LINEN, DCMaterial.LINEN, EntityEquipmentSlot.LEGS,
				"linen").setCreativeTab(ClimateMain.tool).setUnlocalizedName(
				ClimateCore.PACKAGE_BASE + "_leggins_linen");
		GameRegistry.register(MainInit.linenUnder.setRegistryName(ClimateCore.PACKAGE_BASE + "_leggins_linen"));

		MainInit.linenCourt = new ItemArmorThinDC(DCArmorMaterial.DC_LINEN, DCMaterial.LINEN,
				EntityEquipmentSlot.CHEST, "linen").setCreativeTab(ClimateMain.tool).setUnlocalizedName(
				ClimateCore.PACKAGE_BASE + "_coat_linen");
		GameRegistry.register(MainInit.linenCourt.setRegistryName(ClimateCore.PACKAGE_BASE + "_coat_linen"));

		MainInit.clothUnder = new ItemArmorThinDC(DCArmorMaterial.DC_CLOTH, DCMaterial.LINEN, EntityEquipmentSlot.LEGS,
				"cloth").setCreativeTab(ClimateMain.tool).setUnlocalizedName(
				ClimateCore.PACKAGE_BASE + "_leggins_cloth");
		GameRegistry.register(MainInit.clothUnder.setRegistryName(ClimateCore.PACKAGE_BASE + "_leggins_cloth"));

		MainInit.workerSuit = new ItemArmorThinDC(DCArmorMaterial.DC_CLOTH, DCMaterial.LINEN, EntityEquipmentSlot.LEGS,
				"worker").setCreativeTab(ClimateMain.tool).setUnlocalizedName(
				ClimateCore.PACKAGE_BASE + "_leggins_worker");
		GameRegistry.register(MainInit.workerSuit.setRegistryName(ClimateCore.PACKAGE_BASE + "_leggins_worker"));

		MainInit.blackSuit = new ItemArmorThinDC(DCArmorMaterial.DC_CLOTH, DCMaterial.LINEN, EntityEquipmentSlot.LEGS,
				"suit").setCreativeTab(ClimateMain.tool).setUnlocalizedName(ClimateCore.PACKAGE_BASE + "_leggins_suit");
		GameRegistry.register(MainInit.blackSuit.setRegistryName(ClimateCore.PACKAGE_BASE + "_leggins_suit"));

		MagicInit.pendant = new ItemMagicalPendant(10).setCreativeTab(ClimateMain.tool).setUnlocalizedName(
				ClimateCore.PACKAGE_BASE + "_jewel_pendant");
		GameRegistry.register(MagicInit.pendant.setRegistryName(ClimateCore.PACKAGE_BASE + "_jewel_pendant"));

		MagicInit.badge = new ItemMagicalBadge(10).setCreativeTab(ClimateMain.tool).setUnlocalizedName(
				ClimateCore.PACKAGE_BASE + "_jewel_badge");
		GameRegistry.register(MagicInit.badge.setRegistryName(ClimateCore.PACKAGE_BASE + "_jewel_badge"));
	}

	static void registerMaterialEnum() {
		MainInit.repairPutty = new ItemRepairPutty().setCreativeTab(ClimateMain.tool).setUnlocalizedName(
				ClimateCore.PACKAGE_BASE + "_repair");
		GameRegistry.register(MainInit.repairPutty.setRegistryName(ClimateCore.PACKAGE_BASE + "_repair"));

		DCArmorMaterial.load();
		DCToolMaterial.load();
	}

	private static void registerHarvestLevel() {
		MainInit.ores.setHarvestLevel("pickaxe", 0);
	}

	static void registerBlock(Block block, String name) {
		Block reg = block.setRegistryName(name);
		GameRegistry.register(reg);
		GameRegistry.register(new DCItemBlock(reg));
	}

}
