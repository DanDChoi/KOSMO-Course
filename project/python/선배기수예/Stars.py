from Main import *

WINSIZE = [1280, 960]
WINCENTER = [640,480]
NUMSTARS = 100

def init_star():

    dir = random.randrange(100)
    velmult = random.random()*.6+.4
    vel = [math.sin(dir) * velmult, math.cos(dir) * velmult]
    return vel, WINCENTER[:]

def initialize_stars():
    
    stars = []
    for x in range(NUMSTARS):
        star = init_star()
        vel, pos = star
        steps = random.randint(0, WINCENTER[0])
        
        pos[0] = pos[0] + (vel[0] * steps)
        pos[1] = pos[1] + (vel[1] * steps)
        vel[0] = vel[0] * (steps * .09)
        vel[1] = vel[1] * (steps * .09)
        stars.append(star)
    move_stars(stars)
    return stars
  
def draw_stars(surface, stars, color):
    
    for vel, pos in stars:
        pos = (int(pos[0]), int(pos[1]))
        surface.set_at(pos, color)
        
def move_stars(stars):
    
    for vel, pos in stars:
        pos[0] = pos[0] + vel[0]
        pos[1] = pos[1] + vel[1]
        
        if not 0 <= pos[0] <= WINSIZE[0] or not 0 <= pos[1] <= WINSIZE[1]:
            vel[:], pos[:] = init_star()
            pos[0]=pos[0]+vel[0]*200
            pos[1]=pos[1]+vel[1]*200
        else:
            
            vel[0] = vel[0] * 1.05
            vel[1] = vel[1] * 1.05
