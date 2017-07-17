package defeatedcrow.hac.main.achievement;

import java.util.List;

import com.google.common.collect.Lists;

import defeatedcrow.hac.core.DCInit;
import defeatedcrow.hac.food.FoodInit;
import defeatedcrow.hac.machine.MachineInit;
import defeatedcrow.hac.magic.MagicInit;
import defeatedcrow.hac.main.MainInit;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class AchievementClimate {

	private static final String BR = System.getProperty("line.separator");
	public static final List<Achievement> ACHIEVEMENTS = Lists.<Achievement>newArrayList();
	public static AchievementPage page;

	/* climate */
	public static final Achievement CLIMATE_MASTER = (new Achievement("achievement.climate_master",
			"dcs.climate_master", 3, -2, new ItemStack(MainInit.stevenson_screen, 1, 0), (Achievement) null) {
		@Override
		@SideOnly(Side.CLIENT)
		public String getDescription() {
			return super.getDescription() + "\n"
					+ I18n.translateToLocal("dcs.achievement_additional_desc.climate_master");
		}
	}).initIndependentStat().registerStat().setSpecial();

	public static final Achievement CLIMATE_SPECIALIST = (new Achievement("achievement.climate_specialist",
			"dcs.climate_specialist", 10, -2, new ItemStack(MainInit.achievementShield, 1, 0), CLIMATE_MASTER) {
		@Override
		@SideOnly(Side.CLIENT)
		public String getDescription() {
			return super.getDescription() + "\n"
					+ I18n.translateToLocal("dcs.achievement_additional_desc.climate_specialist");
		}
	}).initIndependentStat().registerStat().setSpecial();

	public static final Achievement CLIMATE_DAMAGE = (new Achievement("achievement.climate_damage",
			"dcs.climate_damage", -2, -2, MagicInit.infernalFlame, (Achievement) null)).initIndependentStat()
					.registerStat();

	public static final Achievement CLIMATE_ARMOR = (new Achievement("achievement.climate_prevent",
			"dcs.climate_prevent", -1, -2, MainInit.linenUnder, CLIMATE_DAMAGE)).registerStat();

	public static final Achievement CLIMATE_CHECKER = (new Achievement("achievement.climate_checker",
			"dcs.climate_checker", 0, -2, DCInit.climate_checker, CLIMATE_ARMOR)).registerStat();

	public static final Achievement CLIMATE_SMELT = (new Achievement("achievement.climate_smelt", "dcs.climate_smelt",
			1, -2, MainInit.bakedApple, CLIMATE_CHECKER)).registerStat();

	public static final Achievement METAL_TIER1 = (new Achievement("achievement.metal_tier1", "dcs.metal_tier1", 5, -2,
			new ItemStack(MainInit.oreIngot, 1, 4), CLIMATE_SMELT)).registerStat();

	public static final Achievement METAL_CHAMBER = (new Achievement("achievement.metal_chamber", "dcs.metal_chamber",
			6, -2, new ItemStack(MainInit.chamber, 1, 0), METAL_TIER1)).registerStat();

	public static final Achievement METAL_TIER2 = (new Achievement("achievement.metal_tier2", "dcs.metal_tier2", 7, -2,
			new ItemStack(MainInit.oreIngot, 1, 6), METAL_CHAMBER)).registerStat();

	public static final Achievement METAL_TIER3 = (new Achievement("achievement.metal_tier3", "dcs.metal_tier3", 8, -2,
			new ItemStack(MainInit.oreIngot, 1, 10), METAL_TIER2)).registerStat();

	public static final Achievement FOOD_STICK = (new Achievement("achievement.food_stick", "dcs.food_stick", 1, -4,
			new ItemStack(FoodInit.sticks, 1, 3), CLIMATE_SMELT)).registerStat();

	public static final Achievement FOOD_BREAD = (new Achievement("achievement.food_bread", "dcs.food_bread", 2, -4,
			new ItemStack(FoodInit.bread, 1, 1), FOOD_STICK)).registerStat();

	public static final Achievement FOOD_POT = (new Achievement("achievement.food_pot", "dcs.food_pot", 3, -4,
			new ItemStack(FoodInit.steelPot, 1, 0), FOOD_BREAD)).registerStat();

	/* machine */
	public static final Achievement MACHINE_MASTER = (new Achievement("achievement.machine_master",
			"dcs.machine_master", 3, 0, MachineInit.windmill, (Achievement) null) {
		@Override
		@SideOnly(Side.CLIENT)
		public String getDescription() {
			return super.getDescription() + "\n"
					+ I18n.translateToLocal("dcs.achievement_additional_desc.machine_master");
		}
	}).initIndependentStat().registerStat().setSpecial();

	public static final Achievement MACHINE_SPECIALIST = (new Achievement("achievement.machine_specialist",
			"dcs.machine_specialist", 10, 0, new ItemStack(MainInit.achievementShield, 1, 1), MACHINE_MASTER) {
		@Override
		@SideOnly(Side.CLIENT)
		public String getDescription() {
			return super.getDescription() + "\n"
					+ I18n.translateToLocal("dcs.achievement_additional_desc.machine_specialist");
		}
	}).initIndependentStat().registerStat().setSpecial();

	public static final Achievement MACHINE_GEAR = (new Achievement("achievement.machine_gear", "dcs.machine_gear", -2,
			0, new ItemStack(MainInit.materials, 1, 5), (Achievement) null)).initIndependentStat().registerStat();

	public static final Achievement MACHINE_PLACE = (new Achievement("achievement.machine_place", "dcs.machine_place",
			-1, 0, MachineInit.shaft_s, MACHINE_GEAR)).registerStat();

	public static final Achievement MACHINE_CHANGE = (new Achievement("achievement.machine_rotate",
			"dcs.machine_rotate", 0, 0, MainInit.wrench, MACHINE_PLACE)).registerStat();

	public static final Achievement MACHINE_ALLOY = (new Achievement("achievement.machine_alloy", "dcs.machine_alloy",
			1, 0, new ItemStack(MainInit.materials, 1, 6), MACHINE_CHANGE)).registerStat();

	public static final Achievement MACHINE_USING = (new Achievement("achievement.machine_stonemill",
			"dcs.machine_stonemill", 5, 0, MachineInit.stonemill, MACHINE_ALLOY)).registerStat();

	public static final Achievement MACHINE_EXCHANGER = (new Achievement("achievement.machine_heatex",
			"dcs.machine_heatex", 6, 0, MachineInit.heatPump, MACHINE_USING)).registerStat();

	public static final Achievement MACHINE_SUS = (new Achievement("achievement.machine_sus", "dcs.machine_sus", 7, 0,
			MachineInit.shaft2_s, MACHINE_EXCHANGER)).registerStat();

	public static final Achievement MACHINE_TIER3 = (new Achievement("achievement.machine_tier3", "dcs.machine_tier3",
			8, 0, MachineInit.pressMachine, MACHINE_SUS)).registerStat();

	/* magic */
	public static final Achievement MAGIC_MASTER = (new Achievement("achievement.magic_master", "dcs.magic_master", 3,
			2, new ItemStack(MainInit.gems, 1, 4), (Achievement) null) {
		@Override
		@SideOnly(Side.CLIENT)
		public String getDescription() {
			return super.getDescription() + "\n"
					+ I18n.translateToLocal("dcs.achievement_additional_desc.magic_master");
		}
	}).initIndependentStat().registerStat().setSpecial();

	public static final Achievement MAGIC_SPECIALIST = (new Achievement("achievement.magic_specialist",
			"dcs.magic_specialist", 10, 2, new ItemStack(MainInit.achievementShield, 1, 2), MAGIC_MASTER) {
		@Override
		@SideOnly(Side.CLIENT)
		public String getDescription() {
			return super.getDescription() + "\n"
					+ I18n.translateToLocal("dcs.achievement_additional_desc.magic_specialist");
		}
	}).initIndependentStat().registerStat().setSpecial();

	public static final Achievement MAGIC_GEM = (new Achievement("achievement.magic_getgem", "dcs.magic_getgem", -2, 2,
			new ItemStack(MainInit.gems, 1, 0), (Achievement) null)).initIndependentStat().registerStat();

	public static final Achievement MAGIC_GEM_RARE = (new Achievement("achievement.magic_raregem", "dcs.magic_raregem",
			-1, 2, new ItemStack(MainInit.gems, 1, 7), MAGIC_GEM)).registerStat();

	public static final Achievement MAGIC_CHARM = (new Achievement("achievement.magic_charm", "dcs.magic_charm", 0, 2,
			new ItemStack(MagicInit.pendant, 1, 0), MAGIC_GEM_RARE)).registerStat();

	public static final Achievement MAGIC_KNIFE = (new Achievement("achievement.magic_knife", "dcs.magic_knife", 1, 2,
			new ItemStack(MagicInit.daggerSilver, 1, 0), MAGIC_CHARM)).registerStat();

	public static final Achievement MAGIC_DAGGER = (new Achievement("achievement.magic_dagger", "dcs.magic_dagger", 5,
			2, new ItemStack(MagicInit.daggerMagic, 1, 14), MAGIC_KNIFE)).registerStat();

	public static final Achievement MAGIC_ELESTIAL = (new Achievement("achievement.magic_elestial",
			"dcs.magic_elestial", 6, 2, new ItemStack(MagicInit.elestial, 1, 0), MAGIC_DAGGER)).registerStat();

	public static final Achievement MAGIC_MACE = (new Achievement("achievement.magic_mace", "dcs.magic_mace", 7, 2,
			new ItemStack(MagicInit.maceIce, 1, 0), MAGIC_ELESTIAL)).registerStat();

	public static final Achievement MAGIC_BIRD = (new Achievement("achievement.magic_bird", "dcs.magic_bird", 8, 2,
			new ItemStack(MagicInit.maceBird, 1, 0), MAGIC_MACE)).registerStat();

	public static void load() {

		Achievement[] list = new Achievement[] {
				CLIMATE_MASTER,
				CLIMATE_SPECIALIST,
				CLIMATE_DAMAGE,
				CLIMATE_CHECKER,
				CLIMATE_ARMOR,
				CLIMATE_SMELT,

				METAL_CHAMBER,
				METAL_TIER1,
				METAL_TIER2,
				METAL_TIER3,

				FOOD_STICK,
				FOOD_BREAD,
				FOOD_POT,

				MACHINE_MASTER,
				MACHINE_SPECIALIST,
				MACHINE_GEAR,
				MACHINE_PLACE,
				MACHINE_CHANGE,
				MACHINE_ALLOY,
				MACHINE_USING,
				MACHINE_EXCHANGER,
				MACHINE_SUS,
				MACHINE_TIER3,

				MAGIC_MASTER,
				MAGIC_SPECIALIST,
				MAGIC_GEM,
				MAGIC_GEM_RARE,
				MAGIC_CHARM,
				MAGIC_KNIFE,
				MAGIC_DAGGER,
				MAGIC_ELESTIAL,
				MAGIC_MACE,
				MAGIC_BIRD
		};

		page = new AchievementPage("HeatAndClimate", list);
		AchievementPage.registerAchievementPage(page);
	}

}
