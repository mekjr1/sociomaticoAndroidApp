niveaurate = Image.load ("png/niveaurate.png")
vie100 = Image.load ("png/vie/100.png")
vie75 = Image.load ("png/vie/75.png")
vie50 = Image.load ("png/vie/50.png")
vie25 = Image.load ("png/vie/25.png")
fondecranniveau = Image.load ("png/trou/petittroumilieu.png")
raymandroite = Image.load ("png/position-rayman/raymandroite.png")
raymangauche = Image.load ("png/position-rayman/raymangauche.png")
raymanbasdroite = Image.load ("png/position-rayman/raymanbasdroite.png")
raymanbasgauche = Image.load ("png/position-rayman/raymanbasgauche.png")
raymanregardedroite = Image.load ("png/position-rayman/raymanregardedroite.png")
raymanregardegauche = Image.load ("png/position-rayman/raymanregardegauche.png")
violet = Color.new(128,0,128)
X = 20
Y = 220
rayman = {}
rayman.gravity = 220
rayman.y = 220
rayman.x = 20
rayman.jumpspeed = 10
rayman.jumpstate = "sol"
statut="droite"

while true do

pad = Controls.read() 
screen:clear()
screen:blit (0,0,fondecranniveau)

positionY = 210
positionX = 10

if pad:left() then 
statut = "gauche" 
X = X-2
end 

if pad:right() then 
statut = "droite" 
X = X+2
end

if pad:down() then
if pad:right() then
statut = "basdroite" 
end
end

if pad:down() then
if pad:left() then
statut = "basgauche" 
end
end

if pad:triangle() then
if pad:right() then
statut = "triangledroite" 
end
end

if pad:triangle() then
if pad:left() then
statut = "trianglegauche" 
end
end

if pad:cross() and rayman.jumpstate == "sol" then rayman.jumpstate = "en saut" end

if rayman.jumpstate == "en saut" then 
rayman.jumpspeed = rayman.jumpspeed - 0.5
rayman.gravity = rayman.gravity - rayman.jumpspeed 
end

if rayman.gravity < 0 then 
rayman.jumpstate = "retombe"
end

if rayman.gravity < 220 and rayman.jumpstate == "retombe" then 
rayman.gravity = rayman.gravity + (rayman.jumpspeed + 3) 
end

if rayman.gravity == 220 then 
rayman.jumpspeed = 10
rayman.jumpstate = "sol"
end

rayman.y = rayman.gravity

if rayman.jumpstate ~= "sol" then
if statut=="gauche" then 
screen:blit(X,rayman.y,raymangauche) end
 if statut=="droite" then 
screen:blit(X,rayman.y,raymandroite) end
end

if rayman.jumpstate == "sol" then 
if rayman.gravity > 220 then rayman.gravity = 220 end

if statut == "gauche" then screen:blit(X, positionY, raymangauche)
end
if statut == "droite" then screen:blit(X, positionY, raymandroite)
end
if statut == "basdroite" then screen:blit(X,240, raymanbasdroite)
end
if statut == "basgauche" then screen:blit(X,240, raymanbasgauche)
end
if statut == "triangledroite" then screen:blit(X,210, raymanregardedroite)
end
if statut == "trianglegauche" then screen:blit(X,210, raymanregardegauche)
end
end

if statutvie == "vie100" then screen:blit(360,20, vie100)
end
if statutvie == "vie75" then screen:blit(360,20, vie75)
end
if statutvie == "vie50" then screen:blit(360,20, vie50)
end
if statutvie == "vie25" then screen:blit(360,20, vie25)
end
if statutvie == "vie00" then screen:blit(0,0, niveaurate)
end

if statut == "gauche" then
if X<-2 then
X=-2
end
end

if statutvie == "vie00" then
if pad:start() then
dofile("menu.lua")
end
end

if statutvie == "vie100" then
if colision == 1 then
statutvie = "vie75"
end
end

if statutvie == "vie75" then
if colision == 2 then
statutvie = "vie50"
end
end

if statutvie == "vie50" then
if colision == 3 then
statutvie = "vie25"
end
end

if statutvie == "vie25" then
if colision == 4 then
statutvie = "vie00"
end
end

if statut == "droite" then
if colision==0 then
if X>182 and X<220 and rayman.y>=220 then
colision=1
dofile("niveau1-7.lua")
end
end
end

if statut == "droite" then
if colision==1 then
if X>182 and X<220 and rayman.y>=220 then
colision=2
dofile("niveau1-7.lua")
end
end
end

