package hashmonopolist.redstonehelper2.util;

import org.bukkit.block.Block;
import org.bukkit.block.data.type.*;

public class Flippers {
    public static void flipPiston(Block block) {
        Piston blockData = (Piston) block.getBlockData();
        blockData.setFacing(blockData.getFacing().getOppositeFace());
        block.setBlockData(blockData);
    }
    public static void flipRedstoneWallTorch(Block block) {
        RedstoneWallTorch blockData = (RedstoneWallTorch) block.getBlockData();
        blockData.setFacing(blockData.getFacing().getOppositeFace());
        block.setBlockData(blockData);
    }
    public static void flipRepeater(Block block) {
        Repeater blockData = (Repeater) block.getBlockData();
        blockData.setFacing(blockData.getFacing().getOppositeFace());
        block.setBlockData(blockData);
    }
    public static void flipComparator(Block block) {
        Comparator blockData = (Comparator) block.getBlockData();
        blockData.setFacing(blockData.getFacing().getOppositeFace());
        block.setBlockData(blockData);
    }
    public static void flipObserver(Block block) {
        Observer blockData = (Observer) block.getBlockData();
        blockData.setFacing(blockData.getFacing().getOppositeFace());
        block.setBlockData(blockData);
    }
}
