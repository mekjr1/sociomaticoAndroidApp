niveaurate = Image.load ("png/niveaurate.png")
vie100 = Image.load ("png/vie/100.png")
vie75 = Image.load ("png/vie/75.png")
vie50 = Image.load ("png/vie/50.png")
vie25 = Image.load ("png/vie/25.png")
fondecranniveau = Image.load ("png/fondecranniveau.png")
raymandroite = Image.load ("png/position-rayman/raymandroite.png")
raymangauche = Image.load ("png/position-rayman/raymangauche.png")
raymanbasdroite = Image.load ("png/position-rayman/raymanbasdroite.png")
raymanbasgauche = Image.load ("png/position-rayman/raymanbasgauche.png")
raymanregardedroite = Image.load ("png/position-rayman/raymanregardedroite.png")
raymanregardegauche = Image.load ("png/position-rayman/raymanregardegauche.png")
niveau1 = Image.load ("png/niveau/niveau1.png")
texte1 = "appuie sur gauche pour faire glisser rayman vers la gauche"
texte2 = "appuie sur droite pour faire glisser rayman vers la droite"
violet = Color.new(128,0,128)
X = 20
Y = 230
rayman = {}
rayman.gravity = 230
rayman.y = 230
rayman.x = 20
rayman.jumpspeed = 10
rayman.jumpstate = "sol"
statut="droite"

while true do

pad = Controls.read() 
screen:clear()
screen:blit (0,0,fondecranniveau)
screen:blit (170,20,niveau1)
screen:print (10,70,texte1,violet)
screen:print (10,80,texte2,violet)

positionY = 210
positionX = 30

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

if pad:cross() and rayman.jumpstate == "sol" then rayman.jumpstate = "en saut" end

if rayman.jumpstate == "en saut" then 
rayman.jumpspeed = rayman.jumpspeed - 0.5
rayman.gravity = rayman.gravity - rayman.jumpspeed 
end

if rayman.gravity < 0 then 
rayman.jumpstate = "retombe"
end

if rayman.gravity < 230 and rayman.jumpstate == "retombe" then 
rayman.gravity = rayman.gravity + (rayman.jumpspeed + 3) 
end

if rayman.gravity == 230 then 
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
if rayman.gravity > 230 then rayman.gravity = 230 end

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

if statut == "vie00" then
if pad:cross() then
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
dofile("niveau1-2.lua") 
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
