from map import *
from PyQt5.QtWidgets import QWidget, QApplication, QMessageBox

class CWidget(QWidget):
    endSignal = pyqtSignal()
    #시그널 생성
    def __init__(self):
        super().__init__()
        self.initUI()
    
    def __del__(self):
        pass
    
    def initUI(self):
        self.setGeometry(100, 100, 500, 500)
        self.setWindowTitle('Snake Game')
        self.setFixedSize(self.rect().size())
        
        self.map = CMap(self)
        self.endSignal.connect(self.ExitGame)
        
    def paintEvent(self, e):
        qp = QPainter()
        qp.begin(self)
        self.map.draw(qp)
        qp.end()
    
    def keyPressEvent(self, e):
        self.map.keydown(e.key())
        
    def ExitGame(self):
        result = QMessageBox.information(self
                                         ,'게임종료'
                                         ,'다시시작: Yes, 종료: No'
                                         ,QMessageBox.Yes | QMessageBox.No)
        if result == QMessageBox.Yes:
            self.map.reStart()
        else:
            self.close()