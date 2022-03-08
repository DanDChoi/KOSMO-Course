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

       5) React 서버 종료 
            Ctrl + C

    (2) VSCode 환경에서 서버 실행
       1) VSCode로 t-app3 폴더 열기 

      2) React 서버 실행 
          - VSCode 새 터미널 ( Command ~ 선택 )

          <1> 방법1
            C:\SOO\React\t-app3>npm start
            
          <2> 방법2
             C:\SOO\React\t-app3>yarn start //안되면.. VSCode 껐다가 켜요

      3) React 서버 종료 
            Ctrl + C

[3] Hello, React 를 출력!! 
    (1) App.js 
       1) //import logo from './logo.svg';
      2) function App() {
           return (
            <div className="App">
              <h1>안녕, 리액트</h1>
            </div>
           );
          }
        
   (2) CSS 수정 
       1) src/index.css
         body {
           background-color: yellowgreen;
         }
      2) App.css
         .App {
           text-align: left;
         }

[4] Publishing 
    (1) 크롬 F12 -> 새로고침 아이콘 -> 오른쪽 마우스 -> 캐시비우기 및 강력새로고침
   (2) Network탭 -> 'X.X MB' 확인 
   (3) bulid 생성 
       C:\SOO\React\t-app3>npm run build  //bulid디렉토리 생성확인
    (4) 서버설치 
       #>npm install -g serve
    (5) 서버실행 
       #>npx serve -s build
    (6) 크롬에서 확인 
       - http://localhost:3000/
      - Network탭 -> 'XXX KB' 확인 

[5] Component 제작 
    (1) VSCode에서 앱을 생성 
       1) 생성 
           C:\SOO\React>yarn create react-app react-app

      2) 파일 -> 폴더열기 
            C:\SOO\React\react-app

       3) 서버 실행 
          C:\SOO\React\react-app>yarn start

   (2) origin.html 
        <html>
         <head>
            <meta charset="utf-8">
            <title>react-app</title>
         </head>
         <body>
            <header>
               <h1>홈</h1>
               리액트 인덱스^^
            <header>

            <nav>
               <ul>
                  <li><a href="1.html">자바</a></li> 
                  <li><a href="2.html">파이썬</a></li>
                  <li><a href="3.html">오라클</a></li>
               </ul>
            </nav>

            <article>
               <h3>자바</h3>
               자바는 엔터프라이즈 솔루션 구축에 최적화 된 언어! 
            </article>
         </body>
      </html>

    (3) 요청 
       http://127.0.0.1:3000/origin.html

    (4) App.js
       function App() {
        return (
         <div className="App">
           <header>
            <h1>홈</h1>
            리액트 인덱스^^
           </header>

           <nav>
            <ul>
              <li><a href="1.html">자바</a></li> 
              <li><a href="2.html">파이썬</a></li>
              <li><a href="3.html">오라클</a></li>
            </ul>
           </nav>

           <article>
            <h3>자바</h3>
            자바는 엔터프라이즈 솔루션 구축에 최적화 된 언어! 
           </article>
           
         </div>
        );
      }
       
       cf) 요청 http://127.0.0.1:3000/

    (5) 컴포넌트로 분리1 ( App.js : class )
       class Subject extends Component {
        render(){
         return(
           <header>
            <h1>홈</h1>
            리액트 인덱스*^^*
           </header>
         ); 
        }
      }
      class NavC extends Component {
        render(){
         return(
           <nav>
            <ul>
              <li><a href="1.html">자바</a></li> 
              <li><a href="2.html">파이썬</a></li>
              <li><a href="3.html">오라클</a></li>
            </ul>
           </nav>
         );
        }
      }
      class Content extends Component{
        render(){
         return(
           <article>
            <h3>자바</h3>
            자바는 엔터프라이즈 솔루션 구축에 최적화 된 언어! 
           </article>
         );
        }
      }
      function App() {
        return (
         <div className="App">
           <Subject/>
           <NavC/>
           <Content/>
         </div>
        );
      }
      export default App;

    (6) 컴포넌트로 분리2 ( App.js : props )
      class Subject extends Component {
        render(){
         return(
           <header>
            <h1>{this.props.title}</h1>
            {this.props.sub}
           </header>
         ); 
        }
      }
      class NavC extends Component {
        render(){
         return(
           <nav>
            <ul>
              <li><a href="1.html">자바</a></li> 
              <li><a href="2.html">파이썬</a></li>
              <li><a href="3.html">오라클</a></li>
            </ul>
           </nav>
         );
        }
      }
      class Content extends Component{
        render(){
         return(
           <article>
            <h3>{this.props.title}</h3>
            {this.props.desc}
           </article>
         );
        }
      }
      function App() {
        return (
         <div className="App">
           <Subject title="수스 홈" sub="수스 리액트 홈페이지"/>
           <NavC/>
           <Content title="자바!" desc="자바는 엔터프라이즈 솔루션 구축에 최적화 된 언어!!"/>
         </div>
        );
      }
      export default App;

    (7) 컴포넌트로 분리3 ( 각 파일로 분리 )
       1) src/components/ 폴더 생성 후 그 하위에.. 
         <1> Subject.js 
            import { Component } from "react";
           class Subject extends Component {
            render(){
              return(
               <header>
                 <h1>{this.props.title}</h1>
                 {this.props.sub}
               </header>
              ); 
            }
           }
           export default Subject;

         <2> NavC.js
            import { Component } from "react";
           class NavC extends Component {
            render(){
              return(
               <nav>
                 <ul>
                  <li><a href="1.html">자바</a></li> 
                  <li><a href="2.html">파이썬</a></li>
                  <li><a href="3.html">오라클</a></li>
                 </ul>
                  </nav>
              );
            }
           }
           export default NavC;
          
      <3> Content.js
            import { Component } from "react";
           class Content extends Component{
            render(){
              return(
               <article>
                 <h3>{this.props.title}</h3>
                 {this.props.desc}
               </article>
              );
            }
           }
           export default Content;

      <4> src/App.js 
            import './App.css';
           import Subject from "./components/Subject"
           import NavC from "./components/NavC"
           import Content from "./components/Content"

           function App() {
             return (
              <div className="App">
                <Subject title="수스 홈" sub="수스 리액트 홈페이지"/>
                <NavC/>
                <Content title="자바!" desc="자바는 엔터프라이즈 솔루션 구축에 최적화 된 언어!!"/>
              </div>
             );
           }
           export default App;

