OUTDECM	PROC
	PUSH	AX
	PUSH	BX
	PUSH	CX
	PUSH	DX

	CMP	AX,0
	JGE	@END_IF	;양수 : END_IF

;음수인 경우
	PUSH	AX
	MOV	DL,'-'
	MOV	AH,2
	INT	21H	;- 출력
	POP	AX
	NEG	AX	;음수 -> 양수

@END_IF:
	XOR	CX,CX
	MOV	BX,10	;나눌수 10 설정

;---- 10진수 출력 알고리즘 시작 (스택에 넣기)----

@FIND_DEC:
	XOR	DX,DX	;워드 나눗셈(몫 16바이트 저장을 위함)
	DIV	BX	;10으로 나눈다
	PUSH	DX	;나머지를 스택에 넣는다

	INC	CX	;숫자개수 센다
	CMP	AX,0	;
	JNE	@FIND_DEC

;----스택에서 꺼내와 출력하기----
	MOV	AH,2
@OUT_LOOP:
	POP	DX
	OR	DL,30H
	INT	21H		;출력!
	LOOP	@OUT_LOOP	;계속 출력

;----10진수 출력 알고리즘 종료----

	POP	DX
	POP	CX
	POP	BX
	POP	AX
	RET

OUTDECM	ENDP