.MODEL	SMALL
.STACK	100H
.CODE
MAIN	PROC
;3.5 0~9사이의 수를 입력 받고 입력 받은 수의 10의 보수를 구하여 출력하는 프로그램을 작성하라.
	MOV	AH,2
	MOV	DL,'?'
	INT	21H

	MOV	AH,1
	INT	21H

	MOV	BL,AL

	SUB	BL,30H
	NEG	BL
	ADD	BL,10
	ADD	BL,30H

	MOV	AH,2
	MOV	DL,0DH
	INT	21H
	MOV	DL,0AH
	INT	21H

	MOV	DL,BL
	INT	21H

	MOV	AH,4CH
	INT	21H
MAIN	ENDP
	END	MAIN