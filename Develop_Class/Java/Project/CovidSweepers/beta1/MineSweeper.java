import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.Math.*;

public class MineSweeper extends JFrame implements ActionListener{
   
   CM_Client cm;
   
   int rows=12; int cols=12; int mines=31; //지뢰 수 
   int score =0;//점수
   int tot=0; //주변의 지뢰개수 숫자 표시
   
   Cell userField[][] = new Cell[12][12]; //사용자에게 표시되는 필드
   Cell gameField[][] = new Cell[12][12]; // 사용자가 볼 수 없는 정답필드
   Cell selected ; //선택한 셀 참조용
   
   public MineSweeper(CM_Client cm) {
	 this.cm = cm;
   }
   
   void start() {
      for(int i=0;i<rows;i++) {
         for(int j=0;j<cols;j++) {
            userField[i][j].setEnabled(true);
         }
      }
   }//end for start();
   
   void initFields() {
      cm.panel_Mine.removeAll(); //지뢰찾기 게임이 올라가는 패널 내용 초기화
      for(int i =0;i<rows;i++) {
         for(int j=0;j<cols;j++) {
            //Cell 타입으로 게임필드, 유저필드 생성
            gameField[i][j]=new Cell();
            userField[i][j]=new Cell();
            cm.panel_Mine.add(userField[i][j]); //사용자 필드만 화면에 보이게 패널에 올림
            userField[i][j].addActionListener(this);
            userField[i][j].setEnabled(false);
         } //end for j
         //게임 정보 초기화
         score=0;
         cm.panel_Mine.validate();
      }//end for i
   }//end of initFields()
   
   void showFullField() {
      for(int row=0;row<row;row++) {
         for(int col=0;col<cols;col++) {
            if(!userField[row][col].isClicked()) {
               userField[row][col].setType(gameField[row][col].getType());
               userField[row][col].setValue(gameField[row][col].getValue());
               userField[row][col].setClicked(true);
               gameField[row][col].setClicked(true);
               if(userField[row][col].getType()=='m') {
                  userField[row][col].setText("*");
               }
               if(userField[row][col].getType()=='e') {
                  userField[row][col].setText("");
               }
               if(userField[row][col].getType()=='f') {
                  userField[row][col].setText("B");
               }
               else {//주변 지뢰의 개수를 알려주는 n 타입이라면
                  userField[row][col].setText(String.valueOf(gameField[row][col].getValue()));
               }
            }
         }//end for col
      }//end for row   
   }//end of showFullField()
   
    int isAMine(int row, int col) {
        if(row<rows &&col<cols &&col>=0 &&row>=0) {
           if(gameField[row][col].getType()=='m') {
              return 1;
           }
           return 0;
        }//end of if-유효범위내
        return 0;
     }
    
     int nearMines(int row, int col) {
        int tot=0;
        if(row<rows &&col<cols &&col>=0 &&row>=0) {
         tot += isAMine(row-1,col);         
         tot += isAMine(row-1,col-1);         
         tot += isAMine(row+1,col);         
         tot += isAMine(row+1,col-1);   
         tot += isAMine(row,col-1);         
         tot += isAMine(row,col+1);
         tot += isAMine(row-1,col+1);
         tot += isAMine(row+1,col+1);
         }
         return tot;
      }//end of nearMines()
     
