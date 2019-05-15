main = Image.load ("png/main.png")
menu = Image.load ("png/menu.png")
statutvie = "vie100"
colision=0
selection=1 

while true do
pad = Controls.read() 
screen:clear()
screen:blit (0,0,menu)
if selection == 1 then 
screen:blit (12,110,main)
end 
if selection == 2 then 
screen:blit (12,140,main)
end
if selection == 3 then 
screen:blit (12,170,main)
end 
if pad:cross() then 
if selection == 1 then 
dofile("presentation.lua") 
elseif selection== 2 
then os.exit() 
end
 if selection == 3 then 
dofile("remerciment.lua")
end
end 
if pad:up() then selection = selection -1 end
if pad:down() then selection = selection +1 end
if selection == 0 then selection =1 end
if selection == 4 then selection = 3 end

screen.flip()
for i=0,8 do
screen.waitVblankStart()
end
end