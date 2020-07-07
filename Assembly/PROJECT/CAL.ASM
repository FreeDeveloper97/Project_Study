.MODEL	SMALL
.STACK	100H
.DATA
TITLE0	DB	'****************************************',0AH,0DH
	DB	'          Assembler Calculator',0AH,0DH
	DB	' Maker : INHA COM 12171571 Kang Minsang',0AH,0DH
	DB	'****************************************',0AH,0DH,'$'

TITLE1	DB	'               Operator',0AH,0DH
	DB	'****************************************',0AH,0DH,'$'

TITLE2	DB	' (ex) 23+34*21-13/2=',0AH,0DH
	DB	'----------------------------------------',0AH,0DH,'$'

TITLE3	DB	' 23+34		... 57	',0AH,0DH,'$'
TITLE4	DB	' 57*21		... 1197	',0AH,0DH,'$'
TITLE5	DB	' 119-13		... 106	',0AH,0DH,'$'
TITLE6	DB	' 184/2		... 92	',0AH,0DH
	DB	'----------------------------------------',0AH,0DH,'$'

TITLE7	DB	' Please Press =',0AH,0DH
	DB	'----------------------------------------',0AH,0DH,0AH,0DH
	DB	'-> $'

ERR0	DB	0DH,0AH,' Your Input Operator is not +, -, *, /. OPERATOR ERROR.$'
ERR1	DB	0DH,0AH,' Your Input Number is Over 128. OverFlow ERROR.$'

PREV	DB	' '	;이전 연산자 저장
POST	DB	' '	;숫자 입력 후 입력된 연산자 저장

TEN	DW	10	;10으로 나누는 수
FIRST	DB	0	;첫 입력인지 아닌지 판별, 두번째 숫자입력시 2로 변경되어 있다

.CODE
MAIN	PROC
	MOV	AX,@DATA
	MOV	DS,AX

;START PRINT

	MOV	AH,9
	LEA	DX,TITLE0
	INT	21H

	LEA	DX,TITLE1
	INT	21H

	LEA	DX,TITLE2
	INT	21H

	LEA	DX,TITLE3
	INT	21H

	LEA	DX,TITLE4
	INT	21H

	LEA	DX,TITLE5
	INT	21H

	LEA	DX,TITLE6
	INT	21H

	LEA	DX,TITLE7
	INT	21H


	XOR	CX,CX
@WHILE_ST:

	CALL	READ_N		;숫자를 입력 받는다 : 숫자 : AX에 저장, 사칙연산 : POST에 저장

	CMP	AX,128		;입력된 값 128과 비교한다
	JL	@FIR		;작은 경우 FIR로 이동(정상경우)
	JMP	@OVER		;큰 경우 오버플러우 이므로 OVER로 이동

@FIR:				;정상적인 숫자가 입력된 경우
	CMP	FIRST,0		;초기상태인지 판별

	JNE	@CONTINUE	;초기상태가 아닌 경우 CONTINUE로 이동한다

	MOV	FIRST,2		;초기상태인 경우 FIRST를 2로 바꾼다
	JMP	@SKIP		;그리고서 SKIP으로 이동한다

@OVER:				;128 이상의 숫자를 입력한 경우
	MOV	AH,9
	LEA	DX,ERR1
	INT	21H
	JMP	@QUIT		;에러 문구를 출력 후 QUIT으로 이동한다



@CONTINUE:			;두번째 숫자 이상이 입력된 경우 (이전값 : CX, 이전 연산자 : PREV, 이후값 : AX, 이후 연산자 : POST)

	MOV	BX,AX		;두번째 숫자 -> BX
	MOV	AX,CX		;첫번째 숫자 -> AX

	CALL	OPER		;AX, PREV, BX, POST 지니고서 OPER 부른다
				;정상의 경우 AX에 연산값이 저장, 연산자 오류의 경우 PREV에 @저장, 오류 출력상태

	CMP	PREV,'@'		;연산자 오류 판별
	JNE	@SKIP		;정상의 경우 SKIP으로 넘어간다

	JMP	@QUIT		;연산자 오류의 경우 QUIT으로 이동한다

@SKIP:				;연산종료, AX에 연산값 저장, POST에 연산자 저장되어 있는 상태
	MOV	DL,POST
	MOV	PREV,DL		;처음 입력된 사칙연산을 PREV로 옮긴다

	CMP	POST,'='		;처음 입력된 사칙연산이 = 인지 확인

	JNE	@WHILE_END	;=이 아닌경우(정상의 경우) WHILE_END이동 (최종값은 AX에 저장되어 있는 상태)
	JMP	@EXIT		;=이 입력된 경우 EXIT으로 이동

