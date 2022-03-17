[ 수스 파이썬 ]

1. 아나콘다 설치  
   Down) https://www.anaconda.com/products/individual
   Blog) https://needjarvis.tistory.com/563 

2. 개발 환경 설명 
   (1) Anaconda : Python + 기본 Lib 
   (2) Editor 
       - VSCode ( Editplus + Eclipse ) by MS 
	   - Pycham ( Elipse ) by jetbrains 

3. VSCode 단축키 
   (1) VSCode 설치 
       Down) https://code.visualstudio.com/
	   Blog) https://mylogcenter.tistory.com/7

   (2) VSCode 필수 설치 Plugin 
       - Python 
	   - Python for VSCode 
	   - Python Extension Pack 
	   - Korean Language Pack 
	   - Code Runner 

   (3) 단축키 
       - Ctrl + Shift + P : Select Interpreter
	   - Ctrl + , : Settings ( font size, zoom, .. )
	   
       Blog) https://developer-theo.tistory.com/entry/VSCode-%EA%B8%B0%EB%B3%B8-%EC%82%AC%EC%9A%A9%EB%B2%95

4. 가상 환경 셋팅
   (1) conda 가상환경(env) 생성 ( create )
       1) 버젼 확인 
          VSCode의 Command Prompt 열기 
		  $ python --version 

	   2) 생성 
	      VSCode에서 Command Prompt 열기 
		  $ conda create -n env_python python=3.8.8

	   3) 생성되는 위치 확인 
	      C:\Users\kosmo\anaconda3\envs\env_python
  
   (2) conda 가상 환경 조회 
       $ conda env list 

   (3) conda 가상 환경 내 package 목록/버젼 확인 
       $ conda list -n env_python 
   
   (4) VSCode에서 가상환경 선택 
       Ctrl + Shift + P: Select Interpreter 에서 오른쪽 상단의 Refresh아이콘 
	     -> env_python 확인 -> 선택 

   (5) conda 가상환경 핸들링 
       1) 활성화 
	      $ conda activate env_python

	   2) 비활성화 
	      $ conda deactivate

	   3) 제거 
	      $ conda remove --name env_python --all 

		  (디렉토리삭제) 
		  탐색기에서 C:\Users\kosmo\anaconda3\envs\env_python 삭제!!

5. 파이썬 실행 
   (1) 명령프롬프트(cmd)에서 작성/실행 
       1) 작업할 가상환경 활성화 
	      $ conda activate env_python 
     
	   2) 파이썬 작성 
	      >>> print('방가 파이썬')
          방가 파이썬
		  >>> exit() 

   (2) 일반편집기(Editplus..)에서 코딩후.. ~day01/hi.py 저장했을 경우 
       방법1) VSCode cmd에서 
          day01>python hi.py

	   방법2) Anaconda Prompt에서 
	      $ conda activate env_python
		  cd C:\SOO\Python\day01 
		  (env_python) C:\SOO\Python\day01>python hi.py 
		  exit
       
	   방법3) Window cmd창에서 
	      cd C:\SOO\Python\day01
		  C:\SOO\Python\day01>python hi.py
		  exit

   (3) VSCode에서 실행 
       1) 왼쪽 상단의 새파일 icon 클릭 -> hello.py 열기  
	      print("안녕 파이썬 at VSCode") 
	   2) 실행버튼(오른쪽 상단) -> Run Python File 

	       
	      
       
		


		 