(01) Android Studio 무설치(zip버젼)로 사용 
    <1> 환경변수에 JAVA_HOME 잡기( jdk8 이상 )
    <2> android-studio-2021.1.1.22-windows.zip
	<3> ~\android-studio\bin\studio64.exe 실행
	<4> Custom 선택 
	    - Android SDK Location 디폴트(예: C:\Users\kosmo\AppData\Local\Android\Sdk )
	    - 플젝디렉토리 (예: C:\SOO\Android\AndroidStudioProjects ) 
		- Empty Activity 로 플젝( Api 21 ) 생성   

    cf) 실행시 버그 해결 
       1_1. JDK 버젼 변경 
          File -> Proejct Structure.. -> SDK Location메뉴 
		  -> Gradle Settings 링크 클릭 -> Gradle JDK -> Embeded JDK version 11.0.10 ~ 선택

       1_2. Android SDK 라이센스 해결 
          File -> Settings -> Appearance & Behavior -> System Settings -> Android SDK 
          -> SDK Tools 탭 -> Google Play Licensing Library 체크 -> Apply 