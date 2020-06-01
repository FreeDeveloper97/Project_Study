.MODEL	SMALL
.STACK	100H
.CODE
MAIN	PROC
;한 대문자를 입력 받고 입력 받은 대문자의 소문자를 출력하는 프로그램을 작성하라.
	MOV	AH,2
	MOV	DL,'?'
	INT	21H

	MOV	AH,1
	INT	21H

	MOV	BL,AL
	ADD	BL,20H
	
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