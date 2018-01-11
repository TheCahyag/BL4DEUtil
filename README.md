# BL4DEUtil
**Not being developed ATM**
## Commands:
/Blade - Prints info message regarding the plugin<br />
/Blade help - Prints commands and their respective usages<br />
/Blade debug - Toggles debug information  
/GMC - Sets users gamemode to creative<br />
/GMS - Sets users gamemode to survival<br />
/Ranks [labrat|technician|scientist]<br />
/LastOnline - Shows the last 10 players who have logged onto the server with their last login times  
/GetChunkLoadingWard - Information for getting a extrautils2:chunkloader  
/GetChunkLoadingWard Confirm - Takes 3 emeralds and gives the player one chunk loaded  

## Permissions:
`bl4de.base` - /Blade, /Blade help<br />
`bl4de.debug.base` - /Blade debug  
`bl4de.gamemode.creative` - /GMC<br />
`bl4de.gamemode.survival` - /GMS<br />
`bl4de.ranks.base` - /Ranks, /Ranks [labrat|technician|scientist]<br />
`bl4de.getclw.base` - /GetChunkLoadingWard, /GetCLW  
`bl4de.getclw.confirm` - /GetChunkLoadingWard Confirm, /GetCLW C  
`bl4de.lastonline.base` - /LastOnline, /LO  

## TODO:
* ~~Make commands clickable in /GetCLW and /Blade ?~~
* ~~Keep track of how many chunk loading wards each player has received and enable a limit~~
* Allow a permission to by pass this limit/ Ooooorrrrr set a dynamic permission that will define a players limit (bl4de.getclw.limit.10)
* ~~Allow to see the time a specific player was online (/LastOnline TheCahyag)~~
* ~~Add /GetCLW and /LastOnline to the /Blade ? commands~~
* Add functionality to the CLW check so if the player breaks a chunk loading ward that is supporting a AE2Stuff block the action is canceled, or all the AE2Stuff blocks are destroyed and placed in the inventory of the player
* Add functionality to the /LO command and display near the time how long since the player has been on relative to the current time. (1 day ago, 3 hours ago, ... etc)
* ~~Refactor old Text creation sections for most BL4DE commands~~
* Look into whether I must be tracking UUIDs instead just the players name (if its worth it)
* ~~Consider making commands clickable in the /rank child commands~~ nah gonna pass on this
* Log where people place chunk loadings and be able to call up the list
* Make BL4DEUtil debug boolean private
* Look into creating an abstract and/or interface based hierarchical systems for commands