[6] 크롬 디버깅 확장프로그램 설치
   (1) 앱스토어 검색 
      'React Developer Tools'
   (2) 크롬 재시작
   (3) Components 탭 
   
[7] props 속성값에 'state' 적용 
    (1) App.js 함수 형태의 Component 를 클래스 형태로 변경 
       import ...
      /*
      function App() {
        return (
         <div className="App">
           <Subject title="수스 홈" sub="수스 리액트 홈페이지"/>
           <NavC/>
           <Content title="자바!" desc="자바는 엔터프라이즈 솔루션 구축에 최적화 된 언어!!"/>
         </div>
        );
      }*/
      class App extends Component{
        render(){
         return (
           <div className="App">
            <Subject title="수스 홈" sub="수스 리액트 홈페이지"/>
            <NavC/>
            <Content title="자바" desc="자바는 엔터프라이즈 솔루션 구축에 최적화 된 언어"/>
           </div>
         );
        }
      }
      export default App;

    (2) state 적용 
       1) 상위컴포넌트(App.js)에 정의 
         class App extends Component{
           constructor(props){
            super(props);
            this.state = {
              subject: {title:"수스 홈" , sub:"수스 리액트 홈페이지"},
              navc: [
               {id:1, title:"자바", desc:"자바는 엔터프라이즈 솔루션 구축에 최적화 된 언어"}, 
               {id:2, title:"파이썬", desc:"데이터 과학에 최적화 된 언어"}, 
               {id:3, title:"오라클", desc:"가장 안정적인 대용량 시스템구축을 위한 DBMS"}
              ],
              content: {title:"자바", desc:"자바는 엔터프라이즈 솔루션 구축에 최적화 된 언어"}
            };
           }
           render(){
            return (
              <div className="App">
               <Subject title={this.state.subject.title} sub={this.state.subject.sub}/>
               <NavC data={this.state.navc}/>
               <Content title={this.state.content.title} desc={this.state.content.desc}/>
              </div>
            );
           }
         }

      2) 하위컴포넌트(ex:NavC.js)에 적용 
          import { Component } from "react";
         class NavC extends Component {
            render(){
               var lists = [];
               var data = this.props.data;
               for(var i=0; i<data.length; i++){
                  lists.push(<li key={data[i].id}><a href={"/content/"+data[i].id}>{data[i].title}</a></li>);
               }
               return(
                  <nav>
                  <ul>
                     {lists}
                  </ul>
                  </nav>
               );
            }
           }
           export default NavC

