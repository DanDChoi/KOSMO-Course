< 리액트 (React) >

#Part1: 상위컴포넌트와 하위컴포넌트간의 데이터 교환 

[1] why? React 
	(1) Output
		- Rich: "화려한"
		- Reuse: "재사용성"
		- Modularity: "모듈화" ( == Component화 == 레고블럭화 )
		- AutoUpdate: "자동갱신"

	(2) Input 
		- 학습에 대한 에너지  
		- 버젼이 올라감에 따라 셋팅법이 바뀜 

[2] 환경설정 
    (1) Node.js 설치 
	    1) 다운로드 ( node-v14.17.5-x64.msi )   
		   - https://nodejs.org/ko/download/

		2) 설치 
		   - Actomatically ~ : 체크하지 X 
		   - Chocolatey 설치 : 엔터!

		3) node 와 npm 설치/버젼 확인 
		   #> node -v
		   #> npm -v

		4) create-react-app 으로 리액트앱 생성 / 서버실행 
		   <1> 방법1 ( npx )  
		      C:\SOO\React>npx -v //5.2+ 확인 
		      C:\SOO\React>npx create-react-app t-app1 //생성 
			  C:\SOO\React>cd t-app1
			  C:\SOO\React\t-app1>npm start	

		   <2> 방법2 ( npm )
		      C:\SOO\React>npm init react-app t-app2
			  C:\SOO\React>cd t-app2
			  C:\SOO\React\t-app2>npm start
			  
		   <3> 방법3 ( yarn )
		      C:\SOO\React>npm install -g yarn //얀 설치 
              C:\SOO\React>yarn -v //0.25+ 확인 
		      C:\SOO\React>yarn create react-app t-app3
              C:\SOO\React>cd t-app3
			  C:\SOO\React\t-app3>yarn start

	    5) 리액트 서버 종료 
            Ctrl + C

    (2) VSCode 환경에서 서버 실행
	    1) 

[3] 환경설정
			   
