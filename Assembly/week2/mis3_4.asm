.MODEL	SMALL
.STACK	100H
.DATA
IN_MSG		DB	'Enter an upper case letter : $'
OUT_MSG	DB	0DH,0AH,'The upper and lower case letters : '
UCHAR		DB	?,' '
LCHAR		DB	?,'$'

.CODE
MAIN	PROC
;한 대문자를 입력 받고 입력 받은 대문자와 소문자를 모두 출력하는 프로그램을 작성하라.
	MOV	AX,@DATA
	MOV	DS,AX

	LEA	DX,IN_MSG	;??
	MOV	AH,9
	INT	21H

	MOV	AH,1
	INT	21H

	MOV	UCHAR,AL	;AL -> UCHAR
	ADD	AL,20H
	MOV	LCHAR,AL	;AL + 20H = Small -> LCHAR

	LEA	DX,OUT_MSG
	MOV	AH,9
	INT	21H

	MOV	AH,4CH
	INT	21H
MAIN	ENDP
	END	MAIN