[8] Event
    (1) 상위컴포넌트(App.js)에서 직접 이벤트 처리 
         ...
       render(){
         return (
           <div className="App">
            {/* <Subject title={this.state.subject.title} sub={this.state.subject.sub}/> */}
            <header>
              <h1><a href="/" onClick={function(e){
               console.log("e", e); //이벤트 객체를 확인!
               e.preventDefault(); //<a>태그가 가진 고유한기능(페이지갱신)을 막음!
               //debugger;
              }}>{this.state.subject.title}</a></h1>
              {this.state.subject.sub}
            </header>
            <NavC data={this.state.navc}/>
            <Content title={this.state.content.title} desc={this.state.content.desc}/>
           </div>
         );
        }
       ...

   (2) "수스 홈"링크를 click할때 <Content>내용이 갱신 
        class App extends Component{
        constructor(props){
         super(props);
         this.state = {
           mode: "read", 
           welcome: {title:"환영", desc:"어솨~ 리액트!"}, 
           subject: {title:"수스 홈" , sub:"수스 리액트 홈페이지"},
           navc: [
            {id:1, title:"자바", desc:"자바는 엔터프라이즈 솔루션 구축에 최적화 된 언어"}, 
            {id:2, title:"파이썬", desc:"데이터 과학에 최적화 된 언어"}, 
            {id:3, title:"오라클", desc:"가장 안정적인 대용량 시스템구축을 위한 DBMS"}
           ],
           content: {title:"자바", desc:"자바는 엔터프라이즈 솔루션 구축에 최적화 된 언어"}
         };
        }
        render(){
         console.log("#App render()");
         var _title, _desc = null;
         if(this.state.mode === "welcome"){
           _title = this.state.welcome.title;
           _desc = this.state.welcome.desc;
         }else if(this.state.mode === "read"){
           _title = this.state.navc[0].title;
           _desc = this.state.navc[0].desc;
         }

         return (
           <div className="App">
            {/* <Subject title={this.state.subject.title} sub={this.state.subject.sub}/> */}
            <header>
              <h1><a href="/" onClick={function(e){
               console.log("e", e); //이벤트 객체를 확인!
               e.preventDefault(); //<a>태그가 가진 고유한기능(페이지갱신)을 막음!
               //debugger;

               //this.state.mode = 'welcome'; //안됨!
               this.setState(
                 {mode: "welcome"}
               );
              }.bind(this)}>{this.state.subject.title}</a></h1>
              {this.state.subject.sub}
            </header>
            <NavC data={this.state.navc}/>
            <Content title={_title} desc={_desc}/>
           </div>
         );
        }
      }

        
     #참고1) bind()에 대한 고찰 ( 크롬의 Console탭에서.. )
       var obj = {name:'SoosApps'}
       function bindTest(){
         console.log(this.name);
      }
        'undefined'

      var bindTest2 = bindTest.bind(obj);
        bindTest2();
        'SoosApps'

   
      #참고2) 크롬 Console탭 js작성시 줄바꿈 
        Shift + Enter! 

   
   (3) 하위 컴포넌트(Subject.js)에서 이벤트 처리
      1) App.js에 이벤트 정의 
         <Subject 
           title={this.state.subject.title} 
           sub={this.state.subject.sub}
           onChangePage={function(){
            this.setState(
              {mode: "welcome"}
            );
           }.bind(this)}
         />
         {/* <header>
           <h1><a href="/" onClick={function(e){
            console.log("e", e); //이벤트 객체를 확인!
            e.preventDefault(); //<a>태그가 가진 고유한기능(페이지갱신)을 막음!
            //debugger;

            //this.state.mode = 'welcome';
            this.setState(
              {mode: "welcome"}
            );
           }.bind(this)}>{this.state.subject.title}</a></h1>
           {this.state.subject.sub}
         </header> */}

      2) Subject.js에서 이벤트 호출 
            import { Component } from "react";
         class Subject extends Component {
            render(){
              console.log("#Subject render()");
              return(
               <header>
                 <h1>
                  <a href="/" onClick={function(e){
                     e.preventDefault();
                     this.props.onChangePage();
                  }.bind(this)}>
                    {this.props.title}
                  </a>
                 </h1>
                 {this.props.sub}
               </header>
              ); 
            }
           }
           export default Subject; 
           
   (4) 하위 컴포넌트(NavC.js)에서 이벤트 처리   
      1) App.js에 이벤트 정의 
          <NavC 
           data={this.state.navc}
           onChangePage={function(){
            this.setState(
              {mode: "read"}
            );
           }.bind(this)}
         />
      2) NavC.js에서 이벤트 호출
          <li key={data[i].id}>
                <a 
                    href={"/content/"+data[i].id}
                    onClick={function(e){
                        e.preventDefault();
                        this.props.onChangePage();
                    }.bind(this)}>
                    {data[i].title}
                </a>
            </li>

   (5) 상위컴포넌트(App.js)에서 selected_navc_id 속성 추가 
       class App extends Component{
        constructor(props){
         super(props);
         this.state = {
           ...
           selected_navc_id: 2, 
           ...
         };
        }
        render(){
         ...
         }else if(this.state.mode === "read"){
           //_title = this.state.navc[0].title;
           //_desc = this.state.navc[0].desc;

           for(var i=0; i<this.state.navc.length; i++){
            var data = this.state.navc[i];
            if(data.id === this.state.selected_navc_id){
              _title = data.title;
              _desc = data.desc;
              break;
            }
           }
         }
         ...
        }
      }

   (6) 하위컴포넌트(NavC.js)에서 파라미터(id)를 넘김
      1) id값을 로그 출력
         <li key={data[i].id}>
                <a 
                    href={"/content/"+data[i].id}
                    data-id={data[i].id} //먼저 추가해야 함
                    onClick={function(e){
                        console.log("#NavC e", e);
                        console.log("#NavC e.target.dataset.id", e.target.dataset.id);
                        e.preventDefault();
                        debugger;
                        //this.props.onChangePage();
                    }.bind(this)}>
                    {data[i].title}
                </a>
            </li>

       2) 파라미터로 넘기기 
          <1> 방법1 ( 'data-XXX' 속성 이용 ) 
            <li key={data[i].id}>
               <a 
                  href={"/content/"+data[i].id}
                  data-id={data[i].id} //먼저 추가해야 함
                  onClick={function(e){
                     //console.log("#NavC e", e);
                     //console.log("#NavC e.target.dataset.id", e.target.dataset.id);
                     e.preventDefault();
                     this.props.onChangePage(e.target.dataset.id);
                  }.bind(this)}>
                  {data[i].title}
               </a>
            </li>

         <2> 방법2 ( 'bind(파라미터)' 이용 )
             <li key={data[i].id}>
               <a 
                  href={"/content/"+data[i].id}
                  onClick={function(id, e){
                     console.log("#NavC id", id);
                     e.preventDefault();
                     this.props.onChangePage(id);
                  }.bind(this, data[i].id)}>
                  {data[i].title}
               </a>
            </li>

   (7) 상위컴포넌트(App.js)에서 파라미터를 받기 
        <NavC 
          data={this.state.navc}
          onChangePage={function(id){
            this.setState(
              {
                mode: "read", 
                selected_navc_id: Number(id)
              }
            );
          }.bind(this)}
         />


/////////////////////// react-app -> 복사 -> react-crud ////////////////////// 
#Part2: CRUD

[9] Create 구현1 : mode변경  
    (1) App.js에서 다음 html을 추가 후 크롬에서 확인
       <ul>
          <li><a href="/create">입력</a></li>
          <li><a href="/update">수정</a></li>
          <li><a href="/delete">삭제</a></li>
        </ul>

    (2) components/Control.js 생성 ( Subject.js를 복사해서 .. )
       import { Component } from "react";
      class Control extends Component {
         render(){
           console.log("#Control render()");
           return(
            <ul>
              <li><a href="/create">입력</a></li>
              <li><a href="/update">수정</a></li>
              <li><a href="/delete">삭제</a></li>
            </ul>
           ); 
         }
        }
        export default Control;

   (3) App.js 
         <Control onChangeMode={function(_mode){
            this.setState({
              mode: _mode
            });
           }.bind(this)}/>

   (4) Control.js 에서 onChangeMode()호출 및 parameter 넘기기
       <ul>
          <li><a href="/create"
                onClick={function(e){
                    e.preventDefault();
                    this.props.onChangeMode("create");
                }.bind(this)}>입력</a>
          </li>
          <li><a href="/update"
                onClick={function(e){
                    e.preventDefault();
                    this.props.onChangeMode("update");
                }.bind(this)}>수정</a></li>
          <li><a href="/delete"
                onClick={function(e){
                    e.preventDefault();
                    this.props.onChangeMode("delete");
                }.bind(this)}>삭제</a></li>
        </ul> 

   (5) Parameter 확인 
      크롬F12 -> Components탭 -> App -> mode값 변화 확인

