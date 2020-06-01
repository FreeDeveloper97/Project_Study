.MODEL	SMALL
.STACK	100H
.CODE
MAIN	PROC

	MOV	CX,26	;문자개수 초기화
	MOV	BL,0	;출력개수 초기화
	MOV	DL,'A'	;출력문자 초기화
	
	MOV	AH,2
@TOP:
	INT	21H	;출력
	INC	BL	;출력개수 증가
	CMP	BL,7
	JL	@NEXT	;넘기기

	;다음줄로 넘기는 경우
	MOV	DH,DL	;DL사용해야 하므로 옮겨서 저장
	MOV	DL,0DH
	INT	21H
	MOV	DL,0AH
	INT	21H
	MOV	DL,DH	;다시 옮겨서 저장
	MOV	BL,0	;출력개수 초기화
@NEXT:
	INC	DL	;출력문자 증가
	LOOP	@TOP	;자동으로 문자개수 감소, 출력반복

	;반복이 끝난경우
	MOV	AH,4CH
	INT	21H
MAIN	ENDP
	END	MAIN