@WHILE_END:			;정상 숫자, 정상 사칙연산이 입력된 경우
	MOV	CX,AX		;입력된 숫자를 CX로 옯긴다

	JMP	@WHILE_ST	;다시 입력을 반복한다

@EXIT:				;정상 종료가 이뤄지는 경우
	XOR	CX,CX		;CX를 0으로 초기화한다
@DECIMAL:
	XOR	DX,DX
	DIV	TEN		;연산된 값을 10으로 나눈다?

	PUSH	DX		;나머지 스택에 저장
	INC	CX		;출력할 자리수 저장한다

	CMP	AX,0000H		;나눈 몫을 0과 바교한다
	JNE	@DECIMAL	;몫이 0이 아닌경우 DECIMAL로 이동한다 (또 나누기 -> 나머지 스택에 넣기)

	MOV	AH,2		;몫이 0인 경우 출력상태로 맞춘다
@POPDEC:
	POP	DX
	ADD	DX,30H
	INT	21H
	LOOP	@POPDEC	;하나하나 불러와 출력한다
@QUIT:
	MOV	AH,4CH
	INT	21H		;종료한다

MAIN	ENDP






READ_N	PROC				;숫자 : N1을 먼저 거친다(2자리의 경우 N1 두번 거친다) -> BX에 값이 저장된다
					;그 뒤에 연산자가 입력되면 N2로 넘어간다.
	PUSH	BX
	PUSH	CX			;이전에 입력됬던 값이 있는경우 CX에 저장되어 있다

	MOV	CX,10D			;CX에 10을 넣는다
	XOR	BX,BX			;BX에 0을 넣는다
@READ_N1:
	MOV	AH,1
	INT	21H			;한문자를 입력받는다

	CMP	AL,'0'
	JB	@READ_N2		;0보다 작은 숫자의 경우 N2로 넘어간다 (사칙연산도 포함)
	CMP	AL,'9'
	JA	@READ_N2		;9보다 큰 숫자의 경우 N2로 넘어간다

;정상적인 0~9 사이의 수가 입력된 경우

	SUB	AL,'0'			;입력된 문자를 숫자로 변경한다
	PUSH	AX			;스택에 넣는다

	MOV	AX,BX			;이전에 저장되어 있던 BX를 AX에 넣는다
	MUL	CX			;10을 곱한다 -> 이전에 저장된값 * 10이 된다

	MOV	BX,AX			;2자리 숫자를 다시 BX에 옮긴다
	POP	AX			;현재 입력된 값 다시 가져온다

	XOR	AH,AH			;AH의 값을 0으로 초기화 한다
	ADD	BX,AX			;그래서 결론적으로 두자리 10진수 값이 BX에 저장된다

	JMP	@READ_N1		;다시 입력

@READ_N2:				;사칙연산, 또는 이상한 값 입력시
	MOV	POST,AL			;입력된 것을 POST에 넣는다
	MOV	AX,BX			;입력되어 연산된 값을 AX에 넣는다

	POP	CX			;이전에 입력된 값 다시 가져오기
	POP	BX
	RET
READ_N	ENDP				;결론적으로 입력된 값은 AX에 저장되고, 그 뒤 입력된 연산자는 POST에 저장된다
					;만약 두번째 숫자가 입력된 경우 첫번째 입력되었던 값은 CX에 저장되어 있고, 연산자는 PREV에 저장되어 있다






OPER	PROC				;AX : 이전값, PREV : 이전 연산자, BX : 이후값, POST : 이후 연산자
	CMP	PREV,'*'			;이전 연산자를 가지고서 판별한다
	JNZ	@DIVISION		;곱하기 아닌경우 -> 나누기 이동

	MUL	BL
	JMP	@FINISH
@DIVISION:
	CMP	PREV,'/'
	JNZ	@PLUS			;나누기 아닌경우 -> 더하기 이동

	XOR	DX,DX
	DIV	BX
	JMP	@FINISH
@PLUS:
	CMP	PREV,'+'
	JNZ	@MINUS			;더하기 아닌경우 -> 빼기로 이동

	ADD	AX,BX
	JMP	@FINISH
@MINUS:
	CMP	PREV,'-'
	JNZ	@ERROR			;빼기까지 아닌경우 -> ERROR로 이동

	SUB	AX,BX
	JMP	@FINISH

@ERROR:					;사칙연산 모두 아닌 경우
	MOV	DL,'@'
	MOV	PREV,DL			;PREV에 @를 저장한다
	MOV	AH,9
	LEA	DX,ERR0
	INT	21H			;연산자 입력 오류를 출력한다

@FINISH:					;정상적인 연산 후 AX에 값이 저장되어 있다
	RET
OPER	ENDP

	END	MAIN			;결론 : 정상의 경우 연산 후 AX에 저장, 연산자 오류의 경우 PREV에 @ 저장, 오류 출력