[10] Create 구현2 : CreateContent.js 생성 
   (1) components/Content.js -> components/'ReadContent'.js 로 파일이름 변경 

    (2) components/'CreateContent'.js 생성 ( ReadContent.js 를 복사해서.. )
       import { Component } from "react";
      class CreateContent extends Component{
         render(){
           console.log("#CreateContent render()");
           return(
            <article>
              <h3>Create</h3>
              <form>
              </form>
            </article>
           );
         }
        }
        export default CreateContent;

   (3) App.js 
       render(){
         ...
         var _article = null; //추가1
         ...
         }else if(this.state.mode === "read"){
           for(var i=0; i<this.state.navc.length; i++){
            ...
            }
           }
           _article = <ReadContent title={_title} desc={_desc}/> //추가2
         }else if(this.state.mode === "create"){
           _article =<CreateContent/> //추가3 
         }

         return (
           <div className="App">
            <Subject 
              ...
            />
            <NavC 
              ...
            />
            <Control onChangeMode={function(_mode){
               this.setState({
                 mode: _mode
               });
            }.bind(this)}/>

            {_article}  //추가4

           </div>
         );
        }
      
   (4) 크롬 테스팅 

[11] Create 구현3 : <form>를 구현 
    (1) App.js 
      class App extends Component{
        constructor(props){
         super(props);
         this.state = {
           mode: "create", 

   (2) CreateContent.js 
       <article>
          <h3>Create</h3>
          <form action="/create_process" method="post" onSubmit={function(e){
            e.preventDefault();
            alert("전송!");
          }.bind(this)}>
            <p><input name="title" placeholder="제목"/></p>
            <p><input name="desc" placeholder="설명"/></p>
            <p><input type="submit" value="입력"/></p>
          </form>
        </article>

[11] Create 구현4 : onSubmit 이벤트 처리 
   (1) App.js 
      }else if(this.state.mode === "create"){
        _article =<CreateContent onSubmit={function(_title, _desc){
         //this.state.navc 에 추가
        }.bind(this)}/>  
      }

   (2) CreateContent.js 
      <form action="/create_process" method="post" onSubmit={function(e){
            e.preventDefault();
            alert("전송!");
            debugger;
            //this.props.onSubmit(param1, param2);
          }.bind(this)}>

   (3) value값 찾기 
      1) '전송' click -> F12 -> Source탭 -> CreateContent.js의 debugger;에서 멈춤
      2) Console탭 -> e -> 엔터*2 
      3) form -> target -> input -> value -> ... 클릭 
      4) Console탭에서 출력 
         e.target.title.value -> 엔터!
         e.target.desc.value -> 엔터! 

    (4) CreateContent.js 
      <form action="/create_process" method="post" onSubmit={function(e){
            e.preventDefault();
            //debugger;
            this.props.onSubmit(e.target.title.value, e.target.desc.value);
         alert("전송완료!");
          }.bind(this)}>

   (5) App.js에서 넘어온 param 확인
        }else if(this.state.mode === "create"){
           _article =<CreateContent onSubmit={function(_title, _desc){
            console.log(_title, _desc);
            //this.state.navc 에 추가
           }.bind(this)}/> //추가3 
        }

   (6) 확인 
      제출click -> F12 -> Console탭 

[13] Create 구현5: Content 변경
   (1) App.js 
      class App extends Component{
        constructor(props){
         super(props);
         this.max_navc_id = 3; //UI에 영향이 없는 속성이기때문에 멤버변수로 뺌 
         this.state = {
            ...

   (2) navc에 객체를 추가 
       }else if(this.state.mode === "create"){
        _article =<CreateContent onSubmit={function(_title, _desc){
         //console.log(_title, _desc);
         //this.state.navc 에 추가
         this.max_navc_id = this.max_navc_id + 1; //step1
         this.state.navc.push(
           {id:this.max_navc_id, title:_title, desc:_desc}
         ); //step2 
         this.setState({
           navc:this.state.navc
         }); //step3
        }.bind(this)}/> //추가3 
       }

   (3) 크롬에서 추가 확인

    (4) push()와 concat() 테스트 ( at 크롬 Console탭 )
      1) push() //가변메소드 
          var a = [1, 2]; 
         a.push(3);
         a; //[1, 2, 3]

      2) concat() //불변메소드 
         var b = [1, 2]; 
           var c = b.concat(3);
         b; //[1, 2]
         c; //[1, 2, 3]

    (5) 복사본 배열 적용( concat()을 이용해서 )
      }else if(this.state.mode === "create"){
        _article =<CreateContent onSubmit={function(_title, _desc){
         this.max_navc_id = this.max_navc_id + 1; //step1
         /*this.state.navc.push(
           {id:this.max_navc_id, title:_title, desc:_desc}
         ); */
         var _navc = this.state.navc.concat(
           {id:this.max_navc_id, title:_title, desc:_desc}
         ); //step2 
         this.setState({
           navc:_navc
         }); //step3
        }.bind(this)}/> //추가3 
      }

    (6) 크롬에서 추가 확인 
      
[14] Create 구현6: shouldComponentUpdate()
   (1) NavC.js ( 파라미터 X )
       1) true 일때
           shouldComponentUpdate(){
            console.log("#NavC shouldComponentUpdate()");
            return true;
         }
         render(){
            console.log("#NavC render()");

          #결과) log 출력 
                "#NavC shouldComponentUpdate()"
            "#NavC render()"
         
      2) false 일때 
         shouldComponentUpdate(){
            console.log("#NavC shouldComponentUpdate()");
            return false;
         }

         #결과) log 출력 
                "#NavC shouldComponentUpdate()"

   (2) NavC.js ( 파라미터 O )
      1) 새로운 data와 기존 data를 비교 
         shouldComponentUpdate(newProps){
            console.log("#NavC shouldComponentUpdate()", newProps.data, this.props.data);
            return false;
         }

         #결과) log 출력 
             #NavC shouldComponentUpdate() (4) [...] (3) [...]

      2) '새로운 props객체의 data'와 '기존 props객체의 data'가 다른 경우에만 render() 호출 
         shouldComponentUpdate(newProps){
            console.log("#NavC shouldComponentUpdate()", newProps.data, this.props.data);
            if(this.props.data === newProps.data){
               return false;
            }
            return true;
         }
          
         #결과) log 출력 
              #NavC shouldComponentUpdate() (4) [...] (3) [...]
            #NavC render()


