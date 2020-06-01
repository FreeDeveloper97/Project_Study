INDECM	PROC
	PUSH	BX
	PUSH	CX
	PUSH	DX
	PUSH	SI

@BEGIN:
	XOR	BX,BX
	XOR	CX,CX	;부호
	MOV	AH,1
	INT	21H

	CMP	AL,'-'
	JE	@MINUS
	CMP	AL,'+'
	JE	@PLUS
	JMP	@DO_WHILE

@MINUS:
	MOV	CX,1	;음수
@PLUS:
	INT	21H	;한번더 입력
@DO_WHILE:
	CMP	AL,'0'
	JB	@ERROR
	CMP	AL,'9'
	JA	@ERROR

;----정상 숫자가 들어온경우----

	AND	AX,000FH		;10진수 값으로 변환한다
	MOV	SI,AX		;곱셈을 위해 옮기기
	MOV	AX,10		;곱할수 10 설정

	IMUL	BX		;곱할수 BX와 10 곱하기 -> AX저장
	
	JO	@OVERFLOW	;오버플러우 발생

	MOV	BX,SI		;옮긴값 BX로 가져오기
	ADD	BX,AX		;앞전 수 * 10(BX) + 지금들어온 수(AX) -> BX에 저장
	
	JO	@OVERFLOW	;오버플러우 발생

	MOV	AH,1
	INT	21H		;다시 입력
	CMP	AL,0DH
	JE	@END_WHILE	;종료 조건
	CMP	AL,' '
	JE	@END_WHILE	;종료 조건

	JMP	@DO_WHILE

@END_WHILE:
	MOV	AX,BX		;최종값 AX로 옮기기

;---- 10진수 입력 알고리즘 끝----

	CMP	CX,0
	JE	@EXIT
	NEG	AX
@EXIT:
	POP	SI
	POP	DX
	POP	CX
	POP	BX
	RET			;종료

@OVERFLOW:
	CMP	BX,32768
	JNE	@ERROR		;32768보다 큰 경우 ERROR
	CMP	CX,1
	JNE	@ERROR		;32768인 경우 ERROR
	JMP	@END_WHILE	;-32768인 경우 : 정상 종료
@ERROR:
	MOV	AH,2
	MOV	DL,0DH
	INT	21H
	MOV	DL,0AH
	INT	21H
	JMP	@BEGIN

INDECM	ENDP