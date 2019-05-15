finraymanpspv01 = Image.load ("png/finraymanpspv01.png")

while true do

pad = Controls.read() 
screen:clear()
screen:blit (0,0,finraymanpspv01)

if pad:start() then 
os.exit() 
end

screen.flip()
for i=0,8 do
screen.waitVblankStart()
end
end