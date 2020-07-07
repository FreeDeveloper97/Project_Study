.MODEL	
.STACK	100H
.DATA
MSG	DB	'*******************************************',0DH,0AH
	DB	'*  WELCOME TO OUR ASSEMBLY BASEBALL GAME  *',0DH,0AH
	DB	'*******************************************',0DH,0AH
	DB	'*					  *',0DH,0AH
	DB	'*		  NOTICE		  *',0DH,0AH
	DB	'* 1. This game is consist of 9 inning     *',0DH,0AH
	DB	'* 2. You must use 1~9 between number	  *',0DH,0AH					;10
	DB	'* 3. One inning cannot input same number  *',0DH,0AH
	DB	'*					  *',0DH,0AH
	DB	'* Maker : INHA COM 12171571 Kang Minsang  *',0DH,0AH
	DB	'* 	   Computer Engineering		  *',0DH,0AH
	DB	'*******************************************',0DH,0AH,'$'

RULE	DB	0DH,0AH
	DB	'*******************************************',0DH,0AH
	DB	'*               GAME RULES                *',0DH,0AH
	DB	'*******************************************',0DH,0AH						;20
	DB	'*        What is Strike? Ball? Out?       *',0DH,0AH
	DB	'* ------------=====<EX1>=====------------ *',0DH,0AH
	DB	'* Random number     : 123                 *',0DH,0AH
	DB	'* Your input number : 135                 *',0DH,0AH
	DB	'*                  THEN                   *',0DH,0AH
	DB	'* 1 : Strike,    3 : Ball,    5 : Out     *',0DH,0AH
	DB	'* ------------=====<EX2>=====------------ *',0DH,0AH
	DB	'* Random number     : 471                 *',0DH,0AH
	DB	'* Your input number : 417                 *',0DH,0AH
	DB	'*                  THEN                   *',0DH,0AH							;30
	DB	'* 4 : Strike,    1 : Ball,    7 : Ball    *',0DH,0AH
	DB	'*					  *',0DH,0AH
	DB	'*           Are you understand?           *',0DH,0AH
	DB	'*					  *',0DH,0AH
	DB	'*         When before end of game         *',0DH,0AH
	DB	'*       Make 3 Strike : [YOU WIN!]        *',0DH,0AH
	DB	'*               else : [YOU LOSE!]        *',0DH,0AH
	DB	'*					  *',0DH,0AH
	DB	'*   How can I quit when i playing game?   *',0DH,0AH
	DB	'*            Press [ESC] button           *',0DH,0AH						;40
	DB	'*******************************************$'

MSG1	DB	0DH,0AH
	DB	'        Are you ready? (Press Y or N) $'

MSG2	DB	0DH,0AH,0DH,0AH
	DB	' Enter 3 numbers. EX)123',0DH,0AH,'$'

INNING	DB	'1'
MSG4	DB	' inning input : $'										;50

BYE_	DB	0DH,0AH,0DH,0AH
	DB	'           Good Bye see you next! $'

MSG5	DB	'               [Strike = '
SCOUNT	DB	'0'
MSG6	DB	']',0DH,0AH
	DB	'               [Ball   = '
BCOUNT	DB	'0'
MSG7	DB	']',0DH,0AH										;60
	DB	'               [Out    = '
OCOUNT	DB	'0'
MSG8	DB	']',0DH,0AH,'$'

SUCCESS	DB	0DH,0AH
	DB	'            CONGRATULATION! YOU WIN!',0DH,0AH
	DB	'	    RE GAME? (Y OR N) -> $'

FAIL_	DB	0DH,0AH
	DB	'             YOU LOSE!',0DH,0AH								;70
	DB	'	The answer is [$'

RETRY	DB	']',0DH,0AH
	DB	'	   TRY AGEIN? (Y OR N) -> $'

ERROR_	DB	0DH,0AH
	DB	'       ERROR! Please typing Y or N!',0DH,0AH,'$'