[15] Array복제와 Object복제 ( Immutable 이슈 )
   (1) Array복제 
       1) 테스트 ( at Console탭 )
          var a = [1, 2];
           var b = Array.from(a);
         console.log(a, b, a===b); //[1,2] [1,2] false

           var a = [1,2];
           var b = Array.from(a);
         b.push(3);
           console.log(a, b, a===b); //[1,2] [1,2,3] false

      2) App.js에 적용 
         }else if(this.state.mode === "create"){
           _article =<CreateContent onSubmit={function(_title, _desc){
            this.max_navc_id = this.max_navc_id + 1; //step1
            /*this.state.navc.push(
              {id:this.max_navc_id, title:_title, desc:_desc}
            ); */
            /*var _navc = this.state.navc.concat(
              {id:this.max_navc_id, title:_title, desc:_desc}
            );*/
            var copy_navc = Array.from(this.state.navc);
            copy_navc.push(
              {id:this.max_navc_id, title:_title, desc:_desc}
            );//step2 
            this.setState({
              //navc:_navc
              navc:copy_navc //step3
            }); 
           }.bind(this)}/> //추가3 
         }

        #결과) log 출력 
        '#NavC shouldComponentUpdate()' 
        '#NavC render()'
  

   (2) Object복제 ( at Console탭 )
      var a = {name:'kim'};
       var b = Object.assign({}, a);
      console.log(a, b, a===b); //{name: 'kim'} {name: 'kim'} false

        var a = {name:'kim'}; 
      var b = Object.assign({}, a);
      b.name = 'soo';
        console.log(a, b, a===b); //{name: 'kim'} {name: 'soo'} false


      var a = {name:'kim'}; 
      var b = Object.assign({left:1, right:2}, a);
        console.log(a, b, a===b); //{name: 'kim'} {left: 1, right: 2, name: 'kim'} false


[16] Update 구현1: 수정폼
   (1) UpdateContent.js 생성 ( CreateContent.js를 복사해서.. )
      import { Component } from "react";
      class UpdateContent extends Component{
         render(){
           console.log("#UpdateContent render()");
           return(
            <article>
              <h3>Update</h3>
              <form action="/update_process" method="post" onSubmit={function(e){
               e.preventDefault();
               //debugger;
               this.props.onSubmit(e.target.title.value, e.target.desc.value);
                    alert("전송완료!");
              }.bind(this)}>
               <p><input name="title" placeholder="제목"/></p>
               <p><input name="desc" placeholder="설명"/></p>
               <p><input type="submit" value="수정"/></p>
              </form>
            </article>
           );
         }
        }
        export default UpdateContent;

   (2) App.js에 추가 
      }else if(this.state.mode === "update"){
        _article = <UpdateContent onSubmit={function(_title, _desc){
         var copy_navc = Array.from(this.state.navc);
         copy_navc.push(
           {title:_title, desc:_desc}
         );
        }.bind(this)}/>
      }

   (3) 테스팅 
      '수정'링크click -> 수정폼으로 변경됨 

   (4) #과제: App.js에서 UpdateContent.js로 데이터를 넘겨서 폼에 셋팅 방법?


[17] Update 구현2: '리펙토링' & '데이터' 넘기기 
   (1) App.js 리펙토링1 : '함수 독립'
       1) App.js
         getContent(){
            var _title, _desc = null;
            var _article = null; //추가1
            if(this.state.mode === "welcome"){
              _title = this.state.welcome.title;
              _desc = this.state.welcome.desc;
            }else if(this.state.mode === "read"){
              ...
            }else if(this.state.mode === "create"){
              ...
            }else if(this.state.mode === "update"){
              ...
            }

            return _article; //추가 
           }

      2) 변경 
         {_article}을 {this.getContent()}로 수정 
         
      3) 테스팅 
            동일한 결과 수행 

   (2) App.js 리펙토링2 : '선택된 데이터를 가져오는 중복 로직을 공통함수로 뺌'
       1) App.js 
         getReadContent(){
            for(var i=0; i<this.state.navc.length; i++){
              var data = this.state.navc[i];
              if(data.id === this.state.selected_navc_id){
               //_title = data.title;
               //_desc = data.desc;
               return data;
               //break;
              }
            }
           }

      2) 적용1 
         }else if(this.state.mode === "read"){
           var _content = this.getReadContent();//변경
           _article = <ReadContent title={_content.title} desc={_content.desc}/> //추가2
         }

       3) 적용2 
          else if(this.state.mode === "update"){
           var _content = this.getReadContent();//추가
           _article = <UpdateContent data={_content} onSubmit={function(_title, _desc){
            ...
         } 
          
         #중요) 'data={_content}' 추가됨 

   (3) UpdateContent.js에서 데이더 받기 
      1) log 확인 
         class UpdateContent extends Component{
            render(){
              console.log("#UpdateContent render()");
              console.log(this.props.data); //넘겨진 데이터 확인

      2) update form에 데이터 셋팅 
         <1> 문제: (데이터는 가져오나..) '경고메세지'가 뜸 
            <p><input name="title" placeholder="제목" value={this.props.data.title}/></p>
            <p><textarea name="desc" placeholder="설명" value={this.props.data.desc}/></p>

         <2> 해결: 'setState()'를 이용 
            1> 추가 
               constructor(props){
                 super(props);
                 this.state = {
                  id: this.props.data.id, 
                  title: this.props.data.title, 
                  desc: this.props.data.desc
                 }
               }

            2> 적용 
               <p><input name="title" placeholder="제목" value={this.state.title}
               onChange={function(e){
                 this.setState({
                  title:e.target.value
                 });
               }.bind(this)}/></p>
               <p><textarea name="desc" placeholder="설명" value={this.state.desc}
               onChange={function(e){
                 this.setState({
                  desc:e.target.value
                 });
               }.bind(this)}/></p>

            3> 테스팅 
               정상 작동 ( '경고' 사라짐 )

[18] Update 구현3: 'id를 추가'하고, 수정버튼을 클릭하면.. 'App.js에서 파라미터로 받기'
   (1) UpdateContent.js 
      1) hidden 필드 추가 
          <input type="hidden" name="id" value={this.state.id}/> //추가

        2) form의 onSubmit()에 id파라미터 추가 
         <form action="/update_process" method="post" onSubmit={function(e){
            ...
            this.props.onSubmit(this.state.id, this.state.title, this.state.desc); //추가 및 변경 
         alert("전송완료!");
           }.bind(this)}>

   (2) App.js 
      }else if(this.state.mode === "update"){
        var _content = this.getReadContent();//추가
        _article = <UpdateContent data={_content} onSubmit={function(_id, _title, _desc){ //_id 추가
         var copy_navc = Array.from(this.state.navc);
         for(var i=0; i<copy_navc.length; i++){
           if(copy_navc[i].id === _id){
            copy_navc[i] = {id:_id, title:_title, desc:_desc};
            break;
           }
         }
         this.setState({
           navc:copy_navc
         });
        }.bind(this)}/>
      } 

   (3) 테스팅 
      업데이트 성공!

    (4) update 후, 결과를 자동으로 read하려면.. 
      }else if(this.state.mode === "update"){
        ...
         this.setState({
           navc:copy_navc, 
           mode:"read"  //추가 후 테스팅!
         });
        }.bind(this)}/>
      }

    (5) create 후, 결과를 자동으로 read하려면.. 
      }else if(this.state.mode === "create"){
        ...
         this.setState({
           navc:copy_navc,  
           mode:"read", //추가
           selected_navc_id: this.max_navc_id //추가
         }); 
        }.bind(this)}/> 
      }

