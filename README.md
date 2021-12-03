
# RedstoneHelper2
Utilities for the Minecraft redstone engineer.


| | | |  
|--|--|--|  
|![Imgur](https://i.imgur.com/hrJLeIv.gif) | ![Imgur](https://imgur.com/aNMXJlD.gif) | ![Imgur](https://i.imgur.com/v9bR6Yy.gif)|  
|||  
![](https://i.imgur.com/pUQEjON.png)|![Imgur](https://i.imgur.com/CQ7jdIo.png)

# Requirements
* [CommandAPI](https://www.spigotmc.org/resources/api-commandapi-1-16-5-1-18.62353/) plugin
## Features

### Commands
| Command | Description | Permission |  
|--|--|--|  
| /redstonehelper | Shows information about the plugin | redstonehelper2.redstonehelper |  
| /redstonehelper reload| Reloads plugin configuration | redstonehelper2.reload |  
| /dec2bin [Number] | Converts decimal (base 10) to binary (base 2)| redstonehelper2.dec2bin|  
| /bin2dec [Binary] | Converts binary (base 2) to decimal (base 10) | redstonehelper2.bin2dec|  
| /furnace [0-15] | Gives you a furnace named a number 0-15 | redstonehelper2.furnace|
| /barrel [0-15] | Gives you a barrel named a number 0-15 | redstonehelper2.barrel
| /chest [0-15] | Gives you a chest named a number 0-15 | redstonehelper2.chest
| /dropper [0-15] | Gives you a dropper named a number 0-15 | redstonehelper2.dropper
| /dispenser [0-15] | Gives you a dispenser named a number 0-15 | redstonehelper2.dispenser
| /shulkerbox [0-15] | Gives you a shulker box named a number 0-15 | redstonehelper2.shulkerbox

### Blocks
Supported blocks:
* Flipping (Shift+Place)
	* Sticky piston
	* Piston
	* Repeater
	* Redstone wall torch
	* Comparator
	* Observer
* Filling (Shift+Right click)
	* End portal frame
	* Composter
* Automatic filling for signal strength
	* Furnace (Based off name of block 0-15)
	* Barrel (Based off name of block 0-15)
	* Chest (Based off name of block 0-15)
	* Dropper (Based off name of block 0-15)
	* Dispenser (Based off name of block 0-15)
	* Shulker box (Based off name of block 0-15)
* Delete dropped items on block break
	* Furnace
	* Barrel
	* Chest
	* Dropper
	* Dispenser
	* Shulker box
### Utility
* Delete items when containers are broken
* Set proper amount of items inside containers for desired signal strength based off name of the container