ERROR1_	DB	0DH,0AH
	DB	'       Please enter number only!',0DH,0AH,'$'							;80

ERROR2_	DB	0DH,0AH
	DB	' ERROR! SAME NUMBERS CANNOT!',0DH,0AH,0DH,0AH,'$'

MSG9	DB	0DH,0AH
	DB	' Do you know this game rules? (Y or N) -> $'

MSG10	DB	0DH,0AH
	DB	'    Do you want to Quit? (Y or N) -> $'
													;90
RAND_	DB	3	DUP	(0)
INPUT_	DB	3	DUP	(0)

.CODE
MAIN	PROC
	MOV	AX,@DATA
	MOV	DS,AX
	MOV	AH,9
	LEA	DX,MSG
	INT	21H		;게임 시작내용 출력							;100

@LETS_:
	LEA	DX,MSG9
	INT	21H		;게임 룰 아는지 여부 출력
	MOV	AH,1
	INT	21H		;Y 또는 N 입력

	CMP	AL,'Y'
	JE	@STARTMSG_
	CMP	AL,'y'											;110
	JE	@STARTMSG_	;Y : STARTMSG_ 이동한다
	CMP	AL,'N'
	JE	@RULEMSG_
	CMP	AL,'n'
	JE	@RULEMSG_	;N : RULEMSG_ 이동한다

	LEA	DX,ERROR_	;잘못 입력된 경우 에러를 출력한다
	MOV	AH,9
	INT	21H
	JMP	@LETS_		;다시 입력하겠금 돌아간다							;120

@RULEMSG_:			;룰을 모른다고 입력한 경우
	LEA	DX,RULE
	MOV	AH,9		
	INT	21H		;룰의 내용을 출력한다

@STARTMSG_:
	MOV	AH,9		
	LEA	DX,MSG1
	INT	21H		;시작 준비 내용을 출력한다							;130

@TOP_:
	MOV	AH,1
	INT	21H		;Y 또는 N 입력

	MOV	INNING,'1'	;게임 초기셋팅을 한다
	MOV	CX,9

	CMP	AL,'Y'
	JE	@START_											;140
	CMP	AL, 'y'
	JE	@START_		;Y : START_ 이동한다
	CMP	AL,'N'
	JE	@ENDJUMP_
	CMP	AL,'n'
	JE	@ENDJUMP_	;N : ENDJUMP_ 이동한다

	MOV	AH,9
	LEA	DX,ERROR_
	INT	21H		;잘못된 입력 에러를 출력한다							;150

	LEA	DX,MSG1
	INT	21H		;시작 준비 내용을 출력한다
	JMP	@TOP_		;다시 TOP으로 가서 입력을 받는다


;게임 시작

@START_:
	CALL	MAKESEED	;난수발생을 위한 값을 BX에 넣는다						;160
	XOR	SI,SI		;SI를 0으로 초기화
	CALL	RAND		;랜덤수 하나를 반환한다 -> AL에 저장, RAND_[0]에 저장
	INC	SI		;SI ++, 다음위치로 이동시킨다
@RANDMAKE:
	CALL	RAND		;새로운 난수를 반환한다 -> AL에 저장, RAND_[1]에 저장
	MOV	DL,RAND_[SI]	
	CMP	DL,RAND_[SI-1]	;[0]과 같은 숫자인지를 비교한다
	JE	@RANDMAKE	;같은 경우 다시 난수를 구한다

	INC	SI		;다른경우 정상적으로 저장이 완료된 후, SI++, 다음 위치로 이동시킨다		;170
@RANDMAKE1:
	CALL	RAND		;마지막 난수를 반환한다 -> AL에 저장, RAND_[2]에 저장
	MOV	DL,RAND_[SI]
	CMP	DL,RAND_[SI-2]	;[0]과 같은 숫자인지를 비교한다
	JE	@RANDMAKE1	;같은 경우 다시 난수를 구한다
	CMP	DL,RAND_[SI-1]	;[1]과 같은 숫자인지를 비교한다
	JE	@RANDMAKE1	;같은 경우 다시 난수를 구한다