     void prepareField() {
         int row, col;
         initFields();
         for(int i=0;i<=mines;i++) {
            do {
               row= (int)(Math.random() * rows);
               col=(int)(Math.random()*cols);
               gameField[row][col].setType('m');
            }while(gameField[row][col].getType() !='m');
         }//end for i
         
         for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
               if(gameField[i][j].getType()!='m') {
                  if(nearMines(i,j)!=0) {
                     gameField[i][j].setType('n');
                     gameField[i][j].setValue(nearMines(i,j));
                  }
               }
            }//end for j
         }//end for i
      }//end for prepaerField
      
      void checkEmptyCell(int row, int col) {
         if(row<rows && col<cols && col>= 0 && row>=0){
            if(!gameField[row][col].isClicked() && !userField[row][col].isClicked() && gameField[row][col].getType() == 'e'){
               userField[row][col].setClicked(true);         
               userField[row][col].setType('e');                              
               userField[row][col].setValue(' ');            
               userField[row][col].setText("");            
               userField[row][col].setEnabled(false);         
               gameField[row][col].setClicked(true);
               checkEmptyCell(row - 1, col - 1);            
               checkEmptyCell(row, col - 1);
               checkEmptyCell(row + 1, col - 1);
               checkEmptyCell(row - 1, col);
               checkEmptyCell(row + 1, col);
               checkEmptyCell(row -1, col + 1);
               checkEmptyCell(row, col + 1);
               checkEmptyCell(row + 1, col + 1);

            }else if(gameField[row][col].getType() == 'n' && gameField[row][col].getValue() != 0 && !gameField[row][col].isClicked() && !userField[row][col].isClicked()){   
               userField[row][col].setType(gameField[row][col].getType());         
               userField[row][col].setValue(gameField[row][col].getValue());      
               userField[row][col].setClicked(true);                        
               gameField[row][col].setClicked(true);   
               userField[row][col].setText(String.valueOf(gameField[row][col].getValue()));   
               userField[row][col].setEnabled(false);                     
            }
         }
      }//end of checkEmptyCell()
      
   boolean victory(){
      int checked = 0; 
      for(int i=0;i<rows;i++){
         for(int j=0;j<cols;j++){
            if(gameField[i][j].isClicked()&&gameField[i][j].getType()=='m'){
               checked++; 
            }
         }//end for j
      }//end for i
      if(checked==mines){         
         return true;            
      }
      return false;
   } 

   @Override
   public void actionPerformed(ActionEvent e) {
         Object obj= (Object) e.getSource();
            if(e.getSource() == cm.btn_Exit){
               int select = JOptionPane.showConfirmDialog(null, "정말 게임을 종료하시겠습니까?", "Exit", JOptionPane.OK_CANCEL_OPTION);
               if(select == JOptionPane.YES_OPTION) System.exit(0);
            }
            if(obj == cm.btn_Ready){   
               //start();            
            }

            /*if(obj == 게임초기화 버튼){      
               prepareField();   

            }*/

            for(int i=0;i<rows;i++){
               for(int j=0;j<cols;j++){
                     if(obj==userField[i][j] && !userField[i][j].isClicked()){   
                     selected = gameField[i][j];                           

                     /*필요 없어보여서 주석처리
                      if(userField[i][j].getType() == 'f'){   
                        handleFlag(i,j);                  
                     }*/

                     if(isAMine(i,j) == 1){ //지뢰라면--211208 수정
                        //JOptionPane.showMessageDialog(null,"Hai colpito una mina!");   
                        //showFullField();                              
                        selected.setClicked(true);                        
                        userField[i][j].setClicked(true);
                        userField[i][j].setValue(selected.getValue());         
                        userField[i][j].setType('f');                  

                        userField[i][j].setText("F");   
                        //userField[i][j].setText(String.valueOf(selected.getValue())); 
                        userField[i][j].setEnabled(false);                  

                        //20211208 새로 추가한것
                        score++;
                        //lScore.setText(Integer.toString(score));
                        //lScore.setValue(score);
                        revalidate();
                        repaint();
                        
                        //System.out.println("점수 : "+score);
                     }
                     
                     else if(selected.getType() == 'n'){
                        selected.setClicked(true);                        
                        userField[i][j].setClicked(true);
                        userField[i][j].setValue(selected.getValue());         
                        userField[i][j].setType('n');                  
                        userField[i][j].setText(String.valueOf(selected.getValue()));   
                        userField[i][j].setEnabled(false);               
                     }
                     else if(selected.getType() == 'e'){                  
                        checkEmptyCell(i,j);                           
                     }
                     if(victory()){                                 
                        JOptionPane.showMessageDialog(null,"승리!");   
                        showFullField();                     
                     }
                  }//end of if
               }//end of for j
            }//end of for i
   }
}
