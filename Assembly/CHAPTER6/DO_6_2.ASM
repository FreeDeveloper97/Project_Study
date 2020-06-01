.MODEL	SMALL
.STACK	100H
.CODE
MAIN	PROC
	MOV	AH,2
	MOV	DL,'?'
	INT	21H

	MOV	BL,0	;소문자개수 초기화
	
	MOV	AH,1
	INT	21H
@WHILE:
	;엔터키인지 (반복문 종료조건) 판별
	CMP	AL,0DH
	JE	@END_WHILE

	;소문자인지 판별
	CMP	AL,'a'
	JL	@END_IF
	CMP	AL,'z'
	JG	@END_IF
	INC	BL	;소문자개수 증가
@END_IF:
	;새로운 문자를 받고 반복시작
	INT	21H
	JMP	@WHILE
@END_WHILE:
	;반복문 종료시 출력준비
	MOV	AH,2
	MOV	DL,0DH
	INT	21H
	MOV	DL,0AH
	INT	21H
	
	ADD	BL,30H	;아스키코드 변환
	MOV	DL,BL
	INT	21H

	MOV	AH,4CH
	INT	21H
MAIN	ENDP
	END	MAIN