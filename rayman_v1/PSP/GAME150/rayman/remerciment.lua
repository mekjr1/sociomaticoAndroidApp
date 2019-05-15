remerciments = Image.load ("png/remerciments.png")

while true do
pad = Controls.read() 
screen:clear()
screen:blit (0,0,remerciments)
if pad:start() then
dofile("menu.lua") 
end

screen.flip()
screen.waitVblankStart()
end