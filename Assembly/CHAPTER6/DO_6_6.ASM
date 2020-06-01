.MODEL	SMALL
.STACK	100H
.CODE
MAIN	PROC

	MOV	CX,30	;개수 초기화
	MOV	BX,1	;더하는수 초기화
	MOV	DX,0	;수 차이 초기화
	MOV	AX,0	;합산 초기화

@TOP:
	ADD	AX,BX	;더한다
	INC	DX
	ADD	BX,DX	;더할수 차이만큼 더한다
	LOOP	@TOP

	;종료문이 없어 추가했습니다.
	MOV	AH,4CH
	INT	21H
MAIN	ENDP
	END	MAIN