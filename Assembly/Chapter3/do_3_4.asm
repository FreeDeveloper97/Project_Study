.MODEL	SMALL
.STACK	100H
.DATA
	FIRST	DB	'Enter an upper case letter : $'
	SECOND	DB	0DH,0AH,'The upper and lower case letters : '
	UPPER	DB	?,' '
	LOWER	DB	?,'$'
.CODE
MAIN	PROC
;3.4 한 대문자를 입력 받고 입력 받은 대문자와 소문자를 모두 출력하는 프로그램을 작성하라.

	MOV	AX,@DATA
	MOV	DS,AX

	MOV	AH,9
	LEA	DX,FIRST
	INT	21H
	
	MOV	AH,1
	INT	21H
	MOV	UPPER,AL

	MOV	LOWER,AL
	ADD	LOWER,20H

	MOV	AH,9
	LEA	DX,SECOND
	INT	21H

	MOV	AH,4CH
	INT	21H
MAIN	ENDP
	END	MAIN
	