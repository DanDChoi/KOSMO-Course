1. IO ( Input Output )
    (1) 스트림 ( Stream ): '데이터의 흐름'
        Data Source(근원지) ----> Data Destination(목적지)

    (2) 스트림특징
        1) FIFO ( First In First Out )
        2) 지연성 
        3) 단방향성
        4) 유연성

    (3) 표준입력 / 표준출력
        키보드(System.in) ----> 모니터(System.out)

        //ex) Day1/A.java
    (4) 구분
        1) 전송단위
            <1> 바이트 스트림 ( 1 byte Stream )
                ex) XXXStream

            <2> 문자 스트림 (2 byte Stream )
                ex) XXXReader, XXXWriter
        
        2) 특성
            <1> 근본 스트림 ( Node Stream )
                ex) System.in, System.out, ...
            <2> 다리 스트림 ( Bridge Stream )
                ex) InputStreamReader, OutputStreamWriter
            <3> 목적(응용) 스트림 ( Filter Stream )
                ex) BufferedReader, PrintWriter, ...

        3) 입출력
            <1> 입력 스트림
                ex) XXXInputStream, XXXReader
            <2> 출력 스트림
                ex) XXXOutputStream, XXXWriter

    (5) 주요 스트림 클래스
        1) Inputstream / OutputStream
            ex) Day01/B.java

        2) FileInputStream / FileOutputStream
            ex) Day01/C.java
       
        3) BufferedInStream / BufferedOutStream
            ex) Day01/D.java

        4) DataInputStream / DataOutputStream
            ex) Day01/E.java

2. NetWork
    (1) TCP(Transmission Control Protocol): 연결지향 프로토콜 (신뢰성 +실시간, 비유: 전화)
        // ex) Day03/AServer.java , AClient.java
        // ex) Day05/MtServer.java, MtClient.java
        // ex) Day05/FServer.java, FClient.java
        
    (2) UDP(User Datagram Protocol): 비연결지향 프로토콜 (비신뢰성, 비유:편지)
        // ex) Day05/UServer.java, UClient.java

3. GUI( Graphic User Interface )
    (1) 배치
        1)모양
            Component 1, 2, ...
            ---------------------
                Container

            //ex) Day06/A.java

        2) 배치관리자 ( LayoutManager )
            - BorderLayout 
            - GridLayout
            - CardLayout
            - FlowLayout
            //ex) Day06/B.java ~ E.java

        3) Event
            - 위임형 이벤트처리 모델 ( Delegation Event Model ) 
              (예: A1 ~ A3 )
              
            - 셀프 이벤트처리 모델 ( Self Event Model) //강사님이 이름 지음.

            //ex) Day07/A1.java ~ A3.java