;정상적으로 세가지 난수가 구해진 경우
													;180
	XOR	SI,SI		;SI = 0
	JMP	@DAP_		;DAP_으로 이동한다

@ENDJUMP_:			;시작준비 N 입력 경우
	JMP	@ENDJUMP_1	;다시 점프

@OUTQ:				;종료여부 확인하는 곳
	POP	CX

	LEA	DX,MSG10										;190
	MOV	AH,9
	INT	21H		;종료 여부 내용을 출력한다
	MOV	AH,1
	INT	21H		;입력 한다
	CMP	AL,'Y'
	JE	@ENDJUMP_
	CMP	AL,'y'
	JE	@ENDJUMP_	;Y 입력시 ENDJUMP_로 이동한다
	CMP	AL,'N'
	JE	@DAP_											;200
	CMP	AL,'n'
	JE	@DAP_		;N 입력시 DAP_ 로 이동한다

	MOV	AH,9
	LEA	DX,ERROR_
	INT	21H		;다른걸 입력시 에러를 출력한다
	JMP	@OUTQ		;다시 출력한다

;숫자 3개 입력하는 곳
													;210
@DAP_:
	LEA	DX,MSG2	
	MOV	AH,9
	INT	21H		;3가지 숫자를 입력하라는 내용을 출력한다
	XOR	SI,SI		;SI = 0 초기화 시킨다

@GOGO_:			;게임 초기화 영역
	PUSH	CX
	MOV	SCOUNT,'0'	;스트라이크 개수 초기화
	MOV	BCOUNT,'0'	;볼 개수 초기화								;220
	MOV	OCOUNT,'0'	;아웃 개수 초기화

	MOV	CX,3		;세번의 입력으로 세팅한다
	LEA	DX,INNING
	INT	21H		;현재 이닝을 출력한다

@WHILE_1:
	MOV	AH,1
	INT	21H		;입력을 받는다
	CMP	AL,1BH		;ESC 키와 비교한다
	JE	@OUTQ		;ESC와 같은 경우 OUTQ로 이동한다

	CMP	AL,'9'		;A보다 크거나 같은경우
	JG	@ERROR_	;ERROR로 이동한다
	CMP	AL,'0'
	JL	@ERROR_	;?

;숫자 들어왔을 때

	SUB	AL,30H		;숫자로 변경한다
	MOV	INPUT_[SI],AL	;저장한다
	INC	SI		;다음 위치로 옮긴다
	LOOP	@WHILE_1	;총 3번 반복한다

;입력 종료

	XOR	SI,SI		;SI를 0으로 초기화 한다
	MOV	AL,INPUT_[SI]
	CMP	AL,INPUT_[SI+1]	;[0]과 [1]을 비교한다
	JE	@ERROR_2	;같은경우 ERROR_2로 이동한다
	CMP	AL,INPUT_[SI+2]	;[0]과 [2]를 비교한다
	JE	@ERROR_2	;같은 경우 ERROR_2로 이동한다

;서로다른 숫자가 들어온 경우

	INC	INNING		;이닝수를 증가시킨다
	MOV	CX,3		;세 숫자 비교를 위해 3을 저장한다

@STRIKE_CHK:
	MOV	AL,RAND_[SI]	
	CMP	AL,INPUT_[SI]	;난수[0]과 입력[0]을 비교한다
	JE	@SCOUNT_	;같은경우 : SCOUNT로 이동한다
	INC	SI		;다음 위치로 이동
	LOOP	@STRIKE_CHK	;3 숫자를 다 확인한다

@STRIKE_GO:
	XOR	SI,SI
	MOV	AL,INPUT_[SI]	;AL에 입력[0]을 넣는다
	MOV	CX,2
	JMP	@BALL_CHK1	;BALL_CHK1로 이동한다

