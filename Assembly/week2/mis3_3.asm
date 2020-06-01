.MODEL	SMALL
.STACK	100H
.CODE
MAIN	PROC
;세 개의 대문자를 입력 받고 입력 받은 순서의 반대로 출력하는 프로그램을 작성하라.
	MOV	AH,2
	MOV	DL,'?'
	INT	21H

	MOV	AH,1
	INT	21H
	MOV	BL,AL	;1 -> BL

	INT	21H
	MOV	BH,AL	;2 -> BH

	INT	21H
	MOV	CL,AL	;3 -> CL

	MOV	AH,2
	MOV	DL,0DH
	INT	21H
	MOV	DL,0AH
	INT	21H

	MOV	DL,CL	;CL
	INT	21H

	MOV	DL,BH	;BH
	INT	21H

	MOV	DL,BL	;BL
	INT	21H

	MOV	AH,4CH
	INT	21H
MAIN	ENDP
	END	MAIN