from Main import *

if not p.image.get_extended():
    raise SystemExit("Extended Image Module Requried")

SCREENRECT = Rect(0, 0, 1280, 960)
BLACK = 0, 0, 0
main_dir = os.path.abspath('imgs')

#images
def load_image(file):
    "loads an image, prepares it for play"
    file = os.path.join(main_dir,file)

    try:
        surface = p.image.load(file)
    except p.error:
        raise SystemExit('unable to load image')
    return surface.convert_alpha()

def load_images(*files):
    imgs = []
    for file in files:
        imgs.append(load_image(file))
    return imgs

#sprites - UI
class GameOver(p.sprite.Sprite):
    images=[]
    def __init__(self):
        p.sprite.Sprite.__init__(self)
        self.image = self.images[0]
        self.rect = self.image.get_rect(center=(340,450))

class TextLabel(p.sprite.Sprite):
    images = []
    def __init__(self,index,location):
        p.sprite.Sprite.__init__(self)
        self.image = self.images[index]
        self.rect = self.image.get_rect(center=location)

class EnterLabel(TextLabel):
    def __init__(self):
        TextLabel.__init__(self,3,(640,720))
        self.start_time = time.time()
    def update(self):
        cal_time= time.time()-self.start_time
        if math.ceil(cal_time)>1:
            self.kill()
            
class Coin(TextLabel):
    def __init__(self):
        TextLabel.__init__(self,4,(80,-30))
    
    def update(self):

        if self.rect.y<29:
            self.rect.move_ip(0,2)
class BombCount(TextLabel):
    def __init__(self):
        TextLabel.__init__(self,14,(1100,1000))
    def update(self):

        if self.rect.y>900:
            
            self.rect.move_ip(0,-2)
class DifficultyLabel(TextLabel):
    def __init__(self,index,difficulty):
        self.index=index
        self.difficulty=difficulty
        TextLabel.__init__(self,self.index,(1100,-30))
    def update(self):
        if self.difficulty!=self.index:
            self.rect.move_ip(0,-2)
            if self.rect.y<-30:
                self.kill()
        if self.rect.y<35 and self.difficulty==self.index:
            self.rect.move_ip(0,2)
            
        
#sprites - game missiles
class Missile(p.sprite.Sprite):
    images = []
    def __init__(self,player) :
        p.sprite.Sprite.__init__(self)
        self.image = self.images[0]
        self.rect = self.image.get_rect()
        mt =list(player.rect.midtop)
        mt[1]=mt[1]+8
        
        self.rect.midbottom = mt
        screen = p.display.get_surface()
        self.speed = -15
        self.area =screen.get_rect()
    
    def update(self):
        newpos = self.rect.move(0,self.speed)
        if newpos.bottom > self.area.top:
            self.rect = newpos
        if self.rect.y<-1:
            self.kill()

class UpgradedMissle(Missile):
    def __init__(self):
        self.image=self.images[1]
        Missile.init(self,Missile.player)

class BossMissile(p.sprite.Sprite):
    images = []
    def __init__(self,boss,index):
        p.sprite.Sprite.__init__(self)
        self.boss=boss
        self.index=index
        self.image= self.images[self.index]
        self.rect =self.images[self.index].get_rect()
        self.image.set_colorkey(BLACK)
        mt = list(self.boss.rect.midbottom)
        if self.index==0:
            self.rect.midtop=boss.rect.midbottom 
        elif self.index==1:
            mt[0]=mt[0]-30
            self.rect.midtop=mt
        elif self.index==2:
            mt[0]=mt[0]+30
            self.rect.midtop=mt
        screen = p.display.get_surface()
        
        self.speed =10
        self.radius = int(self.rect.width * .9/2)
        self.area =screen.get_rect()
        
    def update(self):
        
        if self.index==0:
            newpos = self.rect.move(0,self.speed)
        elif self.index==1:
            newpos = self.rect.move(-8,self.speed)
        elif self.index==2:
            newpos = self.rect.move(8,self.speed)
        if newpos.bottom > self.area.top:
            self.rect = newpos
        if self.rect.y>1500: 
            self.kill()

class Bomb(p.sprite.Sprite):
    images = []
    def __init__(self):
        p.sprite.Sprite.__init__(self)                   
        self.image =self.images[0]
        s = random.randrange(10,1200)
        self.rect = self.images[0].get_rect(center=(s,1000))
        screen = p.display.get_surface()
        self.movey = -10
        self.area =screen.get_rect()
    def update(self):
        newpos = self.rect.move(0,self.movey)
        if newpos.bottom > self.area.top:
            self.rect = newpos
        if self.rect.y<-50:
            self.kill()
        
            
