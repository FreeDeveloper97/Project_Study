.MODEL	SMALL
.STACK	100H
.CODE
MAIN	PROC

	MOV	AH,2
	MOV	DL,'?'
	INT	21H

	MOV	BL,0	;개수 초기화
	MOV	BH,0	;문자여부 판별값

	MOV	AH,1
	INT	21H
@WHILE:
	CMP	AL,0DH
	JE	@END_WHILE	;엔터 -> END_WHILE
	CMP	AL,' '
	JNE	@SET_FLAG	;문자 -> SET_FLAG

	;스페이스바 인경우
	CMP	BH,0		;문자 입력됬었는지 확인
	JE	@NO_COUNT	;문자없이 스페이스바 -> 다음입력
	INC	BL		;문자있었던 경우 -> 개수1UP
	JMP	@NO_COUNT	;-> 다음문자입력

@SET_FLAG:
	CMP	BH,1		;문자 있었던지 여부 판별
	JE	@NO_COUNT	;있었던경우 -> 다음입력
	MOV	BH,1		;첫문자인경우 -> 문자여부1로 변경 
@NO_COUNT:
	INT	21H		;다음 입력
	JMP	@WHILE
@END_WHILE:
	CMP	BH,0
	JE	@OUTPUT	;첫문자가 엔터일경우 개수증가X
	INC	BL		;마지막 숫자 증가
@OUTPUT:
	MOV	AH,2
	MOV	DL,0DH
	INT	21H
	MOV	DL,0AH
	INT	21H
	
	ADD	BL,30H		;변환
	MOV	DL,BL
	INT	21H

	MOV	AH,4CH
	INT	21H
MAIN	ENDP
	END	MAIN