[19] welcome모드 수정/보완 
    (1) App.js 수정 
      this.state = {
         mode: "welcome",  //수정 
         ...

   (2) 'welcome' 모드 일때 _article 셋팅 
        if(this.state.mode === "welcome"){
        _title = this.state.welcome.title;
        _desc = this.state.welcome.desc;
        _article = <ReadContent title={_title} desc={_desc}/> //추가
      }  

[20] Delete 구현
   (1) App.js 수정 
       <Control onChangeMode={function(_mode){
          if(_mode === "delete"){
            if(window.confirm("정말 삭제할까요?")){
              var copy_navc = Array.from(this.state.navc);
              for(var i=0; i<copy_navc.length; i++){
                if(copy_navc[i].id === this.state.selected_navc_id){
                  copy_navc.splice(i, 1);
                  break;
                }
              }
              this.setState({
                navc:copy_navc, 
                mode:"welcome"
              });
              alert("삭제 성공!");
            }
          }else{
            this.setState({
              mode: _mode
            });
          }
        }.bind(this)}/>

   (2) 테스팅 


//////////////////////////////////////////////////////////////////////////
#Part3: Ajax   
[1] 템플릿 준비하기
   (1) app 생성 
       C:\SOO\React>yarn create react-app react-ajax

   (2) app 실행 
      C:\SOO\React\react-ajax>yarn start

   (3) 불필요 파일삭제( src/하위 )
      1) App.css
      2) App.test.js
      3) logo.svg
      4) reportWebVitals.js 
      5) setupTests.js

    (4) App.js
      function App() {
        return (
         <div className="App">
           <h1>Ajax홈</h1>
           <nav>
            <ul>
              <li><a href="1">자바</a></li>
              <li><a href="2">파이썬</a></li>
              <li><a href="3">오라클</a></li>
            </ul>
           </nav>
         </div>
        );
      }
      export default App;

    (5) index.js 
      import React from 'react';
      import ReactDOM from 'react-dom';
      import './index.css';
      import App from './App';

      ReactDOM.render(
        <React.StrictMode>
         <App />
        </React.StrictMode>,
        document.getElementById('root')
      );
 
    (6) index.css
      body {
        background-color: aquamarine;
      }

    (7) public/list.json 생성 
      [
           {"id":1, "title":"자바"},
         {"id":2, "title":"파이썬"},
         {"id":3, "title":"오라클"}
      ]

    (8-1) public/1.json
      {"id":1, "title":"자바", "desc":"자바는 ..."}
   (8-2) public/2.json
      {"id":2, "title":"파이썬", "desc":"파이썬은 ..."}
   (8-3) public/3.json
      {"id":3, "title":"오라클", "desc":"오라클은 ..."}

[2] Nav Component 로 빼내고.. list.json을 읽어서 리스팅하기 
   (1) Nav.js
       import { Component } from "react";
      class Nav extends Component {
         render(){
            return(
               <nav>
                  <ul>
                  <li><a href="1">자바</a></li>
                  <li><a href="2">파이썬</a></li>
                  <li><a href="3">오라클</a></li>
                  </ul>
               </nav>
            );
         }
      }
      export default Nav;
      
    (2) App.js 
      import Nav from "./Nav";
      function App() {
        return (
         <div className="App">
           <h1>Ajax홈</h1>
           <Nav/>
         </div>
        );
      }
      export default App;

      #실행) 결과는 동일 

   (3) Nav.js에서 componentDidMount() 구현 
      class Nav extends Component {
         componentDidMount(){ //컴포넌트 로딩완료 후, 호출되는 메소드
            fetch("list.json") //해당 리소스에 연결
            .then(function(result){
               var temp = result.json();//json ->js객체를 포함하는 객체로 변경
               console.log("temp", temp);
               return temp;
            })
            .then(function(js){
               console.log(js); //변경된 js객체가 출력
            })
         }
         render(){
            ...
         }
        }
      
      #확인) F12 -> Network탭 -> Use large~체크 -> list.json클릭 -> Esc키 -> Console확인
       
   (4) state 추가  
      class Nav extends Component {
         state = { //추가 
            list: []
         }
         componentDidMount(){
            ...
            .then(function(js){
               //console.log(js); //변경된 js객체가 출력
               this.setState({ //추가 
                  list:js
               });
            }.bind(this)) //변경
         }
         render(){
            ...
         }
      }

    #확인)  Component탭 -> Nav선택 -> state확인

   (5) Nav.js의 render() 수정 
       render(){
         var listTag = [];
         for(var i=0; i<this.state.list.length; i++){
            var li = this.state.list[i];
            listTag.push(<li key={li.id}><a href={li.id}>{li.title}</a></li>);
         }
         return(
            <nav>
               <ul>
               {listTag}
               </ul>
            </nav>
         );
      }