@ERROR_:				;숫자 아닌 값이 입력된 경우
	LEA	DX,ERROR1_
	MOV	AH,9
	INT	21H			;숫자만 입력해야 한다는 내용을 출력한다
	POP	CX
	JMP	@GOGO_			;다시 GOGO

@ERROR_2:				;동일 숫자를 입력한 경우
	LEA	DX,ERROR2_
	MOV	AH,9	
	INT	21H			;같은 숫자를 입력할 수 없다고 출력한다
	POP	CX
	JMP	@GOGO_			;다시 GOGO

@ENDJUMP_1:				;종료위한 임시점프위치
	JMP	@ENDJUMP_2

@END_WHILE:				;스트라이크 3개인 경우
	LEA	DX,SUCCESS		
	MOV	AH,9
	INT	21H			;성공 내용을 출력한다
	JMP	@TOP_			;TOP으로 이동한다

@SCOUNT_:				;난수[]와 입력[]이 일치한 경우
	INC	SCOUNT			;스트라이크 수를 증가시킨다
	INC	SI			;다음 위치로 이동한다

	CMP	SCOUNT,'3'		
	JE	@END_WHILE		;만약 스트라이크가 3이면 END_WHILE로 이동한다
	LOOP	@STRIKE_CHK		;다음수를 스트라이크 확인하기 위해 이동한다
	JMP	@STRIKE_GO		;3번이 끝난 경우 다음 메소드인 STRIKE_GO로 이동한다

@GOGO_1:
	JMP	@GOGO_
@GOTOP_1:
	JMP	@TOP_
@UPTO_:
	JMP	@WHILE_1

;볼 체크하는 곳

@BALL_CHK1:
	CMP	RAND_[SI+1],AL		;입력[0]과 난수[1], 입력[0]과 난수[2]
	JE	@BCOUNT_1		;같은경우 BCOUNT_1 이동한다
@BALL_1:				;볼 카운트 업데이트 후
	INC	SI			;다음 위치로 옮긴다
	LOOP	@BALL_CHK1


	XOR	SI,SI			;볼 카운트1이 끝난후 SI = 0 초기화 한다
	MOV	AL,INPUT_[SI+1]		;비교값을 입력[1]로 맞춘다
	MOV	CX,2
@BALL_CHK2:
	CMP	RAND_[SI],AL		;입력[1]과 난수[0], 입력[1]와 난수[2]을 비교한다
	JE	@BCOUNT_2		;같은경우 BCOUNT_2로 이동한다
@BALL_2:
	ADD	SI,2			;SI를 0 -> 2로 옮긴다
	LOOP	@BALL_CHK2


	XOR	SI,SI			;볼 카운트2이 끝난 후 SI = 0 초기화 한다
	MOV	AL,INPUT_[SI+2]		;비교값을 입력[2]로 맞춘다
	MOV	CX,2
@BALL_CHK3:
	CMP	RAND_[SI],AL		;입력[2]와 난수[0], 입력[2]와 난수[1]을 비교한다
	JE	@BCOUNT_3		;같은경우 BCOUNT_3로 이동한다
@BALL_3:
	INC	SI
	LOOP	@BALL_CHK3

;볼 카운트가 끝난 경우

	JMP	@OUT_CHK		;볼카운트 후 OUT_CHK로 이동한다

@GOGO_2:
	JMP	@GOGO_1
@GOTOP_2:
	JMP	@GOTOP_1
@ENDJUMP_2:
	JMP	@BYE_

@BCOUNT_1:				;입력[0], 난수[1],[2] 볼이 맞는 경우
	INC	BCOUNT			;개수를 증가시킨다
	JMP	@BALL_1			;다시 BALL_1으로 이동한다

@BCOUNT_2:				;입력[1], 난수[0],[2] 볼이 맞는 경우
	INC	BCOUNT			;개수를 증가시킨다
	JMP	@BALL_2			;다시 BALL_2로 이동한다

@BCOUNT_3:				;입력[2], 난수[0],[1] 볼이 맞는 경우
	INC	BCOUNT			;개수를 증가시킨다
	JMP	@BALL_3			;다시 BALL_3로 이동한다

