from platform import release
from snake import *
from PyQt5.QtCore import *
from PyQt5.QtGui import *
from threading import Thread, Lock
import time
import pygame
from random import randint

class CMap:
    def __init__(self, parent):
        super().__init__()
        
        self.thread = Thread(target = self.playgame) #쓰레드 생성
        self.lock = Lock() # 쓰레드 동기화 락
        self.bRun = True #쓰레드 동작
        self.bMove = True #키보드 2회 연속 방지
        self.bGame = False #게임 진행 상태
        self.foodcnt = 0 #먹이 먹은 횟수
        self.lines = 15 #맵의 줄수
        self.snake = CSnake(self.lines) #뱀 생성
        self.food = CNode(-1, -1) #뱀 먹이
        self.parent = parent #부모 윈도우 저장
        self.outrect = parent.rect() #부모 윈도우 크기 저장
        gap = 20 # 내부 맵 여백 조정
        self.inrect = self.outrect.adjusted(gap, gap, -gap, -gap)
        
        
        pygame.init()
        self.bgm = pygame.mixer.Sound("/Users/Dan/Desktop/Develop/Develop_Class/project/python/Dan/bgm/bgm.mp3")
        
        #맵 한칸 크기
        self.wsize = self.inrect.width()/self.lines
        self.hsize = self.inrect.height()/self.lines
        
        #맵 사각형 좌표 저장
        self.left = self.inrect.left()
        self.top = self.inrect.top()
        self.right = self.inrect.right()
        self.bottom = self.inrect.bottom()
        
        #맵 사각형 저장 2차원 배열 생성 [ [열] 행]
        self.rect = [[QRectF for _ in range(self.lines)] for _ in range(self.lines)]
        
        #생성된 사각형 배열 좌표 저장
        topleft = QPoint(self.left, self.top)
        size = QSize(self.wsize, self.hsize)
        
        for i in range(self.lines):
            for j in range(self.lines):
                self.rect[i][j] = QRect(self.left+(j*self.wsize)
                                        , self.top+(i*self.hsize)
                                        , self.wsize
                                        , self.hsize)
                self.rect[i][j].adjust(1, 1, -1, -1) #사각형 크기 줄이기
                
    def reStart(self):
        
        del(self.thread)
        self.thread = Thread(target = self.playgame)
        self.bRun = True
        self.bGame = False
        self.bMove = True
        self.foodcnt = 0
        
        del(self.snake)
        self.snake = CSnake(self.lines)
        del(self.food)
        self.food = CNode(-1, -1)
        
    def draw(self, qp): #맵그리기
        for i in range(self.lines+1):
            #가로선
            qp.drawLine(self.left, self.top+(i*self.hsize), self.right, self.top+(i*self.hsize))
            #세로선
            qp.drawLine(self.left+(i*self.wsize), self.top, self.left+(i*self.wsize), self.bottom)
            
        #뱀 그리기
        i = 0
        self.lock.acquire()
        for node in self.snake.node:
            if i == 0:
                qp.setBrush(QColor(33, 53, 194))
            else:
                qp.setBrush(QColor(83, 103, 255, 128))
            if self.bRun:
                qp.drawRect(self.rect[node.y][node.x])
            i += 1
        self.lock.release()
        self.lock.acquire()
        
        #먹이그리기
        if self.food.x != -1 and self.food.y != -1:
            qp.setBrush(QColor(255, 0, 0))
            qp.drawEllipse(self.rect[self.food.y][self.food.x])
        self.lock.release()
        
        qp.drawText(self.outrect, Qt.AlignTop|Qt.AlignLeft, '점수:'+str(self.foodcnt))
        
        #게임 도움말
        if not self.bGame:
            qp.setFont(QFont('맑은고딕', 20))
            qp.drawText(self.outrect, Qt.AlignCenter, '키보드 방향키를 누르면 시작')
            
    def keydown(self, key):
        #게임시작
        if (key == Qt.Key_Right or key == Qt.Key_Up or key == Qt.Key_Down) and self.bGame == False:
            self.bGame = True
            self.snake.changeDir(key)
            self.thread.start()
            self.bgm.play(-1)
        #게임진행중 키 변경
        if (key == Qt.Key_Left or key == Qt.Key_Right or key == Qt.Key_Up or key == Qt.Key_Down) and self.bGame == True:
            if self.bMove:
                self.snake.changeDir(key)
                self.bMove = False
    def makeFood(self):
        #먹이가 있으면 리턴
        if self.food.x != -1 and self.food.y != -1:
            return
        
        cnt = 0
        while True:
            x = randint(0, self.lines-1)
            y = randint(0, self.lines-1)
            node = CNode(x, y)
            
            bDiff = False
            
            for snode in self.snake.node:
                if node == snode:
                    bDiff = True
                    break
                
            if not bDiff:
                self.food = node
                break
                
            #밥을 놓을 공간이 없다면 탈출
            if cnt>self.lines*self.lines:
                break
                
            cnt += 1
            
    def isEat(self, node):
        if self.food == node:
            return True
        else:
            return False
    def isOut(self, head):
        if head.x < 0 or head.x >= self.lines:
            return True
        elif head.y < 0 or head.y >= self.lines:
            return True
        else:
            return False
            
    def playgame(self):
        while self.bRun:
            self.lock.acquire()
            #뱀 이동, 머리, 몸통 충돌시 종료 or 맵 나가면 종료
            if not self.snake.move() or self.isOut(self.snake.node[0]):
                self.parent.update()
                self.bRun = False
                self.bGame = False
                self.lock.release()
                self.bgm.stop()
                break
            #먹이 생성
            self.makeFood()
            #먹이 먹었는지
            bEat = self.isEat(self.snake.node[0])
            
            #먹이 먹었으면 마디 추가, 먹이 좌표 초기화
            if bEat:
                self.snake.addNode()
                self.foodcnt += 1
                self.food.x = -1
                self.food.y = -1
                
            self.lock.release()
            
            #키보드 2중 누름방지
            self.bMove = True
            
            self.parent.update()
            time.sleep(0.3)
            
        if not self.bGame:
            self.parent.endSignal.emit()
            