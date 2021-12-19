

# RedstoneHelper2
![RedstoneHelper2 Build](https://github.com/1Gigabit/RedstoneHelper2/actions/workflows/maven.yml/badge.svg)
<p align="center">
<img src="https://i.imgur.com/FOyEMq9.png" width=200 height=200>
</p>


Utilities for the Minecraft redstone engineer.

| | | |    
|--|--|--|    
|![Imgur](https://i.imgur.com/hrJLeIv.gif) | ![Imgur](https://imgur.com/aNMXJlD.gif)  
| ![Imgur](https://i.imgur.com/v9bR6Yy.gif)|    
|||    
![](https://i.imgur.com/pUQEjON.png)|![Imgur](https://i.imgur.com/CQ7jdIo.png)

# Requirements

* Spigot 1.17.1 (Tested)

## Features

### Commands

| Command | Description | Permission |    
|--|--|--|    
| /redstonehelper | Shows information about the plugin | redstonehelper2.redstonehelper |    
| /redstonehelper reload| Reloads plugin configuration | redstonehelper2.reload |    
| /dec2bin [Number] | Converts decimal (base 10) to binary (base 2)| redstonehelper2.dec2bin|    
| /bin2dec [Binary] | Converts binary (base 2) to decimal (base 10) | redstonehelper2.bin2dec|
| /hex2dec [Hexadecimal ] | Converts hexadecimal (base 16) to decimal (base 10) | redstonehelper2.hex2dec
| /furnace [0-15] | Gives you a furnace that is prefilled with just enough items to meet desired redstone strength | redstonehelper2.furnace |
 /barrel [0-15] |  Gives you a barrel that is prefilled with just enough items to meet desired redstone strength | redstonehelper2.barrel | /chest [0-15] | Gives you a chest named a number 0-15 |  redstonehelper2.chest 
/dropper [0-15] |  Gives you a dropper that is prefilled with just enough items to meet desired redstone strength | redstonehelper2.dropper | /dispenser [0-15] | Gives you a dispenser named a number 0-15 | redstonehelper2.dispenser
/shulkerbox [0-15] |  Gives you a shulkerbox that is prefilled with just enough items to meet desired redstone strength | redstonehelper2.shulkerbox

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
  * Shulker box (Based off name of block 0-15
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
* Shift+right clicking redstone shows power level on action bar

### Configuration

<details>  
<summary>Configuration</summary>  
<br>  
<pre><code>  
#RedstoneHelper2 V1.0.0  
commands:  
  redstonehelper:  
    permission: redstonehelper2.redstonehelper2  
  reload:  
      permission: redstonehelper2.reload  
  bin2dec:  
    enabled: true  
  permission: redstonehelper2.bin2dec  
  dec2bin:  
    enabled: true  
  permission: redstonehelper2.dec2bin  
  hex2dec:  
    enabled: true  
  permission: redstonehelper2.hex2dec  
  barrel:  
    enabled: true  
  permission: redstonehelper2.barrel  
  furnace:  
    enabled: true  
  permission: redstonehelper2.furnace  
  chest:  
    enabled: true  
  permission: redstonehelper2.chest  
  dropper:  
    enabled: true  
  permission: redstonehelper2.dropper  
  dispenser:  
    enabled: true  
  permission: redstonehelper2.dispenser  
  shulkerbox:  
    enabled: true  
  permission: redstonehelper2.shulkerbox  
blocks:  
  flipping: #Flipping the directional face of blocks  
  COMPARATOR:  
      enabled: true  
  REPEATER:  
      enabled: true  
  REDSTONE_WALL_TORCH:  
      enabled: true  
  OBSERVER:  
      enabled: true  
  PISTON:  
      enabled: true  
  STICKY_PISTON:  
      enabled: true  
  naming: #filling named container blocks with amount of items for desired signal strength  
  BARREL:  
      enabled: true  
  FURNACE:  
      enabled: true  
  CHEST:  
      enabled: true  
  DISPENSER:  
      enabled: true  
  DROPPER:  
      enabled: true  
  SHULKER_BOX:  
      enabled: true  
utility:  
  #shift+right clicking redstone to display redstone power level on action bar  
  redstone_action_bar: true  
  # Delete items dropped from containers when broken  
  delete_items:  
    enabled: true  
  barrel: true  
  furnace: true  
  chest: true  
  dispenser: true  
  dropper: true  
  shulker_box: true  
messages:  
  composter: "&cComposter level:&a "  
  end_portal_frame: "&cEye:&a "  
  dec2bin: "&cBinary:&a "  
  bin2dec: "&cDecimal:&a "  
  hex2dec: "&cDecimal:&a "  
  redstone_level: "&cPower:&a  "  
  bin2dec_error: "&cPlease check your input"  
  hex2dec_error: "&cPlease check your input"  
  reload: "&cConfiguration reloaded"  
  not_within_range: "&cMust be within 0-15"</code></pre>  
</details>
