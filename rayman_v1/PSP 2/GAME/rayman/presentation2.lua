toutnoir = Image.load ("png/presentation/toutnoir.png")
rayman1 = Image.load ("png/presentation/rayman1.png")
rayman2 = Image.load ("png/presentation/rayman2.png")
rayman3 = Image.load ("png/presentation/rayman3.png")
rayman4 = Image.load ("png/presentation/rayman4.png")
rayman5 = Image.load ("png/presentation/rayman5.png")
rayman6 = Image.load ("png/presentation/rayman6.png")
texte1 = "lire la suite"
texte2 = "passer la presentation"
texte3 = "rayman vit paisiblement"
texte4 = "raymaze est un de ses ennnemies "
texte5 = "c'est un docteur tres jaloux"
texte6 = "pas de rayman mais de ces pouvoirs !"
texte7 = "alors un soir alors que rayman"
texte8 = "dormait il lui a pris son pouvoir"
texte9 = "celui qui  permet de lancer un poing"
texte10 = "rayman se reveil "
texte11 = "d'habitude il envoie un poing sur"
texte12 = "l'interupteur qui permet d'allumer"
texte13 = "la lumiere. Mais ce matin il"
texte14 = "n'y arrive pas"
texte15 = "rayman decide de recuperer son"
texte16 = "pouvoir avant que raymaze "
texte17 = "ne le detruise avec une armee"
texte18 = "de poing.Rayman a besion d'aide"
texte19 = "qui peut l'aider ?"

rouge = Color.new(255,0,0)
bleu = Color.new(0,0,255)

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
screen:print (160,210,texte1,rouge)
screen:print (160,240,texte2,rouge)
screen:print (80,20,texte3,bleu)
screen:print (80,30,texte4,bleu)
screen:print (80,40,texte5,bleu)
screen:print (80,50,texte6,bleu)
screen:print (80,60,texte7,bleu)
screen:print (80,70,texte8,bleu)
screen:print (80,80,texte9,bleu)
screen:print (80,90,texte10,bleu)
screen:print (80,100,texte11,bleu)
screen:print (80,110,texte12,bleu)
screen:print (80,120,texte13,bleu)
screen:print (80,130,texte14,bleu)
screen:print (80,140,texte15,bleu)
screen:print (80,150,texte16,bleu)
screen:print (80,160,texte17,bleu)
screen:print (80,170,texte18,bleu)
screen:print (80,180,texte19,bleu)

if selection == 1 then 
screen:blit (120,210,main)
end
if selection == 2 then 
screen:blit (120,240,main)
end
if pad:cross() then 
if selection == 1 then 
dofile("presentation3.lua") 
elseif selection== 2 then
dofile("niveau1.lua")
end 
end   

if pad:up() then selection = selection -1 end
if pad:down() then selection = selection +1 end
if selection == 0 then selection =1 end
if selection == 3 then selection = 2 end

screen.flip()
for i=0,3 do
screen.waitVblankStart()
end
end