[3] Article Component 추가하기 
   (1) App.js에서 class Article 추가 및 적용 
      class Article extends Component {
        render(){
           return(
            <article>
               <h3>{this.props.title}</h3>
               {this.props.desc}
            </article>
           );
        }
      }
      function App() {
        return (
         <div className="App">
           <h1>Ajax홈</h1>
           <Nav/>
           <Article title={"환영"} desc={"어서와 리액트.. 에이젝스도 환영해!"}></Article>
         </div>
        );
      }

   (2) 변경 ( function App() -> class App )
      class App extends Component {
        render(){
         return (
           <div className="App">
            <h1>Ajax홈</h1>
            <Nav/>
            <Article title={"환영"} desc={"어서와 리액트.. 에이젝스도 환영해!"}></Article>
           </div>
         );
        }
      }
  
    (3) App class에 state 생성 
      class App extends Component {
        state = { //추가
         article: {title:"환영", desc:"어서와 리액트.. 에이젝스도 환영해!"} 
        }
        render(){
         return (
           <div className="App">
            <h1>Ajax홈</h1>
            <Nav/>
            <Article title={this.state.article.title} desc={this.state.article.desc}/>
           </div>
         );
        }
      }
   
[4] <Nav> 이벤트 처리 
   (1) App class 에서 <Nav> 이벤트 정의
      <Nav onClick={function(id){
          console.log(id); //하위컴포넌트에서 넘겨질 id 출력
        }.bind(this)}/>
      
   (2) Nav class에서 이벤트 호출 및 파라미터 넘기기   
       render(){
         var listTag = [];
         for(var i=0; i<this.state.list.length; i++){
            var li = this.state.list[i];
            listTag.push(
            <li key={li.id}>
               <a href={li.id} //변경 시작 
                  data-id={li.id}
                  onClick={function(e){
                     e.preventDefault();
                     this.props.onClick(e.target.dataset.id);
                  }.bind(this)}>{li.title}</a> //변경 끝 
            </li>
            );
         }
         return(
            ...
         );
      }

       #확인) 링크click -> Console탭 -> id를 확인! 

   (3) App.js에서 <Nav>태그 이벤트 구현 
      <Nav onClick={function(id){
          //console.log(id); //하위컴포넌트에서 넘겨질 id 출력
          fetch(id+".json")
          .then(function(result){
            return result.json();//json ->js객체를 포함하는 객체로 변경
          })
          .then(function(js){
            this.setState({
              article: {title:js.title, desc:js.desc} 
            });
          }.bind(this))
        }.bind(this)}/>

      #확인) F12 -> Component탭 -> App선택 -> 링크click -> state 변화 확인 


[5] 리팩토링 : Component 의 종류별로 기능 분업화
   (1) React Component (역할기준) 종류 
       1) Presentation Component : 뷰 역할 
       2) Container Component : 로직을 품을 수 있는 컴포넌트 

   (2) Nav class 수정 
       1) state 주석 처리 
         /*state = {
            list: []
         }*/
        2) componentDidMount(){} 잘라내기 

    (3) App class 에 붙여넣기 
        class App extends Component {
        state = { 
         article: {title:"환영", desc:"어서와 리액트.. 에이젝스도 환영해!"}, 
         list: [] //추가 
        }
        componentDidMount(){ //옮겨진 메소드
         fetch("list.json") 
         .then(function(result){
            var temp = result.json();
            console.log("temp", temp);
            return temp;
         })
         .then(function(js){
            this.setState({
               list:js
            });
         }.bind(this))
        }
        render(){
         return (
           <div className="App">
            <h1>Ajax홈</h1>
            <Nav 
              list={this.state.list} //추가 
              ...
           </div>
         );
        }
      }

   (4) Nav class 수정
      render(){
         var listTag = [];
         for(var i=0; i<this.props.list.length; i++){ //props로 수정
            var li = this.props.list[i]; //props로 수정
            ...
         }
         ...
       }
      ...
   
    #테스팅) 동일한 결과!

///////////////////////////////////////////////////////////////////////
#Part4: Spring
[1] 템플릿 준비하기
   (1) app 생성 
      C:\SOO\React>create-react-app react-spring

   (2) app 실행 
        C:\SOO\React\react-spring>yarn start

   (3) 불필요 파일 삭제 
      1) App.css
      2) App.test.js
      3) logo.svg
      4) reportWebVitals.js 
      5) setupTests.js

   (4) App.js 수정 
        function App() {
        return (
         <div className="App">
           안녕.. 스프링!
         </div>
        );
      }
      export default App;

   (5) index.css 수정
      body {
        background-color: khaki;
      }

   (6) index.js 수정 
        ...
      ReactDOM.render(
        <React.StrictMode>
         <App />
        </React.StrictMode>,
        document.getElementById('root')
      );

[2] 순서
   (1) 'backend'에 Restful(json format) CRUD 구축 
   (2) 'frontend'에서 비동기 통신 방식(axios/fetch)으로 url요청 

