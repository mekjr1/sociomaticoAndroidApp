niveaureussit = Image.load ("png/niveaureussit.png")
main = Image.load ("png/main.png")
selection=1

while true do

pad = Controls.read() 
screen:clear()
screen:blit (0,0,niveaureussit)

if selection == 1 then 
screen:blit (110,220,main)
end 

if selection == 2 then 
screen:blit (110,240,main)
end

if pad:cross() then 
if selection == 1 then 
dofile("niveau1-9.lua")
end

 if selection == 2 then 
dofile("menu.lua")
end
end 

if pad:up() then selection = selection -1 end
if pad:down() then selection = selection +1 end
if selection == 0 then selection =1 end
if selection == 3 then selection = 2 end

screen.flip()
for i=0,8 do
screen.waitVblankStart()
end
end