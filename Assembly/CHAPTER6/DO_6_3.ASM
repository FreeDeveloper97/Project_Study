.MODEL	SMALL
.STACK	100H
.CODE
MAIN	PROC
	MOV	AH,2
	MOV	DL,'?'
	INT	21H

	MOV	BL,0	;카운터 초기화
	MOV	AH,1
	INT	21H	;첫번째 입력
@WHILE:
	CMP	AL,0DH
	JE	@END_WHILE	;엔터 입력시 반복문 종료

	;문자인지 아닌지 판별
	CMP	AL,'A'
	JL	@COUNT		;1UP
	CMP	AL,'Z'
	JLE	@END_IF
	CMP	AL,'a'
	JL	@COUNT		;1UP
	CMP	AL,'z'
	JLE	@END_IF
@COUNT:
	INC	BL		;1UP
@END_IF:
	;다시 입력을 받는다
	INT	21H
	JMP	@WHILE
@END_WHILE:
	;반복을 종료하고 출력한다
	MOV	AH,2
	MOV	DL,0DH
	INT	21H
	MOV	DL,0AH
	INT	21H

	ADD	BL,30H		;아스키코드 변환
	MOV	DL,BL
	INT	21H

	MOV	AH,4CH
	INT	21H
MAIN	ENDP	
	END	MAIN