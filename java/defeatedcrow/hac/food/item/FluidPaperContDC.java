package defeatedcrow.hac.food.item;

import javax.annotation.Nullable;

import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.FluidTankProperties;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.capability.IFluidTankProperties;
import defeatedcrow.hac.food.FoodInit;

/**
 * 空容器にPAPERを返却するコンテナアイテム
 */
public class FluidPaperContDC implements IFluidHandler, ICapabilityProvider {

	protected final ItemStack container;

	public FluidPaperContDC(ItemStack container) {
		this.container = container;
	}

	/* Fluid */

	@Nullable
	public FluidStack getFluid() {
		int meta = container.getItemDamage();
		String name = ItemFluidPack.getFluidName(meta);
		Fluid fluid = FluidRegistry.getFluid(name);
		if (fluid != null) {
			return new FluidStack(fluid, 250);
		}
		return null;
	}

	protected void setFluid(FluidStack resource) {
		if (container.stackSize != 1 || resource == null || !canFillFluidType(resource)) {
			return;
		}
		int meta = 0;
		if (resource.getFluid() == FluidRegistry.WATER) {
			meta = 1;
		} else if (resource.getFluid() == FoodInit.cream) {
			meta = 3;
		} else if (resource.getFluid() == FoodInit.oil) {
			meta = 4;
		} else if (resource.getFluid().getName().contains("milk")) {
			meta = 2;
		}

		if (meta == 0) {
			return;
		}

		container.setItemDamage(meta);
	}

	@Override
	public IFluidTankProperties[] getTankProperties() {
		return new FluidTankProperties[] { new FluidTankProperties(getFluid(), 250) };
	}

	@Override
	public int fill(FluidStack resource, boolean doFill) {
		if (container.stackSize != 1 || resource == null || resource.amount < 250 || !canFillFluidType(resource)) {
			return 0;
		}

		int fillAmo = 250;
		int meta = 0;
		if (resource.getFluid() == FluidRegistry.WATER) {
			meta = 1;
		} else if (resource.getFluid() == FoodInit.cream) {
			meta = 3;
		} else if (resource.getFluid() == FoodInit.oil) {
			meta = 4;
		} else if (resource.getFluid().getName().contains("milk")) {
			meta = 2;
		}

		if (meta == 0) {
			return 0;
		}

		if (doFill) {
			container.setItemDamage(meta);
		}
		return fillAmo;

	}

	@Override
	public FluidStack drain(FluidStack resource, boolean doDrain) {
		if (container.stackSize != 1 || resource == null || resource.amount < 250 || !resource.isFluidEqual(getFluid())) {
			return null;
		}
		return drain(resource.amount, doDrain);
	}

	@Override
	public FluidStack drain(int maxDrain, boolean doDrain) {
		if (container.stackSize != 1 || maxDrain < 250) {
			return null;
		}

		FluidStack contained = getFluid();
		if (contained == null || !canDrainFluidType(contained)) {
			return null;
		}

		final int drainAmount = 250;
		FluidStack drained = contained.copy();
		drained.amount = drainAmount;

		if (doDrain) {
			setContainerToEmpty();
		}

		return drained;
	}

	public boolean canFillFluidType(FluidStack fluid) {
		if (container.getItemDamage() > 0) {
			return false;
		}
		return true;
	}

	public boolean canDrainFluidType(FluidStack fluid) {
		return true;
	}

	protected void setContainerToEmpty() {
		container.setItemDamage(0);
	}

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		return capability == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		return capability == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY ? (T) this : null;
	}

}