[3] 'backend' 
   (1) AddressRestController.java
        package soo.md.controller;

      import org.springframework.web.bind.annotation.CrossOrigin;
      ...

      @Log4j
      @RestController
      @RequestMapping("rest_addr")
      @CrossOrigin(origins = "*", maxAge = 3600) //#매우 중요!
      public class AddressRestController { //CRUD
         @Autowired
         private AddressAjaxService service;
         
         @PostMapping("create")
         public void create(@RequestBody Address address) { //파라미터를 JSON을 받을 때 
            log.info("#AddressRestController create() address: " + address);
            service.insertS(address);
         }
         //at React => http://127.0.0.1:8080/rest_addr/create.json
         //{"seq":-1, "name":"병철", "addr":"도쿄"}   
         
         //(2) Read ( select )
         @GetMapping("read")
         public List<Address> read(){
            List<Address> list = service.listS();
            return list;
         }
         //at React => http://127.0.0.1:8080/rest_addr/read.json
         
         @GetMapping("read/{seq}")
         public Address read(@PathVariable long seq){
            Address address = service.selectBySeqS(seq);
            return address;
         }
         //at React => http://127.0.0.1:8080/rest_addr/read/16.json
         
         @GetMapping(value="read", params = {"na"})
         public List<Address> read(@RequestParam("na") String name){
            List<Address> list = service.selectByNameS(name);
            return list;
         }
         //at React => http://127.0.0.1:8080/rest_addr/read.json?na=병철
         
         //(3) Delete (delete)
         @DeleteMapping("delete/{seq}")
         public void delete(@PathVariable long seq) {
            service.deleteS(seq);
         }
         //at React => http://127.0.0.1:8080/rest_addr/delete/8
      }

   (2) URL 테스트 
      1) R ( Get방식 )
           - http://127.0.0.1:8080/rest_addr/read.json
            - http://127.0.0.1:8080/rest_addr/read/1.json
          - http://127.0.0.1:8080/rest_addr/read.json?na=병철

      2) C ( Post방식 at 'Talend Tester' )
         - http://127.0.0.1:8080/rest_addr/create.json
            ( {"seq":-1, "name":"병철", "addr":"도쿄"}   )

      3) D ( Delete방식 at 'Talend Tester' )
         - http://127.0.0.1:8080/rest_addr/delete/8

        4> U ( Put방식 at 'Talend Tester' )

[4-1] 'frontend' 셋팅 
   (1) axios방식
        C:\SOO\React\react-spring>yarn add axios

       참고) axios는 별도 설치 ( https://yarnpkg.com/package/axios ) 

    (2) fetch방식 
      참고) React에 기본 내장

[4-2] 'frontend' 통신방법 
   먼저.. src/components 디렉토리 생성 후
   (1) Axios 방법 
      1) AxiosGet.js 
         import { Component } from "react";
         import axios from "axios"
         class AxiosGet extends Component {
            componentDidMount(){
               //axios.get("http://127.0.0.1:8080/rest_addr/read.json") //모두검색
               //axios.get("http://127.0.0.1:8080/rest_addr/read/12.json")//seq검색
               axios.get("http://127.0.0.1:8080/rest_addr/read.json?na=병철") //name검색
               .then(function(response){ //정상처리시 실행 
                  console.log("1", response.data);
               })
               .catch(function(error){ //오류발생시 실행
                  console.log("2", error);
               })
               .then(function(){ //항상 실행
                  console.log("3");
               });
            }
            render(){
               return(
                  <h1>AxiosGet</h1>
               );
            }
         }
         export default AxiosGet;

      2) AxiosPost.js
         import { Component } from "react";
         import axios from "axios"
         class AxiosPost extends Component {
            componentDidMount(){
               axios.post("http://127.0.0.1:8080/rest_addr/create.json", 
               {"seq":-1, "name":"리액트", "addr":"페이스북"}) //name검색
               .then(function(response){ //정상처리시 실행 
                  console.log("1", response.data);
               })
               .catch(function(error){ //오류발생시 실행
                  console.log("2", error);
               })
               .then(function(){ //항상 실행
                  console.log("3");
               });
            }
            render(){
               return(
                  <h1>AxiosPost</h1>
               );
            }
         }
         export default AxiosPost;

      3) AxiosDelete.js
         import { Component } from "react";
         import axios from "axios"
         class AxiosDelete extends Component {
            componentDidMount(){
               axios.delete("http://127.0.0.1:8080/rest_addr/delete/20") 
               .then(function(response){ //정상처리시 실행 
                  console.log("1", response.data);
               })
               .catch(function(error){ //오류발생시 실행
                  console.log("2", error);
               })
               .then(function(){ //항상 실행
                  console.log("3");
               });
            }
            render(){
               return(
                  <h1>AxiosDelete</h1>
               );
            }
         }
         export default AxiosDelete;

   (2) Fetch 방법 
      1) FetchGet.js 
         import { Component } from "react";
         class FetchGet extends Component {
            componentDidMount(){
               fetch("http://127.0.0.1:8080/rest_addr/read.json") //모두검색
               //axios.get("http://127.0.0.1:8080/rest_addr/read/12.json")//seq검색
               //axios.get("http://127.0.0.1:8080/rest_addr/read.json?na=병철") //name검색
               .then(function(response){ //정상처리시 실행 
                  var tmp = response.json(); 
                  console.log("1", tmp);
                  return tmp;
               })
               .catch(function(error){ //오류발생시 실행
                  console.log("2", error);
               })
               .then(function(js){ //항상 실행
                  console.log("3", js);
               });
            }
            render(){
               return(
                  <h1>FetchGet</h1>
               );
            }
         }
         export default FetchGet;

      2) FetchPost.js
      3) FetchDelete.js

[4-3] 'frontend' App.js 
      function App() {
        return (
         <div className="App">
           {/* 안녕.. 스프링! */}
           {/* <AxiosGet/> */}
           {/* <AxiosPost/> */}
           {/* <AxiosDelete/> */}
           <FetchGet/>
         </div>
        );
      }
      export default App;