if statut == "droite" then
if colision==2 then
if X>182 and X<220 and rayman.y>=220 then
colision=3
dofile("niveau1-3.lua")
end
end
end

if statut == "droite" then
if colision==3 then
if X>182 and X<220 and rayman.y>=220 then
colision=4
dofile("niveau1-7.lua")
end
end
end

if statut == "gauche" then
if colision==0 then
if X>182 and X<220 and rayman.y>=220 then
colision=1
dofile("niveau1-7.lua")
end
end
end

if statut == "gauche" then
if colision==1 then
if X>182 and X<220 and rayman.y>=220 then
colision=2
dofile("niveau1-7.lua")
end
end
end

if statut == "gauche" then
if colision==2 then
if X>182 and X<220 and rayman.y>=220 then
colision=3
dofile("niveau1-7.lua")
end
end
end

if statut == "gauche" then
if colision==3 then
if X>182 and X<220 and rayman.y>=220 then
colision=4
dofile("niveau1-7.lua")
end
end
end

if statut == "triangledroite" then
if colision==0 then
if X>182 and X<220 and rayman.y>=220 then
colision=1
dofile("niveau1-7.lua")
end
end
end

if statut == "triangledroite" then
if colision==1 then
if X>182 and X<220 and rayman.y>=220 then
colision=2
dofile("niveau1-7.lua")
end
end
end

if statut == "triangledroite" then
if colision==2 then
if X>182 and X<220 and rayman.y>=220 then
colision=3
dofile("niveau1-7.lua")
end
end
end

if statut == "triangledroite" then
if colision==3 then
if X>182 and X<220 and rayman.y>=220 then
colision=4
dofile("niveau1-7.lua")
end
end
end

if statut == "trianglegauche" then
if colision==0 then
if X>182 and X<220 and rayman.y>=220 then
colision=1
dofile("niveau1-7.lua")
end
end
end

if statut == "trianglegauche" then
if colision==1 then
if X>182 and X<220 and rayman.y>=220 then
colision=2
dofile("niveau1-7.lua")
end
end
end

if statut == "trianglegauche" then
if colision==2 then
if X>182 and X<220 and rayman.y>=220 then
colision=3
dofile("niveau1-7.lua")
end
end
end

if statut == "trianglegauche" then
if colision==3 then
if X>182 and X<220 and rayman.y>=220 then
colision=4
dofile("niveau1-7.lua")
end
end
end

if statut == "basdroite" then
if colision==0 then
if X>182 and X<220 and rayman.y>=220 then
colision=1
dofile("niveau1-7.lua")
end
end
end

if statut == "basdroite" then
if colision==1 then
if X>182 and X<220 and rayman.y>=220 then
colision=2
dofile("niveau1-7.lua")
end
end
end

if statut == "basdroite" then
if colision==2 then
if X>182 and X<220 and rayman.y>=220 then
colision=3
dofile("niveau1-7.lua")
end
end
end

if statut == "basdroite" then
if colision==3 then
if X>182 and X<220 and rayman.y>=220 then
colision=4
dofile("niveau1-7.lua")
end
end
end

if statut == "basgauche" then
if colision==0 then
if X>182 and X<220 and rayman.y>=220 then
colision=1
dofile("niveau1-7.lua")
end
end
end

if statut == "basgauche" then
if colision==1 then
if X>182 and X<220 and rayman.y>=220 then
colision=2
dofile("niveau1-7.lua")
end
end
end

if statut == "basgauche" then
if colision==2 then
if X>182 and X<220 and rayman.y>=220 then
colision=3
dofile("niveau1-7.lua")
end
end
end

if statut == "basgauche" then
if colision==3 then
if X>182 and X<220 and rayman.y>=220 then
colision=4
dofile("niveau1-7.lua")
end
end
end

if pad:circle() then
if pad:r() then
colision=0
statutvie = "vie100"
dofile("niveau2.lua") 
end
end

if pad:circle() then
if pad:l() then
colision=0
statutvie = "vie100"
dofile("niveau1.lua") 
end
end

if statut == "trianglegauche" then
if X<-4 then
X=-4
end
end

if statut == "droite" then
if X<-2 then
X=-2
end
end

if statut == "droite" then
if X>470 then
dofile("niveau1-8.lua")
end
end

if positionX<462 then 
positionX=positionX+1

if positionX>10 then
positionX=positionX-1
 
end 
end

screen.flip()
screen.waitVblankStart()
screen:clear()
end