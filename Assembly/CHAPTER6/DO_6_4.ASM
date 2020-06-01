.MODEL	SMALL
.STACK	100H
.CODE
MAIN	PROC
	MOV	AH,2
	MOV	DL,'?'
	INT	21H

	MOV	CX,0	;초기화

	MOV	AH,1
	INT	21H
	SUB	AL,30H
	MOV	CL,AL	;CL에 저장한다
	MOV	BL,0	;합 초기화
@TOP:
	ADD	BL,CL	;N부터 차례로 더하기 시작
	LOOP	@TOP	;CX가 0이지만 CL이 값이있으니 CX가 값 있는듯
	;반복탈출

	;왜 예제엔 출력문이 없지? 그래서 추가를 해봤습니다.
	MOV	AH,2
	MOV	DL,0DH
	INT	21H
	MOV	DL,0AH
	INT	21H
	ADD	BL,30H
	MOV	DL,BL
	INT	21H

	MOV	AH,4CH
	INT	21H
MAIN	ENDP
	END	MAIN