;볼 카운트가 끝난 후 오는 곳

@OUT_CHK:
	MOV	DL,'3'
	SUB	DL,SCOUNT		
	ADD	DL,30H
	SUB	DL,BCOUNT
	ADD	DL,30H
	MOV	OCOUNT,DL		;OUTCOUNT 개수를 3 - 스크라이크, 볼로 계산한다

;아웃카운트 까지 계산이 끝난 경우

@END_:
	POP	CX			;이전 CX값을 스택에서 다시 가져온다 : 이닝 수를 가져오는 것
	MOV	AH,2
	MOV	DL,0DH			
	INT	21H
	MOV	DL,0AH
	INT	21H

	MOV	AH,9
	LEA	DX,MSG5			
	INT	21H			;스크라이크 숫자부터 차례로 출력한다

	XOR	SI,SI			;SI = 0 초기화 한다
	LOOP	@GOGO_2		;GOGO_2 -> GOGO_1 -> GOGO_으로 이동한다

@FIN_:					;만약 10번중 성공을 못한 경우
	MOV	AH,9			
	LEA	DX,FAIL_
	INT	21H			;실패라는 내용을 출력한다
	MOV	CX,3
@ANSWER:
	MOV	AH,2
	MOV	DL,RAND_[SI]
	ADD	DL,30H
	MOV	AH,2			
	INT	21H			;각 난수를 출력한다
	INC	SI			;다음 난수로 이동한다
	LOOP	@ANSWER

@FINQ:					;게임이 실패로 끝난 후
	MOV	AH,9
	LEA	DX,RETRY
	INT	21H			;다시 게임할지를 묻는다
	MOV	AH,1
	INT	21H
	CMP	AL,'Y'
	JE	@GOTOP_2
	CMP	AL,'y'
	JE	@GOTOP_2		;Y 입력된 경우 GOTOP_2 -> GOTOP_1 -> TOP_로 이동한다
	CMP	AL,'N'
	JE	@BYE_
	CMP	AL,'n'
	JE	@BYE_			;N 입력된 경우 BYE_로 이동한다

	MOV	AH,9
	LEA	DX,ERROR_
	INT	21H			;그 외의 입력이 입력된 경우 에러를 출력하낟
	JMP	@FINQ			;다시 묻고 입력을 받는다

@BYE_:					;게임 종료한다고 한 경우
	MOV	AH,9
	LEA	DX,BYE_
	INT	21H			;게임종료 문장을 출력한다
	MOV	AH,4CH
	INT	21H
MAIN	ENDP




MAKESEED	PROC
	PUSH	DS

	MOV	AX,0
	MOV	DS,AX	;AX,DX : 0으로 초기화
	MOV	SI,46CH	;타이머 값을 SI에 넣는다
	MOV	AX,[SI]

	POP	DS
	MOV	BX,AX	;난수발생을 위한 값을 BX에 넣는다
	RET
MAKESEED	ENDP




RAND	PROC
	PUSH	CX
	MOV	AX,BX	;난수씨앗을 AX로 옮긴다
@R_LP:
	MUL	BX	;씨앗 * 씨앗
	MOV	CL,4	
	SHR	AX,CL	;난수값 -> 오른쪽으로 4비트 이동
	MOV	BX,AX	;난수값 -> AX저장
	MOV	DX,BX	;난수값 -> DX저장
	MOV	CL,4	
	SHR	DX,CL	;난수값 -> 오른쪽으로 4비트 이동
	ADD	BX,DX	
	AND	AX,000FH
	CMP	AL,8	;AL값을 8과 비교한 뒤 (1000)
	JA	@R_LP	;8보다 크면 다시 난수끼리 곱한다

	POP	CX
	INC	AL	;AL ++ 한다 (최대 9로)
	MOV	RAND_[SI],AL	;RAND_[0]에 값을 넣는다
	RET
RAND	ENDP

	END	MAIN