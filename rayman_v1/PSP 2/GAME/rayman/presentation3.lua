toutnoir = Image.load ("png/presentation/toutnoir.png")
rayman1 = Image.load ("png/presentation/rayman1.png")
rayman2 = Image.load ("png/presentation/rayman2.png")
rayman3 = Image.load ("png/presentation/rayman3.png")
rayman4 = Image.load ("png/presentation/rayman4.png")
rayman5 = Image.load ("png/presentation/rayman5.png")
rayman6 = Image.load ("png/presentation/rayman6.png")
toi = Image.load ("png/presentation/toi.png")

texte = "commencer a jouer !"
rouge = Color.new(255,0,0)

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
screen:print (160,240,texte,rouge)
screen:blit (180,60,toi)
screen:blit (120,240,main)

if pad:cross() then
dofile("niveau1.lua")
end 

screen.flip()
screen.waitVblankStart()
screen:clear()
end