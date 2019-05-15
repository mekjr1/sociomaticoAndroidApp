rouge = Color.new (255,0,0)
psplaypresente = Image.load ("png/psplaypresente.png")
concours2007psp = Image.load ("png/concours2007psp.png")
lua = Image.load ("png/lua.png")
raymanpspv01 = Image.load ("png/raymanpspv0.1.png")
remerciments = Image.load ("png/remerciments.png")
mineuteurexit = Timer.new()
mineuteurexit:start()

while true do
screen:clear()

pad = Controls.read()
if pad:start() then
mineuteurexit:start()
end

Tempexit = mineuteurexit:time()
if Tempexit <= 1000 then
screen:blit (0,0,concours2007psp)
elseif Tempexit > 1000 and Tempexit < 2000 then
screen:blit (0,0,lua)
elseif Tempexit > 2000 and Tempexit < 4000 then
screen:blit (0,0,psplaypresente)
elseif Tempexit > 4000 and Tempexit < 6000 then
screen:blit (0,0,raymanpspv01)
elseif Tempexit > 6000 then
dofile("menu.lua")
break 
end

screen.flip()
screen.waitVblankStart()
screen:clear()
end