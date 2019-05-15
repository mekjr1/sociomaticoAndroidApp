toutnoir = Image.load ("png/presentation/toutnoir.png")
rayman1 = Image.load ("png/presentation/rayman1.png")
rayman2 = Image.load ("png/presentation/rayman2.png")
rayman3 = Image.load ("png/presentation/rayman3.png")
rayman4 = Image.load ("png/presentation/rayman4.png")
rayman5 = Image.load ("png/presentation/rayman5.png")
rayman6 = Image.load ("png/presentation/rayman6.png")
presentation = Image.load ("png/presentation/presentation.png")
texte1 = "lire la presentation"
texte2 = "passer la presentation"
rouge = Color.new(255,0,0)

selection=1 

while true do

pad = Controls.read() 
screen:clear()
screen:blit (0,0,toutnoir)
screen:blit (2,105,rayman3)
screen:blit (2,200,rayman2)
screen:blit (2,10,rayman1)
screen:blit (410,10,rayman4)
screen:blit (410,120,rayman5)
screen:blit (410,200,rayman6)
screen:blit (140,80,presentation)
screen:print (160,210,texte1,rouge)
screen:print (160,240,texte2,rouge)

if pad:up() then selection = selection -1 end
if pad:down() then selection = selection +1 end
if selection == 0 then selection =1 end
if selection == 3 then selection = 2 end

if selection == 1 then 
screen:blit (120,210,main)
end
if selection == 2 then 
screen:blit (120,240,main)
end
if pad:cross() then 
if selection == 1 then 
dofile("presentation2.lua") 
elseif selection== 2 then
dofile("niveau1.lua")
end 
end

screen.flip()
for i=0,3 do
screen.waitVblankStart()
end
end