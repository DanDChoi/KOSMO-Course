from PyQt5.QtCore import Qt

class CNode:
    def __init__(self, x=0, y=0):
        self.x = x
        self.y = y
        
    def __eq__(self, other):
        if self.x == other.x and self.y == other.y:
            return True
        else:
            return False
        
        
class CSnake:
    def __init__(self, lines):
        self.node = [] #뱀 마디길이 저장할 리스트
        self.dir = Qt.Key_Right #뱀의 방향
        self.bAdd = False #뱀 마디 추가
        self.init(lines)
    
    def init(self, lines):
        cx = lines//2
        cy = lines//2
        for i in range(3): #기본 뱀 3마디 생성
            self.node.append(CNode(cx, cy))
            cx -= 1
            
    def changeDir(self, key):
        if self.isChangeDir(key) == False:
            return None
        
        self.dir = key
    
    def isChangeDir(self, key): #현대 방향과 이동할 방향이 반대인지?
        if self.dir == Qt.Key_Left and key == Qt.Key_Right:
            return False
        elif self.dir == Qt.Key_Right and key == Qt.Key_Left:
            return False
        elif self.dir == Qt.Key_Up and key == Qt.Key_Down:
            return False
        elif self.dir == Qt.Key_Down and key == Qt.Key_Up:
            return False
        else:
            return True
        
    def isCrash(self):
        if self.nodeCount() < 5:
            return False
        
        head = CNode(self.node[0].x, self.node[0].y) #뱀 머리
        bodylist = self.node[4:] #몸통은 4마디부터 충돌가능하므로
        
        for body in bodylist:
            if head == body:
                return True
            
        return False
        
    def move(self):
        if self.isCrash(): #뱀 머리, 몸통 충돌 검사
            return False 
        
        head = CNode(self.node[0].x, self.node[0].y) #뱀 머리
        
        if self.dir == Qt.Key_Left:
            head.x -= 1
        elif self.dir == Qt.Key_Right:
            head.x += 1
        elif self.dir == Qt.Key_Up:
            head.y -= 1
        elif self.dir == Qt.Key_Down:
            head.y += 1
        
        self.node.insert(0, head) #이동방향으로 뱀 머리 추가
        
        if self.bAdd:  #이동시 먹이를 먹었으면 꼬리 유지, 아니면 제거
            self.bAdd = False
        else:
            self.node.pop()
            
        return True
    
    def addNode(self):
        self.bAdd = True
        
    def nodeCount(self):    # 뱀 길이 얻기
        return len(self.node)