#sprites - game main object    
class Enemy(p.sprite.Sprite):
    images = []
    def __init__(self,index):
        p.sprite.Sprite.__init__(self)
        a = random.randrange(0,3)
        self.image = self.images[index]
        self.image.set_colorkey(BLACK)
        b = random.randrange(100,1180)
        self.speedx1=0
        self.speedx2=0
        self.rect = self.image.get_rect(center = (b,-150))
        self.radius = int(self.rect.width * .9/2)
        if 0<self.rect.x<640:
            self.speedx1 = random.randrange(0,2)
            self.speedy = random.randrange(1,3)
        else :
            self.speedx2 = random.randrange(-2,0)
            self.speedy = random.randrange(1,3)
        screen = p.display.get_surface()
        self.area =screen.get_rect()
        
        self.start_time = time.time()
    def explode(self):
        self.kill()
        return Explode(self)
    def update(self):
        newpos = self.rect.move(0,2)
        self.rect = newpos
        self.cal_time= time.time()-self.start_time
        if self.rect.y>50:
            if math.ceil(self.cal_time)%2==0:
                if 0<self.rect.x<640:
                    newpos = self.rect.move(self.speedx1,self.speedy)
                    self.rect = newpos
                else:
                    newpos = self.rect.move(self.speedx2,self.speedy)
                    self.rect = newpos
        if self.rect.y >1000:
            
            self.kill()
class Enemy1(Enemy):
    def __init__(self):
        Enemy.__init__(self,0)
class Enemy2(Enemy):
    def __init__(self):
        Enemy.__init__(self,1)     
class Enemy3(Enemy):
    def __init__(self):
        Enemy.__init__(self,2)          
class Enemy4(Enemy):
    def __init__(self):
        Enemy.__init__(self,3)
        
class Boss(p.sprite.Sprite):
    images=[]
    def __init__(self,linger = 60,mistype=BossMissile):
        p.sprite.Sprite.__init__(self)
        self.index=1
        self.image = self.images[self.index]
        self.rect = self.images[0].get_rect(center=(640,-200))
        self.start_frame = time.time()
        self.noi =5
        self.life=100
        self.linger= linger
        self.frames_per_second=4
        self.shoted = False
        self.movex=2
        self.mistype=mistype
        self.miscount=0
        self.is_kill_player = 0
    def update(self):
        if not self.is_kill_player:
            if self.rect.y<0:
                self.rect.move_ip(0,8)
            else:
                self.rect.move_ip(self.movex,0)
                if self.rect.x>900:
                    self.movex=-2
                elif self.rect.x<-80:
                    self.movex=2 
        else :
            self.rect.move_ip(0,-4)
            if(self.rect.y<-250):
                self.kill()  
        s = (time.time() - self.start_frame)*self.frames_per_second%self.noi
        

        if not self.shoted:   
            self.index=math.floor(s)+1
            self.image = self.images[self.index]
        if self.shoted:
            if time.time()-self.start_time<0.3:
                self.index=0
                self.image = self.images[self.index]
            if time.time()-self.start_time>0.3:
                self.start_time = time.time()        
                self.shoted=False
    def gotshoot(self):
        self.start_time = time.time()
        self.shoted = True       
        self.life-=1
        
    def fire(self):
        if self.miscount==0:
            self.miscount +=1
            return self.mistype(self,0)
        elif self.miscount==1:
            self.miscount +=1
            return self.mistype(self,1)    
        elif self.miscount==2:
            self.miscount=0
            return self.mistype(self,2)
    def explode(self):
        self.alive=False
        self.frame = 0
        self.rect = self.images[0].get_rect(center=(640,-200))
        self.kill()
        return Explode(self)
                    
class Player(p.sprite.Sprite):
    images = []
    ani = 12
    alive = False
    def __init__(self,mistype =Missile):
        p.sprite.Sprite.__init__(self)
        self.image = self.images[0]
        self.image.set_colorkey(BLACK)
        self.status=0
        self.rect = self.images[0].get_rect(center=(640,1100))
        self.radius = int(self.rect.width * .9/2)
        self.reloading = 0
        self.origtop = self.rect.top
        self.movex = 0
        self.movey = 0
        self.frame = 0
        self.mistype= mistype

    # def upgrade(self):
    #     self.mistype= UpgradedMissile()
       
    def control(self, x, y):
        self.movex += x
        self.movey += y

    def fire(self):
        return self.mistype(self)
    def explode(self):
        self.alive=False
        self.frame = 0
        self.movex=0
        self.movey=0
        self.kill()
        return Explode(self)
        
    #     # if self.movex <0 :
        #     self.frame +=1
        #     if self.frame > self.ani:
        #         self.frame = 0
        #     self.image = self.images[self.frame//self.ani%2]
        # if self.movey <0 :
        #     self.frame +=1
        #     if self.frame > self.ani:
        #         self.frame = 0
        #     self.image = self.images[self.frame//self.ani%2]

#sprites - game effect
class Explode(p.sprite.Sprite):
    images = []
    def __init__(self,explodedThing,linger = 25):
        p.sprite.Sprite.__init__(self)
        self.index = 0
        self.image = self.images[self.index]
        self.rect = self.images[0].get_rect()   
        self.rect.center = explodedThing.rect.center 
        self.linger = linger
        self.frame = 0
        self.start_frame = time.time()
        self.noi = 24
        self.frames_per_second = 24

    def update(self):
        s = (time.time() - self.start_frame)*self.frames_per_second%self.noi

        self.index += 1
        
        if self.index==60:
            self.kill()
        if self.index<60:
            self.image = self.images[math.ceil(s)]



